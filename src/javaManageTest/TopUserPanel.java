package javaManageTest;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class TopUserPanel extends JPanel {
	JButton btn0, btn1, btn2, btn3, btn4;

	TopUserPanel() {
		this.setLayout(new GridLayout(0, 5));
		btn0 = new JButton("도서목록");
		btn1 = new JButton("도서검색");
		btn2 = new JButton("도서주문");
		btn3 = new JButton("주문목록");
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
			case "도서목록":
				test.viewScreen2(new Booklist());
				break;
			case "도서검색":
				test.viewScreen2(new BookSearch());
				break;
			case "도서주문":
				test.viewScreen2(new ScreenPanel2());
				break;
			case "주문목록":
				test.viewScreen2(new ScreenPanel3());
				break;
			case "종료":
				System.exit(0);
			}
		}
	}
}