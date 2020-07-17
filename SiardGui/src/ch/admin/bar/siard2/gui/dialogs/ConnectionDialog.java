/*======================================================================
ConnectionDialog for entering data to connect to a database.
Application : Siard2
Description : ConnectionDialog for entering data to connect to a
              database.
Platform    : Java 8, JavaFX 8
------------------------------------------------------------------------
Copyright  : Swiss Federal Archives, Berne, Switzerland, 2017
Created    : 27.06.2017, Hartwig Thomas, Enter AG, Rüti ZH
======================================================================*/
package ch.admin.bar.siard2.gui.dialogs;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import ch.admin.bar.siard2.cmd.SiardConnection;
import ch.admin.bar.siard2.gui.SiardBundle;
import ch.admin.bar.siard2.gui.UserProperties;
import ch.config.db.CommonDAO;
import ch.enterag.utils.fx.FxSizes;
import ch.enterag.utils.fx.FxStyles;
import ch.enterag.utils.fx.ScrollableDialog;
import ch.enterag.utils.fx.dialogs.FS;
import ch.enterag.utils.logging.IndentLogger;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.Clipboard;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*====================================================================*/
/** ConnectionDialog for entering data to connect to a database.
 * Abstract base class for DownloadConnectionDialog and UploadConnectionDialog.
 * @author Hartwig Thomas test
 */
public abstract class ConnectionDialog extends ScrollableDialog
{
  /** logger */
  private static IndentLogger _il = IndentLogger.getIndentLogger(ConnectionDialog.class.getName());

  // 최창근 추가 - 로그
  private static final Logger LOG = Logger.getLogger(ConnectionDialog.class);

  // width of JDBC URL input box
  protected static final double dWIDTH_URL = FxSizes.getScreenBounds().getWidth()/2.0;

  // properties
  protected String _sConnectionUrl = null;
  protected String _sDbUser = null;
  /** result will be 1 for default, 0 otherwise */
  public static final int iRESULT_CANCELED = 0;
  public static final int iRESULT_SUCCESS = 1;
  protected int _iResult = iRESULT_CANCELED;
  public int getResult() { return _iResult; }

  /** default button (= Enter) */
  protected Button _btnDefault = null;
  /** cancel button (= Escape) */
  protected Button _btnCancel = null;
  /** error message */
  protected TextField _tfError = null;
  /** VBox for parameters */
  protected VBox _vboxParameters = null;
  protected ComboBox<String> _cbDbScheme = null;
  /** hbox for database host */
  protected HBox _hboxDbHost = null;
  /** text field for database host */
  protected TextField _tfDbHost = null;
  /** text field for database name */
  protected TextField _tfDbName = null;
  /** toggle group for database options */
  protected ToggleGroup _tgOptions = null;
  /** hbox for database folder */
  protected HBox _hboxDbFolder = null;
  /** text field for folder name */
  protected PastingTextField _tfDbFolder = null;
  // protected Label _lblDbFolder = null;
  /** button for triggering folder selection */
  protected Button _btnDbFolder = null;
  /** map from scheme title to scheme */
  protected Map<String,String> _mapSchemes = new HashMap<String,String>();
  /** text field for connection URL */
  protected TextField _tfConnectionUrl = null;

	protected TextField				_tfOriginalDir		= new TextField();
	protected TextField				_tfTargetDir		= new TextField();
	protected TextField				_tfFilePath			= new TextField(); 	//파일 저장 경로
	protected TextField				_tfSchema			= new TextField(); 	//스키마명

	protected Button				_btnTableName		= new Button("목록 가져오기");				// _tvSelectTable 행 삭제
	protected Button				_btnChecked			= new Button("Check Table Names");				// _tvSelectTable 행 삭제
	protected CheckBox 				_cbkAll				= new CheckBox("전체선택");

	protected Label					_lblUser			= new Label("계정");
	protected TextField				_tfUser				= new TextField();
	protected Label					_lblPassword		= new Label("암호");
	protected PasswordField         _pfTable  			= new PasswordField();

	protected Button				_btnAdd				= new Button("+");				// _tvSelectTable 행 추가
	protected Button				_btnDelete			= new Button("-");				// _tvSelectTable 행 삭제

	protected RadioButton			_radioSftp 			= new RadioButton("네트워크");
	protected RadioButton			_radioCopy 			= new RadioButton("폴더 복사");
	protected ToggleGroup 			_groupFile 			= new ToggleGroup();
	protected HBox 					_hboxRadio 			= new HBox();
	protected HBox 					_hboxSchema 		= new HBox();

	protected TableView<TableName>	_tvSelectTable		= new TableView<TableName>();
	ObservableList<TableName> rowdata = FXCollections.observableArrayList();

	public String getSchemaName()
	{
		return _tfSchema.getText();
	}

	public String getFileDown()
	{
		if(_radioSftp.isSelected() == true)
		{
			return "SFTP";
		}
		else
		{
			return "COPY";
		}
	}

	public String getOriginalDir()
	{
		return _tfOriginalDir.getText();
	}

	public String getTargetDir()
	{
		return _tfTargetDir.getText();
	}

	public String getFilePath()
	{
		return _tfFilePath.getText();
	}

	public ArrayList getTableCheckedList()
	{
		ObservableList<TableName> rowdata_checked =  _tvSelectTable.getItems();

    	ArrayList<String> list = new ArrayList();

    	for(int ix = 0; ix < rowdata_checked.size(); ix++)
    	{
    		TableName tablename_check = rowdata_checked.get(ix);

    		String str_checked = "";

    		Hashtable<String, String> hash = new Hashtable();

    		if(tablename_check.getCheck().get() == true)
    		{
    			str_checked = "CHECK!!!!!!!!!!!!";
    			list.add(tablename_check.getTableName());

    		}
    	}

    	return list;
	}

  public String getConnectionUrl() { return _iResult == 1? _tfConnectionUrl.getText(): null; }
  /** text field for DbUser */
  protected TextField _tfDbUser = null;
  public String getDbUser() { return _iResult == 1? _tfDbUser.getText(): null; }
  /** password field for password */
  protected PasswordField _pfDbPassword = null;
  public String getDbPassword() { return _iResult == 1? _pfDbPassword.getText(): null; }
  /** check box for meta data only download */
  protected CheckBox _cbMetaDataOnly = null;
  public boolean isMetaDataOnly() { return _iResult == 1? _cbMetaDataOnly.isSelected(): false; }
  /** check box for overwrite */
  private CheckBox _cbOverwrite = null;
  public boolean isOverwrite() { return (_iResult == 1) && (_cbOverwrite != null)? _cbOverwrite.isSelected(): false; }
  /** check box for views as tables */
  private CheckBox _cbViewsAsTables = null;
  public boolean isViewsAsTables() { return (_iResult == 1) && (_cbViewsAsTables != null)? _cbViewsAsTables.isSelected(): false; }

