package com.awshousekeeping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.awshousekeeping.dao.AccountManagementDao;
import com.awshousekeeping.model.Account;
import com.awshousekeeping.utils.BusinessException;
import com.awshousekeeping.utils.CommonUtility;
import com.awshousekeeping.utils.DBConnect;

public class AccountManagementDaoImpl implements AccountManagementDao {

	static final Logger logger = Logger.getLogger(UserManagementDaoImpl.class);

	@Override
	public boolean addAccount(Account account) throws BusinessException {

		Connection con = DBConnect.getConnecttion();
		String sql = "insert into account(account_id,created_on,created_by,updated_on,updated_by,hsps_id,project_expire_date,free_trial_expire_date,AWS_account_owner_name,hsps_expire_date,email_id_of_owner,project_name,project_id,account_type,hsps_description,business_unit,AWS_account_number,AWS_account_alias,AWS_access_key,AWS_secret_key,AWS_access_key_XXXX,AWS_secret_key_XXXX ) value(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);

			ps.setInt(1, account.getAccountId());
			ps.setDate(2, CommonUtility.sqlDateConversion(new Date()));
			ps.setString(3, "Anuja");
			ps.setDate(4, CommonUtility.sqlDateConversion(new Date()));
			ps.setString(5, account.getUpdatedBy());
			ps.setString(6, account.getHspsId());
			ps.setDate(7, CommonUtility.sqlDateConversion(new Date()));
			ps.setDate(8, CommonUtility.sqlDateConversion(new Date()));
			ps.setString(9, account.getAwsAccountOwnerName());
			ps.setDate(10, CommonUtility.sqlDateConversion(new Date()));
			ps.setString(11, account.getEmailIdOfOwner());
			ps.setString(12, account.getProjectName());
			ps.setString(13, account.getProjectId());
			ps.setString(14, account.getAccountType());
			ps.setString(15, account.getHspsDescription());
			ps.setString(16, account.getBusinessUnit());
			ps.setString(17, account.getAwsAccountNumber());
			ps.setString(18, account.getAwsAccountAlias());
			ps.setString(19, account.getAwsAccessKey());
			ps.setString(20, account.getAwsSecretKey());
			ps.setString(21, account.getAwsAccessKeyXXXX());
			ps.setString(22, account.getAwsSecretKeyXXXX());

			ps.executeUpdate();
			con.close();
			ps.close();
		} catch (SQLException e) {
			logger.error("Error while adding account", e);
			throw new BusinessException("Error While Adding Account", e);
		}

		return true;

	}

	@Override
	public int deleteAccount(Account account) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateAccount(Account account) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Account> getAllAccount() {
		List<Account> accounts = new ArrayList();

		Connection con = DBConnect.getConnecttion();
		String sql = "select * from account";
		try {
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				Account account = new Account();

				account.setAccountId(rs.getInt("account_id"));
				account.setCreatedOn(rs.getDate("created_on"));
				account.setCreatedBy(rs.getString("created_by"));
				account.setUpdatedOn(rs.getDate("updated_on"));
				account.setUpdatedBy(rs.getString("updated_by"));
				account.setHspsId(rs.getString("hsps_id"));
				account.setProjectExpireDate(rs.getDate("project_expire_date"));
				account.setFreeTrialExpireDate(rs
						.getDate("free_trial_expire_date"));
				account.setAwsAccountOwnerName(rs
						.getString("AWS_account_owner_name"));
				account.setHspsExpireDate(rs.getDate("hsps_expire_date"));
				account.setEmailIdOfOwner(rs.getString("email_id_of_owner"));
				account.setProjectName(rs.getString("project_name"));
				account.setProjectId(rs.getString("project_id"));
				account.setAccountType(rs.getString("account_type"));
				account.setHspsDescription(rs.getString("hsps_description"));
				account.setBusinessUnit(rs.getString("business_unit"));
				account.setAwsAccountNumber(rs.getString("AWS_account_number"));
				account.setAwsAccountAlias(rs.getString("AWS_account_alias"));
				account.setAwsAccessKey(rs.getString("AWS_access_key"));
				account.setAwsSecretKey(rs.getString("AWS_secret_key"));
				account.setAwsAccessKeyXXXX(rs.getString("AWS_access_key_XXXX"));
				account.setAwsSecretKeyXXXX(rs.getString("AWS_secret_key_XXXX"));

				accounts.add(account);

			}

			con.close();
		} catch (SQLException e) {
			logger.error(e);
		}
		return accounts;
	}

	@Override
	public Account getAccountByAccountId(int accountId) {
		// TODO Auto-generated method stub
		return null;
	}
}
