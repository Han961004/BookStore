package javaManageTest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class AfterLoginPanel extends JPanel {
	
	JButton btn1, btn2;
	Container c;

	AfterLoginPanel() {
		this.setBackground(Color.white);
		this.setLayout(new BorderLayout());
		btn1 = new JButton("로그인");
		btn2 = new JButton("회원가입");
		
		
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

			FrameTest test = (FrameTest) btn.getTopLevelAncestor();

			
			switch (btn.getText()) {
			case "로그인":
				test.viewScreen(new UserLogin());
				
				break;
			case "회원가입":
				test.viewScreen(new SignUpPanel__());
				
				break;
			}
		}
	}
}
