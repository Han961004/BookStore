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
		JLabel l2 = new JLabel("회원아이디 : ");
		JTextField tf1 = new JTextField(10);
		JButton btn1 = new JButton("검색");
		JButton btn2 = new JButton("목록");
		
		Panel p = new Panel();
		p.setLayout(null);
		p.setSize(450, 400);

		List li = new List();
		li.setBounds(0, 20, 450, 250);
		li.removeAll(); // 리스트 내용을 전부 제거한다.

		
		String str2 = "주문번호| 책번호|  아이디 |  수취인  |        연락처       |  수량   |      주   소";
		li.add(str2);
		
		
		try{
        	Connection con = connection.makeConnection();
    		String sql = null;
    		ResultSet rs = null; 
    		PreparedStatement pstmt = null;
    		
    		
    		
    		
    		sql = "select * from orders order by onum desc";
    		pstmt = con.prepareStatement(sql);
    		
    		rs = pstmt.executeQuery();
    		
    		
    		while (rs.next()) {
    			
    			String f1 = "";
    			String ff1 ="";
    			String ll = "";
    			String v = "";
    			
    			if (Math.log10(rs.getInt(1))+1 < 1) {			// 혹시 4자리 가격이면
    				ll = "    ";
    			}else if (Math.log10(rs.getInt(1))+1 < 2) {
    				ll = "  ";
    			}
    			
    			f1 = rs.getString(2);
    			if(f1.startsWith("f")) {
    				ff1 = " ";
    			}
    			
    			if (rs.getInt(6) < 10) {			// 00권 맞추기
    				v = "0";
    			}
    			
    			String str = "         " + ll + rs.getInt(1) + "  |  " + ff1 + rs.getString(2) + "  |  " + rs.getNString(3) + "  |  " + rs.getNString(4) + "  |  " + rs.getNString(5) + "  |  " + v + rs.getInt(6) + " 권  |  " + rs.getNString(7);
                li.add(str); // 리스트에 데이터를 추가한다.
    		}

        }catch(SQLException sqle){
			JOptionPane.showMessageDialog(this, "불러오기 실패", "조회실패", 0);
        }
		
		
		
		add(l2);
		add(tf1);
		add(btn1);
		add(btn2);
		p.add(li);
		add(p);

		ActionListener listener1 = e -> {
			
			String id = tf1.getText();
			
			if(e.getSource() == btn1) {	
				
				
				
				Connection con = connection.makeConnection();
	    		String sql = null;
	    		ResultSet rs = null; 
	    		PreparedStatement pstmt = null;
	    		
	    		
    			sql = "select * from orders where id = '" + id + "' order by onum desc ;";
	    		
	    		try {
		    		pstmt = con.prepareStatement(sql);
		    		rs = pstmt.executeQuery();
		    		
		    		
		    		
		    		if (rs.next()) {
		    			
		    			
			    		
		    			
	    				if (rs.getString(3).contentEquals(id)) {
	    					
	    					
	    					
	    					
	    					String f1 = "";
	    	    			String ff1 ="";
	    	    			String ll = "";
	    	    			String v = "";
	    	    			
	    	    			if (Math.log10(rs.getInt(1))+1 < 1) {			// 혹시 4자리 가격이면
	    	    				ll = "    ";
	    	    			}else if (Math.log10(rs.getInt(1))+1 < 2) {
	    	    				ll = "  ";
	    	    			}
	    	    			
	    	    			f1 = rs.getString(2);
	    	    			if(f1.startsWith("f")) {
	    	    				ff1 = " ";
	    	    			}
	    	    			
	    	    			if (rs.getInt(6) < 10) {			// 00권 맞추기
	    	    				v = "0";
	    	    			}
	    	    			
	    	    			li.removeAll();				// 버튼 누를 때 마다 리스트 초기화
	    	    			
	    	    			li.add(str2);
	    		    		
	    	    			
	    					
	    					// 밑에랑 합치면 첫번 째 튜플 안나옴			if (rs.next()) 에서 이미 한번 써버려서 
	    	    			String str = "         " + ll + rs.getInt(1) + "  |  " + ff1 + rs.getString(2) + "  |  " + rs.getNString(3) + "  |  " + rs.getNString(4) + "  |  " + rs.getNString(5) + "  |  " + v + rs.getInt(6) + " 권  |  " + rs.getNString(7);
			                 li.add(str);
	    					
	    					while(rs.next()) {
	    						
	    						
	    						
	    						
	        	    			
	    		    			
	    		    			if (Math.log10(rs.getInt(1))+1 < 1) {			// 혹시 4자리 가격이면
	    		    				ll = "    ";
	    		    			}else if (Math.log10(rs.getInt(1))+1 < 2) {
	    		    				ll = "  ";
	    		    			}
	    		    			
	    		    			f1 = rs.getString(2);
	    		    			if(f1.startsWith("f")) {
	    		    				ff1 = " ";
	    		    			}
	    		    			
	    		    			if (rs.getInt(6) < 10) {			// 00권 맞추기
	    		    				v = "0";
	    		    			}
	        	    			
	        	    			
	        	    			
	        	    			
	        	    			
	        	    			
	        	    			String str1 = "         " + ll + rs.getInt(1) + "  |  " + ff1 + rs.getString(2) + "  |  " + rs.getNString(3) + "  |  " + rs.getNString(4) + "  |  " + rs.getNString(5) + "  |  " + v + rs.getInt(6) + " 권  |  " + rs.getNString(7);
	    		                li.add(str1); // 리스트에 데이터를 추가한다.
	    					}
	    					JOptionPane.showMessageDialog(this, "불러오기 성공", "조회성공", 1);
	    				}
		    		}
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(this, "불러오기 실패", "조회실패", 0);
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
		    		
		    		sql = "select * from orders order by onum desc";
		    		pstmt = con.prepareStatement(sql);
		    		
		    		rs = pstmt.executeQuery();
		    		
		    		li.add(str2);
		    		
		    		while (rs.next()) {
		    			
		    			
		    			String f1 = "";
		    			String ff1 ="";
		    			String ll = "";
		    			String v = "";
		    			
		    			if (Math.log10(rs.getInt(1))+1 < 1) {			// 혹시 4자리 가격이면
		    				ll = "    ";
		    			}else if (Math.log10(rs.getInt(1))+1 < 2) {
		    				ll = "  ";
		    			}
		    			
		    			f1 = rs.getString(2);
		    			if(f1.startsWith("f")) {
		    				ff1 = " ";
		    			}
		    			
		    			if (rs.getInt(6) < 10) {			// 00권 맞추기
		    				v = "0";
		    			}
		    			
		    			String str = "         " + ll + rs.getInt(1) + "  |  " + ff1 + rs.getString(2) + "  |  " + rs.getNString(3) + "  |  " + rs.getNString(4) + "  |  " + rs.getNString(5) + "  |  " + v + rs.getInt(6) + " 권  |  " + rs.getNString(7);
		                li.add(str); // 리스트에 데이터를 추가한다.
		    		}
					JOptionPane.showMessageDialog(this, "불러오기 성공", "조회성공", 1);

		        }catch(SQLException sqle){
					JOptionPane.showMessageDialog(this, "불러오기 성공", "조회실패", 0);

		        }
			}
		};
		btn1.addActionListener(listener1);
		btn2.addActionListener(listener1);
	}
}