/*
 * ====================================================================== HistoryDialog displays
 * meta data of the program. Application : Siard2 Description : InfoDialog displays meta data of the
 * program. Platform : Java 7, JavaFX 2.2
 * ------------------------------------------------------------------------ Copyright : 2017, Enter
 * AG, Rüti ZH, Switzerland Created : 12.01.2017, Hartwig Thomas
 * ======================================================================
 */
package ch.admin.bar.siard2.gui.dialogs;

import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import ch.admin.bar.siard2.gui.MainToolBar;
import ch.admin.bar.siard2.gui.SiardBundle;
import ch.admin.bar.siard2.gui.browser.BrowserRegion;
import ch.admin.bar.siard2.gui.models.HistoryDetailModel;
import ch.admin.bar.siard2.gui.models.HistoryModel;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/* ==================================================================== */
/**
 * HistoryDialog displays meta data of the program.
 *
 * @author Hartwig Thomas
 */
public class ReportPrintDialog extends ScrollableDialog implements EventHandler<ActionEvent> {

	private static final Logger LOG = Logger.getLogger(ReportPrintDialog.class);

	public static final int iRESULT_CANCELED = 0;
	public static final int iRESULT_SUCCESS = 1;
	protected int _iResult = iRESULT_CANCELED;
	public int getResult() { return _iResult; }

	protected HistoryModel historyModel;

	private Button _btnDefault;
	private Button _btnCancel;

	private BrowserRegion br;

	private ReportPrintDialog(Stage stageOwner, HistoryModel historyModel) {
		// super(stageOwner, SiardBundle.getSiardBundle().getInfoTitle());

		// TODO text값 properties로 관리해야되지 않을까?
		super(stageOwner, "보고서 출력");

		this.historyModel = historyModel;

		// TODO getColumnTitle 로 변경해야함
		double dMinWidth = FxSizes.getTextWidth(SiardBundle.getSiardBundle().getInfoTitle()) + FxSizes.getCloseWidth() + dHSPACING;

		VBox vboxDialog = createVBoxDialog(stageOwner);

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
//		SiardBundle sb = SiardBundle.getSiardBundle();

		if (event.getSource() == _btnCancel) {
			close();

		} else if (event.getSource() == _btnDefault) {

//			setColumnListByChooseColumn();

			_iResult = iRESULT_SUCCESS;

			close();

		}
	} /* handle */

	/*------------------------------------------------------------------*/
	/**
	 * create the main VBox of the dialog
	 *
	 * @return main VBox
	 */
	private VBox createVBoxDialog(Stage stageOwner)
	{
		VBox vbox = new VBox();
		vbox.setPadding(new Insets(dOUTER_PADDING));
		vbox.setSpacing(dVSPACING);
		vbox.setStyle(FxStyles.sSTYLE_BACKGROUND_LIGHTGREY);
//		double dMinWidth = 0.0;
		/* browser region with HTML */
		br = createBrowserRegion(stageOwner);
//		if (dMinWidth < br.getPrefWidth())
//			dMinWidth = br.getPrefWidth();
		VBox.setVgrow(br, Priority.ALWAYS); /* Intradigm */
		vbox.getChildren().add(br);
		/* HBox with save XML, save HTML and OK button */
		HBox hbox = createHBoxButtons(stageOwner);
//		if (dMinWidth < hbox.getMinWidth())
//			dMinWidth = hbox.getMinWidth();
		/* three buttons: save XML, save HTML, Cancel */
		vbox.getChildren().add(hbox);
//		vbox.setMinWidth(dMinWidth);
		return vbox;
	} /* createVBoxDialog */

	/**
	 * create a browser region and display meta data HTML in it.
	 *
	 * @return browser region.
	 */
	private BrowserRegion createBrowserRegion(Stage stageOwner)
	{
		URL rdrHtmlUrl = MainToolBar.class.getResource("res/reportPrint.html");

		BrowserRegion br = BrowserRegion.newBrowserRegion_reportPrint(stageOwner, rdrHtmlUrl, setHistoryModelConvertToJsonString());

		br.setPrefSize(0.4 * FxSizes.getScreenBounds().getWidth(), 0.8 * FxSizes.getScreenBounds().getHeight()); /* IntraDIGM */
		br.setPadding(new Insets(dOUTER_PADDING));
		br.setStyle(FxStyles.sSTYLE_BACKGROUND_LIGHTGREY);
		return br;
	} /* createBrowserRegion */

	/**
	 * create the HBox with the OK button.
	 *
	 * @return HBox with OK button.
	 */
	private HBox createHBoxButtons(Stage stageOwner)
	{
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(dINNER_PADDING));
		hbox.setSpacing(dHSPACING);
		hbox.setAlignment(Pos.TOP_RIGHT);
		SiardBundle sb = SiardBundle.getSiardBundle();

