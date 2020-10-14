package com.firstinfo.eraser.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
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
 * 처분 스크립트 등록화면
 *
 * @author 국가기록원
 *
 */
@SuppressWarnings("serial")
public class EraserCreate extends JPanel
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

	JButton btn_create = new JButton("저장");

	JTextField text_title = new JTextField();
	JTextField text_date = new JTextField();

	JDateChooser date_picker = new JDateChooser();
	JTextFieldDateEditor editor = null;

	JTextArea area_desc = new JTextArea();
	JTextArea area_sql = new JTextArea();

	EraserCreate()
	{
		BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);

		JLabel label = new JLabel("스크립트 등록 화면입니다.");
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

		text_title.setFont(new Font(text_title.getFont().getName(), Font.PLAIN, 12));
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

		// calendar.setFont(new Font(calendar.getFont().getName(), Font.PLAIN, 10));

		label_y_position += label_height + line_interval;
		input_y_position += input_height + line_interval;

		panel_content.add(label_date);
		// panel_content.add(text_date);
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

		btn_create.setBounds(input_x_position - 1, input_y_position, 120, input_height);
		panel_content.add(btn_create);

		this.setLayout(layout);
		this.setOpaque(true);
		this.setBackground(Color.darkGray);
		this.add(Box.createRigidArea(new Dimension(0, 10)));
		this.add(label);
		this.add(Box.createRigidArea(new Dimension(0, 10)));
		this.add(panel_content);

		btn_create.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("actionPerformed");
				EraserService service = new EraserServiceImpl();
				String filename = service.erasercreate(text_title.getText(), editor.getText(),
					area_desc.getText(), area_sql.getText());

				JOptionPane.showMessageDialog(null, filename + " 파일이 저장되었습니다.");

			}
		});
	}

	public void refresh()
	{
		text_title.setText("");
		date_picker.setDate(new Date());
		area_desc.setText("");
		area_sql.setText("");
	}
}
