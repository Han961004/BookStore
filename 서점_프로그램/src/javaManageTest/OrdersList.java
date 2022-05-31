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
		JLabel l2 = new JLabel("ȸ�����̵� : ");
		JTextField tf1 = new JTextField(10);
		JButton btn1 = new JButton("�˻�");
		JButton btn2 = new JButton("���");
		
		Panel p = new Panel();
		p.setLayout(null);
		p.setSize(450, 400);

		List li = new List();
		li.setBounds(0, 20, 450, 250);
		li.removeAll(); // ����Ʈ ������ ���� �����Ѵ�.

		
		String str2 = "�ֹ���ȣ| å��ȣ|  ���̵� |  ������  |        ����ó       |  ����   |      ��   ��";
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
			JOptionPane.showMessageDialog(this, "�ҷ����� ����", "��ȸ����", 0);
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
	    	    			
	    	    			li.removeAll();				// ��ư ���� �� ���� ����Ʈ �ʱ�ȭ
	    	    			
	    	    			li.add(str2);
	    		    		
	    	    			
	    					
	    					// �ؿ��� ��ġ�� ù�� ° Ʃ�� �ȳ���			if (rs.next()) ���� �̹� �ѹ� ������� 
	    	    			String str = "         " + ll + rs.getInt(1) + "  |  " + ff1 + rs.getString(2) + "  |  " + rs.getNString(3) + "  |  " + rs.getNString(4) + "  |  " + rs.getNString(5) + "  |  " + v + rs.getInt(6) + " ��  |  " + rs.getNString(7);
			                 li.add(str);
	    					
	    					while(rs.next()) {
	    						
	    						
	    						
	    						
	        	    			
	    		    			
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
	        	    			
	        	    			
	        	    			
	        	    			
	        	    			
	        	    			
	        	    			String str1 = "         " + ll + rs.getInt(1) + "  |  " + ff1 + rs.getString(2) + "  |  " + rs.getNString(3) + "  |  " + rs.getNString(4) + "  |  " + rs.getNString(5) + "  |  " + v + rs.getInt(6) + " ��  |  " + rs.getNString(7);
	    		                li.add(str1); // ����Ʈ�� �����͸� �߰��Ѵ�.
	    					}
	    					JOptionPane.showMessageDialog(this, "�ҷ����� ����", "��ȸ����", 1);
	    				}
		    		}
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(this, "�ҷ����� ����", "��ȸ����", 0);
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
					JOptionPane.showMessageDialog(this, "�ҷ����� ����", "��ȸ����", 1);

		        }catch(SQLException sqle){
					JOptionPane.showMessageDialog(this, "�ҷ����� ����", "��ȸ����", 0);

		        }
			}
		};
		btn1.addActionListener(listener1);
		btn2.addActionListener(listener1);
	}
}