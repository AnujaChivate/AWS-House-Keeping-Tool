package com.awshousekeeping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.awshousekeeping.dao.UserManagementDao;
import com.awshousekeeping.model.User;
import com.awshousekeeping.utils.BusinessException;
import com.awshousekeeping.utils.CommonUtility;
import com.awshousekeeping.utils.DBConnect;

public class UserManagementDaoImpl implements UserManagementDao {

	static final Logger logger = Logger.getLogger(UserManagementDaoImpl.class);

	@Override
	public boolean addUser(User user) throws BusinessException {

		Connection con = DBConnect.getConnecttion();
		String sql = "insert into user (user_name,first_name,last_name,password,email,created_on,role,is_active,created_by,updated_by,updated_on ) value(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getFirstName());
			ps.setString(3, user.getLastName());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getEmail());
			ps.setDate(6, CommonUtility.sqlDateConversion(user.getCreateOn()));
			ps.setInt(7, user.getRole());
			ps.setInt(8, user.getIsActive());
			ps.setString(9, user.getCreatedBy());
			ps.setString(10, user.getUpdatedBy());
			ps.setDate(11, CommonUtility.sqlDateConversion(user.getUpdatedOn()));

			ps.executeUpdate();
			con.close();
			ps.close();
		} catch (SQLException e) {
			logger.error("Error while adding user", e);
			throw new BusinessException("Error While Adding User", e);
		}

		return true;
	}

	@Override
	public int deleteUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<User> getAllUser() {
		List<User> users = new ArrayList<User>();

		Connection con = DBConnect.getConnecttion();
		String sql = "select * from user";
		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				User user = new User();

				user.setFirstName(rs.getString("first_Name"));
				user.setCreateOn(rs.getDate("created_on"));
				user.setUid(rs.getInt("uid"));
				user.setUserName(rs.getString("user_name"));
				user.setLastName(rs.getString("last_name"));
				user.setPassword("******");
				user.setEmail(rs.getString("email"));
				user.setRole(rs.getInt("role"));
				user.setUpdatedBy(rs.getString("updated_by"));
				user.setUpdatedOn(new Date());
				user.setCreatedBy(rs.getString("created_by"));
				user.setIsActive(rs.getInt("is_active"));

				users.add(user);

			}

			con.close();
		} catch (SQLException e) {
			logger.error(e);
		}
		return users;
	}

	@Override
	public User getUserByUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
