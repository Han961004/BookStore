package javaManageTest;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class __TopUserPanel extends JPanel {
	JButton btn0, btn1, btn2, btn3, btn4;

	__TopUserPanel() {
		this.setLayout(new GridLayout(0, 5));
		btn0 = new JButton("�������");
		btn1 = new JButton("�����˻�");
		btn2 = new JButton("�����ֹ�");
		btn3 = new JButton("�ֹ����");
		btn4 = new JButton("�α׾ƿ�");

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
			case "�������":
				test.viewScreen2(new Booklist___());
				break;
			case "�����˻�":
				test.viewScreen2(new UserBookSearch__());
				break;
			case "�����ֹ�":
				//test.viewScreen2(new UserOrderList__());
				break;
			case "�ֹ����":
				test.viewScreen2(new UserOrderList__());
				break;
			case "�α׾ƿ�":										// ����
				test.viewScreen(new InfoPanel());
				break;
			}
		}
	}
}