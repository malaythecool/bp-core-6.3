/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2015 hybris AG
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 *
 *
 */
package com.hybris.cis.client.payment.models;


/**
 * Capture type enum.
 */
public enum CisCaptureCompleteType
{
	/**
	 * COMPLETE capture.
	 */
	COMPLETE,
	/**
	 * Partial capture.
	 */
	NOT_COMPLETE;

	/**
	 * Get the enum value from a string value.
	 * 
	 * @param v the string value
	 * @return the enum values
	 */
	public static CisCaptureCompleteType fromValue(final String v)
	{
		for (final CisCaptureCompleteType c : CisCaptureCompleteType.values())
		{
			if (c.toString().equalsIgnoreCase(v))
			{
				return c;
			}
		}
		throw new IllegalArgumentException("No enum value found for: " + v);
	}
}
