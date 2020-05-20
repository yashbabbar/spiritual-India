package india;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBUtil {
	
	static String username = "root";
	static String password = "123456";
	static String dbUrl = "jdbc:mysql://localhost:3306/spiritualindia";
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			//Class.forName("jdbc:mysql://localhost:3306/spiritualindia").newInstance();
			 Class.forName("com.mysql.jdbc.Driver");
			 conn = DriverManager.getConnection(dbUrl, username, password);
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return conn;
		
	}

}
