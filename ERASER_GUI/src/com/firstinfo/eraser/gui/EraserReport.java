package com.firstinfo.eraser.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.Hashtable;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import com.firstinfo.eraser.config.Constants;
import com.firstinfo.eraser.service.EraserService;
import com.firstinfo.eraser.serviceimpl.EraserServiceImpl;

@SuppressWarnings("serial")
public class EraserReport extends JDialog
{
	Hashtable hash_history = null;

	EraserService service = new EraserServiceImpl();

	JPanel panel_main = new JPanel();

	JPanel panel_printer_button = new JPanel();
	JPanel panel_printarea = new JPanel();
	JPanel panel_top = new JPanel();
	JPanel panel_center = new JPanel();
	JPanel panel_bottom = new JPanel();
	JPanel panel_icon = new JPanel();

	JButton button_printer = new JButton(" 인쇄 ");

	JLabel label_top_title = new JLabel("기록물 삭제 결과 (행정데이터세트)");

	JLabel label_depart_left = new JLabel("기관명:");
	JLabel label_grade_left = new JLabel("부서명:");
	JLabel label_name_left = new JLabel("실행자:");
	JLabel label_present_left = new JLabel("입회자:");
	JLabel label_script_id_left = new JLabel("삭제 스크립트 아이디:");
	JLabel label_script_title_left = new JLabel("삭제대상:");
	JLabel label_datetime_left = new JLabel("삭제일시:");
	JLabel label_count_left = new JLabel("삭제건수:");
	JLabel label_comment_left = new JLabel("심의결과:");
	JLabel label_sql_left = new JLabel("삭제스크립트:");

	JLabel label_depart_right = new JLabel("");
	JLabel label_grade_right = new JLabel("");
	JLabel label_name_right = new JLabel("");
	JLabel label_present_right = new JLabel("");
	JLabel label_script_id_right = new JLabel("");
	JLabel label_script_title_right = new JLabel("");
	JLabel label_datetime_right = new JLabel("");
	JLabel label_count_right = new JLabel("");
	JLabel label_comment_right = new JLabel("");
	JLabel label_sql_right = new JLabel("");

	//20201008 - 좌표값 일부 수정 by.IntraDIGM
	int label_left_x = 50;
	int label_left_y = 20;
	int label_left_width = 100;
	int label_left_height = 24;

	int label_right_x = 150;
	int label_right_y = 20;
	int label_right_width = 400;
	int label_right_height = 24;

	JLabel label_bottom_title = new JLabel("행정안전부 국가기록원");

	ImageIcon icon_logo = new ImageIcon("images/document.jpg");
	JLabel label_icon = new JLabel(icon_logo);

