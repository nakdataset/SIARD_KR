/*
 * ======================================================================
 * UploadDownloadAction handles upload and download of a SIARD archive.
 * Application : SIARD GUI
 * Description : UploadDownloadAction handles upload and download of a SIARD archive.
 * Platform : JAVA 1.7, JavaFX 2.2
 * ------------------------------------------------------------------------
 * Copyright : Swiss Federal Archives, Berne, Switzerland, 2017
 * Created : 23.06.2017, Hartwig Thomas, Enter AG, Rüti ZH
 * ======================================================================
 */
package ch.admin.bar.siard2.gui.actions;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import ch.admin.bar.siard2.api.Archive;
import ch.admin.bar.siard2.api.primary.ArchiveImpl;
import ch.admin.bar.siard2.cmd.MetaDataToDb;
import ch.admin.bar.siard2.cmd.SiardConnection;
import ch.admin.bar.siard2.gui.MainMenuBar;
import ch.admin.bar.siard2.gui.MruConnection;
import ch.admin.bar.siard2.gui.MruFile;
import ch.admin.bar.siard2.gui.SiardBundle;
import ch.admin.bar.siard2.gui.SiardGui;
import ch.admin.bar.siard2.gui.UserProperties;
import ch.admin.bar.siard2.gui.dialogs.DownloadConnectionDialog;
import ch.admin.bar.siard2.gui.dialogs.DownloadDialog;
import ch.admin.bar.siard2.gui.dialogs.TableDialog;
import ch.admin.bar.siard2.gui.dialogs.UploadConnectionDialog;
import ch.admin.bar.siard2.gui.dialogs.UploadDialog;
import ch.enterag.utils.fx.dialogs.FS;
import ch.enterag.utils.fx.dialogs.MB;
import ch.enterag.utils.logging.IndentLogger;
import javafx.scene.Scene;
import javafx.stage.Stage;

/* ==================================================================== */
/**
 * UploadDownloadAction handles upload and download of a SIARD archive.
 *
 * @author Hartwig Thomas
 */
public class UploadDownloadAction {
	/** logger */
	private static IndentLogger _il = IndentLogger.getIndentLogger(UploadDownloadAction.class.getName());

	private static final Logger LOG = Logger.getLogger(UploadDownloadAction.class);

	Stage _stageSplash = null;
	Scene scene = null;
	boolean process = true;

	/*------------------------------------------------------------------*/
	/** constructor */
	private UploadDownloadAction() {} /* constructor UploadDownloadAction */

	/*------------------------------------------------------------------*/
	/** factory */
	public static UploadDownloadAction newUploadDownloadAction() {
		return new UploadDownloadAction();
	} /* newUploadDownloadAction */

