package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	public static ConnectDB instance = new ConnectDB();
	public static Connection con = null;
	public static ConnectDB getInstance() {
		return instance;
	}
	public static void connect() throws Exception{
		String url = "jdbc:sqlserver://localhost:1433;databasename=QLKhachSan";
		String user = "sa";
		String password = "sapassword";
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void disconnect() {
		if(con != null)
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	public static Connection getConnection() {
		if(con == null)
			try {
				connect();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return con;
	}
}
