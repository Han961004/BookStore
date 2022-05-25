package javaManageTest;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameTest extends JFrame {
	TopPanel top = new TopPanel();
	Container c;

	FrameTest() {
		this.setTitle("니가와 서점");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c = getContentPane();
		this.viewScreen(new InfoPanel());
		this.setSize(500, 300);
		this.setVisible(true);

	}

	void viewScreen(JPanel p) {
		c.removeAll();
		
//		add(top, BorderLayout.NORTH);
		add(p);

		c.revalidate();
	}

	public static void main(String[] args) {
		new FrameTest();
	}

}
