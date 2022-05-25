package javaManageTest;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javaManageTest.LoginPanel.MyActionListener;

public class Booklist extends JPanel {
	Booklist() {
		this.setBackground(Color.white);
		
		JLabel l1 = new JLabel("도서 목록");
		
		MyActionListener l = new MyActionListener();
		
		add(l1);
		
	}
	
	class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			JButton btn = (JButton) e.getSource();

			FrameTest test = (FrameTest) btn.getTopLevelAncestor();

			switch (btn.getText()) {
			case "검색":

				break;

			}
		}
	}
}
