package Demo;

import javax.swing.*;
import javax.swing.event.*;


public class prac extends JFrame{         
    
    public static void main(String[] args) {   
        
        JFrame f = new JFrame("����������");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setSize(200,200);
        f.setVisible(true);
                
        DefaultListModel<String> m = new DefaultListModel<>();
        m.addElement("����");
        m.addElement("�ܹ���");
        m.addElement("�Ŷ��");      
        m.addElement("�����");
        
        JList l = new JList(m);     
        f.add(l);
        
        l.addListSelectionListener(new ListSelectionListener() {
            
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {                     
                    
                    System.out.println( l.getSelectedValuesList() );
                }
            }           
        });
    }      
}