  /*====================================================================*/
  /** DragEventHandler handles dropping folders on DbFolder field.
   */
  private class DragEventHandler
    implements EventHandler<DragEvent>
  {
    @Override
    public void handle(DragEvent event)
    {
      boolean bDropCompleted = false;
      Dragboard db = event.getDragboard();
      if (db.hasFiles())
      {
        List<File> listFiles = db.getFiles();
        if (listFiles.size() == 1)
        {
          File file = db.getFiles().get(0);
          if (file.isDirectory())
          {
            if (event.getEventType() == DragEvent.DRAG_OVER)
              event.acceptTransferModes(TransferMode.COPY);
            else if (event.getEventType() == DragEvent.DRAG_DROPPED)
            {
              PastingTextField ptf = (PastingTextField)event.getSource();
              ptf.changeText(file.getAbsolutePath());
              bDropCompleted = true;
            }
          }
        }
      }
      if (event.getEventType() == DragEvent.DRAG_DROPPED)
        event.setDropCompleted(bDropCompleted);
    } // handle
  } // class
  private DragEventHandler _deh = new DragEventHandler();

  protected void persist()
  {
    UserProperties up = UserProperties.getUserProperties();
    SiardConnection sc = SiardConnection.getSiardConnection();

    String sDbScheme = _mapSchemes.get(getSelectedTitle());
    up.setDatabaseScheme(sDbScheme);

    String sDbHost = _tfDbHost.getText();
    if ((sDbHost != null) && (sDbHost.length() > 0))
      up.setDatabaseHost(sDbHost);

    String sDbName = _tfDbName.getText();
    up.setDatabaseName(sDbName);

    if (sc.getOptions(sDbScheme) > 1)
      up.setDatabaseOption(getSelectedOption());

    _sDbUser = _tfDbUser.getText();

    up.setDatabaseUser(_sDbUser);

    LOG.info("sDbScheme : " + sDbScheme);
    LOG.info("sDbHost : " + sDbHost);
    LOG.info("sDbName : " + sDbName);
    LOG.info("getSelectedOption() : " + getSelectedOption());
    LOG.info("_tfDbUser.getText() : " + _tfDbUser.getText());

  } /* persist */

  protected String validate()
  {
    String sError = null;
    String sDbUser = _tfDbUser.getText();
    if ((sDbUser == null) || (sDbUser.length() == 0))
    {
      sError = SiardBundle.getSiardBundle().getConnectionErrorUser();
      _tfDbUser.requestFocus();
    }
    return sError;
  } /* validate */

  /*====================================================================*/
  /** ActionEventHandler handles all action events.
   */
  private class ActionEventHandler
    implements EventHandler<ActionEvent>
  {
    /*------------------------------------------------------------------*/
    /** handle the clicking of the default or cancel button.
     */
    @Override
    public void handle(ActionEvent ae)
    {
      if (ae.getSource() == _btnCancel)
        close();
      else if (ae.getSource() == _btnDefault)
      {
        String sError = validate();
        if (sError == null)
        {
          LOG.info("sError " + sError);
          persist();
          _iResult = iRESULT_SUCCESS;
          LOG.info("_iResult " + _iResult);
          close();
        }
        else
          _tfError.setText(sError);
      }
      else if (ae.getSource() == _btnDbFolder)
      {
        UserProperties up = UserProperties.getUserProperties();
        SiardBundle sb = SiardBundle.getSiardBundle();
        String sDbFolder = _tfDbFolder.getText();
        File fileDbFolder = new File(sDbFolder);
        try
        {
          fileDbFolder = FS.chooseExistingFolder(ConnectionDialog.this,
            sb.getConnectionDbFolderTitle(), sb.getConnectionDbFolderMessage(), sb,
            fileDbFolder);
          if (fileDbFolder != null)
          {
            up.setDatabaseFolder(fileDbFolder);
            _tfDbFolder.setText(fileDbFolder.getAbsolutePath());
          }
        }
        catch(FileNotFoundException fnfe) { _il.exception(fnfe); }
      }
    } /* handle */
  }
  private ActionEventHandler _aeh = new ActionEventHandler();

  /*====================================================================*/
  /** StringChangeListener handles all change events.
   */
  private class StringChangeListener
    implements ChangeListener<String>
  {
    boolean _bInListener = false;
    /*------------------------------------------------------------------*/
    /** if the scheme choice changed, redisplay Host/Folder and JDBC URL.
     * @param ovs observable value.
     * @param sOld old string.
     * @param sNew new string.
     */
    @Override
    public void changed(ObservableValue<? extends String> ovs,
        String sOld, String sNew)
    {
      if (!_bInListener)
      {
        _bInListener = true;
        SiardConnection sc = SiardConnection.getSiardConnection();
        String sScheme = _mapSchemes.get(getSelectedTitle());
        if (ovs == _cbDbScheme.getSelectionModel().selectedItemProperty())
        {
          if (_vboxParameters != null)
          {
            if (sc.isLocal(sScheme))
            {
              {
                if (_vboxParameters.getChildren().contains(_hboxDbHost))
                  _vboxParameters.getChildren().remove(_hboxDbHost);
                if (!_vboxParameters.getChildren().contains(_hboxDbFolder))
                  _vboxParameters.getChildren().add(1, _hboxDbFolder);
              }
            }
            else
            {
              if (!_vboxParameters.getChildren().contains(_hboxDbHost))
                _vboxParameters.getChildren().add(1,_hboxDbHost);
              if (_vboxParameters.getChildren().contains(_hboxDbFolder))
                _vboxParameters.getChildren().remove(_hboxDbFolder);
            }
          }
          if (_tfDbName != null)
          {
            if (sScheme.equals(UserProperties.sORACLE_DATABASE_SCHEME))
              _tfDbName.setText(UserProperties.sORACLE_DATABASE_NAME);
            else
              _tfDbName.setText(UserProperties.sDATABASE_NAME);
          }
          removeToggleGroup(_tgOptions);
          _tgOptions = createToggleGroup(sScheme);
        }
        if (ovs == _tfDbUser)
        {
          if (sScheme.equals(UserProperties.sACCESS_DATABASE_SCHEME))
          {
            String sDbUser = _tfDbUser.getText();
            if (sDbUser.length() == 0)
              _tfDbUser.setText(UserProperties.sACCESS_DATABASE_USER);
          }
        }
        if ((ovs == _cbDbScheme.getSelectionModel().selectedItemProperty()) ||
            (ovs == _tfDbHost.textProperty()) ||
            (ovs == _tfDbFolder.textProperty()) ||
            (ovs == _tfDbName.textProperty()))
        {
          if (_tfConnectionUrl != null)
          {
            int iSelectedOption = getSelectedOption();
            String sSampleUrl = sc.getSampleUrl(sScheme, _tfDbHost.getText(), _tfDbFolder.getText(), _tfDbName.getText(),iSelectedOption);
            _tfConnectionUrl.setText(sSampleUrl);
          }
        }
        if (_tfError != null)
          _tfError.setText("");
        _bInListener = false;
      }
    } /* changed */
  } /* class */
  protected StringChangeListener _scl = new StringChangeListener();

