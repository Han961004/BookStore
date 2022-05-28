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
import javax.swing.JTextArea;
import javax.swing.JTextField;

import SQL.connection;

public class OrderFix extends JFrame{

	// 새창에 수정하기 JFrame
	JTextField text, text1, text2;
	
	OrderFix(){
		
		JFrame window = new JFrame("주문정보 수정");
	    window.setBounds(800, 100, 500, 400);
	    window.setResizable(false);
	    window.setBackground(Color.white);
	    window.setLayout(null);
		
		JLabel lbl = new JLabel("주문번호 :");
		lbl.setBounds(150, 50, 120, 20);
		text = new JTextField(30);
		text.setBounds(220, 50, 120, 20);
	
		JLabel lbl1 = new JLabel("받는사람 :");
		lbl1.setBounds(150, 90, 120, 20);
		text1 = new JTextField(20);
		text1.setBounds(220, 90, 120, 20);
		
		JLabel lbl2 = new JLabel("휴대전화 :");
		lbl2.setBounds(150, 130, 120, 20);
		text2 = new JTextField(20);
		text2.setBounds(220, 130, 120, 20);
		
		JLabel lbl3 = new JLabel("받는주소 :");
		lbl3.setBounds(120, 170, 120, 20);
		JTextArea text3 = new JTextArea();
		text3.setBounds(190, 170, 180, 100);
	
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
		window.add(btn5);
		window.add(btn6);
		window.add(btn7);
	    
	    window.setVisible(true);
	    
	    
	    ActionListener listener1 = e -> {
			
	    	String onum = text.getText();
			String person = text1.getText();
			String tel = text2.getText();
			String address = text3.getText();
			
			if(e.getSource() == btn5) {			// 회원가입 누르면
				
				
				Connection con = connection.makeConnection();
	    		String sql = null;
	    		ResultSet rs = null; 
	    		PreparedStatement pstmt = null;
	    		
	    		
	    		try {
	    			sql = "select * from orders where onum = '" + onum + "';";
		    		pstmt = con.prepareStatement(sql);
		    		rs = pstmt.executeQuery();
		    		rs.next();
		    		text1.setText(rs.getNString(4));
		    		text2.setText(rs.getNString(6));
					text3.setText(rs.getNString(5));
					
					JOptionPane.showMessageDialog(this, "조회 성공", "조회성공", 1);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(this, "조회 실패", "조회성공", 0);
					e1.printStackTrace();
				}
			} else if(e.getSource() == btn6) {
				
				Connection con = connection.makeConnection();
	    		String sql = null;
	    		PreparedStatement pstmt = null;
	    		
	    		sql = "update orders set person = ?, tel = ?, address = ? where (onum = ?);";
	    		try {
	    			
	    			pstmt = con.prepareStatement(sql);
	    			pstmt.setString(1, person);
	    			pstmt.setString(2, tel);
	    			pstmt.setString(3, address);
	    			pstmt.setString(4, onum);
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
	    		
	    		sql = "delete from orders where onum = ?;";
	    		
	    		try {
	    			pstmt = con.prepareStatement(sql);
	    			pstmt.setString(1, onum);
	    			
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

