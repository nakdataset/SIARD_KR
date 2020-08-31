/*
 * ====================================================================== 
 * ValueDialog displays cell values. 
 * Application : Siard2 
 * Description : ValueDialog displays cell values. 
 * Platform : Java 7, JavaFX 2.2 
 * ---------------------------------------------------------------------- 
 * Copyright : 2017, Enter AG, Rüti ZH, Switzerland 
 * Created : 14.08.2017, Hartwig Thomas
 * ======================================================================
 */
package ch.admin.bar.siard2.gui.dialogs;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.Locale;

import org.apache.log4j.Logger;

import ch.admin.bar.siard2.api.Cell;
import ch.admin.bar.siard2.api.MetaType;
import ch.admin.bar.siard2.api.MetaValue;
import ch.admin.bar.siard2.api.Value;
import ch.admin.bar.siard2.api.generated.CategoryType;
import ch.admin.bar.siard2.gui.SiardBundle;
import ch.admin.bar.siard2.gui.SiardGui;
import ch.admin.bar.siard2.gui.UserProperties;
import ch.admin.bar.siard2.gui.details.ValueTreeView;
import ch.enterag.sqlparser.Interval;
import ch.enterag.sqlparser.SqlLiterals;
import ch.enterag.utils.BU;
import ch.enterag.utils.DU;
import ch.enterag.utils.EU;
import ch.enterag.utils.fx.FxSizes;
import ch.enterag.utils.fx.FxStyles;
import ch.enterag.utils.fx.ScrollableDialog;
import ch.enterag.utils.fx.dialogs.MB;
import ch.enterag.utils.lang.Execute;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/* ==================================================================== */
/**
 * ValueDialog displays cell values.
 * 
 * @author Hartwig Thomas
 */
