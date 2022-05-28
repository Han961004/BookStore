package javaManageTest;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

import SQL.connection;

public class SignUpPanel extends JPanel {
	TopUserPanel top = new TopUserPanel();

	SignUpPanel() {

		this.setBackground(Color.white);
		this.setLayout(null);

		
		JLabel lbl1 = new JLabel("아   이   디 :");
		lbl1.setBounds(150, 10, 120, 20);
		JTextField text1 = new JTextField(20);
		text1.setBounds(220, 10, 120, 20);
		
		JLabel lbl2 = new JLabel("비밀번호 :");
		lbl2.setBounds(150, 60, 120, 20);
		JTextField text2 = new JTextField(20);
		text2.setBounds(220, 60, 120, 20);
		
		JLabel lbl0 = new JLabel("이        름 :");
		lbl0.setBounds(150, 110, 120, 20);
		JTextField text0 = new JTextField(20);
		text0.setBounds(220, 110, 120, 20);
		
		JLabel lbl3 = new JLabel("나        이 :");
		lbl3.setBounds(150, 160, 120, 20);
		JTextField text3 = new JTextField(20);
		text3.setBounds(220, 160, 120, 20);
		
		JLabel lbl4 = new JLabel("전화번호 :");
		lbl4.setBounds(150, 210, 120, 20);
		JTextField text4 = new JTextField(20);
		text4.setBounds(220, 210, 120, 20);
		
		JLabel lbl5 = new JLabel("주        소 :");
		lbl5.setBounds(150, 260, 120, 20);
		JTextField text5 = new JTextField(20);
		text5.setBounds(220, 260, 120, 20);

		JButton btn1 = new JButton("회원가입");
		btn1.setBounds(80, 320, 120, 20);

		JButton btn2 = new JButton("돌아가기");
		btn2.setBounds(320, 320, 120, 20);
		

		add(lbl0);
		add(text0);
		add(lbl1);
		add(text1);
		add(lbl2);
		add(text2);
		add(lbl3);
		add(text3);
		add(lbl4);
		add(text4);
		add(lbl5);
		add(text5);
		add(btn1);
		add(btn2);

		
		
		
		ActionListener listener1 = e -> {
			
			JButton btn = (JButton) e.getSource();
			__FrameTest__ test = (__FrameTest__) btn.getTopLevelAncestor();
			
			if(e.getSource() == btn1) {			// 회원가입 누르면
				
				String id = text1.getText();
				String pw = text2.getText();
				String age = text3.getText();
				String address = text5.getText();
				String tel = text4.getText();
				String uname = text0.getText();
				
				Connection con = connection.makeConnection();
	    		String sql = null;
	    		 
	    		PreparedStatement pstmt = null;
	    		
	    		sql = "insert into members values (?,?,?,?,?,?);";
	    		try {
	    			pstmt = con.prepareStatement(sql);
	    			pstmt.setString(1, id);
	    			pstmt.setString(2, pw);
	    			pstmt.setString(3, uname);
	    			pstmt.setString(4, age);
	    			pstmt.setString(5, tel);
	    			pstmt.setString(6, address);
	    			pstmt.execute();
	    			
	    			// 확인 메세지
	    			JOptionPane.showMessageDialog(this, "회원 가입 성공", "가입성공", 1);
	    			
	    			test.viewScreen(new InfoPanel());
					
				} catch (SQLException e1) {
					// 실패 메세지
					JOptionPane.showMessageDialog(this, "회원 가입 실패", "가입실패", 0);
					
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if(e.getSource() == btn2) {
				// 그냥 이전으로 돌아가기 
				test.viewScreen(new InfoPanel());
			}
		};
		btn1.addActionListener(listener1);
		btn2.addActionListener(listener1);
	}
}