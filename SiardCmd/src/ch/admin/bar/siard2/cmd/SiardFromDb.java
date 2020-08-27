/*== SiardFromDb.java ======================================================
SiardFromDb stores database content in a SIARD file.
Application : Siard2
Description : Stores database content in a SIARD file.
------------------------------------------------------------------------
Copyright  : Swiss Federal Archives, Berne, Switzerland, 2008
Created    : 29.08.2016, Hartwig Thomas, Enter AG, Rüti ZH
======================================================================*/

package ch.admin.bar.siard2.cmd;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import ch.admin.bar.siard2.api.Archive;
import ch.admin.bar.siard2.api.MetaColumn;
import ch.admin.bar.siard2.api.MetaSchema;
import ch.admin.bar.siard2.api.MetaTable;
import ch.admin.bar.siard2.api.primary.ArchiveImpl;
import ch.admin.bar.siard2.api.primary.FileDownloadModel;
import ch.enterag.utils.EU;
import ch.enterag.utils.ProgramInfo;
import ch.enterag.utils.cli.Arguments;
import ch.enterag.utils.configuration.ManifestAttributes;
import ch.enterag.utils.logging.IndentLogger;

/*====================================================================*/
/** Stores database content in a SIARD file.
 @author Hartwig Thomas
 */
public class SiardFromDb
{
  /*====================================================================
  (private) constants
  ====================================================================*/
	private static final int iRETURN_OK = 0;
	private static final int iRETURN_WARNING = 4;
	private static final int iRETURN_ERROR = 8;
	private static final int iRETURN_FATAL = 12;

  /*====================================================================
  (private) data members
  ====================================================================*/
  /** logger */
  private static IndentLogger _il = IndentLogger.getIndentLogger(SiardFromDb.class.getName());
  /** manifest */
  private static final ManifestAttributes MF = ManifestAttributes.getInstance(SiardFromDb.class);
  /** info */
  private static ProgramInfo _pi = ProgramInfo.getProgramInfo(
  		"SIARD Suite",MF.getSpecificationVersion(),
      "SiardFromDb",MF.getImplementationVersion(),
      "Program to store database content in a .siard file",
  		"Swiss Federal Archives, Berne, Switzerland, 2008-2016",
      Arrays.asList((new String[] {"Hartwig Thomas, Enter AG, Rüti ZH, Switzerland",
                                   "Andreas Voss, Swiss Federal Archives, Berne, Switzerland",
                                   "Anders Bo Nielsen, Danish National Archives, Denmark",
                                   "Claire Röthlisberger-Jourdan, KOST, Berne, Switzerland"})),
      Arrays.asList((new String[] {"Hartwig Thomas, Enter AG, Rüti ZH, Switzerland",
  		                             "Simon Jutz, Cytex GmbH, Zurich, Switzerland" })),
      Arrays.asList((new String[] {"Claudia Matthys, POOL Computer AG, Zurich, Switzerland",
      		                         "Marcel Büchler, Swiss Federal Archives, Berne, Switzerland",
  	      		                     "Yvan Dutoit, Swiss Federal Archives, Berne, Switzerland"})),
      Arrays.asList((new String[] {"Hartwig Thomas, Enter AG, Rüti ZH, Switzerland",
                                   "Marcel Büchler, Swiss Federal Archives, Berne, Switzerland",
                                   "Alain Mast, Swiss Federal Archives, Berne, Switzerland",
  	      		                     "Krystyna Ohnesorge, Swiss Federal Archives, Berne, Switzerland"})));

