package com.housekeepingtool.test;

import org.junit.Test;

import com.awshousekeeping.services.AwsIamUserService;
import com.awshousekeeping.services.impl.AwsIamUserServiceImpl;

public class TestIAMUserManagement {

	private AwsIamUserService awsIamUserService = new AwsIamUserServiceImpl();

	@Test
	public void awstest() throws Exception {
		
		try{
		System.out.println(" --- " + awsIamUserService.getAllIAMUSers(1));
		}
		catch( Exception e)
		{
			e.printStackTrace();
		}
	}

}
