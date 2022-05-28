package Demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import SQL.connection;

public class demo {
	
	
	public static void main(String [] args) throws SQLException{
		
		int [] y = {0,0,0,0,0,0,0,0,0,0,0,0};
		
		
		Connection con = connection.makeConnection();
		String sql = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; 
		
		
		for(int i = 1 ; i <13 ; i ++) {
			sql = "select sum(counts) as cnt from sale group by months having months = " + i + ";";			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			rs.next();
			y[i-1] = rs.getInt(1);
			
			System.out.println("1");
		}
		
		
		
		
//		for (int i = 0 ; i < 12; i ++) {
//			sql = "select sum(counts) as cnt from sale group by months having months = " + i + ";";			
//			pstmt = con.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			
//			try {
//				y[i] = rs.getInt(1);
//				System.out.println(y[i]);
//			}catch(Exception e) {
//				System.out.println("dpf");
//			}
//			
//		}
	}
}