  /*====================================================================*/
  /** ToggleChangeListener handles change events of database name option.
   */
  private class ToggleChangeListener
    implements ChangeListener<Toggle>
  {
    /*------------------------------------------------------------------*/
    /** if the scheme choice changed, redisplay Host/Folder and JDBC URL.
     * @param ovs observable value.
     * @param sOld old string.
     * @param sNew new string.
     */
    @Override
    public void changed(ObservableValue<? extends Toggle> ovt,
        Toggle tOld, Toggle tNew)
    {
      SiardConnection sc = SiardConnection.getSiardConnection();
      String sScheme = _mapSchemes.get(getSelectedTitle());
      int iSelectedOption = getSelectedOption();
      String sSampleUrl = sc.getSampleUrl(sScheme, _tfDbHost.getText(), _tfDbFolder.getText(), _tfDbName.getText(),iSelectedOption);
      _tfConnectionUrl.setText(sSampleUrl);
    } /* changed */
  } /* class */
  protected ToggleChangeListener _tcl = new ToggleChangeListener();

  /*====================================================================*/
  /** PastingTextField implements non-editable field which can receive
   * paste events and serve as a drop target.
   */
  private class PastingTextField
    extends TextField
  {
    private boolean bChangeable = false;
    PastingTextField(String s)
    {
      super(s);
    }
    @Override
    public void replaceText(int start, int end, String text)
    {
      if (bChangeable)
        super.replaceText(start, end, text);
    }
    public void changeText(String s)
    {
      bChangeable = true;
      setText(s);
      bChangeable = false;
    }
    @Override
    public void paste()
    {
      Clipboard cb = Clipboard.getSystemClipboard();
      String sPasted = cb.getString();
      File file = new File(sPasted);
      // if we have a file, it gets priority over the string
      List<File> listFiles = cb.getFiles();
      if (listFiles.size() == 1)
        file = listFiles.get(0);
      if (file.isDirectory())
        changeText(file.getAbsolutePath());
    }
  } /* class */
  /*====================================================================*/

  /*------------------------------------------------------------------*/
  private String getSelectedTitle()
  {
    String sTitle = _cbDbScheme.getSelectionModel().getSelectedItem();
    if (sTitle == null)
    {
      UserProperties up = UserProperties.getUserProperties();
      String sScheme = up.getDatabaseScheme();
      for (Iterator<String> iterScheme = _mapSchemes.keySet().iterator(); iterScheme.hasNext(); )
      {
        String sTitleTry = iterScheme.next();
        if (_mapSchemes.get(sTitleTry).equals(sScheme))
          sTitle = sTitleTry;
      }
      _cbDbScheme.getSelectionModel().select(sTitle);
    }
    return sTitle;
  } /* getSelectedTitle */

  private int getSelectedOption()
  {
    int iSelectedOption = 0;
    if (_tgOptions != null)
    {
      RadioButton rbSelected = (RadioButton)_tgOptions.getSelectedToggle();
      SiardConnection sc = SiardConnection.getSiardConnection();
      String sScheme = _mapSchemes.get(getSelectedTitle());
      for (int iOption = 0; iOption < sc.getOptions(sScheme); iOption++)
      {
        if (sc.getOption(sScheme, iOption).equals(rbSelected.getText()))
          iSelectedOption = iOption;
      }
    }
    return iSelectedOption;
  } /* getSelectedOption */

  /*------------------------------------------------------------------*/
  /** compute the maximum pref width of the given labels and set their
   * min and pref widths to that value.
   * @param aLabels labels.
   * @return maximum pref width.
   */
  protected double getMaxLabelPrefWidth(Label... aLabel)
  {
    double dMaxPrefWidth = 0.0;
    for (int iLabel = 0; iLabel < aLabel.length; iLabel++)
    {
      Label lbl = aLabel[iLabel];
      if (lbl != null)
      {
        double dPrefWidth = lbl.getPrefWidth();
        if (dMaxPrefWidth < dPrefWidth)
          dMaxPrefWidth = dPrefWidth;
      }
    }
    for (int iLabel = 0; iLabel < aLabel.length; iLabel++)
    {
      Label lbl = aLabel[iLabel];
      if (lbl != null)
      {
        lbl.setMinWidth(dMaxPrefWidth);
        lbl.setPrefWidth(dMaxPrefWidth);
      }
    }
    return dMaxPrefWidth;
  } /* getMaxLabelPrefWidth */

  /*------------------------------------------------------------------*/
  /** compute the maximum min width of the given Panes.
   * @param apane Panes.
   * @return maximum min width.
   */
  protected double getMaxPaneMinWidth(Pane... apane)
  {
    double dMaxMinWidth = 0.0;
    for (int iPane = 0; iPane < apane.length; iPane++)
    {
      Pane pane = apane[iPane];
      if (pane != null)
      {
        double dMinWidth = pane.getMinWidth();
        if (dMaxMinWidth < dMinWidth)
          dMaxMinWidth = dMinWidth;
      }
    }
    return dMaxMinWidth;
  } /* getMaxPaneMinWidth */

  /*------------------------------------------------------------------*/
  /** remove the given toggle group.
   * @param tg toggle group to remove, or null.
   */
  protected void removeToggleGroup(ToggleGroup tg)
  {
    /* remove radio buttons from HBox */
    if (tg != null)
    {
      HBox hbox = (HBox)_tfDbName.getParent();
      for (int iOption = 0; iOption < tg.getToggles().size(); iOption++)
        hbox.getChildren().remove(tg.getToggles().get(iOption));
    }
  } /* removeToggleGroup */

  /*------------------------------------------------------------------*/
  /** create a toggle group for the given database scheme.
   * @param sScheme database scheme.
   * @return toggle group, or null, if no toggle group is associated with the scheme.
   */
  protected ToggleGroup createToggleGroup(String sScheme)
  {
    ToggleGroup tg = null;
    UserProperties up = UserProperties.getUserProperties();
    SiardConnection sc = SiardConnection.getSiardConnection();
    int iOptions = sc.getOptions(sScheme);
    if (iOptions > 1)
    {
      HBox hbox = (HBox)_tfDbName.getParent();
      tg = new ToggleGroup();
      for (int iOption = 0; iOption < iOptions; iOption++)
      {
        RadioButton rb = new RadioButton();
        rb.setText(sc.getOption(sScheme,iOption));
        rb.setToggleGroup(tg);
        rb.selectedProperty().set(iOption == up.getDatabaseOption());
        hbox.getChildren().add(rb);
      }
      tg.selectedToggleProperty().addListener(_tcl);
    }
    return tg;
  } /* createToggleGroup */

