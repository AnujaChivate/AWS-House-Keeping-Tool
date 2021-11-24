package com.awshousekeeping.services;

import java.util.List;
import java.util.Map;

import com.amazonaws.services.ec2.model.Instance;

public interface AWSListEc2ResourcesService {

	/**
	 * 
	 * @param accountId
	 * @return
	 */
	public Map<String, List<Instance>> getAllRegionsEc2Resources(
			int accountId);
}
