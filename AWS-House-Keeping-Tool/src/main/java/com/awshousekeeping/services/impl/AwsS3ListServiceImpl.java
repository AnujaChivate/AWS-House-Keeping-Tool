package com.awshousekeeping.services.impl;

import java.util.List;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;
import com.awshousekeeping.services.AwsS3ListService;
import com.awshousekeeping.utils.AllAWSClientBuilder;

public class AwsS3ListServiceImpl implements AwsS3ListService {

	@Override
	public List<Bucket>  listAWSs3Buckets(int accountid) {
		 AmazonS3  s3=	AllAWSClientBuilder.getEs3Client(0);
		
		return s3.listBuckets();
		
	}

}
