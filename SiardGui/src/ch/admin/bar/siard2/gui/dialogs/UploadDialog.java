/*
 * ========================================================================= 
 * UploadDialog for uploading a database from a SIARD archive. 
 * Application : Siard2 
 * Description : UploadDialog for uploading a database from a SIARD archive. 
 * Platform : Java 7, JavaFX 2.2
 * ------------------------------------------------------------------------- 
 * Copyright : Swiss Federal Archives, Berne, Switzerland, 2017 
 * Created : 29.06.2017, Hartwig Thomas, Enter AG, Rüti ZH 
 * =========================================================================
 */
package ch.admin.bar.siard2.gui.dialogs;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import ch.admin.bar.siard2.api.Archive;
import ch.admin.bar.siard2.api.MetaData;
import ch.admin.bar.siard2.api.MetaSchema;
import ch.admin.bar.siard2.cmd.MetaDataToDb;
import ch.admin.bar.siard2.gui.SiardBundle;
import ch.admin.bar.siard2.gui.tasks.UploadTask;
import ch.config.db.HistoryDAO;
import ch.enterag.utils.EU;
import ch.enterag.utils.fx.FxSizes;
import ch.enterag.utils.logging.IndentLogger;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/* ==================================================================== */
/**
 * UploadDialog for uploading a database from a SIARD archive.
 * 
 * @author Hartwig Thomas
 */
