package com.awshousekeeping.dao;

import java.util.List;

import com.awshousekeeping.model.Account;
import com.awshousekeeping.utils.BusinessException;

public interface AccountManagementDao {
	/**
	 * 
	 * @param account
	 * @return
	 */
	public boolean addAccount(Account account) throws BusinessException;

	/**
	 * 
	 * @param account
	 * @return
	 */
	public int deleteAccount(Account account);

	/**
	 * 
	 * @param account
	 * @return
	 */
	public int updateAccount(Account account);

	/**
	 * 
	 * @return
	 */
	public List<Account> getAllAccount();

	/**
	 * 
	 * @param accountId
	 * @return
	 */
	public Account getAccountByAccountId(int accountId);

}
