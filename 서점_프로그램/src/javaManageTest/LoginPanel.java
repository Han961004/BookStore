package javaManageTest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
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

import SQL.connection;
import javaManageTest.InfoPanel.MyActionListener;

public class LoginPanel extends JPanel {
	
	InfoSave info = new InfoSave();
	
	JLabel img = new JLabel();
	
	LoginPanel() {

		this.setBackground(Color.white);
		this.setLayout(null);

		JLabel lbl1 = new JLabel("아   이   디 :");
		lbl1.setBounds(150, 30, 120, 20);
		JTextField text1 = new JTextField(20);
		text1.setBounds(220, 30, 120, 20);
		
		JLabel lbl2 = new JLabel("비밀번호 :");
		lbl2.setBounds(150, 70, 120, 20);
		JTextField text2 = new JTextField(20);
		text2.setBounds(220, 70, 120, 20);

		JButton btn1 = new JButton("사용자 로그인");
		btn1.setBounds(80, 150, 120, 20);
		JButton btn2 = new JButton("관리자 로그인");
		btn2.setBounds(200, 150, 120, 20);
		JButton btn3 = new JButton("돌아가기");
		btn3.setBounds(320, 150, 120, 20);
		
		
		add(lbl1);
		add(text1);
		add(lbl2);
		add(text2);
		add(btn1);
		add(btn2);
		add(btn3);
		
		
		
		ActionListener listener1 = e -> {
			
			
			// 패스워드 어디감???????????????????????
			
			JButton btn = (JButton) e.getSource();
			__FrameTest__ test = (__FrameTest__) btn.getTopLevelAncestor();
			String id = text1.getText();
			String pw = text2.getText();
			
			// 사용자 로그인 누르면
			if(e.getSource() == btn1) {			
				
				Connection con = connection.makeConnection();
	    		String sql = null;
	    		ResultSet rs = null; 
	    		PreparedStatement pstmt = null;
	    		
	    		sql = "select * from members where id = (?) ;";
	    		
	    		try {
	    			pstmt = con.prepareStatement(sql);
	    			pstmt.setString(1, id);
	    			rs = pstmt.executeQuery();
	    			
	    			
	    			if (rs.next()) {
	    				if (rs.getString(1).contentEquals(id)) {
	    					
	    					info.setPublicid(id);
	    					
	    					JOptionPane.showMessageDialog(this, "회원 로그인 성공", "로그인성공", 1); // 로그인 성공
	    					
	    					test.viewScreen2(new UserPanel());
	    				}
	    				else {
	    					JOptionPane.showMessageDialog(this, "비밀번호를 재확인 해주세요", "로그인실패", 0); // 비밀번호 불일치
	    				}
	    			} else {
	    				JOptionPane.showMessageDialog(this, "회원 아이디를 확인해주세요", "로그인실패", 0); // 아이디가 없음
	    			}
	    			
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(this, "오류", "꿹뷁휅훎", 0);
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
// 관리자 누르면
			else if(e.getSource() == btn2) {			
				
				Connection con = connection.makeConnection();
	    		String sql = null;
	    		ResultSet rs = null; 
	    		PreparedStatement pstmt = null;
	    		
	    		sql = "select * from admins where id = (?);";
	    		
	    		try {
	    			pstmt = con.prepareStatement(sql);
	    			pstmt.setString(1, id);
	    			rs = pstmt.executeQuery();
	    			
	    			if (rs.next()) {
	    				if (rs.getString(1).contentEquals(id)) {
	    					JOptionPane.showMessageDialog(this, "관리자 로그인 성공", "로그인성공", 1); // 로그인 성공
	    					test.viewScreen3(new AdminPanel());
	    				}
	    				else {
	    					JOptionPane.showMessageDialog(this, "비밀번호를 재확인 해주세요", "로그인실패", 0); // 비밀번호 불일치
	    				}
	    			} else {
	    				JOptionPane.showMessageDialog(this, "관리자 아이디를 확인해주세요", "로그인실패", 0); // 아이디가 없음
	    			}
	    			
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(this, "오류", "꿹뷁휅훎", 0);
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
// 돌아가기 누르면
			else if(e.getSource() == btn3) {			
				test.viewScreen(new InfoPanel());
			}
		};
		
		btn1.addActionListener(listener1);
		btn2.addActionListener(listener1);
		btn3.addActionListener(listener1);
		
	}
}
