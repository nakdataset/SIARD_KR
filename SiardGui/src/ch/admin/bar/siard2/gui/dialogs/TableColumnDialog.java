/*
 * ====================================================================== HistoryDialog displays
 * meta data of the program. Application : Siard2 Description : InfoDialog displays meta data of the
 * program. Platform : Java 7, JavaFX 2.2
 * ------------------------------------------------------------------------ Copyright : 2017, Enter
 * AG, Rüti ZH, Switzerland Created : 12.01.2017, Hartwig Thomas
 * ======================================================================
 */
package ch.admin.bar.siard2.gui.dialogs;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ch.admin.bar.siard2.api.primary.FileDownloadModel;
import ch.admin.bar.siard2.cmd.SFTPConnection;
import ch.admin.bar.siard2.cmd.SiardConnection;
import ch.admin.bar.siard2.gui.SiardBundle;
import ch.admin.bar.siard2.gui.models.ColumnModel;
import ch.admin.bar.siard2.gui.models.TableModel;
import ch.enterag.utils.fx.FxSizes;
import ch.enterag.utils.fx.FxStyles;
import ch.enterag.utils.fx.ScrollableDialog;
import ch.enterag.utils.fx.dialogs.FS;
import ch.enterag.utils.fx.dialogs.MB;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.Clipboard;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

/* ==================================================================== */
/**
 * HistoryDialog displays meta data of the program.
 *
 * @author Hartwig Thomas
 */
public class TableColumnDialog extends ScrollableDialog implements EventHandler<ActionEvent> {

	private static final Logger LOG = Logger.getLogger(TableColumnDialog.class);

	public static final int iRESULT_CANCELED = 0;
	public static final int iRESULT_SUCCESS = 1;
	protected int _iResult = iRESULT_CANCELED;
	public int getResult() { return _iResult; }

	protected TableModel tableModel;
	protected FileDownloadModel fileDownloadModel;

	private TableView<ColumnModel> _tvColumnList;

	private Button _btnDefault;
	private Button _btnCancel;

	private RadioButton _rbSFTP;
	private RadioButton _rbFileCopy;

	private VBox _vboxSFTPConnection;
	private TextField _tfSFTPHost;
	private TextField _tfSFTPPort;
	private TextField _tfSFTPUser;
	private PasswordField _tfSFTPPassword;

//	private VBox _vboxFileCopy;
//	private Label _lblSourceFilePath;
	private Button _btnSourceFileBrowser;
	private PastingTextField _tfSourceFilePath;

	private Button _btnTargetFileBrowser;
	private PastingTextField _tfTargetFilePath;

	private TableColumnDialog(Stage stageOwner, TableModel tableModel, FileDownloadModel beforfileDownloadModel) {
		super(stageOwner, SiardBundle.getSiardBundle().getTableColumnTitle(tableModel.getSchemaName(), tableModel.getTableName()));

		this.tableModel = tableModel;

		double dMinWidth = FxSizes.getTextWidth(SiardBundle.getSiardBundle().getTableColumnTitle(tableModel.getSchemaName(), tableModel.getTableName())) + FxSizes.getCloseWidth() + dHSPACING;

		VBox vboxDialog = createVBoxDialog();

		if (dMinWidth < vboxDialog.getMinWidth()) {
			dMinWidth = vboxDialog.getMinWidth();
		}

		//20200904 - 이전 파일다운로드모델 연동 추가 by.pks
		if(beforfileDownloadModel != null) {
			setColumnListByBeforeChooseColumn(beforfileDownloadModel);
		}

		setMinWidth(dMinWidth);

		/* scene */
		Scene scene = new Scene(vboxDialog);
		setScene(scene);
	}

