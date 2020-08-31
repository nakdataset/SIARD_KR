package com.firstinfo.eraser.gui;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Hashtable;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
public class EraserList extends JPanel
{
	String				data[][]	= { { "", "", "" } };
	String				columns[]	= { "파일번호", "제목", "생성날짜" };

	DefaultTableModel	model		= new DefaultTableModel(data, columns);
	JTable				table		= new JTable(model);

	EraserMain			panel_main	= null;

	EraserList(EraserMain main)
	{

		this.panel_main = main;

		BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(layout);

		JLabel label = new JLabel("처분 스크립트 목록입니다.");
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		label.setFont(new Font(label.getFont().getName(), Font.PLAIN, 12));

		JButton btn = new JButton("등록");

		table.setFont(new Font(table.getFont().getName(), Font.PLAIN, 12));

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);

		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.getColumnModel().getColumn(1).setPreferredWidth(500);
		table.getColumnModel().getColumn(2).setPreferredWidth(120);

		table.setRowHeight(20);

		((DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

		// table.setEnabled(false);
		JScrollPane scrollPane = new JScrollPane(table);

		this.add(Box.createRigidArea(new Dimension(5, 20)));
		this.add(label);
		this.add(Box.createRigidArea(new Dimension(5, 10)));
		// this.add(btn);
		this.add(scrollPane);

		EraserService		service	= new EraserServiceImpl();

		Vector<Hashtable>	v		= service.eraserlist();

		// 처분 스크립트 목록 가져온다.
		data = new String[v.size()][3];

		model.setRowCount(0);

		String rowdata[] = new String[3];

		try
		{
			for(int ix = 0; ix < v.size(); ix++)
			{
				Hashtable<String, String>	hash	= (Hashtable) v.get(ix);

				String						number	= (String) hash.get("NUMBER");
				String						title	= (String) hash.get("TITLE");
				String						date	= (String) hash.get("DATE");

//				number 	= new String(number.getBytes("ISO-8859-1"), "UTF-8");
//				title 	= new String(title.getBytes("ISO-8859-1"), "UTF-8");
//				date 	= new String(date.getBytes("ISO-8859-1"), "UTF-8");

				rowdata[0]	= number;
				rowdata[1]	= title;
				rowdata[2]	= date;

				model.addRow(rowdata);
			}

			// table.setModel(model);

			model.fireTableDataChanged();

			table.addMouseListener(new java.awt.event.MouseAdapter()
			{

				public void mouseClicked(java.awt.event.MouseEvent e)
				{

					int			row		= table.rowAtPoint(e.getPoint());

					CardLayout	card	= (CardLayout) panel_main.getLayout();
					card.show(panel_main, "view");

					EraserView	view		= (EraserView) panel_main.getSubPanel("view");					
					String		str_number	= table.getValueAt(row, 0).toString();
					view.viewrefesh(str_number);
					view.setReportButtonEnabled(false);

				}

			});

		}
		catch(Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void listrefresh()
	{
		EraserService		service	= new EraserServiceImpl();

		Vector<Hashtable>	v		= service.eraserlist();

		while(model.getRowCount() > 0)
		{
			model.removeRow(0);
		}

		String rowdata[] = new String[3];

		for(int ix = 0; ix < v.size(); ix++)
		{
			Hashtable<String, String>	hash	= (Hashtable) v.get(ix);

			String						number	= (String) hash.get("NUMBER");
			String						title	= (String) hash.get("TITLE");
			String						date	= (String) hash.get("DATE");

			rowdata[0]	= number;
			rowdata[1]	= title;
			rowdata[2]	= date;

			model.addRow(rowdata);
		}

		// table.setModel(model);

		model.fireTableDataChanged();
	}
}
