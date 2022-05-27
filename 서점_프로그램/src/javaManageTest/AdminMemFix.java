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

public class AdminMemFix {
	__TopUserPanel top = new __TopUserPanel();
	
	// 새창에 수정하기 JFrame
	JTextField text, text1, text2, text3, text4, text5;
	
	AdminMemFix(){
		JFrame window = new JFrame();
	    window.setBounds(800, 100, 500, 400);
	    
	    window.setBackground(Color.white);
	    window.setLayout(null);
		
		JLabel lbl = new JLabel("수정 할 사 람 :");
		lbl.setBounds(130, 20, 120, 20);
		text = new JTextField(30);
		text.setBounds(220, 20, 120, 20);
	
		JLabel lbl1 = new JLabel("저        자 :");
		lbl1.setBounds(150, 60, 120, 20);
		text1 = new JTextField(20);
		text1.setBounds(220, 60, 120, 20);
		
		JLabel lbl2 = new JLabel("제        목 :");
		lbl2.setBounds(150, 100, 120, 20);
		text2 = new JTextField(20);
		text2.setBounds(220, 100, 120, 20);
		
		JLabel lbl3 = new JLabel("출  판  사 :");
		lbl3.setBounds(150, 140, 120, 20);
		text3 = new JTextField(20);
		text3.setBounds(220, 140, 120, 20);
		
		JLabel lbl4 = new JLabel("가        격 :");
		lbl4.setBounds(150, 180, 120, 20);
		text4 = new JTextField(20);
		text4.setBounds(220, 180, 120, 20);
		
		JLabel lbl5 = new JLabel("재        고 :");
		lbl5.setBounds(150, 220, 120, 20);
		text5 = new JTextField(20);
		text5.setBounds(220, 220, 120, 20);
	
		JButton btn5 = new JButton("확인");
		btn5.setBounds(350, 20, 90, 20);
	
		JButton btn6 = new JButton("수정완료");
		btn6.setBounds(80, 260, 120, 20);
		
		JButton btn7 = new JButton("삭제하기");
		btn7.setBounds(320, 260, 120, 20);
		
		
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
			
			String bnum = text.getText();
			String bname = text2.getText();
			String author = text1.getText();
			String publisher = text3.getText();
			String price = text4.getText();
			String stock = text5.getText();
			
			if(e.getSource() == btn5) {			// 회원가입 누르면
				
				Connection con = connection.makeConnection();
	    		String sql = null;
	    		ResultSet rs = null; 
	    		PreparedStatement pstmt = null;
	    		
	    		
	    		try {
	    			sql = "select * from books where bnum = '" + bnum + "';";
		    		pstmt = con.prepareStatement(sql);
		    		rs = pstmt.executeQuery();
		    		
		    		rs.next();
		    		text1.setText(rs.getNString(2));
		    		text2.setText(rs.getNString(3));
					text3.setText(rs.getNString(4));
					text4.setText(rs.getNString(5));
					text5.setText(rs.getNString(6));
	    			
	    			
	    			JOptionPane.showMessageDialog(this, "책 불러오기 성공", "등록성공", 1);
					
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(this, "책 불러오기 실패", "등록실패", 0);
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    		// 다시입력 초기화 버튼
			} else if(e.getSource() == btn6) {
				
				Connection con = connection.makeConnection();
	    		String sql = null;
	    		PreparedStatement pstmt = null;
	    		
	    		sql = "update books set bname = ?, author = ?, publisher = ?, price = ?, stock = ? where (bnum = ?);";
	    		try {
	    			
	    			pstmt = con.prepareStatement(sql);
	    			pstmt.setString(1, bname);
	    			pstmt.setString(2, author);
	    			pstmt.setString(3, publisher);
	    			pstmt.setString(4, price);
	    			pstmt.setString(5, stock);
	    			pstmt.setString(6, bnum);
	    			pstmt.execute();
	    			
	    			JOptionPane.showMessageDialog(this, "책 수정 성공", "수정성공", 1);
					
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(this, "책 수정 실패", "수정실패", 0);
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if(e.getSource() == btn7) {
				
				Connection con = connection.makeConnection();
	    		String sql = null;
	    		PreparedStatement pstmt = null;
	    		
	    		sql = "delete from books where bnum = ?;";
	    		
	    		try {
	    			pstmt = con.prepareStatement(sql);
	    			pstmt.setString(1, bnum);
	    			
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