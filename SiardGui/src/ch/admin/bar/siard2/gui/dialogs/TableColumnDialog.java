/*
 * ====================================================================== HistoryDialog displays
 * meta data of the program. Application : Siard2 Description : InfoDialog displays meta data of the
 * program. Platform : Java 7, JavaFX 2.2
 * ------------------------------------------------------------------------ Copyright : 2017, Enter
 * AG, Rüti ZH, Switzerland Created : 12.01.2017, Hartwig Thomas
 * ======================================================================
 */
package ch.admin.bar.siard2.gui.dialogs;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ch.admin.bar.siard2.cmd.SiardConnection;
import ch.admin.bar.siard2.gui.SiardBundle;
import ch.admin.bar.siard2.gui.models.ColumnModel;
import ch.admin.bar.siard2.gui.models.HistoryDetailModel;
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
import javafx.scene.control.Label;
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

/* ==================================================================== */
/**
 * HistoryDialog displays meta data of the program.
 *
 * @author Hartwig Thomas
 */
public class TableColumnDialog extends ScrollableDialog implements EventHandler<ActionEvent> {

	// 최창근 추가 - 로그
	private static final Logger LOG = Logger.getLogger(TableColumnDialog.class);

	private TableView<ColumnModel> _tvColumnList;

	protected TableModel tableModel;

	protected List<String> chooseColumnList;

	private Button _btnDefault;

	private TableColumnDialog(Stage stageOwner, TableModel tableModel) {
//		super(stageOwner, SiardBundle.getSiardBundle().getInfoTitle());

		// TODO text값 properties로 관리해야되지 않을까?
		super(stageOwner, "내역 타이틀 테스트");

		this.tableModel = tableModel;

		//TODO getHistoryTitle 로 변경해야함
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

		if (event.getSource() == _btnDefault) {
			SiardBundle sb = SiardBundle.getSiardBundle();

			if(getChooseColumnCount() < 1) {
				//TODO 최창근 추가 - 컬럼을 선택하라는 메시지 alert 추가 .properties로 메시지 관리
				LOG.info("선택한 컬럼 없음");
				MB.show(this, "제목", "내용", sb.getOk(), null);
				return;
			}

			getColumnListByChooseColumn();
		}

		close();
	} /* handle */

	private int getChooseColumnCount() {
		int count = 0;
		int size = _tvColumnList.getItems().size();
		for(int i=0; i<size; i++){
			if(_tvColumnList.getItems().get(i).getChooseColumnFlag()) {
				count++;
			}
    	}
		return count;
	}

