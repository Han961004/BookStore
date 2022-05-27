package javaManageTest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class AdminPanel extends JPanel {
	TopUserPanel top = new TopUserPanel();
	JButton btn1, btn2;
	Container c;

	AdminPanel() {
		
		repaint();
		
		this.setLayout(null);
		this.setBackground(Color.white);
		
		JLabel lbl1 = new JLabel("어서오세요 관리자", JLabel.CENTER);

		lbl1.setBorder(new LineBorder(Color.black, 1));

		lbl1.setBounds(180, 30, 120, 20);

		add(lbl1);
		add(top, BorderLayout.NORTH);
		top.setVisible(true);

		MyActionListener l = new MyActionListener();

	}

	class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			JButton btn = (JButton) e.getSource();

			FrameTest test = (FrameTest) btn.getTopLevelAncestor();

		}
	}
}