public class UploadDialog
	extends LoadDialog
{
	/** logger */
	private static IndentLogger _il = IndentLogger.getIndentLogger(UploadDialog.class.getName());

	// 최창근 추가 - 로그
	private static final Logger LOG = Logger.getLogger(UploadDialog.class);

	// upload task
	private UploadTask _ut = null;

	/* ================================================================== */
	private class WorkerStateEventHandler
		implements EventHandler<WorkerStateEvent>
	{
		@Override
		public void handle(WorkerStateEvent wse)
		{
			LOG.info("Upload.call.callback");

			_btnCancel.setDisable(true);
			UploadTask ut = (UploadTask) wse.getSource();
			SiardBundle sb = SiardBundle.getSiardBundle();
			String sMessage = null;

			LOG.info("wse.getEventType() " + wse.getEventType());
			// TODO 최창근 추가 - 재현 결과
			String execute_result = "";
			if (wse.getEventType() == WorkerStateEvent.WORKER_STATE_SUCCEEDED) {
				sMessage = sb.getUploadSuccessMessage();
				_bSuccess = true;
				execute_result = "1";

			} else if (wse.getEventType() == WorkerStateEvent.WORKER_STATE_CANCELLED) {
				sMessage = sb.getUploadCanceledMessage();
				execute_result = "0";

			} else if (wse.getEventType() == WorkerStateEvent.WORKER_STATE_FAILED) {
				sMessage = sb.getUploadFailureMessage(ut.getException());
				execute_result = "0";

			}

			try {
				HistoryDAO dao = new HistoryDAO();
				String history_idx = "";
				Map<String, String> params = null;
				for (int i = 0, schemaSize = ut.getArchive().getMetaData().getMetaSchemas(); i < schemaSize; i++) {
					params = new LinkedHashMap<String, String>();
					history_idx = dao.selectMaxHistoryIdx();
					params.put("history_idx", history_idx);
					params.put("div", "0002");
					params.put("db_name", ut.getArchive().getMetaData().getDatabaseProduct());
					params.put("db_con_url", ut.getArchive().getMetaData().getConnection());
					params.put("schema_name", ut.getArchive().getMetaData().getMetaSchema(i) + "");
					params.put("table_count", ut.getArchive().getMetaData().getMetaSchema(i).getMetaTables() + "");
					params.put("execute_result", execute_result);
					dao.insertHistory(params);

					for (int j = 0, tableSize = ut.getArchive().getMetaData().getMetaSchema(i).getMetaTables(); j < tableSize; j++) {
						params = new LinkedHashMap<String, String>();
						params.put("history_idx", history_idx);
						params.put("table_name", ut.getArchive().getMetaData().getMetaSchema(i).getMetaTable(j) + "");
						params.put("table_column_count", ut.getArchive().getMetaData().getMetaSchema(i).getMetaTable(j).getMetaColumns() + "");
						params.put("table_record_count", ut.getArchive().getMetaData().getMetaSchema(i).getMetaTable(j).getRows() + "");
						dao.insertHistoryDetail(params);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			_tfMessage.setText(sMessage);

			if (!_bSuccess) {
				try {
					ut.getConnection().rollback();
				} catch (SQLException se) {
					System.err.println(EU.getExceptionMessage(se));
				}
			}

			_btnDefault.setDisable(false);
		}
	}

	private WorkerStateEventHandler _wseh = new WorkerStateEventHandler();

	/* ================================================================== */
	private class ActionEventHandler
		implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent ae)
		{
			if (ae.getSource() == _btnCancel) {
				_ut.cancel();
				_btnCancel.setDisable(true);
			} else if (ae.getSource() == _btnDefault)
				close();
		}
	} /* ActionEventHandler */

	private ActionEventHandler _aeh = new ActionEventHandler();

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
	 * @param archive SIARD archive to be uploaded.
	 * @param conn target database connection.
	 * @param bMetaDataOnly true, if only schema is to be created.
	 * @return new parameters VBox at the top of the dialog.
	 */
	@Override
	protected VBox createVBoxParameters(Connection conn, Archive archive,
		boolean bMetaDataOnly, boolean bViewsAsLabels)
	{
		SiardBundle sb = SiardBundle.getSiardBundle();
		VBox vbox = new VBox();
		vbox.setPadding(new Insets(dINNER_PADDING));
		vbox.setSpacing(dVSPACING / 2);
		double dLabelWidth = 0.0;

		Label lblArchiveLabel = createLabelWithColon(sb.getUploadArchiveLabel());
		lblArchiveLabel.setPrefWidth(FxSizes.getTextWidth(lblArchiveLabel.getText()));
		if (dLabelWidth < lblArchiveLabel.getPrefWidth())
			dLabelWidth = lblArchiveLabel.getPrefWidth();

		Label lblConnectionLabel = createLabelWithColon(sb.getUploadConnectionLabel());
		if (dLabelWidth < lblConnectionLabel.getPrefWidth())
			dLabelWidth = lblConnectionLabel.getPrefWidth();

		Label lblMetaDataOnlyLabel = createLabelWithColon(sb.getUploadExtentLabel());
		if (dLabelWidth < lblMetaDataOnlyLabel.getPrefWidth())
			dLabelWidth = lblMetaDataOnlyLabel.getPrefWidth();

		lblArchiveLabel.setPrefWidth(dLabelWidth);
		lblConnectionLabel.setPrefWidth(dLabelWidth);
		lblMetaDataOnlyLabel.setPrefWidth(dLabelWidth);

		double dMaxWidth = FxSizes.getScreenBounds().getWidth() / 2.0;
		Label lblArchive = createLabel(archive.getFile().getAbsolutePath(), dMaxWidth);
		String sConnectionUrl = "";
		try {
			sConnectionUrl = conn.getMetaData().getURL();
		} catch (SQLException se) {
		}
		Label lblConnection = createLabel(sConnectionUrl, dMaxWidth);
		Label lblMetaDataOnly = createLabel(bMetaDataOnly ? sb.getUploadExtentMetaDataOnly() : sb.getUploadExtentFullDatabase(), dMaxWidth);

		double dMinWidth = 0.0;

		HBox hboxArchive = createParameterHBox(lblArchiveLabel, lblArchive);
		if (dMinWidth < hboxArchive.getMinWidth())
			dMinWidth = hboxArchive.getMinWidth();
		vbox.getChildren().add(hboxArchive);

		HBox hboxConnection = createParameterHBox(lblConnectionLabel, lblConnection);
		if (dMinWidth < hboxConnection.getMinWidth())
			dMinWidth = hboxConnection.getMinWidth();
		vbox.getChildren().add(hboxConnection);

		HBox hboxMetaDataOnly = createParameterHBox(lblMetaDataOnlyLabel, lblMetaDataOnly);
		if (dMinWidth < hboxMetaDataOnly.getMinWidth())
			dMinWidth = hboxMetaDataOnly.getMinWidth();
		vbox.getChildren().add(hboxMetaDataOnly);
		vbox.setMinWidth(dMinWidth);
		return vbox;
	} /* createVBoxParameters */

	/*------------------------------------------------------------------*/
	/**
	 * display the upload dialog.
	 * 
	 * @param stageOwner owner window.
	 * @param archive SIARD archive to be uploaded.
	 * @param conn database connection.
	 * @param bMetaDataOnly true, if only the schema is to be created.
	 * @param mdtd MetaDataToDb instance.
	 */
	private UploadDialog(Stage stageOwner, Archive archive, Connection conn,
		boolean bMetaDataOnly, MetaDataToDb mdtd)
	{
		super(stageOwner, conn, archive, bMetaDataOnly, false, SiardBundle.getSiardBundle().getUploadTitle());

		MetaData md = archive.getMetaData();
		if (!mdtd.supportsUdts()) {
			int iTypesInSiard = 0;
			for (int iSchema = 0; iSchema < md.getMetaSchemas(); iSchema++) {
				MetaSchema ms = md.getMetaSchema(iSchema);
				iTypesInSiard = iTypesInSiard + ms.getMetaTypes();
			}
			if (iTypesInSiard > 0)
				_tfMessage.setText(SiardBundle.getSiardBundle().getUploadUnsupportedUdtsMessage());
		}

		_ut = UploadTask.startUploadTask(archive, conn, bMetaDataOnly, mdtd, _pb.progressProperty(), _wseh);
	} /* constructor UploadDialog */

	/*------------------------------------------------------------------*/
	/**
	 * show upload dialog and start uploading.
	 * 
	 * @param stageOwner owner window.
	 * @param archive SIARD archive to be uploaded.
	 * @param conn database connection.
	 * @param bMetaDataOnly true, if only meta data are to be uploaded.
	 * @return upload result.
	 */
	public static UploadDialog showUploadDialog(Stage stageOwner,
		Archive archive, Connection conn, boolean bMetaDataOnly, MetaDataToDb mdtd)
	{
		_il.enter(conn, archive, String.valueOf(bMetaDataOnly));
		UploadDialog ud = new UploadDialog(stageOwner, archive, conn, bMetaDataOnly, mdtd);

		ud.setResizable(false); /* IntraDIGM */

		ud.showAndWait();
		System.setOut(ud._psOut);
		System.setErr(ud._psErr);
		_il.exit(ud);
		return ud;
	} /* showUploadDialog */

} /* UploadDialog */
