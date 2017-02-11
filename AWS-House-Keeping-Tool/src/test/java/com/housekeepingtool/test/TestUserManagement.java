package com.housekeepingtool.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.awshousekeeping.dao.UserManagementDao;
import com.awshousekeeping.model.User;
import com.awshousekeeping.services.UserService;
import com.awshousekeeping.services.impl.UserServiceImpl;
import com.awshousekeeping.utils.BusinessException;

public class TestUserManagement {

	@Mock
	private UserManagementDao useDao;

	@InjectMocks
	private UserService userService = new UserServiceImpl();

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testAddUser() throws BusinessException {

		when(useDao.addUser(Mockito.any(User.class))).thenReturn(true);
		Boolean result = userService.addUser(Mockito.any(User.class));
		assertEquals(result, true);

	}

	@Test
	public void testListAllUser() throws BusinessException {
		when(useDao.getAllUser()).thenReturn(getDummyListUser());

		List<User> ulist = userService.listAllUsers();
		assertEquals(ulist.size(), 1);
	}

	private User getDummyUser() {
		User u = new User();
		u.setCreatedBy("pavan");
		u.setUid(1);
		u.setCreateOn(new Date());
		u.setLastName("pawar");
		u.setPassword("abcd");
		u.setRole(1);
		u.setIsActive(1);
		u.setUpdatedBy("admin");
		return u;

	}

	private List<User> getDummyListUser() {
		List<User> ulist = new ArrayList<>();
		ulist.add(getDummyUser());
		return ulist;
	}
}
