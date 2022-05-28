package javaManageTest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import SQL.connection;
import javaManageTest.InfoPanel.MyActionListener;

public class LoginPanel extends JPanel {
	
	InfoSave info = new InfoSave();
	
	JLabel img = new JLabel();
	
	LoginPanel() {

		this.setBackground(Color.white);
		this.setLayout(null);

		JLabel lbl1 = new JLabel("��   ��   �� :");
		lbl1.setBounds(150, 30, 120, 20);
		JTextField text1 = new JTextField(20);
		text1.setBounds(220, 30, 120, 20);
		
		JLabel lbl2 = new JLabel("��й�ȣ :");
		lbl2.setBounds(150, 70, 120, 20);
		JTextField text2 = new JTextField(20);
		text2.setBounds(220, 70, 120, 20);

		JButton btn1 = new JButton("����� �α���");
		btn1.setBounds(80, 150, 120, 20);
		JButton btn2 = new JButton("������ �α���");
		btn2.setBounds(200, 150, 120, 20);
		JButton btn3 = new JButton("���ư���");
		btn3.setBounds(320, 150, 120, 20);
		
		
		add(lbl1);
		add(text1);
		add(lbl2);
		add(text2);
		add(btn1);
		add(btn2);
		add(btn3);
		
		
		
		ActionListener listener1 = e -> {
			
			
			// �н����� ���???????????????????????
			
			JButton btn = (JButton) e.getSource();
			__FrameTest__ test = (__FrameTest__) btn.getTopLevelAncestor();
			String id = text1.getText();
			String pw = text2.getText();
			
			// ����� �α��� ������
			if(e.getSource() == btn1) {			
				
				Connection con = connection.makeConnection();
	    		String sql = null;
	    		ResultSet rs = null; 
	    		PreparedStatement pstmt = null;
	    		
	    		sql = "select * from members where id = (?) ;";
	    		
	    		try {
	    			pstmt = con.prepareStatement(sql);
	    			pstmt.setString(1, id);
	    			rs = pstmt.executeQuery();
	    			
	    			
	    			if (rs.next()) {
	    				if (rs.getString(1).contentEquals(id)) {
	    					
	    					info.setPublicid(id);
	    					
	    					JOptionPane.showMessageDialog(this, "ȸ�� �α��� ����", "�α��μ���", 1); // �α��� ����
	    					
	    					test.viewScreen2(new UserPanel());
	    				}
	    				else {
	    					JOptionPane.showMessageDialog(this, "��й�ȣ�� ��Ȯ�� ���ּ���", "�α��ν���", 0); // ��й�ȣ ����ġ
	    				}
	    			} else {
	    				JOptionPane.showMessageDialog(this, "ȸ�� ���̵� Ȯ�����ּ���", "�α��ν���", 0); // ���̵� ����
	    			}
	    			
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(this, "����", "�r��Ē�b", 0);
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
// ������ ������
			else if(e.getSource() == btn2) {			
				
				Connection con = connection.makeConnection();
	    		String sql = null;
	    		ResultSet rs = null; 
	    		PreparedStatement pstmt = null;
	    		
	    		sql = "select * from admins where id = (?);";
	    		
	    		try {
	    			pstmt = con.prepareStatement(sql);
	    			pstmt.setString(1, id);
	    			rs = pstmt.executeQuery();
	    			
	    			if (rs.next()) {
	    				if (rs.getString(1).contentEquals(id)) {
	    					JOptionPane.showMessageDialog(this, "������ �α��� ����", "�α��μ���", 1); // �α��� ����
	    					test.viewScreen3(new AdminPanel());
	    				}
	    				else {
	    					JOptionPane.showMessageDialog(this, "��й�ȣ�� ��Ȯ�� ���ּ���", "�α��ν���", 0); // ��й�ȣ ����ġ
	    				}
	    			} else {
	    				JOptionPane.showMessageDialog(this, "������ ���̵� Ȯ�����ּ���", "�α��ν���", 0); // ���̵� ����
	    			}
	    			
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(this, "����", "�r��Ē�b", 0);
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
// ���ư��� ������
			else if(e.getSource() == btn3) {			
				test.viewScreen(new InfoPanel());
			}
		};
		
		btn1.addActionListener(listener1);
		btn2.addActionListener(listener1);
		btn3.addActionListener(listener1);
		
	}
}
