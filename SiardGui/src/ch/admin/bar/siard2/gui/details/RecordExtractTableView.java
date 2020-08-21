/*======================================================================
The record extract table view displays the primary dara of the record extract.
Application: SIARD GUI
Description: The record extract table view displays the primary dara of
             the record extract.
             It catches and executes sort requests.
             It catches and executes display requests.
Platform   : JAVA 1.7, JavaFX 2.2
------------------------------------------------------------------------
Copyright  : Swiss Federal Archives, Berne, Switzerland, 2017
Created    : 11.08.2017, Hartwig Thomas, Enter AG, Rüti ZH
======================================================================*/
package ch.admin.bar.siard2.gui.details;

import java.io.IOException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import ch.admin.bar.siard2.api.Archive;
import ch.admin.bar.siard2.api.Cell;
import ch.admin.bar.siard2.api.MetaColumn;
import ch.admin.bar.siard2.api.MetaTable;
import ch.admin.bar.siard2.api.Record;
import ch.admin.bar.siard2.api.RecordExtract;
import ch.admin.bar.siard2.api.generated.CategoryType;
import ch.admin.bar.siard2.gui.MainMenuBar;
import ch.admin.bar.siard2.gui.SiardBundle;
import ch.admin.bar.siard2.gui.SiardGui;
import ch.admin.bar.siard2.gui.UserProperties;
import ch.admin.bar.siard2.gui.dialogs.ValueDialog;
import ch.admin.bar.siard2.gui.tasks.SortTask;
import ch.enterag.sqlparser.identifier.QualifiedId;
import ch.enterag.utils.EU;
import ch.enterag.utils.database.SqlTypes;
import ch.enterag.utils.fx.FxSizes;
import ch.enterag.utils.fx.controls.ObjectListTableView;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.SortType;
import javafx.scene.control.TableView;

/*====================================================================*/
/** The record extract table view displays the primary data of the record
 * extract.
 * It catches and executes sort requests.
 * It catches and executes display requests.
 * @author Hartwig Thomas
 */
