package Database;

import java.sql.Connection;
import java.sql.DriverManager;

import java.util.Properties;
public class DAO {
	public static Connection getConnection() {
		Connection conn = null;
		 try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		    	String url = "jdbc:sqlserver://DESKTOP-GEUAEG5:1433;databaseName=QLPHONGTRO2";
		    	String userName = "sa";
		    	String password = "123456789";
		    	Properties p = new Properties();
		    	p.put("username", userName);
		    	p.put("password", password);
		    	p.put("encrypt", "false");
		    	conn = DriverManager.getConnection(url,p);
		    	System.out.println("Connection database and java");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		 return conn;
		
	}
	
}
