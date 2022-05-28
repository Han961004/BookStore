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
import javaManageTest.*;
import SQL.connection;

public class MyOrderList extends JPanel {
	
	
	MyOrderList() {
		
		this.setBackground(Color.white);
		
		JButton btn2 = new JButton("주문수정");
		
		Panel p = new Panel();
		p.setLayout(null);
		p.setSize(450, 400);

		List li = new List();
		li.setBounds(0, 20, 450, 250);
		li.removeAll(); // 리스트 내용을 전부 제거한다.

		add(btn2);
		p.add(li);
		add(p);
		
		
		String id = LogInfoSave.getPublicid();
		
		try{
        	Connection con = connection.makeConnection();
    		String sql = null;
    		ResultSet rs = null; 
    		PreparedStatement pstmt = null;
    		
    		sql = "select * from orders where id = '" + id + "'order by onum desc;";		// 최신순 조회
    		pstmt = con.prepareStatement(sql);
    		
    		rs = pstmt.executeQuery();
    		while (rs.next()) {				// 주문번호 | 전화 | 주소 | 책 | 수량 |수취인
    			String str = rs.getNString(1) + "  /  \t" + rs.getNString(3) + "  /  " + rs.getNString(2);
    			System.out.println(str);
                li.add(str); // 리스트에 데이터를 추가한다.
    		}

        }catch(SQLException sqle){
			JOptionPane.showMessageDialog(this, "주문 불러오기 실패", "불러오기 실패", 0);
        }
		
		
		ActionListener listener1 = e -> {
		
			if(e.getSource() == btn2) {			
				new OrderFix();
			}
		};
		btn2.addActionListener(listener1);
	}
}
