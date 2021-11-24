package com.housekeepingtool.test;

import org.junit.Test;

import com.awshousekeeping.services.AwsS3ListService;
import com.awshousekeeping.services.impl.AwsS3ListServiceImpl;

public class TestS3Resources {

	private AwsS3ListService awsS3ListService = new AwsS3ListServiceImpl();

	@Test
	public void testListS3() {
		System.out.println(awsS3ListService.listAWSs3Buckets(0).toString());
	}

}