  private boolean _bOverwrite = false;
  private boolean _bViewsAsTables = false;
  private int _iLoginTimeoutSeconds = SiardConnection.iDEFAULT_LOGIN_TIMEOUT_SECONDS;
  private int _iQueryTimeoutSeconds = SiardConnection.iDEFAULT_QUERY_TIMEOUT_SECONDS;
  private File _fileImportXml = null;
  private File _fileExternalLobFolder = null;
  private URI _uriExternalLobFolder = null;
  private String _sMimeType = null;
  private String _sJdbcUrl = null;
  private String _sDatabaseUser = null;
  private String _sDatabasePassword = null;
  private File _fileSiard = null;
  private File _fileExportXml = null;
  //2020.07.28 - siardCmd 테이블 목록 변수
  private List<String> _tableList = new ArrayList<>();
  //2020.08.10 - siardCmd 파일 컬럼 목록 변수
  private List<String> _fileColumnList = new ArrayList<>();
  //2020.08.11 - siardCmd 파일 다운로드 정보 입력
  private String _sAtchTargetFilePath = null; //첨부파일 타겟 경로
//  private String _sAtchSourceFilePath = null; //첨부파일 소스 경로(root경로)
  private String _sSftpHost = null; //sftp IP
  private String _sSftpPort = "22"; //sftp port(default)
  private String _sSftpUser = null; //sftp id
  private String _sSftpPasswd = null; //sftp password
  private boolean _sftpFlag = false;
  private boolean _fileCopyFlag = false;

  private Archive _archive = null;
  private Connection _conn = null;

	private int _iReturn = iRETURN_WARNING;
	int getReturn() { return _iReturn; }

  /*====================================================================
  methods
  ====================================================================*/
	/*------------------------------------------------------------------*/
	/** prints and logs the string */
	private static void logPrint(String s)
	{
		_il.info(s);
		System.out.println(s);
	} /* logPrint */

	/*------------------------------------------------------------------*/
  /** prints usage information */
  private void printUsage()
  {
  	System.out.println("Usage:");
  	System.out.println("java -cp <siardpath>/lib/siardcmd.jar ch.admin.bar.siard2.cmd.SiardFromDb [-h]");
    System.out.println("  [-o][-v][-l=<login timeout>][-q=<query timeout>][-i=<import xml>] [-x=<external lob folder>] [-m=<mime type>]");
  	System.out.println("  -j=<JDBC URL> -u=<database user> -p=<database password> (-s=<siard file> | -e=<export xml>)");
    System.out.println("where");
    System.out.println("  <siardpath>          installation path of SiardCmd");
    System.out.println("  -h (help)            prints this usage information");
    System.out.println("  -o (overwrite)       overwrite existing siard file");
    System.out.println("  -v (views as tables) archive views as tables");
    System.out.println("  <login timeout>      login timeout in seconds (default: "+String.valueOf(_iLoginTimeoutSeconds)+"), 0 for unlimited");
    System.out.println("  <query timeout>      query timeout in seconds (default: "+String.valueOf(_iQueryTimeoutSeconds)+"), 0 for unlimited");
    System.out.println("  <import xml>         name of meta data XML file to be used as a template");
    System.out.println("  <lob folder>         folder for storing largest LOB column of database externally");
    System.out.println("                       (contents will be deleted if they exist!)");
    System.out.println("  <mime type>          MIME type of data in the largest LOB column of database");
    System.out.println("  <JDBC URL>           JDBC URL of database to be downloaded");
    System.out.println("========== 이하 Siard_KR 추가 argument ==========");
    System.out.println("  -t : 다운로드 대상 테이블 입력 (입력 형식은 '스키마명.테이블명')");
    System.out.println("    - 전체 스키마 및 테이블 다운로드 : ex) -t=\"all\"");
    System.out.println("    - 특정 스키마에 대한 전체 테이블 다운로드 : ex) -t=\"schema1.*\"");
    System.out.println("    - 특정 테이블 다운로드 : ex) -t=\"schema1.table1,schema1.table2,schema2.table1\"");
    System.out.println("  -fc : 첨부파일의 경로가 포함된 컬럼명 입력 (입력 형식은 '테이블명.컬럼명')");
    System.out.println("    - ex) -fc=\"table1.filePath\"");
    System.out.println("  -tfp : 첨부파일의 target file path를 입력(다운로드 받을 경로)");
    System.out.println("    - ex) -tfp=\"/siardCmd/attachFile/\"");
    System.out.println("  -sfp : 첨부파일의 source file path를 입력(다운로드 대상(root) 경로)");
    System.out.println("    - ex) -sfp=\"/data/attachFile/\"");
    System.out.println("  -host : sftp 접속 host IP");
    System.out.println("    - ex) -host=\"127.0.0.1\"");
    System.out.println("  -port : sftp 접속 port (입력을 안하거나 잘못된 값(숫자가 아닌 값)으로 입력한 경우 sftp기본 포트(22)로 진행)");
    System.out.println("    - ex) -port=\"22\"");
    System.out.println("  -su : sftp 접속 user");
    System.out.println("    - ex) -su=\"user\"");
    System.out.println("  -sp : sftp 접속 password");
    System.out.println("    - ex) -sp=\"password\"");
    System.out.println("  -sftp : sftp 방식 사용(flag)");
    System.out.println("    - ex) -sftp");
    System.out.println("  -file : file copy 방식 사용(flag)");
    System.out.println("    - ex) -file");
    System.out.println("   * 기본적으로 sftp와 file은 둘 중 하나만 입력 가능합니다.");
    System.out.println("   * 만약 둘 다 입력할 경우 siard 다운로드 자체가 진행되지 않습니다.");
    System.out.println("   * 단, 둘 다 입력하지 않을 경우에는 파일 다운로드만 진행하지 않습니다.(DB정보에 대한 siard 다운로드는 정상 진행)");
    SiardConnection sc = SiardConnection.getSiardConnection();
    String[] asSchemes = sc.getSchemes();
    for (int i = 0; i < asSchemes.length; i++)
    {
      if (i > 0)
        System.out.println("                           ");
      String sScheme = asSchemes[i];
      System.out.println("for "+sc.getTitle(sScheme)+": "+sc.getSampleUrl(sScheme,"dbserver.enterag.ch","D:\\dbfolder","testdb"));
    }
    System.out.println("  <database user>      database user");
    System.out.println("  <database password>  database password");
    System.out.println("  <siard file>         name of .siard file to be written");
    System.out.println("  <export xml>         name of meta data XML file to be exported");
  } /* printUsage */

