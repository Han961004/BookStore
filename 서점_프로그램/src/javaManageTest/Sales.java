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

import Demo.SaleChart;
import SQL.connection;

public class Sales extends JPanel {
	
	InfoSave info = new InfoSave();
	
	Sales() {

		this.setBackground(Color.white);
		JLabel l2 = new JLabel("��¥ �˻� : ");
		JLabel l3 = new JLabel(" �� ");
		JLabel l4 = new JLabel(" �� ");
		
		JTextField tf1 = new JTextField(3);
		JTextField tf2 = new JTextField(2);
		
		JButton btn1 = new JButton("�˻�");
		JButton btn2 = new JButton("������Ʈ");
		
		Panel p = new Panel();
		p.setLayout(null);
		p.setSize(450, 400);

		List li = new List();
		li.setBounds(0, 20, 450, 250);
		li.removeAll(); // ����Ʈ ������ ���� �����Ѵ�.

		

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
			if(e.getSource() == btn1) {			// �˻� ��ư	 ������
				
				li.removeAll();
				
				
				
				Connection con = connection.makeConnection();
	    		String sql = null;
	    		PreparedStatement pstmt = null;
	    		ResultSet rs = null; 
	    		
	    		try {
	    			sql = "select * from sale where years = ? and months = ? order by days;";
	    			
	    			pstmt = con.prepareStatement(sql);
	    			pstmt.setString(1, years);
	    			pstmt.setString(2, months);
	    			
	    			rs = pstmt.executeQuery();
	    			
	    			int a = 0;
	    			int b = 0;
	    			
	    			while (rs.next()) {
	    				String str = "  " + rs.getNString(1) + "  |  " + rs.getNString(2) + "-" + rs.getNString(3) + "-" + rs.getNString(4) + "  |  " + rs.getNString(5) + " ��  |  " + rs.getNString(6) + " ��  |  " + rs.getNString(7);
	                    a+= Integer.parseInt(rs.getNString(5));
	                    b+= Integer.parseInt(rs.getNString(6));
	    				li.add(str); // ����Ʈ�� �����͸� �߰��Ѵ�.
	        		}
	        		
	    			
	    			
	    			li.add("");
	    			li.add("");
	    			li.add(String.format("  �� �Ǹ� �� �� : %20d ��          |  �� �Ǹ� �ݾ� : %20d ��", a, b));
	    			
					JOptionPane.showMessageDialog(this, "�܂�Ē��v��", "����", 1);

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(this, "����� �ٽ� Ȯ�����ּ���", "����", 0);
		    		e1.printStackTrace();
				}
			} else if(e.getSource() == btn2) {
				
				info.setPublicyears(tf1.getText());				// ������Ŵ
				
				SaleChart.main(null);
			}
		};
		btn1.addActionListener(listener1);
		btn2.addActionListener(listener1);
		
	}
}
