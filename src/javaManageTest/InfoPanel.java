package javaManageTest;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class InfoPanel extends JPanel {
	JButton btn1, btn2;

	InfoPanel() {
		this.setBackground(Color.white);

		btn1 = new JButton("�α���");
		btn2 = new JButton("ȸ������");
		
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
			case "�α���":
				test.viewScreen(new UserLogin());
				break;
			case "ȸ������":
				test.viewScreen(new ScreenPanel2());
				break;
			}
		}
	}
}
