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
//db�� ����

public class AdminOrderList extends JPanel {
	AdminOrderList() {
		this.setBackground(Color.white);
		JLabel l2 = new JLabel("�ֹ��� : ");
		JTextField tf1 = new JTextField(20);
		JButton btn1 = new JButton("�˻�");
		Panel p = new Panel();
		p.setLayout(null);
		p.setSize(450, 400);

		List li = new List();
		li.setBounds(0, 20, 450, 250);
		li.removeAll(); // ����Ʈ ������ ���� �����Ѵ�.

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
				li.add(str); // ����Ʈ�� �����͸� �߰��Ѵ�.
			}
		} catch (SQLException sqle) {
			System.out.println("SQLException: " + sqle.getMessage());
			System.out.println("SQLState: " + sqle.getSQLState());
		}

		MyActionListener l = new MyActionListener();
		btn1.addActionListener(l);
		add(l2);
		add(tf1);
		add(btn1);
		p.add(li);
		add(p);

	}

	class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			JButton btn = (JButton) e.getSource();

			FrameTest test = (FrameTest) btn.getTopLevelAncestor();

			switch (btn.getText()) {
			case "�˻�":

				break;

			}
		}
	}
}
