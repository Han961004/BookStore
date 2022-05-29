package javaManageTest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; 

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListModel;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Execute;

import SQL.connection;
import chart.*;

public class BookManagement extends JPanel {
	
	JTextField text, text1, text2, text3, text4, text5;
	List li = new List();
	
	BookManagement() {

		this.setBackground(Color.white);

		
		JLabel l1 = new JLabel("å ���� : ");
		JTextField tf1 = new JTextField(18);
		JButton btn1 = new JButton("�˻�");
		JButton btn2 = new JButton("����");
		JButton btn3 = new JButton("�߰�");
		
		Panel p = new Panel();
		p.setLayout(null);
		p.setSize(450, 400);

		
		li.setBounds(0, 20, 450, 250);
		li.removeAll(); // ����Ʈ ������ ���� �����Ѵ�.
		
		add(l1);
		add(tf1);
		add(btn1);
		add(btn2);
		add(btn3);
		p.add(li);
		add(p);
		
		try{
        	Connection con = connection.makeConnection();
    		
        	String sql = null;
    		ResultSet rs = null; 
    		PreparedStatement pstmt = null;
    		
    		sql = "select * from books order by bname";
    		pstmt = con.prepareStatement(sql);
    		
    		rs = pstmt.executeQuery();
    		while (rs.next()) {
    			String ll = "";
    			String o = "";
    			if (rs.getInt(6) < 10) {			// 00�� ���߱�
    				o = "0";
    			}
    			
    			if (Math.log10(rs.getInt(5))+1 < 5) {			// Ȥ�� 4�ڸ� �����̸�
    				ll = "  ";
    			}
    			
    			String str1 = "  " + rs.getNString(1) + "  |  " + o + rs.getInt(6) + " ��"  + "  |  " + rs.getNString(3) + "  |  " + ll + rs.getInt(5) + " ��" + "  |  " + rs.getNString(2);
    			
                li.add(str1); // ����Ʈ�� �����͸� �߰��Ѵ�.
    		}
        }catch(SQLException sqle){
			JOptionPane.showMessageDialog(this, "å �ҷ����� ����", "�ҷ����� ����", 0);
        }
		
		
		
		ActionListener listener1 = e -> {
			if(e.getSource() == btn1) {			// �˻� ��ư	 ������
				
				String bname = tf1.getText();
				Connection con = connection.makeConnection();
	    		String sql = null;
	    		PreparedStatement pstmt = null;
	    		ResultSet rs = null; 
	    		
	    		try {
	    			sql = "select * from books where bname = (?);";
	    			
	    			pstmt = con.prepareStatement(sql);
	    			pstmt.setString(1, bname);
	    			rs = pstmt.executeQuery();
	    			
	    			
	    			if (rs.next()) {
	    				if (rs.getString(2).contentEquals(bname)) {
	    					JOptionPane.showMessageDialog(this, "ã�� å�� �ֽ��ϴ�.  " + rs.getInt(6) + " �� ���ҽ��ϴ�.", "�˻�����", 1)	;
	    				}
	    			}
	    			else {
    					JOptionPane.showMessageDialog(this, "ã�� å�� �����ϴ�", "�˻�����", 0); // ��й�ȣ ����ġ
    				}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(this, "�܂�Ē��v��", "����", 0);
		    		e1.printStackTrace();
				}
			} else if(e.getSource() == btn2) {
				new BookFix();
			} else if(e.getSource() == btn3) {
				new BookAdd();
			}
		};
		btn1.addActionListener(listener1);
		btn2.addActionListener(listener1);
		btn3.addActionListener(listener1);
		
		
		
	}
}

