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

public class AddBookPanel__ extends JPanel {
	__TopUserPanel top = new __TopUserPanel();
	JTextField text, text1, text2, text3, text4, text5;

	AddBookPanel__() {

		this.setBackground(Color.white);
		this.setLayout(null);
		
		JLabel lbl = new JLabel("책   번    호 :");
		lbl.setBounds(150, 20, 120, 20);
		text = new JTextField(20);
		text.setBounds(220, 20, 120, 20);

		JLabel lbl1 = new JLabel("저        자 :");
		lbl1.setBounds(150, 60, 120, 20);
		text1 = new JTextField(20);
		text1.setBounds(220, 60, 120, 20);
		
		JLabel lbl2 = new JLabel("제        목 :");
		lbl2.setBounds(150, 100, 120, 20);
		text2 = new JTextField(20);
		text2.setBounds(220, 100, 120, 20);
		
		JLabel lbl3 = new JLabel("출  판  사 :");
		lbl3.setBounds(150, 140, 120, 20);
		text3 = new JTextField(20);
		text3.setBounds(220, 140, 120, 20);
		
		JLabel lbl4 = new JLabel("가        격 :");
		lbl4.setBounds(150, 180, 120, 20);
		text4 = new JTextField(20);
		text4.setBounds(220, 180, 120, 20);
		
		JLabel lbl5 = new JLabel("재        고 :");
		lbl5.setBounds(150, 220, 120, 20);
		text5 = new JTextField(20);
		text5.setBounds(220, 220, 120, 20);

		JButton btn1 = new JButton("입력완료");
		btn1.setBounds(80, 260, 120, 20);

		JButton btn2 = new JButton("다시입력");
		btn2.setBounds(320, 260, 120, 20);

		add(lbl);
		add(text);
		add(lbl1);
		add(text1);
		add(lbl2);
		add(text2);
		add(lbl3);
		add(text3);
		add(lbl4);
		add(text4);
		add(lbl5);
		add(text5);
		add(btn1);
		add(btn2);
		
		
		
		ActionListener listener1 = e -> {
			
			JButton btn = (JButton) e.getSource();
			FrameTest test = (FrameTest) btn.getTopLevelAncestor();
			
			if(e.getSource() == btn1) {			// 입력완료 누르면
				
				String bnum = text.getText();
				String bname = text2.getText();
				String author = text1.getText();
				String publisher = text3.getText();
				String price = text4.getText();
				String stock = text5.getText();
				
				Connection con = connection.makeConnection();
	    		String sql = null;
	    		ResultSet rs = null; 
	    		PreparedStatement pstmt = null;
	    		
	    		sql = "insert into books values (?,?,?,?,?,?);";
	    		try {
	    			pstmt = con.prepareStatement(sql);
	    			pstmt.setString(1, bnum);
	    			pstmt.setString(2, bname);
	    			pstmt.setString(3, author);
	    			pstmt.setString(4, publisher);
	    			pstmt.setString(5, price);
	    			pstmt.setString(6, stock);
	    			pstmt.execute();
	    			
	    			JOptionPane.showMessageDialog(this, "책 등록 성공", "등록성공", 1);
					
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(this, "책 번호 중첩", "등록실패", 0);
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    		// 다시입력 초기화 버튼
			} else if(e.getSource() == btn2) {
				text.setText("");
				text1.setText("");
				text2.setText("");
				text3.setText("");
				text4.setText("");
				text5.setText("");
			}
		};
		btn1.addActionListener(listener1);
		btn2.addActionListener(listener1);
	}
}