  /*------------------------------------------------------------------*/
  /** create a label for the given node.
   * @param sLabel label text
   * @param nodeFor node associated with label.
   * @return label.
   */
  protected Label createLabel(String sLabel, Node nodeFor)
  {
    Label lbl = new Label(sLabel);
    lbl.setPrefWidth(FxSizes.getNodeWidth(lbl));
    lbl.setLabelFor(nodeFor);
    return lbl;
  } /* createLabel */

  /*------------------------------------------------------------------*/
  /** create a horizontal box with label and text
   * @param lbl Label.
   * @param ptfText field for text
   * @param btn button for selector
   * @return horizontal box.
   */
  protected HBox createHBox(Label lbl, PastingTextField ptfText, Button btn)
  {
    HBox hbox = new HBox();
    lbl.setAlignment(Pos.BASELINE_RIGHT);
    hbox.setPadding(new Insets(dINNER_PADDING));
    hbox.setSpacing(dHSPACING);
    hbox.setAlignment(Pos.TOP_LEFT);
    hbox.getChildren().add(lbl);
    hbox.getChildren().add(ptfText);
    HBox.getHgrow(ptfText);
    hbox.getChildren().add(btn);
    hbox.setMinWidth(lbl.getPrefWidth() + dHSPACING +
        ptfText.getPrefWidth() + dHSPACING +
        btn.getPrefWidth());
    return hbox;
  } /* createHBox */

  /*------------------------------------------------------------------*/
  /** create a horizontal box with label and text
   * @param lbl Label.
   * @param node TextField/Checkbox
   * @return horizontal box.
   */
  protected HBox createHBox(Label lbl, Node node)
  {
    HBox hbox = new HBox();
    lbl.setAlignment(Pos.BASELINE_RIGHT);
    hbox.setPadding(new Insets(dINNER_PADDING));
    hbox.setSpacing(dHSPACING);
    hbox.setAlignment(Pos.TOP_LEFT);
    hbox.getChildren().add(lbl);
    hbox.getChildren().add(node);
    double dWidth = 0.0;

    /**
     * AS-IS
    if (node instanceof TextField)// PasswordField is a TextField
      dWidth = ((TextField)node).getPrefWidth();
    else if (node instanceof CheckBox)
      dWidth = ((CheckBox)node).getWidth();
    */

    // TODO 최창근 수정 - 동적 크기조절을 위한 설정
    HBox.setHgrow(node, Priority.ALWAYS);
    if (node instanceof TextField) // PasswordField is a TextField
    	dWidth = ((TextField)node).getPrefWidth();
    else if (node instanceof CheckBox)
    	dWidth = ((CheckBox)node).getWidth();
    hbox.setMinWidth(lbl.getPrefWidth() + dHSPACING + dWidth);
    return hbox;
  } /* createHBox */

  /*------------------------------------------------------------------*/
  /** create a horizontal box with label and text and options
   * @param lbl Label.
   * @param tf TextField
   * @param tg ToggleGroup with RadioButtons
   * @return horizontal box.
   */
  protected HBox createHBox(Label lbl, TextField tf, ToggleGroup tg)
  {
    HBox hbox = new HBox();
    lbl.setAlignment(Pos.BASELINE_RIGHT);
    hbox.setPadding(new Insets(dINNER_PADDING));
    hbox.setSpacing(dHSPACING);
    hbox.setAlignment(Pos.TOP_LEFT);
    hbox.getChildren().add(lbl);
    hbox.getChildren().add(tf);
    double dWidth = tf.getPrefWidth();
    for (int iToggle = 0; iToggle < tg.getToggles().size(); iToggle++)
    {
      RadioButton rb = (RadioButton)tg.getToggles().get(iToggle);
      hbox.getChildren().add(rb);
      dWidth = dWidth + dHSPACING + rb.getPrefWidth();
    }
    hbox.setMinWidth(lbl.getPrefWidth() + dHSPACING + dWidth);
    return hbox;
  } /* createHBox */

  /*------------------------------------------------------------------*/
  /** create the VBox containing the parameters database server and
   * database name.
   * @return parameters VBox.
   */
  private VBox createVBoxParameters()
  {
    UserProperties up = UserProperties.getUserProperties();
    SiardBundle sb = SiardBundle.getSiardBundle();
    VBox vbox = new VBox();
    vbox.setPadding(new Insets(dINNER_PADDING));
    vbox.setSpacing(dVSPACING);
    vbox.setAlignment(Pos.TOP_LEFT);

    String sScheme = up.getDatabaseScheme();
    String sTitle = null;
    ObservableList<String> olScheme = FXCollections.observableArrayList();
    SiardConnection sc = SiardConnection.getSiardConnection();
    String[] asScheme = sc.getSchemes();
    for (int iScheme = 0; iScheme < asScheme.length; iScheme++)
    {
      String sSch = asScheme[iScheme];
      String sTit = sc.getTitle(sSch);
      if (sSch.equals(sScheme))
        sTitle = sTit;
      olScheme.add(sTit);
      _mapSchemes.put(sTit, sSch);
    }

    _cbDbScheme = new ComboBox<String>(olScheme);
    _cbDbScheme.setTooltip(new Tooltip(sb.getConnectionDbSchemeTooltip()));
    _cbDbScheme.getSelectionModel().select(sTitle);
    _cbDbScheme.getSelectionModel().selectedItemProperty().addListener(_scl);

    HBox.setHgrow(_cbDbScheme, Priority.ALWAYS);
    Label lblDbSchemeLabel = createLabel(sb.getConnectionDbSchemeLabel(),_cbDbScheme);
    /* select the element for the connection URL in combo box */

    _tfDbHost = new TextField(up.getDatabaseHost());
    _tfDbHost.textProperty().addListener(_scl);
    HBox.setHgrow(_tfDbHost, Priority.ALWAYS);
    Label lblDbHostLabel = createLabel(sb.getConnectionDbHostLabel(),_tfDbHost);

    _tfDbFolder = new PastingTextField(up.getDatabaseFolder().getAbsolutePath());
    _tfDbFolder.textProperty().addListener(_scl);
    HBox.setHgrow(_tfDbFolder, Priority.ALWAYS);
    _tfDbFolder.setOnDragOver(_deh);
    _tfDbFolder.setOnDragDropped(_deh);

    _btnDbFolder = new Button(sb.getConnectionDbFolderButton());
    _btnDbFolder.setOnAction(_aeh);
    _btnDbFolder.setAlignment(Pos.BASELINE_RIGHT);
    _btnDbFolder.setMinWidth(FxSizes.getNodeWidth(_btnDbFolder));
    Label lblDbFolderLabel = createLabel(sb.getConnectionDbFolderLabel(),_tfDbFolder);

    _tfDbName = new TextField(up.getDatabaseName(sScheme));
    _tfDbName.textProperty().addListener(_scl);
    HBox.setHgrow(_tfDbName, Priority.ALWAYS);
    Label lblDbNameLabel = createLabel(sb.getConnectionDbNameLabel(),_tfDbName);

    int iOptions = sc.getOptions(sScheme);
    RadioButton rbSelected = null;
    if (iOptions > 1)
    {
      _tgOptions = new ToggleGroup();
      for (int iOption = 0; iOption < iOptions; iOption++)
      {
        RadioButton rb = new RadioButton();
        rb.setToggleGroup(_tgOptions);
        rb.selectedProperty().set(iOption == up.getDatabaseOption());
        rb.setText(sc.getOption(sScheme, iOption));
        if (iOption == up.getDatabaseOption())
          rbSelected = rb;
      }
      _tgOptions.selectToggle(rbSelected);
      _tgOptions.selectedToggleProperty().addListener(_tcl);
    }

    getMaxLabelPrefWidth(lblDbSchemeLabel,lblDbHostLabel,lblDbNameLabel,lblDbFolderLabel);

    HBox hboxDbScheme = createHBox(lblDbSchemeLabel, _cbDbScheme);
    vbox.getChildren().add(hboxDbScheme);
    _hboxDbHost = createHBox(lblDbHostLabel, _tfDbHost);
    if (!sc.isLocal(sScheme))
      vbox.getChildren().add(_hboxDbHost);
    _hboxDbFolder = createHBox(lblDbFolderLabel, _tfDbFolder, _btnDbFolder);
    if (sc.isLocal(sScheme))
      vbox.getChildren().add(_hboxDbFolder);
    HBox hboxDbName = null;
    if (iOptions == 1)
      hboxDbName = createHBox(lblDbNameLabel, _tfDbName);
    else
      hboxDbName = createHBox(lblDbNameLabel, _tfDbName, _tgOptions);
    vbox.getChildren().add(hboxDbName);

    double dMinWidth = getMaxPaneMinWidth(hboxDbScheme,_hboxDbHost,_hboxDbFolder,hboxDbName);
    vbox.setMinWidth(dMinWidth);
    return vbox;
  } /* createVBoxParameters */

