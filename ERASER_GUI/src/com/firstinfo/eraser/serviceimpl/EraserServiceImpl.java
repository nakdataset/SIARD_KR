package com.firstinfo.eraser.serviceimpl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.firstinfo.eraser.config.Constants;
import com.firstinfo.eraser.service.EraserService;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 삭제 프로그램 기능구현 1. 스크립트 목록조회/상세조회 2. 스크립트 저장 파일 삭제/변경/실행 3. DBMS 접속정보 저장/조회 4.
 * 스크립트 실행이력 조회/저장
 *
 * @author 국가기록원
 *
 */
public class EraserServiceImpl implements EraserService
{

	private String			data_dir	= "data";

	private BASE64Encoder	encoder		= new BASE64Encoder();

	private BASE64Decoder	decoder		= new BASE64Decoder();

	/**
	 * 삭제 스크립트를 저장한다.
	 *
	 * @title 삭제 스크립트명
	 * @date 삭제 스크립트 저장 일자
	 * @desc 삭제 스크립트 설명
	 * @sql 삭제 스크립트
	 */
	@Override
	public String erasercreate(String title, String date, String desc, String sql)
	{
		boolean	is_success		= true;
		String	makefilename	= null;
		try
		{
			Path	currentRelativePath	= Paths.get("");
			String	s					= currentRelativePath.toAbsolutePath().toString();
			System.out.println("Current relative path is: " + s);

			// 기존 파일이 있는지 조회한다.
			File file_eraser_dir = new File(data_dir);

			System.out.println("file_eraser_dir.getAbsolutePath()=" + file_eraser_dir.getAbsolutePath());
			System.out.println("file_eraser_dir.exists()=" + file_eraser_dir.exists());

			if(!file_eraser_dir.exists()) {
				file_eraser_dir.mkdir();
			}

			File	file_eraser_list[]	= file_eraser_dir.listFiles();

			String	str_max_number		= "1";
			String	temp_number			= "1";
			int		n_max_number		= 1;

			// file_eraser_info 으로 시작하는 파일을 찾아서 파일번호 1 증가한다.
			if(file_eraser_list != null && file_eraser_list.length > 0)
			{
				for(int ix = 0; ix < file_eraser_list.length; ix++)
				{
					String file_name = file_eraser_list[ix].getName();

					if(file_name.indexOf("file_eraser_info") > -1)
					{
						file_name	= file_name.substring(0, file_name.lastIndexOf("."));

						// 맨마지막 3자리 숫자 가져온다. file_eraser_info_004 --> 004
						temp_number	= file_name.substring(file_name.length() - 3, file_name.length());

						System.out.println("temp_number=" + temp_number);

						if(Integer.parseInt(temp_number) > Integer.parseInt(str_max_number))
						{
							str_max_number = temp_number;
						}
					}

				}

				// 004 -> 005 1증가한다.
				n_max_number = Integer.parseInt(str_max_number) + 1;
			}

			String new_max_number = String.valueOf(n_max_number);

			// 3자리로 맞춘다. 5 --> 005
			if(new_max_number.length() == 1)
			{
				new_max_number = "00" + new_max_number;
			}
			else if(new_max_number.length() == 2)
			{
				new_max_number = "0" + new_max_number;
			}

			File	file_eraser_info	= new File(data_dir + "/file_eraser_info_" + new_max_number + ".txt");
			File	file_eraser_sql		= new File(data_dir + "/file_eraser_sql_" + new_max_number + ".txt");

			file_eraser_info.createNewFile();
			file_eraser_sql.createNewFile();

			FileOutputStream	fos_eraser_info	= new FileOutputStream(file_eraser_info);
			FileOutputStream	fos_eraser_sql	= new FileOutputStream(file_eraser_sql);

			BufferedWriter		bw_eraser_info	= new BufferedWriter(new OutputStreamWriter(fos_eraser_info));
			BufferedWriter		bw_eraser_sql	= new BufferedWriter(new OutputStreamWriter(fos_eraser_sql));

			bw_eraser_info.write(title);
			bw_eraser_info.newLine();
			bw_eraser_info.write(date);
			bw_eraser_info.newLine();
			bw_eraser_info.write(desc);

			bw_eraser_sql.write(sql);

			bw_eraser_info.close();
			bw_eraser_sql.close();

			fos_eraser_info.close();
			fos_eraser_sql.close();

			makefilename = "file_eraser_info_" + new_max_number + ".txt, file_eraser_sql_" + new_max_number + ".txt";

			// file_eraser_info.close();
			// file_eraser_sql.close();
		}
		catch(NumberFormatException e)
		{
			is_success = false;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(FileNotFoundException e)
		{
			is_success = false;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(IOException e)
		{
			is_success = false;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return makefilename;
	}

	/**
	 * 삭제 스크립트 목록조회
	 */
	@Override
	public Vector eraserlist()
	{
		Vector<Hashtable> v = new Vector<Hashtable>();

		try
		{
			// 기존 파일이 있는지 조회한다.
			File	file_eraser_dir		= new File(data_dir);
			File	file_eraser_list[]	= file_eraser_dir.listFiles();

			if(file_eraser_list != null && file_eraser_list.length > 0)
			{
				for(int ix = 0; ix < file_eraser_list.length; ix++)
				{
					String file_name = file_eraser_list[ix].getName();

					if(file_name.indexOf("file_eraser_info") > -1)
					{
						RandomAccessFile	randomfile	= new RandomAccessFile(file_eraser_list[ix], "r");

						String				title		= new String(randomfile.readLine().getBytes("ISO-8859-1"),
						        "UTF-8");
						String				date		= new String(randomfile.readLine().getBytes("ISO-8859-1"),
						        "UTF-8");

						file_name.substring(0, file_name.lastIndexOf("."));

						String number = file_name.substring(0, file_name.lastIndexOf("."));

						number = number.substring(number.length() - 3);

						Hashtable<String, String> hash = new Hashtable<String, String>();
						hash.put("TITLE", title);
						hash.put("DATE", date);
						hash.put("NUMBER", number);
						v.add(hash);
						randomfile.close();
					}

				}
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return v;
	}

	/**
	 * 삭제 스크립트 상세조회
	 */
	@Override
	public Hashtable eraserview(String number)
	{
		Hashtable<String, String> hash = new Hashtable<String, String>();
		try
		{
			// 기존 파일이 있는지 조회한다.
			File				file_eraser_info	= new File(data_dir + "/file_eraser_info_" + number + ".txt");
			File				file_eraser_sql		= new File(data_dir + "/file_eraser_sql_" + number + ".txt");

			RandomAccessFile	randomfile_info		= new RandomAccessFile(file_eraser_info, "r");
			RandomAccessFile	randomfile_sql		= new RandomAccessFile(file_eraser_sql, "r");

			String				title				= new String(randomfile_info.readLine().getBytes("ISO-8859-1"),
			        "UTF-8");
			String				date				= new String(randomfile_info.readLine().getBytes("ISO-8859-1"),
			        "UTF-8");

			String				desc				= "";
			String				desc_temp			= "";

			while((desc_temp = randomfile_info.readLine()) != null)
			{
				byte ptext[] = desc_temp.getBytes("ISO-8859-1");
				desc_temp	= new String(ptext, "UTF-8");
				desc		+= desc_temp;
			}

			String	sql			= "";
			String	sql_temp	= "";

			int		count		= 0;
			while((sql_temp = randomfile_sql.readLine()) != null)
			{
				byte ptext[] = sql_temp.getBytes("ISO-8859-1");
				sql_temp = new String(ptext, "UTF-8");
				System.out.println("sql_temp=" + sql_temp);

				if(count > 0)
				{
					sql += "\n" + sql_temp;
				}
				else
				{
					sql += sql_temp;
				}

				count++;
			}

			hash.put("TITLE", title);
			hash.put("DATE", date);
			hash.put("DESC", desc);
			hash.put("SQL", sql);
			hash.put("NUMBER", number);

			randomfile_info.close();
			randomfile_sql.close();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return hash;
	}

	/**
	 * 삭제 스크립트 삭제
	 */
	@Override
	public boolean eraserdelete(String number)
	{
		boolean is_success = true;
		try
		{
			// 기존 파일이 있는지 조회한다.
			// 기존파일을 삭제한다.
			File	file_eraser_info	= new File(data_dir + "/file_eraser_info_" + number + ".txt");
			File	file_eraser_sql		= new File(data_dir + "/file_eraser_sql_" + number + ".txt");

			if(file_eraser_info.exists())
			{
				file_eraser_info.delete();
			}
			else
			{
				is_success = false;
			}

			if(file_eraser_sql.exists())
			{
				file_eraser_sql.delete();
			}
			else
			{
				is_success = false;
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return is_success;
	}

	/**
	 * 삭제 스크립트 변경
	 */
	@Override
	public boolean eraserchange(String number, String title, String date, String desc, String sql)
	{
		boolean is_success = true;
		try
		{
			// 기존파일을 삭제한다.
			File	file_eraser_info	= new File(data_dir + "/file_eraser_info_" + number + ".txt");
			File	file_eraser_sql		= new File(data_dir + "/file_eraser_sql_" + number + ".txt");

			if(file_eraser_info.exists())
			{
				file_eraser_info.delete();
			}
			else
			{
				is_success = false;
			}

			if(file_eraser_sql.exists())
			{
				file_eraser_sql.delete();
			}
			else
			{
				is_success = false;
			}

			// 같은 이름으로 새로 생성한다.
			File	file_eraser_info_new	= new File(data_dir + "/file_eraser_info_" + number + ".txt");
			File	file_eraser_sql_new		= new File(data_dir + "/file_eraser_sql_" + number + ".txt");

			file_eraser_info_new.createNewFile();
			file_eraser_sql_new.createNewFile();

			FileOutputStream	fos_eraser_info_new	= new FileOutputStream(file_eraser_info_new);
			FileOutputStream	fos_eraser_sql_new	= new FileOutputStream(file_eraser_sql_new);

			BufferedWriter		bw_eraser_info_new	= new BufferedWriter(new OutputStreamWriter(fos_eraser_info_new));
			BufferedWriter		bw_eraser_sql_new	= new BufferedWriter(new OutputStreamWriter(fos_eraser_sql_new));

			bw_eraser_info_new.write(title);
			bw_eraser_info_new.newLine();
			bw_eraser_info_new.write(date);
			bw_eraser_info_new.newLine();
			bw_eraser_info_new.write(desc);

			bw_eraser_sql_new.write(sql);

			bw_eraser_info_new.close();
			bw_eraser_sql_new.close();

			fos_eraser_info_new.close();
			fos_eraser_sql_new.close();

		}
		catch(Exception e)
		{
			is_success = false;
			e.printStackTrace();
		}

		return is_success;
	}

	/**
	 * DBMS 접속정보 저장
	 */
	@Override
	public boolean dbconfigsave(String dbsystem, String address, String sid, String user, String pw, String jdbc)
	{
		boolean is_success = true;
		try
		{
			// ClassPathResource resource = new
			// ClassPathResource("config/db.properties");

			/* 20200703] 최창근 경로수정 */
//			File			dbconfigfile		= new File("./config/db.properties");
			File			dbconfigfile		= new File(Constants.DB_PROPERTIES_PATH);

			FileOutputStream	fos				= new FileOutputStream(dbconfigfile);

			Properties			dbpropert		= new Properties();

			dbpropert.setProperty("dbsystem", dbsystem);
			dbpropert.setProperty("address", address);
			dbpropert.setProperty("sid", sid);
			dbpropert.setProperty("user", user);
			dbpropert.setProperty("pw", pw);
			dbpropert.setProperty("jdbc", jdbc);

			System.out.println("dbsystem=" + dbsystem);
			System.out.println("address=" + address);
			System.out.println("sid=" + sid);
			System.out.println("user=" + user);
			System.out.println("pw=" + pw);
			System.out.println("jdbc=" + jdbc);

			dbpropert.store(fos, "this is db config item");

			fos.close();

		}
		catch(Exception e)
		{
			is_success = false;
			e.printStackTrace();
		}

		return is_success;
	}

	/**
	 * DBMS 접속정보 조회
	 */
	@Override
	public Hashtable dbconfigview()
	{
		Hashtable<String, String> hash = new Hashtable<String, String>();
		try
		{
			// ClassPathResource resource = new
			// ClassPathResource("config/db.properties");
			/* 20200703] 최창근 경로수정 */
//			File			dbconfigfile		= new File("./config/db.properties");
			File			dbconfigfile		= new File(Constants.DB_PROPERTIES_PATH);

			FileInputStream	fis				= new FileInputStream(dbconfigfile);

			Properties		dbpropert		= new Properties();

			dbpropert.load(fis);

			if(dbpropert.getProperty("dbsystem") != null)
			{
				hash.put("dbsystem", dbpropert.getProperty("dbsystem"));
			}

			if(dbpropert.getProperty("address") != null)
			{
				hash.put("address", dbpropert.getProperty("address"));
			}

			if(dbpropert.getProperty("sid") != null)
			{
				hash.put("sid", dbpropert.getProperty("sid"));
			}

			if(dbpropert.getProperty("user") != null)
			{
				hash.put("user", dbpropert.getProperty("user"));
			}

			if(dbpropert.getProperty("pw") != null)
			{
				hash.put("pw", dbpropert.getProperty("pw"));
			}

			if(dbpropert.getProperty("jdbc") != null)
			{
				hash.put("jdbc", dbpropert.getProperty("jdbc"));
			}

			fis.close();

		}
		catch(Exception e)
		{

			e.printStackTrace();
		}

		return hash;
	}

	/**
	 * 삭제 스크립트 실행
	 *
	 * @number 삭제 스크립트 저장파일 순번
	 * @title 삭제 스크립트 명
	 * @test
	 * @all 삭제 스크립트 모두 수행 후 commit 여부
	 */
	@Override
	public Hashtable eraserexecute(String number, String title, String test, String all, String comment)
	{
		Hashtable<String, String>	hash		= new Hashtable<String, String>();
		String						errorsql	= "";

		try
		{
			Connection		connection			= null;
			Statement		statement			= null;
			ResultSet		resultSet			= null;

			String			driverNameOracle	= "oracle.jdbc.driver.OracleDriver";
			String			driverNameCubrid	= "cubrid.jdbc.driver.CUBRIDDriver";
			String			driverNameTibero	= "com.tmax.tibero.jdbc.TbDriver";
			String			driverNameMysql		= "com.mysql.jdbc.Driver";
			String			driverNameMssql		= "com.microsoft.sqlserver.jdbc.SQLServerDriver";

			String			dbsystem			= "";
			String			url					= "";
			String			user				= "";
			String			password			= "";

			int				resultValue			= 0;

			// ClassPathResource resource = new
			// ClassPathResource("config/db.properties");
			/* 20200703] 최창근 경로수정 */
//			File			dbconfigfile		= new File("./config/db.properties");
			File			dbconfigfile		= new File(Constants.DB_PROPERTIES_PATH);

			FileInputStream	fis					= new FileInputStream(dbconfigfile);

			Properties		dbpropert			= new Properties();

			dbpropert.load(fis);

			if(dbpropert.getProperty("dbsystem") != null)
			{
				dbsystem = dbpropert.getProperty("dbsystem");
			}

			if(dbpropert.getProperty("user") != null)
			{
				user = dbpropert.getProperty("user");
			}

			if(dbpropert.getProperty("pw") != null)
			{
				password = dbpropert.getProperty("pw");
			}

			if(dbpropert.getProperty("jdbc") != null)
			{
				url = dbpropert.getProperty("jdbc");
			}

			if(dbsystem.equals("oracle"))
			{
				Class.forName(driverNameOracle);
			}
			else if(dbsystem.equals("cubrid"))
			{
				Class.forName(driverNameCubrid);
			}
			else if(dbsystem.equals("tibero"))
			{
				Class.forName(driverNameTibero);
			}
			else if(dbsystem.equals("mysql"))
			{
				Class.forName(driverNameMysql);
			}
			else if(dbsystem.equals("mssql"))
			{
				Class.forName(driverNameMssql);
			}

			// 기존 파일이 있는지 조회한다.
			File				file_eraser_sql	= new File(data_dir + "/file_eraser_sql_" + number + ".txt");

			RandomAccessFile	randomfile_sql	= new RandomAccessFile(file_eraser_sql, "r");

			String				sql				= "";
			String				sql_temp		= "";
			int					count			= 0;
			while((sql_temp = randomfile_sql.readLine()) != null)
			{
				byte ptext[] = sql_temp.getBytes("ISO-8859-1");
				sql_temp = new String(ptext, "UTF-8");
				// System.out.println("sql_temp=" + sql_temp);

				if(count > 0)
				{
					sql += "\n" + sql_temp;
				}
				else
				{
					sql += sql_temp;
				}

				count++;
			}

			connection = DriverManager.getConnection(url, user, password);

			// System.out.println("test=" + test);
			// //테스트박스가 체크되면 롤백한다.
			// if(test.equals("true"))
			// {
			// connection.setAutoCommit(false);
			// }
			// else
			// {
			// connection.setAutoCommit(true);
			// }

			// 커밋선택을 하기 위해서
			// sql 하나씩 커밋 아니면 전부 실행하고 커밋
			connection.setAutoCommit(false);

			System.out.println("SQL:" + sql);

			statement = connection.createStatement();

			// 2개 이상의 문장이 있으면 반복해서 실행한다.
			if(sql.indexOf(";") > 0)
			{
				String sql_split[] = sql.split(";");

				for(int ix = 0; ix < sql_split.length; ix++)
				{
					// 여러개의 sql문 실행
					sql_split[ix] = sql_split[ix].trim();
					System.out.println("SQL ONE:" + sql_split[ix]);

					if(sql_split[ix].trim().length() > 0)
					{
						errorsql	= sql_split[ix];
						resultValue	+= statement.executeUpdate(sql_split[ix]);

						if(all.equals("false"))
						{
							connection.commit();
						}
					}
				}
			}
			else
			{
				errorsql	= sql;
				resultValue	= statement.executeUpdate(sql);
			}

			if(all.equals("true"))
			{
				connection.commit();
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

			Hashtable hash_history = new Hashtable();

			this.eraserhistorysave(number, title, resultValue, sql, comment);

			// //테스트박스가 체크되면 롤백한다.
			// if(test.equals("true"))
			// {
			// connection.rollback();
			// }
			// else
			// {
			// //삭제 스크립트 이력 저장
			// //삭제후 커밋이 되면
			// this.eraserhistorysave(number, title, resultValue, sql);
			// }

			hash.put("COUNT", String.valueOf(resultValue));
			hash.put("SUCCESS", "true");
		}
		catch(FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			hash.put("SUCCESS", "false");
		}
		catch(IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			hash.put("SUCCESS", "false");
		}
		catch(SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();

			hash.put("SUCCESS", "false");
			hash.put("ERRORCODE", String.valueOf(e.getErrorCode()));

			String localmessage = e.getLocalizedMessage();

			localmessage = localmessage.substring(0, localmessage.indexOf("\n"));
			hash.put("ERRORMESSAGE", localmessage);
			hash.put("ERRORSQL", errorsql);
			System.out.println("ERRORMESSAGE=" + localmessage);
		}
		catch(Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			hash.put("SUCCESS", "false");
		}

		return hash;
	}

	/**
	 * 삭제 스크립트 실행
	 *
	 * @number 삭제 스크립트 저장파일 순번
	 * @title 삭제 스크립트 명
	 * @test
	 * @all 삭제 스크립트 모두 수행 후 commit 여부
	 */
	// public Hashtable eraserexecute(String number, String title, String test,
	// String all, String comment)
	@Override
	public Hashtable eraserexecute(Hashtable hashinput)
	{

		String						number		= (String) hashinput.get("NUMBER");
		String						title		= (String) hashinput.get("TITLE");
		String						test		= (String) hashinput.get("TEST");
		String						all			= (String) hashinput.get("ALL");
		String						comment		= (String) hashinput.get("COMMENT");

		String						depart		= (String) hashinput.get("DEPART");
		String						grade		= (String) hashinput.get("GRADE");
		String						name		= (String) hashinput.get("NAME");		// 실행자
		String						present		= (String) hashinput.get("PRESENT");	// 입회자

		Hashtable<String, String>	hash		= new Hashtable<String, String>();
		String						errorsql	= "";

		try
		{
			Connection		connection			= null;
			Statement		statement			= null;
			ResultSet		resultSet			= null;

			String			driverNameOracle	= "oracle.jdbc.driver.OracleDriver";
			String			driverNameCubrid	= "cubrid.jdbc.driver.CUBRIDDriver";
			String			driverNameTibero	= "com.tmax.tibero.jdbc.TbDriver";
			String			driverNameMysql		= "com.mysql.cj.jdbc.Driver";
			String			driverNameMssql		= "com.microsoft.sqlserver.jdbc.SQLServerDriver";

			String			dbsystem			= "";
			String			url					= "";
			String			user				= "";
			String			password			= "";

			int				resultValue			= 0;

			// ClassPathResource resource = new
			// ClassPathResource("config/db.properties");
			/* 20200703] 최창근 경로수정 */
//			File			dbconfigfile		= new File("./config/db.properties");
			File			dbconfigfile		= new File(Constants.DB_PROPERTIES_PATH);

			FileInputStream	fis					= new FileInputStream(dbconfigfile);

			Properties		dbpropert			= new Properties();

			dbpropert.load(fis);

			if(dbpropert.getProperty("dbsystem") != null)
			{
				dbsystem = dbpropert.getProperty("dbsystem");
			}

			if(dbpropert.getProperty("user") != null)
			{
				user = dbpropert.getProperty("user");
			}

			if(dbpropert.getProperty("pw") != null)
			{
				password = dbpropert.getProperty("pw");
			}

			if(dbpropert.getProperty("jdbc") != null)
			{
				url = dbpropert.getProperty("jdbc");
			}

			System.out.println("dbsystem=" + dbsystem);
			System.out.println("user=" + user);
			System.out.println("pw=" + password);
			System.out.println("jdbc=" + url);

			if(dbsystem.equals("oracle"))
			{
				Class.forName(driverNameOracle);
			}
			else if(dbsystem.equals("cubrid"))
			{
				Class.forName(driverNameCubrid);
			}
			else if(dbsystem.equals("tibero"))
			{
				Class.forName(driverNameTibero);
			}
			else if(dbsystem.equals("mysql"))
			{
				Class.forName(driverNameMysql);
			}
			else if(dbsystem.equals("mssql"))
			{
				Class.forName(driverNameMssql);
			}

			// 기존 파일이 있는지 조회한다.
			File				file_eraser_sql	= new File(data_dir + "/file_eraser_sql_" + number + ".txt");

			RandomAccessFile	randomfile_sql	= new RandomAccessFile(file_eraser_sql, "r");

			String				sql				= "";
			String				sql_temp		= "";
			int					count			= 0;
			while((sql_temp = randomfile_sql.readLine()) != null)
			{
				byte ptext[] = sql_temp.getBytes("ISO-8859-1");
				sql_temp = new String(ptext, "UTF-8");
				// System.out.println("sql_temp=" + sql_temp);

				if(count > 0)
				{
					sql += "\n" + sql_temp;
				}
				else
				{
					sql += sql_temp;
				}

				count++;
			}

			connection = DriverManager.getConnection(url, user, password);

			// System.out.println("test=" + test);
			// //테스트박스가 체크되면 롤백한다.
			// if(test.equals("true"))
			// {
			// connection.setAutoCommit(false);
			// }
			// else
			// {
			// connection.setAutoCommit(true);
			// }

			// 커밋선택을 하기 위해서
			// sql 하나씩 커밋 아니면 전부 실행하고 커밋
			connection.setAutoCommit(false);

			System.out.println("SQL:" + sql);

			statement = connection.createStatement();

			// 2개 이상의 문장이 있으면 반복해서 실행한다.
			if(sql.indexOf(";") > 0)
			{
				String sql_split[] = sql.split(";");

				for(int ix = 0; ix < sql_split.length; ix++)
				{
					// 여러개의 sql문 실행
					sql_split[ix] = sql_split[ix].trim();
					System.out.println("SQL ONE:" + sql_split[ix]);

					if(sql_split[ix].trim().length() > 0)
					{
						errorsql	= sql_split[ix];
						resultValue	+= statement.executeUpdate(sql_split[ix]);

						if(all.equals("false"))
						{
							connection.commit();
						}
					}
				}
			}
			else
			{
				errorsql	= sql;
				resultValue	= statement.executeUpdate(sql);
			}

			if(all.equals("true"))
			{
				connection.commit();
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

			// this.eraserhistorysave(number, title, resultValue, sql, comment);

			Hashtable hash_history = new Hashtable();

			hash_history.put("NUMBER", number);
			hash_history.put("TITLE", title);
			hash_history.put("COUNT", String.valueOf(resultValue));
			hash_history.put("SQL", sql);
			hash_history.put("COMMENT", comment);
			hash_history.put("DEPART", depart);
			hash_history.put("GRADE", grade);
			hash_history.put("NAME", name);
			hash_history.put("PRESENT", present);

			String sqltime = this.eraserhistorysave(hash_history);

			hash.put("SQLTIME", sqltime);

			// //테스트박스가 체크되면 롤백한다.
			// if(test.equals("true"))
			// {
			// connection.rollback();
			// }
			// else
			// {
			// //삭제 스크립트 이력 저장
			// //삭제후 커밋이 되면
			// this.eraserhistorysave(number, title, resultValue, sql);
			// }

			hash.put("COUNT", String.valueOf(resultValue));
			hash.put("SUCCESS", "true");
		}
		catch(FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			hash.put("SUCCESS", "false");
		}
		catch(IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			hash.put("SUCCESS", "false");
		}
		catch(SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();

			hash.put("SUCCESS", "false");
			hash.put("ERRORCODE", String.valueOf(e.getErrorCode()));

			String localmessage = e.getLocalizedMessage();

			localmessage = localmessage.substring(0, localmessage.indexOf("\n"));
			hash.put("ERRORMESSAGE", localmessage);
			hash.put("ERRORSQL", errorsql);
			System.out.println("ERRORMESSAGE=" + localmessage);
		}
		catch(Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			hash.put("SUCCESS", "false");
		}

		return hash;
	}

	/**
	 * 삭제스크립트 실행이력 조회
	 */
	@Override
	public Vector historyview()
	{
		Vector v = new Vector();

		try
		{
			// 기존 파일이 있는지 조회한다.
			File file_eraser_history = new File(data_dir + "/file_eraser_history.txt");

			// 이력 파일이 없으면 나간다.
			if(file_eraser_history.exists() == false)
			{
				return v;
			}

			RandomAccessFile	randomfile_history	= new RandomAccessFile(file_eraser_history, "r");
			String				str_history			= null;

			while((str_history = randomfile_history.readLine()) != null)
			{
				byte ptext[] = str_history.getBytes("ISO-8859-1");
				str_history = new String(ptext, "UTF-8");

				String	number			= "";
				String	title			= "";
				String	date			= "";
				String	delete_count	= "";
				String	depart			= "";
				String	grade			= "";
				String	name			= "";
				String	present			= "";

				String	history_item[]	= str_history.split("\\|");

				number			= history_item[0];
				title			= history_item[1];
				date			= history_item[2];
				delete_count	= history_item[3];
				depart			= history_item[4];
				grade			= history_item[5];
				name			= history_item[6];

				if(history_item.length > 7)
				{
					present = history_item[7];
				}

				Hashtable<String, String> hash = new Hashtable<String, String>();

				hash.put("NUMBER", number);
				hash.put("TITLE", title);
				hash.put("DATE", date);
				hash.put("COUNT", delete_count);
				hash.put("DEPART", depart);
				hash.put("GRADE", grade);
				hash.put("NAME", name);
				hash.put("PRESENT", present);

				v.add(hash);
			}

			randomfile_history.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return v;
	}

	private String nullToSpace(String str)
	{
		if(str == null)
		{
			return "";
		}

		return str;
	}

	/**
	 * 삭제스크립트 실행이력 저장
	 */
	private boolean eraserhistorysave(String number, String title, int count, String sql, String comment)
	{
		boolean is_success = true;

		try
		{
			// 기존파일을 삭제한다.
			File file_eraser_history = new File(data_dir + "/file_eraser_history.txt");

			if(file_eraser_history.exists() == false)
			{
				file_eraser_history.createNewFile();
			}

			RandomAccessFile rndhistory = new RandomAccessFile(file_eraser_history, "rw");

			if(rndhistory.length() > 0)
			{
				rndhistory.seek(rndhistory.length() - 1);
			}
			else
			{
				rndhistory.seek(0);
			}

			Date				date		= new Date();
			SimpleDateFormat	formatter	= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			// 삭제스크립트 번호,타이블,실행날짜,삭제건수
			String				str_history	= number + "|" + title + "|" + formatter.format(date) + "|" + count
			        + "\r\n";

			System.out.println("str_history=" + str_history);
			rndhistory.write(str_history.getBytes());
			rndhistory.close();

			SimpleDateFormat	formatter_sql		= new SimpleDateFormat("yyyyMMdd_HHmmss");

			// 실행 sql문을 저장한다. 시작
			// 실행 sql문을 저장한다. 시작
			// 실행 sql문을 저장한다. 시작
			String				history_sql_name	= data_dir + "/file_eraser_history_sql_"
			        + formatter_sql.format(date) + ".txt";
			System.out.println("history_sql_name=" + history_sql_name);
			File file_history_sql = new File(history_sql_name);

			if(file_history_sql.exists() == false)
			{
				file_history_sql.createNewFile();
			}

			RandomAccessFile rndhistory_sql = new RandomAccessFile(file_history_sql, "rw");

			if(rndhistory_sql.length() > 0)
			{
				rndhistory_sql.seek(rndhistory_sql.length() - 1);
			}
			else
			{
				rndhistory_sql.seek(0);
			}
			rndhistory_sql.write(sql.getBytes());
			rndhistory_sql.close();
			// 실행 sql문을 저장한다. 끝
			// 실행 sql문을 저장한다. 끝
			// 실행 sql문을 저장한다. 끝

			// 평가의견을 저장한다. 시작
			// 평가의견을 저장한다. 시작
			// 평가의견을 저장한다. 시작
			String history_commnet_name = data_dir + "/file_eraser_history_comment_" + formatter_sql.format(date)
			        + ".txt";
			System.out.println("history_sql_name=" + history_commnet_name);
			File file_history_comment = new File(history_commnet_name);

			if(file_history_comment.exists() == false)
			{
				file_history_comment.createNewFile();
			}

			RandomAccessFile rndhistory_comment = new RandomAccessFile(file_history_comment, "rw");

			if(rndhistory_comment.length() > 0)
			{
				rndhistory_comment.seek(rndhistory_comment.length() - 1);
			}
			else
			{
				rndhistory_comment.seek(0);
			}
			rndhistory_comment.write(comment.getBytes());
			rndhistory_comment.close();
			// 평가의견을 저장한다. 끝
			// 평가의견을 저장한다. 끝
			// 평가의견을 저장한다. 끝

		}
		catch(Exception e)
		{
			is_success = false;
			e.printStackTrace();
		}

		return is_success;
	}

	/**
	 * 삭제스크립트 실행이력 저장
	 */
	// private boolean eraserhistorysave(String number, String title, int count,
	// String sql, String comment)
	private String eraserhistorysave(Hashtable hash)
	{
		String	number		= (String) hash.get("NUMBER");
		String	title		= (String) hash.get("TITLE");
		String	count		= (String) hash.get("COUNT");
		String	sql			= (String) hash.get("SQL");
		String	comment		= (String) hash.get("COMMENT");
		String	depart		= (String) hash.get("DEPART");
		String	grade		= (String) hash.get("GRADE");
		String	name		= (String) hash.get("NAME");
		String	present		= (String) hash.get("PRESENT");

		String  result_sqltime = "";

		boolean	is_success	= true;

		try
		{
			// 기존파일을 삭제한다.
			File file_eraser_history = new File(data_dir + "/file_eraser_history.txt");

			if(file_eraser_history.exists() == false)
			{
				file_eraser_history.createNewFile();
			}

			RandomAccessFile rndhistory = new RandomAccessFile(file_eraser_history, "rw");

			if(rndhistory.length() > 0)
			{
				rndhistory.seek(rndhistory.length() - 1);
			}
			else
			{
				rndhistory.seek(0);
			}

			Date				date		= new Date();
			SimpleDateFormat	formatter	= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			// 삭제스크립트 번호,타이블,실행날짜,삭제건수
			String				str_history	= number + "|" + title + "|" + formatter.format(date) + "|" + count + "|"
			        + depart + "|" + grade + "|" + name + "|" + present + "\r\n";

			System.out.println("str_history=" + str_history);
			rndhistory.write(str_history.getBytes());
			rndhistory.close();

			SimpleDateFormat	formatter_sql		= new SimpleDateFormat("yyyyMMdd_HHmmss");

			// 실행 sql문을 저장한다. 시작
			// 실행 sql문을 저장한다. 시작
			// 실행 sql문을 저장한다. 시작
			String				history_sql_name	= data_dir + "/file_eraser_history_sql_"
			        + formatter_sql.format(date) + ".txt";
			System.out.println("history_sql_name=" + history_sql_name);
			File file_history_sql = new File(history_sql_name);

			if(file_history_sql.exists() == false)
			{
				file_history_sql.createNewFile();
			}

			RandomAccessFile rndhistory_sql = new RandomAccessFile(file_history_sql, "rw");

			if(rndhistory_sql.length() > 0)
			{
				rndhistory_sql.seek(rndhistory_sql.length() - 1);
			}
			else
			{
				rndhistory_sql.seek(0);
			}

			rndhistory_sql.write(sql.getBytes());
			rndhistory_sql.close();
			// 실행 sql문을 저장한다. 끝
			// 실행 sql문을 저장한다. 끝
			// 실행 sql문을 저장한다. 끝

			// 평가의견을 저장한다. 시작
			// 평가의견을 저장한다. 시작
			// 평가의견을 저장한다. 시작
			String	history_commnet_name	= data_dir + "/file_eraser_history_comment_" + formatter_sql.format(date)
			        + ".txt";

			File	file_history_comment	= new File(history_commnet_name);

			if(file_history_comment.exists() == false)
			{
				file_history_comment.createNewFile();
			}

			RandomAccessFile rndhistory_comment = new RandomAccessFile(file_history_comment, "rw");

			if(rndhistory_comment.length() > 0)
			{
				rndhistory_comment.seek(rndhistory_comment.length() - 1);
			}
			else
			{
				rndhistory_comment.seek(0);
			}
			rndhistory_comment.write(comment.getBytes());
			rndhistory_comment.close();
			// 평가의견을 저장한다. 끝
			// 평가의견을 저장한다. 끝
			// 평가의견을 저장한다. 끝

			result_sqltime = formatter.format(date);

		}
		catch(Exception e)
		{
			is_success = false;
			e.printStackTrace();
		}

		return result_sqltime;
	}

	@Override
	public boolean managersave(String depart, String grade, String name, String password)
	{
		boolean is_success = true;
		try
		{
			String encpasswrod = "";

			encpasswrod = this.encrypt(password);
			// ClassPathResource resource = new
			// ClassPathResource("config/db.properties");

			/* 20200703] 최창근 경로수정 */
//			File				managerfile	= new File("./config/manager.properties");
			File			managerfile		= new File(Constants.MESSAGE_PROPERTIES_PATH);


			FileOutputStream	fos			= new FileOutputStream(managerfile);

			Properties			managerprpt	= new Properties();

			managerprpt.setProperty("depart", depart);
			managerprpt.setProperty("grade", grade);
			managerprpt.setProperty("name", name);
			managerprpt.setProperty("password", encpasswrod);

			// System.out.println("depart=" + depart);
			// System.out.println("grade=" + grade);
			// System.out.println("name=" + name);
			// System.out.println("password=" + password);

			managerprpt.store(fos, "this is manager config item");

			fos.close();

		}
		catch(Exception e)
		{
			is_success = false;
			e.printStackTrace();
		}

		return is_success;
	}

	/**
	 * DBMS 접속정보 조회
	 */
	@Override
	public Hashtable managerview()
	{
		Hashtable<String, String> hash = new Hashtable<String, String>();
		try
		{
			// ClassPathResource resource = new
			// ClassPathResource("config/db.properties");

			/* 20200703] 최창근 경로수정 */
//			File				managerfile	= new File("./config/manager.properties");
			File			dbconfigfile		= new File(Constants.MESSAGE_PROPERTIES_PATH);


			FileInputStream	fis				= new FileInputStream(dbconfigfile);

			Properties		managerprpt		= new Properties();

			managerprpt.load(fis);

			if(managerprpt.getProperty("depart") != null)
			{
				hash.put("depart", managerprpt.getProperty("depart"));
			}

			if(managerprpt.getProperty("grade") != null)
			{
				hash.put("grade", managerprpt.getProperty("grade"));
			}

			if(managerprpt.getProperty("name") != null)
			{
				hash.put("name", managerprpt.getProperty("name"));
			}

			if(managerprpt.getProperty("password") != null)
			{
				hash.put("password", this.decrypt(managerprpt.getProperty("password")));
			}

			fis.close();

		}
		catch(Exception e)
		{

			e.printStackTrace();
		}

		return hash;
	}

	public String encrypt(String planText)
	{

		return encoder.encode(planText.getBytes());

	}

	public String decrypt(String encryptText) throws IOException
	{

		return new String(decoder.decodeBuffer(encryptText));

	}

	@Override
	public String commentview(String datetime)
	{
		String comment_history = "";

		try
		{
			String				comment_file_name		= "file_eraser_history_comment_" + datetime + ".txt";

			File				file_history_comment	= new File(data_dir + "/" + comment_file_name);
			RandomAccessFile	ranfile_comment			= new RandomAccessFile(file_history_comment, "r");

			String				line					= "";

			int					count					= 0;
			while((line = ranfile_comment.readLine()) != null)
			{
				byte ptext[] = line.getBytes("ISO-8859-1");
				line = new String(ptext, "UTF-8");
				System.out.println("desc_temp=" + line);

				if(count > 0)
				{
					comment_history += "\n" + line;
				}
				else
				{
					comment_history += line;
				}

				count++;
			}

			ranfile_comment.close();
		}
		catch(FileNotFoundException fnfe)
		{
			JOptionPane.showMessageDialog(null, "파일이 없습니다.");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return comment_history;
	}

	@Override
	public String historysqlview(String sql_time)
	{
		String sql_history = "";

		try
		{
			String				sql_file_name		= "file_eraser_history_sql_" + sql_time + ".txt";

			File				file_history_sql	= new File(data_dir + "/" + sql_file_name);
			RandomAccessFile	ranfile_sql			= new RandomAccessFile(file_history_sql, "r");

			String				line				= "";

			int					count				= 0;
			while((line = ranfile_sql.readLine()) != null)
			{
				byte ptext[] = line.getBytes("ISO-8859-1");
				line = new String(ptext, "UTF-8");
				System.out.println("desc_temp=" + line);

				if(count > 0)
				{
					sql_history += "\n" + line;
				}
				else
				{
					sql_history += line;
				}

				count++;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return sql_history;
	}

}