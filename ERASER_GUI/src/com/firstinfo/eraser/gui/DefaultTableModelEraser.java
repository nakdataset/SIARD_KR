package com.firstinfo.eraser.gui;

import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 * 테이블 생성
 * 
 * @author 국가기록원
 *
 */
public class DefaultTableModelEraser extends DefaultTableModel
{

	public DefaultTableModelEraser(String data[][], String column[])
	{
		super(data, column);
	}

	public DefaultTableModelEraser(Object data[][], String column[])
	{
		super(data, column);
	}

	@Override
	public Class getColumnClass(int column)
	{
		switch (column)
		{
			case 6:
				return ImageIcon.class;
			default:
				return String.class;
		}
	}

	@Override
	public boolean isCellEditable(int row, int column)
	{
		// all cells false
		return false;
	}
}
