/*
 * [y] hybris Platform
 *
 * Copyright (c) 2017 hybris AG  * All rights reserved.
 *
 * This software is the confidential and proprietary information of hybris
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with hybris.
 *
 *
 */
package de.hybris.platform.integration.cis.tax.strategies;

import de.hybris.platform.core.model.order.AbstractOrderModel;


/**
 * Interface to determine what the item code of a shipping line should be
 */
public interface ShippingItemCodeStrategy
{

	Integer getShippingItemCode(AbstractOrderModel abstractOrder);
}
