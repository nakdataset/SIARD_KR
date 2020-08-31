package com.firstinfo.eraser.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Hashtable;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.UIManager;

import com.firstinfo.eraser.service.EraserService;
import com.firstinfo.eraser.serviceimpl.EraserServiceImpl;

public class EraserLogin extends JDialog implements ActionListener, KeyListener
{
	JLabel			label		= new JLabel("암호");
	JPasswordField	password	= new JPasswordField();

	JButton			btnOk		= new JButton("로그인");
	JButton			btnCancel	= new JButton("취소");

	public EraserLogin()
	{
		
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JPanel paneltop = new JPanel();
		paneltop.setLayout(new BoxLayout(paneltop, BoxLayout.X_AXIS));
		paneltop.add(Box.createRigidArea(new Dimension(10, 10)));
		paneltop.add(label);
		paneltop.add(Box.createRigidArea(new Dimension(10, 10)));
		password.setPreferredSize(new Dimension(80, 20));
		paneltop.add(password);
		paneltop.add(Box.createRigidArea(new Dimension(10, 10)));

		JPanel panelbtn = new JPanel();
		panelbtn.setLayout(new BoxLayout(panelbtn, BoxLayout.X_AXIS));
		panelbtn.add(btnOk);
		panelbtn.add(Box.createRigidArea(new Dimension(10, 10)));
		panelbtn.add(btnCancel);

		panel.add(Box.createRigidArea(new Dimension(10, 10)));
		panel.add(paneltop);
		panel.add(Box.createRigidArea(new Dimension(5, 5)));
		panel.add(panelbtn);
		panel.add(Box.createRigidArea(new Dimension(10, 10)));

		btnOk.addActionListener(this);
		btnCancel.addActionListener(this);
		password.addKeyListener(this);

		this.setTitle("국가 기록원 처분 스크립트 로그인");
		this.add(panel);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.pack();

		this.setResizable(false);
		this.setSize(320, 110);

		Dimension	dimension	= Toolkit.getDefaultToolkit().getScreenSize();
		int			x			= (int) ((dimension.getWidth() - this.getWidth()) / 2);
		int			y			= (int) ((dimension.getHeight() - this.getHeight()) / 2);
		this.setLocation(x, y);

		this.setVisible(true);
	}

	public void login()
	{
		EraserService	service		= new EraserServiceImpl();
		Hashtable		hash		= service.managerview();
		String			strpassword	= (String) hash.get("password");

//		EraserGui gui = new EraserGui();
//		this.show(false);

		if(strpassword.equals(password.getText()))
		{
			EraserGui gui = new EraserGui();
			this.show(false);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "암호가 틀렸습니다.");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == btnOk)
		{
			login();
		}
		else if(e.getSource() == btnCancel)
		{
			System.exit(1);
		}
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if(e.getSource() == password && e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			login();
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
	}

	public static void main(String args[])
	{
		EraserLogin login = new EraserLogin();
	}
}
