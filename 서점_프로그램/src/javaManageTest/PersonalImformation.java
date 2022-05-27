package javaManageTest;

import java.awt.Color;
import java.awt.Container;
import java.awt.List;
import java.awt.Panel;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;

import SQL.connection;

public class PersonalImformation extends JPanel {

	PersonalImformation() {
		this.setBackground(Color.white);
		
		//�̸� �˻��ؼ� �ֹ� ��ȣ�� å��� ���� ���ų�¥�� ���;� ��
		
		JLabel l1 = new JLabel("�̸� �˻� : ");
		JTextField tf1 = new JTextField(10);
		JButton btn1 = new JButton("�� ��");
		JButton btn2 = new JButton("��  ��");
		
		Panel p = new Panel();
		p.setLayout(null);
		p.setSize(450, 400);

		JTextArea p2 = new JTextArea();
		p2.setBounds(0, 20, 450, 250);
		p2.removeAll(); // ����Ʈ ������ ���� �����Ѵ�.
		p2.setEnabled(false);
		
		add(l1);
		add(tf1);
		add(btn1);
		add(btn2);
		p.add(p2);
		add(p);

		
		
		ActionListener listener1 = e -> {

		    JButton btn = (JButton) e.getSource();
			FrameTest test = (FrameTest) btn.getTopLevelAncestor();
			
			if(e.getSource() == btn1) {			// �Է¿Ϸ� ������
				
				String uname = tf1.getText();
				
				Connection con = connection.makeConnection();
	    		String sql = null;
	    		ResultSet rs = null; 
	    		PreparedStatement pstmt = null;
	    		
	    		sql = "select * from members where uname = '" + uname + "';";
	    		
	    		try {
	    			pstmt = con.prepareStatement(sql);
	    			pstmt.execute();
	    			rs = pstmt.executeQuery();
	    			rs.next();
	    			
	    			
	    			p2.setText("���̵�\t\t" + rs.getNString(1) + "\n" +
	    						"�н�����\t\t" + rs.getNString(2) + "\n" +
	    						"��   ��\t\t" + rs.getNString(3) + "\n" +
	    						"��   ��\t\t" + rs.getNString(4) + "\n" +
	    						"�޴���\t\t" + rs.getNString(5) + "\n" +
	    						"��   ��\t\t"+ rs.getNString(6));

	    			JOptionPane.showMessageDialog(this, "�� �˻� ����", "�˻�����", 1);
	    			
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(this, "�� �˻� ����", "�˻�����", 0);
					e1.printStackTrace();
				}
			} else if(e.getSource() == btn2) {
				
				
				new AdminMemFix();
		        //
		        
		        
			}
		};
		btn1.addActionListener(listener1);
		btn2.addActionListener(listener1);
	}
}