public class ValueDialog
	extends ScrollableDialog
	implements EventHandler<ActionEvent>
{

	// 최창근 추가 - 로그
	private static final Logger LOG = Logger.getLogger(ValueDialog.class);

	// padding inside
	private static final double dINNER_PADDING = 10.0;
	// vertical spacing of elements
	private static final double dVSPACING = 10.0;
	/** maximum column count in text field / area */
	private static final int iCOLUMNS = 40;
	/** maximum row count in text area */
	private static final int iROWS = 20;
	/** buffer size for file copying */
	private static final int iBUFFER_SIZE = 8192;

	private VBox _vbox = null;
	private Value _value = null;
	private int _iMaxInlineSize = -1;
	private String _sLocation = null;

	/*------------------------------------------------------------------*/
	/**
	 * display value in tree view cell.
	 * 
	 * @param vtc tree view cell.
	 * @throws IOException, if an I/O error occurs.
	 */
	private void displayCell(ValueTreeView.ValueTreeCell vtc)
		throws IOException
	{
		displayValue(this, vtc.getLocation(), vtc.getDataValue(), vtc.getMaxInlineSize());
		vtc.deselect();
	} /* displayCell */

	/*------------------------------------------------------------------*/
	/**
	 * handle close button.
	 * 
	 * @param action event indicating close button has been pressed.
	 */
	@Override
	public void handle(ActionEvent ae)
	{
		if (ae.getTarget() instanceof ValueTreeView.ValueTreeCell) {
			ValueTreeView.ValueTreeCell vtc = (ValueTreeView.ValueTreeCell) ae.getTarget();
			Platform.runLater(new Runnable() {
				private ValueTreeView.ValueTreeCell _vtc = null;

				/* stores argument and returns this */
				public Runnable init(ValueTreeView.ValueTreeCell vtc)
				{
					_vtc = vtc;
					return this;
				} /* init */
				/* uses argument */

				@Override
				public void run()
				{
					try {
						displayCell(_vtc);
					} catch (IOException ie) {
						System.err.println(EU.getExceptionMessage(ie));
					}
				}
			}.init(vtc));

		} else // from button
			close();
	} /* handle */

	/*------------------------------------------------------------------*/
	/**
	 * create the main VBox with tree or text field/text area and close button.
	 * 
	 * @return main VBox.
	 */
	private VBox createVBoxDialog()
	{
		VBox vbox = new VBox();
		vbox.setStyle(FxStyles.sSTYLE_BACKGROUND_LIGHTGREY);
		vbox.setPadding(new Insets(dINNER_PADDING));
		vbox.setSpacing(dVSPACING);
		double dMinWidth = 0.0;
		double dMinHeight = 0.0;
		try {
			MetaValue mv = _value.getMetaValue();
			MetaType mt = mv.getMetaType();
			if (((mt != null) && (mt.getCategoryType() == CategoryType.UDT)) ||
				(mv.getCardinality() > 0)) {
				ValueTreeView vtv = new ValueTreeView(_sLocation, (Cell) _value, _iMaxInlineSize);
				vtv.setOnShowValue(this);
				vbox.getChildren().add(vtv);
				dMinWidth = vtv.getPrefWidth();
				dMinHeight += vtv.getPrefHeight();
			} else {
				String sText = getText(_value, _iMaxInlineSize);
				TextInputControl tic = null;
				if (sText.length() < iCOLUMNS) {
					TextField tf = new TextField();
					tf.setText(sText);
					tic = tf;
					tf.setPrefColumnCount(sText.length());
				} else {
					TextArea ta = new TextArea();
					ta.setPrefColumnCount(iCOLUMNS);
					ta.setWrapText(true);
					ta.setText(sText);
					int iRows = (int) Math.ceil(sText.length() / iCOLUMNS);
					int iTextRows = (int) Math.ceil(FxSizes.getTextHeight(sText) / FxSizes.getTextHeight(""));
					if (iRows < iTextRows)
						iRows = iTextRows;
					if (iRows > iROWS)
						iRows = iROWS;
					ta.setPrefRowCount(iRows);
					tic = ta;
				}
				tic.setEditable(false);
				tic.setUserData(_value);
				tic.setMinHeight(FxSizes.getNodeHeight(tic));
				tic.setMinWidth(FxSizes.getNodeWidth(tic));
				if (dMinWidth < FxSizes.getNodeWidth(tic))
					dMinWidth = FxSizes.getNodeWidth(tic);
				dMinHeight += FxSizes.getNodeHeight(tic);
				vbox.getChildren().add(tic);
				vbox.getChildren().add(new Separator()); /* 2020-08-31 */
			}
		} catch (IOException ie) {
			System.err.println(EU.getExceptionMessage(ie));
		}
		HBox hbox = new HBox();
		hbox.setSpacing(dHSPACING);
		hbox.setStyle(FxStyles.sSTYLE_BACKGROUND_LIGHTGREY);
		hbox.setAlignment(Pos.BASELINE_RIGHT);
		Button btnClose = new Button(SiardBundle.getSiardBundle().getValueDialogClose());
		btnClose.setDefaultButton(true);
		btnClose.setOnAction(this);
		hbox.getChildren().add(btnClose);		
//		if (dMinWidth < FxSizes.getNodeWidth(btnClose))
//			dMinWidth = FxSizes.getNodeWidth(btnClose);
//		dMinHeight += dVSPACING + FxSizes.getNodeHeight(btnClose);
		vbox.getChildren().add(hbox);

		dMinWidth += vbox.getPadding().getLeft() + vbox.getPadding().getRight();
		dMinHeight += vbox.getPadding().getTop() + vbox.getPadding().getBottom();

		vbox.setMinWidth(dMinWidth);
		vbox.setMinHeight(dMinHeight);

		return vbox;
	} /* createVBoxDialog */

	/*------------------------------------------------------------------*/
	/**
	 * create a dialog that displays the value data.
	 * 
	 * @param stageOwner
	 * @param sLocation location in table.
	 * @param value data.
	 * @param iMaxInlineSize maximum number of characters to be displayed inline.
	 */
	private ValueDialog(Stage stageOwner, String sLocation, Value value, int iMaxInlineSize)
	{
		super(stageOwner, SiardBundle.getSiardBundle().getValueDialogTitle(value.getMetaValue().getAncestorMetaColumn().getParentMetaTable().getName() + sLocation));
		_value = value;
		_iMaxInlineSize = iMaxInlineSize;
		_sLocation = sLocation;
		LOG.info("ValueDialog");
		_vbox = createVBoxDialog();

		_vbox.setPadding(new Insets(dOUTER_PADDING * 2, dOUTER_PADDING, 0, dOUTER_PADDING)); /* IntraDIGM */
		_vbox.setSpacing(dVSPACING); /* IntraDIGM */
		_vbox.setStyle(FxStyles.sSTYLE_BACKGROUND_LIGHTGREY); /* IntraDIGM */

		/* scene */
		double dWidth = FxSizes.getScreenBounds().getWidth() / 4.0;
		if (dWidth > FxSizes.getScreenBounds().getWidth())
			dWidth = FxSizes.getScreenBounds().getWidth();
		_vbox.setMinWidth(dWidth);
//		double dHeight = _vbox.getMinHeight() + 10.0;
//		if (dHeight > FxSizes.getScreenBounds().getHeight() / 2.0)
//			dHeight = FxSizes.getScreenBounds().getHeight() / 2.0;
//		Scene scene = new Scene(_vbox, dWidth, dHeight);
		Scene scene = new Scene(_vbox);
		setScene(scene);
	} /* constructor */

	/*------------------------------------------------------------------*/
	/**
	 * get text to be displayed from value.
	 * 
	 * @param value value.
	 * @param iMaxInlineSize maximum displayable size.
	 * @return text for value, empty string for null, null for LOB.
	 * @throws IOException
	 */
	public static String getText(Value value, int iMaxInlineSize)
		throws IOException
	{
		DU du = DU.getInstance(Locale.getDefault().getLanguage(), (new SimpleDateFormat()).toPattern());
		String sText = null;
		if (!value.isNull()) {
			int iType = value.getMetaValue().getPreType();
			if (((iType == Types.CHAR) ||
				(iType == Types.VARCHAR) ||
				(iType == Types.NCHAR) ||
				(iType == Types.NVARCHAR) ||
				(iType == Types.CLOB) ||
				(iType == Types.NCLOB) ||
				(iType == Types.SQLXML)) &&
				(value.getCharLength() < iMaxInlineSize))
				sText = value.getString();
			else if (((iType == Types.BINARY) ||
				(iType == Types.VARBINARY) ||
				(iType == Types.BLOB)) &&
				(value.getByteLength() < iMaxInlineSize / 2))
				sText = "0x" + BU.toHex(value.getBytes());
			else if ((iType == Types.NUMERIC) ||
				(iType == Types.DECIMAL))
				sText = value.getBigDecimal().toPlainString();
			else if (iType == Types.SMALLINT)
				sText = value.getInt().toString();
			else if (iType == Types.INTEGER)
				sText = value.getLong().toString();
			else if (iType == Types.BIGINT)
				sText = value.getBigInteger().toString();
			else if ((iType == Types.FLOAT) ||
				(iType == Types.DOUBLE))
				sText = value.getDouble().toString();
			else if (iType == Types.REAL)
				sText = value.getFloat().toString();
			else if (iType == Types.BOOLEAN)
				sText = value.getBoolean().toString();
			else if (iType == Types.DATE)
				sText = du.fromSqlDate(value.getDate());
			else if (iType == Types.TIME)
				sText = du.fromSqlTime(value.getTime());
			else if (iType == Types.TIMESTAMP)
				sText = du.fromSqlTimestamp(value.getTimestamp());
			else if (iType == Types.OTHER)
				sText = SqlLiterals.formatIntervalLiteral(Interval.fromDuration(value.getDuration()));
		} else
			sText = ""; // null value returns empty string
		return sText;
	} /* getText */

	/*------------------------------------------------------------------*/
	/**
	 * display the characters in the text editor.
	 * 
	 * @param stageOwner
	 * @param rdr character source.
	 * @throws IOException if an I/O error occurred.
	 */
	public static void displayText(Stage stageOwner, Reader rdr)
		throws IOException
	{
		/* save buffer in temp file */
		File fiDataDir = SiardGui.getDefaultDataDirectory();
		File fiTemp = File.createTempFile("tmp", ".txt", fiDataDir);
		FileOutputStream fos = new FileOutputStream(fiTemp);
		OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF8");
		char[] cbuf = new char[iBUFFER_SIZE];
		for (int iRead = rdr.read(cbuf); iRead != -1; iRead = rdr.read(cbuf))
			osw.write(cbuf, 0, iRead);
		rdr.close();
		osw.close();
		File fileTextEditor = UserProperties.getUserProperties().getTextEditor();
		String[] asCommand = new String[] {fileTextEditor.getPath(), fiTemp.getAbsolutePath()};
		Execute ex = Execute.execute(asCommand);
		if (ex.getResult() != 0) {
			SiardBundle sb = SiardBundle.getSiardBundle();
			MB.show(stageOwner,
				sb.getValueDisplayErrorTitle(),
				sb.getValueDisplayErrorMessage(fileTextEditor.getPath(), ex.getResult(),
					ex.getStdOut(), ex.getStdErr()),
				sb.getOk(), null);
		}
		fiTemp.deleteOnExit();
	} /* displayText */

	/*------------------------------------------------------------------*/
	/**
	 * display the bytes in the bin editor.
	 * 
	 * @param stageOwner
	 * @param is byte source.
	 * @throws IOException if an I/O error occurred.
	 */
	public static void displayBinary(Stage stageOwner, InputStream is)
		throws IOException
	{
		File fiDataDir = SiardGui.getDefaultDataDirectory();
		File fiTemp = File.createTempFile("tmp", ".bin", fiDataDir);
		FileOutputStream fos = new FileOutputStream(fiTemp);
		byte[] buf = new byte[iBUFFER_SIZE];
		for (int iRead = is.read(buf); iRead != -1; iRead = is.read(buf))
			fos.write(buf, 0, iRead);
		fos.close();
		is.close();
		File fileBinEditor = UserProperties.getUserProperties().getBinEditor();
		String[] asCommand = new String[] {fileBinEditor.getPath(), fiTemp.getAbsolutePath()};
		Execute ex = Execute.execute(asCommand);
		if (ex.getResult() != 0) {
			SiardBundle sb = SiardBundle.getSiardBundle();
			MB.show(stageOwner,
				sb.getValueDisplayErrorTitle(),
				sb.getValueDisplayErrorMessage(fileBinEditor.getPath(), ex.getResult(),
					ex.getStdOut(), ex.getStdErr()),
				sb.getOk(), null);
		}
		fiTemp.deleteOnExit();
	} /* displayBinary */

	/*------------------------------------------------------------------*/
	/**
	 * factory creates the value dialog and shows it.
	 * 
	 * @param stageOwner
	 * @param sLocation location in table.
	 * @param value data.
	 * @param iMaxInlineSize maximum number of characters to be displayed inline.
	 * @throws IOException if an I/O error occurred.
	 */
	private static void displayValue(Stage stageOwner, String sLocation,
		Value value, int iMaxInlineSize)
		throws IOException
	{
		LOG.info("(value.getCharLength() > iMaxInlineSize) " + (value.getCharLength() > iMaxInlineSize));
		LOG.info("(value.getByteLength() > iMaxInlineSize/2) " + (value.getByteLength() > iMaxInlineSize / 2));
		if (value.getCharLength() > iMaxInlineSize)
			displayText(stageOwner, value.getReader());
		else if (value.getByteLength() > iMaxInlineSize / 2)
			displayBinary(stageOwner, value.getInputStream());
		else {
			ValueDialog vd = new ValueDialog(stageOwner, sLocation, value, iMaxInlineSize);

			vd.setResizable(false); /* IntraDIGM */

			vd.showAndWait();
		}
	} /* displayValue */

	/*------------------------------------------------------------------*/
	/**
	 * factory creates the value dialog and shows it.
	 * 
	 * @param stageOwner
	 * @param cell data.
	 * @param iMaxInlineSize maximum number of characters to be displayed inline.
	 * @throws IOException if an I/O error occurred.
	 */
	public static void displayValue(Stage stageOwner, Cell cell, int iMaxInlineSize)
		throws IOException
	{
		String sLocation = "[" + String.valueOf(cell.getParentRecord().getRecord() + 1) + "]:" +
			cell.getMetaColumn().getName(); /* IntraDIGM */
		displayValue(stageOwner, sLocation, cell, iMaxInlineSize);
	} /* showValueDialog */

} /* class ValueDialog */
