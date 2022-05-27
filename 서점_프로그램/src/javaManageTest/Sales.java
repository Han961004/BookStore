package javaManageTest;

import java.awt.Color;
import java.awt.Frame;
import java.awt.List;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import SQL.connection;

public class Sales extends JPanel {
	Sales() {

		this.setBackground(Color.white);
		JLabel l2 = new JLabel("월 매출 검색 : ");
		JTextField tf1 = new JTextField(20);
		JButton btn1 = new JButton("검색");
		Panel p = new Panel();
		p.setLayout(null);
		p.setSize(450, 400);

		List li = new List();
		li.setBounds(0, 20, 450, 250);
		li.removeAll(); // 리스트 내용을 전부 제거한다.

		

		add(l2);
		add(tf1);
		add(btn1);
		p.add(li);
		add(p);
		
		
		this.setVisible(true);
	}

	
	
	
	public static void main(String [] args) {
		new Sales();
	}
}
