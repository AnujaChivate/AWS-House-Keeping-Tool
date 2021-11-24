package com.awshousekeeping.services;

import java.util.List;

import com.awshousekeeping.model.Account;
import com.awshousekeeping.utils.BusinessException;

public interface AccountService {
	
	public List<Account> listAllAccounts();
	
	
	public boolean addAccount(Account account) throws  BusinessException;

}
