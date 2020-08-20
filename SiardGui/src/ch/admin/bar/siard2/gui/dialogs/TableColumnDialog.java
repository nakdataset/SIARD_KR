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
import ch.admin.bar.siard2.cmd.SiardConnection;
import ch.admin.bar.siard2.gui.SiardBundle;
import ch.admin.bar.siard2.gui.models.ColumnModel;
import ch.admin.bar.siard2.gui.models.TableModel;
import ch.enterag.utils.fx.FxSizes;
import ch.enterag.utils.fx.FxStyles;
import ch.enterag.utils.fx.ScrollableDialog;
import ch.enterag.utils.fx.dialogs.FS;
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

/* ==================================================================== */
/**
 * HistoryDialog displays meta data of the program.
 *
 * @author Hartwig Thomas
 */
public class TableColumnDialog extends ScrollableDialog implements EventHandler<ActionEvent> {

	// 최창근 추가 - 로그
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

	private VBox _vboxFileCopy;
	private Button _btnSourceFileBrowser;
	private Label _lblSourceFilePath;
	private PastingTextField _tfSourceFilePath;

	private Button _btnTargetFileBrowser;
	private PastingTextField _tfTargetFilePath;

	private TableColumnDialog(Stage stageOwner, TableModel tableModel) {
		// super(stageOwner, SiardBundle.getSiardBundle().getInfoTitle());

		// TODO text값 properties로 관리해야되지 않을까?
		super(stageOwner, "내역 타이틀 테스트");

		this.tableModel = tableModel;

		// TODO getColumnTitle 로 변경해야함
		double dMinWidth = FxSizes.getTextWidth(SiardBundle.getSiardBundle().getInfoTitle()) + FxSizes.getCloseWidth() + dHSPACING;

		VBox vboxDialog = createVBoxDialog();

		if (dMinWidth < vboxDialog.getMinWidth()) {
			dMinWidth = vboxDialog.getMinWidth();
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
		LOG.info("handle");

		SiardBundle sb = SiardBundle.getSiardBundle();

		if (event.getSource() == _btnCancel) {
			close();

		} else if (event.getSource() == _btnDefault) {

			/*
			if (getChooseColumnCount() < 1) {
				// TODO 최창근 추가 - 컬럼을 선택하라는 메시지 alert 추가 .properties로 메시지 관리
				LOG.info("선택한 컬럼 없음");
				MB.show(this, "제목", "내용", sb.getOk(), null);
				return;
			}
			 */

			setColumnListByChooseColumn();

			_iResult = iRESULT_SUCCESS;

			close();

		} else if (event.getSource() == _btnTargetFileBrowser) {
			// UserProperties up = UserProperties.getUserProperties();
			// String sDbFolder = _tfDbFolder.getText();
//			File fileDbFolder = new File(_tfTargetFilePath.getText());
			File fileDbFolder = null;
			try {
				fileDbFolder = FS.chooseExistingFolder(TableColumnDialog.this,
					sb.getConnectionDbFolderTitle(), sb.getConnectionDbFolderMessage(), sb,
					fileDbFolder);
				if (fileDbFolder != null) {
					// up.setDatabaseFolder(fileDbFolder);
					_tfTargetFilePath.setText(fileDbFolder.getAbsolutePath());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (event.getSource() == _btnSourceFileBrowser) {
			// UserProperties up = UserProperties.getUserProperties();
			// String sDbFolder = _tfDbFolder.getText();
//			File fileDbFolder = new File(_tfSourceFilePath.getText());
			File fileDbFolder = null;
			try {
				fileDbFolder = FS.chooseExistingFolder(TableColumnDialog.this,
					sb.getConnectionDbFolderTitle(), sb.getConnectionDbFolderMessage(), sb,
					fileDbFolder);
				if (fileDbFolder != null) {
					// up.setDatabaseFolder(fileDbFolder);
					_tfSourceFilePath.setText(fileDbFolder.getAbsolutePath());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	} /* handle */

	public void setColumnListByChooseColumn() {
		int size = _tvColumnList.getItems().size();
		List<String> chooseColumnList = new ArrayList<String>();

		for (int i = 0; i < size; i++) {
			if (_tvColumnList.getItems().get(i).getChooseColumnFlag()) {
				chooseColumnList.add(_tvColumnList.getItems().get(i).getColumnName());
//				chooseColumnList.add(_tvColumnList.getItems().get(i).getColumnType() + "." + _tvColumnList.getItems().get(i).getColumnName());
			}
		}
		LOG.info(chooseColumnList.toString());

		fileDownloadModel = new FileDownloadModel();
		fileDownloadModel.setSchemaName(tableModel.getSchemaName());
		fileDownloadModel.setTableName(tableModel.getTableName());

		fileDownloadModel.setSftpFlag(_rbSFTP.isSelected());
		fileDownloadModel.setFileCopyFlag(_rbFileCopy.isSelected());

		fileDownloadModel.setHost(_tfSFTPHost.getText());
		fileDownloadModel.setUser(_tfSFTPUser.getText());
		fileDownloadModel.setPassword(_tfSFTPPassword.getText());
		fileDownloadModel.setPort(Integer.parseInt(_tfSFTPPort.getText()));

		fileDownloadModel.setSourceFilePath(_tfSourceFilePath.getText());
		fileDownloadModel.setTargetFilePath(_tfTargetFilePath.getText());

		fileDownloadModel.setChooseColumnList(chooseColumnList);

	}

	/*------------------------------------------------------------------*/
	/**
	 * create the main VBox of the dialog
	 *
	 * @return main VBox
	 */
	private VBox createVBoxDialog() {
		LOG.info("createVBoxDialog");

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

		_vboxFileCopy = createVBoxFileCopy();
		_vboxFileCopy.setVisible(false);
		_vboxFileCopy.setManaged(false);
		vbox.getChildren().add(_vboxFileCopy);

		vbox.getChildren().add(new Separator());

		Label lblSFTPTargetFilePath = createLabel("Target FilePath :", _tfTargetFilePath);
		_tfTargetFilePath = new PastingTextField("");
		_tfTargetFilePath.setText("");

		// TODO 최창근 추가 - 다국어 지원을 위한 .properties 관리.
		_btnTargetFileBrowser = new Button(sb.getConnectionDbFolderButton());
		_btnTargetFileBrowser.setAlignment(Pos.BASELINE_RIGHT);
		_btnTargetFileBrowser.setMinWidth(FxSizes.getNodeWidth(_btnTargetFileBrowser));
		_btnTargetFileBrowser.setOnAction(this);

		HBox hboxSFTPTargetFilePath = createHBox(lblSFTPTargetFilePath, _tfTargetFilePath, _btnTargetFileBrowser);
		vbox.getChildren().add(hboxSFTPTargetFilePath);

		getMaxLabelPrefWidth(_lblSourceFilePath, lblSFTPTargetFilePath);

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
		_rbFileCopy = new RadioButton("FileCopy");

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

	//TODO 최창근 추가 - setText 테스트 후 삭제하기
	private VBox createVBoxSFTPConnection() {
		VBox vbox = new VBox();
		vbox.setPadding(new Insets(dINNER_PADDING));
		vbox.setSpacing(dVSPACING);
		vbox.setAlignment(Pos.TOP_LEFT);

		_tfSFTPHost = new TextField();
		Label lblSFTPHost = createLabel("Host :", _tfSFTPHost);
		HBox hboxSFTPHost = createHBox(lblSFTPHost, _tfSFTPHost);
		// TODO 테스트 후 삭제
		_tfSFTPHost.setText("192.168.1.153");
		vbox.getChildren().add(hboxSFTPHost);

		_tfSFTPPort = new TextField();
		Label lblSFTPPort = createLabel("Port :", _tfSFTPPort);
		HBox hboxSFTPPort = createHBox(lblSFTPPort, _tfSFTPPort);
		// TODO 테스트 후 삭제
		_tfSFTPPort.setText("22");
		vbox.getChildren().add(hboxSFTPPort);

		_tfSFTPUser = new TextField();
		Label lblSFTPUser = createLabel("User :", _tfSFTPUser);
		HBox hboxSFTPUser = createHBox(lblSFTPUser, _tfSFTPUser);
		// TODO 테스트 후 삭제
		_tfSFTPUser.setText("dsrms_db");
		vbox.getChildren().add(hboxSFTPUser);

		_tfSFTPPassword = new PasswordField();
		Label lblSFTPPassword = createLabel("Password :", _tfSFTPPassword);
		HBox hboxSFTPPassword = createHBox(lblSFTPPassword, _tfSFTPPassword);
		// TODO 테스트 후 삭제
		_tfSFTPPassword.setText("1234");
		vbox.getChildren().add(hboxSFTPPassword);

		getMaxLabelPrefWidth(lblSFTPHost, lblSFTPPort, lblSFTPUser, lblSFTPPassword);

		return vbox;
	}

	private VBox createVBoxFileCopy() {
		SiardBundle sb = SiardBundle.getSiardBundle();

		VBox vbox = new VBox();
		vbox.setPadding(new Insets(dINNER_PADDING));
		vbox.setSpacing(dVSPACING);
		vbox.setAlignment(Pos.TOP_LEFT);

		_lblSourceFilePath = createLabel("Source File Path :", _tfSourceFilePath);

		_tfSourceFilePath = new PastingTextField("");
		_tfSourceFilePath.setText("");

		// TODO 최창근 추가 - 다국어 지원을 위한 .properties 관리.
		_btnSourceFileBrowser = new Button(sb.getConnectionDbFolderButton());
		_btnSourceFileBrowser.setAlignment(Pos.BASELINE_RIGHT);
		_btnSourceFileBrowser.setMinWidth(FxSizes.getNodeWidth(_btnSourceFileBrowser));
		_btnSourceFileBrowser.setOnAction(this);

		HBox hboxSourceFilePath = createHBox(_lblSourceFilePath, _tfSourceFilePath, _btnSourceFileBrowser);
		vbox.getChildren().add(hboxSourceFilePath);

		return vbox;
	}

	private class ToggleChangeListener implements ChangeListener<Toggle> {
		@Override
		public void changed(ObservableValue<? extends Toggle> ovt, Toggle tOld, Toggle tNew) {
			RadioButton rb = (RadioButton) ovt.getValue().getToggleGroup().getSelectedToggle();
			if (rb == _rbSFTP) {
				_vboxSFTPConnection.setManaged(true);
				_vboxSFTPConnection.setVisible(true);

				_vboxFileCopy.setManaged(false);
				_vboxFileCopy.setVisible(false);

			} else if (rb == _rbFileCopy) {
				_vboxSFTPConnection.setManaged(false);
				_vboxSFTPConnection.setVisible(false);

				_vboxFileCopy.setManaged(true);
				_vboxFileCopy.setVisible(true);
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

		// TODO 최창근 수정 - 동적 크기조절을 위한 설정
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

		LOG.info("createHBoxTableView");
		SiardBundle sb = SiardBundle.getSiardBundle();

		HBox hBoxTableView = new HBox();
		hBoxTableView.setPadding(new Insets(dINNER_PADDING));
		hBoxTableView.setSpacing(dHSPACING);

		_tvColumnList = new TableView<ColumnModel>();

		// TODO 최창근 추가 - 스키마,테이블,선택 properties에서 key=value로 관리(다국어 지원을 위한)
		TableColumn<ColumnModel, String> columnName = new TableColumn<ColumnModel, String>("컬럼명");
		TableColumn<ColumnModel, String> columnType = new TableColumn<ColumnModel, String>("컬럼타입");
		TableColumn<ColumnModel, Boolean> chooseColumnFlag = new TableColumn<ColumnModel, Boolean>("선택");

		columnName.setCellValueFactory(new PropertyValueFactory<ColumnModel, String>("columnName"));
		columnType.setCellValueFactory(new PropertyValueFactory<ColumnModel, String>("columnType"));
		chooseColumnFlag.setCellValueFactory(new PropertyValueFactory<ColumnModel, Boolean>("chooseColumnFlag"));
		chooseColumnFlag.setCellFactory(CheckBoxTableCell.forTableColumn(chooseColumnFlag));

		columnName.prefWidthProperty().bind(_tvColumnList.widthProperty().multiply(0.4));
		columnType.prefWidthProperty().bind(_tvColumnList.widthProperty().multiply(0.4));
		chooseColumnFlag.prefWidthProperty().bind(_tvColumnList.widthProperty().multiply(0.2));

		_tvColumnList.getColumns().add(columnName);
		_tvColumnList.getColumns().add(columnType);
		_tvColumnList.getColumns().add(chooseColumnFlag);
		_tvColumnList.setEditable(true);

		// TODO text값 properties로 관리해야되지 않을까?
		_tvColumnList.setPlaceholder(new Label("데이터 없음 1122"));

		SiardConnection.getSiardConnection().loadDriver(tableModel.getConnectionUrl());
		// DriverManager.setLoginTimeout(0);

		try {
			Connection conn = null;
			conn = DriverManager.getConnection(tableModel.getConnectionUrl(), tableModel.getUser(), tableModel.getPassword());
			conn.setAutoCommit(false);

			ResultSet rs = conn.getMetaData().getColumns(null, tableModel.getSchemaName(), tableModel.getTableName(), "%");
			while (rs.next()) {
				_tvColumnList.getItems().add(new ColumnModel(tableModel.getSchemaName(), tableModel.getTableName(), rs.getString("COLUMN_NAME"), rs.getString("TYPE_NAME"), false));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		hBoxTableView.getChildren().add(_tvColumnList);

		// 최창근 추가 - 테이블 크기별로 리사이징
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
	public static TableColumnDialog showTableColumnDialog(Stage stageOwner, TableModel tableModel) {
		LOG.info("showTableColumnDialog");
		TableColumnDialog tcd = new TableColumnDialog(stageOwner, tableModel);
		tcd.showAndWait(); // until it is closed
		return tcd;
	} /* showInfoDialog */

} /* class InfoDialog */
