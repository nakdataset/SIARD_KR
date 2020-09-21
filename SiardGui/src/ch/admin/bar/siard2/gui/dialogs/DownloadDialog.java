/*
 * =========================================================================== DownloadDialog for
 * downloading a database to a SIARD archive. Application : Siard2 Description : DownloadDialog for
 * downloading a database to a SIARD archive. Platform : Java 7, JavaFX 2.2
 * --------------------------------------------------------------------------- Copyright : Swiss
 * Federal Archives, Berne, Switzerland, 2017 Created : 27.06.2017, Hartwig Thomas, Enter AG, Rüti
 * ZH ===========================================================================
 */
package ch.admin.bar.siard2.gui.dialogs;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

import org.apache.log4j.Logger;

import ch.admin.bar.siard2.api.Archive;
import ch.admin.bar.siard2.gui.SiardBundle;
import ch.admin.bar.siard2.gui.tasks.DownloadTask;
import ch.enterag.utils.fx.FxSizes;
import ch.enterag.utils.logging.IndentLogger;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/* ==================================================================== */
/**
 * DownloadDialog for downloading a database to a SIARD archive.
 *
 * @author Hartwig Thomas
 */
public class DownloadDialog
	extends LoadDialog
{
	/** logger */
	private static IndentLogger _il = IndentLogger.getIndentLogger(DownloadDialog.class.getName());

	private static final Logger LOG = Logger.getLogger(DownloadDialog.class);

	// download task
	private DownloadTask _dt = null;

	// 검증 진행 여부
	boolean verify_process = false;

	public boolean getVerify()
	{
		return verify_process;
	}

	/* ================================================================== */
	private class WorkerStateEventHandler
		implements EventHandler<WorkerStateEvent>
	{
		@Override
		public void handle(WorkerStateEvent wse)
		{
			_btnCancel.setDisable(true);
			DownloadTask dt = (DownloadTask) wse.getSource();
			SiardBundle sb = SiardBundle.getSiardBundle();
			String sMessage = null;

//			String execute_result = "";
			if (wse.getEventType() == WorkerStateEvent.WORKER_STATE_SUCCEEDED) {
				sMessage = sb.getDownloadSuccessMessage();
				_bSuccess = true;
//				execute_result = "1";

			} else if (wse.getEventType() == WorkerStateEvent.WORKER_STATE_CANCELLED) {
				sMessage = sb.getDownloadCanceledMessage();
//				execute_result = "0";

			} else if (wse.getEventType() == WorkerStateEvent.WORKER_STATE_FAILED) {
				sMessage = sb.getDownloadFailureMessage(dt.getException());
				System.err.println(sMessage);
//				execute_result = "0";
			}

//			try {
//				HistoryDAO dao = new HistoryDAO();
//				String history_idx = "";
//				Map<String, String> params = null;
//				for (int i = 0, schemaSize = dt.getArchive().getMetaData().getMetaSchemas(); i < schemaSize; i++) {
//					params = new LinkedHashMap<String, String>();
//					history_idx = dao.selectMaxHistoryIdx();
//					params.put("history_idx", history_idx);
//					params.put("div", "0001");
//					params.put("db_name", dt.getArchive().getMetaData().getDatabaseProduct());
//					params.put("db_con_url", dt.getArchive().getMetaData().getConnection());
//					params.put("schema_name", dt.getArchive().getMetaData().getMetaSchema(i) + "");
//					params.put("table_count", dt.getArchive().getMetaData().getMetaSchema(i).getMetaTables() + "");
//					params.put("execute_result", execute_result);
//					dao.insertHistory(params);
//
//					for (int j = 0, tableSize = dt.getArchive().getMetaData().getMetaSchema(i).getMetaTables(); j < tableSize; j++) {
//						params = new LinkedHashMap<String, String>();
//						params.put("history_idx", history_idx);
//						params.put("table_name", dt.getArchive().getMetaData().getMetaSchema(i).getMetaTable(j) + "");
//						params.put("table_column_count", dt.getArchive().getMetaData().getMetaSchema(i).getMetaTable(j).getMetaColumns() + "");
//						params.put("table_record_count", dt.getArchive().getMetaData().getMetaSchema(i).getMetaTable(j).getRows() + "");
//						dao.insertHistoryDetail(params);
//					}
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}

			_tfMessage.setText(sMessage);
			_btnDefault.setDisable(false);
		}
	}

	/* ================================================================== */
	WorkerStateEventHandler _wseh = new WorkerStateEventHandler();

	/* ================================================================== */
	private class ActionEventHandler
		implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent ae)
		{
			if (ae.getSource() == _btnCancel) {
				_dt.cancel();
				_btnCancel.setDisable(true);

			} else if (ae.getSource() == _btnDefault) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("검증");
				alert.setHeaderText("SIARD 파일 검증");
				alert.setContentText("다운로드한 SIARD 파일을 검증하시겠습니까?");
				Optional<ButtonType> result = alert.showAndWait();

				if (result.get() == ButtonType.OK) {
					verify_process = true;
				} else {
					verify_process = false;
				}

				close();
			}
		}
	} /* ActionEventHandler */
	/* ================================================================== */

	private ActionEventHandler _aeh = null;

	/*------------------------------------------------------------------*/
	/** {@inheritDoc} */
	@Override
	protected EventHandler<ActionEvent> getActionEventHandler()
	{
		if (_aeh == null)
			_aeh = new ActionEventHandler();
		return _aeh;
	}; /* getActionEventHandler */

	/*------------------------------------------------------------------*/
	/**
	 * create the parameters VBox at the top of the dialog
	 *
	 * @param conn database connection.
	 * @param fileArchive SIARD archive to be written.
	 * @param bMetaDataOnly true, if only meta data are to be downloaded.
	 * @param bViewsAsTables true, if views are to be downloaded as tables.
	 * @return new parameters VBox at the top of the dialog.
	 */
	@Override
	protected VBox createVBoxParameters(Connection conn, Archive archive,
		boolean bMetaDataOnly, boolean bViewsAsTables)
	{
		SiardBundle sb = SiardBundle.getSiardBundle();
		VBox vbox = new VBox();
		vbox.setPadding(new Insets(dINNER_PADDING));
		vbox.setSpacing(dVSPACING / 2);
		double dLabelWidth = 0.0;
		Label lblConnectionLabel = createLabelWithColon(sb.getDownloadConnectionLabel());
		if (dLabelWidth < lblConnectionLabel.getPrefWidth())
			dLabelWidth = lblConnectionLabel.getPrefWidth();
		Label lblArchiveLabel = createLabelWithColon(sb.getDownloadArchiveLabel());
		if (dLabelWidth < lblArchiveLabel.getPrefWidth())
			dLabelWidth = lblArchiveLabel.getPrefWidth();
		Label lblMetaDataOnlyLabel = createLabelWithColon(sb.getDownloadExtentLabel());
		if (dLabelWidth < lblMetaDataOnlyLabel.getPrefWidth())
			dLabelWidth = lblMetaDataOnlyLabel.getPrefWidth();
		Label lblViewsAsTablesLabel = createLabelWithColon(sb.getDownloadViewsLabel());
		if (dLabelWidth < lblViewsAsTablesLabel.getPrefWidth())
			dLabelWidth = lblViewsAsTablesLabel.getPrefWidth();
		lblConnectionLabel.setMinWidth(dLabelWidth);
		lblConnectionLabel.setPrefWidth(dLabelWidth);
		lblArchiveLabel.setMinWidth(dLabelWidth);
		lblArchiveLabel.setPrefWidth(dLabelWidth);
		lblMetaDataOnlyLabel.setMinWidth(dLabelWidth);
		lblMetaDataOnlyLabel.setPrefWidth(dLabelWidth);
		lblViewsAsTablesLabel.setMinWidth(dLabelWidth);
		lblViewsAsTablesLabel.setPrefWidth(dLabelWidth);
		String sConnectionUrl = "";
		try {
			sConnectionUrl = conn.getMetaData().getURL();
		} catch (SQLException se) {
		}
		double dMaxWidth = FxSizes.getScreenBounds().getWidth() / 2.0;
		Label lblConnection = createLabel(sConnectionUrl, dMaxWidth);
		Label lblArchive = createLabel(archive.getFile().getAbsolutePath(), dMaxWidth);
		Label lblMetaDataOnly = createLabel(bMetaDataOnly ? sb.getDownloadExtentMetaDataOnly() : sb.getDownloadExtentFullDatabase(),
			dMaxWidth);
		Label lblViewsAsTables = createLabel(bViewsAsTables ? sb.getDownloadViewsAsTables() : sb.getDownloadViewsAsViews(),
			dMaxWidth);
		double dMinWidth = 0.0;
		HBox hboxConnection = createParameterHBox(lblConnectionLabel, lblConnection);
		if (dMinWidth < hboxConnection.getMinWidth())
			dMinWidth = hboxConnection.getMinWidth();
		vbox.getChildren().add(hboxConnection);
		HBox hboxArchive = createParameterHBox(lblArchiveLabel, lblArchive);
		if (dMinWidth < hboxArchive.getMinWidth())
			dMinWidth = hboxArchive.getMinWidth();
		vbox.getChildren().add(hboxArchive);
		HBox hboxMetaDataOnly = createParameterHBox(lblMetaDataOnlyLabel, lblMetaDataOnly);
		if (dMinWidth < hboxMetaDataOnly.getMinWidth())
			dMinWidth = hboxMetaDataOnly.getMinWidth();
		vbox.getChildren().add(hboxMetaDataOnly);
		HBox hboxViewsAsTables = createParameterHBox(lblViewsAsTablesLabel, lblViewsAsTables);
		if (dMinWidth < hboxViewsAsTables.getMinWidth())
			dMinWidth = hboxViewsAsTables.getMinWidth();
		vbox.getChildren().add(hboxViewsAsTables);
		vbox.setMinWidth(dMinWidth);
		return vbox;
	} /* createVBoxParameters */

	/*------------------------------------------------------------------*/
	/**
	 * display the connection dialog.
	 *
	 * @param stageOwner owner window.
	 * @param conn database connection.
	 * @param archive SIARD archive to be written.
	 * @param bMetaDataOnly true, if only meta data are to be downloaded.
	 * @param bViewsAsTables true, if views are to be downloaded as tables.
	 */
	private DownloadDialog(Stage stageOwner, Connection conn, Archive archive,
		boolean bMetaDataOnly, boolean bViewsAsTables)
	{
		super(stageOwner, conn, archive, bMetaDataOnly, bViewsAsTables, SiardBundle.getSiardBundle().getDownloadTitle());

		_dt = DownloadTask.startDownloadTask(conn, archive, bMetaDataOnly, bViewsAsTables, _pb.progressProperty(), _wseh);
	} /* constructor DownloadDialog */

	/*------------------------------------------------------------------*/
	/**
	 * show connection dialog and save entered values.
	 *
	 * @param stageOwner owner window.
	 * @param conn database connection.
	 * @param archive SIARD archive to be written.
	 * @param bMetaDataOnly true, if only meta data are to be downloaded.
	 * @param bViewsAsTables true, if views are to be downloaded as tables.
	 * @return download result.
	 */
	public static DownloadDialog showDownloadDialog(Stage stageOwner,
		Connection conn, Archive archive,
		boolean bMetaDataOnly, boolean bViewsAsTables)
	{
		_il.enter(conn, archive, String.valueOf(bMetaDataOnly));
		DownloadDialog dd = new DownloadDialog(stageOwner, conn, archive, bMetaDataOnly, bViewsAsTables);
		dd.setResizable(false); /* IntraDIGM */
		dd.showAndWait();
		System.setOut(dd._psOut);
		System.setErr(dd._psErr);
		_il.exit(dd);
		return dd;
	} /* showConnectionDialog */

} /* DownloadDialog */
