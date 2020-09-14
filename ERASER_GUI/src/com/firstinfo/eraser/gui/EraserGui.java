package com.firstinfo.eraser.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.UIManager;

import com.firstinfo.eraser.config.Constants;

/**
 * 처분 프로그램 실행 및 메뉴 클릭 이벤트 작성
 *
 * @author 국가기록원
 *
 */
public class EraserGui extends JFrame implements ActionListener
{
	JMenuBar	menubar		= new JMenuBar();
	JMenu		menu1		= new JMenu("스크립트 목록");
	JMenu		menu2		= new JMenu("스크립트 등록");
	JMenu		menu3		= new JMenu("스크립트 실행이력");
	JMenu		menu4		= new JMenu("DB 접속설정");
	JMenu		menu5		= new JMenu("관리자 정보");

	JMenuItem	item1		= new JMenuItem("스크립트 목록");
	JMenuItem	item2		= new JMenuItem("스크립트 등록");
	JMenuItem	item3		= new JMenuItem("스크립트 실행이력");
	JMenuItem	item4		= new JMenuItem("DB 접속설정");
	JMenuItem	item5		= new JMenuItem("관리자 정보");

	EraserMain	main		= null;

//	JButton		btnlist		= new JButton(new ImageIcon("images/script_list.jpg"));
//	JButton		btncreate	= new JButton(new ImageIcon("images/script_create.jpg"));
//	JButton		btnhistory	= new JButton(new ImageIcon("images/script_history.jpg"));
//	JButton		btndbconfig	= new JButton(new ImageIcon("images/dbconfig.jpg"));
//	JButton		btnmanager	= new JButton(new ImageIcon("images/manager.jpg"));

	JButton		btnlist		= new JButton(new ImageIcon(Constants.IMAGE_PATH + "/script_list.jpg"));
	JButton		btncreate	= new JButton(new ImageIcon(Constants.IMAGE_PATH + "/script_create.jpg"));
	JButton		btnhistory	= new JButton(new ImageIcon(Constants.IMAGE_PATH + "/script_history.jpg"));
	JButton		btndbconfig	= new JButton(new ImageIcon(Constants.IMAGE_PATH + "/dbconfig.jpg"));
	JButton		btnmanager	= new JButton(new ImageIcon(Constants.IMAGE_PATH + "/manager.jpg"));

	JToolBar	toolbar		= new JToolBar("Eraser ToolBar");

//	public static void main(String args[])
//	{
//		//처분 프로그램 실행
//		EraserGui gui = new EraserGui();
//	}

