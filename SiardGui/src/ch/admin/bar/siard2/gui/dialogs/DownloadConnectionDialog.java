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

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import ch.admin.bar.siard2.gui.SiardBundle;
import ch.enterag.utils.fx.controls.ObjectListTableView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
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

    LOG.info("sConnectionUrl " + sConnectionUrl);
    LOG.info("sDbUser " + sDbUser);
    LOG.info("_sb.getConnectionDownloadTitle() " + _sb.getConnectionDownloadTitle());
    LOG.info("_sb.getConnectionDownloadMetaDataOnlyLabel() " + _sb.getConnectionDownloadMetaDataOnlyLabel());
    LOG.info("_sb.getConnectionDownloadMetaDataOnlyTooltip() " + _sb.getConnectionDownloadMetaDataOnlyTooltip());
    LOG.info("_sb.getConnectionDownloadViewsAsTablesLabel() " + _sb.getConnectionDownloadViewsAsTablesLabel());
    LOG.info("_sb.getConnectionDownloadViewsAsTablesTooltip() " + _sb.getConnectionDownloadViewsAsTablesTooltip());


    //TODO 최창근 추가 - 1차에 구현해놓은 특정 테이블 선택 기능 가져오기
    /* add the schemas from the meta data to the dialog */
//
//    VBox vboxDialog = (VBox)getScene().getRoot();
//    double dMinWidth = vboxDialog.getMinWidth();
//    VBox vboxSchemas = createVBoxSchemas();
//
//    if (dMinWidth < vboxSchemas.getMinWidth())
//      dMinWidth = vboxSchemas.getMinWidth();
//
//    /* add schemas before buttons */
//    vboxDialog.getChildren().add(vboxDialog.getChildren().size()-1, vboxSchemas);
//    vboxDialog.getChildren().add(vboxDialog.getChildren().size()-1, new Separator());
//    vboxDialog.setMinWidth(dMinWidth);

  } /* constructor DownloadConnectionDialog */

  /*------------------------------------------------------------------*/
  /** create a VBox for the schema mapping.
   * @return VBox for the schema mapping.
   */
  private VBox createVBoxSchemas()
  {
    SiardBundle sb = SiardBundle.getSiardBundle();

    VBox vbox = new VBox();
    vbox.setPadding(new Insets(dINNER_PADDING));
    vbox.setSpacing(dVSPACING);
    vbox.setAlignment(Pos.TOP_LEFT);

    double dMinWidth = 0.0;

    HBox hBoxTableView = createHBoxTableView();
    if (dMinWidth < hBoxTableView.getMinWidth()) {
		dMinWidth = hBoxTableView.getMinWidth();
	}
    vbox.getChildren().add(hBoxTableView);

    vbox.setMinWidth(dMinWidth);

    return vbox;
  } /* createVBoxSchemas */

  private HBox createHBoxTableView() {
	HBox hBoxTableView = new HBox();
	hBoxTableView.setPadding(new Insets(dINNER_PADDING));
	hBoxTableView.setSpacing(dHSPACING);

	ObjectListTableView _oltv = newMetaTablesTableView();

	hBoxTableView.getChildren().add(_oltv);
	HBox.setHgrow(_oltv, Priority.ALWAYS);
	VBox.setVgrow(_oltv, Priority.NEVER);

//	TableView<TableName> _tvSelectTable = new TableView<TableName>();
//	ObservableList<TableName> rowdata = FXCollections.observableArrayList();
//
//	TableColumn<TableName, String> c1 = new TableColumn<TableName, String>("테이블명");
//	c1.setCellValueFactory(new PropertyValueFactory<TableName, String>("TableName"));
//
//	TableColumn<TableName, Boolean> c2 = new TableColumn<TableName, Boolean>("선택");
//
//	c2.setCellValueFactory(new PropertyValueFactory<TableName, Boolean>("check"));
//	c2.setCellFactory(CheckBoxTableCell.forTableColumn(c2));
//
//	//c2.setEditable(true);
//
//	c1.prefWidthProperty().bind(_tvSelectTable.widthProperty().multiply(0.75));
//	c2.prefWidthProperty().bind(_tvSelectTable.widthProperty().multiply(0.2));

//	_tvSelectTable.getColumns().add(c1);
//	_tvSelectTable.getColumns().add(c2);
//	_tvSelectTable.setEditable(true);

	return hBoxTableView;
  }

  /*------------------------------------------------------------------*/
  /** create the table view for the tables of a schema.
   * @param ms schema meta data.
   * @return TableView listing the tables of the schema.
   */
  public ObjectListTableView newMetaTablesTableView()
  {
    SiardBundle sb = SiardBundle.getSiardBundle();

    List<String> listHeaders = Arrays.asList(
      sb.getProperty("header.metatables.row"),
      sb.getProperty("header.metatables.name"),
      sb.getProperty("header.metatables.columns"),
      sb.getProperty("header.metatables.records"));
    ObjectListTableView oltv = new ObjectListTableView(listHeaders);

    List<Object> listRow = Arrays.asList("최창근", "김창근", "이창근", "박창근");
    oltv.getItems().add(listRow);
    listRow = Arrays.asList("박경식", "김경식", "이경식", "박경식");
    oltv.getItems().add(listRow);
    listRow = Arrays.asList("박경식", "김경식", "이경식", "박경식");
    oltv.getItems().add(listRow);
    listRow = Arrays.asList("박경식", "김경식", "이경식", "박경식");
    oltv.getItems().add(listRow);
    listRow = Arrays.asList("박경식", "김경식", "이경식", "박경식");
    oltv.getItems().add(listRow);
    listRow = Arrays.asList("박경식", "김경식", "이경식", "박경식");
    oltv.getItems().add(listRow);
    listRow = Arrays.asList("박경식", "김경식", "이경식", "박경식");
    oltv.getItems().add(listRow);
    listRow = Arrays.asList("박경식", "김경식", "이경식", "박경식");
    oltv.getItems().add(listRow);
    listRow = Arrays.asList("박경식", "김경식", "이경식", "박경식");
    oltv.getItems().add(listRow);
    listRow = Arrays.asList("박경식", "김경식", "이경식", "박경식");
    oltv.getItems().add(listRow);
    listRow = Arrays.asList("박경식", "김경식", "이경식", "박경식");
    oltv.getItems().add(listRow);
    listRow = Arrays.asList("박경식", "김경식", "이경식", "박경식");
    oltv.getItems().add(listRow);
    listRow = Arrays.asList("박경식", "김경식", "이경식", "박경식");
    oltv.getItems().add(listRow);
    listRow = Arrays.asList("박경식", "김경식", "이경식", "박경식");
    oltv.getItems().add(listRow);
    listRow = Arrays.asList("박경식", "김경식", "이경식", "박경식");
    oltv.getItems().add(listRow);
    listRow = Arrays.asList("박경식", "김경식", "이경식", "박경식");
    oltv.getItems().add(listRow);
    listRow = Arrays.asList("박경식", "김경식", "이경식", "박경식");
    oltv.getItems().add(listRow);
    listRow = Arrays.asList("박경식", "김경식", "이경식", "박경식");
    oltv.getItems().add(listRow);
    listRow = Arrays.asList("박경식", "김경식", "이경식", "박경식");
    oltv.getItems().add(listRow);
    listRow = Arrays.asList("박경식", "김경식", "이경식", "박경식");
    oltv.getItems().add(listRow);
    listRow = Arrays.asList("박경식", "김경식", "이경식", "박경식");
    oltv.getItems().add(listRow);
    listRow = Arrays.asList("박경식", "김경식", "이경식", "박경식");
    oltv.getItems().add(listRow);
    listRow = Arrays.asList("박경식", "김경식", "이경식", "박경식");
    oltv.getItems().add(listRow);
    listRow = Arrays.asList("박경식", "김경식", "이경식", "박경식");
    oltv.getItems().add(listRow);
    listRow = Arrays.asList("박경식", "김경식", "이경식", "박경식");
    oltv.getItems().add(listRow);
    listRow = Arrays.asList("박경식", "김경식", "이경식", "박경식");
    oltv.getItems().add(listRow);
    listRow = Arrays.asList("박경식", "김경식", "이경식", "박경식");
    oltv.getItems().add(listRow);
    listRow = Arrays.asList("박경식", "김경식", "이경식", "박경식");
    oltv.getItems().add(listRow);
    listRow = Arrays.asList("박경식", "김경식", "이경식", "박경식");
    oltv.getItems().add(listRow);
    /* table data */
//    for (int iTable = 0; iTable < ms.getMetaTables(); iTable++)
//    {
//      MetaTable mt = ms.getMetaTable(iTable);
//      List<Object> listRow = Arrays.asList((Object)iTable, mt.getName(),mt.getMetaColumns(),mt.getRows());
//      oltv.getItems().add(listRow);
//    }
    return oltv;
  } /* newMetaTablesTableView */

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
	LOG.info("DownloadConnectionDialog call!");
    DownloadConnectionDialog dcd = new DownloadConnectionDialog(stageOwner, sConnectionUrl, sDbUser);
    LOG.info("DownloadConnectionDialog before dcd.showAndWait()");
    dcd.showAndWait();
    LOG.info("DownloadConnectionDialog after dcd.showAndWait()");
    return dcd;
  } /* showDownloadConnectionDialog */

} /* class DownloadConnectionDialog */
