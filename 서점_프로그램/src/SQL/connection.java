package SQL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection {
	public static Connection makeConnection() {
		String url = "jdbc:mysql://localhost/project?serverTimezone=Asia/Seoul";
		Connection con = null;
			 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("������ ���� �� ...");
			con = DriverManager.getConnection(url, "root", "1234");
			System.out.println("���� ����");
		}catch (ClassNotFoundException e) {	
				System.out.println("JDBC ����̹��� ã�� ����");
		}catch (SQLException e) {
			System.out.println("������ ���� ����");
		} 
		return con;
	}
}
