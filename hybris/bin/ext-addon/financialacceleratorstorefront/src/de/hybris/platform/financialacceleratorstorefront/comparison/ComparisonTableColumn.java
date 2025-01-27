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

package de.hybris.platform.financialacceleratorstorefront.comparison;

import java.util.List;

import com.google.common.collect.Lists;


public class ComparisonTableColumn
{
	private List items = Lists.newArrayList();

	public void addItem(final Object item)
	{
		getItems().add(item);
	}

	public List getItems()
	{
		return items;
	}

	public void setItems(final List items)
	{
		this.items = items;
	}

}
