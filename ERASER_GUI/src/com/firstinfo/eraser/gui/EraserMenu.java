package com.firstinfo.eraser.gui;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * 처분 프로그램 메뉴 생성 및 이벤트 작성
 * 
 * @author 국가기록원
 *
 */
public class EraserMenu extends JPanel implements ActionListener
{
	JButton		btn1			= null;
	JButton		btn2			= null;
	JButton		btn3			= null;
	JButton		btn4			= null;
	JButton		btn5			= null;

	EraserMain	panel_main		= null;

	private int	btn_position_x	= 0;
	private int	btn_position_y	= 0;

	private int	btn_width		= 80;
	private int	btn_height		= 20;

	EraserMenu(EraserMain panel)
	{
		this.panel_main = panel;

		BoxLayout layout_menu = new BoxLayout(this, BoxLayout.Y_AXIS);

		this.setLayout(layout_menu);
		Dimension btn_size = new Dimension(300, 25);

		btn1	= new JButton("스크립트 목록");
		btn2	= new JButton("스크립트 등록");
		btn3	= new JButton("스크립트 실행이력");
		btn4	= new JButton("DB 접속 설정");
		btn5	= new JButton("관리자 정보");

		btn1.setMaximumSize(btn_size);
		btn2.setMaximumSize(btn_size);
		btn3.setMaximumSize(btn_size);
		btn4.setMaximumSize(btn_size);
		btn5.setMaximumSize(btn_size);

		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);

		this.setAlignmentY(0f);

		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
		this.add(btn4);
		this.add(btn5);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// 액션 리스너 재정의
		if(e.getSource().equals(btn1)) // list
		{
			CardLayout card = (CardLayout) this.panel_main.getLayout();
			card.show(panel_main, "list");
			EraserList panel = (EraserList) panel_main.getSubPanel("list");
			panel.listrefresh();
		}
		else if(e.getSource().equals(btn2)) // create
		{
			CardLayout card = (CardLayout) this.panel_main.getLayout();
			card.show(panel_main, "create");
			EraserCreate panel = (EraserCreate) panel_main.getSubPanel("create");
			panel.refresh();

		}
		else if(e.getSource().equals(btn3)) // history
		{
			CardLayout card = (CardLayout) this.panel_main.getLayout();
			card.show(panel_main, "history");
			EraserHistory panel = (EraserHistory) panel_main.getSubPanel("history");
			panel.listrefresh();
		}
		else if(e.getSource().equals(btn4)) // dbconfig
		{
			CardLayout card = (CardLayout) this.panel_main.getLayout();
			card.show(panel_main, "config");
			EraserConfig panel = (EraserConfig) panel_main.getSubPanel("config");
			panel.view();
		}
		else if(e.getSource().equals(btn5)) // dbconfig
		{
			CardLayout card = (CardLayout) this.panel_main.getLayout();
			card.show(panel_main, "manager");
			EraserManager panel = (EraserManager) panel_main.getSubPanel("manager");
			panel.view();
		}
	}
}
