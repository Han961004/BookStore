package javaManageTest;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FrameTest extends JFrame {
	TopUserPanel top1 = new TopUserPanel();
	TopAdminPanel top2 = new TopAdminPanel();
	Container c;
	
	
	
	
	
	
	
	public FrameTest() {
		
		c = getContentPane();
		
		this.setResizable(false);
		this.setTitle("니가와 서점");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.viewScreen(new InfoPanel());
		this.setSize(500, 400);
		this.setVisible(true);
		
	}

	
	void viewScreen(JPanel p) {
		c.removeAll();
		
		add(p);

		c.revalidate();
		c.repaint();
	}
	
	void viewScreen2(JPanel p) {
		c.removeAll();
		add(top1, BorderLayout.NORTH);
		add(p);
		
		c.revalidate();
		c.repaint();
	}
	void viewScreen3(JPanel p) {
		c.removeAll();
		
		add(top2, BorderLayout.NORTH);
		add(p);

		c.revalidate();
		c.repaint();
	}
	
	public static void main(String[] args) {
		new FrameTest();
	}

}
