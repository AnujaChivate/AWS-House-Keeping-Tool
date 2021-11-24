package com.awshousekeeping.services;

import com.awshousekeeping.utils.BusinessException;

public interface LoginService {
	public int isUserValid(String user, String password) throws BusinessException;

}
