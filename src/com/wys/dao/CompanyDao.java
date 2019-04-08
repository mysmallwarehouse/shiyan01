package com.wys.dao;

import java.sql.*;

import com.wys.javabean.Company;
import com.wys.util.DBUtil;

public class CompanyDao {

	/**
	 * 企业信息添加
	 * 
	 * @param company
	 * @return 
	 */
	public int  save(Company company) {
		int n = 0;
		Connection conn = DBUtil.getConnection();
		String sql = "insert into tb_company(COMPANY_NAME,COMPANY_AREA,COMPANY_SIZE,COMPANY_TYPE,COMPANY_BRIEF,COMPANY_STATE,COMPANY_SORT,COMPANY_VIEWNUM,COMPANY_PIC) values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt=null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, company.getCompanyName());
			stmt.setString(2, company.getCompanyArea());
			stmt.setString(3, company.getCompanySize());
			stmt.setString(4, company.getCompanyType());
			stmt.setString(5, company.getCompanybrief());
			stmt.setInt(6, company.getCompanyState());
			stmt.setInt(7, company.getCompanySort());
			stmt.setInt(8, company.getCompanyViewnum());
			stmt.setString(9, company.getCompanyPic());
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
