package be.nathanPire.BusinessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {
	private Connection conn;
	private static GetConnection instance;
	public Connection getConnection() {
		return conn;
	}
	private GetConnection() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn=DriverManager.getConnection("jdbc:sqlserver://dbjavaprojectpire.database.windows.net:1433;database=Database;user=thelittlewozniak@dbjavaprojectpire;password={azerty1234@};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static GetConnection getInstance() {
		if(instance==null) {
			instance=new GetConnection();
		}
		return instance;
	}
}
