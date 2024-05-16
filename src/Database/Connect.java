package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JComponent;

import Model.DanhBa;


public class Connect {
	static String driver ="org.postgresql.Driver";
    static String url = "jdbc:postgresql://localhost:5432/Java" ;
    static String username= "postgres" ;
    static String password = "123" ;
    public static Connection getConnection() {
		Connection conn= null;
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, username, password);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		  return conn;
		}
    public static void update(DanhBa danhBa) {
    	Connection con= getConnection();
    	String sql="UPDATE public.\"danhba\" SET \"Name\"=?, \"Nam_Sinh\"=?, \"Dia_Chi\"=?, \"sDT\"=?, \"Anh\"=? WHERE \"sDT\"="+danhBa.getsDT()+";" ;
    	try {
    		PreparedStatement ps= con.prepareStatement(sql);
    		ps.setString(1,danhBa.getTen());
    		ps.setInt(2,danhBa.getnS());
    		ps.setString(3,danhBa.getdC());
    		ps.setString(4,danhBa.getsDT());
    		ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
    public static void delete(DanhBa danhBa) {
    	Connection con= getConnection();
    	String sql="DELETE FROM public.\"danhBa\""
    			+ "	WHERE \"sDT\" = ? ;";
    	try {
    		
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setString(1, danhBa.getsDT());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
	public static Connect getInstance() {
		// TODO Auto-generated method stub
		return new Connect();
	}
}
