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

import ch.admin.bar.siard2.gui.MainToolBar;
import ch.admin.bar.siard2.gui.SiardBundle;
import ch.admin.bar.siard2.gui.models.HistoryModel;
import ch.config.db.HistoryDAO;
import ch.enterag.utils.fx.FxSizes;
import ch.enterag.utils.fx.FxStyles;
import ch.enterag.utils.fx.ScrollableDialog;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
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
public class HistoryDialog extends ScrollableDialog implements EventHandler<ActionEvent> {

	// 최창근 추가 - 로그
	private static final Logger LOG = Logger.getLogger(HistoryDialog.class);
	private String uploadDownloadDivCode;
	private Stage stageOwner;

	private HistoryDialog(Stage stageOwner, String div) {
		super(stageOwner, (div.equals("0001") ? SiardBundle.getSiardBundle().getHistoryDownloadTitle() : SiardBundle.getSiardBundle().getHistoryUploadTitle()));
		this.stageOwner = stageOwner;

		uploadDownloadDivCode = div;

		LOG.info("HistoryDialog uploadDownloadDivCode " + div);

		double dMinWidth = FxSizes.getTextWidth(SiardBundle.getSiardBundle().getHistoryDownloadTitle()) + FxSizes.getCloseWidth() + dHSPACING;

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

	@SuppressWarnings("unchecked")
	private HBox createHBoxTableView() {

		LOG.info("createHBoxTableView");
		SiardBundle sb = SiardBundle.getSiardBundle();

		HBox hBoxTableView = new HBox();
		hBoxTableView.setPadding(new Insets(dINNER_PADDING));
		hBoxTableView.setSpacing(dHSPACING);

		TableView<HistoryModel> historyTableView = new TableView<HistoryModel>();
		List<TableColumn<HistoryModel, Object>> historyTableColumnList = createHistoryTableColumn();
		historyTableView.getColumns().addAll(historyTableColumnList);
		historyTableView.setEditable(true);

		try {
			HistoryDAO dao = new HistoryDAO();

			Map<String, String> params = new LinkedHashMap<String, String>();
			params.put("div", uploadDownloadDivCode);

			List<Map> resultList = dao.selectListHistory(params);

			for(int i=0; i<resultList.size(); i++) {
				// TODO text값 properties로 관리해야되지 않을까?
				HistoryModel historyModel = new HistoryModel();

				//보고서 출력용 HistoryModel
				HistoryModel historyModelPrintParam = new HistoryModel();
				historyModelPrintParam.fromMap(resultList.get(i));

				//프린터 버튼
				Button _colPrint = new Button();
				_colPrint.setGraphic(new ImageView(new Image(MainToolBar.class.getResourceAsStream("res/printer.jpg"))));
				_colPrint.setOnMouseClicked(new EventHandler<MouseEvent>() {
				    @Override
				    public void handle(MouseEvent event)
				    {
						if(event.getButton() == MouseButton.PRIMARY) {
							ReportPrintDialog.showReportPrintDialog(stageOwner, historyModelPrintParam);
						}
				    }
				});

				resultList.get(i).put("REPORT_PRINT", _colPrint);

				historyModel.fromMap(resultList.get(i));
				historyTableView.getItems().add(historyModel);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// HISTORY_IDX 컬럼 숨기기
		historyTableView.getColumns().get(0).setVisible(false);

		// 테이블 클릭 이벤트
		historyTableView.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub

				Object clickRowObject =  historyTableView.getSelectionModel().selectedItemProperty().get();
//				int clickRowIndex = historyTableView.getSelectionModel().selectedIndexProperty().get();

				//20200903 - 헤더를 더블클릭할 경우 널 포인트 에러 방지용
				if(clickRowObject == null) return;

				HistoryModel historyModel = (HistoryModel) clickRowObject;
//				System.out.println("history_idx : " + historyModel.getHistory_idx());
//				System.out.println("table row : " + clickRowIndex);

				if(event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
//					HistoryDetailDialog.showHistoryDetailDialog(stageOwner);
					HistoryDetailDialog.showHistoryDetailDialog(stageOwner, historyModel.getHistory_idx() + "");
				}
//				else {
//					historyTableView.getSelectionModel().clearSelection();
//				}

			}

		});

		// TODO text값 properties로 관리해야되지 않을까?
		historyTableView.setPlaceholder(new Label(sb.getListNoData()));

		hBoxTableView.getChildren().add(historyTableView);

		Callback<TableColumn<HistoryModel,Object>, TableCell<HistoryModel,Object>> WRAPPING_CELL_FACTORY =
                new Callback<TableColumn<HistoryModel,Object>, TableCell<HistoryModel,Object>>() {

            @Override public TableCell<HistoryModel,Object> call(TableColumn<HistoryModel,Object> param) {
                TableCell<HistoryModel,Object> tableCell = new TableCell<HistoryModel,Object>() {
                    @Override protected void updateItem(Object item, boolean empty) {
                    	if (item == getItem()) return;
                        super.updateItem(item, empty);

                        if (item == null) {
                            super.setText(null);
                            super.setGraphic(null);
                        } else {
                        	super.setText(null);
                        	Label l = new Label(item.toString());
                        	l.setWrapText(true);
                        	VBox box = new VBox(l);
                        	l.heightProperty().addListener((observable,oldValue,newValue)-> {
                        		box.setPrefHeight(newValue.doubleValue()+7);
                        		Platform.runLater(()->this.getTableRow().requestLayout());
                        	});
                        	super.setGraphic(box);
                        }
                    }
                };
    			return tableCell;
            }
        };

        int index = 0;
        for (TableColumn<HistoryModel, Object> tableColumn : historyTableColumnList) {

        	if(null == tableColumn.getCellData(index)) continue;

        	//버튼은 줄바꿈 하지 않음.
        	if(Button.class.getName().equals(tableColumn.getCellData(index).getClass().getName())) {
            	break;
            }
        	tableColumn.setCellFactory(WRAPPING_CELL_FACTORY);
        	historyTableView.getColumns().set(index, tableColumn);
        	index++;
		}

        //최창근 추가 - 테이블 크기별로 리사이징
 		autoResizeColumns(historyTableView);

 		HBox.setHgrow(historyTableView, Priority.ALWAYS);

		return hBoxTableView;
	}

