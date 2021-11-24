package com.awshousekeeping.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.ec2.model.DescribeInstancesRequest;
import com.amazonaws.services.ec2.model.DescribeInstancesResult;
import com.amazonaws.services.ec2.model.DescribeRegionsResult;
import com.amazonaws.services.ec2.model.Instance;
import com.amazonaws.services.ec2.model.Region;
import com.amazonaws.services.ec2.model.Reservation;
import com.awshousekeeping.services.AWSListEc2ResourcesService;
import com.awshousekeeping.utils.AllAWSClientBuilder;

public class AWSListEc2ResourcesServiceImpl implements
		AWSListEc2ResourcesService {

	static final Logger logger = Logger.getLogger(LoginServiceImpl.class);

	@Override
	public Map<String, List<Instance>> getAllRegionsEc2Resources(int accountId) {

		AmazonEC2 ec2 = AllAWSClientBuilder.getEc2Client(0);

		DescribeRegionsResult describeRegionsResult = ec2.describeRegions();

		List<Region> regionList = describeRegionsResult.getRegions();

		HashMap<String, List<Instance>> resultMap = new HashMap<>();
		for (Region r : regionList) {

			AmazonEC2ClientBuilder builder = AmazonEC2ClientBuilder.standard();

			builder.setEndpointConfiguration(new EndpointConfiguration(r.getEndpoint(), null));
			AmazonEC2 ec2clinet = builder.build();
			DescribeInstancesResult describeInstancesResult = ec2clinet
					.describeInstances();
			
			
			for (Reservation res : describeInstancesResult.getReservations()) {

				resultMap.put(r.getRegionName(), res.getInstances());

				logger.info("region name : " + r.getRegionName() + "   :"
						+ res.getInstances().toString());

			}

		}

		return resultMap;
	}
}
