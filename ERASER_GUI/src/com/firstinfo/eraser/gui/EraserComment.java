package com.firstinfo.eraser.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.firstinfo.eraser.config.Constants;
import com.firstinfo.eraser.service.EraserService;
import com.firstinfo.eraser.serviceimpl.EraserServiceImpl;

@SuppressWarnings("serial")
public class EraserComment extends JDialog implements ActionListener
{
	JTextArea textareaMessage = new JTextArea();
	JScrollPane scrollMessage = new JScrollPane(textareaMessage);

	JLabel labelMessage = new JLabel("알림");
	JLabel labelComment = new JLabel("* 심의결과");

	JButton btnOk = new JButton("실행");
	JButton btnCancel = new JButton("취소");

	String number = "";
	String title = "";
	String check_test = "";
	String check_all = "";

	JLabel label_depart = new JLabel("* 기관명");
	JLabel label_grade = new JLabel("* 부서명");
	JLabel label_name = new JLabel("* 실행자(이름)");
	JLabel label_present = new JLabel("입회자(이름)");

	JLabel label_depart_sample = new JLabel("예) 국가기록원");
	JLabel label_grade_sample = new JLabel("예) 전자기록관리과");
	JLabel label_name_sample = new JLabel("예) 전산주사 홍길동");
	JLabel label_present_sample = new JLabel("예) 기록연구사 전우치");
	JLabel label_comment_sample = new JLabel("예) 2020년 1월 1일 심의회의 결과에 따른 처분");

	JTextArea textareaComment = new JTextArea();
	JScrollPane scrollComment = new JScrollPane(textareaComment);

	JTextField text_depart = new JTextField();
	JTextField text_grade = new JTextField();
	JTextField text_name = new JTextField();
	JTextField text_present = new JTextField();

	EraserGui gui = null;