	// 컬럼 크기를 구해 테이블 뷰 크기를 리 사이징 한다.
	public void autoResizeColumns(TableView<?> table){

	    //Set the right policy
	    table.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);
	    table.getColumns().stream().forEach((column) ->{
	        Text t = new Text(column.getText());
	        double max = t.getLayoutBounds().getWidth();
	        double buttonWidth = 70d;
	        for(int i = 0; i<table.getItems().size(); i++){
	            //cell must not be empty
	            if (column.getCellData(i) != null){

	                t = new Text(column.getCellData(i).toString());
	                double calcwidth = t.getLayoutBounds().getWidth();
	                //remember new max-width
	                if (calcwidth > max){
	                    max = calcwidth;
	                }

	                //버튼 컬럼 사이즈 및 정렬
	                if(Button.class.getName().equals(column.getCellData(i).getClass().getName())) {
	                	max = buttonWidth;
	                	column.setStyle("-fx-alignment:center;"); //가운데 정렬
	                }
	            }
	        }

	        //컬럼의 width는 최대 400d
	        if(max > 400d) {
	        	max = 400d;
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
//	public static void showHistoryDialog(Stage stageOwner) {
//		LOG.info("showHistoryDialog");
//		HistoryDialog hd = new HistoryDialog(stageOwner);
//		hd.showAndWait(); // until it is closed
//	} /* showInfoDialog */

	/*------------------------------------------------------------------*/
	/**
	 * show the modal info dialog.
	 *
	 * @param stageOwner owner window.
	 */
	public static void showHistoryDialog(Stage stageOwner, String div) {
		LOG.info("showHistoryDialog");
		HistoryDialog hd = new HistoryDialog(stageOwner, div);
		hd.showAndWait(); // until it is closed
	} /* showInfoDialog */


	private List<TableColumn<HistoryModel, Object>> createHistoryTableColumn() {
		List<TableColumn<HistoryModel, Object>> historyTableColumnList = new ArrayList<TableColumn<HistoryModel, Object>>();
		try {

			SiardBundle sb = SiardBundle.getSiardBundle();

			Class innerClass = Class.forName("ch.admin.bar.siard2.gui.models.HistoryModel");
			Field[] fields = innerClass.getDeclaredFields();
			for(int i=0, length=fields.length; i<length; i++) {
				fields[i].setAccessible(true);

	            if(javafx.beans.property.SimpleIntegerProperty.class.isAssignableFrom(fields[i].getType())
	            	|| javafx.beans.property.SimpleStringProperty.class.isAssignableFrom(fields[i].getType())
	            	|| Button.class.isAssignableFrom(fields[i].getType())) {

	            	// TODO 최창근 추가 - 테이블 컬럼명 property로 관리하자(변수명으로 컬럼명으로 나오고, 다국어 지원도 필요)
	            	String columnName = sb.getTableColumnName(fields[i].getName());
	            	historyTableColumnList.add(new TableColumn<HistoryModel, Object>(columnName.equals("") ? fields[i].getName() : columnName));
	            	historyTableColumnList.get(i).setCellValueFactory(new PropertyValueFactory<HistoryModel, Object>(fields[i].getName()));

//	            	historyTableColumnList.add(new TableColumn<HistoryModel, String>(fields[i].getName()));
//	            	historyTableColumnList.get(i).setCellValueFactory(new PropertyValueFactory<HistoryModel, String>(fields[i].getName()));
//		            	LOG.info("필드타입 : " + fields[i].getType());
//		            	LOG.info("필드명 : " + fields[i].getName());
	            }

	        }

		}catch(Exception e) {
			e.printStackTrace();
		}
		return historyTableColumnList;
	}

} /* class InfoDialog */
