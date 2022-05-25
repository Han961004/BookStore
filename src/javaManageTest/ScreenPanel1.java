package javaManageTest;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ScreenPanel1 extends JPanel {
	ScreenPanel1(){
		this.setBackground(Color.white);
		
		JLabel l1 = new JLabel("도서 검색 : ");
		JTextField tf1=new JTextField(20);
		JButton btn1 = new JButton("검색");
		
		add(l1);
		add(tf1);
		add(btn1);
		
	}
}