	public List<?> getColumnListByChooseColumn(){
		int size = _tvColumnList.getItems().size();
		chooseColumnList = new ArrayList<String>();

		for(int i=0; i<size; i++){
			if(_tvColumnList.getItems().get(i).getChooseColumnFlag()) {
				LOG.info("선택 => " + _tvColumnList.getItems().get(i).getColumnType());

//				chooseTableList.add(_tvColumnList.getItems().get(i).getTableName());

				//TODO 최창근 추가 - siardcmd 에서 스키마.테이블명 구현되면 바꾸기
				chooseColumnList.add(_tvColumnList.getItems().get(i).getColumnType() + "." +_tvColumnList.getItems().get(i).getColumnName());
			}
    	}

		LOG.info(chooseColumnList.toString());

		return chooseColumnList;
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

		_tvColumnList = new TableView<ColumnModel>();

		//TODO 최창근 추가 - 스키마,테이블,선택 properties에서 key=value로 관리(다국어 지원을 위한)
		TableColumn<ColumnModel, String> columnName = new TableColumn<ColumnModel, String>("컬럼명");
		TableColumn<ColumnModel, String> columnType = new TableColumn<ColumnModel, String>("컬럼타입");
		TableColumn<ColumnModel, Boolean> chooseColumnFlag = new TableColumn<ColumnModel, Boolean>("선택");

		columnName.setCellValueFactory(new PropertyValueFactory<ColumnModel, String>("columnType"));
		columnType.setCellValueFactory(new PropertyValueFactory<ColumnModel, String>("columnName"));
		chooseColumnFlag.setCellValueFactory(new PropertyValueFactory<ColumnModel, Boolean>("chooseColumnFlag"));
		chooseColumnFlag.setCellFactory(CheckBoxTableCell.forTableColumn(chooseColumnFlag));

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
			conn = DriverManager.getConnection(tableModel.getConnectionUrl(), tableModel.getUser(),  tableModel.getPassword());
			conn.setAutoCommit(false);

			ResultSet rs = conn.getMetaData().getColumns(null, tableModel.getSchemaName(), tableModel.getTableName(), "%");
			while (rs.next()) {
				_tvColumnList.getItems().add(new ColumnModel(tableModel.getSchemaName(), tableModel.getTableName(), rs.getString("COLUMN_NAME"), rs.getString("TYPE_NAME"), false));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

		hBoxTableView.getChildren().add(_tvColumnList);

		// 최창근 추가 - 테이블 크기별로 리사이징
		autoResizeColumns(_tvColumnList);

		HBox.setHgrow(_tvColumnList, Priority.ALWAYS);

		return hBoxTableView;
	}

	// 컬럼 크기를 구해 테이블 뷰 크기를 리 사이징 한다.
	public void autoResizeColumns(TableView<?> tableView){

	    //Set the right policy
		tableView.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);
		tableView.getColumns().stream().forEach((column) ->{

	        Text t = new Text(column.getText());
	        double max = t.getLayoutBounds().getWidth();
	        for(int i = 0; i<tableView.getItems().size(); i++){
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

	/*------------------------------------------------------------------*/
	  /** create the HBox with the OK button.
	   * @return HBox with OK button.
	   */
	  private HBox createHBoxButton()
	  {
	    SiardBundle sb = SiardBundle.getSiardBundle();

	    /* default button */
	    _btnDefault = new Button(sb.getOk());
	    _btnDefault.setDefaultButton(true);
	    _btnDefault.setOnAction(this);

	    /* HBox for button */
	    HBox hboxButton = new HBox();
	    hboxButton.setPadding(new Insets(dINNER_PADDING));
	    hboxButton.setSpacing(dHSPACING);
	    hboxButton.setAlignment(Pos.TOP_RIGHT);
	    hboxButton.getChildren().add(_btnDefault);
	    hboxButton.setMinWidth(FxSizes.getTextWidth(sb.getOk()));

	    return hboxButton;
	  } /* createHBoxButton */

	private List<TableColumn<HistoryDetailModel, String>> createHistoryDetailTableColumn() {
		List<TableColumn<HistoryDetailModel, String>> historyTableColumnList = new ArrayList<TableColumn<HistoryDetailModel, String>>();
		try {

			SiardBundle sb = SiardBundle.getSiardBundle();

			Class innerClass = Class.forName("ch.admin.bar.siard2.gui.models.HistoryDetailModel");
			Field[] fields = innerClass.getDeclaredFields();
			for(int i=0, length=fields.length; i<length; i++) {
				fields[i].setAccessible(true);

	            if(javafx.beans.property.SimpleIntegerProperty.class.isAssignableFrom(fields[i].getType())
	            	|| javafx.beans.property.SimpleStringProperty.class.isAssignableFrom(fields[i].getType())) {
	            	// TODO 최창근 추가 - 테이블 컬럼명 property로 관리하자(변수명으로 컬럼명으로 나오고, 다국어 지원도 필요)
	            	String columnName = sb.getTableColumnName(fields[i].getName());
	            	historyTableColumnList.add(new TableColumn<HistoryDetailModel, String>(columnName.equals("") ? fields[i].getName() : columnName));
	            	historyTableColumnList.get(i).setCellValueFactory(new PropertyValueFactory<HistoryDetailModel, String>(fields[i].getName()));

//	            	historyTableColumnList.add(new TableColumn<HistoryDetailModel, String>(fields[i].getName()));
//	            	historyTableColumnList.get(i).setCellValueFactory(new PropertyValueFactory<HistoryDetailModel, String>(fields[i].getName()));
//		            	LOG.info("필드타입 : " + fields[i].getType());
//		            	LOG.info("필드명 : " + fields[i].getName());
	            }

	        }

		}catch(Exception e) {
			e.printStackTrace();
		}
		return historyTableColumnList;
	}

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
