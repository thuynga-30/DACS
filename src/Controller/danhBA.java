package Controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Database.JDBCUtil;
import Model.DanhBa;

public class danhBA implements DAOinterface<DanhBa> {

    public static danhBA getInstance() {
        return new danhBA(); // Fixed the method name to lowercase "danhBA"
    }

    @Override
    public int insert(DanhBa t) {
        // TODO: Implement the insert method
        return 0;
    }

    
    @Override
    public int update(DanhBa t) {
        Connection con = null;
        PreparedStatement ps = null;
        
        try {
            con = JDBCUtil.getConnection();
            String sql = "UPDATE public.\"danhBa\" SET \"Name\"=?, \"Nam_Sinh\"=?, \"Dia_Chi\"=?, \"sDT\"=?, \"Anh\"=? WHERE \"sDT\"=?";
            ps = con.prepareStatement(sql);
            
            ps.setString(1, t.getTen());
            ps.setInt(2, t.getnS());
            ps.setString(3, t.getdC());
            ps.setString(4, t.getsDT());
            ps.setBytes(5, t.getAnh());
            ps.setString(6, t.getsDT()); // Sử dụng số điện thoại để xác định dòng cần cập nhật
            
            int rowsAffected = ps.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("Update successful!");
            } else {
                System.out.println("Update failed!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(con);
            try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        return 0;
    }


    @Override
    public int delete(DanhBa t) {
        Connection con = null;
        PreparedStatement ps = null;
        
        try {
            con = JDBCUtil.getConnection();
            String sql = "DELETE FROM public.\"danhBa\" WHERE sDT=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, t.getsDT());
            
            int rowsAffected = ps.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("Delete successful!");
            } else {
                System.out.println("Delete failed!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(con);
            try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        return 0;
    }

      
 

    @Override
    public ArrayList<DanhBa> selectAll() {
        ArrayList<DanhBa> ketqua = new ArrayList<>();
        try {
            // Establish a database connection
            Connection con = JDBCUtil.getConnection();

            // Create a statement object
            Statement st = con.createStatement();

            // Execute the SQL query
            String sql = "SELECT * FROM \"danhBa\"";
            System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);

            // Process the result set
            while (rs.next()) {
                String ten = rs.getString("Name");
                int nS = rs.getInt("Nam_sinh");
                String dC = rs.getString("Dia_chi");
                String sDT = rs.getString("sDT");
                byte[] anh = rs.getBytes("Anh"); // Corrected the data type to lowercase "byte[]"

                DanhBa sach = new DanhBa(ten, nS, dC, sDT, anh);
                ketqua.add(sach);
            }

            // Close the connection
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ketqua;
    }

    @Override
    public DanhBa selectById(DanhBa t) {
        // TODO: Implement the selectById method
        return null;
    }

    @Override
    public ArrayList<DanhBa> selectByCondition(String condition) {
        // TODO: Implement the selectByCondition method
        return null;
    }
}
