package ch.admin.bar.siard2.gui.dialogs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import org.apache.log4j.Logger;

import ch.admin.bar.siard2.cmd.SiardConnection;
import ch.admin.bar.siard2.gui.SiardBundle;
import ch.enterag.utils.fx.FxSizes;
import ch.enterag.utils.fx.FxStyles;
import ch.enterag.utils.fx.ScrollableDialog;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
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

	// properties
	protected DownloadConnectionDialog dcd;

	private ChooseTableDialog(Stage stageOwner, DownloadConnectionDialog dcd) {
		super(stageOwner, "테이블 선택 테스트");

		this.dcd = dcd;

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
			dcd._iResult = iRESULT_SUCCESS;
		}
//		if (event.getSource() == _btnCancel) {
//			_iResult = iRESULT_CANCELED;
//		}
		close();

	}

	private VBox createVBoxDialog() {
		LOG.info("createVBoxDialog");

		/* VBox for title area, separator, credits area, separator and OK button */
		VBox vboxDialog = new VBox();
		vboxDialog.setPadding(new Insets(dOUTER_PADDING));
		vboxDialog.setSpacing(dVSPACING);
		vboxDialog.setStyle(FxStyles.sSTYLE_BACKGROUND_LIGHTGREY);

		double dMinWidth = 0;

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

	private HBox createHBoxTableView() {

		LOG.info("createHBoxTableView");
		SiardBundle sb = SiardBundle.getSiardBundle();

		HBox hBoxTableView = new HBox();
		hBoxTableView.setPadding(new Insets(dINNER_PADDING));
		hBoxTableView.setSpacing(dHSPACING);

		TableView<TableListModel> chooseTableListTabieView = new TableView<TableListModel>();

		TableColumn<TableListModel, String> columnSchemaName = new TableColumn<TableListModel, String>("스키마");
		TableColumn<TableListModel, String> columnTableName = new TableColumn<TableListModel, String>("테이블");
		TableColumn<TableListModel, Boolean> columnChooseTable = new TableColumn<TableListModel, Boolean>("선택");

		columnSchemaName.setCellValueFactory(new PropertyValueFactory<TableListModel, String>("schemaName"));
		columnTableName.setCellValueFactory(new PropertyValueFactory<TableListModel, String>("tableName"));
		columnChooseTable.setCellValueFactory(new PropertyValueFactory<TableListModel, Boolean>("chooseTableFlag"));
		columnChooseTable.setCellFactory(CheckBoxTableCell.forTableColumn(columnChooseTable));

		chooseTableListTabieView.getColumns().add(columnSchemaName);
		chooseTableListTabieView.getColumns().add(columnTableName);
		chooseTableListTabieView.getColumns().add(columnChooseTable);
		chooseTableListTabieView.setEditable(true);

		// TODO text값 properties로 관리해야되지 않을까?
//		historyTableView.setPlaceholder(new Label("데이터 없음 1122"));

		//TODO 최창근 추가 - 테스트 후 삭제->테스트 데이터 삽입
//		ObservableList<TableListModel> rowdata = FXCollections.observableArrayList();

		try {
			Connection _conn = null;

			//TODO 최창근 추가 - 전 화면에서 가져와야함
			SiardConnection.getSiardConnection().loadDriver(dcd.getConnectionUrl());

			DriverManager.setLoginTimeout(0);

			//TODO 최창근 추가 - 전 화면에서 가져와야함
			_conn = DriverManager.getConnection(dcd.getConnectionUrl(), dcd.getDbUser(),  dcd.getDbPassword());
			_conn.setAutoCommit(false);

			ResultSet rs = _conn.getMetaData().getTables(null, "%", "%", new String[]{"TABLE"});

			while (rs.next()) {
			  String sTableSchema = rs.getString("TABLE_SCHEM");
		      String sTableName = rs.getString("TABLE_NAME");
		      String sTableType = rs.getString("TABLE_TYPE");

		      chooseTableListTabieView.getItems().add(new TableListModel(sTableSchema, sTableName, false));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// 최창근 추가 - 테이블 크기별로 리사이징
		autoResizeColumns(chooseTableListTabieView);

		hBoxTableView.getChildren().add(chooseTableListTabieView);

		HBox.setHgrow(chooseTableListTabieView, Priority.ALWAYS);

//		chooseTableListTabieView.addEventHandler(ActionEvent.ACTION, this);

		return hBoxTableView;
	}

	// 컬럼 크기를 구해 테이블 뷰 크기를 리 사이징 한다.
	public void autoResizeColumns(TableView<?> table){

	    //Set the right policy
	    table.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);
	    table.getColumns().stream().forEach((column) ->{

	        Text t = new Text(column.getText());
	        double max = t.getLayoutBounds().getWidth();
	        for(int i = 0; i<table.getItems().size(); i++){
	            //cell must not be empty
	            if (column.getCellData(i) != null){

	                t = new Text(column.getCellData(i).toString());
	                double calcwidth = t.getLayoutBounds().getWidth();
	                //remember new max-width
	                if (calcwidth > max){
	                    max = calcwidth;
	                }
	            }
	        }
	        //set the new max-widht with some extra space
	        column.setPrefWidth(max + 15.0d);
	    });
	}

	private HBox createHBoxButton()
	  {
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
	public static ChooseTableDialog showChooseTableDialog(Stage stageOwner, DownloadConnectionDialog dcd) {
		LOG.info("showChooseTableDialog");
		ChooseTableDialog ctd = new ChooseTableDialog(stageOwner, dcd);
		ctd.showAndWait(); // until it is closed
		return ctd;
	} /* showInfoDialog */

	public class TableListModel
	{
		public SimpleStringProperty	schemaName;
		public SimpleStringProperty	tableName;
		public BooleanProperty chooseTableFlag;

		public TableListModel(String schemaName, String tableName, boolean chooseTableFlag) {
			super();
			this.schemaName = new SimpleStringProperty(schemaName);
			this.tableName = new SimpleStringProperty(tableName);
			this.chooseTableFlag = new SimpleBooleanProperty(chooseTableFlag);
		}

		public String getSchemaName() {
			return schemaName.get();
		}
		public void setSchemaName(SimpleStringProperty schemaName) {
			this.schemaName = schemaName;
		}
		public String getTableName() {
			return tableName.get();
		}
		public void setTableName(SimpleStringProperty tableName) {
			this.tableName = tableName;
		}
		public boolean getChooseTableFlag() {
			return chooseTableFlag.get();
		}
		public void setChooseTableFlag(BooleanProperty chooseTableFlag) {
			this.chooseTableFlag = chooseTableFlag;
		}

	}
}
