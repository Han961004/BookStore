package javaManageTest;

import java.awt.Color;
import java.awt.List;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import SQL.connection;
import javaManageTest.LoginPanel.MyActionListener;

public class PersonalImformation extends JPanel {
	JTextField text1, text2, text3, text4, text5;

	PersonalImformation() {
		this.setBackground(Color.white);
		
		//이름 검색해서 주문 번호와 책재목 가격 구매날짜가 나와야 함
		
		JLabel l2 = new JLabel("이름 검색 : ");
		
		JTextField tf1 = new JTextField(10);
		
		JButton btn3 = new JButton("검 색");
		

		JButton btn1 = new JButton("수  정");
		
		JButton btn2 = new JButton("취  소");
		

		MyActionListener l = new MyActionListener();

		btn3.addActionListener(l);
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

			sql = "select * from books";
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				String str = rs.getNString(1) + "  /  " + rs.getNString(3) + "  /  " + rs.getNString(2);
				li.add(str); // 리스트에 데이터를 추가한다.
			}
		} catch (SQLException sqle) {
			System.out.println("SQLException: " + sqle.getMessage());
			System.out.println("SQLState: " + sqle.getSQLState());
		}
		add(l2);
		add(tf1);
		add(btn3);
		add(btn1);
		add(btn2);
		p.add(li);
		add(p);

		btn1.addActionListener(l);
		btn2.addActionListener(l);

		

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
