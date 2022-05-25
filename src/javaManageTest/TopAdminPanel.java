package javaManageTest;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class TopAdminPanel extends JPanel {
	JButton btn0, btn1, btn2, btn3, btn4;

	TopAdminPanel() {
		this.setLayout(new GridLayout(0, 5));
		btn0 = new JButton("도서추가");
		btn1 = new JButton("도서수정");
		btn2 = new JButton("주문목록");
		btn3 = new JButton("고객정보");
		btn4 = new JButton("종료");

		this.setVisible(true);

		this.add(btn0);
		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
		this.add(btn4);

		MyActionListener l = new MyActionListener();

		btn0.addActionListener(l);
		btn1.addActionListener(l);
		btn2.addActionListener(l);
		btn3.addActionListener(l);
		btn4.addActionListener(l);

	}

	class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			JButton btn = (JButton) e.getSource();

			FrameTest test = (FrameTest) btn.getTopLevelAncestor();

			switch (btn.getText()) {
			case "도서추가":
				test.viewScreen3(new Booklist());
				break;
			case "도서수정":
				test.viewScreen3(new BookSearch());
				break;
			case "주문목록":
				test.viewScreen3(new ScreenPanel2());
				break;
			case "고객정보":
				test.viewScreen3(new ScreenPanel3());
				break;
			case "종료":
				System.exit(0);

			}
		}
	}
}