	EraserReport(JFrame owner, String sqltime)
	{
		super(owner);

		Vector vector = service.historyview();

		for (int ix = 0; ix < vector.size(); ix++) {

			Hashtable hash = (Hashtable) vector.get(ix);

			if (sqltime.equals(hash.get("DATE"))) {
				this.hash_history = (Hashtable) vector.get(ix);
				System.out.println("sqltime=" + sqltime);
				break;
			}
		}

		sqltime = sqltime.replace(":", "");
		sqltime = sqltime.replace("-", "");
		sqltime = sqltime.replace(" ", "_");

		String str_comment = service.commentview(sqltime);

		if (str_comment == null) {
			str_comment = "";
		}

		String str_sql = service.historysqlview(sqltime);

		if (str_sql == null) {
			str_sql = "";
		}

		label_depart_right.setText((String) hash_history.get("DEPART"));
		label_grade_right.setText((String) hash_history.get("GRADE"));
		label_name_right.setText((String) hash_history.get("NAME"));
		label_present_right.setText((String) hash_history.get("PRESENT"));
		label_script_id_right.setText((String) hash_history.get("NUMBER"));
		label_script_title_right.setText((String) hash_history.get("TITLE"));
		label_datetime_right.setText((String) hash_history.get("DATE"));
		label_count_right.setText((String) hash_history.get("COUNT") + "건");
		label_comment_right.setText("<html><p>" + str_comment + "</p></html>");
		label_sql_right.setText("<html><p>" + str_sql + "</p></html>");

		Border blackline = BorderFactory.createLineBorder(Color.black);

		panel_main.setLayout(new BoxLayout(panel_main, BoxLayout.Y_AXIS));
		panel_printarea.setLayout(new BoxLayout(panel_printarea, BoxLayout.Y_AXIS));

		panel_printer_button.setLayout(new BoxLayout(panel_printer_button, BoxLayout.X_AXIS));
		panel_top.setLayout(new BoxLayout(panel_top, BoxLayout.X_AXIS));

		panel_center.setLayout(null);
		panel_bottom.setLayout(new BoxLayout(panel_bottom, BoxLayout.X_AXIS));
		panel_icon.setLayout(new BoxLayout(panel_icon, BoxLayout.X_AXIS));

		panel_printer_button.setBorder(blackline);

		panel_printer_button.add(button_printer);
		panel_printer_button.add(Box.createHorizontalGlue());

		label_top_title.setFont(new Font("Malgun Gothic", Font.PLAIN, 22));

		label_depart_left.setFont(new Font("Malgun Gothic", Font.PLAIN, 16));
		label_grade_left.setFont(new Font("Malgun Gothic", Font.PLAIN, 16));
		label_name_left.setFont(new Font("Malgun Gothic", Font.PLAIN, 16));
		label_present_left.setFont(new Font("Malgun Gothic", Font.PLAIN, 16));
		label_script_id_left.setFont(new Font("Malgun Gothic", Font.PLAIN, 16));
		label_script_title_left.setFont(new Font("Malgun Gothic", Font.PLAIN, 16));
		label_datetime_left.setFont(new Font("Malgun Gothic", Font.PLAIN, 16));
		label_count_left.setFont(new Font("Malgun Gothic", Font.PLAIN, 16));
		label_comment_left.setFont(new Font("Malgun Gothic", Font.PLAIN, 16));
		label_sql_left.setFont(new Font("Malgun Gothic", Font.PLAIN, 16));

		label_depart_left.setPreferredSize(new Dimension(150, 20));

		label_depart_right.setFont(new Font("Malgun Gothic", Font.PLAIN, 16));
		label_grade_right.setFont(new Font("Malgun Gothic", Font.PLAIN, 16));
		label_name_right.setFont(new Font("Malgun Gothic", Font.PLAIN, 16));
		label_present_right.setFont(new Font("Malgun Gothic", Font.PLAIN, 16));
		label_script_id_right.setFont(new Font("Malgun Gothic", Font.PLAIN, 16));
		label_script_title_right.setFont(new Font("Malgun Gothic", Font.PLAIN, 16));
		label_datetime_right.setFont(new Font("Malgun Gothic", Font.PLAIN, 16));
		label_count_right.setFont(new Font("Malgun Gothic", Font.PLAIN, 16));
		label_comment_right.setFont(new Font("Malgun Gothic", Font.PLAIN, 16));
		label_sql_right.setFont(new Font("Malgun Gothic", Font.PLAIN, 16));

		panel_printarea.setBorder(blackline);

		label_depart_left.setHorizontalAlignment(SwingConstants.LEFT);
		label_grade_left.setHorizontalAlignment(SwingConstants.LEFT);
		label_name_left.setHorizontalAlignment(SwingConstants.LEFT);
		label_present_left.setHorizontalAlignment(SwingConstants.LEFT);
		label_script_title_left.setHorizontalAlignment(SwingConstants.LEFT);
		label_datetime_left.setHorizontalAlignment(SwingConstants.LEFT);
		label_count_left.setHorizontalAlignment(SwingConstants.LEFT);
		label_comment_left.setHorizontalAlignment(SwingConstants.LEFT);
		label_sql_left.setHorizontalAlignment(SwingConstants.LEFT);

		label_depart_left.setVerticalAlignment(SwingConstants.TOP);
		label_grade_left.setVerticalAlignment(SwingConstants.TOP);
		label_name_left.setVerticalAlignment(SwingConstants.TOP);
		label_present_left.setVerticalAlignment(SwingConstants.TOP);
		label_script_title_left.setVerticalAlignment(SwingConstants.TOP);
		label_datetime_left.setVerticalAlignment(SwingConstants.TOP);
		label_count_left.setVerticalAlignment(SwingConstants.TOP);
		label_comment_left.setVerticalAlignment(SwingConstants.TOP);
		label_sql_left.setVerticalAlignment(SwingConstants.TOP);

		label_depart_right.setVerticalAlignment(SwingConstants.TOP);
		label_grade_right.setVerticalAlignment(SwingConstants.TOP);
		label_name_right.setVerticalAlignment(SwingConstants.TOP);
		label_present_right.setVerticalAlignment(SwingConstants.TOP);
		label_script_id_right.setVerticalAlignment(SwingConstants.TOP);
		label_script_title_right.setVerticalAlignment(SwingConstants.TOP);
		label_datetime_right.setVerticalAlignment(SwingConstants.TOP);
		label_count_right.setVerticalAlignment(SwingConstants.TOP);
		label_comment_right.setVerticalAlignment(SwingConstants.TOP);
		label_sql_right.setVerticalAlignment(SwingConstants.TOP);

		label_depart_left.setLocation(label_left_x, label_left_y);
		label_depart_left.setSize(label_left_width, label_left_height);
		label_left_y += 30;

		label_grade_left.setLocation(label_left_x, label_left_y);
		label_grade_left.setSize(label_left_width, label_left_height);
		label_left_y += 30;

		label_datetime_left.setLocation(label_left_x, label_left_y);
		label_datetime_left.setSize(label_left_width, label_left_height);
		label_left_y += 30;

		label_name_left.setLocation(label_left_x, label_left_y);
		label_name_left.setSize(label_left_width, label_left_height);
		label_left_y += 30;

		label_present_left.setLocation(label_left_x, label_left_y);
		label_present_left.setSize(label_left_width, label_left_height);
		label_left_y += 30;

		label_script_title_left.setLocation(label_left_x, label_left_y);
		label_script_title_left.setSize(label_left_width, label_left_height);
		label_left_y += 30;

		label_count_left.setLocation(label_left_x, label_left_y);
		label_count_left.setSize(label_left_width, label_left_height);
		label_left_y += 30;

		label_comment_left.setLocation(label_left_x, label_left_y);
		label_comment_left.setSize(label_left_width, label_left_height + 50);
		label_left_y += 30 + 50;

		//////////////////////////////
		label_depart_right.setLocation(label_right_x, label_right_y);
		label_depart_right.setSize(label_right_width, label_right_height);
		label_right_y += 30;

		label_grade_right.setLocation(label_right_x, label_right_y);
		label_grade_right.setSize(label_right_width, label_right_height);
		label_right_y += 30;

		label_datetime_right.setLocation(label_right_x, label_right_y);
		label_datetime_right.setSize(label_right_width, label_right_height);
		label_right_y += 30;

		label_name_right.setLocation(label_right_x, label_right_y);
		label_name_right.setSize(label_right_width, label_right_height);
		label_right_y += 30;

		label_present_right.setLocation(label_right_x, label_right_y);
		label_present_right.setSize(label_right_width, label_right_height);
		label_right_y += 30;

		label_script_title_right.setLocation(label_right_x, label_right_y);
		label_script_title_right.setSize(label_right_width + 40, label_right_height);
		label_right_y += 30;

		label_count_right.setLocation(label_right_x, label_right_y);
		label_count_right.setSize(label_right_width, label_right_height);
		label_right_y += 30;

		label_comment_right.setLocation(label_right_x, label_right_y);
		label_comment_right.setSize(label_right_width, label_right_height + 50);
		label_right_y += 30 + 50;

		label_bottom_title.setFont(new Font("Malgun Gothic", Font.PLAIN, 16));

		panel_top.add(label_top_title);

		panel_main.setBackground(Color.WHITE);
		panel_printer_button.setBackground(Color.WHITE);
		panel_printarea.setBackground(Color.WHITE);
		panel_top.setBackground(Color.WHITE);
		panel_center.setBackground(Color.WHITE);
		panel_bottom.setBackground(Color.WHITE);

		panel_center.add(label_depart_left);
		panel_center.add(label_grade_left);
		panel_center.add(label_name_left);
		panel_center.add(label_present_left);
		panel_center.add(label_script_id_left);
		panel_center.add(label_script_title_left);
		panel_center.add(label_datetime_left);
		panel_center.add(label_count_left);
		panel_center.add(label_comment_left);
		panel_center.add(label_sql_left);

		panel_center.add(label_depart_right);
		panel_center.add(label_grade_right);
		panel_center.add(label_name_right);
		panel_center.add(label_present_right);
		panel_center.add(label_script_id_right);
		panel_center.add(label_script_title_right);
		panel_center.add(label_datetime_right);
		panel_center.add(label_count_right);
		panel_center.add(label_comment_right);
		panel_center.add(label_sql_right);

		panel_icon.add(label_icon);

		panel_printarea.add(Box.createRigidArea(new Dimension(10, 50)));
		panel_printarea.add(panel_top);
		panel_printarea.add(Box.createRigidArea(new Dimension(10, 10)));
		panel_printarea.add(panel_center);
		panel_printarea.add(panel_bottom);
		panel_printarea.add(panel_icon);
		panel_printarea.add(Box.createRigidArea(new Dimension(10, 150)));

		panel_main.add(panel_printer_button);
		panel_main.add(panel_printarea);

		button_printer.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent event)
			{
				PrinterJob pj = PrinterJob.getPrinterJob();
				pj.setJobName(" Print Component ");

				pj.setPrintable(new Printable() {
					@Override
					public int print(Graphics pg, PageFormat pf, int pageNum)
					{
						if (pageNum > 0) {
							return Printable.NO_SUCH_PAGE;
						}

						Graphics2D g2 = (Graphics2D) pg;
						g2.translate(pf.getImageableX(), pf.getImageableY());
						panel_printarea.paint(g2);
						return Printable.PAGE_EXISTS;
					}
				});
				if (pj.printDialog() == false)
					return;

				try {
					pj.print();
				} catch (PrinterException ex) {
					// handle exception
				}
			}
		});

		ImageIcon img = new ImageIcon(Constants.IMAGE_PATH + "/favicon.png");

		this.setTitle("국가기록원 삭제 스크립트 실행 결과");
		this.setIconImage(img.getImage());
		this.add(panel_main);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.pack();

		this.setResizable(false);
		this.setSize(575, 830);

		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
		this.setLocation(x, y);

		this.setVisible(true);
	}
}