public class RecordExtractTableView
  extends ObjectListTableView
  implements EventHandler<ActionEvent>
{

  // 최창근 추가 - 로그
  private static final Logger LOG = Logger.getLogger(RecordExtractTableView.class);

  private RecordExtract _re = null;
  public RecordExtract getRecordExtract() { return _re; }
  private static final String sROW_HEADER = "Row";
  private static final double sMIN_COLUMN_WIDTH = 4.0;

  /*------------------------------------------------------------------*/
  /** display the cell
   * @param iRow table row (0-based).
   * @param iColumn table column (0-based).
   * @throws IOException if an I/O error occurred.
   */
  private void displayCell(int iRow, int iColumn)
    throws IOException
  {
    int iMaxInlineSize = _re.getTable().getParentSchema().getParentArchive().getMaxInlineSize();
    RecordExtract reRecord = _re.getRecordExtract(iRow);
    Record re = reRecord.getRecord();
    Cell cell = re.getCell(iColumn);
    LOG.info("iRow " + iRow);
    LOG.info("iColumn " + iColumn);
    ValueDialog.displayValue(SiardGui.getSiardGui().getStage(), cell, iMaxInlineSize);
  } /* displayCell */

  /*------------------------------------------------------------------*/
  /** handle show cell event.
   */
  @Override
  public void handle(ActionEvent ae)
  {
    if (ae.getTarget() instanceof ObjectListTableView.ObjectTableCell)
    {
      LOG.info("ae.getTarget() " + ae.getTarget());
      ObjectListTableView.ObjectTableCell otc = (ObjectListTableView.ObjectTableCell)ae.getTarget();
      Platform.runLater(new Runnable()
      {
        private ObjectListTableView.ObjectTableCell _otc = null;
        public Runnable init(ObjectListTableView.ObjectTableCell otc)
        {
          _otc = otc;
          return this;
        }
        @Override
        public void run()
        {
          try {
        	  LOG.info("_otc.getRow() " + _otc.getRow());
        	  LOG.info("_otc.getColumn()-1 " + (_otc.getColumn()-1));
        	  displayCell(_otc.getRow(), _otc.getColumn()-1);
          }catch(IOException ie) {
        	  System.err.println(EU.getExceptionMessage(ie));
          }
        }
      }.init(otc));
    }
  } /* handle */

  /*------------------------------------------------------------------*/
  /** retrieve the column headers for the record extract.
   * @param re record extract.
   * @return column headers.
   */
  private static List<String> getColumnHeaders(RecordExtract re)
  {
    List<String> listColumnHeaders = new ArrayList<String>();
    listColumnHeaders.add(sROW_HEADER);
    MetaTable mt = re.getTable().getMetaTable();
    for (int iColumn = 0; iColumn < mt.getMetaColumns(); iColumn++)
      listColumnHeaders.add(mt.getMetaColumn(iColumn).getName());
    return listColumnHeaders;
  } /* getColumnHeaders */

  /*------------------------------------------------------------------*/
  /** fill the table with values from record extract
   */
  private void reset()
    throws IOException
  {
    getItems().clear();
    MetaTable mt = _re.getTable().getMetaTable();
    Archive archive = _re.getTable().getParentSchema().getParentArchive();
    if (archive.isValid()) // has primary data
    {
      for (int iRecordExtract = 0; iRecordExtract < _re.getRecordExtracts(); iRecordExtract++)
      {
        RecordExtract reChild = _re.getRecordExtract(iRecordExtract);
        List<Object> listValues = new ArrayList<Object>();
//        listValues.add(reChild.getOffset());
        listValues.add(reChild.getOffset() + 1); /* IntraDIGM */
        Record record = reChild.getRecord();
        for (int iCell = 0; iCell < record.getCells(); iCell++)
        {
          MetaColumn mc = mt.getMetaColumn(iCell);
          Cell cell = record.getCell(iCell);
          Object oValue = null;
          // depending on type add an object
          if (cell.isNull())
            oValue = "{null}";
          else if ((mc.getMetaType() != null) && (mc.getMetaType().getCategoryType() == CategoryType.UDT))
          {
            QualifiedId qiType = new QualifiedId(null,mc.getTypeSchema(),mc.getTypeName());
            oValue = "{udt:"+qiType.format()+"}";
          }
          else if (mc.getCardinality() > 0)
            oValue = "{"+mc.getType()+"}";
          else
          {
            int iType = mc.getPreType();
            if ((iType == Types.CLOB) ||
              (iType == Types.NCLOB) ||
              (iType == Types.SQLXML))
            {
              if (cell.getCharLength() > archive.getMaxInlineSize())
                oValue = "{"+SqlTypes.getTypeName(iType).toLowerCase()+":+"+cell.getCharLength()+"}";
              else
                oValue = cell.getString().replace('\n', '¶');
            }
            else if (iType == Types.BLOB)
            {
              if (cell.getByteLength() > archive.getMaxInlineSize()/2)
                oValue = "{"+SqlTypes.getTypeName(iType).toLowerCase()+":+"+cell.getByteLength()+"}";
              else
                oValue = cell.getBytes();
            }
            else if ((iType == Types.CHAR) ||
              (iType == Types.VARCHAR) ||
              (iType == Types.NCHAR) ||
              (iType == Types.NVARCHAR))
              oValue = cell.getString().replace('\n', '¶');
            else if ((iType == Types.BINARY) ||
              (iType == Types.VARBINARY))
              oValue = cell.getBytes();
            else if ((iType == Types.NUMERIC) ||
              (iType == Types.DECIMAL))
              oValue = cell.getBigDecimal();
            else if (iType == Types.SMALLINT)
              oValue = cell.getInt();
            else if (iType == Types.INTEGER)
              oValue = cell.getLong();
            else if (iType == Types.BIGINT)
              oValue = cell.getBigInteger();
            else if ((iType == Types.FLOAT) ||
              (iType == Types.DOUBLE))
              oValue = cell.getDouble();
            else if (iType == Types.REAL)
              oValue = cell.getFloat();
            else if (iType == Types.BOOLEAN)
              oValue = cell.getBoolean();
            else if (iType == Types.DATE)
              oValue = cell.getDate();
            else if (iType == Types.TIME)
              oValue = cell.getTime();
            else if (iType == Types.TIMESTAMP)
              oValue = cell.getTimestamp();
            else if (iType == Types.OTHER)
              oValue = cell.getDuration();
          }
          listValues.add(oValue);
        }
        getItems().add(listValues);
      }
      requestFocus();
    }
    else
      throw new IOException("Invalid archive has no primary data!");
  } /* reset */

  /*------------------------------------------------------------------*/
  /** constructor builds the table.
   * @param re record extract.
   */
  public RecordExtractTableView(RecordExtract re)
    throws IOException
  {
    super(getColumnHeaders(re));
    super.setMaxVisibleRows(re.getRecordExtracts());
    setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);
    for (Iterator<TableColumn<List<Object>,?>> iterColumn = getColumns().iterator(); iterColumn.hasNext(); )
    {
      ObjectListTableColumn oltc = (ObjectListTableColumn)iterColumn.next();
      double dPreferredColumnWidth = UserProperties.getUserProperties().getColumnWidth();
      oltc.setMinWidth(FxSizes.fromEms(sMIN_COLUMN_WIDTH));
      oltc.setPrefWidth(FxSizes.fromEms(dPreferredColumnWidth));
      oltc.setMaxWidth(FxSizes.fromEms(dPreferredColumnWidth*dPreferredColumnWidth/sMIN_COLUMN_WIDTH));
    }
    setOnShowCellAction(this);
    setOnSort(new EventHandler<SortEvent<TableView<List<Object>>>>()
    {
      @Override
      public void handle(SortEvent<TableView<List<Object>>> se)
      {
        RecordExtractTableView retv = RecordExtractTableView.this;
        ObjectListTableColumn oltc = (ObjectListTableColumn)retv.getSortOrder().get(0);
        if (oltc.isSortable())
        {
          SiardGui sg = SiardGui.getSiardGui();
          SiardBundle sb = SiardBundle.getSiardBundle();
          sg.startAction(sb.getTableSorting(_re.getTable().getMetaTable().getName()));
          int iSortColumn = retv.getColumns().indexOf(oltc)-1;
          SortTask.sortTask(_re.getTable(), (oltc.getSortType() == SortType.ASCENDING),
            iSortColumn, new EventHandler<WorkerStateEvent>()
          {
            @Override
            public void handle(WorkerStateEvent arg0)
            {
              SiardGui sg = SiardGui.getSiardGui();
              sg.terminateAction();
              sg.collapseToRows();
            }
          });
        }
      }
    });
    getSelectionModel().setCellSelectionEnabled(true);
    getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>()
    {
      /*------------------------------------------------------------------*/
      /** handle changes in selection: refresh menu.
       */
      @Override
      public void changed(ObservableValue<? extends Number> ov,
        Number numOld, Number numNew)
      {
        MainMenuBar.getMainMenuBar().restrict();
      } /* changed */
    });
    _re = re;
    reset();
  } /* constructor */

} /* class RecordExtractTableView */
