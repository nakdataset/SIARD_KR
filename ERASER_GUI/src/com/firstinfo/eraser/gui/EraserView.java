package com.firstinfo.eraser.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Hashtable;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.firstinfo.eraser.service.EraserService;
import com.firstinfo.eraser.serviceimpl.EraserServiceImpl;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

/**
 * 삭제 스크립트 상세조회 및 수정/실행 이벤트 작성
 *
 * @author 국가기록원
 *
 */
@SuppressWarnings("serial")
public class EraserView extends JPanel
{
	private int label_x = 30;
	private int label_x_position = label_x;
	private int label_y_position = 30;
	private int label_width = 80;
	private int label_height = 25;

	private int input_x = 120;
	private int input_x_position = input_x;
	private int input_y_position = 30;
	private int input_width = 600;
	private int input_height = 25;

	private int input_area_height = 100;
	private int line_interval = 5;

	JButton btn_change = new JButton("수정");
	JButton btn_comment = new JButton("심의결과 입력후 실행");
	JButton btn_report = new JButton("보고서");

	JTextField text_title = new JTextField();
	JTextField text_date = new JTextField();

	JDateChooser date_picker = new JDateChooser();
	JTextFieldDateEditor editor = null;

	JTextArea area_desc = new JTextArea();
	JTextArea area_sql = new JTextArea();

	JCheckBox checkbox_test = new JCheckBox("테스트(체크되어 있으면 삭제가 되지 않습니다.)");
	JCheckBox checkbox_all = new JCheckBox("한번 커밋(체크되어 있으면 모든 SQL실행후에 커밋됩니다)");

	String number = null;

	Object panelme = null;

	EraserGui gui = null;

	String sqltime = "";

	EraserView(EraserGui e)
	{
		this.gui = e;
		panelme = this;
		BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);

		JLabel label = new JLabel("스크립트 상세 화면입니다.");
		label.setFont(new Font(label.getFont().getName(), Font.PLAIN, 12));
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		label.setForeground(Color.WHITE);

		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		input_width = (int)(dimension.getWidth() / 2) - (30 * 2) - (label_width + 20) - 52;

		JPanel panel_content = new JPanel();
		panel_content.setLayout(null);

		JLabel label_title = new JLabel("제목");
		JLabel label_date = new JLabel("날짜");
		JLabel label_desc = new JLabel("설명");
		JLabel label_sql = new JLabel("SQL");

		area_desc.setFont(new Font(area_desc.getFont().getName(), Font.PLAIN, 12));
		area_sql.setFont(new Font(area_sql.getFont().getName(), Font.PLAIN, 12));

		JScrollPane scroll_desc = new JScrollPane(area_desc);
		JScrollPane scroll_sql = new JScrollPane(area_sql);

		label_title.setBounds(label_x_position, label_y_position, label_width, label_height);
		text_title.setBounds(input_x_position, input_y_position, input_width, input_height);
		label_y_position += label_height + line_interval;
		input_y_position += input_height + line_interval;
		panel_content.add(label_title);
		panel_content.add(text_title);

		label_date.setBounds(label_x_position, label_y_position, label_width, label_height);
		text_date.setBounds(input_x_position, input_y_position, input_width, input_height);

		editor = (JTextFieldDateEditor) date_picker.getDateEditor();
		editor.setEditable(false);
		date_picker.setDateFormatString("yyyy-MM-dd");
		date_picker.setBounds(input_x_position, input_y_position, 120, input_height);

		label_y_position += label_height + line_interval;
		input_y_position += input_height + line_interval;
		panel_content.add(label_date);
		panel_content.add(date_picker);

		label_desc.setBounds(label_x_position, label_y_position, label_width, label_height);
		scroll_desc.setBounds(input_x_position, input_y_position, input_width, input_area_height);
		label_y_position += input_area_height + line_interval;
		input_y_position += input_area_height + line_interval;
		panel_content.add(label_desc);
		panel_content.add(scroll_desc);

		label_sql.setBounds(label_x_position, label_y_position, label_width, label_height);
		scroll_sql.setBounds(input_x_position, input_y_position, input_width, input_area_height + 100);
		label_y_position += input_area_height + line_interval;
		input_y_position += input_area_height + line_interval + 100;
		panel_content.add(label_sql);
		panel_content.add(scroll_sql);

		// checkbox_test.setBounds(input_x_position, input_y_position, input_width, input_height);
		//
		// panel_content.add(checkbox_test);
		//
		// label_y_position += input_height + line_interval;
		// input_y_position += input_height + line_interval;

