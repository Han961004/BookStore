package javaManageTest;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class InfoPanel extends JPanel {
	JButton btn1, btn2;
	TopUserPanel top = new TopUserPanel();

	InfoPanel() {
		this.setBackground(Color.white);
		this.setLayout(null);
		btn1 = new JButton("로그인");
		btn1.setBounds(150, 30, 90, 30);
		btn2 = new JButton("회원가입");
		btn2.setBounds(240, 30, 90, 30);
		
		this.add(btn1);
		this.add(btn2);
		
		MyActionListener l = new MyActionListener();

		btn1.addActionListener(l);
		btn2.addActionListener(l);
	}

	class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			JButton btn = (JButton) e.getSource();

			__FrameTest__ test = (__FrameTest__) btn.getTopLevelAncestor();

			switch (btn.getText()) {
			case "로그인":
				test.viewScreen(new LoginClick());
				break;
			case "회원가입":
				test.viewScreen(new SignUpPanel__O());
				break;
			}
		}
	}
}
