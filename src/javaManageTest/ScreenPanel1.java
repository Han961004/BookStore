package javaManageTest;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ScreenPanel1 extends JPanel {
	ScreenPanel1(){
		this.setBackground(Color.white);
		
		JLabel l1 = new JLabel("���� �˻� : ");
		JTextField tf1=new JTextField(20);
		JButton btn1 = new JButton("�˻�");
		
		add(l1);
		add(tf1);
		add(btn1);
		
	}
}