		checkbox_all.setBounds(input_x_position, input_y_position, input_width, input_height);

		panel_content.add(checkbox_all);

		label_y_position += input_height + line_interval;
		input_y_position += input_height + line_interval;

		btn_change.setBounds(input_x_position, input_y_position, 120, input_height);
		btn_comment.setBounds(input_x_position + 120 + 5, input_y_position, 190, input_height);
		btn_report.setBounds(input_x_position + 120 + 5 + 190 + 5, input_y_position, 100, input_height);

		btn_report.setEnabled(false);

		panel_content.add(btn_change);
		panel_content.add(btn_comment);
		panel_content.add(btn_report);

		this.setLayout(layout);

		this.setOpaque(true);
		this.setBackground(Color.darkGray);
		this.add(Box.createRigidArea(new Dimension(0, 10)));
		this.add(label);
		this.add(Box.createRigidArea(new Dimension(0, 10)));
		this.add(panel_content);

		btn_change.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				EraserService service = new EraserServiceImpl();
				boolean is_success = service.eraserchange(number, text_title.getText(), editor.getText(), area_desc.getText(), area_sql.getText());
				JOptionPane.showMessageDialog(null, number + " 번이 수정되었습니다.");
			}
		});

		btn_comment.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String check_test = "";

				if (checkbox_test.isSelected() == true) {
					check_test = "true";
				} else {
					check_test = "false";
				}

				String check_all = "";

				if (checkbox_all.isSelected() == true) {
					check_all = "true";
				} else {
					check_all = "false";
				}

				Hashtable hash = new Hashtable();
				hash.put("NUMBER", number);
				hash.put("TITLE", text_title.getText());
				hash.put("CHECKTEST", check_test);
				hash.put("CHECKALL", check_all);

				// JFrame topFrame = (JFrame) SwingUtilities.windowForComponent((JPanel) panelme);
				EraserComment comment = new EraserComment(gui, true, hash);
			}
		});

		btn_report.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				EraserReport report = new EraserReport(gui, sqltime);
			}
		});
	}

	// public void delete()
	// {
	// EraserService service = new EraserServiceImpl();
	//
	// String check_test = "";
	//
	// if(checkbox_test.isSelected() == true)
	// {
	// check_test = "true";
	// }
	// else
	// {
	// check_test = "false";
	// }
	//
	// String check_all = "";
	//
	// if(checkbox_all.isSelected() == true)
	// {
	// check_all = "true";
	// }
	// else
	// {
	// check_all = "false";
	// }
	//
	// Hashtable hash = service.eraserexecute(number, text_title.getText(), check_test, check_all);
	//
	// String count = (String)hash.get("COUNT");
	// String success = (String)hash.get("SUCCESS");
	//
	// if(success != null)
	// {
	// if(success.equals("true"))
	// {
	// JOptionPane.showMessageDialog(null, count + "건 삭제되었습니다.");
	// }
	// else if(success.equals("false"))
	// {
	// String error_code = (String)hash.get("ERRORCODE");
	// String error_message = (String)hash.get("ERRORMESSAGE");
	// String error_sql = (String)hash.get("ERRORSQL");
	//
	// String message = "에러코드:" + error_code + "\n"
	// + "에러메시지:" + error_message + "\n"
	// + "SQL :" + error_sql;
	//
	// JOptionPane.showMessageDialog(null, message);
	// }
	// }
	// }

	public void setReportButtonEnabled(boolean b)
	{
		btn_report.setEnabled(b);
	}

	public void setNumber(String str)
	{
		this.number = str;
	}

	public void viewrefesh(String str_number)
	{
		this.number = str_number;
		EraserService service = new EraserServiceImpl();
		Hashtable hash = service.eraserview(this.number);

		String title = (String) hash.get("TITLE");
		String date = (String) hash.get("DATE");
		String desc = (String) hash.get("DESC");
		String sql = (String) hash.get("SQL");

		text_title.setText(title);
		String year = null;
		String month = null;
		String day = null;
		// 2006-09-10
		if (date.length() >= 10) {
			year = date.substring(0, 4);
			month = date.substring(5, 7);
			day = date.substring(8);
		} else {
			year = "1900";
			month = "01";
			day = "01";
		}

		Calendar get_date = Calendar.getInstance();
		get_date.set(Integer.parseInt(year), Integer.parseInt(month) - 1, Integer.parseInt(day));
		date_picker.setCalendar(get_date);

		text_date.setText(date);
		area_desc.setText(desc);
		area_sql.setText(sql);
	}

	public void setSqlTime(String str)
	{
		this.sqltime = str;
	}
}
