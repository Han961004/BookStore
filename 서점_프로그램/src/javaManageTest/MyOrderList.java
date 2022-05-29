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
    		while (rs.next()) {																					// �ֹ���ȣ | ���� | ���� | å 
    			String str = "  " + rs.getInt(1) + "  |  " + rs.getNString(2) + "  |  " + rs.getInt(6) + " ��  |  " + rs.getNString(4) + "  |  " + rs.getString(5) + "  |  " + rs.getNString(7);
    			li.add(str);
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
