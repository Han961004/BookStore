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

public class Booklist extends JPanel {
	JTextField text, text1, text2, text3, text4, text5;
	List li = new List();
	Booklist() {
		this.setBackground(Color.white);

		
		JLabel l1 = new JLabel("책 제목 : ");
		JTextField tf1 = new JTextField(18);
		JButton btn1 = new JButton("검색");
		JButton btn2 = new JButton("주문하기");
		
		
		Panel p = new Panel();
		p.setLayout(null);
		p.setSize(450, 400);

		
		li.setBounds(0, 20, 450, 250);
		li.removeAll(); // 리스트 내용을 전부 제거한다.
		
		add(l1);
		add(tf1);
		add(btn1);
		add(btn2);
		
		p.add(li);
		add(p);
		
		try{
        	Connection con = connection.makeConnection();
    		
        	String sql = null;
    		ResultSet rs = null; 
    		PreparedStatement pstmt = null;
    		
    		sql = "select * from books order by bname";
    		pstmt = con.prepareStatement(sql);
    		
    		rs = pstmt.executeQuery();
    		while (rs.next()) {
    			String f = "";			// f열 줄맞추기
				String ll = "";
    			String o = "";
    			String ff = "";
    			
    			if (rs.getInt(6) < 10) {			// 00권 맞추기
    				o = "0";
    			}
    			
    			if (Math.log10(rs.getInt(5))+1 < 5) {			// 혹시 4자리 가격이면
    				ll = "    ";
    			} else if(Math.log10(rs.getInt(5))+1 < 6) {		// 5자리 가격이면
    				ll = "  ";
    			}
    			
    			f = rs.getString(1);
    			
    			if(f.startsWith("f")) {
    				ff = " ";
    			}
    			
    			String str1 = "  " + ff + rs.getNString(1) + "  |  " + o + rs.getInt(6) + " 권"  + "  |  " + rs.getNString(3) + "  |  " + ll + rs.getInt(5) + " 원" + "  |  " + rs.getNString(2);
    			
                li.add(str1); // 리스트에 데이터를 추가한다.
    		}
        }catch(SQLException sqle){
			JOptionPane.showMessageDialog(this, "책 불러오기 실패", "불러오기 실패", 0);
        }
		
		
		ActionListener listener1 = e -> {
			if(e.getSource() == btn1) {			// 검색 버튼	 누르면
				
				String bname = tf1.getText();
				Connection con = connection.makeConnection();
	    		String sql = null;
	    		PreparedStatement pstmt = null;
	    		ResultSet rs = null; 
	    		
	    		try {
	    			sql = "select * from books where bname = (?);";
	    			
	    			pstmt = con.prepareStatement(sql);
	    			pstmt.setString(1, bname);
	    			rs = pstmt.executeQuery();
	    			
	    			
	    			if (rs.next()) {
	    				if (rs.getString(2).contentEquals(bname)) {
	    					JOptionPane.showMessageDialog(this, "찾는 책이 있습니다.  " + rs.getInt(6) + " 권 남았습니다.", "검색성공", 1)	;
	    				}
	    			}
	    			else {
    					JOptionPane.showMessageDialog(this, "찾는 책이 없습니다", "검색실패", 0); // 비밀번호 불일치
    				}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(this, "꿀궭휅뷃엟럻", "에러", 0);
		    		e1.printStackTrace();
				}
			}else if(e.getSource() == btn2) {	
				new BookOrder_SQL점검();
			}
		};
		btn1.addActionListener(listener1);
		btn2.addActionListener(listener1);
	}
}
