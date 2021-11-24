package com.housekeepingtool.test;

import org.junit.Test;

import com.awshousekeeping.services.AWSListEc2ResourcesService;
import com.awshousekeeping.services.impl.AWSListEc2ResourcesServiceImpl;

public class TestEc2Resources {

	private AWSListEc2ResourcesService service = new AWSListEc2ResourcesServiceImpl();

	@Test
	public void testEc2Result() {
		service.getAllRegionsEc2Resources(0);

	}
}
