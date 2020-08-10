package ch.admin.bar.siard2.gui.dialogs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

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

public class ChooseTableDialog extends ScrollableDialog implements EventHandler<ActionEvent> {

	// 최창근 추가 - 로그
	private static final Logger LOG = Logger.getLogger(ChooseTableDialog.class);

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

	private TableView<TableModel> _tvTableList = null;

	// properties
	protected DownloadConnectionDialog dcd;
	protected TableColumnDialog tcd;

	private Connection conn = null;

	private Stage stageOwner;

	private ChooseTableDialog(Stage stageOwner, DownloadConnectionDialog dcd) throws Exception{
		super(stageOwner, "테이블 선택 테스트");

		this.dcd = dcd;
		this.stageOwner = stageOwner;

		//TODO getChooseTableTitle 로 변경해야함
		double dMinWidth = FxSizes.getTextWidth(SiardBundle.getSiardBundle().getInfoTitle()) + FxSizes.getCloseWidth() + dHSPACING;

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
		LOG.info("handle");

		if (event.getSource() == _btnDefault) {
			SiardBundle sb = SiardBundle.getSiardBundle();

			if(getChooseTableCount() < 1) {
				//TODO 최창근 추가 - 테이블을 선택하라는 메시지 alert 추가 .properties로 메시지 관리
				LOG.info("선택한 테이블 없음");
				MB.show(this, "제목", "내용", sb.getOk(), null);
				return;
			}

			dcd.chooseTableList = getTableListByChooseTable();

			dcd.chooseColumnList = tcd.getColumnListByChooseColumn();

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
				LOG.info("선택 => " + _tvTableList.getItems().get(i).getTableName());

//				chooseTableList.add(_tvTableList.getItems().get(i).getTableName());

				//TODO 최창근 추가 - siardcmd 에서 스키마.테이블명 구현되면 바꾸기
				chooseTableList.add(_tvTableList.getItems().get(i).getSchemaName() + "." +_tvTableList.getItems().get(i).getTableName());
			}
    	}

		return chooseTableList;
	}

	private VBox createVBoxDialog() throws Exception{
		LOG.info("createVBoxDialog");

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

	    // TODO 최창근 추가 - 전체선택 properties 다국어 지원 추가
	    Label lblAllChooseTable = new Label("전체선택");
	    lblAllChooseTable.setLabelFor(_cbAllChooseTable);
	    lblAllChooseTable.setAlignment(Pos.BASELINE_RIGHT);

	    hbox.getChildren().add(lblAllChooseTable);
	    hbox.getChildren().add(_cbAllChooseTable);

	    return hbox;
	}


	private class ActionEventHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
			if(event.getSource() == _cbAllChooseTable) {
				allChooseTable();
				_tvTableList.refresh();
			}

		}

	}
	private ActionEventHandler _aeh = new ActionEventHandler();

	void allChooseTable() {
		for(int i=0, size=_tvTableList.getItems().size(); i<size; i++){
			_tvTableList.getItems().get(i).setCheck(_cbAllChooseTable.isSelected());
    	}
	}

	void getTableNameByColumn(Connection conn, TableModel tableModel) {
		try {
			ResultSet rs = conn.getMetaData().getColumns(null, tableModel.getSchemaName(), tableModel.getTableName(), "%");
			ResultSetMetaData rsmd = rs.getMetaData();
			int cols = rsmd.getColumnCount();

			while (rs.next()) {
				System.out.println();
				System.out.println();
				for(int i=1; i<=cols; i++) {
					System.out.println(rsmd.getColumnName(i) + " => " + rs.getString(rsmd.getColumnName(i)));
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private HBox createHBoxTableView() throws Exception{
		LOG.info("createHBoxTableView");
		SiardBundle sb = SiardBundle.getSiardBundle();

		HBox hBoxTableView = new HBox();
		hBoxTableView.setPadding(new Insets(dINNER_PADDING));
		hBoxTableView.setSpacing(dHSPACING);

		_tvTableList = new TableView<TableModel>();

		//TODO 최창근 추가 - 스키마,테이블,선택 properties에서 key=value로 관리(다국어 지원을 위한)
		TableColumn<TableModel, String> columnSchemaName = new TableColumn<TableModel, String>("스키마");
		TableColumn<TableModel, String> columnTableName = new TableColumn<TableModel, String>("테이블");
		TableColumn<TableModel, Boolean> columnChooseTableFlag = new TableColumn<TableModel, Boolean>("선택");

		columnSchemaName.setCellValueFactory(new PropertyValueFactory<TableModel, String>("schemaName"));
		columnTableName.setCellValueFactory(new PropertyValueFactory<TableModel, String>("tableName"));
		columnChooseTableFlag.setCellValueFactory(new PropertyValueFactory<TableModel, Boolean>("chooseTableFlag"));
		columnChooseTableFlag.setCellFactory(CheckBoxTableCell.forTableColumn(columnChooseTableFlag));

		_tvTableList.getColumns().add(columnSchemaName);
		_tvTableList.getColumns().add(columnTableName);
		_tvTableList.getColumns().add(columnChooseTableFlag);
		_tvTableList.setEditable(true);

		// TODO text값 properties로 관리해야되지 않을까?
//		historyTableView.setPlaceholder(new Label("데이터 없음 1122"));

		SiardConnection.getSiardConnection().loadDriver(dcd.getConnectionUrl());
		// DriverManager.setLoginTimeout(0);
//		Connection conn = null;

		conn = DriverManager.getConnection(dcd.getConnectionUrl(), dcd.getDbUser(),  dcd.getDbPassword());
		conn.setAutoCommit(false);

		ResultSet rs = conn.getMetaData().getTables(null, "%", "%", new String[]{"TABLE"});
		while (rs.next()) {
	      _tvTableList.getItems().add(new TableModel(rs.getString("TABLE_SCHEM"), rs.getString("TABLE_NAME"), true));
		}

		// 최창근 추가 - 테이블 크기별로 리사이징
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
					System.out.println("_tvTableList.setOnMouseClicked : " + clickRowObject);
					System.out.println("_tvTableList.setOnMouseClicked : " + clickRowIndex);
					System.out.println("_tvTableList.setOnMouseClicked : " + tableModel);
					System.out.println("schemaName : " + tableModel.getSchemaName());
					System.out.println("tableName : " + tableModel.getTableName());
					tempTableModel.setSchemaName(tableModel.getSchemaName());
					tempTableModel.setTableName(tableModel.getTableName());

					LOG.info("before tcd");
					tcd = TableColumnDialog.showTableColumnDialog(stageOwner, tempTableModel);
					LOG.info("after tcd");
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
	public static ChooseTableDialog showChooseTableDialog(Stage stageOwner, DownloadConnectionDialog dcd) throws Exception{
		LOG.info("showChooseTableDialog");
		ChooseTableDialog ctd = new ChooseTableDialog(stageOwner, dcd);
		ctd.showAndWait(); // until it is closed
		return ctd;
	} /* showInfoDialog */

}
