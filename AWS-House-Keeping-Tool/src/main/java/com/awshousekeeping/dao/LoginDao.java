package com.awshousekeeping.dao;

import com.awshousekeeping.utils.BusinessException;

public interface LoginDao {

	/**
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	public boolean checkLogin(String userName, String password);
	
	
	public int getRoleByUsername(String userName) throws BusinessException;
	
}
