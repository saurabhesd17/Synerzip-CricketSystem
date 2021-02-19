import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
	private static String url = "jdbc:mysql://localhost:3360/cricket";
	private static String user = "root";
	private static String password = "saurabh17";
	
	public static Connection connect() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);
		return con;
	}
}
