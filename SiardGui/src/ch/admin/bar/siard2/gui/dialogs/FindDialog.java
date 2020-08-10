/*======================================================================
FindDialog asks for a string to find in the meta data.
Application : Siard2
Description : FindDialog asks for a string to find in the meta data.
Platform    : Java 7, JavaFX 2.2
------------------------------------------------------------------------
Copyright  : 2017, Enter AG, Rüti ZH, Switzerland
Created    : 16.08.2017, Hartwig Thomas
======================================================================*/
package ch.admin.bar.siard2.gui.dialogs;

import ch.admin.bar.siard2.gui.SiardBundle;
import ch.enterag.utils.fx.FxSizes;
import ch.enterag.utils.fx.FxStyles;
import ch.enterag.utils.fx.ScrollableDialog;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*====================================================================*/
/** FindDialog asks for a string to find in the meta data.
 * @author Hartwig Thomas
 */
public class FindDialog
  extends ScrollableDialog
  implements EventHandler<ActionEvent>
{
  private static final int iTEXT_COLUMNS = 32;
  private boolean _bCanceled = true; // just closing with the close button is canceling
  public boolean isCanceled() { return _bCanceled; }

  private TextField _tfFindString = null;
  public String getFindString()
  {
    return _tfFindString.getText();
  }
  private CheckBox _cbMatchCase = null;
  public boolean mustMatchCase() { return _cbMatchCase.isSelected(); }
  private Button _btnOk = null;
  private Button _btnCancel = null;

  /*------------------------------------------------------------------*/
  /** handle pressed button.
   * @param ae action event.
   */
  @Override
  public void handle(ActionEvent ae)
  {
    if ((ae.getSource() == _btnOk) && (getFindString().length() > 0))
      _bCanceled = false;
    close();
  } /* handle */

  /*------------------------------------------------------------------*/
  /** create a HBox with OK and Cancel button.
   * @param sOk text on OK button.
   * @param sCancel text on Cancel button.
   * @return HBox.
   */
  private HBox createButtonsHBox(String sOk, String sCancel)
  {
    HBox hbox = new HBox();
    hbox.setSpacing(dHSPACING);
    hbox.setStyle(FxStyles.sSTYLE_BACKGROUND_LIGHTGREY);
    hbox.setAlignment(Pos.BASELINE_RIGHT);
    /* buttons and their width */
    _btnOk = new Button(sOk);
    _btnOk.setDefaultButton(true);
    _btnOk.setOnAction(this);
    hbox.getChildren().add(_btnOk);
    _btnCancel = new Button(sCancel);
    _btnCancel.setCancelButton(true); // associate it with ESC key
    _btnCancel.setOnAction(this);
    hbox.getChildren().add(_btnCancel);
    return hbox;
  } /* createButtons */

  /*------------------------------------------------------------------*/
  /** create HBox with label and check box for match case.
   * @param sMatchCaseLabel label.
   * @param dLabelWidth width of label.
   * @param bMatchCase initial value of match case.
   * @return HBox with label and check box.
   */
  private HBox createMatchCaseHBox(String sMatchCaseLabel, double dLabelWidth,
    boolean bMatchCase)
  {
    HBox hbox = new HBox();
    hbox.setSpacing(dHSPACING);
    hbox.setStyle(FxStyles.sSTYLE_BACKGROUND_LIGHTGREY);
    _cbMatchCase = new CheckBox();
    _cbMatchCase.setSelected(bMatchCase);
    Label lblMatchCase = new Label(sMatchCaseLabel);
    lblMatchCase.setLabelFor(_cbMatchCase);
    lblMatchCase.setAlignment(Pos.BASELINE_RIGHT);
    hbox.getChildren().add(lblMatchCase);
    hbox.getChildren().add(_cbMatchCase);
    return hbox;
  } /* createMatchCaseHBox */

  /*------------------------------------------------------------------*/
  /** create HBox with label and text field for find string.
   * @param sFindStringLabel label.
   * @param dLabelWidth width of label.
   * @param sFindString initial value of find string.
   * @return HBox with label and text field.
   */
  private HBox createFindStringHBox(String sFindStringLabel, double dLabelWidth,
    String sFindString)
  {
    HBox hbox = new HBox();
    hbox.setSpacing(dHSPACING);
    hbox.setStyle(FxStyles.sSTYLE_BACKGROUND_LIGHTGREY);
    _tfFindString = new TextField();
    if (sFindString != null)
      _tfFindString.setText(sFindString);
    _tfFindString.setMinWidth(FxSizes.fromEms(iTEXT_COLUMNS));

    // 최창근 추가 - 텍스트필드 가변크기 변환을 위한 설정
    HBox.setHgrow(_tfFindString, Priority.ALWAYS);

    Label lblFindString = new Label(sFindStringLabel);
    lblFindString.setMinWidth(dLabelWidth);
    lblFindString.setLabelFor(_tfFindString);
    lblFindString.setAlignment(Pos.BASELINE_RIGHT);
    hbox.getChildren().add(lblFindString);
    hbox.getChildren().add(_tfFindString);
    return hbox;
  } /* createFindStringHBox */

  /*------------------------------------------------------------------*/
  /** create the main VBox of the dialog.
   * @param sb bundle.
   * @param sFindString initial find string value.
   * @param bMatchCase initial match case value.
   * @return main VBox.
   */
  private VBox createVBox(SiardBundle sb, String sFindString, boolean bMatchCase)
  {
    VBox vbox = new VBox();

    // 최창근 수정 - margin 값 수정
//    vbox.setPadding(new Insets(dINNER_PADDING));
    vbox.setPadding(new Insets(dOUTER_PADDING));
    vbox.setSpacing(dVSPACING);
    vbox.setStyle(FxStyles.sSTYLE_BACKGROUND_LIGHTGREY);
    String sFindStringLabel = sb.getFindStringLabel();
    String sMatchCaseLabel = sb.getFindMatchCaseLabel();
    double dLabelWidth = FxSizes.getTextWidth(sFindStringLabel);
    if (dLabelWidth < FxSizes.getTextWidth(sMatchCaseLabel))
      dLabelWidth = FxSizes.getTextWidth(sMatchCaseLabel);

    vbox.getChildren().add(createFindStringHBox(sFindStringLabel, dLabelWidth, sFindString));
    vbox.getChildren().add(createMatchCaseHBox(sMatchCaseLabel, dLabelWidth,bMatchCase));
    vbox.getChildren().add(createButtonsHBox(sb.getOk(),sb.getCancel()));

    vbox.setMinWidth(FxSizes.getNodeWidth(vbox));
    vbox.setMinHeight(FxSizes.getNodeHeight(vbox));

    return vbox;
  } /* createVBox */
  /*------------------------------------------------------------------*/
  /** constructor
   * @param stageOwner owner window.
   * @param sFindString initial find string value.
   * @param bMatchCase initial match case value.
   */
  private FindDialog(Stage stageOwner, String sFindString, boolean bMatchCase)
  {
    super(stageOwner,SiardBundle.getSiardBundle().getFindTitle());
    VBox vbox = createVBox(SiardBundle.getSiardBundle(), sFindString, bMatchCase);
    // 최창근 수정 - 가로, 세로 스크롤 제거를 위한 넓이, 높이 값 수정
    /* scene */
    // Scene scene = new Scene(vbox, vbox.getMinWidth()+10.0, vbox.getMinHeight()+10.0);
    Scene scene = new Scene(vbox, vbox.getMinWidth()+20.0, vbox.getMinHeight()+20.0);
    setScene(scene);
  } /* constructor */

  /*------------------------------------------------------------------*/
  /** shows find dialog.
   * @param stageOwner owner window.
   * @param sFindString initial find string value.
   * @param bMatchCase initial match case value.
   * @return find dialog with result.
   */
  public static FindDialog showFindDialog(Stage stageOwner,
    String sFindString, boolean bMatchCase)
  {
    FindDialog fd = new FindDialog(stageOwner,sFindString,bMatchCase);
    fd.showAndWait();
    return fd;
  } /* showFindDialog */

} /* class FindDialog */
