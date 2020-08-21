/*
 * MainToolBar implements menu bar of the SIARD GUI. 
 * Application: SIARD 2 
 * Description: MainToolBar implements menu bar of the SIARD GUI. 
 * Platform: JAVA 1.7, JavaFX 2.2
 * ------------------------------------------------------------------------ 
 * Created : 10.08.2020, IntraDIGM 
 */
package ch.admin.bar.siard2.gui;

import ch.admin.bar.siard2.api.Archive;
import ch.admin.bar.siard2.api.Table;
import ch.enterag.utils.fx.FxStyles;
import javafx.beans.property.BooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/* ==================================================================== */
/**
 * MainMenuBar implements menu bar of the CultLibEditor. It also implements its own "controller" by
 * implementing the corresponding EventHandler.
 * 
 * @author Hartwig Thomas
 */
public class MainToolBar
	extends ToolBar
	implements EventHandler<ActionEvent>
{
	/** singleton */
	private static MainToolBar _mtb = null;
	
	/** toolbar icon */
	/** ch.admin.bar.siard2.gui.res */
	private static final String DOWNLOAD_ICON_RESOURCE = "res/download.png";
	private static final String DOWNLOAD_ICON_RESOURCE_DISABLED = "res/download.disabled.png";
	private static final String UPLOAD_ICON_RESOURCE = "res/upload.png";
	private static final String UPLOAD_ICON_RESOURCE_DISABLED = "res/upload.disabled.png";
	private static final String OPEN_ICON_RESOURCE = "res/open.png";
	private static final String OPEN_ICON_RESOURCE_DISABLED = "res/open.disabled.png";
	private static final String SAVE_ICON_RESOURCE = "res/save.png";
	private static final String SAVE_ICON_RESOURCE_DISABLED = "res/save.disabled.png";
	private static final String CLOSE_ICON_RESOURCE = "res/close.png";
	private static final String CLOSE_ICON_RESOURCE_DISABLED = "res/close.disabled.png";
	private static final String FIND_ICON_RESOURCE = "res/find.png";
	private static final String FIND_ICON_RESOURCE_DISABLED = "res/find.disabled.png";
	private static final String FINDNEXT_ICON_RESOURCE = "res/findnext.png";
	private static final String FINDNEXT_ICON_RESOURCE_DISABLED = "res/findnext.disabled.png";
	private static final String SEARCH_ICON_RESOURCE = "res/search.png";
	private static final String SEARCH_ICON_RESOURCE_DISABLED = "res/search.disabled.png";
	private static final String SEARCHNEXT_ICON_RESOURCE = "res/searchnext.png";
	private static final String SEARCHNEXT_ICON_RESOURCE_DISABLED = "res/searchnext.disabled.png";
	private static final String OPTIONS_ICON_RESOURCE = "res/options.png";
	private static final String INFO_ICON_RESOURCE = "res/info.png";
	
	/** toolbar items */
	private Button _tbDownload = null;
	private Button _tbUpload = null;
	private Button _tbOpen = null;
	private Button _tbSave = null;
	private Button _tbClose = null;
	private Button _tbFind = null;
	private Button _tbFindNext = null;
	private Button _tbSearch = null;
	private Button _tbSearchNext = null;
	private Button _tbOptions = null;
	private Button _tbInfo = null;

	/* ================================================================== */
	/**
	 * this class fixes a bug in the disable display ...
	 */
	private class DisableChangeListener
		implements ChangeListener<Boolean>
	{
		/*------------------------------------------------------------------*/
		/**
		 * {@link javafx.beans.value.ChangeListener<Boolean>#changed changed} handles change of disable
		 * state
		 */
		@Override
		public void changed(ObservableValue<? extends Boolean> ovValue,
			Boolean bOld, Boolean bNew)
		{
			BooleanProperty bp = (BooleanProperty) ovValue;
			Button btn = (Button) bp.getBean();
			if (bNew.booleanValue())
				btn.setStyle(FxStyles.sSTYLE_DISABLED_OPACITY);
			else
				btn.setStyle(FxStyles.sSTYLE_ENABLED_OPACITY);
		} /* changed */
	}

	private DisableChangeListener _dcl = new DisableChangeListener();
	
	/*------------------------------------------------------------------*/
	/**
	 * {@link javafx.event.EventHandler<ActionEvent>#handle handle} handles selection of menu items
	 */
	@Override
	public void handle(ActionEvent ae)
	{
		SiardGui sg = SiardGui.getSiardGui();
		Button btn = (Button) ae.getSource();
		
		if (btn == _tbDownload)
			sg.download();
		else if (btn == _tbUpload)
			sg.upload();
		else if (btn == _tbOpen)
			sg.openArchive();
		else if (btn == _tbSave)
			sg.save();
		else if (btn == _tbClose)
			sg.closeArchive();
		else if (btn == _tbFind)
			sg.find();
		else if (btn == _tbFindNext)
			sg.findNext();
		else if (btn == _tbSearch)
			sg.search();
		else if (btn == _tbSearchNext)
			sg.searchNext();
		else if (btn == _tbOptions)
			sg.options();
		else if (btn == _tbInfo)
			sg.info(); // display Info dialog
	} /* handle */

	/*------------------------------------------------------------------*/
	/**
	 * restrict enables and disables menu items.
	 */
	public void restrict()
	{
		boolean bAvailable = false;
		boolean bChanged = false;
		boolean bValid = false;
		Archive archive = SiardGui.getSiardGui().getArchive();
		MainPane mp = MainPane.getMainPane();
		if (archive != null) {
			bAvailable = true;
			if (archive.isValid())
				bValid = true;
			if ((!archive.isMetaDataUnchanged()) || mp.isChanged())
				bChanged = true;
		}
		_tbDownload.setDisable(bChanged && bValid);
		if (_tbDownload.isDisabled()) {
			_tbDownload.setGraphic(new ImageView(new Image(MainToolBar.class.getResourceAsStream(DOWNLOAD_ICON_RESOURCE_DISABLED))));
		} else {
			_tbDownload.setGraphic(new ImageView(new Image(MainToolBar.class.getResourceAsStream(DOWNLOAD_ICON_RESOURCE))));
		}
		_tbUpload.setDisable((!bAvailable) || (!bValid));
		if (_tbUpload.isDisabled()) {
			_tbUpload.setGraphic(new ImageView(new Image(MainToolBar.class.getResourceAsStream(UPLOAD_ICON_RESOURCE_DISABLED))));
		} else {
			_tbUpload.setGraphic(new ImageView(new Image(MainToolBar.class.getResourceAsStream(UPLOAD_ICON_RESOURCE))));
		}
		_tbOpen.setDisable(bAvailable && bChanged);
		if (_tbOpen.isDisabled()) {
			_tbOpen.setGraphic(new ImageView(new Image(MainToolBar.class.getResourceAsStream(OPEN_ICON_RESOURCE_DISABLED))));
		} else {
			_tbOpen.setGraphic(new ImageView(new Image(MainToolBar.class.getResourceAsStream(OPEN_ICON_RESOURCE))));
		}
		_tbSave.setDisable((!bAvailable) || (!bChanged) || (!bValid));
		if (_tbSave.isDisabled()) {
			_tbSave.setGraphic(new ImageView(new Image(MainToolBar.class.getResourceAsStream(SAVE_ICON_RESOURCE_DISABLED))));
		} else {
			_tbSave.setGraphic(new ImageView(new Image(MainToolBar.class.getResourceAsStream(SAVE_ICON_RESOURCE))));
		}
		_tbClose.setDisable(!bAvailable);
		if (_tbClose.isDisabled()) {
			_tbClose.setGraphic(new ImageView(new Image(MainToolBar.class.getResourceAsStream(CLOSE_ICON_RESOURCE_DISABLED))));
		} else {
			_tbClose.setGraphic(new ImageView(new Image(MainToolBar.class.getResourceAsStream(CLOSE_ICON_RESOURCE))));
		}
		Table table = mp.getSelectedTable();
		_tbFind.setDisable(!bAvailable);
		if (_tbFind.isDisabled()) {
			_tbFind.setGraphic(new ImageView(new Image(MainToolBar.class.getResourceAsStream(FIND_ICON_RESOURCE_DISABLED))));
		} else {
			_tbFind.setGraphic(new ImageView(new Image(MainToolBar.class.getResourceAsStream(FIND_ICON_RESOURCE))));
		}
		_tbFindNext.setDisable((!bAvailable) || (!archive.getMetaData().canFindNext()));
		if (_tbFindNext.isDisabled()) {
			_tbFindNext.setGraphic(new ImageView(new Image(MainToolBar.class.getResourceAsStream(FINDNEXT_ICON_RESOURCE_DISABLED))));
		} else {
			_tbFindNext.setGraphic(new ImageView(new Image(MainToolBar.class.getResourceAsStream(FINDNEXT_ICON_RESOURCE))));
		}
		_tbSearch.setDisable(table == null);
		if (_tbSearch.isDisabled()) {
			_tbSearch.setGraphic(new ImageView(new Image(MainToolBar.class.getResourceAsStream(SEARCH_ICON_RESOURCE_DISABLED))));
		} else {
			_tbSearch.setGraphic(new ImageView(new Image(MainToolBar.class.getResourceAsStream(SEARCH_ICON_RESOURCE))));
		}
		_tbSearchNext.setDisable((table == null) || (!table.canFindNext()));
		if (_tbSearchNext.isDisabled()) {
			_tbSearchNext.setGraphic(new ImageView(new Image(MainToolBar.class.getResourceAsStream(SEARCHNEXT_ICON_RESOURCE_DISABLED))));
		} else {
			_tbSearchNext.setGraphic(new ImageView(new Image(MainToolBar.class.getResourceAsStream(SEARCHNEXT_ICON_RESOURCE))));
		}
	} /* restrict */

	private void ToolTipItem(Button btn, String tip)
	{
		Tooltip tooltip = btn.getTooltip();
		if (tooltip == null) {
			tooltip = new Tooltip();
		} 
		tooltip.setText(tip);
		
		btn.setTooltip(tooltip);
		//btn.setText(tip);
	} /* createToolTipItem */
	
	/*------------------------------------------------------------------*/
	/**
	 * set all language-dependent texts in menu.
	 */
	void refreshLanguage()
	{
		SiardBundle sb = SiardBundle.getSiardBundle();
		
		ToolTipItem(_tbDownload, sb.getToolTipDownload());
		ToolTipItem(_tbUpload, sb.getToolTipUpload());
		ToolTipItem(_tbOpen, sb.getToolTipOpen());
		ToolTipItem(_tbSave, sb.getToolTipSave());
		ToolTipItem(_tbClose, sb.getToolTipClose());
		ToolTipItem(_tbFind, sb.getToolTipFind());
		ToolTipItem(_tbFindNext, sb.getToolTipFindNext());
		ToolTipItem(_tbSearch, sb.getToolTipSearch());
		ToolTipItem(_tbSearchNext, sb.getToolTipSearchNext());
		ToolTipItem(_tbOptions, sb.getToolTipOptions());
		ToolTipItem(_tbInfo, sb.getToolTipInfo());
	} /* refreshLanguage */

	private Button createToolbarItem(String resource)
	{
		Button tbBtn = new Button();
		tbBtn.setGraphic(new ImageView(new Image(MainToolBar.class.getResourceAsStream(resource))));
		tbBtn.disableProperty().addListener(_dcl);
		tbBtn.setOnAction(this);
		
		return tbBtn;
	} /* createToolbarItem */

	/*------------------------------------------------------------------*/
	/**
	 * constructor
	 */
	private MainToolBar()
	{
		super();
		
	    _tbDownload = createToolbarItem(DOWNLOAD_ICON_RESOURCE); getItems().add(_tbDownload);
	    _tbUpload = createToolbarItem(UPLOAD_ICON_RESOURCE); getItems().add(_tbUpload);
	    getItems().add(new Separator());
	    _tbOpen = createToolbarItem(OPEN_ICON_RESOURCE); getItems().add(_tbOpen);
	    _tbSave = createToolbarItem(SAVE_ICON_RESOURCE); getItems().add(_tbSave);
	    _tbClose = createToolbarItem(CLOSE_ICON_RESOURCE); getItems().add(_tbClose);
	    getItems().add(new Separator());
	    _tbFind = createToolbarItem(FIND_ICON_RESOURCE); getItems().add(_tbFind);
	    _tbFindNext = createToolbarItem(FINDNEXT_ICON_RESOURCE); getItems().add(_tbFindNext);
	    getItems().add(new Separator());
	    _tbSearch = createToolbarItem(SEARCH_ICON_RESOURCE); getItems().add(_tbSearch);
	    _tbSearchNext = createToolbarItem(SEARCHNEXT_ICON_RESOURCE); getItems().add(_tbSearchNext);
	    getItems().add(new Separator());
	    _tbOptions = createToolbarItem(OPTIONS_ICON_RESOURCE); getItems().add(_tbOptions);
	    getItems().add(new Separator());
	    _tbInfo = createToolbarItem(INFO_ICON_RESOURCE); getItems().add(_tbInfo);
	    
		/* set all language-dependent strings */
		refreshLanguage();
	} /* constructor MainToolBar */

	/*------------------------------------------------------------------*/
	/**
	 * factory
	 * 
	 * @return freshly created tool bar.
	 */
	public static MainToolBar getMainToolBar()
	{
		if (_mtb == null)
			_mtb = new MainToolBar();
		
		return _mtb;
	} /* getToolbarInstance */

} /* class MainToolBar */
