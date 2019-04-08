
package com.wys.dao;

import java.sql.*;


import com.wys.javabean.User;
import com.wys.util.DBUtil;



public class userDao {
	/**
	 * ÓÃ»§Ìí¼Ó
	 * @param user
	 * @throws SQLException 
	 */
	
	

	public int addUser(User user)  {
		int n = 0;
		Connection conn = DBUtil.getConnection();
		String sql = "insert into tb_users(USER_LOGNAME,USER_PWD,USER_REALNAME,USER_EMAIL,USER_ROLE,USER_STATE) values(?,?,?,?,?,?)";
		PreparedStatement stmt=null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getUserLogname());
			stmt.setString(2, user.getUserPwd());
			stmt.setString(3, user.getUserRealname());
			stmt.setString(4, user.getUserEmail());
			stmt.setInt(5, user.getUserRole());
			stmt.setInt(6, user.getUserState());
			System.out.println(stmt);
			n=stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeJDBC(null, stmt, conn);
		}
		return n;
	}
	
	

}
