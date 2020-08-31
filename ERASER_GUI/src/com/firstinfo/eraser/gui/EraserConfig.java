package com.firstinfo.eraser.gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Hashtable;
import java.util.Properties;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.firstinfo.eraser.config.Constants;
import com.firstinfo.eraser.service.EraserService;
import com.firstinfo.eraser.serviceimpl.EraserServiceImpl;

/**
 * DBMS 접속정보 등록화면
 *
 * @author 국가기록원
 *
 */
public class EraserConfig extends JPanel
{
	private int	label_x				= 30;
	private int	label_x_position	= label_x;
	private int	label_y_position	= 10;
	private int	label_width			= 210;
	private int	label_height		= 25;

	private int	input_x				= 300;
	private int	input_x_position	= input_x;
	private int	input_y_position	= 10;
	private int	input_width			= 300;
	private int	input_height		= 25;

	private int	line_interval		= 5;

	JButton		btn_save			= new JButton("저장");
	JButton		btn_test			= new JButton("접속테스트");
	JLabel		label_test			= new JLabel("(접속 테스트를 하기전에 저장해 주세요.)");

	String		db_name[]			= { "오라클", "큐브리드", "티베로", "MySQL", "MS-SQL" };
	String		db_value[]			= { "oracle", "cubrid", "tibero", "mysql", "mssql" };

	JComboBox	combo_db			= new JComboBox(db_name);
	JTextField	text_ip				= new JTextField();
	JTextField	text_sid			= new JTextField();
	JTextField	text_user			= new JTextField();
	JTextField	text_pw				= new JTextField();
	JTextField	text_jdbc			= new JTextField();

