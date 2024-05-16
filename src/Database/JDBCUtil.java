package Database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.TableModel;

public class JDBCUtil {
	public static Connection getConnection() {
		Connection c = null ;
		
		
		try {
			DriverManager.registerDriver(new org.postgresql.Driver());
			String url = "jdbc:postgresql://localhost:5432/Java" ;
			String username= "postgres" ;
			String password = "123" ;
			
			
			c = DriverManager.getConnection(url,username,password);
		
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			
			
		}
		return c ;
	}
		
	
	public static void closeConnection(Connection c) {
		try {
			if(c!=null) {}
			c.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	public static void printInfo(Connection c){
		if(c!= null) {
			try {
				DatabaseMetaData mtdt = c.getMetaData();
				System.out.println(mtdt.getDatabaseProductName());
				System.out.println(mtdt.getDatabaseProductVersion());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}


	
	

}