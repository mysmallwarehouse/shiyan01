package com.wys.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {

	static {
		try {

			Class.forName("com.mysql.jdbc.Driver"); // �������ݿ�������

			Class.forName("org.gjt.mm.mysql.Driver"); // �������ݿ�������

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		Connection conn = null;
		try {

			 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/itoffer", "root", "123456789"); // url username password																										 																											

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/itoffer", "root", "123456789"); // url username password																										 																											

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void closeJDBC(ResultSet rs, Statement stmt, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	

}
