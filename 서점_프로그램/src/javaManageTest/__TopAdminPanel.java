package javaManageTest;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class __TopAdminPanel extends JPanel {
	JButton btn0, btn1, btn2, btn3, btn4;

	__TopAdminPanel() {
		this.setLayout(new GridLayout(0, 5));
		btn0 = new JButton("도서추가");
		btn1 = new JButton("도서수정");
		btn2 = new JButton("주문목록");
		btn3 = new JButton("고객정보");
		btn4 = new JButton("로그아웃");

		this.setVisible(true);

		MyActionListener l = new MyActionListener();

		btn0.addActionListener(l);
		btn1.addActionListener(l);
		btn2.addActionListener(l);
		btn3.addActionListener(l);
		btn4.addActionListener(l);
		
		this.add(btn0);
		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
		this.add(btn4);
		
		this.revalidate();

		
	}

	class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			JButton btn = (JButton) e.getSource();

			FrameTest test = (FrameTest) btn.getTopLevelAncestor();

			switch (btn.getText()) {
			case "도서추가":
				test.viewScreen3(new AddBookPanel__());
				break;
			case "도서수정":
				test.viewScreen3(new AdminBookSearch__());
				break;
			case "주문목록":
				test.viewScreen3(new AdminOrderList__());
				break;
			case "고객정보":
				test.viewScreen3(new PersonalImformation());
				break;
			case "로그아웃":
				test.viewScreen(new InfoPanel());						// 변경
				break;

			}
		}
	}
}