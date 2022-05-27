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

import SQL.connection;

public class MemberFix extends JPanel {
	
	// 새창에 수정하기 JFrame
	JTextField text, text1, text2, text3, text4, text5;
	
	MemberFix(){
		
		JFrame window = new JFrame("고객정보 수정");
	    window.setBounds(800, 100, 500, 400);
	    window.setResizable(false);
	    window.setBackground(Color.white);
	    window.setLayout(null);
		
		JLabel lbl = new JLabel("수정 할 사 람 :");
		lbl.setBounds(130, 50, 120, 20);
		text = new JTextField(30);
		text.setBounds(220, 50, 120, 20);
	
		JLabel lbl1 = new JLabel("아   이   디 :");
		lbl1.setBounds(150, 90, 120, 20);
		text1 = new JTextField(20);
		text1.setBounds(220, 90, 120, 20);
		
		JLabel lbl2 = new JLabel("패스워드 :");
		lbl2.setBounds(150, 130, 120, 20);
		text2 = new JTextField(20);
		text2.setBounds(220, 130, 120, 20);
		
		JLabel lbl3 = new JLabel("나        이 :");
		lbl3.setBounds(150, 170, 120, 20);
		text3 = new JTextField(20);
		text3.setBounds(220, 170, 120, 20);
		
		JLabel lbl4 = new JLabel("휴대전화 :");
		lbl4.setBounds(150, 210, 120, 20);
		text4 = new JTextField(20);
		text4.setBounds(220, 210, 120, 20);
		
		JLabel lbl5 = new JLabel("주        소 :");
		lbl5.setBounds(150, 250, 120, 20);
		text5 = new JTextField(20);
		text5.setBounds(220, 250, 120, 20);
	
		JButton btn5 = new JButton("확인");
		btn5.setBounds(350, 50, 90, 20);
	
		JButton btn6 = new JButton("수정완료");
		btn6.setBounds(80, 290, 120, 20);
		
		JButton btn7 = new JButton("삭제하기");
		btn7.setBounds(320, 290, 120, 20);
		
		
		window.add(lbl);
		window.add(text);
		window.add(lbl1);
		window.add(text1);
		window.add(lbl2);
		window.add(text2);
		window.add(lbl3);
		window.add(text3);
		window.add(lbl4);
		window.add(text4);
		window.add(lbl5);
		window.add(text5);
		window.add(btn5);
		window.add(btn6);
		window.add(btn7);
	    
	    window.setVisible(true);
	    
	    
	    ActionListener listener1 = e -> {
			
	    	String uname = text.getText();
			String id = text1.getText();
			String pw = text2.getText();
			String age = text3.getText();
			String tel = text4.getText();
			String address = text5.getText();
			
			if(e.getSource() == btn5) {			// 회원가입 누르면
				
				
				Connection con = connection.makeConnection();
	    		String sql = null;
	    		ResultSet rs = null; 
	    		PreparedStatement pstmt = null;
	    		
	    		
	    		try {
	    			sql = "select * from members where uname = '" + uname + "';";
		    		pstmt = con.prepareStatement(sql);
		    		rs = pstmt.executeQuery();
		    		rs.next();
		    		text1.setText(rs.getNString(1));
		    		text2.setText(rs.getNString(2));
					text3.setText(rs.getNString(4));
					text4.setText(rs.getNString(5));
					text5.setText(rs.getNString(6));
					
					JOptionPane.showMessageDialog(this, "조회 성공", "조회성공", 1);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(this, "조회 실패", "조회성공", 0);
					e1.printStackTrace();
				}
			} else if(e.getSource() == btn6) {
				
				Connection con = connection.makeConnection();
	    		String sql = null;
	    		PreparedStatement pstmt = null;
	    		
	    		sql = "update members set id = ?, pw = ?, age = ?, tel = ?, address = ? where (uname = ?);";
	    		try {
	    			
	    			pstmt = con.prepareStatement(sql);
	    			pstmt.setString(1, id);
	    			pstmt.setString(2, pw);
	    			pstmt.setString(3, age);
	    			pstmt.setString(4, tel);
	    			pstmt.setString(5, address);
	    			pstmt.setString(6, uname);
	    			pstmt.execute();
	    			
	    			JOptionPane.showMessageDialog(this, "갱신 성공", "갱신성공", 1);
	    		} catch (SQLException e1) {
	    			JOptionPane.showMessageDialog(this, "갱신 실패", "갱신성공", 0);
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if(e.getSource() == btn7) {
				
				Connection con = connection.makeConnection();
	    		String sql = null;
	    		PreparedStatement pstmt = null;
	    		
	    		sql = "delete from members where uname = ?;";
	    		
	    		try {
	    			pstmt = con.prepareStatement(sql);
	    			pstmt.setString(1, uname);
	    			
	    			pstmt.execute();
	    			
	    			JOptionPane.showMessageDialog(this, "삭제 성공", "삭제성공", 1);
	    		}catch(SQLException e11) {
	    			JOptionPane.showMessageDialog(this, "삭제 실패", "삭제실패", 0);
	    		}
			}
		};
		btn5.addActionListener(listener1);
		btn6.addActionListener(listener1);
		btn7.addActionListener(listener1);
	}
}