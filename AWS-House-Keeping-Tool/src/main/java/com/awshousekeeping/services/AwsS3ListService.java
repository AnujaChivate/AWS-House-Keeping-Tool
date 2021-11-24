package com.awshousekeeping.services;

import java.util.List;

import com.amazonaws.services.s3.model.Bucket;

/**
 * 
 * @author
 *
 */
public interface AwsS3ListService {

	public List<Bucket> listAWSs3Buckets(int accountid);
}
