package javaManageTest;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javaManageTest.LoginPanel.MyActionListener;

public class BookSearch extends JPanel {
	BookSearch(){
		this.setBackground(Color.white);
		
		JLabel l1 = new JLabel("���� �˻� : ");
		JTextField tf1=new JTextField(20);
		JButton btn1 = new JButton("�˻�");
		MyActionListener l = new MyActionListener();
		btn1.addActionListener(l);
		add(l1);
		add(tf1);
		add(btn1);
		
	}
	class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			JButton btn = (JButton) e.getSource();

			FrameTest test = (FrameTest) btn.getTopLevelAncestor();
			
			switch (btn.getText()) {
			case "�˻�":
				
				break;
			
			}
		}
	}
}