	/*------------------------------------------------------------------*/
	/** reads the parameters from the command line or from the config file.
	 * @throws IOException
	*/
	private void getParameters(String[] asArgs) throws IOException
  {
	  _il.enter();
    _iReturn = iRETURN_OK;
	  Arguments args = Arguments.newInstance(asArgs);
	  if (args.getOption("h") != null)
	    _iReturn = iRETURN_WARNING;
    /* overwrite */
    if (args.getOption("o") != null)
      _bOverwrite = true;
    /* views as tables */
    if (args.getOption("v") != null)
      _bViewsAsTables = true;
    /* login time out */
    String sLoginTimeoutSeconds = args.getOption("l");
    /* query time out */
    String sQueryTimeoutSeconds = args.getOption("q");
    /* import XML */
    String sImportXml = args.getOption("i");
    /* export XML */
    String sExportXml = args.getOption("e");
    /* external LOB folder */
    String sExternalLobFolder = args.getOption("x");
    /* MIME type for external LOB */
    _sMimeType = args.getOption("m");
    /* JDBC URI */
    _sJdbcUrl = args.getOption("j");
    /* db user */
    _sDatabaseUser = args.getOption("u");
    /* db password */
    _sDatabasePassword = args.getOption("p");
    /* siard file */
    String sSiardFile = args.getOption("s");
    /* siard Table List (2020.07.28 - 신규 추가)*/
    String sTableList = args.getOption("t");
    /* siard File Column List (2020.08.03 - 신규 추가)*/
    String sFileColumnList = args.getOption("fc");
    /* siard Target File Path (예시 : fp="/siardCmd/file/") (2020.08.11 - 신규 추가)*/
    _sAtchTargetFilePath = args.getOption("tfp");
    /* siard Source File Path (예시 : fp="/siardCmd/file/") (2020.08.11 - 신규 추가)*/
//    _sAtchSourceFilePath = args.getOption("sfp");
    /* siard sftp host ip (2020.08.11 - 신규 추가)*/
    _sSftpHost = args.getOption("host");
    /* siard sftp host port (2020.08.11 - 신규 추가)*/
    if (isNumber(args.getOption("port"))) {
    	_sSftpPort = args.getOption("port");
    }
    /* siard sftp user (2020.08.11 - 신규 추가)*/
    _sSftpUser = args.getOption("su");
    /* siard sftp password (2020.08.11 - 신규 추가)*/
    _sSftpPasswd = args.getOption("sp");
    /* sftp flag */
    if (args.getOption("sftp") != null)
    	_sftpFlag = true;
    /* fileCopy flag */
    if (args.getOption("file") != null)
    	_fileCopyFlag = true;

    System.out.println("");
    System.out.println("================================RETURN MESSAGE START================================");

    /* analyze the parameters */
    if (_iReturn == iRETURN_OK)
    {
      //2020.07.28 - siardCmd 파라미터로 받은 테이블 목록 세팅하기
      if (sTableList != null) {
      	_tableList = new ArrayList<>();

    		StringTokenizer st = new StringTokenizer(sTableList, ",");

    		while (st.hasMoreElements())
    		{
    			String tableName = (String) st.nextElement();
    			if(!"all".equals(tableName)) {
    				//schema.table -> 2개가 나와야함.
    				checkArgumentValue(tableName, 2);
    			}
    			_tableList.add(tableName.trim());
    		}
      }

      if (sTableList == null)
      {
        System.out.println("테이블(-t=\"schema.table\")은 필수 입력입니다.");
        System.out.println(" - 모든 스키마 및 테이블을 다운로드 할 경우에는 -t=\"all\"을 입력해주세요.");
        System.out.println(" - 특정 스키마에 대한 모든 테이블을 다운로드 할 경우에는 -t=\"schema.*\"을 입력해주세요.");
        _iReturn = iRETURN_ERROR;
      }

      if (sSiardFile != null)
      	_fileSiard = new File(sSiardFile);
      if (sExportXml != null)
        _fileExportXml = new File(sExportXml);

      if ((sSiardFile == null) && (sExportXml == null))
      {
        System.out.println("SIARD file and/or export meta data XML must be given!");
        _iReturn = iRETURN_ERROR;
      }
      if (sLoginTimeoutSeconds != null)
      {
        try { _iLoginTimeoutSeconds = Integer.parseInt(sLoginTimeoutSeconds); }
        catch(NumberFormatException nfe)
        {
          System.out.println("Invalid login timeout: "+sLoginTimeoutSeconds+"!");
          _iReturn = iRETURN_ERROR;
        }
      }
      if (sQueryTimeoutSeconds != null)
      {
        try { _iQueryTimeoutSeconds = Integer.parseInt(sQueryTimeoutSeconds); }
        catch(NumberFormatException nfe)
        {
          System.out.println("Invalid query timeout: "+sQueryTimeoutSeconds+"!");
          _iReturn = iRETURN_ERROR;
        }
      }
      if (sImportXml != null)
      {
        _fileImportXml = new File(sImportXml);
        if (!(_fileImportXml.isFile() && _fileImportXml.exists()))
        {
          System.out.println("File import XML "+_fileImportXml.getAbsolutePath() + " does not exist!");
          _iReturn = iRETURN_ERROR;
        }
      }
      if (sExternalLobFolder != null)
      {
        _fileExternalLobFolder = new File(sExternalLobFolder);
        if (!(_fileExternalLobFolder.exists() && _fileExternalLobFolder.isDirectory()))
        {
          System.out.println("External LOB folder  "+_fileExternalLobFolder.getAbsolutePath() + " does not exist!");
          _iReturn = iRETURN_ERROR;
        }
        else
        {
          /* relativize it from SIARD file's parent folder */
          File fileRelative = _fileSiard.getParentFile().getAbsoluteFile().toPath().relativize(_fileExternalLobFolder.getAbsoluteFile().toPath()).toFile();
          /* prepend a ../ for exiting the SIARD file and append a / to indicate that it is a folder */
          try { _uriExternalLobFolder =  new URI("../"+fileRelative.toString()+"/"); }
          catch (URISyntaxException use)
          {
            System.out.println("External LOB folder  "+_fileExternalLobFolder.getAbsolutePath() + " could not be relativized!");
            _iReturn = iRETURN_ERROR;
          }
        }

      }
      String sError = SiardConnection.getSiardConnection().loadDriver(_sJdbcUrl);
      if (sError != null)
      {
        System.out.println("JDBC URL "+String.valueOf(_sJdbcUrl)+" is not valid!");
        System.out.println(sError);
        _iReturn = iRETURN_ERROR;
      }
      if (_sDatabaseUser == null)
      {
        System.out.println("Database user must be given!");
        _iReturn = iRETURN_ERROR;
      }
      if (_sDatabasePassword == null)
      {
        System.out.println("Database password must be given!");
        _iReturn = iRETURN_ERROR;
      }

      /**
       * 20200820 - 파일 다운로드 관련 argument 체크
       */
      if(_sftpFlag && _fileCopyFlag) {
    		System.out.println("sftp 및 file 인자는 둘 중 하나만 입력해야합니다. \n -sftp : sftp방식 파일 다운로드 \n -file : file copy방식 파일 다운로드");
        System.out.println("둘 다 입력할 경우 siard 다운로드 자체가 진행되지 않습니다.");
        System.out.println("단, 둘 다 입력하지 않을 경우에는 파일 다운로드만 진행하지 않습니다.(DB정보에 대한 siard 다운로드는 정상 진행)");
				_iReturn = iRETURN_ERROR;
    	}
      //2020.08.10 - siardCmd 파라미터로 받은 파일 컬럼 목록 세팅하기
    	if(_iReturn != iRETURN_ERROR && (_sftpFlag || _fileCopyFlag)) {
    		if (sFileColumnList == null) {
    			System.out.println("파일 다운로드 처리시 파일 컬럼(-fc=\"schema.table.column\")은 필수 입력입니다.");
  				_iReturn = iRETURN_ERROR;
    		}
    		if (sFileColumnList != null) {
    			_fileColumnList = new ArrayList<>();

  				StringTokenizer st = new StringTokenizer(sFileColumnList, ",");

  				while (st.hasMoreElements())
  				{
  					String columnName = (String) st.nextElement();
  					//schema.table.column -> 3개가 나와야함.
  					checkArgumentValue(columnName, 3);
  					_fileColumnList.add(columnName.trim());
  				}

    			//2020.08.11 - siardCmd 파라미터로 받은 sftp 입력값 체크
    			if (_sAtchTargetFilePath == null) {
    				System.out.println("파일 다운로드 처리시 target file path(-tfp=\"target file path\")는 필수 입력입니다.");
    				_iReturn = iRETURN_ERROR;
    			}
//    			if (_fileCopyFlag && _sAtchSourceFilePath == null) {
//    				System.out.println("file copy 방식의 파일 다운로드 처리시 source file path(-sfp=\"source file path\")는 필수 입력입니다.");
//    				_iReturn = iRETURN_ERROR;
//    			}
    			if (_sftpFlag && _sSftpHost == null) {
    				System.out.println("sftp 방식의 파일 다운로드 처리시 host ip(-host=\"host ip\")는 필수 입력입니다.");
    				_iReturn = iRETURN_ERROR;
    			}
    			if (_sftpFlag && _sSftpUser == null) {
    				System.out.println("sftp 방식의 파일 다운로드 처리시 user(-su=\"user\")는 필수 입력입니다.");
    				_iReturn = iRETURN_ERROR;
    			}
    			if (_sftpFlag && _sSftpPasswd == null) {
    				System.out.println("sftp 방식의 파일 다운로드 처리시 password(-sp=\"password\")는 필수 입력입니다.");
    				_iReturn = iRETURN_ERROR;
    			}
    		}
    	}
    }

    System.out.println("================================RETURN MESSAGE END================================");
    System.out.println("");

    /* print and log the parameters */
    if (_iReturn == iRETURN_OK)
    {
      logPrint("");
      logPrint("Parameters");
      logPrint("  JDBC URL               : "+_sJdbcUrl);
      logPrint("  Database user          : "+_sDatabaseUser);
      logPrint("  Database password      : ***");
      if (_fileSiard != null)
        logPrint("  SIARD file             : "+_fileSiard.getAbsolutePath());
      if (_fileExportXml != null)
        logPrint("  Export meta data XML   : "+_fileExportXml.getAbsolutePath());
      if (sLoginTimeoutSeconds != null)
        logPrint("  Login timeout          : "+String.valueOf(_iLoginTimeoutSeconds)+" seconds");
      if (sQueryTimeoutSeconds != null)
        logPrint("  Query timeout          : "+String.valueOf(_iQueryTimeoutSeconds)+" seconds");
      if (_fileImportXml != null)
        logPrint("  Import meta data XML   : "+_fileImportXml.getAbsolutePath());
      if (_uriExternalLobFolder != null)
        logPrint("  External LOB folder    : "+_uriExternalLobFolder.toString());
      if (_sMimeType != null)
        logPrint("  External LOB MIME type : "+_sMimeType);
      if (_bViewsAsTables)
        logPrint("  Archive views as tables: "+String.valueOf(_bViewsAsTables));
      logPrint("");
    }
    else
      printUsage();
	  _il.exit();
  } /* getParameters */

