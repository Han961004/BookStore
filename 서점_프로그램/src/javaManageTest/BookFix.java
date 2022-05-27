package javaManageTest;

import java.awt.Color;
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

public class BookFix extends JPanel{

	
	// ��â�� �����ϱ� JFrame
	JTextField text, text1, text2, text3, text4, text5;
		
	BookFix(){
		
		JFrame window1 = new JFrame("���� ����");
	    window1.setBounds(800, 100, 500, 400);
	    window1.setResizable(false);
	    window1.setBackground(Color.white);
	    window1.setLayout(null);
		
		JLabel lbl = new JLabel("å  ��  ȣ :");
		lbl.setBounds(150, 50, 120, 20);
		text = new JTextField(30);
		text.setBounds(220, 50, 120, 20);
	
		JLabel lbl1 = new JLabel("å  ��  �� :");
		lbl1.setBounds(150, 90, 120, 20);
		text1 = new JTextField(20);
		text1.setBounds(220, 90, 120, 20);
		
		JLabel lbl2 = new JLabel("��          �� :");
		lbl2.setBounds(150, 130, 120, 20);
		text2 = new JTextField(20);
		text2.setBounds(220, 130, 120, 20);
		
		JLabel lbl3 = new JLabel("��   ��   �� :");
		lbl3.setBounds(150, 170, 120, 20);
		text3 = new JTextField(20);
		text3.setBounds(220, 170, 120, 20);
		
		JLabel lbl4 = new JLabel("��         �� :");
		lbl4.setBounds(150, 210, 120, 20);
		text4 = new JTextField(20);
		text4.setBounds(220, 210, 120, 20);
		
		JLabel lbl5 = new JLabel("��         �� :");
		lbl5.setBounds(150, 250, 120, 20);
		text5 = new JTextField(20);
		text5.setBounds(220, 250, 120, 20);
	
		JButton btn5 = new JButton("�ҷ�����");
		btn5.setBounds(350, 50, 90, 20);
	
		JButton btn6 = new JButton("�����Ϸ�");
		btn6.setBounds(80, 290, 120, 20);
		
		JButton btn7 = new JButton("�����ϱ�");
		btn7.setBounds(320, 290, 120, 20);
		
		
		window1.add(lbl);
		window1.add(text);
		window1.add(lbl1);
		window1.add(text1);
		window1.add(lbl2);
		window1.add(text2);
		window1.add(lbl3);
		window1.add(text3);
		window1.add(lbl4);
		window1.add(text4);
		window1.add(lbl5);
		window1.add(text5);
		window1.add(btn5);
		window1.add(btn6);
		window1.add(btn7);
	    
	    window1.setVisible(true);
	    
	    
	    ActionListener listener1 = e -> {
			
	    	String bnum = text.getText();
			String bname = text1.getText();
			String author = text2.getText();
			String publisher = text3.getText();
			String price = text4.getText();
			String stock = text5.getText();
			
			if(e.getSource() == btn5) {			// ȸ������ ������
				
				
				Connection con = connection.makeConnection();
	    		String sql = null;
	    		ResultSet rs = null; 
	    		PreparedStatement pstmt = null;
	    		
	    		
	    		try {
	    			sql = "select * from books where bnum = '" + bnum + "';";
		    		pstmt = con.prepareStatement(sql);
		    		rs = pstmt.executeQuery();
		    		rs.next();
		    		text1.setText(rs.getNString(1));
		    		text2.setText(rs.getNString(2));
					text3.setText(rs.getNString(4));
					text4.setText(rs.getNString(5));
					text5.setText(rs.getNString(6));
					
					JOptionPane.showMessageDialog(this, "��ȸ ����", "��ȸ����", 1);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(this, "��ȸ ����", "��ȸ����", 0);
					e1.printStackTrace();
				}
			} else if(e.getSource() == btn6) {
				
				Connection con = connection.makeConnection();
	    		String sql = null;
	    		PreparedStatement pstmt = null;
	    		
	    		sql = "update books set bname = ?, author = ?, publisher = ?, price = ?, stock= ? where (bnum = ?);";
	    		try {
	    			
	    			pstmt = con.prepareStatement(sql);
	    			pstmt.setString(1, bname);
	    			pstmt.setString(2, author);
	    			pstmt.setString(3, publisher);
	    			pstmt.setString(4, price);
	    			pstmt.setString(5, stock);
	    			pstmt.setString(6, bnum);
	    			pstmt.execute();
	    			
	    			JOptionPane.showMessageDialog(this, "���� ����", "���ż���", 1);
	    		} catch (SQLException e1) {
	    			JOptionPane.showMessageDialog(this, "���� ����", "���ż���", 0);
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if(e.getSource() == btn7) {
				
				Connection con = connection.makeConnection();
	    		String sql = null;
	    		PreparedStatement pstmt = null;
	    		
	    		sql = "delete from books where bnum = ?;";
	    		
	    		try {
	    			pstmt = con.prepareStatement(sql);
	    			pstmt.setString(1, bnum);
	    			
	    			pstmt.execute();
	    			
	    			JOptionPane.showMessageDialog(this, "���� ����", "��������", 1);
	    		}catch(SQLException e11) {
	    			JOptionPane.showMessageDialog(this, "���� ����", "��������", 0);
	    		}
			}
		};
		btn5.addActionListener(listener1);
		btn6.addActionListener(listener1);
		btn7.addActionListener(listener1);
	}
}

