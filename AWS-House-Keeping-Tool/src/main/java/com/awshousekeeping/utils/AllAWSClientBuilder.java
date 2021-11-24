package com.awshousekeeping.utils;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.identitymanagement.AmazonIdentityManagement;
import com.amazonaws.services.identitymanagement.AmazonIdentityManagementClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

public class AllAWSClientBuilder {

	public static final String accessKey = "";
	public static final String secretKey = "";

	public static AmazonIdentityManagement getIAMClient(int acountID) {

		// TODO read from user id get access key and secret keys

		return AmazonIdentityManagementClientBuilder.defaultClient();
	}

	public static AmazonEC2 getEc2Client(int accountID) {

		return AmazonEC2ClientBuilder.defaultClient();
	}

	public static AmazonS3 getEs3Client(int accountID) {

		return AmazonS3ClientBuilder.defaultClient();

	}

	private AllAWSClientBuilder() {

	}
}
