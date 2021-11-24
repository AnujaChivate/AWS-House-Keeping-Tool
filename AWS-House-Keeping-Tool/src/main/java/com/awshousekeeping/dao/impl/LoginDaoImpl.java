package com.awshousekeeping.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.awshousekeeping.dao.LoginDao;
import com.awshousekeeping.utils.BusinessException;
import com.awshousekeeping.utils.DBConnect;
import com.mysql.jdbc.PreparedStatement;

public class LoginDaoImpl implements LoginDao {
	static final Logger logger = Logger.getLogger(LoginDaoImpl.class);

	@Override
	public boolean checkLogin(String userName, String password) {
		logger.debug("---inside Logindao---");

		Connection con = DBConnect.getConnecttion();
		String sql = "select * from user where user_name='" + userName
				+ "' and password='" + password + "'";
		PreparedStatement ps;
		try {
			
			ps = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				con.close();
				return true;
			}

		} catch (SQLException e) {
			logger.error("Error At Login service ", e);

			try {

				con.close();
			} catch (SQLException e1) {
				logger.error("Error while closing connection ", e1);
			}

		}

		return false;
	}

	@Override
	public int getRoleByUsername(String userName) throws BusinessException {

		// select role from user where user_name =
		Connection con = DBConnect.getConnecttion();
		String sql = "select role from user where user_name='" + userName + "'";
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				int role = rs.getInt(1);
				con.close();
				return role;
			}

		} catch (SQLException e) {
			logger.error("Error At Login service ", e);

			try {

				con.close();
			} catch (SQLException e1) {
				logger.error("Error while closing connection ", e1);
				throw new BusinessException("Error while taking role", e1);
			}

		}
		return 0;
	}

}
