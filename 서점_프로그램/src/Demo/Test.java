package Demo;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class MyFrame2 extends JFrame implements ListSelectionListener{
	JList<String> jlist;
	JLabel label;
	public MyFrame2(){
		String[] s = {"1", "2", "3", "4"};
		jlist = new JList<String>(s);
		label = new JLabel("");
		jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jlist.addListSelectionListener(this);
		this.add(jlist);
		this.add(label, BorderLayout.SOUTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 200);
		this.setVisible(true);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		
		
		if(jlist.getSelectedIndex() == 0)
		label.setText("1이 선택 되었습니다.");
	}
	
	
	
	public void mouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {

            // Double-click detected
            int index = jlist.locationToIndex(evt.getPoint());
        }
    }

}

public class Test {
	public static void main(String[] args) {
		new MyFrame2();
	}
}