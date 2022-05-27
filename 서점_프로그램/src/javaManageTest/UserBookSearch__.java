package javaManageTest;

import java.awt.Color;
import java.awt.List;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import SQL.connection;

public class UserBookSearch__ extends JPanel {
	
	UserBookSearch__(){
		JLabel l1 = new JLabel("도서 검색 : ");
		JTextField tf1 = new JTextField(20);
		JButton btn1 = new JButton("검색");
		
		Panel p = new Panel();
		p.setLayout(null);
		p.setSize(450, 400);
		
		JTextArea li = new JTextArea();
		li.setBounds(0,0,450,280);
		li.removeAll(); // 리스트 내용을 전부 제거한다.
		li.setEnabled(false);
		
		add(l1);
		add(tf1);
		add(btn1);
		p.add(li);
		add(p);
		
		
		ActionListener listener1 = e -> {
			
			if(e.getSource() == btn1) {
				
				String bnum = tf1.getText();
				
				Connection con = connection.makeConnection();
	    		String sql = null;
	    		ResultSet rs = null; 
	    		PreparedStatement pstmt = null;
	    		
	    		sql = "select * from books where bnum = '" + bnum + "';";
	    		
	    		
	    		try {
					pstmt = con.prepareStatement(sql);
					rs = pstmt.executeQuery();
		    		
					rs.next();
					
		    		li.setText("책번호 : " + rs.getNString(1) + "\n"
		    				+ "책저자 : " + rs.getNString(2) + "\n"
		    				+ "책이름 : " + rs.getNString(3) + "\n"
		    				+ "출판사 : " + rs.getNString(4) + "\n"
		    				+ "가 격 : " + rs.getNString(5) + "\n"
		    				+ "재 고 : " + rs.getNString(6) + "\n"
		    				);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					li.setText("번호확인");
					e1.printStackTrace();
				}
			}
		};
		btn1.addActionListener(listener1);
		
	}
}