	EraserConfig()
	{
		BoxLayout	layout	= new BoxLayout(this, BoxLayout.Y_AXIS);
		JLabel		label	= new JLabel("DB 접속 설정");
		label.setFont(new Font(label.getFont().getName(), Font.PLAIN, 12));
		label.setAlignmentX(Component.CENTER_ALIGNMENT);

		JPanel panel_content = new JPanel();

		panel_content.setLayout(null);

		JLabel	label_db	= new JLabel("Data Base System");
		JLabel	label_ip	= new JLabel("서버주소(IP)");
		JLabel	label_sid	= new JLabel("데이터베이스(SID, Service Name)");
		JLabel	label_user	= new JLabel("사용자 계정");
		JLabel	label_pw	= new JLabel("암호");
		JLabel	label_jdbc	= new JLabel("JDBC");

		label_db.setFont(new Font("돋움체", Font.PLAIN, 12));
		label_ip.setFont(new Font("돋움체", Font.PLAIN, 12));
		label_sid.setFont(new Font("돋움체", Font.PLAIN, 12));
		label_user.setFont(new Font("돋움체", Font.PLAIN, 12));
		label_pw.setFont(new Font("돋움체", Font.PLAIN, 12));
		label_jdbc.setFont(new Font("돋움체", Font.PLAIN, 12));

		label_db.setBounds(label_x_position, label_y_position, label_width, label_height);
		combo_db.setBounds(input_x_position, input_y_position, input_width, input_height);
		label_y_position	+= label_height + line_interval;
		input_y_position	+= input_height + line_interval;
		panel_content.add(label_db);
		panel_content.add(combo_db);

		label_ip.setBounds(label_x_position, label_y_position, label_width, label_height);
		text_ip.setBounds(input_x_position, input_y_position, input_width, input_height);
		label_y_position	+= label_height + line_interval;
		input_y_position	+= input_height + line_interval;
		panel_content.add(label_ip);
		panel_content.add(text_ip);

		label_sid.setBounds(label_x_position, label_y_position, label_width, label_height);
		text_sid.setBounds(input_x_position, input_y_position, input_width, input_height);
		label_y_position	+= label_height + line_interval;
		input_y_position	+= input_height + line_interval;
		panel_content.add(label_sid);
		panel_content.add(text_sid);

		label_user.setBounds(label_x_position, label_y_position, label_width, label_height);
		text_user.setBounds(input_x_position, input_y_position, input_width, input_height);
		label_y_position	+= label_height + line_interval;
		input_y_position	+= input_height + line_interval;
		panel_content.add(label_user);
		panel_content.add(text_user);

		label_pw.setBounds(label_x_position, label_y_position, label_width, label_height);
		text_pw.setBounds(input_x_position, input_y_position, input_width, input_height);
		label_y_position	+= label_height + line_interval;
		input_y_position	+= input_height + line_interval;
		panel_content.add(label_pw);
		panel_content.add(text_pw);

		label_jdbc.setBounds(label_x_position, label_y_position, label_width, label_height);
		text_jdbc.setBounds(input_x_position, input_y_position, input_width, input_height);
		label_y_position	+= label_height + line_interval;
		input_y_position	+= input_height + line_interval;
		panel_content.add(label_jdbc);
		panel_content.add(text_jdbc);

		btn_save.setBounds(input_x_position, input_y_position, 80, 20);
		btn_test.setBounds(input_x_position + 80 + 5, input_y_position, 120, 20);
		label_y_position	+= label_height + line_interval;
		input_y_position	+= input_height + line_interval;
		panel_content.add(btn_save);
		panel_content.add(btn_test);

		label_test.setBounds(input_x_position, input_y_position, 300, 20);
		panel_content.add(label_test);

		this.setLayout(layout);

		this.add(Box.createRigidArea(new Dimension(5, 20)));
		this.add(label);
		this.add(Box.createRigidArea(new Dimension(5, 10)));
		this.add(panel_content);

		// db config 저장
		btn_save.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				EraserService	service		= new EraserServiceImpl();
				boolean			is_success	= service.dbconfigsave(db_value[combo_db.getSelectedIndex()], text_ip.getText(), text_sid.getText(), text_user.getText(), text_pw.getText(), text_jdbc.getText());

				JOptionPane.showMessageDialog(null, "DB 설정이 수정되었습니다.");

			}
		});

		btn_test.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				boolean is_success = ConnectionTest();

				if(is_success == true)
				{
					JOptionPane.showMessageDialog(null, "접속 테스트 성공");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "접속 테스트 실패");
				}
			}
		});
	}

	public void view()
	{
		EraserService	service		= new EraserServiceImpl();
		Hashtable		hash		= service.dbconfigview();

		String			dbsystem	= null;
		String			address		= null;
		String			sid			= null;
		String			user		= null;
		String			pw			= null;
		String			jdbc		= null;

		dbsystem	= (String) hash.get("dbsystem");
		address		= (String) hash.get("address");
		sid			= (String) hash.get("sid");
		user		= (String) hash.get("user");
		pw			= (String) hash.get("pw");
		jdbc		= (String) hash.get("jdbc");

		if(dbsystem != null)
		{
			if(dbsystem.equals("oracle"))
			{
				combo_db.setSelectedIndex(0);
			}
			else if(dbsystem.equals("cubrid"))
			{
				combo_db.setSelectedIndex(1);
			}
			else if(dbsystem.equals("tibero"))
			{
				combo_db.setSelectedIndex(2);
			}
			else if(dbsystem.equals("mysql"))
			{
				combo_db.setSelectedIndex(3);
			}
			else if(dbsystem.equals("mssql"))
			{
				combo_db.setSelectedIndex(4);
			}
		}

		if(address == null)
		{
			address = "";
		}
		if(sid == null)
		{
			sid = "";
		}
		if(user == null)
		{
			user = "";
		}
		if(pw == null)
		{
			pw = "";
		}
		if(jdbc == null)
		{
			jdbc = "";
		}

		text_ip.setText(address);
		text_sid.setText(sid);
		text_user.setText(user);
		text_pw.setText(pw);
		text_jdbc.setText(jdbc);

	}

	public boolean ConnectionTest()
	{
		boolean is_success = true;
		try
		{
			Connection		connection			= null;
			Statement		statement			= null;
			ResultSet		resultset			= null;
			String			sql					= "";

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
				sql = "SELECT 1 FROM DUAL";
			}
			else if(dbsystem.equals("cubrid"))
			{
				Class.forName(driverNameCubrid);
				sql = "SELECT 1 FROM DB_ROOT";
			}
			else if(dbsystem.equals("tibero"))
			{
				Class.forName(driverNameTibero);
			}
			else if(dbsystem.equals("mysql"))
			{
				Class.forName(driverNameMysql);
				sql = "SELECT 1 FROM DUAL";
			}
			else if(dbsystem.equals("mssql"))
			{
				Class.forName(driverNameMssql);
				sql = "SELECT 1 AS A";
			}

			DriverManager.setLoginTimeout(3);
			connection	= DriverManager.getConnection(url, user, password);

			statement	= connection.createStatement();
			statement.setQueryTimeout(3);
			resultset = statement.executeQuery(sql);

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
		catch(Exception e)
		{
			is_success = false;
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}

		return is_success;
	}
}
