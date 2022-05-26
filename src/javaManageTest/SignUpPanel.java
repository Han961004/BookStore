package javaManageTest;

import java.awt.BorderLayout;
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

public class SignUpPanel extends JPanel {
	TopUserPanel top = new TopUserPanel();
	JTextField text1, text2, text3, text4, text5;

	SignUpPanel() {

		this.setBackground(Color.white);
		this.setLayout(null);

		JLabel lbl1 = new JLabel("이        름 :");
		lbl1.setBounds(150, 30, 120, 20);
		text1 = new JTextField(20);
		text1.setBounds(220, 30, 120, 20);
		JLabel lbl2 = new JLabel("비밀번호 :");
		lbl2.setBounds(150, 80, 120, 20);
		text2 = new JTextField(20);
		text2.setBounds(220, 80, 120, 20);
		JLabel lbl3 = new JLabel("나        이 :");
		lbl3.setBounds(150, 130, 120, 20);
		text3 = new JTextField(20);
		text3.setBounds(220, 130, 120, 20);
		JLabel lbl4 = new JLabel("전화번호 :");
		lbl4.setBounds(150, 180, 120, 20);
		text4 = new JTextField(20);
		text4.setBounds(220, 180, 120, 20);
		JLabel lbl5 = new JLabel("주        소 :");
		lbl5.setBounds(150, 230, 120, 20);
		text5 = new JTextField(20);
		text5.setBounds(220, 230, 120, 20);

		JButton btn1 = new JButton("회원가입");
		btn1.setBounds(80, 280, 120, 20);

		JButton btn2 = new JButton("취           소");
		btn2.setBounds(320, 280, 120, 20);
		MyActionListener l = new MyActionListener();

		btn1.addActionListener(l);
		btn2.addActionListener(l);

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

	}

	class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			//String str = e.getActionCommand();

			JButton btn = (JButton) e.getSource();

			FrameTest test = (FrameTest) btn.getTopLevelAncestor();

			switch (btn.getText()) {

			case "회원가입":
				String a1 = text1.getText();
				String a2 = text2.getText();
				String a3 = text3.getText();
				String a4 = text4.getText();
				String a5 = text5.getText();
				test.viewScreen(new LoginPanel());
				break;
			case "취           소":
				test.viewScreen(new InfoPanel());
				break;
			}
		}
	}
}