package ch.admin.bar.siard2.gui;

import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javafx.embed.swing.*;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.image.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import ch.enterag.utils.*;

public class ProcessingPane extends Pane
{
	private static final String sSPLASH_IMAGE_RESOURCE = "res/processing.gif";

	/*------------------------------------------------------------------*/
	/**
	 * constructor
	 */
	private ProcessingPane()
	{
		super();
		ImageView ivSplash = new ImageView(new Image(ProcessingPane.class.getResourceAsStream(sSPLASH_IMAGE_RESOURCE)));
		getChildren().add(ivSplash);
		double	dImageWidth		= ivSplash.getBoundsInParent().getWidth();
		double	dImageHeight	= ivSplash.getBoundsInParent().getHeight();
		Label lblMain = new Label("SIARD_KR 1.0");
		double dDefaultSize = Font.getDefault().getSize();
		lblMain.setFont(Font.font(null, FontWeight.SEMI_BOLD, 2.3 * dDefaultSize));
		lblMain.setLayoutX(0.37 * dImageWidth);
		lblMain.setLayoutY(0.09 * dImageHeight);
	} /* constructor */

	/*------------------------------------------------------------------*/
	/**
	 * factory
	 * 
	 * @return new splash pane.
	 */
	public static ProcessingPane newProcessingPane()
	{
		return new ProcessingPane();
	} /* newProcessingPane */

	/*------------------------------------------------------------------*/
	/**
	 * save a snapshot of the splash pane as a PNG file.
	 * 
	 * @param filePng PNG file to write.
	 */
	public static void saveSnapshot(File filePng)
	{
		ProcessingPane sp = newProcessingPane();
		new Scene(sp);
		WritableImage	wi	= sp.snapshot(null, null);
		RenderedImage	ri	= SwingFXUtils.fromFXImage(wi, null);
		try
		{
			ImageIO.write(ri, "gif", filePng);
		}
		catch (IOException ie)
		{
			System.err.println(EU.getExceptionMessage(ie));
		}
	} /* saveSnapshot */

} /* class ProcessingPane */
