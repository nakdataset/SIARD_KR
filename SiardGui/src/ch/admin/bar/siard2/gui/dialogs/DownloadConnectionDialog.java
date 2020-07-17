/*======================================================================
DownloadConnectionDialog for entering data to connect to a database.
Application : Siard2
Description : DownloadConnectionDialog for entering data to connect to a
              database for download.
Platform    : Java 7, JavaFX 2.2
------------------------------------------------------------------------
Copyright  : Swiss Federal Archives, Berne, Switzerland, 2017
Created    : 27.06.2017, Hartwig Thomas, Enter AG, Rüti ZH
======================================================================*/
package ch.admin.bar.siard2.gui.dialogs;

import org.apache.log4j.Logger;

import ch.admin.bar.siard2.gui.SiardBundle;
import javafx.stage.Stage;

/*====================================================================*/
/** DownloadConnectionDialog for entering data to connect to a database
 * for download.
 * @author Hartwig Thomas
 */
public class DownloadConnectionDialog
  extends ConnectionDialog
{
  private static SiardBundle _sb = SiardBundle.getSiardBundle();

  //최창근 추가 - 로그
  private static final Logger LOG = Logger.getLogger(DownloadConnectionDialog.class);

  /*------------------------------------------------------------------*/
  /** display the connection dialog.
   * @param stageOwner owner window.
   * @param sConnectionUrl initial value for connection (JDBC) URL or null.
   * @param sDbUser initial value for user of database or null.
   */
  private DownloadConnectionDialog(Stage stageOwner, String sConnectionUrl, String sDbUser)
  {
    super(stageOwner,sConnectionUrl,sDbUser,
        _sb.getConnectionDownloadTitle(),
        _sb.getConnectionDownloadMetaDataOnlyLabel(),
        _sb.getConnectionDownloadMetaDataOnlyTooltip(),
        null,null,
        _sb.getConnectionDownloadViewsAsTablesLabel(),
        _sb.getConnectionDownloadViewsAsTablesTooltip());
  } /* constructor DownloadConnectionDialog */

  /*------------------------------------------------------------------*/
  /** show download connection dialog and save entered values.
   * @param stageOwner owner window.
   * @param sConnectionUrl initial value for connection (JDBC) URL or null.
   * @param sDbUser initial value for user of database or null.
   * @return DownloadConnectionDialog instance with results.
   *   if getResult() is 1 then getConnectionUrl(), getDbUser(),
   *   getDbPassword(), isMetaDataOnly() and isViewsAsTables() have the
   *   values entered.
   */
  public static DownloadConnectionDialog showDownloadConnectionDialog(
    Stage stageOwner, String sConnectionUrl, String sDbUser)
  {
	LOG.info("connectionDialon call!");
    DownloadConnectionDialog dcd = new DownloadConnectionDialog(stageOwner, sConnectionUrl, sDbUser);
    LOG.info("before dcd.showAndWait()");
    dcd.showAndWait();
    LOG.info("after dcd.showAndWait()");
    return dcd;
  } /* showDownloadConnectionDialog */

} /* class DownloadConnectionDialog */