		//웹뷰 프린트 사용으로 해당 기능 제거.
//		printSetupButton = new Button("인쇄");
//		printSetupButton.setOnAction(new EventHandler <ActionEvent>()
//		{
//            public void handle(ActionEvent event)
//            {
//            	pageSetup(br, stageOwner);
//            }
//        });
//		hbox.getChildren().add(printSetupButton);

		/* OK button */
		_btnDefault = new Button(sb.getOk());
		_btnDefault.setDefaultButton(true);
		_btnDefault.setOnAction(this);
		hbox.getChildren().add(_btnDefault);

		return hbox;
	} /* createHBoxButtons */

//	private void pageSetup(Node node, Stage owner)
//	{
//		// Create the PrinterJob
//		PrinterJob job = PrinterJob.createPrinterJob();
//
//		if (job == null)
//		{
//			return;
//		}
//
//		// Show the page setup dialog
//		boolean proceed = job.showPrintDialog(owner);
//
//		if (proceed)
//		{
//			print(job, node);
//		}
//	}
//
//	private void print(PrinterJob job, Node node)
//	{
//		// Set the Job Status Message
//		jobStatus.textProperty().bind(job.jobStatusProperty().asString());
//
//		// Print the node
//		boolean printed = job.printPage(node);
//
//		if (printed)
//		{
//			job.endJob();
//		}
//	}

	/*------------------------------------------------------------------*/
	/**
	 * show the modal history detail dialog.
	 *
	 * @param stageOwner owner window.
	 */
	public static ReportPrintDialog showReportPrintDialog(Stage stageOwner, HistoryModel historyModel) {
		ReportPrintDialog rpd = new ReportPrintDialog(stageOwner, historyModel);
		rpd.showAndWait(); // until it is closed
		return rpd;
	} /* showInfoDialog */

	//historyModel 데이터를 json형식의 String으로 변환(보고서 출력 웹뷰 연동용)
	@SuppressWarnings("rawtypes")
	private String setHistoryModelConvertToJsonString() {
		 StringBuffer jsonBuf = new StringBuffer();
	      jsonBuf.append("var jsonObj=[");
	  	  jsonBuf.append("{");
	  	  jsonBuf.append("dbConUrl:\""+historyModel.getDb_con_url()+"\"");
	  	  jsonBuf.append(",dbName:\""+historyModel.getDb_name().replaceAll("\n", "\\n").replaceAll("\r", "\\r")+"\"");
	  	  jsonBuf.append(",executeDiv:\""+historyModel.getDiv()+"\"");
	  	  jsonBuf.append(",executeDate:\""+historyModel.getExecute_date()+"\"");
	  	  jsonBuf.append(",executeResult:\""+historyModel.getExecute_result()+"\"");
	  	  jsonBuf.append(",schemaName:\""+historyModel.getSchema_name()+"\"");
	  	  jsonBuf.append(",tableCount:\""+historyModel.getTable_count()+"\"");

	  	  //이력 상세
	  	  StringBuilder sbHistoryDetail = new StringBuilder();
	      try {
				HistoryDAO dao = new HistoryDAO();

				Map<String, String> params = new LinkedHashMap<String, String>();
				params.put("history_idx", String.valueOf(historyModel.getHistory_idx()));

				List<Map> resultList = dao.selectListHistoryDetail(params);

				sbHistoryDetail.append("<table style='width: 100%; border: 1px; border-color: black; border-style: solid;' border='1'>");
				sbHistoryDetail.append("<colgroup>");
				sbHistoryDetail.append("	<col width='60%' />");
				sbHistoryDetail.append("	<col width='20%' />");
				sbHistoryDetail.append("	<col width='20%' />");
				sbHistoryDetail.append("</colgroup>");
				sbHistoryDetail.append("<tr>");
				sbHistoryDetail.append("<th>테이블명</th>");
				sbHistoryDetail.append("<th>테이블 컬럼 수</th>");
				sbHistoryDetail.append("<th>테이블 레코드 수</th>");
				sbHistoryDetail.append("</tr>");

				for(int i=0; i<resultList.size(); i++) {
					HistoryDetailModel historyDetailModel = new HistoryDetailModel();
					historyDetailModel.fromMap(resultList.get(i));

					sbHistoryDetail.append("<tr>");
					sbHistoryDetail.append("<td align='left'>"+historyDetailModel.getTable_name()+"</td>");
					sbHistoryDetail.append("<td align='right'>"+historyDetailModel.getTable_column_count()+"</td>");
					sbHistoryDetail.append("<td align='right'>"+historyDetailModel.getTable_record_count()+"</td>");
					sbHistoryDetail.append("</tr>");
				}

				sbHistoryDetail.append("</table>");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	      jsonBuf.append(",historyDetailTable:\""+sbHistoryDetail.toString()+"\"");
	  	  jsonBuf.append("}");
	      jsonBuf.append("]");

	      return jsonBuf.toString();
	}

} /* class InfoDialog */