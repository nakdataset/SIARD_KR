package com.firstinfo.eraser.gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.firstinfo.eraser.service.EraserService;
import com.firstinfo.eraser.serviceimpl.EraserServiceImpl;

/**
 * DBMS 접속정보 등록화면
 * 
 * @author 국가기록원
 *
 */
public class EraserManager extends JPanel
{
	private int		label_x				= 230;
	private int		label_x_position	= label_x;
	private int		label_y_position	= 10;
	private int		label_width			= 100;
	private int		label_height		= 25;

	private int		input_x				= 320;
	private int		input_x_position	= input_x;
	private int		input_y_position	= 10;
	private int		input_width			= 300;
	private int		input_height		= 25;

	private int		line_interval		= 5;

	JButton			btn_save			= new JButton("저장");

	JTextField		text_depart			= new JTextField();
	JTextField		text_grade			= new JTextField();
	JTextField		text_name			= new JTextField();

	JPasswordField	password1			= new JPasswordField();
	JPasswordField	password2			= new JPasswordField();

	EraserManager()
	{
		BoxLayout	layout	= new BoxLayout(this, BoxLayout.Y_AXIS);
		JLabel		label	= new JLabel("관리자 정보");
		label.setFont(new Font(label.getFont().getName(), Font.PLAIN, 12));
		label.setAlignmentX(Component.CENTER_ALIGNMENT);

		JPanel panel_content = new JPanel();

		panel_content.setLayout(null);

		JLabel	label_depart	= new JLabel("기관명");
		JLabel	label_grade		= new JLabel("부서명");
		JLabel	label_name		= new JLabel("실행자(이름)");
		JLabel	label_password1	= new JLabel("암호");
		JLabel	label_password2	= new JLabel("암호확인");

		label_depart.setFont(new Font("돋움체", Font.PLAIN, 12));
		label_grade.setFont(new Font("돋움체", Font.PLAIN, 12));
		label_name.setFont(new Font("돋움체", Font.PLAIN, 12));
		label_password1.setFont(new Font("돋움체", Font.PLAIN, 12));
		label_password2.setFont(new Font("돋움체", Font.PLAIN, 12));

		label_depart.setBounds(label_x_position, label_y_position, label_width, label_height);
		text_depart.setBounds(input_x_position, input_y_position, input_width, input_height);
		label_y_position	+= label_height + line_interval;
		input_y_position	+= input_height + line_interval;
		panel_content.add(label_depart);
		panel_content.add(text_depart);

		label_grade.setBounds(label_x_position, label_y_position, label_width, label_height);
		text_grade.setBounds(input_x_position, input_y_position, input_width, input_height);
		label_y_position	+= label_height + line_interval;
		input_y_position	+= input_height + line_interval;
		panel_content.add(label_grade);
		panel_content.add(text_grade);

		label_name.setBounds(label_x_position, label_y_position, label_width, label_height);
		text_name.setBounds(input_x_position, input_y_position, input_width, input_height);
		label_y_position	+= label_height + line_interval;
		input_y_position	+= input_height + line_interval;
		panel_content.add(label_name);
		panel_content.add(text_name);

		label_password1.setBounds(label_x_position, label_y_position, label_width, label_height);
		password1.setBounds(input_x_position, input_y_position, input_width, input_height);
		label_y_position	+= label_height + line_interval;
		input_y_position	+= input_height + line_interval;
		panel_content.add(label_password1);
		panel_content.add(password1);

		label_password2.setBounds(label_x_position, label_y_position, label_width, label_height);
		password2.setBounds(input_x_position, input_y_position, input_width, input_height);
		label_y_position	+= label_height + line_interval;
		input_y_position	+= input_height + line_interval;
		panel_content.add(label_password2);
		panel_content.add(password2);

		btn_save.setBounds(input_x_position, input_y_position, 80, 20);
		panel_content.add(btn_save);

		this.setLayout(layout);

		this.add(Box.createRigidArea(new Dimension(5, 20)));
		this.add(label);
		this.add(Box.createRigidArea(new Dimension(5, 10)));
		this.add(panel_content);

		btn_save.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				EraserService service = new EraserServiceImpl();

				if(password1.getText().equals(password2.getText()) == false)
				{
					JOptionPane.showMessageDialog(null, "암호와 암호확인이 다릅니다.");
					return;
				}

				if(password1.getText().length() < 4)
				{
					JOptionPane.showMessageDialog(null, "암호는 4자리 이상으로 해주세요.");
					return;
				}

				service.managersave(text_depart.getText(), text_grade.getText(), text_name.getText(),
				        password1.getText());
				JOptionPane.showMessageDialog(null, "관리자 정보가 수정되었습니다.");

			}
		});
	}

	public void view()
	{
		EraserService	service		= new EraserServiceImpl();
		Hashtable		hash		= service.managerview();

		String			depart		= null;
		String			grade		= null;
		String			name		= null;
		String			password	= null;

		depart		= (String) hash.get("depart");
		grade		= (String) hash.get("grade");
		name		= (String) hash.get("name");
		password	= (String) hash.get("password");

		if(depart == null)
		{
			depart = "";
		}
		if(grade == null)
		{
			grade = "";
		}
		if(name == null)
		{
			name = "";
		}
		if(password == null)
		{
			password = "";
		}

		text_depart.setText(depart);
		text_grade.setText(grade);
		text_name.setText(name);
		password1.setText(password);
		password2.setText(password);
	}
}
