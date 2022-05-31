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
import chart.SaleChart;

public class SalesManagement extends JPanel {
	
	InfoSave info = new InfoSave();
	
	SalesManagement() {

		this.setBackground(Color.white);
		JLabel l2 = new JLabel("날짜 검색 : ");
		JLabel l3 = new JLabel(" 년 ");
		JLabel l4 = new JLabel(" 월 ");
		
		JTextField tf1 = new JTextField(3);
		JTextField tf2 = new JTextField(2);
		
		JButton btn1 = new JButton("검색");
		JButton btn2 = new JButton("연도차트");
		
		Panel p = new Panel();
		p.setLayout(null);
		p.setSize(450, 400);

		List li = new List();
		li.setBounds(0, 20, 450, 250);
		li.removeAll(); // 리스트 내용을 전부 제거한다.

		

		add(l2);
		add(tf1);
		add(l3);
		add(tf2);
		add(l4);
		add(btn1);
		add(btn2);
		
		p.add(li);
		add(p);
		
		
		
		
		ActionListener listener1 = e -> {
			
			String years = tf1.getText();
			String months = tf2.getText();
			
			if(e.getSource() == btn1) {			// 검색 버튼	 누르면
				
				
				
				li.removeAll();
				
				Connection con = connection.makeConnection();
	    		String sql = null;
	    		PreparedStatement pstmt = null;
	    		ResultSet rs = null; 
	    		
	    		try {
	    			sql = "SELECT * FROM orders WHERE year(dates) = ? and month(dates) = ? order by dates;";
	    			
	    			pstmt = con.prepareStatement(sql);
	    			
	    			pstmt.setInt(1, Integer.parseInt(years));
	    			pstmt.setInt(2, Integer.parseInt(months));
	    			
	    			rs = pstmt.executeQuery();
	    			
	    			int a = 0;
	    			int b = 0;
	    			
	    			String str2 = " 주문번호 |    주문날짜   |   수량   |  합계가격   |  도서 제목";
					li.add(str2);
	    			
	    			while (rs.next()) {
	    				
	    				String f = "";			// f열 줄맞추기
	    				String ll = "";
	        			String o = "";
	        			if (rs.getInt(6) < 10) {			// 00권 맞추기
	        				o = "0";
	        			}
	        			
	        			if (Math.log10(rs.getInt(8))+1 < 5) {			// 혹시 4자리 가격이면
	        				ll = "    ";
	        			} else if(Math.log10(rs.getInt(8))+1 < 6) {		// 5자리 가격이면
	        				ll = "  ";
	        			}
	        			
	        			if(Math.log10(rs.getInt(1))+1 <2) {
	        				f = "      ";
	        			}else if (Math.log10(rs.getInt(1))+1 <3){
	        				f = "    ";
	        			}
	        			
	        			
	        			
	    				String str = "  " + f + rs.getInt(1) + " 번  |  " + rs.getDate(10) + "  |  " + o + rs.getInt(6) + " 권"  + "  |  " + ll + rs.getInt(8) + " 원  |  " + rs.getNString(9);
	                    a+= rs.getInt(6);
	                    b+= rs.getInt(8);
	    				li.add(str); // 리스트에 데이터를 추가한다.
	        		}
	        		
	    			li.add("");
	    			li.add("");
	    			li.add(String.format("  총 판매 권 수 : %20d 권          |  총 판매 금액 : %20d 원", a, b));
	    			
					JOptionPane.showMessageDialog(this, "꿀궭휅뷃엟럻", "성공", 1);

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(this, "년월을 다시 확인해주세요", "에러", 0);
		    		e1.printStackTrace();
				}
			} else if(e.getSource() == btn2) {
				
				info.setPublicyears(tf1.getText());				// 고정시킴
				
				try {
					new chart.SaleChart();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		};
		btn1.addActionListener(listener1);
		btn2.addActionListener(listener1);
		
	}
}
