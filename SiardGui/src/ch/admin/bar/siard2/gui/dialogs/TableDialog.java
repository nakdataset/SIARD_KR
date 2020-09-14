package ch.admin.bar.siard2.gui.dialogs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import ch.admin.bar.siard2.api.primary.FileDownloadModel;
import ch.admin.bar.siard2.cmd.SiardConnection;
import ch.admin.bar.siard2.gui.SiardBundle;
import ch.admin.bar.siard2.gui.models.TableModel;
import ch.enterag.utils.fx.FxSizes;
import ch.enterag.utils.fx.FxStyles;
import ch.enterag.utils.fx.ScrollableDialog;
import ch.enterag.utils.fx.dialogs.MB;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TableDialog extends ScrollableDialog implements EventHandler<ActionEvent> {

	private static final Logger LOG = Logger.getLogger(TableDialog.class);

	/** result will be 1 for default, 0 otherwise */
	public static final int iRESULT_CANCELED = 0;
	public static final int iRESULT_SUCCESS = 1;
	protected int _iResult = iRESULT_CANCELED;
	public int getResult() { return _iResult; }

	/** default button (= Enter) */
	protected Button _btnDefault = null;
	/** cancel button (= Escape) */
	protected Button _btnCancel = null;

	private CheckBox _cbAllChooseTable = null;
	private Label _lblAllChooseTable = null;

	private TableView<TableModel> _tvTableList = null;

	// properties
	protected DownloadConnectionDialog dcd;
	protected TableColumnDialog tcd;

	private Map<String, FileDownloadModel> chooseColumnMap;

	//20200908 - 이전 파일다운로드모델 리스트 by.pks
	private List<FileDownloadModel> beforeFileDownloadModelList = new ArrayList<FileDownloadModel>();

	private Connection conn = null;

	private Stage stageOwner;

	private TableDialog(Stage stageOwner, DownloadConnectionDialog dcd) throws Exception{
		super(stageOwner, SiardBundle.getSiardBundle().getTableTitle());

		this.dcd = dcd;
		this.stageOwner = stageOwner;

		chooseColumnMap = new HashMap<String, FileDownloadModel>();

		double dMinWidth = FxSizes.getTextWidth(SiardBundle.getSiardBundle().getTableTitle()) + FxSizes.getCloseWidth() + dHSPACING;

		VBox vboxDialog = createVBoxDialog();

		if (dMinWidth < vboxDialog.getMinWidth()) {
			dMinWidth = vboxDialog.getMinWidth();
		}

		setMinWidth(dMinWidth);

		/* scene */
		Scene scene = new Scene(vboxDialog);
		setScene(scene);

		dcd._iResult = iRESULT_CANCELED;
	}

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub

		if (event.getSource() == _btnDefault) {
			SiardBundle sb = SiardBundle.getSiardBundle();

			if(getChooseTableCount() < 1) {
				//TODO .properties로 메시지 관리
				MB.show(this, "알림", "선택된 테이블이 없습니다.", sb.getOk(), null);
				return;
			}

			dcd.chooseTableList = getTableListByChooseTable();

			for(int i=0; i<dcd.chooseTableList.size(); i++) {
				// chooseColumnMap.get(dcd.chooseTableList.get(i));
				dcd.chooseColumnMap.put(dcd.chooseTableList.get(i), chooseColumnMap.get(dcd.chooseTableList.get(i)));
			}

			dcd._iResult = iRESULT_SUCCESS;
		}

		close();
	}

	private int getChooseTableCount() {
		int count = 0;
		int size = _tvTableList.getItems().size();
		for(int i=0; i<size; i++){
			if(_tvTableList.getItems().get(i).getChooseTableFlag()) {
				count++;
			}
    	}
		return count;
	}

	private List<String> getTableListByChooseTable(){
		int size = _tvTableList.getItems().size();
		List<String> chooseTableList = new ArrayList<String>();

		for(int i=0; i<size; i++){
			if(_tvTableList.getItems().get(i).getChooseTableFlag()) {
				chooseTableList.add(_tvTableList.getItems().get(i).getSchemaName() + "." +_tvTableList.getItems().get(i).getTableName());
			}
    	}

		return chooseTableList;
	}

	private VBox createVBoxDialog() throws Exception{

		/* VBox for title area, separator, credits area, separator and OK button */
		VBox vboxDialog = new VBox();
		vboxDialog.setPadding(new Insets(dOUTER_PADDING));
		vboxDialog.setSpacing(dVSPACING);
		vboxDialog.setStyle(FxStyles.sSTYLE_BACKGROUND_LIGHTGREY);

		double dMinWidth = 0;

		HBox hboxTopButton = createHBoxTopButton();
	    if (dMinWidth < hboxTopButton.getMinWidth())
	      dMinWidth = hboxTopButton.getMinWidth();
	    vboxDialog.getChildren().add(hboxTopButton);

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

	private HBox createHBoxTopButton(){
	    SiardBundle sb = SiardBundle.getSiardBundle();

	    HBox hbox = new HBox();
	    hbox.setSpacing(dHSPACING);
	    hbox.setStyle(FxStyles.sSTYLE_BACKGROUND_LIGHTGREY);
	    hbox.setAlignment(Pos.BASELINE_RIGHT);

	    _cbAllChooseTable = new CheckBox();
	    _cbAllChooseTable.setSelected(true);
	    _cbAllChooseTable.setOnAction(_aeh);

	    _lblAllChooseTable = new Label(sb.getTableAllChoose());
	    _lblAllChooseTable.setLabelFor(_cbAllChooseTable);
	    _lblAllChooseTable.setAlignment(Pos.BASELINE_RIGHT);

	    hbox.getChildren().add(_lblAllChooseTable);
	    hbox.getChildren().add(_cbAllChooseTable);

	    return hbox;
	}

	private class ActionEventHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub

			if(event.getSource() == _cbAllChooseTable) {
				allChooseTable();
			}

		}

	}
	private ActionEventHandler _aeh = new ActionEventHandler();

	void allChooseTable() {
		for(int i=0, size=_tvTableList.getItems().size(); i<size; i++){
			_tvTableList.getItems().get(i).setCheck(_cbAllChooseTable.isSelected());
    	}
		_tvTableList.refresh();
	}

	void getTableNameByColumn(Connection conn, TableModel tableModel) {
		try {
			ResultSet rs = conn.getMetaData().getColumns(null, tableModel.getSchemaName(), tableModel.getTableName(), "%");
			ResultSetMetaData rsmd = rs.getMetaData();
			int cols = rsmd.getColumnCount();

			while (rs.next()) {
				for(int i=1; i<=cols; i++) {
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private HBox createHBoxTableView() throws Exception{
		SiardBundle sb = SiardBundle.getSiardBundle();

		HBox hBoxTableView = new HBox();
		hBoxTableView.setPadding(new Insets(dINNER_PADDING));
		hBoxTableView.setSpacing(dHSPACING);

		_tvTableList = new TableView<TableModel>();

		TableColumn<TableModel, String> columnSchemaName = new TableColumn<TableModel, String>(sb.getTableSchemaName());
		TableColumn<TableModel, String> columnTableName = new TableColumn<TableModel, String>(sb.getTableTableName());
		TableColumn<TableModel, Boolean> columnChooseTableFlag = new TableColumn<TableModel, Boolean>(sb.getTableChoose());

		columnSchemaName.setCellValueFactory(new PropertyValueFactory<TableModel, String>("schemaName"));
		columnTableName.setCellValueFactory(new PropertyValueFactory<TableModel, String>("tableName"));
		columnChooseTableFlag.setCellValueFactory(new PropertyValueFactory<TableModel, Boolean>("chooseTableFlag"));
		columnChooseTableFlag.setCellFactory(CheckBoxTableCell.forTableColumn(columnChooseTableFlag));

		_tvTableList.getColumns().add(columnSchemaName);
		_tvTableList.getColumns().add(columnTableName);
		_tvTableList.getColumns().add(columnChooseTableFlag);
		_tvTableList.setEditable(true);

		//list에 데이터가 없을때 보여주는 메시지
		_tvTableList.setPlaceholder(new Label(sb.getListNoData()));

		SiardConnection.getSiardConnection().loadDriver(dcd.getConnectionUrl());
		// DriverManager.setLoginTimeout(0);

		conn = DriverManager.getConnection(dcd.getConnectionUrl(), dcd.getDbUser(),  dcd.getDbPassword());
		conn.setAutoCommit(false);

		ResultSet rs = conn.getMetaData().getTables(null, "%", "%", new String[]{"TABLE"});
		while (rs.next()) {
	      _tvTableList.getItems().add(new TableModel(rs.getString("TABLE_SCHEM"), rs.getString("TABLE_NAME"), true));
		}

		autoResizeColumns(_tvTableList);

		TableModel tempTableModel = new TableModel();
		tempTableModel.setConnectionUrl(dcd.getConnectionUrl());
		tempTableModel.setUser(dcd.getDbUser());
		tempTableModel.setPassword(dcd.getDbPassword());

		_tvTableList.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub

				Object clickRowObject =  _tvTableList.getSelectionModel().selectedItemProperty().get();
				int clickRowIndex = _tvTableList.getSelectionModel().selectedIndexProperty().get();
				TableModel tableModel = (TableModel) clickRowObject;

				if(event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
					tempTableModel.setSchemaName(tableModel.getSchemaName());
					tempTableModel.setTableName(tableModel.getTableName());

					_tvTableList.getItems().get(clickRowIndex).setCheck(true);
					_tvTableList.refresh();

					FileDownloadModel beforeFileDownloadModel = null;

					int beforeFileDownloadModelListIndex = 0; //이전 파일다운로드모델 리스트 인덱스
					for (FileDownloadModel fileDownloadModel : beforeFileDownloadModelList) {
						if(_tvTableList.getItems().get(clickRowIndex).getTableName().equals(fileDownloadModel.getTableName())
								&& _tvTableList.getItems().get(clickRowIndex).getSchemaName().equals(fileDownloadModel.getSchemaName())) {
							//테이블, 스키마 명이 같은 모델을 담은 후 break
							beforeFileDownloadModel = fileDownloadModel;
							break;
						}

						beforeFileDownloadModelListIndex++;
					}

					tcd = TableColumnDialog.showTableColumnDialog(stageOwner, tempTableModel, beforeFileDownloadModel);
					if(tcd.getResult() == iRESULT_SUCCESS) {
						// map 만들어서 넣어보자 key schema.table, value columnList
						chooseColumnMap.put(tableModel.getSchemaName() + "." +tableModel.getTableName(), tcd.fileDownloadModel);

						if(beforeFileDownloadModel != null) {
							//기존 모델 리스트에서 제거 후 재등록
							beforeFileDownloadModelList.remove(beforeFileDownloadModelListIndex);
						}
						beforeFileDownloadModelList.add(tcd.fileDownloadModel);
					}
				}
			}
		});

		hBoxTableView.getChildren().add(_tvTableList);
		HBox.setHgrow(_tvTableList, Priority.ALWAYS);
		return hBoxTableView;
	}

	// 컬럼 크기를 구해 테이블 뷰 크기를 리 사이징 한다.
	public void autoResizeColumns(TableView<?> tableView){
		tableView.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);
	    tableView.getColumns().stream().forEach((column) ->{

	        Text t = new Text(column.getText());
	        double max = t.getLayoutBounds().getWidth();
	        for(int i = 0; i<tableView.getItems().size(); i++){

	            if (column.getCellData(i) != null){

	                t = new Text(column.getCellData(i).toString());
	                double calcwidth = t.getLayoutBounds().getWidth();

	                if (calcwidth > max){
	                    max = calcwidth;
	                }
	            }
	        }

	        column.setPrefWidth(max + 15.0d);

//	        tableView.setPrefWidth(tableView.getPrefWidth() + (max + 15.0d) + 10.0d);
	    });
	}

	private HBox createHBoxButton(){
	    SiardBundle sb = SiardBundle.getSiardBundle();

	    /* default button */
	    _btnDefault = new Button(sb.getOk());
	    _btnDefault.setDefaultButton(true);
	    _btnDefault.setOnAction(this);

	    /* cancel button */
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
	}

	/*------------------------------------------------------------------*/
	/**
	 * show the modal choose table dialog.
	 *
	 * @param stageOwner owner window.
	 */
	public static TableDialog showChooseTableDialog(Stage stageOwner, DownloadConnectionDialog dcd) throws Exception{
		TableDialog td = new TableDialog(stageOwner, dcd);
		td.showAndWait(); // until it is closed
		return td;
	} /* showInfoDialog */

}
