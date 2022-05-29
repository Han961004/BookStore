package javaManageTest;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javaManageTest.InfoPanel.MyActionListener;

public class Login extends JPanel {

	Login() {

		this.setBackground(Color.white);
		this.setLayout(null);

		JLabel lbl1 = new JLabel("이름 :");
		lbl1.setBounds(150, 30, 120, 20);
		JTextField text1 = new JTextField(20);
		text1.setBounds(220, 30, 120, 20);
		JLabel lbl2 = new JLabel("비밀번호 :");
		lbl2.setBounds(150, 70, 120, 20);
		JTextField text2 = new JTextField(20);
		text2.setBounds(220, 70, 120, 20);
		
		JButton btn1 = new JButton("사용자 로그인");
		btn1.setBounds(80, 150, 120, 20);
		JButton btn2 = new JButton("관리자 로그인");
		btn2.setBounds(200, 150, 120, 20);
		JButton btn3 = new JButton("회원가입");
		btn3.setBounds(320, 150, 120, 20);
		MyActionListener l = new MyActionListener();
		btn1.addActionListener(l);
		btn2.addActionListener(l);
		btn3.addActionListener(l);
		add(lbl1);
		add(text1);
		add(lbl2);
		add(text2);
		add(btn1);
		add(btn2);
		add(btn3);
	}

	class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			JButton btn = (JButton) e.getSource();

			__FrameTest__ test = (__FrameTest__) btn.getTopLevelAncestor();

			switch (btn.getText()) {
			case "사용자 로그인":
				test.viewScreen(new AfterLoginPanel());
				break;
			case "관리자 로그인":
				test.viewScreen(new AdminPanel());
				break;
			case "회원가입":
				test.viewScreen(new SignUpPanel__O());
				break;
			}
		}
	}
}