  /*------------------------------------------------------------------*/
  /** create a text field element for the connection URL.
   * @return text field element for connection URL.
   */
  private TextField createTextFieldConnectionUrl()
  {
    String sScheme = _mapSchemes.get(getSelectedTitle());
    int iOption = getSelectedOption();
    SiardConnection sc = SiardConnection.getSiardConnection();
    String sSampleUrl = sc.getSampleUrl(sScheme, _tfDbHost.getText(), _tfDbFolder.getText(), _tfDbName.getText(),iOption);
    TextField tf = new TextField(sSampleUrl);
    tf.setPrefWidth(dWIDTH_URL);
    if (_sConnectionUrl != null)
      tf.setText(_sConnectionUrl);
    return tf;
  } /* createTextFieldConnectionUrl */

  /*------------------------------------------------------------------*/
  /** create the HBox with the error message, Cancel and OK button.
   * @return HBox with the error message, Cancel and OK button.
   */
  private HBox createHBoxButtons()
  {
    SiardBundle sb = SiardBundle.getSiardBundle();
    /* ok button */
    _btnDefault = new Button(sb.getOk());
    _btnDefault.setDefaultButton(true);
    _btnDefault.setOnAction(_aeh);
    double dMinWidth = _btnDefault.getLayoutBounds().getWidth();
    /* cancel button */
    _btnCancel = new Button(sb.getCancel());
    _btnCancel.setCancelButton(true);
    _btnCancel.setOnAction(_aeh);
    dMinWidth += dHSPACING + _btnCancel.getLayoutBounds().getWidth();
    _tfError = new TextField("");
    _tfError.setBackground(Background.EMPTY);
    _tfError.setStyle(FxStyles.sSTYLE_ERROR);
    HBox.setHgrow(_tfError, Priority.ALWAYS);
    /* HBox for buttons */
    HBox hboxButton = new HBox();
    hboxButton.setPadding(new Insets(dINNER_PADDING));
    hboxButton.setSpacing(dHSPACING);
    // hboxButton.setAlignment(Pos.TOP_LEFT);
    hboxButton.getChildren().add(_tfError);
    hboxButton.getChildren().add(_btnDefault);
    hboxButton.getChildren().add(_btnCancel);
    HBox.setMargin(_tfError, new Insets(dOUTER_PADDING));
    HBox.setMargin(_btnDefault, new Insets(dOUTER_PADDING));
    HBox.setMargin(_btnCancel, new Insets(dOUTER_PADDING));
    hboxButton.setMinWidth(dMinWidth);
    return hboxButton;
  } /* createHBoxButton */

  /*------------------------------------------------------------------*/
  /** create the VBox for the connection URL.
   * @return VBox with connection URL.
   */
  private VBox createVBoxConnectionUrl()
  {
    /* VBox for connection URL */
    VBox vbox = new VBox();
    vbox.setPadding(new Insets(dOUTER_PADDING));
    vbox.setSpacing(dVSPACING/4.0);
    vbox.setStyle(FxStyles.sSTYLE_BACKGROUND_LIGHTGREY);
    vbox.setAlignment(Pos.TOP_LEFT);
    SiardBundle sb = SiardBundle.getSiardBundle();
    _tfConnectionUrl = createTextFieldConnectionUrl();
    _tfConnectionUrl.setTooltip(new Tooltip(sb.getConnectionUrlTooltip()));
    _tfConnectionUrl.textProperty().addListener(_scl);
    double dMinWidth = _tfConnectionUrl.getPrefWidth();
    Label lblConnectionUrl = createLabel(sb.getConnectionUrlLabel(),_tfConnectionUrl);
    if (dMinWidth < lblConnectionUrl.getPrefWidth())
      dMinWidth = lblConnectionUrl.getPrefWidth();
    vbox.getChildren().add(lblConnectionUrl);
    vbox.getChildren().add(_tfConnectionUrl);
    vbox.setMinWidth(dMinWidth);
    return vbox;
  } /* createVBoxConnectionUrl */

