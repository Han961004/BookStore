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
		
		//이름 검색해서 주문 번호와 책재목 가격 구매날짜가 나와야 함
		
		JLabel l1 = new JLabel("이름 검색 : ");
		JTextField tf1 = new JTextField(10);
		JButton btn1 = new JButton("검 색");
		JButton btn2 = new JButton("수  정");
		
		Panel p = new Panel();
		p.setLayout(null);
		p.setSize(450, 400);

		JTextArea p2 = new JTextArea();
		p2.setBounds(0, 20, 450, 250);
		p2.removeAll(); // 리스트 내용을 전부 제거한다.
		p2.setEnabled(false);
		
		add(l1);
		add(tf1);
		add(btn1);
		add(btn2);
		p.add(p2);
		add(p);

		
		
		ActionListener listener1 = e -> {
			
			if(e.getSource() == btn1) {			// 입력완료 누르면
				
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
	    			
	    			
	    			p2.setText("아이디\t\t" + rs.getNString(1) + "\n" +
	    						"패스워드\t\t" + rs.getNString(2) + "\n" +
	    						"이   름\t\t" + rs.getNString(3) + "\n" +
	    						"나   이\t\t" + rs.getNString(4) + "\n" +
	    						"휴대폰\t\t" + rs.getNString(5) + "\n" +
	    						"주   소\t\t"+ rs.getNString(6));

	    			JOptionPane.showMessageDialog(this, "고객 검색 성공", "검색성공", 1);
	    			
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(this, "고객 검색 실패", "검색실패", 0);
					e1.printStackTrace();
				}
			} else if(e.getSource() == btn2) {
				
				
				
				
				
				
				
				
				// 새창에 수정하기 JFrame
				JTextField text, text1, text2, text3, text4, text5;
				
				JFrame window = new JFrame("고객 정보 수정하기");
		        window.setBounds(800, 100, 500, 400);
		        
		        window.setBackground(Color.white);
		        window.setLayout(null);
				
				JLabel lbl = new JLabel("수정 할 책 번호 :");
				lbl.setBounds(120, 20, 120, 20);
				text = new JTextField(30);
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

				JButton btn5 = new JButton("확인");
				btn5.setBounds(350, 20, 90, 20);

				JButton btn6 = new JButton("수정완료");
				btn6.setBounds(80, 260, 120, 20);
				
				JButton btn7 = new JButton("삭제하기");
				btn7.setBounds(320, 260, 120, 20);
				
				
				
				window.add(lbl);
				window.add(text);
				window.add(lbl1);
				window.add(text1);
				window.add(lbl2);
				window.add(text2);
				window.add(lbl3);
				window.add(text3);
				window.add(lbl4);
				window.add(text4);
				window.add(lbl5);
				window.add(text5);
				window.add(btn5);
				window.add(btn6);
				window.add(btn7);
		        
		        
		        
		        window.setVisible(true);
		        
		        
		        
		        
		        
		        
		        //
		        
		        
			}
		};
		btn1.addActionListener(listener1);
		btn2.addActionListener(listener1);
	}
}
