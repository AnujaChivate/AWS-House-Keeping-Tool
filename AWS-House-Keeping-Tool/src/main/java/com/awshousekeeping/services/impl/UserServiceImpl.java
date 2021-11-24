package com.awshousekeeping.services.impl;

import java.util.List;

import com.awshousekeeping.dao.UserManagementDao;
import com.awshousekeeping.dao.impl.UserManagementDaoImpl;
import com.awshousekeeping.model.User;
import com.awshousekeeping.services.UserService;
import com.awshousekeeping.utils.BusinessException;

public class UserServiceImpl implements UserService {

	private UserManagementDao userManagementDao = new UserManagementDaoImpl();

	@Override
	public List<User> listAllUsers() {

		return userManagementDao.getAllUser();
	}

	@Override
	public boolean addUser(User user) throws BusinessException {

		return userManagementDao.addUser(user);

	}

}