	/*------------------------------------------------------------------*/
	/**
	 * display connection dialog, get archive to download to, show download dialog.
	 *
	 * @param sConnectionUrl connection URL from MRU or null.
	 * @param sDbUser Database user from MRU or null.
	 */
	public void download(String sConnectionUrl, String sDbUser) {
		_il.enter(sConnectionUrl, sDbUser);
		SiardBundle sb = SiardBundle.getSiardBundle();
		Stage stage = SiardGui.getSiardGui().getStage();

		/* display connection dialog (at least for password) */
		Connection conn = null;
		DownloadConnectionDialog dcd = DownloadConnectionDialog.showDownloadConnectionDialog(stage, sConnectionUrl, sDbUser);

		if(dcd.getResult() == DownloadConnectionDialog.iRESULT_SUCCESS) {
			try {
				TableDialog.showChooseTableDialog(stage, dcd);
			}catch(Exception e) {
				// e.printStackTrace();
			}
		}

		while ((dcd.getResult() == DownloadConnectionDialog.iRESULT_SUCCESS) && (conn == null)) {
			sConnectionUrl = dcd.getConnectionUrl();
			sDbUser = dcd.getDbUser();
			/* try and load appropriate driver */

			String sError = SiardConnection.getSiardConnection().loadDriver(dcd.getConnectionUrl());
			if (sError == null) {
				_il.event("Driver for " + dcd.getConnectionUrl() + " loaded!");

				/* test connection */
				DriverManager.setLoginTimeout(UserProperties.getUserProperties().getLoginTimeoutSeconds());

				try {
					conn = DriverManager.getConnection(dcd.getConnectionUrl(), dcd.getDbUser(), dcd.getDbPassword());
					conn.setAutoCommit(false);
				} catch (SQLException se) {
					conn = null;
					MB.show(stage,
						sb.getConnectionErrorTitle(),
						sb.getConnectionErrorConnectMessage(dcd.getConnectionUrl(), se),
						sb.getOk(), null);
				}
			} else {
				MB.show(stage,
					sb.getConnectionErrorTitle(),
					sb.getConnectionErrorDriverMessage(sError),
					sb.getOk(), null);
			}

			if (conn == null) {
				dcd = DownloadConnectionDialog.showDownloadConnectionDialog(stage, sConnectionUrl, sDbUser);

				if(dcd.getResult() == DownloadConnectionDialog.iRESULT_SUCCESS) {
					try {
						TableDialog.showChooseTableDialog(stage, dcd);
					}catch(Exception e) {
						// e.printStackTrace();
					}
				}
			}
		}

		if (dcd.getResult() == DownloadConnectionDialog.iRESULT_SUCCESS) {
			_il.event("Connection established!");
			/* update MRU */
			MruConnection mc = MruConnection.getMruConnection(true);
			mc.setMruConnection(dcd.getConnectionUrl(), dcd.getDbUser());

			/* update menu bar */
			MainMenuBar.getMainMenuBar().setConnectionMru(true);

			/* get file */
			File fileArchive = null;

			try {

				if (!dcd.isMetaDataOnly()) {
					fileArchive = SiardGui.getDefaultDataDirectory();

					if (MruFile.getMruFile().getMruFiles() > 0)
						fileArchive = (new File(MruFile.getMruFile().getMruFile(0))).getParentFile();

					if(!fileArchive.exists()) {
						fileArchive = SiardGui.getDefaultDataDirectory();
					}

					fileArchive = new File(fileArchive.getAbsolutePath() + File.separator + "*." + Archive.sSIARD_DEFAULT_EXTENSION);

					fileArchive = FS.chooseNewFile(stage,
						sb.getArchiveFileTitle(), sb.getArchiveFileMessage(), sb,
						fileArchive, Archive.sSIARD_DEFAULT_EXTENSION, true);

				} else {
					/* temporary meta data file */
					fileArchive = File.createTempFile("mdo", ".siard");
				}
			} catch (IOException ie) {
				_il.exception(ie);
			}

			if (fileArchive != null) {
				_il.event("Archive file selected: " + fileArchive.getAbsolutePath());
				if (fileArchive.exists())
					fileArchive.delete();

				SiardGui.getSiardGui().startAction(sb.getDownloadingStatus(dcd.getConnectionUrl(), fileArchive));

				try {

					Archive archive = ArchiveImpl.newInstance();

//					archive.setOriginalDir(dcd.getOriginalDir()); // 파일 원래 경로
//					archive.setFileDown(dcd.getFileDown());
//					archive.setSchema(dcd.getSchemaName());
//
//					// siard 저장되면 파일 저장 경로
//					// DB 첨부파일 루트 저장경로
//					if(dcd.getTargetDir() == null || dcd.getTargetDir().trim().equals("")) {
//						archive.setTargetDir(fileArchive.getParent());
//					} else {
//						archive.setTargetDir(dcd.getTargetDir());
//					}
//
//					// 파일저장 경로 필드명
//					if(dcd.getFilePath() != null && dcd.getFilePath().trim().length() > 0) {
//						archive.setFilePath(dcd.getFilePath());
//					}

					// 체크된 테이블 목록
					archive.setTableCheckedList(dcd.chooseTableList);

					// 체크된 컬럼 목록
					archive.setColumnCheckedMap(dcd.chooseColumnMap);

					archive.create(fileArchive);

					if (dcd.isMetaDataOnly())
						fileArchive.deleteOnExit();
					/* if there is a meta data only archive, use its meta data as a template */
					if (SiardGui.getSiardGui().getArchive() != null) {
						ByteArrayOutputStream baos = new ByteArrayOutputStream();
						SiardGui.getSiardGui().getArchive().exportMetaData(baos);
						ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
						baos.close();
						archive.importMetaDataTemplate(bais);
						bais.close();
					}

					/* show download dialog */
					DownloadDialog dd = DownloadDialog.showDownloadDialog(stage, conn, archive, dcd.isMetaDataOnly(), dcd.isViewsAsTables());

					if (dd.wasSuccessful() && (dd.getArchive().isValid() || dcd.isMetaDataOnly())) {
						// SIARD 파일 검증 진행 여부
//						boolean verify = dd.getVerify();
//
						if (dd.getArchive().isValid()) {
							dd.getArchive().close();
							dd.getArchive().open(fileArchive);
						}
						SiardGui.getSiardGui().setArchive(dd.getArchive());
						if (!dcd.isMetaDataOnly()) {
							MruFile mf = MruFile.getMruFile();
							mf.setMruFile(archive.getFile().getAbsolutePath());
							MainMenuBar.getMainMenuBar().setFileMru();
						}
//
//						if(verify == true) {
//							process = false;
//							Alert alert = new Alert(AlertType.INFORMATION);
//							alert.setTitle("검증 완료");
//							alert.setHeaderText("Siard 파일 검증 완료");
//							alert.setContentText("Siard 파일 검증이 완료되었습니다.");
//							alert.showAndWait();
//						}

					} else {
						try {
							dd.getArchive().close();
						} catch (IOException ie) {
						}

						MB.show(stage,
							sb.getDownloadErrorTitle(),
							sb.getDownloadErrorInvalidMessage(fileArchive),
							sb.getOk(), null);

						if (!fileArchive.delete())
							fileArchive.deleteOnExit();
					}
				} catch (IOException ie) {
					MB.show(stage,
						sb.getDownloadErrorTitle(),
						sb.getDownloadErrorCreateMessage(fileArchive, ie),
						sb.getOk(), null);
				} finally {
					try {
						if ((conn != null) && (!conn.isClosed()))
							conn.close();
					} catch (SQLException se) {
						_il.exception(se);
					}
				}

				SiardGui.getSiardGui().terminateAction();
			} else
				_il.event("No file selected!");
		}
		_il.exit();
	} /* download */

