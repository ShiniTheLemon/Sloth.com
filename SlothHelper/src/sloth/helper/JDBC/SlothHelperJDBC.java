package sloth.helper.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SlothHelperJDBC {
	

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	 public static Connection getConnection() {
		 Connection con=null;
		 
		 try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sloth_helper?useUnicode=yes&characterEncoding=UTF-8","root","123456789");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return con;
		
	}
	 
	 public static void close(Statement stmt,Connection con)
	 {
		 try {
			stmt.close();
			 con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	 }
	 public static  void close(ResultSet rs, Statement stmt, Connection con)
	 {
		 try {
			rs.close();
			 close( stmt, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	 }
}
