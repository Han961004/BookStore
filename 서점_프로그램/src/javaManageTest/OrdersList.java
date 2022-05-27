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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import SQL.connection;

public class OrdersList extends JPanel {
	
	
	OrdersList() {
		this.setBackground(Color.white);
		JLabel l2 = new JLabel("회원이름 : ");
		JTextField tf1 = new JTextField(10);
		JButton btn1 = new JButton("검색");
		JButton btn2 = new JButton("목록");
		
		Panel p = new Panel();
		p.setLayout(null);
		p.setSize(450, 400);

		List li = new List();
		li.setBounds(0, 20, 450, 250);
		li.removeAll(); // 리스트 내용을 전부 제거한다.

		
		
		try{
        	Connection con = connection.makeConnection();
    		String sql = null;
    		ResultSet rs = null; 
    		PreparedStatement pstmt = null;
    		
    		sql = "select * from orders";
    		pstmt = con.prepareStatement(sql);
    		
    		rs = pstmt.executeQuery();
    		while (rs.next()) {
    			String str = rs.getNString(1) + "  /  " + rs.getNString(3) + "  /  " + rs.getNString(2);
                li.add(str); // 리스트에 데이터를 추가한다.
    		}

        }catch(SQLException sqle){
			JOptionPane.showMessageDialog(this, "책 불러오기 성공", "등록성공", 0);
        }
		
		
		
		add(l2);
		add(tf1);
		add(btn1);
		add(btn2);
		p.add(li);
		add(p);

		ActionListener listener1 = e -> {
			
			String uname = tf1.getText();
			
			if(e.getSource() == btn1) {	
				
				Connection con = connection.makeConnection();
	    		String sql = null;
	    		ResultSet rs = null; 
	    		PreparedStatement pstmt = null;

    			sql = "select * from orders where uname = '" + uname + "' ;";
	    		
	    		try {
		    		pstmt = con.prepareStatement(sql);
		    		rs = pstmt.executeQuery();
		    		
		    		if (rs.next()) {
	    				if (rs.getString(4).contentEquals(uname)) {
	    					
	    					li.removeAll();				// 버튼 누를 때 마다 리스트 초기화
	    					
	    					// 밑에랑 합치면 첫번 째 튜플 안나옴			if (rs.next()) 에서 이미 한번 써버려서 
	    					String str = "번호 : " + rs.getNString(1) + "  /  " + "책 번호 : " + rs.getNString(2) + "  /  " + "수취인 : " + rs.getNString(4) + "(" + rs.getNString(5) + ")" + "  /  " + "수량 : " + rs.getNString(6);	
	    					li.add(str);
	    					
	    					while(rs.next()) {
		    					String str1 = "번호 : " + rs.getNString(1) + "  /  " + "책 번호 : " + rs.getNString(2) + "  /  " + "수취인 : " + rs.getNString(4) + "("  + rs.getNString(5) + ")" + "  /  " + "수량 : " + rs.getNString(6);
								li.add(str1); // 리스트에 데이터를 추가한다.
	    					}
	    					JOptionPane.showMessageDialog(this, "주문 불러오기 성공", "불러오기성공", 1);
	    				}
		    		}else {
    					JOptionPane.showMessageDialog(this, "아이디를 재확인 해주세요", "불러오기실패", 0); // 비밀번호 불일치
    				}
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(this, "주문 불러오기 실패", "불러오기실패", 0);
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else if(e.getSource() == btn2) {	
				try{
					li.removeAll();
					
		        	Connection con = connection.makeConnection();
		    		String sql = null;
		    		ResultSet rs = null; 
		    		PreparedStatement pstmt = null;
		    		
		    		sql = "select * from orders";
		    		pstmt = con.prepareStatement(sql);
		    		
		    		rs = pstmt.executeQuery();
		    		while (rs.next()) {
		    			String str = rs.getNString(1) + "  /  " + rs.getNString(3) + "  /  " + rs.getNString(2);
		                li.add(str); // 리스트에 데이터를 추가한다.
		    		}
					JOptionPane.showMessageDialog(this, "책 불러오기 성공", "등록성공", 1);

		        }catch(SQLException sqle){
					JOptionPane.showMessageDialog(this, "책 불러오기 성공", "등록성공", 0);

		        }
			}
		};
		btn1.addActionListener(listener1);
		btn2.addActionListener(listener1);
	}
}