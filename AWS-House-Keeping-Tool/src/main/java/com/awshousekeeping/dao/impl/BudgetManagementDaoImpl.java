package com.awshousekeeping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.awshousekeeping.dao.BudgetManagementDao;
import com.awshousekeeping.model.Budget;
import com.awshousekeeping.utils.BusinessException;
import com.awshousekeeping.utils.CommonUtility;
import com.awshousekeeping.utils.DBConnect;

public class BudgetManagementDaoImpl implements BudgetManagementDao {

	static final Logger logger = Logger.getLogger(BudgetManagementDaoImpl.class);

	@Override
	public boolean addBudget(Budget budget) throws BusinessException {

		Connection con = DBConnect.getConnecttion();
		String sql = "insert into budget (budget_id, budget_start_date, budget_end_date, budget_amount, budget_description, budget_conditional_operator, account_id) value(?,?,?,?,?,?,?)";
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);

			ps.setInt(1, budget.getBudgetId());
			ps.setDate(2, CommonUtility.sqlDateConversion(budget.getBudgetStartDate()));
			ps.setDate(3, CommonUtility.sqlDateConversion(budget.getBudgetEndDate()));
			ps.setDouble(4, budget.getBudgetAmount());
			ps.setString(5, budget.getBudgetDescription());
			ps.setString(6, budget.getBudgetConditionalOperator());
			ps.setInt(7, budget.getAccountId());

			ps.executeUpdate();
			con.close();
			ps.close();
		} catch (SQLException e) {
			logger.error("Error while adding budget", e);
			throw new BusinessException("Error While Adding Budget", e);
		}

		return true;
	}

	@Override
	public int deleteBudget(Budget budget) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateBudget(Budget budget) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Budget> getAllBudget() {
		List<Budget> budgets = new ArrayList();

		Connection con = DBConnect.getConnecttion();
		String sql = "select * from budget";
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				Budget budget = new Budget();
						
				budget.setBudgetId(rs.getInt("budget_id"));
				budget.setBudgetStartDate(new Date());
				budget.setBudgetEndDate(new Date());
				budget.setBudgetAmount(rs.getDouble("budget_amount"));
				budget.setBudgetDescription(rs.getString("budget_description"));
				budget.setBudgetConditionalOperator(rs.getString("budget_conditional_operator"));
				budget.setAccountId(rs.getInt("account_id"));

				budgets.add(budget);

			}

			con.close();
		} catch (SQLException e) {
			logger.error(e);
		}
		return budgets;
	}

	@Override
	public Budget getBudgetByBudgetId(int budgetId) {
		// TODO Auto-generated method stub
		return null;
	}

}
