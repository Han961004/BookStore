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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javaManageTest.*;
import SQL.connection;

public class MyOrderList extends JPanel {
	
	
	MyOrderList() {
		
		this.setBackground(Color.white);
		JButton btn2 = new JButton("�ֹ�����");
		
		Panel p = new Panel();
		p.setLayout(null);
		p.setSize(450, 400);

		List li = new List();
		li.setBounds(0, 20, 450, 250);
		li.removeAll(); // ����Ʈ ������ ���� �����Ѵ�.0

		add(btn2);
		p.add(li);
		add(p);
		
		
		String id = InfoSave.getPublicid();
		
		try{
        	Connection con = connection.makeConnection();
    		String sql = null;
    		ResultSet rs = null; 
    		PreparedStatement pstmt = null;
    		
    		sql = "select * from orders where id = '" + id + "'order by onum desc;";		// �ֽż� ��ȸ
    		pstmt = con.prepareStatement(sql);
    		
    		rs = pstmt.executeQuery();
    		
    		String str2 = "�ֹ���ȣ| å��ȣ|  ���̵� |  ������  |        ����ó       |  ����   |      ��   ��";
    		li.add(str2);
    		
    		while (rs.next()) {					// �ֹ���ȣ | ���� | ���� | å 
    			
    			
    			String f1 = "";
    			String ff1 ="";
    			String ll = "";
    			String v = "";
    			
    			if (Math.log10(rs.getInt(1))+1 < 1) {			// Ȥ�� 4�ڸ� �����̸�
    				ll = "    ";
    			}else if (Math.log10(rs.getInt(1))+1 < 2) {
    				ll = "  ";
    			}
    			
    			f1 = rs.getString(2);
    			if(f1.startsWith("f")) {
    				ff1 = " ";
    			}
    			
    			if (rs.getInt(6) < 10) {			// 00�� ���߱�
    				v = "0";
    			}
    			
    			String str = "         " + ll + rs.getInt(1) + "  |  " + ff1 + rs.getString(2) + "  |  " + rs.getNString(3) + "  |  " + rs.getNString(4) + "  |  " + rs.getNString(5) + "  |  " + v + rs.getInt(6) + " ��  |  " + rs.getNString(7);
                li.add(str); // ����Ʈ�� �����͸� �߰��Ѵ�.
    		}

        }catch(SQLException sqle){
			JOptionPane.showMessageDialog(this, "�ֹ� �ҷ����� ����", "�ҷ����� ����", 0);
        }
		
		
		ActionListener listener1 = e -> {
		
			if(e.getSource() == btn2) {			
				new OrderFix();
			}
		};
		btn2.addActionListener(listener1);
	}
}