	public EraserComment(EraserGui owner, boolean modal, Hashtable hash)
	{
		super(owner, modal);
		this.gui = owner;

		number = (String) hash.get("NUMBER");
		title = (String) hash.get("TITLE");
		check_test = (String) hash.get("CHECKTEST");
		check_all = (String) hash.get("CHECKALL");

		String strmessage = "";
		strmessage = "행정정보데이터세트 기록관리 협의체                                 \n"
			+ "      각 시스템별로 행정정보데이터세트를 관리하기 위해 업무 담당자, \n" + "       기록관리 담당자,  시스템 담당자가 모두 참여하는 협의체를 구성하여 \n"
			+ "       관리의 기준 확정 및 협의가 필요한 부분을 해결하도록 함\n" + "\n" + "단위기능\n"
			+ "       행정정보데이터세트의 특성을 반영하여 데이터베이스의 구조별로 \n" + "       업무별로 물리적 또는 논리적으로 구분이 가능한 기록관리 단위로서 \n"
			+ "       단위기능별로 보존 및 처분 실행\n" + "\n" + "처분단위\n" + "        단위기능별로 동일한 처분을 할 수 없을 때 처분을 달리하는 단위";

		textareaMessage.setText(strmessage);
		textareaMessage.setColumns(50);
		textareaMessage.setEditable(false);
		textareaMessage.setBackground(Color.LIGHT_GRAY);

		textareaMessage.setRows(10);
		textareaComment.setColumns(50);
		textareaComment.setRows(10);

//		Border border = LineBorder.createGrayLineBorder();
//		labelMessage.setBorder(border);
//		labelComment.setBorder(border);

		label_depart.setPreferredSize(new Dimension(110, 20));
		label_grade.setPreferredSize(new Dimension(110, 20));
		label_name.setPreferredSize(new Dimension(110, 20));
		label_present.setPreferredSize(new Dimension(110, 20));
		labelComment.setPreferredSize(new Dimension(110, 20));

		text_depart.setPreferredSize(new Dimension(180, 10));
		text_grade.setPreferredSize(new Dimension(180, 10));
		text_name.setPreferredSize(new Dimension(180, 10));

		label_depart.setAlignmentX(Component.LEFT_ALIGNMENT);
		label_grade.setAlignmentX(Component.LEFT_ALIGNMENT);
		label_name.setAlignmentX(Component.LEFT_ALIGNMENT);
		labelComment.setAlignmentX(Component.LEFT_ALIGNMENT);

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		// 기관명
		JPanel panel1 = new JPanel();
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));
		panel1.add(Box.createRigidArea(new Dimension(10, 10)));
		panel1.add(label_depart);
		panel1.add(Box.createRigidArea(new Dimension(5, 5)));
		panel1.add(text_depart);
		panel1.add(Box.createRigidArea(new Dimension(10, 10)));

		JPanel panel1_sample = new JPanel();
		panel1_sample.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel1_sample.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panel1_sample.add(Box.createRigidArea(new Dimension(115, 1)));
		panel1_sample.add(label_depart_sample);

		// 부서명
		JPanel panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));
		panel2.add(Box.createRigidArea(new Dimension(10, 10)));
		panel2.add(label_grade);
		panel2.add(Box.createRigidArea(new Dimension(5, 5)));
		panel2.add(text_grade);
		panel2.add(Box.createRigidArea(new Dimension(10, 10)));

		JPanel panel2_sample = new JPanel();
		panel2_sample.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel2_sample.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panel2_sample.add(Box.createRigidArea(new Dimension(115, 1)));
		panel2_sample.add(label_grade_sample);

		// 실행자 이름
		JPanel panel3 = new JPanel();
		panel3.setLayout(new BoxLayout(panel3, BoxLayout.X_AXIS));
		panel3.add(Box.createRigidArea(new Dimension(10, 10)));
		panel3.add(label_name);
		panel3.add(Box.createRigidArea(new Dimension(5, 5)));
		panel3.add(text_name);
		panel3.add(Box.createRigidArea(new Dimension(10, 10)));

		JPanel panel3_sample = new JPanel();
		panel3_sample.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel3_sample.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panel3_sample.add(Box.createRigidArea(new Dimension(115, 1)));
		panel3_sample.add(label_name_sample);

		// 입회자 이름
		JPanel panel4 = new JPanel();
		panel4.setLayout(new BoxLayout(panel4, BoxLayout.X_AXIS));
		panel4.add(Box.createRigidArea(new Dimension(10, 10)));
		panel4.add(label_present);
		panel4.add(Box.createRigidArea(new Dimension(5, 5)));
		panel4.add(text_present);
		panel4.add(Box.createRigidArea(new Dimension(10, 10)));

		JPanel panel4_sample = new JPanel();
		panel4_sample.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel4_sample.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panel4_sample.add(Box.createRigidArea(new Dimension(115, 1)));
		panel4_sample.add(label_present_sample);

		// 심의결과
		JPanel panel5 = new JPanel();
		panel5.setLayout(new BoxLayout(panel5, BoxLayout.X_AXIS));
		panel5.add(Box.createRigidArea(new Dimension(10, 10)));
		panel5.add(labelComment);
		panel5.add(Box.createRigidArea(new Dimension(5, 5)));
		panel5.add(scrollComment);
		panel5.add(Box.createRigidArea(new Dimension(10, 10)));

		JPanel panel5_sample = new JPanel();
		panel5_sample.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel5_sample.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panel5_sample.add(Box.createRigidArea(new Dimension(115, 1)));
		panel5_sample.add(label_comment_sample);

		// 버튼
		JPanel panel6 = new JPanel();
		panel6.setLayout(new BoxLayout(panel6, BoxLayout.X_AXIS));
		panel6.add(Box.createRigidArea(new Dimension(10, 10)));
		panel6.add(btnOk);
		panel6.add(Box.createRigidArea(new Dimension(5, 5)));
		panel6.add(btnCancel);
		panel6.add(Box.createRigidArea(new Dimension(10, 10)));

		panel.add(Box.createRigidArea(new Dimension(10, 10)));

		panel.add(panel1);
		panel.add(panel1_sample);
		panel.add(Box.createRigidArea(new Dimension(5, 5)));

		panel.add(panel2);
		panel.add(panel2_sample);
		panel.add(Box.createRigidArea(new Dimension(5, 5)));

		panel.add(panel3);
		panel.add(panel3_sample);
		panel.add(Box.createRigidArea(new Dimension(5, 5)));

		panel.add(panel4);
		panel.add(panel4_sample);
		panel.add(Box.createRigidArea(new Dimension(5, 5)));

		panel.add(panel5);
		panel.add(panel5_sample);
		panel.add(Box.createRigidArea(new Dimension(5, 5)));

		panel.add(panel6);
		panel.add(Box.createRigidArea(new Dimension(10, 10)));

		EraserService service = new EraserServiceImpl();
		Hashtable hashmanager = service.managerview();

		String depart = null;
		String grade = null;
		String name = null;

		depart = (String) hashmanager.get("depart");
		grade = (String) hashmanager.get("grade");
		name = (String) hashmanager.get("name");

		if (depart == null) {
			depart = "";
		}
		if (grade == null) {
			grade = "";
		}
		if (name == null) {
			name = "";
		}

		text_depart.setText(depart);
		text_grade.setText(grade);
		text_name.setText(name);

		btnOk.addActionListener(this);
		btnCancel.addActionListener(this);

		ImageIcon img = new ImageIcon(Constants.IMAGE_PATH + "/favicon.png");
		this.setIconImage(img.getImage());

		this.add(panel);
		this.pack();
		this.setTitle("심의결과 입력 후 실행");

		this.setResizable(true);
		this.setSize(650, 430);

		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
		this.setLocation(x, y);
		this.setResizable(false);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == btnOk) {

			String str_depart = text_depart.getText();
			String str_grade = text_grade.getText();
			String str_name = text_name.getText();

			String strcomment = textareaComment.getText();

			if (str_depart.trim().equals("")) {
				JOptionPane.showMessageDialog(null, "기관명을 입력하여 주세요.");
				return;
			}

			if (str_grade.trim().equals("")) {
				JOptionPane.showMessageDialog(null, "부서명을 입력하여 주세요.");
				return;
			}

			if (str_name.trim().equals("")) {
				JOptionPane.showMessageDialog(null, "실행자(이름)를입력하여 주세요.");
				return;
			}

			if (strcomment.trim().equals("")) {
				JOptionPane.showMessageDialog(null, "심의결과를 입력하여 주세요.");
				return;
			} else {
				String warn_message = "<html>실행하시면 데이터가 완전히 삭제되고 복구되지 않습니다.<br> 최종적으로 기록관과 확인하고 실행하시겠습니까?<html>";

				JLabel label_message = new JLabel(warn_message);

				label_message.setFont(new Font("맑은고딕", Font.PLAIN, 12));

				int result = JOptionPane.showConfirmDialog(this, label_message, "경고", JOptionPane.YES_NO_OPTION);

				if (result == JOptionPane.YES_OPTION) {
					String warn_message2 = "정말로 삭제하시겠습니까?";

					JLabel label_message2 = new JLabel(warn_message2);

					// label_message.getFont().deriveFont(36);

					label_message2.setFont(new Font("맑은고딕", Font.PLAIN, 12));

					int result2 = JOptionPane.showConfirmDialog(this, label_message2, "경고", JOptionPane.YES_NO_OPTION);

					if (result2 == JOptionPane.YES_OPTION) {
						delete();
					}
				}
			}
		} else if (e.getSource() == btnCancel) {
			this.dispose();
		}
	}

	public void delete()
	{
		String strcomment = textareaComment.getText();
		strcomment = strcomment.trim();

		EraserService service = new EraserServiceImpl();

		Hashtable hash_input = new Hashtable();
		hash_input.put("NUMBER", this.number);
		hash_input.put("TITLE", this.title);
		hash_input.put("TEST", this.check_test);
		hash_input.put("ALL", this.check_all);
		hash_input.put("COMMENT", strcomment);
		hash_input.put("DEPART", this.text_depart.getText().trim());
		hash_input.put("GRADE", this.text_grade.getText().trim());
		hash_input.put("NAME", this.text_name.getText().trim()); // 실행자
		hash_input.put("PRESENT", this.text_present.getText().trim()); // 입회자

		// Hashtable hash = service.eraserexecute(this.number, this.title,
		// this.check_test, this.check_all, strcomment);
		Hashtable hash = service.eraserexecute(hash_input);

		String count = (String) hash.get("COUNT");
		String success = (String) hash.get("SUCCESS");
		String sqltime = (String) hash.get("SQLTIME");

		if (success != null) {
			if (success.equals("true")) {
				JOptionPane.showMessageDialog(null, count + "건 삭제되었습니다.");
			} else if (success.equals("false")) {
				String error_code = (String) hash.get("ERRORCODE");
				String error_message = (String) hash.get("ERRORMESSAGE");
				String error_sql = (String) hash.get("ERRORSQL");

				String message = "에러코드:" + error_code + "\n" + "에러메시지:" + error_message + "\n" + "SQL :" + error_sql;
				JOptionPane.showMessageDialog(null, message);
			}

			EraserView view = (EraserView) this.gui.getMain().getSubPanel("view");
			view.setReportButtonEnabled(true);

			System.out.println("sqltime:" + sqltime);
			view.setSqlTime(sqltime);
			this.dispose();
		}
	}
}
