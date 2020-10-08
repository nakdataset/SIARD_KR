package ch.admin.bar.siard2.gui.browser;

import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.net.URL;

import ch.enterag.utils.EU;
import ch.enterag.utils.fx.FxSizes;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.print.PrinterJob;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import netscape.javascript.JSObject;

public class BrowserRegion
  extends Region
{
  private static final int iBUFSIZ = 8192;
  private WebView _wv = new WebView();

  /** for communication to the Javascript engine. */
  private JSObject javascriptConnector;

  /** for communication from the Javascript engine. */
  private JavaConnector javaConnector = new JavaConnector();

  private HBox toolBar = new HBox();
  public Button printButton;
  //Create the JobStatus Label
  private final Label jobStatus = new Label();

  private BrowserRegion(String sUrl)
  {
    super();
    _wv.getEngine().load(sUrl);
    getChildren().add(_wv);
  } /* constructor BrowserRegion */

  private BrowserRegion(Reader rdrHtml)
  {
    super();
    char[] cbuf = new char[iBUFSIZ];
    try
    {
      StringWriter sw = new StringWriter();
      for (int iRead = rdrHtml.read(cbuf); iRead != -1; iRead = rdrHtml.read(cbuf))
        sw.write(cbuf,0,iRead);
      rdrHtml.close();
      sw.close();
      _wv.getEngine().loadContent(sw.getBuffer().toString());
      getChildren().add(_wv);
    }
    catch(IOException ie) { System.err.println(EU.getExceptionMessage(ie));  }
  } /* constructor BrowserRegion */

  /**
   * 20200904 - 보고서 출력용 URL 호출 by.pks
   */
  private BrowserRegion(Stage stageOwner, URL rdrHtmlUrl, String historyModelJson)
  {
	  super();

	  // create the toolbar
      toolBar = new HBox();
      toolBar.setAlignment(Pos.CENTER);
      toolBar.getStyleClass().add("browser-toolbar");

      printButton = new Button("print");
      printButton.setOnAction((ActionEvent e) -> {
          PrinterJob job = PrinterJob.createPrinterJob();
          if (job != null) {
      		// Show the page setup dialog
      		boolean proceed = job.showPrintDialog(stageOwner);

      		if (proceed)
      		{
      		    // Set the Job Status Message
      			jobStatus.textProperty().bind(job.jobStatusProperty().asString());

      			// Print the node
      			_wv.getEngine().print(job);
      			job.endJob();
      		}
          }
      });

      toolBar.getChildren().add(printButton);
      toolBar.getChildren().add(jobStatus);

	  _wv.getEngine().load(rdrHtmlUrl.toExternalForm());
	  _wv.getEngine().getLoadWorker().stateProperty().addListener((obs, oldValue, newValue) -> {
		if (newValue == Worker.State.SUCCEEDED) {
		  JSObject jsobj = (JSObject) _wv.getEngine().executeScript("window");
		  jsobj.setMember("javaConnector", javaConnector);
	      jsobj.eval(historyModelJson);
		  // get the Javascript connector object.
          javascriptConnector = (JSObject) _wv.getEngine().executeScript("getJsConnector()");
	  	}
	  });

	  getChildren().add(toolBar);
	  getChildren().add(_wv);
  } /* constructor BrowserRegion */

  @Override
  protected void layoutChildren()
  {
    double w = getWidth();
    double h = getHeight();
    double tbHeight = toolBar.prefHeight(w);
//    this.layoutInArea(_wv,0,0,w,h,0, HPos.CENTER, VPos.CENTER);
    this.layoutInArea(_wv,0,0,w,h-tbHeight,0, HPos.CENTER, VPos.CENTER);
    this.layoutInArea(toolBar,0,h-tbHeight,w,tbHeight,0,HPos.CENTER,VPos.CENTER);
  } /* layoutChildren */

  @Override
  protected double computePrefWidth(double dHeight)
  {
    return FxSizes.getScreenBounds().getWidth()/2.0;
  } /* computePrefWidth */

  @Override
  protected double computePrefHeight(double dWidth)
  {
    return FxSizes.getScreenBounds().getHeight()/2.0;
  } /* computePrefHeight */

  public static BrowserRegion newBrowserRegion(String sUrl)
  {
    return new BrowserRegion(sUrl);
  } /* factory newBrowserRegion */

  public static BrowserRegion newBrowserRegion(Reader rdrHtml)
  {
    return new BrowserRegion(rdrHtml);
  }

  public static BrowserRegion newBrowserRegion_reportPrint(Stage stageOwner, URL rdrHtmlUrl, String historyModelJson)
  {
    return new BrowserRegion(stageOwner, rdrHtmlUrl, historyModelJson);
  } /* factory newBrowserRegion */

  /**
   * jsobject call()
   */
  public class JavaConnector {
    public void sendHistoryModelToJs() {
    	javascriptConnector.call("setHistoryModel", new Object[] {"jsonObj"});
    }
  }

} /* BrowserRegion */

