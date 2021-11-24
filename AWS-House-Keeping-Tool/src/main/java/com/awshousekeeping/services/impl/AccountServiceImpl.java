/**
 * 
 */
package com.awshousekeeping.services.impl;

import java.util.List;

import com.awshousekeeping.dao.AccountManagementDao;
import com.awshousekeeping.dao.impl.AccountManagementDaoImpl;
import com.awshousekeeping.model.Account;
import com.awshousekeeping.services.AccountService;
import com.awshousekeeping.utils.BusinessException;

/**
 * @author DELL
 *
 */
public class AccountServiceImpl implements AccountService {

	private AccountManagementDao accountManagementDao = new AccountManagementDaoImpl();

	@Override
	public List<Account> listAllAccounts() {

		return accountManagementDao.getAllAccount();
	}

	@Override
	public boolean addAccount(Account account) throws BusinessException {

		return accountManagementDao.addAccount(account);

	}

}
