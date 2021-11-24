package com.awshousekeeping.dao;

import java.util.List;

import com.awshousekeeping.model.Budget;
import com.awshousekeeping.utils.BusinessException;

/**
 * 
 * @author
 *
 */
public interface BudgetManagementDao {

	/**
	 * 
	 * @param budget
	 * @return
	 */
	public boolean addBudget(Budget budget) throws BusinessException;

	/**
	 * 
	 * @param budget
	 * @return
	 */
	public int deleteBudget(Budget budget);

	/**
	 * 
	 * @param budget
	 * @return
	 */
	public int updateBudget(Budget budget);

	/**
	 * 
	 * @return
	 */
	public List<Budget> getAllBudget();

	/**
	 * 
	 * @param budgetId
	 * @return
	 */
	public Budget getBudgetByBudgetId(int budgetId);

}
