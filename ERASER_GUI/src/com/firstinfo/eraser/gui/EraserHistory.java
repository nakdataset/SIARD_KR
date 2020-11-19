package com.firstinfo.eraser.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.Hashtable;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

import com.firstinfo.eraser.config.Constants;
import com.firstinfo.eraser.service.EraserService;
import com.firstinfo.eraser.serviceimpl.EraserServiceImpl;

/**
 * 삭제 스크립트 실행이력을 조회한다.
 *
 * @author 국가기록원
 *
 */
@SuppressWarnings("serial")
public class EraserHistory extends JPanel
{
	ImageIcon icon_printer = new ImageIcon(Constants.IMAGE_PATH + "/printer.jpg");

	String columns[] = {"실행번호", "파일번호", "제목", "실행날짜", "처리건수", "SQL", "결과"};
	Object data[][] = {{"", "", "", "", "", "", "", icon_printer}};

	DefaultTableModelEraser model = new DefaultTableModelEraser(data, columns);
	JTable table = new JTable(model);

	private String data_dir = "./data";

	EraserGui gui = null;

	EraserHistory(EraserGui gui)
	{
		this.gui = gui;

		BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(layout);

		JLabel label = new JLabel("삭제 스크립트 실행 이력입니다.");
		label.setFont(new Font(label.getFont().getName(), Font.PLAIN, 12));
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		label.setForeground(Color.WHITE);

		table.setFont(new Font(table.getFont().getName(), Font.PLAIN, 12));

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

		DefaultTableCellRenderer render_link = new DefaultTableCellRenderer();
		render_link.setForeground(Color.BLUE);
		render_link.setHorizontalAlignment(SwingConstants.CENTER);

		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(5).setCellRenderer(render_link);

		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.getColumnModel().getColumn(1).setPreferredWidth(80);
		table.getColumnModel().getColumn(2).setPreferredWidth(220);
		table.getColumnModel().getColumn(3).setPreferredWidth(160);
		table.getColumnModel().getColumn(4).setPreferredWidth(80);
		table.getColumnModel().getColumn(5).setPreferredWidth(80);
		table.getColumnModel().getColumn(6).setPreferredWidth(80);

		table.setRowHeight(24);

		((DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

		JScrollPane scrollPane = new JScrollPane(table);

		this.setOpaque(true);
		this.setBackground(Color.darkGray);
		this.add(Box.createRigidArea(new Dimension(0, 10)));
		this.add(label);
		this.add(Box.createRigidArea(new Dimension(0, 10)));
		this.add(scrollPane);

		EraserService service = new EraserServiceImpl();

		Vector<Hashtable> v = service.historyview();
		model.setRowCount(0);
		// 삭제 스크립트 목록 가져온다.
		Object row_data[] = new Object[7];

		for (int ix = 0; ix < v.size(); ix++) {
			Hashtable<String, String> hash = v.get(ix);

			String number = hash.get("NUMBER");
			String title = hash.get("TITLE");
			String date = hash.get("DATE");
			String count = hash.get("COUNT");

			row_data[0] = String.valueOf(ix + 1);
			row_data[1] = number;
			row_data[2] = title;
			row_data[3] = date;
			row_data[4] = count;
			row_data[5] = "보기";
			row_data[6] = icon_printer;

			model.addRow(row_data);
		}

		model.fireTableDataChanged();

		table.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent event)
			{
				int row = table.rowAtPoint(event.getPoint());
				int col = table.columnAtPoint(event.getPoint());

				if (col == 5) {
					String sql_time = (String) table.getModel().getValueAt(row, 3);

					// 2019-09-09 12:31:22 --> 20190909_123122
					sql_time = sql_time.replaceAll("-", "");
					sql_time = sql_time.replaceAll(":", "");
					sql_time = sql_time.replaceAll(" ", "_");

					try {
						String sql_file_name = "file_eraser_history_sql_" + sql_time + ".txt";

						File file_history_sql = new File(data_dir + "/" + sql_file_name);
						RandomAccessFile ranfile_sql = new RandomAccessFile(file_history_sql, "r");

						String line = "";
						String sql_history = "";

						int count = 0;

						while ((line = ranfile_sql.readLine()) != null) {
							byte ptext[] = line.getBytes("ISO-8859-1");
							line = new String(ptext, "UTF-8");

							if (count > 0) {
								sql_history += "\n" + line;
							} else {
								sql_history += line;
							}

							count++;
						}

						ranfile_sql.close();
						JTextArea area_sql = new JTextArea(sql_history);
						area_sql.setEditable(false);

						JScrollPane scrollPane = new JScrollPane(area_sql);
						JDialog dialog_sql = new JDialog(gui, sql_file_name);
						Dimension d_size = new Dimension(600, 400);

						dialog_sql.add(scrollPane);
						dialog_sql.setSize(d_size);

						Toolkit toolkit = Toolkit.getDefaultToolkit();
						Dimension screenSize = toolkit.getScreenSize();
						int x = (int) ((screenSize.width / 2) - (d_size.getWidth() / 2));
						int y = (int) ((screenSize.height / 2) - (d_size.getHeight() / 2));
						dialog_sql.setLocation(x, y);

						dialog_sql.setVisible(true);
					} catch (FileNotFoundException fnfe) {
						JOptionPane.showMessageDialog(null, "파일이 없습니다.");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				if (col == 6) {
					String sql_time = (String) table.getModel().getValueAt(row, 3);
					EraserReport report = new EraserReport(gui, sql_time);
				}
			}

			@Override
			public void mouseEntered(java.awt.event.MouseEvent event)
			{
//				int row = table.rowAtPoint(event.getPoint());
				int col = table.columnAtPoint(event.getPoint());

				if (col == 5 || col == 6) {
					table.setCursor(new Cursor(Cursor.HAND_CURSOR));
				} else {
					table.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
			}
		});

		table.addMouseMotionListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseMoved(java.awt.event.MouseEvent event)
			{
//				int row = table.rowAtPoint(event.getPoint());
				int col = table.columnAtPoint(event.getPoint());

				if (col == 5 || col == 6) {
					table.setCursor(new Cursor(Cursor.HAND_CURSOR));
				} else {
					table.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
			}
		});
	}

	public void listrefresh()
	{
		while (model.getRowCount() > 0) {
			model.removeRow(0);
		}

		EraserService service = new EraserServiceImpl();

		Vector<Hashtable> v = service.historyview();
		model.setRowCount(0);
		// 삭제 스크립트 목록 가져온다.
		Object row_data[] = new Object[7];

		for (int ix = 0; ix < v.size(); ix++) {
			Hashtable<String, String> hash = v.get(ix);

			String number = hash.get("NUMBER");
			String title = hash.get("TITLE");
			String date = hash.get("DATE");
			String count = hash.get("COUNT");

			row_data[0] = String.valueOf(ix + 1);
			row_data[1] = number;
			row_data[2] = title;
			row_data[3] = date;
			row_data[4] = count;
			row_data[5] = "보기";
			row_data[6] = icon_printer;

			model.addRow(row_data);
		}

		model.fireTableDataChanged();
	}
}
