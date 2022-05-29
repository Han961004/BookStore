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
import javax.swing.JTextField;

import SQL.connection;

public class 미구현BookOrder extends JFrame{
	JTextField text, text1, text2, text3, text4, text5, text6, text7, text8;

	InfoSave rr = new InfoSave();
	
	미구현BookOrder(){
		JFrame window1 = new JFrame("도서 주문");
	    window1.setBounds(800, 100, 700, 600);
	    window1.setResizable(false);
	    window1.setBackground(Color.white);
	    window1.setLayout(null);
	
	    JButton btn5 = new JButton("확인");
		btn5.setBounds(350, 50, 90, 20);
		
		JButton btn6 = new JButton("주문하기");
		btn6.setBounds(80, 500, 120, 20);
		
		JButton btn7 = new JButton("초기화");
		btn7.setBounds(320, 500, 120, 20);
	    
	    JLabel lbl = new JLabel("도서번호 :");
		lbl.setBounds(150, 50, 120, 20);
		text = new JTextField(30);
		text.setBounds(220, 50, 120, 20);
	
		JLabel lbl1 = new JLabel("도서제목 :");
		lbl1.setBounds(150, 90, 120, 20);
		text1 = new JTextField(20);
		text1.setBounds(220, 90, 200, 20);
		text1.setEnabled(false);
		
		JLabel lbl2 = new JLabel("저       자 :");
		lbl2.setBounds(150, 130, 120, 20);
		text2 = new JTextField(20);
		text2.setBounds(220, 130, 200, 20);
		text2.setEnabled(false);
		
		JLabel lbl3 = new JLabel("출  판  사 :");
		lbl3.setBounds(150, 170, 120, 20);
		text3 = new JTextField(20);
		text3.setBounds(220, 170, 200, 20);
		text3.setEnabled(false);
		
		JLabel lbl4 = new JLabel("가       격 :");
		lbl4.setBounds(150, 210, 120, 20);
		text4 = new JTextField(20);
		text4.setBounds(220, 210, 200, 20);
		text4.setEnabled(false);
		
		JLabel lbl5 = new JLabel("재       고 :");
		lbl5.setBounds(150, 250, 120, 20);
		text5 = new JTextField(20);
		text5.setBounds(220, 250, 200, 20);
		text5.setEnabled(false);
		
		JLabel lbl9 = new JLabel("주문수량 :");
		lbl9.setBounds(150, 290, 120, 20);
		JTextField text9 = new JTextField(20);
		text9.setBounds(220, 290, 200, 20);
		
		JLabel lbl6 = new JLabel("받는사람 :");
		lbl6.setBounds(150, 330, 120, 20);
		text6 = new JTextField(20);
		text6.setBounds(220, 330, 200, 20);
		
		JLabel lbl7 = new JLabel("연  락  처 :");
		lbl7.setBounds(150, 370, 120, 20);
		text7 = new JTextField(20);
		text7.setBounds(220, 370, 200, 20);
		
		
		JLabel lbl8 = new JLabel("받는주소 :");
		lbl8.setBounds(150, 410, 120, 20);
		JTextField text8 = new JTextField(20);
		text8.setBounds(220, 410, 400, 20);
	    
		
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
		window1.add(lbl6);
		window1.add(text6);
		
		window1.add(lbl7);
		window1.add(text7);
		window1.add(lbl8);
		window1.add(text8);
		window1.add(lbl9);
		window1.add(text9);
		
		window1.add(btn7);
		window1.add(btn6);
		
		window1.add(btn5);
	    window1.setVisible(true);
	    
	    
	    
	    
	    
	    
	    
	    ActionListener listener1 = e -> {
			
			String id = rr.getPublicid();
			
			
			String bnum = text.getText();
			String bname = text1.getText();
			String author = text2.getText();
			String publisher = text3.getText();
			String price = text4.getText();
			String stock = text5.getText();
			
			
			String person = text6.getText();
			String tel = text7.getText();
			String count = text9.getText();
			String address = text8.getText();
			
			
			
			if(e.getSource() == btn5) {			// 확인 누르면
				
				
				Connection con = connection.makeConnection();
	    		String sql = null;
	    		ResultSet rs = null; 
	    		PreparedStatement pstmt = null;
	    		
	    		
	    		try {
	    			sql = "select * from books where bnum = '" + bnum + "';";
		    		pstmt = con.prepareStatement(sql);
		    		rs = pstmt.executeQuery();
		    		rs.next();
		    		text1.setText(rs.getNString(2));
		    		text2.setText(rs.getNString(3));
					text3.setText(rs.getNString(4));
					text4.setText(String.valueOf(rs.getInt(5)));
					text5.setText(String.valueOf(rs.getInt(6)));
					
					JOptionPane.showMessageDialog(this, "조회 성공", "조회성공", 1);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(this, "조회 실패", "조회성공", 0);
					e1.printStackTrace();
				}
			} else if(e.getSource() == btn6) {				//주문하기
				
//				int stock = Integer.parseInt(text5.getText());
//				int count = Integer.parseInt(text9.getText());
				
				Connection con = connection.makeConnection();
	    		String sql = null;
	    		String sql1 = null;
	    		ResultSet rs = null; 
	    		PreparedStatement pstmt = null;
	    		PreparedStatement pstmt1 = null;
	    		
	    		int ppap ;
	    		
	    		try {
	    			sql = "INSERT INTO `orders` (`bnum`, `id`, `person`, `tel`, `count`, `address`) VALUES (?, ?, ?, ?, ?,?)";
		    		pstmt = con.prepareStatement(sql);
		    		
		    		pstmt.setString(1, bnum);
	    			pstmt.setString(2, id);
	    			pstmt.setString(3, person);
	    			pstmt.setString(4, tel);
	    			ppap = Integer.parseInt(text5.getText()) - Integer.parseInt(text9.getText());
	    			pstmt.setInt(5, Integer.parseInt(text9.getText()));
	    			pstmt.setString(6, address);
	    			
	    			
	    			
	    			////////////////////////
	    			
	    			sql1 = "update `books` set stock = ? where stock = ?";
	    			pstmt1 = con.prepareStatement(sql1);
	    			pstmt1.setInt(1, ppap);
	    			pstmt1.setInt(2, Integer.parseInt(text5.getText()));
	    			
	    			if (ppap < 0) {
	    				JOptionPane.showMessageDialog(this, "재고가 모자릅니다", "구매실패", 0);
	    			} else {
	    				JOptionPane.showMessageDialog(this, "구매 성공", "구매성공", 1);
	    				pstmt.execute();
	    				pstmt1.execute();
	    			}	
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(this, "구매 실패", "구매실패", 0);
					e1.printStackTrace();
				}
	    		
	    		
			} else if(e.getSource() == btn7) {	
				text.setText("");
				text1.setText("");
				text2.setText("");
				text3.setText("");
				text4.setText("");
				text5.setText("");
				text6.setText("");
				text7.setText("");
				text8.setText("");
				text9.setText("");
				
				repaint();
			}
		};
		btn5.addActionListener(listener1);
		btn6.addActionListener(listener1);
		btn7.addActionListener(listener1);
		
		
	}
}
