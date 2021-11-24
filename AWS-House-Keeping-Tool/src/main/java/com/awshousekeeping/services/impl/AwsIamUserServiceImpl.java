package com.awshousekeeping.services.impl;

import com.amazonaws.services.identitymanagement.AmazonIdentityManagement;
import com.amazonaws.services.identitymanagement.model.GetUserRequest;
import com.amazonaws.services.identitymanagement.model.GetUserResult;
import com.amazonaws.services.identitymanagement.model.ListUsersResult;
import com.awshousekeeping.services.AwsIamUserService;
import com.awshousekeeping.utils.AllAWSClientBuilder;
import com.awshousekeeping.utils.BusinessException;

public class AwsIamUserServiceImpl implements AwsIamUserService {

	@Override
	public ListUsersResult getAllIAMUSers(int acountID) throws Exception {

		try {
			AmazonIdentityManagement iamClient = AllAWSClientBuilder
					.getIAMClient(acountID);

			GetUserRequest getusereq = new GetUserRequest();
			GetUserResult u = iamClient.getUser(getusereq);
			return iamClient.listUsers();

		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("error at get user", e);
		}

	}

}
