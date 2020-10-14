package com.firstinfo.eraser.gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Hashtable;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.firstinfo.eraser.service.EraserService;
import com.firstinfo.eraser.serviceimpl.EraserServiceImpl;

/**
 * 처분 스크립트 저장 목록을 조회한다.
 *
 * @author 국가기록원
 *
 */
@SuppressWarnings("serial")
public class EraserList extends JPanel
{
	String data[][] = {{"", "", ""}};
	String columns[] = {"파일번호", "제목", "생성날짜"};

	DefaultTableModel model = new DefaultTableModel(data, columns);
	JTable table = new JTable(model);

	EraserMain panel_main = null;

	EraserList(EraserMain main)
	{
		this.panel_main = main;

		BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(layout);

		JLabel label = new JLabel("처분 스크립트 목록입니다.");
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		label.setFont(new Font(label.getFont().getName(), Font.PLAIN, 12));
		label.setForeground(Color.WHITE);

		table.setFont(new Font(table.getFont().getName(), Font.PLAIN, 12));

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);

		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.getColumnModel().getColumn(1).setPreferredWidth(500);
		table.getColumnModel().getColumn(2).setPreferredWidth(120);

		table.setRowHeight(24);

		((DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

		// table.setEnabled(false);
		JScrollPane scrollPane = new JScrollPane(table);

		this.setOpaque(true);
		this.setBackground(Color.darkGray);
		this.add(Box.createRigidArea(new Dimension(0, 10)));
		this.add(label);
		this.add(Box.createRigidArea(new Dimension(0, 10)));
		this.add(scrollPane);

		EraserService service = new EraserServiceImpl();

		Vector<Hashtable> v = service.eraserlist();

		// 처분 스크립트 목록 가져온다.
		data = new String[v.size()][3];

		model.setRowCount(0);

		String rowdata[] = new String[3];

		try {
			for (int ix = 0; ix < v.size(); ix++) {
				Hashtable<String, String> hash = v.get(ix);

				String number = hash.get("NUMBER");
				String title = hash.get("TITLE");
				String date = hash.get("DATE");

				// number = new String(number.getBytes("ISO-8859-1"), "UTF-8");
				// title = new String(title.getBytes("ISO-8859-1"), "UTF-8");
				// date = new String(date.getBytes("ISO-8859-1"), "UTF-8");

				rowdata[0] = number;
				rowdata[1] = title;
				rowdata[2] = date;

				model.addRow(rowdata);
			}

			model.fireTableDataChanged();

			table.addMouseListener(new java.awt.event.MouseAdapter() {
				@Override
				public void mouseClicked(java.awt.event.MouseEvent e)
				{
					int row = table.rowAtPoint(e.getPoint());

					CardLayout card = (CardLayout) panel_main.getLayout();
					card.show(panel_main, "view");

					EraserView view = (EraserView) panel_main.getSubPanel("view");
					String str_number = table.getValueAt(row, 0).toString();
					view.viewrefesh(str_number);
					view.setReportButtonEnabled(false);
				}
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void listrefresh()
	{
		EraserService service = new EraserServiceImpl();

		Vector<Hashtable> v = service.eraserlist();

		while (model.getRowCount() > 0) {
			model.removeRow(0);
		}

		String rowdata[] = new String[3];

		for (int ix = 0; ix < v.size(); ix++) {
			Hashtable<String, String> hash = v.get(ix);

			String number = hash.get("NUMBER");
			String title = hash.get("TITLE");
			String date = hash.get("DATE");

			rowdata[0] = number;
			rowdata[1] = title;
			rowdata[2] = date;

			model.addRow(rowdata);
		}

		model.fireTableDataChanged();
	}
}
