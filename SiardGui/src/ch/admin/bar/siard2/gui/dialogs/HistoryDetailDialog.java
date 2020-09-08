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
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import ch.admin.bar.siard2.gui.SiardBundle;
import ch.admin.bar.siard2.gui.models.HistoryDetailModel;
import ch.config.db.HistoryDAO;
import ch.enterag.utils.fx.FxSizes;
import ch.enterag.utils.fx.FxStyles;
import ch.enterag.utils.fx.ScrollableDialog;
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
public class HistoryDetailDialog extends ScrollableDialog implements EventHandler<ActionEvent> {

	// 최창근 추가 - 로그
	private static final Logger LOG = Logger.getLogger(HistoryDetailDialog.class);

	private String history_idx;

	/**
	 * constructor
	 * @param stageOwner owner window.
	 */
//	private HistoryDetailDialog(Stage stageOwner) {
////		super(stageOwner, SiardBundle.getSiardBundle().getInfoTitle());
//		// TODO text값 properties로 관리해야되지 않을까?
//		super(stageOwner, "내역 타이틀 테스트");
//		LOG.info("HistoryDialog");
//
////		Label label = new Label();
//		// TODO text값 properties로 관리해야되지 않을까?
////		label.setText("내역_테스트중");
//
//		double dMinWidth = FxSizes.getTextWidth(SiardBundle.getSiardBundle().getInfoTitle()) + FxSizes.getCloseWidth() + dHSPACING;
//		LOG.info("1 dMinWidth " + dMinWidth);
//
//		VBox vboxDialog = createVBoxDialog();
//
//		if (dMinWidth < vboxDialog.getMinWidth()) {
//			dMinWidth = vboxDialog.getMinWidth();
//		}
//
//		setMinWidth(dMinWidth);
//		/* scene */
//		Scene scene = new Scene(vboxDialog);
//		setScene(scene);
//	}

	private HistoryDetailDialog(Stage stageOwner, String history_idx) {
//		super(stageOwner, SiardBundle.getSiardBundle().getInfoTitle());
		// TODO text값 properties로 관리해야되지 않을까?
		super(stageOwner, "내역 타이틀 테스트");

		this.history_idx = history_idx;

		LOG.info("HistoryDialog uploadDownloadDivCode " + history_idx);

//		Label label = new Label();
		// TODO text값 properties로 관리해야되지 않을까?
//		label.setText("내역_테스트중");

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
	public void handle(ActionEvent ae) {
		LOG.info("handle");

		close();
	} /* handle */

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

		TableView<HistoryDetailModel> historyDetailTableView = new TableView<HistoryDetailModel>();
		List<TableColumn<HistoryDetailModel, String>> historyTableColumnList = createHistoryDetailTableColumn();
		historyDetailTableView.getColumns().addAll(historyTableColumnList);
		historyDetailTableView.setEditable(true);

		try {
			HistoryDAO dao = new HistoryDAO();

			Map<String, String> params = new LinkedHashMap<String, String>();
			params.put("history_idx", history_idx);

			List<Map> resultList = dao.selectListHistoryDetail(params);

			for(int i=0; i<resultList.size(); i++) {
				// TODO text값 properties로 관리해야되지 않을까?
				HistoryDetailModel historyDetailModel = new HistoryDetailModel();
				historyDetailModel.fromMap(resultList.get(i));
				historyDetailTableView.getItems().add(historyDetailModel);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// HISTORY_DETAIL_IDX 컬럼 숨기기
		historyDetailTableView.getColumns().get(0).setVisible(false);
		// HISTORY_IDX 컬럼 숨기기
		historyDetailTableView.getColumns().get(1).setVisible(false);

		// TODO text값 properties로 관리해야되지 않을까?
		historyDetailTableView.setPlaceholder(new Label("데이터 없음"));

		hBoxTableView.getChildren().add(historyDetailTableView);

		// 최창근 추가 - 테이블 크기별로 리사이징
		autoResizeColumns(historyDetailTableView);

		HBox.setHgrow(historyDetailTableView, Priority.ALWAYS);

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
	    Button btnDefault = new Button(sb.getOk());
	    btnDefault.setDefaultButton(true);
	    btnDefault.setOnAction(this);

	    /* HBox for button */
	    HBox hboxButton = new HBox();
	    hboxButton.setPadding(new Insets(dINNER_PADDING));
	    hboxButton.setSpacing(dHSPACING);
	    hboxButton.setAlignment(Pos.TOP_RIGHT);
	    hboxButton.getChildren().add(btnDefault);
	    hboxButton.setMinWidth(FxSizes.getTextWidth(sb.getOk()));

	    return hboxButton;
	  } /* createHBoxButton */

	/*------------------------------------------------------------------*/
	/**
	 * show the modal info dialog.
	 *
	 * @param stageOwner owner window.
	 */
//	public static void showHistoryDetailDialog(Stage stageOwner) {
//		LOG.info("showHistoryDetailDialog");
//		HistoryDetailDialog hdd = new HistoryDetailDialog(stageOwner);
//		hdd.showAndWait(); // until it is closed
//	} /* showInfoDialog */


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
	public static void showHistoryDetailDialog(Stage stageOwner, String div) {
		LOG.info("showHistoryDetailDialog");
		HistoryDetailDialog hdd = new HistoryDetailDialog(stageOwner, div);
		hdd.showAndWait(); // until it is closed
	} /* showInfoDialog */
} /* class InfoDialog */
