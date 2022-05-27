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

public class AdminOrderList__ extends JPanel {
	
	
	AdminOrderList__() {
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

		add(l2);
		add(tf1);
		add(btn1);
		p.add(li);
		add(p);

		ActionListener listener1 = e -> {
			
			String id = tf1.getText();
			
			if(e.getSource() == btn1) {	
				
				
				
				Connection con = connection.makeConnection();
	    		String sql = null;
	    		ResultSet rs = null; 
	    		PreparedStatement pstmt = null;

    			sql = "select * from orders where id = '" + id + "' ;";
	    		
	    		try {
		    		pstmt = con.prepareStatement(sql);
		    		rs = pstmt.executeQuery();
		    		
		    		if (rs.next()) {
	    				if (rs.getString(3).contentEquals(id)) {
	    					
	    					li.removeAll();				// ��ư ���� �� ���� ����Ʈ �ʱ�ȭ
	    					
	    					// �ؿ��� ��ġ�� ù�� ° Ʃ�� �ȳ���			if (rs.next()) ���� �̹� �ѹ� ������� 
	    					String str = "��ȣ : " + rs.getNString(1) + "  /  " + "å ��ȣ : " + rs.getNString(2) + "  /  " + "������ : " + rs.getNString(4) + "(" + rs.getNString(5) + ")" + "  /  " + "���� : " + rs.getNString(6);	
	    					li.add(str);
	    					
	    					while(rs.next()) {
		    					String str1 = "��ȣ : " + rs.getNString(1) + "  /  " + "å ��ȣ : " + rs.getNString(2) + "  /  " + "������ : " + rs.getNString(4) + "("  + rs.getNString(5) + ")" + "  /  " + "���� : " + rs.getNString(6);
								li.add(str1); // ����Ʈ�� �����͸� �߰��Ѵ�.
	    					}
	    					JOptionPane.showMessageDialog(this, "�ֹ� �ҷ����� ����", "�ҷ����⼺��", 1);
	    				}
		    		}else {
    					JOptionPane.showMessageDialog(this, "���̵� ��Ȯ�� ���ּ���", "�ҷ��������", 0); // ��й�ȣ ����ġ
    				}
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(this, "�ֹ� �ҷ����� ����", "�ҷ��������", 0);
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		};
		btn1.addActionListener(listener1);
	}
}