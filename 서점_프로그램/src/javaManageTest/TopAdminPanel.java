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
		btn0 = new JButton("��������");
		btn1 = new JButton("�������");
		btn2 = new JButton("�ֹ����");
		btn3 = new JButton("������");
		btn4 = new JButton("�α׾ƿ�");

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

			__FrameTest__ test = (__FrameTest__) btn.getTopLevelAncestor();

			switch (btn.getText()) {
			case "��������":
				test.viewScreen3(new BookManagement());
				break;
			case "�������":
				test.viewScreen3(new Sales());
				break;
			case "�ֹ����":
				test.viewScreen3(new OrdersList());
				break;
			case "������":
				test.viewScreen3(new MemberManagement());
				break;
			case "�α׾ƿ�":
				test.viewScreen(new InfoPanel());						// ����
				break;

			}
		}
	}
}