  /*------------------------------------------------------------------*/
  /** create the VBox with the connection parameters.
   * @param sLoadMetaDataOnlyLabel label for meta data only check box.
   * @param sLoadMetaDataOnlyTooltip tool tip for meta data only check box.
   * @param sLoadOverwriteLabel label for overwrite check box.
   * @param sLoadOverwriteTooltip tool tip for overwrite check box.
   * @param sLoadViewsAsTablesLabel label for views as tables check box.
   * @param sLoadViewsAsTablesTooltip tool tip for views as tables check box.
   * @return VBox with the connection parameters.
   */
  protected VBox createVBoxConnectionParameters(
      String sLoadMetaDataOnlyLabel, String sLoadMetaDataOnlyTooltip,
      String sLoadOverwriteLabel, String sLoadOverwriteTooltip,
      String sLoadViewsAsTablesLabel, String sLoadViewsAsTablesTooltip)
  {
    SiardBundle sb = SiardBundle.getSiardBundle();
    UserProperties up = UserProperties.getUserProperties();
    _tfDbUser = new TextField();
    if (_sDbUser != null)
      _tfDbUser.setText(_sDbUser);
    else
      _tfDbUser.setText(up.getDatabaseUser());
    _tfDbUser.setTooltip(new Tooltip(sb.getConnectionDbUserTooltip()));
    _tfDbUser.textProperty().addListener(_scl);

    Label lblDbUser = createLabel(sb.getConnectionDbUserLabel()+":",_tfDbUser);
    _pfDbPassword = new PasswordField();
    _pfDbPassword.setTooltip(new Tooltip(sb.getConnectionDbPasswordTooltip()));

    Label lblDbPassword = createLabel(sb.getConnectionDbPasswordLabel()+":",_pfDbPassword);
    _cbMetaDataOnly = new CheckBox();
    _cbMetaDataOnly.setTooltip(new Tooltip(sLoadMetaDataOnlyTooltip));
    _cbMetaDataOnly.setAllowIndeterminate(false);

    Label lblMetaDataOnly = createLabel(sLoadMetaDataOnlyLabel+":",_cbMetaDataOnly);
    Label lblOverwrite = null;
    if (sLoadOverwriteLabel != null)
    {
      _cbOverwrite = new CheckBox();
      _cbOverwrite.setTooltip(new Tooltip(sLoadOverwriteTooltip));
      _cbOverwrite.setAllowIndeterminate(false);
      lblOverwrite  = createLabel(sLoadOverwriteLabel+":",_cbOverwrite);
    }
    Label lblViewsAsTables = null;
    if (sLoadViewsAsTablesLabel != null)
    {
      _cbViewsAsTables = new CheckBox();
      _cbViewsAsTables.setTooltip(new Tooltip(sLoadViewsAsTablesTooltip));
      _cbViewsAsTables.setAllowIndeterminate(false);
      lblViewsAsTables  = createLabel(sLoadViewsAsTablesLabel+":",_cbViewsAsTables);
    }

		Label lblFileDown 		= createLabel("파일 다운로드 방식 :", _hboxRadio);
		Label lblOriginalDir 	= createLabel("파일 위치 :", _tfOriginalDir);
		Label lblTargetDir 		= createLabel("저장 위치 :", _tfTargetDir);
		Label lblFilePath 		= createLabel("저장경로 필드명 :", _tfFilePath);
		Label lblSchema  		= createLabel("스키마명 :", _hboxSchema);
		Label lblSelectCheck 	= createLabel("테이블 목록 :", _tvSelectTable);

    double dLabelWidth = this.getMaxLabelPrefWidth(lblDbUser,lblDbPassword,lblMetaDataOnly,lblOverwrite,
		        lblViewsAsTables, lblOriginalDir, lblTargetDir, lblFilePath, lblSchema, lblSelectCheck, lblFileDown);

    double dTextWidth = dWIDTH_URL - dLabelWidth - dHSPACING;
    _tfDbUser.setPrefWidth(dTextWidth);
    _pfDbPassword.setPrefWidth(dTextWidth);
		_tfOriginalDir.setPrefWidth(dTextWidth);
		_tfTargetDir.setPrefWidth(dTextWidth);
		_tvSelectTable.setPrefWidth(dTextWidth);

    VBox vbox = new VBox();
    vbox.setPadding(new Insets(dINNER_PADDING));
    vbox.setSpacing(dVSPACING);
    vbox.setAlignment(Pos.TOP_LEFT);

    HBox hboxDbUser = createHBox(lblDbUser,_tfDbUser);
    vbox.getChildren().add(hboxDbUser);

    HBox hboxDbPassword = createHBox(lblDbPassword,_pfDbPassword);
    vbox.getChildren().add(hboxDbPassword);

    HBox hboxMetaDataOnly = createHBox(lblMetaDataOnly,_cbMetaDataOnly);
    vbox.getChildren().add(hboxMetaDataOnly);

		_radioSftp.setToggleGroup(_groupFile);
		_radioCopy.setToggleGroup(_groupFile);

		_radioSftp.setSelected(true);
		_radioCopy.setSelected(false);

		_hboxRadio.getChildren().add(_radioSftp);
		_hboxRadio.setSpacing(3);
		_hboxRadio.getChildren().add(_radioCopy);

		HBox hboxFileDown = createHBox(lblFileDown, _hboxRadio);		//파일다운로드 선택 라디오버튼
		vbox.getChildren().add(hboxFileDown);

		HBox hboxOriginalDir = createHBox(lblOriginalDir, _tfOriginalDir);
		vbox.getChildren().add(hboxOriginalDir);

		HBox hboxTargetDir = createHBox(lblTargetDir, _tfTargetDir);
		vbox.getChildren().add(hboxTargetDir);

		HBox hboxFilePath = createHBox(lblFilePath, _tfFilePath);
		vbox.getChildren().add(hboxFilePath);

		_hboxSchema.getChildren().add(_tfSchema);
		_hboxSchema.setSpacing(3);
		_hboxSchema.getChildren().add(new Label("(메타데이터 다운로드 속도 개선)"));

		HBox hboxSchema = createHBox(lblSchema, _hboxSchema);
		vbox.getChildren().add(hboxSchema);

		// 테이블 목록 보여주기
		// colname1.setCellValueFactory(new PropertyValueFactory<>("tableName"));
		// colname2.setCellValueFactory(new PropertyValueFactory<>("check"));

		TableColumn<TableName, String> c1 = new TableColumn<TableName, String>("테이블명");
		c1.setCellValueFactory(new PropertyValueFactory<TableName, String>("TableName"));

		TableColumn<TableName, Boolean> c2 = new TableColumn<TableName, Boolean>("선택");

		c2.setCellValueFactory(new PropertyValueFactory<TableName, Boolean>("check"));

		c2.setCellFactory(CheckBoxTableCell.forTableColumn(c2));

		//c2.setEditable(true);

		c1.prefWidthProperty().bind(_tvSelectTable.widthProperty().multiply(0.75));
		c2.prefWidthProperty().bind(_tvSelectTable.widthProperty().multiply(0.2));

		_tvSelectTable.getColumns().add(c1);
		_tvSelectTable.getColumns().add(c2);
		_tvSelectTable.setEditable(true);

//		rowdata.add(new TableName("ABCD", true));
//		_tvSelectTable.setItems(rowdata);

		HBox hboxBtn = new HBox();

		hboxBtn.getChildren().add(_lblUser);
		hboxBtn.setSpacing(3);
		hboxBtn.getChildren().add(_tfUser);
		hboxBtn.setSpacing(10);
		hboxBtn.getChildren().add(_lblPassword);
		hboxBtn.setSpacing(3);
		hboxBtn.getChildren().add(_pfTable);
		hboxBtn.setSpacing(10);
		hboxBtn.getChildren().add(_btnTableName);
		hboxBtn.setSpacing(10);
		hboxBtn.getChildren().add(_cbkAll);

		//버튼을 누르면 테이블명을 가져온다.
		//오라클만 가능
		_btnTableName.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event)
		    {
				getTableNames();
		    }
		});

		//버튼을 누르면 테이블명을 가져온다.
		//오라클만 가능
		_btnChecked.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event)
		    {
		    	ObservableList<TableName> rowdata_checked =  _tvSelectTable.getItems();

		    	for(int ix = 0; ix < rowdata_checked.size(); ix++)
		    	{
		    		TableName tablename_check = rowdata_checked.get(ix);

		    		String str_checked = "";
		    		if(tablename_check.getCheck().get() == true)
		    		{
		    			str_checked = "CHECK!!!!!!!!!!!!";
		    		}
		    	}
		    }
		});

		//버튼을 누르면 테이블명을 가져온다.
		//오라클만 가능
		_cbkAll.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event)
		    {
		    	setTableNamesChecked(_cbkAll.isSelected());
		    	_tvSelectTable.refresh();
		    }
		});

		VBox vboxSelectTable = new VBox();
		vboxSelectTable.setSpacing(5);
		vboxSelectTable.getChildren().add(hboxBtn);
		vboxSelectTable.getChildren().add(_tvSelectTable);

		HBox hboxSelectTable = createHBox(lblSelectCheck, vboxSelectTable);
		vbox.getChildren().add(hboxSelectTable);

    HBox hboxOverwrite = null;
    if (sLoadOverwriteLabel != null)
    {
      hboxOverwrite = createHBox(lblOverwrite,_cbOverwrite);
      vbox.getChildren().add(hboxOverwrite);
    }

    HBox hboxViewsAsTables = null;
    if (sLoadViewsAsTablesLabel != null)
    {
      hboxViewsAsTables = createHBox(lblViewsAsTables,_cbViewsAsTables);
      vbox.getChildren().add(hboxViewsAsTables);
    }
    double dMinWidth = getMaxPaneMinWidth(hboxDbUser,hboxDbPassword,hboxMetaDataOnly,hboxOverwrite,hboxViewsAsTables);
    vbox.setMinWidth(dMinWidth);
    return vbox;
  } /* createVBoxConnectionParameters */

  /*------------------------------------------------------------------*/
  /** create the main VBox of the dialog
   * @param sLoadMetaDataOnlyLabel label for meta data only check box.
   * @param sLoadMetaDataOnlyTooltip tool tip for meta data only check box.
   * @param sLoadOverwriteLabel label for overwrite check box.
   * @param sLoadOverwriteTooltip tool tip for overwrite check box.
   * @param sLoadViewsAsTablesLabel label for views as tables check box.
   * @param sLoadViewsAsTablesTooltip tool tip for views as tables check box.
   * @return main VBox
   */
  private VBox createVBoxDialog(
      String sLoadMetaDataOnlyLabel, String sLoadMetaDataOnlyTooltip,
      String sLoadOverwriteLabel, String sLoadOverwriteTooltip,
      String sLoadViewsAsTablesLabel, String sLoadViewsAsTablesTooltip)
  {
    VBox vbox = new VBox();
    vbox.setPadding(new Insets(dOUTER_PADDING));
    vbox.setSpacing(dVSPACING);
    vbox.setStyle(FxStyles.sSTYLE_BACKGROUND_LIGHTGREY);

    _vboxParameters = createVBoxParameters();
    vbox.getChildren().add(_vboxParameters);

    vbox.getChildren().add(new Separator());

    VBox vboxConnectionUrl = createVBoxConnectionUrl();
    vbox.getChildren().add(vboxConnectionUrl);

    VBox vboxConnectionParameters = createVBoxConnectionParameters(
        sLoadMetaDataOnlyLabel, sLoadMetaDataOnlyTooltip,
        sLoadOverwriteLabel, sLoadOverwriteTooltip,
        sLoadViewsAsTablesLabel, sLoadViewsAsTablesTooltip);
    vbox.getChildren().add(vboxConnectionParameters);

    vbox.getChildren().add(new Separator());

    HBox hboxButton = createHBoxButtons();
    vbox.getChildren().add(hboxButton);

    double dMinWidth = getMaxPaneMinWidth(_vboxParameters,vboxConnectionUrl,vboxConnectionParameters,hboxButton);
    vbox.setMinWidth(dMinWidth);
    return vbox;
  } /* createVBoxDialog */

  /*------------------------------------------------------------------*/
  /** display the connection dialog.
   * @param stageOwner owner window.
   * @param sConnectionUrl initial value for connection (JDBC) URL or null.
   * @param sDbUser initial value for user of database or null.
   * @param sTitle title of the dialog.
   * @param sLoadMetaDataOnlyLabel label for meta data only check box.
   * @param sLoadMetaDataOnlyTooltip tool tip for meta data only check box.
   * @param sLoadOverwriteLabel label for overwrite check box.
   * @param sLoadOverwriteTooltip tool tip for overwrite check box.
   * @param sLoadViewsAsTablesLabel label for views as tables check box.
   * @param sLoadViewsAsTablesTooltip tool tip for views as tables check box.
   */
  protected ConnectionDialog(Stage stageOwner, String sConnectionUrl, String sDbUser,
    String sTitle, String sLoadMetaDataOnlyLabel, String sLoadMetaDataOnlyTooltip,
    String sLoadOverwriteLabel, String sLoadOverwriteTooltip,
    String sLoadViewsAsTablesLabel, String sLoadViewsAsTablesTooltip)
  {
    super(stageOwner,sTitle);

    LOG.info("");

    //TODO 최창근 추가 - SQLite insert 테스트 후 삭제
	CommonDAO dao = new CommonDAO();
	try {
		dao.insertHistory();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

    _sConnectionUrl = sConnectionUrl;
    _sDbUser = sDbUser;
    double dMinWidth = FxSizes.getTextWidth(sTitle)+FxSizes.getCloseWidth()+dHSPACING;
    VBox vboxDialog = createVBoxDialog(sLoadMetaDataOnlyLabel, sLoadMetaDataOnlyTooltip,
        sLoadOverwriteLabel, sLoadOverwriteTooltip, sLoadViewsAsTablesLabel, sLoadViewsAsTablesTooltip);
    if (dMinWidth < vboxDialog.getMinWidth())
      dMinWidth = vboxDialog.getMinWidth();
    /* adapt dialog width to screen */
    dMinWidth += 2*dOUTER_PADDING;
    Rectangle2D rectScreen = FxSizes.getScreenBounds();
    if (dMinWidth >= rectScreen.getWidth())
      dMinWidth = rectScreen.getWidth()-2*dSCREEN_PADDING;
    setMinWidth(dMinWidth);
    /* scene */
    Scene scene = new Scene(vboxDialog);
    setScene(scene);

    // TODO 최창근 추가 - 테스트 후 삭제
    testInit();
  } /* constructor DownloadConnectionDialog */

	// 테이블명을 가져온다.
	private void getTableNames()
	{
		this._cbkAll.setSelected(true);
		_tvSelectTable.getItems().clear();

		String dbsystem 			= "";
		String url 					= "";
		String user 				= "";
		String password 			= "";

		String driverName 			= "";
		String sql 					= "";

		Connection connection 		= null;
		Statement statement			= null;
		ResultSet resultset			= null;

		String driverNameOracle 	= "oracle.jdbc.driver.OracleDriver";
		String driverNameCubrid 	= "cubrid.jdbc.driver.CUBRIDDriver";
		String driverNameMysql 		= "com.mysql.jdbc.Driver";
		String driverNameMssql 		= "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String driverNameMsAccess 	= "sun.jdbc.odbc.JdbcOdbcDriver";
		String driverNamePostgresql = "org.postgresql.Driver";

		String sqlOracle 			= "";
		String sqlMysql 			= "SHOW FULL TABLES WHERE TABLE_TYPE = 'BASE TABLE'";
		String sqlMssql 			= "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES";
		String sqlMsAccess			= "SELECT MsysObjects.Name FROM MSysObjects WHERE Type = 1";
		String sqlCubrid 			= "";

		dbsystem = _cbDbScheme.getSelectionModel().getSelectedItem().toString();

		if(dbsystem.equals("Oracle"))
		{
			driverName 	= driverNameOracle;

			url 		= _tfConnectionUrl.getText();
			user 		= _tfDbUser.getText();
			password 	= _pfDbPassword.getText();

			String owner = _tfUser.getText();
//			sqlOracle   = "SELECT OBJECT_NAME FROM DBA_OBJECTS WHERE OBJECT_TYPE = 'TABLE' AND OWNER = '" + owner.toUpperCase() + "' ORDER BY OBJECT_NAME";
			sqlOracle   = "SELECT TABLE_NAME FROM ALL_TABLES WHERE OWNER = '" + owner.toUpperCase() + "' ORDER BY TABLE_NAME";
			sql 		= sqlOracle;
		}
		else if(dbsystem.equals("MySQL"))
		{
			driverName 	= driverNameMysql;

			sql 		= sqlMysql;
			url 		= _tfConnectionUrl.getText();
			user 		= _tfUser.getText();
			password 	= _pfTable.getText();
		}
		else if(dbsystem.equals("Microsoft Access"))
		{
			driverName 	= driverNameMsAccess;

			sql 		= sqlMsAccess;
			url 		= _tfConnectionUrl.getText();
			user 		= _tfUser.getText();
			password 	= _pfTable.getText();
		}
		else if(dbsystem.equals("CUBRID"))
		{
			driverName 	= driverNameCubrid;

			url 		= _tfConnectionUrl.getText();
			user 		= _tfUser.getText();
			password 	= _pfTable.getText();

			/* S: Cubrid 테이블 목록조회 쿼리 오류 수정 */
			String owner = _tfUser.getText();
			sqlCubrid	 = "SELECT CLASS_NAME FROM DB_CLASS WHERE OWNER_NAME = '" + owner.toUpperCase() + "'" + " AND CLASS_TYPE = 'CLASS' AND IS_SYSTEM_CLASS = 'NO'";
			sql 		 = sqlCubrid;
			/* E: Cubrid 테이블 목록조회 쿼리 오류 수정 */
		}
		/*2020.07.14 - MsSQL(SQL Server) 드라이버 추가*/
		else if(dbsystem.equals("SQL Server"))
		{
			driverName 	= driverNameMssql;

			sql 		= sqlMssql;
			url 		= _tfConnectionUrl.getText();
			user 		= _tfUser.getText();
			password 	= _pfTable.getText();
		}
		/*2020.07.17 - PostgreSQL 드라이버 추가*/
		else if(dbsystem.equals("PostgreSQL"))
		{
			driverName 	= driverNamePostgresql;

			url 		= _tfConnectionUrl.getText();
			user 		= _tfUser.getText();
			password 	= _pfTable.getText();

			sqlCubrid 	= "SELECT TABLENAME FROM PG_TABLES WHERE TABLEOWNER = '" + user.toLowerCase().trim() + "'";
			sql 		= sqlCubrid;
		}

		try
		{
			Class.forName(driverName);

//			System.out.println("url:" + url);
//			System.out.println("user:" + user);
//			System.out.println("password:" + password);
//			System.out.println("sql:" + sql);

			connection = DriverManager.getConnection(url, user, password);
			statement = connection.createStatement();
			resultset = statement.executeQuery(sql);

			while (resultset.next())
			{
				String tablename = resultset.getString(1);

				TableName tablenames = new TableName(tablename, true);
				rowdata.add(tablenames);
				//_tvSelectTable.getItems().add(rowdata);
			}

			_tvSelectTable.setItems(rowdata);

			if(resultset != null)
			{
				resultset.close();
				resultset = null;
			}

			if(statement != null)
			{
				statement.close();
				statement = null;
			}

			if(connection != null)
			{
				connection.close();
				connection = null;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void setCheckedTableList()
	{
		ObservableList<TableName> rowdata_checked =  _tvSelectTable.getItems();

		ArrayList<String> list = new ArrayList<String>();

    	for(int ix = 0; ix < rowdata_checked.size(); ix++)
    	{
    		TableName tablename_check = rowdata_checked.get(ix);

    		if(tablename_check.getCheck().get() == true)
    		{
    			list.add(tablename_check.getTableName());
    		}
    	}
	}

	public class TableName
	{
		public SimpleStringProperty	tableName;
		public BooleanProperty check;

		public TableName(String str, boolean c)
		{
			this.tableName = new SimpleStringProperty(str);
			this.check = new SimpleBooleanProperty(c);
		}

		public String getTableName()
		{
			return this.tableName.get();
		}

		public void setTableName(SimpleStringProperty str)
		{
			this.tableName = str;
		}

		public BooleanProperty getCheck()
		{
			return this.check;
		}

		public BooleanProperty checkProperty()
		{
			return check;
		}

		public void setCheck(Boolean check)
		{
			this.check = new SimpleBooleanProperty(check);
		}
	}

	public void setTableNamesChecked(boolean b)
	{
		ObservableList<TableName> rowdata_checked =  _tvSelectTable.getItems();

    	for(int ix = 0; ix < rowdata_checked.size(); ix++)
    	{
    		TableName tablename_check = rowdata_checked.get(ix);

    		tablename_check.setCheck(b);
    	}
	}

	/* 최창근 추가 - 테스트를 위한 LocalDB 정보로 Set */
	void testInit() {

		_cbDbScheme.getSelectionModel().select("MySQL");

		_tfDbHost.setText("192.168.1.152");

		_tfDbName.setText("MYSQL");

		_tfConnectionUrl.setText("jdbc:mysql://192.168.1.152:3306/Mysql?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8");

		_tfDbUser.setText("root");

		_pfDbPassword.setText("root");

		_tfUser.setText("root");

		_pfTable.setText("root");
	}
} /* class ConnectionDialog */
