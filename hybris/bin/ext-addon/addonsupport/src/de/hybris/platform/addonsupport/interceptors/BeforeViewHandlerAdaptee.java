/*
 * [y] hybris Platform
 *
 * Copyright (c) 2017 SAP SE or an SAP affiliate company.  All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.addonsupport.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;


/**
 * Allows an AddOn to code up a BeforeViewHandler adapter without needing to implement the storefront specific
 * interface.
 *
 */
public interface BeforeViewHandlerAdaptee
{
	String beforeView(HttpServletRequest request, HttpServletResponse response, ModelMap model, String viewName) throws Exception;// NOSONAR

}