	/*------------------------------------------------------------------*/
	/**
	 * close dialog when the OK button is pressed.
	 */
	@Override
	public void handle(ActionEvent event) {
		SiardBundle sb = SiardBundle.getSiardBundle();

		if (event.getSource() == _btnCancel) {
			close();

		// OK
		} else if (event.getSource() == _btnDefault) {

			try {

				if(_rbSFTP.isSelected()) {
					//TODO SFTP Connection Validation
					FileDownloadModel model = new FileDownloadModel();
					model.setHost(_tfSFTPHost.getText());
					model.setUser(_tfSFTPUser.getText());
					model.setPassword(_tfSFTPPassword.getText());
					model.setPort(Integer.parseInt("".equals(_tfSFTPPort.getText().trim())  ? "0" : _tfSFTPPort.getText()));

					SFTPConnection sftpConnection = new SFTPConnection(_tfSFTPHost.getText(), _tfSFTPUser.getText(), _tfSFTPPassword.getText(), Integer.parseInt("".equals(_tfSFTPPort.getText().trim())  ? "0" : _tfSFTPPort.getText()));
					sftpConnection.initSFTPConnection(model);
				}

				setColumnListByChooseColumn();

				_iResult = iRESULT_SUCCESS;

				close();
			}catch(Exception e) {
				MB.show(this,
					sb.getConnectionErrorTitle(),
					"SFTP access information is incorrect.",
					sb.getOk(), null);
			}


		} else if (event.getSource() == _btnTargetFileBrowser) {

			File fileDbFolder = null;
			try {
				fileDbFolder = FS.chooseExistingFolder(TableColumnDialog.this,
					sb.getConnectionDbFolderTitle(), sb.getConnectionDbFolderMessage(), sb,
					fileDbFolder);
				if (fileDbFolder != null) {
					_tfTargetFilePath.setText(fileDbFolder.getAbsolutePath());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (event.getSource() == _btnSourceFileBrowser) {

			File fileDbFolder = null;
			try {
				fileDbFolder = FS.chooseExistingFolder(TableColumnDialog.this,
					sb.getConnectionDbFolderTitle(), sb.getConnectionDbFolderMessage(), sb,
					fileDbFolder);
				if (fileDbFolder != null) {

					_tfSourceFilePath.setText(fileDbFolder.getAbsolutePath());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	} /* handle */

	public void setColumnListByChooseColumn() {
		int size = _tvColumnList.getItems().size();
		List<FileDownloadModel> chooseColumnList = new ArrayList<FileDownloadModel>();

		for (int i = 0; i < size; i++) {
			if (_tvColumnList.getItems().get(i).getChooseColumnFlag()) {
				FileDownloadModel chooseColumnFdm = new FileDownloadModel();
				chooseColumnFdm.setColumnName(_tvColumnList.getItems().get(i).getColumnName());
				chooseColumnFdm.setSourceFileRootPath(_tvColumnList.getItems().get(i).getSourceFileRootPath());
				chooseColumnFdm.setChooseColumnFlag(_tvColumnList.getItems().get(i).getChooseColumnFlag());
				chooseColumnList.add(chooseColumnFdm);
			}
		}

		if (fileDownloadModel == null) {
			fileDownloadModel = new FileDownloadModel();
		}

		fileDownloadModel.setSchemaName(tableModel.getSchemaName());
		fileDownloadModel.setTableName(tableModel.getTableName());

		fileDownloadModel.setSftpFlag(_rbSFTP.isSelected());
		fileDownloadModel.setFileCopyFlag(_rbFileCopy.isSelected());

		fileDownloadModel.setHost(_tfSFTPHost.getText());
		fileDownloadModel.setPort(Integer.parseInt("".equals(_tfSFTPPort.getText().trim())  ? "0" : _tfSFTPPort.getText()));
		fileDownloadModel.setUser(_tfSFTPUser.getText());
		fileDownloadModel.setPassword(_tfSFTPPassword.getText());

		fileDownloadModel.setTargetFilePath(_tfTargetFilePath.getText());

		fileDownloadModel.setChooseColumnList(chooseColumnList);

	}

	//이전에 입력한 값으로 세팅
	public void setColumnListByBeforeChooseColumn(FileDownloadModel beforfileDownloadModel) {
		int _tvColumnListSize = _tvColumnList.getItems().size();
		int chooseColumnListSize = beforfileDownloadModel.getChooseColumnList().size();

		for (int i = 0; i < _tvColumnListSize; i++) {
			for(int j = 0; j < chooseColumnListSize; j++) {
				if (_tvColumnList.getItems().get(i).getColumnName().equals(beforfileDownloadModel.getChooseColumnList().get(j).getColumnName())) {
					_tvColumnList.getItems().get(i).setSourceFileRootPath(new SimpleStringProperty(beforfileDownloadModel.getChooseColumnList().get(j).getSourceFileRootPath()));
					_tvColumnList.getItems().get(i).setChooseColumnFlag(new SimpleBooleanProperty(beforfileDownloadModel.getChooseColumnList().get(j).isChooseColumnFlag()));
				}
			}
		}

		_rbSFTP.setSelected(beforfileDownloadModel.isSftpFlag());
		_rbFileCopy.setSelected(beforfileDownloadModel.isFileCopyFlag());
		_tfSFTPHost.setText(beforfileDownloadModel.getHost());
		_tfSFTPUser.setText(beforfileDownloadModel.getUser());
		_tfSFTPPassword.setText(beforfileDownloadModel.getPassword());
		_tfSFTPPort.setText(String.valueOf(beforfileDownloadModel.getPort()));
		_tfTargetFilePath.setText(beforfileDownloadModel.getTargetFilePath());
	}

	/*------------------------------------------------------------------*/
	/**
	 * create the main VBox of the dialog
	 *
	 * @return main VBox
	 */
	private VBox createVBoxDialog() {

		/* VBox for title area, separator, credits area, separator and OK button */
		VBox vboxDialog = new VBox();
		vboxDialog.setPadding(new Insets(dOUTER_PADDING));
		vboxDialog.setSpacing(dVSPACING);
		vboxDialog.setStyle(FxStyles.sSTYLE_BACKGROUND_LIGHTGREY);

		double dMinWidth = 0;

		VBox vboxFileConnection = createVBoxFileConnection();
		if (dMinWidth < vboxFileConnection.getMinWidth()) {
			dMinWidth = vboxFileConnection.getMinWidth();
		}
		vboxDialog.getChildren().add(vboxFileConnection);
		VBox.setVgrow(vboxFileConnection, Priority.ALWAYS);

		vboxDialog.getChildren().add(new Separator());

		HBox hBoxTableView = createHBoxTableView();
		if (dMinWidth < hBoxTableView.getMinWidth()) {
			dMinWidth = hBoxTableView.getMinWidth();
		}
		vboxDialog.getChildren().add(hBoxTableView);
		VBox.setVgrow(hBoxTableView, Priority.ALWAYS);

		vboxDialog.getChildren().add(new Separator());

		HBox hboxButton = createHBoxButton();
		if (dMinWidth < hboxButton.getMinWidth()) {
			dMinWidth = hboxButton.getMinWidth();
		}
		vboxDialog.getChildren().add(hboxButton);

		vboxDialog.setMinWidth(dMinWidth);

		return vboxDialog;
	} /* createVBoxDialog */

	private VBox createVBoxFileConnection() {
		SiardBundle sb = SiardBundle.getSiardBundle();

		VBox vbox = new VBox();
		vbox.setPadding(new Insets(dINNER_PADDING));
		vbox.setSpacing(dVSPACING);
		vbox.setAlignment(Pos.TOP_LEFT);

		HBox hboxRadioButton = createHBoxRadioButton();
		vbox.getChildren().add(hboxRadioButton);

		vbox.getChildren().add(new Separator());

		_vboxSFTPConnection = createVBoxSFTPConnection();
		vbox.getChildren().add(_vboxSFTPConnection);

		Label lblSFTPTargetFilePath = createLabel("Target FilePath :", _tfTargetFilePath);
		_tfTargetFilePath = new PastingTextField("");
		_tfTargetFilePath.setText("");

		_btnTargetFileBrowser = new Button(sb.getConnectionDbFolderButton());
		_btnTargetFileBrowser.setAlignment(Pos.BASELINE_RIGHT);
		_btnTargetFileBrowser.setMinWidth(FxSizes.getNodeWidth(_btnTargetFileBrowser));
		_btnTargetFileBrowser.setOnAction(this);

		HBox hboxSFTPTargetFilePath = createHBox(lblSFTPTargetFilePath, _tfTargetFilePath, _btnTargetFileBrowser);
		vbox.getChildren().add(hboxSFTPTargetFilePath);

		getMaxLabelPrefWidth(lblSFTPTargetFilePath);

		return vbox;
	} /* createHBoxFileConnection */

	/*------------------------------------------------------------------*/
	/**
	 * create a label for the given node.
	 *
	 * @param sLabel label text
	 * @param nodeFor node associated with label.
	 * @return label.
	 */
	protected Label createLabel(String sLabel, Node nodeFor) {
		Label lbl = new Label(sLabel);
		lbl.setPrefWidth(FxSizes.getNodeWidth(lbl));
		lbl.setLabelFor(nodeFor);
		return lbl;
	} /* createLabel */

	protected HBox createHBoxRadioButton() {
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(dINNER_PADDING));
		hbox.setSpacing(dHSPACING);
		hbox.setAlignment(Pos.TOP_LEFT);

		_rbSFTP = new RadioButton("SFTP");
		_rbFileCopy = new RadioButton("File Copy");

		_rbSFTP.setSelected(true);
		_rbFileCopy.setSelected(false);

		ToggleGroup toggleGroup = new ToggleGroup();
		_rbSFTP.setToggleGroup(toggleGroup);
		_rbFileCopy.setToggleGroup(toggleGroup);

		toggleGroup.selectedToggleProperty().addListener(_tcl);

		hbox.getChildren().add(_rbSFTP);
		hbox.getChildren().add(_rbFileCopy);

		return hbox;
	}

	private VBox createVBoxSFTPConnection() {
		VBox vbox = new VBox();
		vbox.setPadding(new Insets(dINNER_PADDING));
		vbox.setSpacing(dVSPACING);
		vbox.setAlignment(Pos.TOP_LEFT);

		_tfSFTPHost = new TextField();
		Label lblSFTPHost = createLabel("Host :", _tfSFTPHost);
		HBox hboxSFTPHost = createHBox(lblSFTPHost, _tfSFTPHost);
		vbox.getChildren().add(hboxSFTPHost);

		_tfSFTPPort = new TextField();
		Label lblSFTPPort = createLabel("Port :", _tfSFTPPort);
		HBox hboxSFTPPort = createHBox(lblSFTPPort, _tfSFTPPort);
		vbox.getChildren().add(hboxSFTPPort);

		_tfSFTPUser = new TextField();
		Label lblSFTPUser = createLabel("User :", _tfSFTPUser);
		HBox hboxSFTPUser = createHBox(lblSFTPUser, _tfSFTPUser);
		vbox.getChildren().add(hboxSFTPUser);

		_tfSFTPPassword = new PasswordField();
		Label lblSFTPPassword = createLabel("Password :", _tfSFTPPassword);
		HBox hboxSFTPPassword = createHBox(lblSFTPPassword, _tfSFTPPassword);
		vbox.getChildren().add(hboxSFTPPassword);

		getMaxLabelPrefWidth(lblSFTPHost, lblSFTPPort, lblSFTPUser, lblSFTPPassword);

		//TODO 테스트 후 삭제
//		_tfSFTPHost.setText("10.65.209.193");
//		_tfSFTPPort.setText("22");
//		_tfSFTPUser.setText("dsrms_db");
//		_tfSFTPPassword.setText("1234");

		vbox.getChildren().add(new Separator());

		return vbox;
	}

	private class ToggleChangeListener implements ChangeListener<Toggle> {
		@Override
		public void changed(ObservableValue<? extends Toggle> ovt, Toggle tOld, Toggle tNew) {
			if(ovt.getValue() == null) return;

			RadioButton rb = (RadioButton) ovt.getValue().getToggleGroup().getSelectedToggle();
			if (rb == _rbSFTP) {
				_vboxSFTPConnection.setManaged(true);
				_vboxSFTPConnection.setVisible(true);

			} else if (rb == _rbFileCopy) {
				_vboxSFTPConnection.setManaged(false);
				_vboxSFTPConnection.setVisible(false);

			}

		}
	}

	protected ToggleChangeListener _tcl = new ToggleChangeListener();

	protected HBox createHBox(Label lbl, Node node) {
		HBox hbox = new HBox();
		lbl.setAlignment(Pos.BASELINE_RIGHT);
		hbox.setPadding(new Insets(dINNER_PADDING));
		hbox.setSpacing(dHSPACING);
		hbox.setAlignment(Pos.TOP_LEFT);
		hbox.getChildren().add(lbl);
		hbox.getChildren().add(node);
		double dWidth = 0.0;

		HBox.setHgrow(node, Priority.ALWAYS);
		if (node instanceof TextField) // PasswordField is a TextField
			dWidth = ((TextField) node).getPrefWidth();
		else if (node instanceof CheckBox)
			dWidth = ((CheckBox) node).getWidth();
		hbox.setMinWidth(lbl.getPrefWidth() + dHSPACING + dWidth);
		return hbox;
	} /* createHBox */

	protected HBox createHBox(Label lbl, PastingTextField ptfText, Button btn) {
		HBox hbox = new HBox();
		lbl.setAlignment(Pos.BASELINE_RIGHT);
		hbox.setPadding(new Insets(dINNER_PADDING));
		hbox.setSpacing(dHSPACING);
		hbox.setAlignment(Pos.TOP_LEFT);
		hbox.getChildren().add(lbl);
		hbox.getChildren().add(ptfText);
		HBox.getHgrow(ptfText);
		hbox.getChildren().add(btn);
		hbox.setMinWidth(lbl.getPrefWidth() + dHSPACING +
			ptfText.getPrefWidth() + dHSPACING +
			btn.getPrefWidth());

		HBox.setHgrow(ptfText, Priority.ALWAYS);
		return hbox;
	} /* createHBox */

	/*------------------------------------------------------------------*/
	/**
	 * compute the maximum pref width of the given labels and set their min and pref widths to that
	 * value.
	 *
	 * @param aLabels labels.
	 * @return maximum pref width.
	 */
	protected double getMaxLabelPrefWidth(Label... aLabel) {
		double dMaxPrefWidth = 0.0;
		for (int iLabel = 0; iLabel < aLabel.length; iLabel++) {
			Label lbl = aLabel[iLabel];
			if (lbl != null) {
				double dPrefWidth = lbl.getPrefWidth();
				if (dMaxPrefWidth < dPrefWidth)
					dMaxPrefWidth = dPrefWidth;
			}
		}
		for (int iLabel = 0; iLabel < aLabel.length; iLabel++) {
			Label lbl = aLabel[iLabel];
			if (lbl != null) {
				lbl.setMinWidth(dMaxPrefWidth);
				lbl.setPrefWidth(dMaxPrefWidth);
			}
		}
		return dMaxPrefWidth;
	} /* getMaxLabelPrefWidth */

	/*------------------------------------------------------------------*/
	/**
	 * compute the maximum min width of the given Panes.
	 *
	 * @param apane Panes.
	 * @return maximum min width.
	 */
	protected double getMaxPaneMinWidth(Pane... apane) {
		double dMaxMinWidth = 0.0;
		for (int iPane = 0; iPane < apane.length; iPane++) {
			Pane pane = apane[iPane];
			if (pane != null) {
				double dMinWidth = pane.getMinWidth();
				if (dMaxMinWidth < dMinWidth)
					dMaxMinWidth = dMinWidth;
			}
		}
		return dMaxMinWidth;
	} /* getMaxPaneMinWidth */

	/* ==================================================================== */
	/**
	 * PastingTextField implements non-editable field which can receive paste events and serve as a drop
	 * target.
	 */
	private class PastingTextField extends TextField {
		private boolean bChangeable = false;

		PastingTextField(String s) {
			super(s);
		}

		@Override
		public void replaceText(int start, int end, String text) {
			if (bChangeable)
				super.replaceText(start, end, text);
		}

		public void changeText(String s) {
			bChangeable = true;
			setText(s);
			bChangeable = false;
		}

		@Override
		public void paste() {
			Clipboard cb = Clipboard.getSystemClipboard();
			String sPasted = cb.getString();
			File file = new File(sPasted);
			// if we have a file, it gets priority over the string
			List<File> listFiles = cb.getFiles();
			if (listFiles.size() == 1)
				file = listFiles.get(0);
			if (file.isDirectory())
				changeText(file.getAbsolutePath());
		}
	} /* class */
	/* ==================================================================== */

	private HBox createHBoxTableView() {

		SiardBundle sb = SiardBundle.getSiardBundle();

		HBox hBoxTableView = new HBox();
		hBoxTableView.setPadding(new Insets(dINNER_PADDING));
		hBoxTableView.setSpacing(dHSPACING);

		_tvColumnList = new TableView<ColumnModel>();
		_tvColumnList.setMinWidth(500.0d); //width 설정

		Callback<TableColumn<ColumnModel, String>, TableCell<ColumnModel, String>> cellFactory = (TableColumn<ColumnModel, String> param) -> new EditingCell();

		TableColumn<ColumnModel, String> columnName = new TableColumn<ColumnModel, String>(sb.getTableColumnName());
		TableColumn<ColumnModel, String> columnType = new TableColumn<ColumnModel, String>(sb.getTableColumnType());
		TableColumn<ColumnModel, String> sourceFileRootPath = new TableColumn<ColumnModel, String>(sb.getTableColumnRootPath());
		TableColumn<ColumnModel, Boolean> chooseColumnFlag = new TableColumn<ColumnModel, Boolean>(sb.getTableColumnChoose());

		columnName.setCellValueFactory(new PropertyValueFactory<ColumnModel, String>("columnName"));
		columnType.setCellValueFactory(new PropertyValueFactory<ColumnModel, String>("columnType"));
		//람다 표현식(문제시 아래 주석처리한 문장으로 교제)
		sourceFileRootPath.setCellValueFactory(cellData -> cellData.getValue().sourceFileRootPath);
//		sourceFileRootPath.setCellValueFactory(new PropertyValueFactory<ColumnModel, String>("sourceFileRootPath"));
		sourceFileRootPath.setCellFactory(cellFactory);
		//람다 표현식(문제시 아래 주석처리한 문장으로 교제)
		sourceFileRootPath.setOnEditCommit(
            (TableColumn.CellEditEvent<ColumnModel, String> t) -> {
        		t.getTableView().getItems()
        		.get(t.getTablePosition().getRow())
        		.setSourceFileRootPath(new SimpleStringProperty(t.getNewValue()));
            }
        );
//		sourceFileRootPath.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<ColumnModel,String>>() {
//			@Override
//			public void handle(TableColumn.CellEditEvent<ColumnModel,String> t) {
//				t.getTableView().getItems()
//        		.get(t.getTablePosition().getRow())
//        		.setSourceFileRootPath(t.getNewValue());
//			}
//		});

		chooseColumnFlag.setCellValueFactory(new PropertyValueFactory<ColumnModel, Boolean>("chooseColumnFlag"));
		chooseColumnFlag.setCellFactory(CheckBoxTableCell.forTableColumn(chooseColumnFlag));

		columnName.prefWidthProperty().bind(_tvColumnList.widthProperty().multiply(0.2));
		columnType.prefWidthProperty().bind(_tvColumnList.widthProperty().multiply(0.2));
		sourceFileRootPath.prefWidthProperty().bind(_tvColumnList.widthProperty().multiply(0.4));
		chooseColumnFlag.prefWidthProperty().bind(_tvColumnList.widthProperty().multiply(0.2));

		_tvColumnList.getColumns().add(columnName);
		_tvColumnList.getColumns().add(columnType);
		_tvColumnList.getColumns().add(sourceFileRootPath);
		_tvColumnList.getColumns().add(chooseColumnFlag);
		_tvColumnList.setEditable(true);

		_tvColumnList.setPlaceholder(new Label(sb.getListNoData()));

		SiardConnection.getSiardConnection().loadDriver(tableModel.getConnectionUrl());
		DriverManager.setLoginTimeout(0);

		try {
			Connection conn = null;
			conn = DriverManager.getConnection(tableModel.getConnectionUrl(), tableModel.getUser(), tableModel.getPassword());
			conn.setAutoCommit(false);

			ResultSet rs = conn.getMetaData().getColumns(null, tableModel.getSchemaName(), tableModel.getTableName(), "%");
			while (rs.next()) {
				_tvColumnList.getItems().add(new ColumnModel(tableModel.getSchemaName(), tableModel.getTableName(), rs.getString("COLUMN_NAME"), rs.getString("TYPE_NAME"), null, false));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		hBoxTableView.getChildren().add(_tvColumnList);

		// autoResizeColumns(_tvColumnList);

		HBox.setHgrow(_tvColumnList, Priority.ALWAYS);

		return hBoxTableView;
	}

	// 컬럼 크기를 구해 테이블 뷰 크기를 리 사이징 한다.
	public void autoResizeColumns(TableView<?> tableView) {

		// Set the right policy
		tableView.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);
		tableView.getColumns().stream().forEach((column) -> {

			Text t = new Text(column.getText());
			double max = t.getLayoutBounds().getWidth();
			for (int i = 0; i < tableView.getItems().size(); i++) {
				// cell must not be empty
				if (column.getCellData(i) != null) {

					t = new Text(column.getCellData(i).toString());
					double calcwidth = t.getLayoutBounds().getWidth();
					// remember new max-width
					if (calcwidth > max) {
						max = calcwidth;
					}
				}
			}
			// set the new max-widht with some extra space
			column.setPrefWidth(max + 15.0d);
		});
	}

	/*------------------------------------------------------------------*/
	/**
	 * create the HBox with the OK button.
	 *
	 * @return HBox with OK button.
	 */
	private HBox createHBoxButton() {
		SiardBundle sb = SiardBundle.getSiardBundle();

		/* default button */
		_btnDefault = new Button(sb.getOk());
		_btnDefault.setDefaultButton(true);
		_btnDefault.setOnAction(this);

		_btnCancel = new Button(sb.getCancel());
		_btnCancel.setCancelButton(true);
		_btnCancel.setOnAction(this);

		/* HBox for button */
		HBox hboxButton = new HBox();
		hboxButton.setPadding(new Insets(dINNER_PADDING));
		hboxButton.setSpacing(dHSPACING);
		hboxButton.setAlignment(Pos.TOP_RIGHT);
		hboxButton.getChildren().add(_btnDefault);
		hboxButton.getChildren().add(_btnCancel);
		hboxButton.setMinWidth(FxSizes.getTextWidth(sb.getOk()));

		return hboxButton;
	} /* createHBoxButton */

	/*------------------------------------------------------------------*/
	/**
	 * show the modal history detail dialog.
	 *
	 * @param stageOwner owner window.
	 */
	public static TableColumnDialog showTableColumnDialog(Stage stageOwner, TableModel tableModel, FileDownloadModel fileDownloadModel) {
		TableColumnDialog tcd = new TableColumnDialog(stageOwner, tableModel, fileDownloadModel);
		tcd.showAndWait(); // until it is closed
		return tcd;
	} /* showInfoDialog */


	/**
	 * 테이블 컬럼 에디트 셀 설정
	 * @Type    : EditingCell
	 * @Date    : 2020. 8. 25
	 * @Version : 1.0
	 */
	class EditingCell extends TableCell<ColumnModel, String> {

	    private TextField textField;

	    private EditingCell() {
	    }

	    @Override
	    public void startEdit() {
	        if (!isEmpty()) {
	            super.startEdit();
	            createTextField();
	            setText(null);
	            setGraphic(textField);
	            textField.selectAll();
	        }
	    }

	    @Override
	    public void cancelEdit() {
	        super.cancelEdit();

	        setText(getItem());
	        setGraphic(null);
	    }

	    @Override
	    public void updateItem(String item, boolean empty) {
	        super.updateItem(item, empty);

	        if (empty) {
	            setText(item);
	            setGraphic(null);
	        } else {
	            if (isEditing()) {
	                if (textField != null) {
	                    textField.setText(getString());
//	                    setGraphic(null);
	                }
	                setText(null);
	                setGraphic(textField);
	            } else {
	                setText(getString());
	                setGraphic(null);
	            }
	        }
	    }

		private void createTextField() {
	        textField = new TextField(getString());
	        textField.setMinWidth(this.getWidth() - this.getGraphicTextGap() * 2);
	        textField.setOnAction((e) -> commitEdit(textField.getText()));
	        textField.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
	        	if (!newValue) {
	                commitEdit(textField.getText());

	                boolean rootPathFlag = true;
	                for (int i = 0; i < _tvColumnList.getColumns().size(); i++) {
	                	//컬럼명(0), 컬럼타입(1)은 패스
	                	if(i < 2) continue;

						TableColumn<ColumnModel, ?> column = _tvColumnList.getColumns().get(i);

						//filePath 입력 체크
						if(i == 2 && (column.getCellData(getIndex()) == null || "".equals(column.getCellData(getIndex())))) {
							rootPathFlag = false;
						}

						if (i == 3 && column.getCellData(getIndex()) != null) {
        					_tvColumnList.getItems().get(getIndex()).setChooseColumnFlag(new SimpleBooleanProperty(rootPathFlag));
        				}
					}

	                _tvColumnList.refresh();
	            }
	        });
	    }

	    private String getString() {
	        return getItem() == null ? "" : getItem();
	    }
	}/* class EditingCell */

} /* class InfoDialog */
