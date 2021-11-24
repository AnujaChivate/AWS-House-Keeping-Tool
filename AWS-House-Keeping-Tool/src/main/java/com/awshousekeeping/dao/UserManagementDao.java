package com.awshousekeeping.dao;

import java.util.List;

import com.awshousekeeping.model.User;
import com.awshousekeeping.utils.BusinessException;

/**
 * 
 * @author
 *
 */
public interface UserManagementDao {

	/**
	 * 
	 * @param user
	 * @return
	 */
	public boolean addUser(User user) throws BusinessException;

	/**
	 * 
	 * @param user
	 * @return
	 */
	public int deleteUser(User user);

	/**
	 * 
	 * @param user
	 * @return
	 */
	public int updateUser(User user);

	/**
	 * 
	 * @return
	 */
	public List<User> getAllUser();

	/**
	 * 
	 * @param userId
	 * @return
	 */
	public User getUserByUserId(int userId);

}
