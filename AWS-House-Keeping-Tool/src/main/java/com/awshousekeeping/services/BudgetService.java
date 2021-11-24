package com.awshousekeeping.services;

import java.util.List;

import com.awshousekeeping.model.Budget;
import com.awshousekeeping.utils.BusinessException;

public interface BudgetService {
	/**
	 * This method return all budgets list
	 * 
	 * @return List<Budget>
	 */
	public List<Budget> listAllBudgets();

	public boolean addBudget(Budget budget) throws BusinessException;

}