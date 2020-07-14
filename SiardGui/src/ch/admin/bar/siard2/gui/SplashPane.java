package ch.admin.bar.siard2.gui;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import ch.enterag.utils.EU;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class SplashPane
  extends Pane
{
  private static final String sSPLASH_IMAGE_RESOURCE = "res/splash.png";
  /*------------------------------------------------------------------*/
  /** constructor
   */
  private SplashPane()
  {
    super();
    ImageView ivSplash = new ImageView(new Image(SplashPane.class.getResourceAsStream(sSPLASH_IMAGE_RESOURCE)));
    getChildren().add(ivSplash);
    double dImageWidth = ivSplash.getBoundsInParent().getWidth();
    double dImageHeight = ivSplash.getBoundsInParent().getHeight();
    Label lblMain = new Label(SiardGui.getApplication()+" "+SiardGui.getVersion());
    double dDefaultSize = Font.getDefault().getSize();
    lblMain.setFont(Font.font(null, FontWeight.SEMI_BOLD, 2.3*dDefaultSize));
    lblMain.setLayoutX(0.37*dImageWidth);
    lblMain.setLayoutY(0.09*dImageHeight);
    //getChildren().add(lblMain);
  } /* constructor */

  /*------------------------------------------------------------------*/
  /** factory
   * @return new splash pane.
   */
  public static SplashPane newSplashPane()
  {
    return new SplashPane();
  } /* newSplashPane */

  /*------------------------------------------------------------------*/
  /** save a snapshot of the splash pane as a PNG file.
   * @param filePng PNG file to write.
   */
  public static void saveSnapshot(File filePng)
  {
    SplashPane sp = newSplashPane();
    new Scene(sp);
    WritableImage wi = sp.snapshot(null, null);
    RenderedImage ri = SwingFXUtils.fromFXImage(wi, null);
    try { ImageIO.write(ri, "png", filePng); }
    catch(IOException ie) { System.err.println(EU.getExceptionMessage(ie)); }
  } /* saveSnapshot */

} /* class SplashPane */