	/*------------------------------------------------------------------*/
	/**
	 * display connection dialog, show upload dialog.
	 *
	 * @param sConnectionUrl connection URL from MRU or null.
	 * @param sDbUser Database user from MRU or null.
	 * @param archive SIARD archive to upload.
	 */
	public void upload(String sConnectionUrl, String sDbUser, Archive archive) {
		_il.enter(sConnectionUrl, sDbUser);

		SiardBundle sb = SiardBundle.getSiardBundle();
		Stage stage = SiardGui.getSiardGui().getStage();

		/* display connection dialog (at least for password) */
		Connection conn = null;
		UploadConnectionDialog ucd = UploadConnectionDialog.showUploadConnectionDialog(stage, sConnectionUrl, sDbUser, archive);

		while ((ucd.getResult() == UploadConnectionDialog.iRESULT_SUCCESS) && (conn == null)) {
			sConnectionUrl = ucd.getConnectionUrl();
			sDbUser = ucd.getDbUser();
			/* try and load appropriate driver */
			String sError = SiardConnection.getSiardConnection().loadDriver(ucd.getConnectionUrl());
			if (sError == null) {
				/* test connection */
				DriverManager.setLoginTimeout(UserProperties.getUserProperties().getLoginTimeoutSeconds());
				try {
					conn = DriverManager.getConnection(ucd.getConnectionUrl(), ucd.getDbUser(), ucd.getDbPassword());
					conn.setAutoCommit(false);
				} catch (SQLException se) {
					conn = null;
					MB.show(stage,
						sb.getConnectionErrorTitle(),
						sb.getConnectionErrorConnectMessage(ucd.getConnectionUrl(), se),
						sb.getOk(), null);
				}
			} else {
				MB.show(stage, sb.getConnectionErrorTitle(),
					sb.getConnectionErrorDriverMessage(sError),
					sb.getOk(), null);
			}
			if (conn == null)
				ucd = UploadConnectionDialog.showUploadConnectionDialog(
					stage, sConnectionUrl, sDbUser, archive);
		}

		if (ucd.getResult() == UploadConnectionDialog.iRESULT_SUCCESS) {
			/* update MRU */
			MruConnection mc = MruConnection.getMruConnection(false);
			mc.setMruConnection(ucd.getConnectionUrl(), ucd.getDbUser());
			/* update menu bar */
			MainMenuBar.getMainMenuBar().setConnectionMru(false);
			/* creating the MetaDataToDb takes a while. So let the user see the wait cursor ... */
			SiardGui.getSiardGui().startAction(
				sb.getUploadingStatus(archive.getFile(), ucd.getConnectionUrl()));
			try {
				MetaDataToDb mdtd = MetaDataToDb.newInstance(conn.getMetaData(), archive.getMetaData(), ucd.getSchemasMap());

				mdtd._todb = conn.getMetaData().getDatabaseProductName();
				mdtd._ardb = archive.getMetaData().getDatabaseProduct().substring(0, 6);
				mdtd._cubrid = mdtd._todb.equals("CUBRID") && mdtd._ardb.equals("CUBRID");

				if (ucd.isOverwrite() || ((mdtd.tablesDroppedByUpload() == 0) && (mdtd.typesDroppedByUpload() == 0)))
					UploadDialog.showUploadDialog(stage,
						archive, conn, ucd.isMetaDataOnly(), mdtd);
				else {
					MB.show(stage,
						sb.getUploadErrorTitle(),
						sb.getUploadErrorOverwriteMessage(ucd.getConnectionUrl()),
						sb.getOk(), null);
				}
			} catch (IOException ie) {
				MB.show(stage,
					sb.getUploadErrorTitle(),
					sb.getUploadErrorIoMessage(archive.getFile(), ie),
					sb.getOk(), null);
			} catch (SQLException se) {
				MB.show(stage,
					sb.getUploadErrorTitle(),
					sb.getUploadErrorSqlMessage(ucd.getConnectionUrl(), se),
					sb.getOk(), null);
			}
			SiardGui.getSiardGui().terminateAction();
		}
		_il.exit();
	} /* upload */

} /* class UploadDownloadAction */
