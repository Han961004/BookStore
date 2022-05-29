package javaManageTest;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

import SQL.connection;

public class SignUpPanel__O extends JPanel {
	TopUserPanel top = new TopUserPanel();

	SignUpPanel__O() {

		this.setBackground(Color.white);
		this.setLayout(null);

		
		JLabel lbl1 = new JLabel("��   ��   �� :");
		lbl1.setBounds(150, 50, 120, 20);
		JTextField text1 = new JTextField(20);
		text1.setBounds(220, 50, 120, 20);
		
		JLabel lbl2 = new JLabel("��й�ȣ :");
		lbl2.setBounds(150, 100, 120, 20);
		JTextField text2 = new JTextField(20);
		text2.setBounds(220, 100, 120, 20);
		
		JLabel lbl0 = new JLabel("��        �� :");
		lbl0.setBounds(150, 150, 120, 20);
		JTextField text0 = new JTextField(20);
		text0.setBounds(220, 150, 120, 20);
		
		JLabel lbl3 = new JLabel("��        �� :");
		lbl3.setBounds(150, 190, 120, 20);
		JTextField text3 = new JTextField(20);
		text3.setBounds(220, 190, 120, 20);
		

		JButton btn1 = new JButton("ȸ������");
		btn1.setBounds(80, 280, 120, 20);

		JButton btn2 = new JButton("���ư���");
		btn2.setBounds(320, 280, 120, 20);
		

		add(lbl0);
		add(text0);
		add(lbl1);
		add(text1);
		add(lbl2);
		add(text2);
		add(lbl3);
		add(text3);
		add(btn1);
		add(btn2);

		
		
		
		ActionListener listener1 = e -> {
			
			JButton btn = (JButton) e.getSource();
			__FrameTest__ test = (__FrameTest__) btn.getTopLevelAncestor();
			
			if(e.getSource() == btn1) {			// ȸ������ ������
				
				String id = text1.getText();
				String pw = text2.getText();
				String age = text3.getText();
				String uname = text0.getText();
				
				Connection con = connection.makeConnection();
	    		String sql = null;
	    		 
	    		PreparedStatement pstmt = null;
	    		
	    		sql = "insert into members values (?,?,?,?);";
	    		try {
	    			pstmt = con.prepareStatement(sql);
	    			pstmt.setString(1, id);
	    			pstmt.setString(2, pw);
	    			pstmt.setString(3, uname);
	    			pstmt.setString(4, age);
	    			pstmt.execute();
	    			
	    			// Ȯ�� �޼���
	    			JOptionPane.showMessageDialog(this, "ȸ�� ���� ����", "���Լ���", 1);
	    			
	    			test.viewScreen(new InfoPanel());
					
				} catch (SQLException e1) {
					// ���� �޼���
					JOptionPane.showMessageDialog(this, "ȸ�� ���� ����", "���Խ���", 0);
					
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if(e.getSource() == btn2) {
				// �׳� �������� ���ư��� 
				test.viewScreen(new InfoPanel());
			}
		};
		btn1.addActionListener(listener1);
		btn2.addActionListener(listener1);
	}
}