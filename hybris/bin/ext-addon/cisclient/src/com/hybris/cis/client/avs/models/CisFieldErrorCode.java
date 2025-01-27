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
package com.hybris.cis.client.avs.models;



/**
 * Represents a field error.
 */
public enum CisFieldErrorCode
{
	/** The field is missing. */
	MISSING,

	/** The field is invalid. */
	INVALID,

	/** The field when standardized was truncated. */
	TRUNCATED,

	/** The field when standardized was corrected. */
	CORRECTED;

	private CisFieldErrorCode()
	{
		// empty
	}

}
