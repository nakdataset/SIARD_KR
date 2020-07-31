/*======================================================================
UploadConnectionDialog for entering data to connect to a database.
Application : Siard2
Description : UploadConnectionDialog for entering data to connect to a
              database for upload.
Platform    : Java 7, JavaFX 2.2
------------------------------------------------------------------------
Copyright  : Swiss Federal Archives, Berne, Switzerland, 2017
Created    : 29.06.2017, Hartwig Thomas, Enter AG, Rüti ZH
======================================================================*/
package ch.admin.bar.siard2.gui.dialogs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import ch.admin.bar.siard2.api.Archive;
import ch.admin.bar.siard2.api.MetaData;
import ch.admin.bar.siard2.gui.SchemaMapping;
import ch.admin.bar.siard2.gui.SiardBundle;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*====================================================================*/
/** UploadConnectionDialog for entering data to connect to a database
 * for upload.
 * @author Hartwig Thomas
 */
public class UploadConnectionDialog
  extends ConnectionDialog
{

  //최창근 추가 - 로그
  private static final Logger LOG = Logger.getLogger(UploadConnectionDialog.class);

  private static SiardBundle _sb = SiardBundle.getSiardBundle();
  private Archive _archive = null;
  /** schema mappings */
  private Map<Label,TextField> _mapSchemas = null;
  public Map<String,String> getSchemasMap()
  {
    Map<String,String> mapSchemas = new HashMap<String,String>();
    for (Iterator<Label> iterSchema = _mapSchemas.keySet().iterator(); iterSchema.hasNext(); )
    {
      Label lbl = iterSchema.next();
      String sSchema = lbl.getText();
      TextField tf = _mapSchemas.get(lbl);
      String sMapped = tf.getText();
      mapSchemas.put(sSchema, sMapped);
    }
    return mapSchemas;
  } /* getSchemasMap */

  @Override
  protected void persist()
  {
    super.persist();
    Map<String,String> mapSchemas = new HashMap<String,String>();
    for (Iterator<Label> iterSchema = _mapSchemas.keySet().iterator(); iterSchema.hasNext(); )
    {
      Label lblSchema = iterSchema.next();
      TextField tfSchema = _mapSchemas.get(lblSchema);
      mapSchemas.put(lblSchema.getText(), tfSchema.getText());
    }
    SchemaMapping.getInstance().setSchemaMapping(mapSchemas);
  }

  @Override
  protected String validate()
  {
    String sError = super.validate();
    for (Iterator<Label> iterSchema = _mapSchemas.keySet().iterator(); (sError == null) && iterSchema.hasNext(); )
    {
      Label lbl = iterSchema.next();
      TextField tf = _mapSchemas.get(lbl);
      String sMapped = tf.getText();
      if (sMapped.length() == 0)
      {
        sError = SiardBundle.getSiardBundle().getUploadConnectionErrorSchema();
        tf.requestFocus();
      }
    }
    return sError;
  }

  /*------------------------------------------------------------------*/
  /** create a VBox for the schema mapping.
   * @return VBox for the schema mapping.
   */
  private VBox createVBoxSchemas()
  {
    SiardBundle sb = SiardBundle.getSiardBundle();
    SchemaMapping sm = SchemaMapping.getInstance();
    VBox vbox = new VBox();
    vbox.setPadding(new Insets(dINNER_PADDING));
    vbox.setSpacing(dVSPACING);
    vbox.setAlignment(Pos.TOP_LEFT);
    double dMinWidth = 0.0;
    Label lblTitle = createLabel(sb.getConnectionUploadSchemasLabel(),vbox);
    if (dMinWidth < lblTitle.getPrefWidth())
      dMinWidth = lblTitle.getPrefWidth();
    vbox.getChildren().add(lblTitle);
    double dLabelWidth = 0;
    Set<String> setSchemas = new HashSet<String>();
    MetaData md = _archive.getMetaData();
    for (int iSchema = 0; iSchema < md.getMetaSchemas(); iSchema++)
    {
      String sSchema = md.getMetaSchema(iSchema).getName();
      setSchemas.add(sSchema);
    }
    Map<String,String> mapSchemas = sm.getSchemaMapping(setSchemas);
    _mapSchemas = new HashMap<Label,TextField>();
    for (int iSchema = 0; iSchema < md.getMetaSchemas(); iSchema++)
    {
      String sSchema = md.getMetaSchema(iSchema).getName();
      TextField tfSchema = new TextField(mapSchemas.get(sSchema));
      tfSchema.textProperty().addListener(_scl);
      Label lblSchema = createLabel(sSchema,tfSchema);
      if (dLabelWidth < lblSchema.getPrefWidth())
        dLabelWidth = lblSchema.getPrefWidth();
      _mapSchemas.put(lblSchema, tfSchema);
    }
    double dTextWidth = dWIDTH_URL - dLabelWidth - dHSPACING;
    for (Iterator<Label> iterLabel = _mapSchemas.keySet().iterator(); iterLabel.hasNext(); )
    {
      Label lbl = iterLabel.next();
      lbl.setPrefWidth(dLabelWidth);
      TextField tf = _mapSchemas.get(lbl);
      tf.setPrefWidth(dTextWidth);
      HBox hbox = createHBox(lbl,tf);
      if (dMinWidth < hbox.getMinWidth())
        dMinWidth = hbox.getMinWidth();
      vbox.getChildren().add(hbox);
    }
    vbox.setMinWidth(dMinWidth);
    return vbox;
  } /* createVBoxSchemas */

  /*------------------------------------------------------------------*/
  /** display the upload connection dialog.
   * @param stageOwner owner window.
   * @param sConnectionUrl initial value for connection (JDBC) URL or null.
   * @param sDbUser initial value for user of database opr null.
   * @param archive SIARD archive to be uploaded.
   */
  private UploadConnectionDialog(
    Stage stageOwner, String sConnectionUrl, String sDbUser, Archive archive)
  {
    super(stageOwner,sConnectionUrl,sDbUser,
        _sb.getConnectionUploadTitle(),
        _sb.getConnectionUploadMetaDataOnlyLabel(),
        _sb.getConnectionUploadMetaDataOnlyTooltip(),
        _sb.getConnectionUploadOverwriteLabel(),
        _sb.getConnectionUploadOverwriteTooltip(),
        null,null);

    LOG.info("sConnectionUrl " + sConnectionUrl);
    LOG.info("sDbUser " + sDbUser);
    LOG.info("_sb.getConnectionDownloadTitle() " + _sb.getConnectionUploadTitle());
    LOG.info("_sb.getConnectionUploadMetaDataOnlyLabel() " + _sb.getConnectionUploadMetaDataOnlyLabel());
    LOG.info("_sb.getConnectionUploadMetaDataOnlyTooltip() " + _sb.getConnectionUploadMetaDataOnlyTooltip());
    LOG.info("_sb.getConnectionUploadOverwriteLabel() " + _sb.getConnectionUploadOverwriteLabel());
    LOG.info("_sb.getConnectionUploadOverwriteTooltip() " + _sb.getConnectionUploadOverwriteTooltip());

    _archive = archive;

    LOG.info("UploadConnectionDialog");

    /* add the schemas from the meta data to the dialog */
    VBox vboxDialog = (VBox)getScene().getRoot();
    double dMinWidth = vboxDialog.getMinWidth();
    VBox vboxSchemas = createVBoxSchemas();

    if (dMinWidth < vboxSchemas.getMinWidth())
      dMinWidth = vboxSchemas.getMinWidth();

    /* add schemas before buttons */
    vboxDialog.getChildren().add(vboxDialog.getChildren().size()-1,vboxSchemas);
    vboxDialog.getChildren().add(vboxDialog.getChildren().size()-1,new Separator());
    vboxDialog.setMinWidth(dMinWidth);
  } /* constructor UpConnectionDialog */

  /*------------------------------------------------------------------*/
  /** show upload connection dialog and save entered values.
   * @param stageOwner owner window.
   * @param sConnectionUrl initial value for connection (JDBC) URL or null.
   * @param sDbUser initial value for user of database or null.
   * @param archive SIARD archive to be uploaded.
   * @return UpConnectionDialog instance with results.
   *   if getResult() is 1 then getConnectionUrl(), getDbUser(),
   *   getDbPassword(), isMetaDataOnly(), isOverwrite(), and getSchemasMap()
   *   have the values entered.
   */
  public static UploadConnectionDialog showUploadConnectionDialog(
    Stage stageOwner, String sConnectionUrl, String sDbUser, Archive archive)
  {
    UploadConnectionDialog ucd = new UploadConnectionDialog(stageOwner, sConnectionUrl, sDbUser, archive);
    ucd.showAndWait();
    return ucd;
  } /* showUploadConnectionDialog */

} /* class UploadConnectionDialog */
