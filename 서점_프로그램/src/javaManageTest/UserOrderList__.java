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
import javax.swing.JPanel;
import javax.swing.JTextField;

import SQL.connection;

public class UserOrderList__ extends JPanel {
	
	UserOrderList__() {
		this.setBackground(Color.white);
		
		JLabel l = new JLabel("[주문번호]     /     [책번호]     /     [아이디]     /     [이름]     /     [주소]       /        [수량]");
		
		Panel p = new Panel();
		p.setLayout(null);
		p.setSize(450, 400);

		List li = new List();
		li.setBounds(0, 20, 450, 250);
		li.removeAll(); // 리스트 내용을 전부 제거한다.

		try {
			Connection con = connection.makeConnection();
			String sql = null;
			ResultSet rs = null;
			PreparedStatement pstmt = null;

			sql = "select * from orders";
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				String str = "[" + rs.getNString(1) + "]" + 
						"     /     " + "[" + rs.getNString(2) + "]"  + 
						"     /     " + "[" + rs.getNString(3) + "]"  +
						"     /     " + "[" + rs.getNString(4) + "]"  +
						"     /     " + "[" + rs.getNString(5) + "]"  + 
						"        /        " + "[" + rs.getNString(6) + "]" ;
				li.add(str); // 리스트에 데이터를 추가한다.
			}
		} catch (SQLException sqle) {
			System.out.println("SQLException: " + sqle.getMessage());
			System.out.println("SQLState: " + sqle.getSQLState());
		}

		add(l);
		p.add(li);
		add(p);

	}

	class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			JButton btn = (JButton) e.getSource();

			FrameTest test = (FrameTest) btn.getTopLevelAncestor();

			switch (btn.getText()) {
			case "검색":

				break;

			}
		}
	}
}
