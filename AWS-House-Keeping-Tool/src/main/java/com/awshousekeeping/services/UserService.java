package com.awshousekeeping.services;

import java.util.List;

import com.awshousekeeping.model.User;
import com.awshousekeeping.utils.BusinessException;

public interface UserService {
	/**
	 * This method return all users list
	 * 
	 * @return List<User>
	 */
	public List<User> listAllUsers();

	public boolean addUser(User user) throws BusinessException;

}
