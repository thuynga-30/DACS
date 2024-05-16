package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Model.user;
import Database.JDBCUtil;

public class hoSoDAO implements DAOinterface<user>  {
	public static hoSoDAO getInstance() {
		return new hoSoDAO() ; 
	}

	@Override
	public int insert(user t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(user t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(user t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<user> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public user selectById(user t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<user> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}