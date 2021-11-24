package com.awshousekeeping.utils;

import java.sql.Date;

/**
 * 
 * @author 
 *
 */
public class CommonUtility {
	private CommonUtility() {
	}

	public static Date sqlDateConversion(java.util.Date utilDate) {
		return new java.sql.Date(utilDate.getTime());
	}
}
