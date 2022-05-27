package javaManageTest;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javaManageTest.*;
import SQL.connection;

public class BookAdd extends JPanel {
	
	
	// 새창에 수정하기 JFrame
	JTextField text, text1, text2, text3, text4, text5;
		
	BookAdd(){
		
		JFrame window1 = new JFrame("도서 추가");
	    window1.setBounds(800, 100, 500, 400);
	    window1.setResizable(false);
	    window1.setBackground(Color.white);
	    window1.setLayout(null);
		
		JLabel lbl = new JLabel("책   번   호 :");
		lbl.setBounds(150, 50, 120, 20);
		text = new JTextField(30);
		text.setBounds(220, 50, 120, 20);
	
		JLabel lbl1 = new JLabel("책   제   목 :");
		lbl1.setBounds(150, 90, 120, 20);
		text1 = new JTextField(20);
		text1.setBounds(220, 90, 120, 20);
		
		JLabel lbl2 = new JLabel("저        자 :");
		lbl2.setBounds(150, 130, 120, 20);
		text2 = new JTextField(20);
		text2.setBounds(220, 130, 120, 20);
		
		JLabel lbl3 = new JLabel("출    판   사 :");
		lbl3.setBounds(150, 170, 120, 20);
		text3 = new JTextField(20);
		text3.setBounds(220, 170, 120, 20);
		
		JLabel lbl4 = new JLabel("가        격 :");
		lbl4.setBounds(150, 210, 120, 20);
		text4 = new JTextField(20);
		text4.setBounds(220, 210, 120, 20);
		
		JLabel lbl5 = new JLabel("재        고 :");
		lbl5.setBounds(150, 250, 120, 20);
		text5 = new JTextField(20);
		text5.setBounds(220, 250, 120, 20);
	
		JButton btn6 = new JButton("완    료");
		btn6.setBounds(220, 290, 120, 20);
		
		
		window1.add(lbl);
		window1.add(text);
		window1.add(lbl1);
		window1.add(text1);
		window1.add(lbl2);
		window1.add(text2);
		window1.add(lbl3);
		window1.add(text3);
		window1.add(lbl4);
		window1.add(text4);
		window1.add(lbl5);
		window1.add(text5);
		window1.add(btn6);
	    
	    window1.setVisible(true);
	    
	    
	    ActionListener listener1 = e -> {
			
	    	String bnum = text.getText();
			String bname = text1.getText();
			String author = text2.getText();
			String publisher = text3.getText();
			String price = text4.getText();
			String stock = text5.getText();
			
			
			if(e.getSource() == btn6) {			// 완료 누르면
				
				Connection con = connection.makeConnection();
	    		String sql = null;
	    		PreparedStatement pstmt = null;
	    		
	    		try {
	    			sql = "insert into books values (?,?,?,?,?,?);";
	    			pstmt = con.prepareStatement(sql);
	    			pstmt.setString(1, bnum);
	    			pstmt.setString(2, bname);
	    			pstmt.setString(3, author);
	    			pstmt.setString(4, publisher);
	    			pstmt.setString(5, price);
	    			pstmt.setString(6, stock);
	    			pstmt.execute();
	    			
	    			// 확인 메세지
	    			JOptionPane.showMessageDialog(this, "추가 성공", "추가성공", 1);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(this, "책 번호가 중복입니다", "추가실패", 0);
					e1.printStackTrace();
				}
			}
		};
		btn6.addActionListener(listener1);
	}
}

