package com.awshousekeeping.services;

import com.amazonaws.services.identitymanagement.model.ListUsersResult;


public interface AwsIamUserService {

	
	public ListUsersResult getAllIAMUSers(int accountId) throws Exception;
	
}