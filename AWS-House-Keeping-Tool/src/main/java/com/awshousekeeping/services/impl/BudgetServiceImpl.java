package com.awshousekeeping.services.impl;

import java.util.List;

import com.awshousekeeping.dao.BudgetManagementDao;
import com.awshousekeeping.dao.impl.BudgetManagementDaoImpl;
import com.awshousekeeping.model.Budget;
import com.awshousekeeping.services.BudgetService;
import com.awshousekeeping.utils.BusinessException;

public class BudgetServiceImpl implements BudgetService {

	private BudgetManagementDao budgetManagementDao = new BudgetManagementDaoImpl();

	@Override
	public List<Budget> listAllBudgets() {

		return budgetManagementDao.getAllBudget();
	}

	@Override
	public boolean addBudget(Budget budget) throws BusinessException {

		return budgetManagementDao.addBudget(budget);

	}

}
