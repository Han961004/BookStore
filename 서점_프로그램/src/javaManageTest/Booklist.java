package javaManageTest;

import java.awt.Color;
import java.awt.Frame;
import java.awt.List;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import SQL.connection;

public class Booklist extends JPanel {
	
	Booklist() {
		
		Panel p = new Panel();
        p.setLayout(null);
        p.setSize(450, 400);
        
		List li = new List();
		li.setBounds(0,0,450,300);
		li.removeAll(); // 리스트 내용을 전부 제거한다.
        
        try{
        	Connection con = connection.makeConnection();
    		String sql = null;
    		ResultSet rs = null; 
    		PreparedStatement pstmt = null;
    		
    		sql = "select * from books order by bname;";
    		pstmt = con.prepareStatement(sql);
    		
    		rs = pstmt.executeQuery();
    		while (rs.next()) {
    			String str = rs.getNString(1) + "  /  " + rs.getNString(3) + "  /  " + rs.getNString(2);
                li.add(str); // 리스트에 데이터를 추가한다.
    		}
        }catch(SQLException sqle){
            
        }
        p.add(li);
        add(p);
	}
}