	/**
	 * 처분 프로그램 초기화
	 */
	public EraserGui()
	{

		try
		{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		this.setTitle("국가기록원 처분스크립트");

		menu1.setFont(new Font("돋움체", Font.PLAIN, 12));
		menu2.setFont(new Font("돋움체", Font.PLAIN, 12));
		menu3.setFont(new Font("돋움체", Font.PLAIN, 12));
		menu4.setFont(new Font("돋움체", Font.PLAIN, 12));
		menu5.setFont(new Font("돋움체", Font.PLAIN, 12));

		menubar.add(menu5);
		menubar.add(menu4);
		menubar.add(menu2);
		menubar.add(menu1);
		menubar.add(menu3);

		this.setJMenuBar(menubar);

		btnlist.setToolTipText("스크립트 목록");
		btncreate.setToolTipText("스크립트 등록");
		btnhistory.setToolTipText("스크립트 실행이력");
		btndbconfig.setToolTipText("DB 접속설정");
		btnmanager.setToolTipText("관리자 정보");

		toolbar.setFloatable(false);
		toolbar.add(btnlist);
		toolbar.add(btncreate);
		toolbar.add(btnhistory);
		toolbar.add(btndbconfig);
		toolbar.add(btnmanager);

		getContentPane().add(toolbar, BorderLayout.NORTH);

		JPanel		panel_main	= new JPanel();

		BoxLayout	layout_main	= new BoxLayout(panel_main, BoxLayout.X_AXIS);

		main = new EraserMain(this);
		EraserMenu menu = new EraserMenu(main);

		// JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, menu,
		// main);

		// splitPane.setDividerLocation(150);

		// menu.setAlignmentX(Component.LEFT_ALIGNMENT);
		// main.setAlignmentX(Component.LEFT_ALIGNMENT);
		menu.setAlignmentX(Component.TOP_ALIGNMENT);
//		panel_main.add(menu);
//		panel_main.add(main);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// this.add(panel_main);
		this.add(main);
		this.pack();

		this.setSize(800, 660);

		Dimension	dimension	= Toolkit.getDefaultToolkit().getScreenSize();
		int			x			= (int) ((dimension.getWidth() - this.getWidth()) / 2);
		int			y			= (int) ((dimension.getHeight() - this.getHeight()) / 2);
		this.setLocation(x, y);

		this.setVisible(true);

		menu1.addMouseListener(new MouseListener()
		{
			@Override
			public void mouseReleased(MouseEvent e)
			{
			}

			@Override
			public void mousePressed(MouseEvent e)
			{
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
			}

			@Override
			public void mouseEntered(MouseEvent e)
			{
			}

			@Override
			public void mouseClicked(MouseEvent e)
			{
				CardLayout card = (CardLayout) main.getLayout();
				card.show(main, "list");
				EraserList panel = (EraserList) main.getSubPanel("list");
				panel.listrefresh();

			}

		});

		btnlist.addMouseListener(new MouseListener()
		{
			@Override
			public void mouseReleased(MouseEvent e)
			{
			}

			@Override
			public void mousePressed(MouseEvent e)
			{
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
			}

			@Override
			public void mouseEntered(MouseEvent e)
			{
			}

			@Override
			public void mouseClicked(MouseEvent e)
			{
				CardLayout card = (CardLayout) main.getLayout();
				card.show(main, "list");
				EraserList panel = (EraserList) main.getSubPanel("list");
				panel.listrefresh();

			}

		});

		menu2.addMouseListener(new MouseListener()
		{
			@Override
			public void mouseReleased(MouseEvent e)
			{
			}

			@Override
			public void mousePressed(MouseEvent e)
			{
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
			}

			@Override
			public void mouseEntered(MouseEvent e)
			{
			}

			@Override
			public void mouseClicked(MouseEvent e)
			{
				CardLayout card = (CardLayout) main.getLayout();
				card.show(main, "create");
				EraserCreate panel = (EraserCreate) main.getSubPanel("create");
				panel.refresh();
			}

		});

		btncreate.addMouseListener(new MouseListener()
		{
			@Override
			public void mouseReleased(MouseEvent e)
			{
			}

			@Override
			public void mousePressed(MouseEvent e)
			{
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
			}

			@Override
			public void mouseEntered(MouseEvent e)
			{
			}

			@Override
			public void mouseClicked(MouseEvent e)
			{
				CardLayout card = (CardLayout) main.getLayout();
				card.show(main, "create");
				EraserCreate panel = (EraserCreate) main.getSubPanel("create");
				panel.refresh();
			}

		});

		menu3.addMouseListener(new MouseListener()
		{
			@Override
			public void mouseReleased(MouseEvent e)
			{
			}

			@Override
			public void mousePressed(MouseEvent e)
			{
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
			}

			@Override
			public void mouseEntered(MouseEvent e)
			{
			}

			@Override
			public void mouseClicked(MouseEvent e)
			{
				CardLayout card = (CardLayout) main.getLayout();
				card.show(main, "history");
				EraserHistory panel = (EraserHistory) main.getSubPanel("history");
				panel.listrefresh();
			}

		});

		btnhistory.addMouseListener(new MouseListener()
		{
			@Override
			public void mouseReleased(MouseEvent e)
			{
			}

			@Override
			public void mousePressed(MouseEvent e)
			{
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
			}

			@Override
			public void mouseEntered(MouseEvent e)
			{
			}

			@Override
			public void mouseClicked(MouseEvent e)
			{
				CardLayout card = (CardLayout) main.getLayout();
				card.show(main, "history");
				EraserHistory panel = (EraserHistory) main.getSubPanel("history");
				panel.listrefresh();
			}

		});

		menu4.addMouseListener(new MouseListener()
		{
			@Override
			public void mouseReleased(MouseEvent e)
			{
			}

			@Override
			public void mousePressed(MouseEvent e)
			{
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
			}

			@Override
			public void mouseEntered(MouseEvent e)
			{
			}

			@Override
			public void mouseClicked(MouseEvent e)
			{
				CardLayout card = (CardLayout) main.getLayout();
				card.show(main, "config");
				EraserConfig panel = (EraserConfig) main.getSubPanel("config");
				panel.view();

			}

		});

		btndbconfig.addMouseListener(new MouseListener()
		{
			@Override
			public void mouseReleased(MouseEvent e)
			{
			}

			@Override
			public void mousePressed(MouseEvent e)
			{
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
			}

			@Override
			public void mouseEntered(MouseEvent e)
			{
			}

			@Override
			public void mouseClicked(MouseEvent e)
			{
				CardLayout card = (CardLayout) main.getLayout();
				card.show(main, "config");
				EraserConfig panel = (EraserConfig) main.getSubPanel("config");
				panel.view();

			}

		});

		menu5.addMouseListener(new MouseListener()
		{
			@Override
			public void mouseReleased(MouseEvent e)
			{
			}

			@Override
			public void mousePressed(MouseEvent e)
			{
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
			}

			@Override
			public void mouseEntered(MouseEvent e)
			{
			}

			@Override
			public void mouseClicked(MouseEvent e)
			{
				CardLayout card = (CardLayout) main.getLayout();
				card.show(main, "manager");
				EraserManager panel = (EraserManager) main.getSubPanel("manager");
				panel.view();

			}

		});

		btnmanager.addMouseListener(new MouseListener()
		{
			@Override
			public void mouseReleased(MouseEvent e)
			{
			}

			@Override
			public void mousePressed(MouseEvent e)
			{
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
			}

			@Override
			public void mouseEntered(MouseEvent e)
			{
			}

			@Override
			public void mouseClicked(MouseEvent e)
			{
				CardLayout card = (CardLayout) main.getLayout();
				card.show(main, "manager");
				EraserManager panel = (EraserManager) main.getSubPanel("manager");
				panel.view();

			}

		});

	} // EraserGui() End

	/**
	 * 처분프로그램 화면전환
	 *
	 * 메뉴 클릭 이벤트 menu1 : 스크립트 목록 menu2 : 스크립트 등록 menu3 : 스크립트 실행이력 menu4 : DB 접속설정
	 *
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("actionPerformed");

		if(e.getSource() == menu1)
		{
			CardLayout card = (CardLayout) main.getLayout();
			card.show(main, "list");
			EraserList panel = (EraserList) main.getSubPanel("list");
			panel.listrefresh();
		}

		if(e.getSource() == menu2)
		{
			CardLayout card = (CardLayout) main.getLayout();
			card.show(main, "create");
			EraserCreate panel = (EraserCreate) main.getSubPanel("create");
			panel.refresh();
		}

		if(e.getSource() == menu3)
		{
			CardLayout card = (CardLayout) main.getLayout();
			card.show(main, "history");
			EraserHistory panel = (EraserHistory) main.getSubPanel("history");
			panel.listrefresh();
		}

		if(e.getSource() == menu4)
		{
			CardLayout card = (CardLayout) main.getLayout();
			card.show(main, "config");
			EraserConfig panel = (EraserConfig) main.getSubPanel("config");
			panel.view();
		}

	}

	public EraserMain getMain()
	{
		return this.main;
	}
}