  //argument value값 체크
  private void checkArgumentValue(String value, int checkInt) {
		String valueTitle = (checkInt == 2 ? "테이블" : "파일 컬럼");
		if(value.split("[.]").length != checkInt) {
			System.out.println(valueTitle + "은 (-fc=\"schema.table.column\") 형식으로 입력해야합니다.");
			System.out.println(" - 관련 " + valueTitle + " = " + value);
			_iReturn = iRETURN_ERROR;
		}
	}

  //숫자값 체크
  private boolean isNumber(String port)
  {
  	try {
  		Integer.parseInt(port);
  		return true;
  	} catch (NumberFormatException e) {
  		return false;
  	}
  }

	/*====================================================================
  constructor
  ====================================================================*/
	/*------------------------------------------------------------------*/
	/** runs main program of SiardFromDb. */
	SiardFromDb(String asArgs[])
	  throws SQLException, IOException, ClassNotFoundException
  {
	  super();
	  _il.enter();
	  /* parameters */
	  getParameters(asArgs);
	  if (_iReturn == iRETURN_OK)
	  {
	    if (_bOverwrite)
	    {
	      if (_fileSiard != null)
	      {
	        if (_fileSiard.exists())
	          _fileSiard.delete();
	      }
	      if (_fileExportXml != null)
	      {
	        if (_fileExportXml.exists())
	          _fileExportXml.delete();
	      }
	    }
	    if (((_fileSiard == null) || !_fileSiard.exists()) &&
	        ((_fileExportXml == null) || !_fileExportXml.exists()))
	    {
	      /* open connection */
	      String sError = SiardConnection.getSiardConnection().loadDriver(_sJdbcUrl);
	      if ((sError == null) || (sError.length() == 0))
	      {
	        DriverManager.setLoginTimeout(_iLoginTimeoutSeconds);
	        _conn = DriverManager.getConnection(_sJdbcUrl, _sDatabaseUser, _sDatabasePassword);
	        if ((_conn != null) && (!_conn.isClosed()))
	        {
	          System.out.println("Connected to "+_conn.getMetaData().getURL().toString());
	          _conn.setAutoCommit(false);
	          /* open SIARD archive */
	          _archive = ArchiveImpl.newInstance();
	          File fileSiard = _fileSiard;
	          if (fileSiard == null)
	          {
	            fileSiard = File.createTempFile("siard", ".siard");
	            fileSiard.delete();
	          }
	          _archive.create(fileSiard);
	          if (_fileImportXml != null)
	          {
	            FileInputStream fis = new FileInputStream(_fileImportXml);
	            _archive.importMetaDataTemplate(fis);
	            fis.close();
	          }

	          MetaDataFromDb mdfd;
	          //2020.07.28 - archive 파라미터 추가
	          //archive에 파라미터로 받은 테이블 목록 세팅.
	          if(_tableList.size() > 0) {
	          	System.out.println("_tableList is not null");
	          	_archive.setOriginalDir(""); //원본 파일 경로
		          _archive.setFileDown("SFTP");
		          _archive.setSchema("");
		          _archive.setTargetDir(fileSiard.getParent());
		          _archive.setFilePath("");
	          	_archive.setTableCheckedList(_tableList);

	          	/**
	          	 * 20200819 - 파일 다운로드 관련 데이터 세팅 추가
	          	 * file download flag 입력여부 확인 후 진행. (sftp 또는 file copy)
	          	 */
	          	Map<String, FileDownloadModel> chooseColumnMap = new HashMap<String, FileDownloadModel>();
	          	if(_fileCopyFlag || _sftpFlag) {
	          		FileDownloadModel fileModel = new FileDownloadModel();
	          		fileModel.setTargetFilePath(_sAtchTargetFilePath);
//	          		fileModel.setSourceFilePath(_sAtchSourceFilePath);
	          		fileModel.setHost(_sSftpHost);
	          		fileModel.setPort(Integer.parseInt(_sSftpPort));
	          		fileModel.setUser(_sSftpUser);
	          		fileModel.setPassword(_sSftpPasswd);
	          		fileModel.setFileCopyFlag(_fileCopyFlag);
	          		fileModel.setSftpFlag(_sftpFlag);

	          		//파일 컬럼 세팅
	          		List<FileDownloadModel> rFileColumnList = new ArrayList<FileDownloadModel>();
	          		FileDownloadModel fdm = new FileDownloadModel();
	          		for (int i = 0; i < _tableList.size(); i++)	{
	          			String table_schemaTable = _tableList.get(i);
	          			fileModel.setSchemaName(_tableList.get(i).substring(0, table_schemaTable.lastIndexOf(".")));
	          			fileModel.setTableName(_tableList.get(i).substring(table_schemaTable.lastIndexOf(".")+1));

	          			//각 테이블 별로 파일 컬럼 리스트를 세팅
	          			for (int j = 0; j < _fileColumnList.size(); j++) {
	          				String column_schemaTable = _fileColumnList.get(j).substring(0, _fileColumnList.get(j).lastIndexOf("."));
	          				String columnName = _fileColumnList.get(j).substring(_fileColumnList.get(j).lastIndexOf(".")+1);
	          				if(table_schemaTable.equals(column_schemaTable)) {
	          					//TODO : rootPath 넣어야함.
	          					fdm.setColumnName(columnName);
	          					rFileColumnList.add(fdm);
	          				}
	          			}
	          			fileModel.setChooseColumnList(rFileColumnList);
	          			chooseColumnMap.put(table_schemaTable, fileModel);
	          		}
	          	}
	          	_archive.setColumnCheckedMap(chooseColumnMap);

	          	mdfd = MetaDataFromDb.newInstance(_conn.getMetaData(), _archive.getMetaData(), _archive);
	          } else {
	          	System.out.println("_tableList is null");
	          	//기존 소스
	          	/* get meta data from DB */
	          	mdfd = MetaDataFromDb.newInstance(_conn.getMetaData(), _archive.getMetaData());
	          }

						mdfd._cubrid = _conn.getMetaData().getDatabaseProductName().equals("CUBRID");
	          mdfd.setQueryTimeout(_iQueryTimeoutSeconds);
	          mdfd.download(_bViewsAsTables, (_uriExternalLobFolder != null), null);
	          /* set external LOB stuff */
	          if (_uriExternalLobFolder != null)
	          {
	            MetaColumn mcMaxLob = mdfd.getMaxLobColumn();
	            if (mcMaxLob != null)
	            {
	              String sColumnName = mcMaxLob.getName();
	              MetaTable mtLob = mcMaxLob.getParentMetaTable();
	              String sTableName = mtLob.getName();
	              MetaSchema msLob = mtLob.getParentMetaSchema();
	              String sSchemaName = msLob.getName();
	              String sMessage = "LOBs in database column \""+sColumnName+"\" in table \""+sTableName+"\" in schema \""+sSchemaName+
                 "\" will be stored externally in folder \""+_fileExternalLobFolder.getAbsolutePath().toString()+"\"";
	              mcMaxLob.setLobFolder(_uriExternalLobFolder);
	              if (_sMimeType != null)
	              {
	                mcMaxLob.setMimeType(_sMimeType);
	                sMessage = sMessage + " with MIME type "+mcMaxLob.getMimeType();
	              }
	              System.out.println();
	              System.out.println(sMessage);
	            }
	            else
	              System.out.println("No LOB column found to be externalized!");
	          }
	          /* export meta data XML from DB */
	          if (_fileExportXml != null)
	          {
	            OutputStream osXml = new FileOutputStream(_fileExportXml);
	            _archive.exportMetaData(osXml);
	            osXml.close();
	          }
	          if (_fileSiard != null)
	          {
  	          /* export primary data from DB */
  	          PrimaryDataFromDb pdfd = PrimaryDataFromDb.newInstance(_conn, _archive);
  	          pdfd.setQueryTimeout(_iQueryTimeoutSeconds);
  	          pdfd.download(null);
	          }
            else
              fileSiard.deleteOnExit();
	          /* close SIARD archive */
	          /***
	          FileOutputStream fosXml = new FileOutputStream("D:\\Projekte\\SIARD2\\SiardCmd\\tmp\\export.xml");
	          _archive.exportMetaData(fosXml);
	          fosXml.close();
	          ***/
	          _archive.close();
	          /* close connection */
	          _conn.rollback();
	          _conn.close();
	        }
	        else
	          System.out.println("Connection to "+_conn.getMetaData().getURL().toString()+" failed!");
	      }
	      else
	        System.out.println("Connection to "+_sJdbcUrl+" not supported ("+sError+")!");
	    }
	    else
	    {
	      String sMessage = "File "+_fileSiard.getAbsolutePath();
	      if (_fileExportXml != null)
	        sMessage = sMessage + " or "+_fileExportXml.getAbsolutePath()+" exist already!";
	      else
	        sMessage = sMessage + " exists already!";
        System.out.println(sMessage);
        System.out.println("Backup and delete it or use option -o for overwriting it.");
	      _iReturn = iRETURN_WARNING;
	    }
	  }
	  _il.exit();
  } /* constructor SiardFromDb */

  /*====================================================================
  factory
  ====================================================================*/
	/*------------------------------------------------------------------*/
	/** main entry point starts logging and creates running instance.
	@param asArgs command-line arguments are ignored
	*/
	public static void main(String[] asArgs)
	{
		int iReturn = iRETURN_WARNING;
		try
		{
			_pi.printStart();
	    _pi.logStart();
	    _il.systemProperties();
	    /* run application */
	    SiardFromDb sfdb = new SiardFromDb(asArgs);
	    /* log termination info */
	    _pi.logTermination();
	    /* termination information */
	    _pi.printTermination();
	    iReturn = sfdb.getReturn();
		}
		catch (Exception e)
		{
		  _il.exception(e);
		  System.out.println(EU.getExceptionMessage(e));
			iReturn = iRETURN_ERROR;
		}
		catch (Error e)
		{
      _il.error(e);
      System.out.println(EU.getErrorMessage(e));
			iReturn = iRETURN_FATAL;
		}
    System.exit(iReturn);
	} /* main */

} /* class SiardFromDb */
