package com.firstinfo.eraser.gui;

import java.awt.CardLayout;

import javax.swing.JPanel;

/**
 * 처분 프로그램 화면 초기화 및 화면 호출
 * 
 * @author 국가기록원
 *
 */
public class EraserMain extends JPanel
{
	CardLayout		layout	= null;

	EraserList		list	= null;
	EraserCreate	create	= null;
	EraserHistory	history	= null;
	EraserConfig	config	= null;
	EraserView		view	= null;
	EraserManager	manager	= null;

	EraserGui		gui		= null;

	EraserMain(EraserGui gui)
	{
		this.gui	= gui;
		layout		= new CardLayout();
		this.setLayout(layout);

		list	= new EraserList(this);
		create	= new EraserCreate();
		history	= new EraserHistory(gui);
		config	= new EraserConfig();
		view	= new EraserView(gui);
		manager	= new EraserManager();

		this.add("list", list);
		this.add("create", create);
		this.add("history", history);
		this.add("config", config);
		this.add("view", view);
		this.add("manager", manager);
	}

	public JPanel getSubPanel(String str)
	{
		if(str.equals("list"))
		{
			return list;
		}

		if(str.equals("create"))
		{
			return create;
		}

		if(str.equals("history"))
		{
			return history;
		}

		if(str.equals("config"))
		{
			return config;
		}

		if(str.equals("view"))
		{
			return view;
		}

		if(str.equals("manager"))
		{
			return manager;
		}

		return null;
	}
}
