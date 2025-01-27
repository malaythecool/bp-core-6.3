/*
 * [y] hybris Platform
 *
 * Copyright (c) 2017 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.smarteditaddon.cms.services.impl;

import de.hybris.platform.acceleratorcms.component.container.CMSComponentContainerStrategy;
import de.hybris.platform.acceleratorcms.services.CMSDynamicAttributeService;
import de.hybris.platform.cms2.misc.CMSFilter;
import de.hybris.platform.cms2.model.contents.CMSItemModel;
import de.hybris.platform.cms2.model.contents.components.AbstractCMSComponentModel;
import de.hybris.platform.cms2.model.contents.containers.AbstractCMSComponentContainerModel;
import de.hybris.platform.cms2.model.contents.contentslot.ContentSlotModel;
import de.hybris.platform.servicelayer.session.SessionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;

import javax.servlet.jsp.PageContext;
import java.util.HashMap;
import java.util.Map;


/**
 * SmartEdit implementation of the {@link CMSDynamicAttributeService}.
 */
public class CMSSmartEditDynamicAttributeService implements CMSDynamicAttributeService
{
	private static final Logger LOG = LoggerFactory.getLogger(CMSSmartEditDynamicAttributeService.class);

	private static final String SMART_EDIT_COMPONENT_CLASS = "smartEditComponent";
	private static final String CLASS_ATTRIBUTE = "class";
	private static final String SMARTEDIT_COMPONENT_TYPE_ATTRIBUTE = "data-smartedit-component-type";
	private static final String SMARTEDIT_COMPONENT_ID_ATTRIBUTE = "data-smartedit-component-id";

	private SessionService sessionService;
	private CMSComponentContainerStrategy cmsComponentContainerStrategy;

	@Override
	public Map<String, String> getDynamicComponentAttributes(final AbstractCMSComponentModel component,
															 final ContentSlotModel contentSlot)
	{
		final Map<String, String> dynamicAttributes = new HashMap<>();

		if (component != null && contentSlot != null && isEnabled() && shouldTheComponentBeWrapped(component, contentSlot))
		{
			dynamicAttributes.put(SMARTEDIT_COMPONENT_ID_ATTRIBUTE, component.getUid());
			dynamicAttributes.put(SMARTEDIT_COMPONENT_TYPE_ATTRIBUTE, component.getItemtype());
			dynamicAttributes.put(CLASS_ATTRIBUTE, SMART_EDIT_COMPONENT_CLASS);
		}

		return dynamicAttributes;
	}

	@Override
	public Map<String, String> getDynamicContentSlotAttributes(final ContentSlotModel contentSlot, final PageContext pageContext,
															   final Map<String, String> initialMaps)
	{
		final Map<String, String> dynamicAttributes = new HashMap<>();

		if (isEnabled() && contentSlot != null)
		{
			dynamicAttributes.put(SMARTEDIT_COMPONENT_ID_ATTRIBUTE, contentSlot.getUid());
			dynamicAttributes.put(SMARTEDIT_COMPONENT_TYPE_ATTRIBUTE, contentSlot.getItemtype());
			dynamicAttributes.put(CLASS_ATTRIBUTE, SMART_EDIT_COMPONENT_CLASS);
		}

		return dynamicAttributes;
	}

	@Override
	public void afterAllItems(final PageContext pageContext)
	{
		if (!isEnabled())
		{
			return;
		}
	}

	/**
	 * will wrapp in a div any smarteditcomponent that is neither a NavigationBarComponent nor
	 * NavigationBarCollectionComponent
	 *
	 * @param cmsItemModel
	 * @return
	 */
	@Override
	public String getFallbackElement(final CMSItemModel cmsItemModel)
	{
		if (!isEnabled())
		{
			return null;
		}
		else
		{
			return "div";
		}
	}


	/**
	 * Checks if smarteditaddon is enabled by checking the presence of a cmsTicketId in session.
	 *
	 * @return true if this dyanamic attribute service is enabled and false otherwise.
	 */
	protected boolean isEnabled()
	{
		return getSessionService().getAttribute(CMSFilter.PREVIEW_TICKET_ID_PARAM) != null;
	}

	/**
	 * Checks if the current component is neither the direct child of the containing contentSlot not the child of a {@link AbstractCMSComponentContainerModel}, and instead is nested within other CMS component.
	 * @param component The component to verify.
	 * @param contentSlot The slot containing the current component.
	 * @return true if it's a direct child or child of a {@link AbstractCMSComponentContainerModel}, false otherwise.
	 */
	protected boolean shouldTheComponentBeWrapped(final AbstractCMSComponentModel component, final ContentSlotModel contentSlot)
	{
		if (component == null || contentSlot == null){
			throw new IllegalArgumentException("CMSSmartEditDynamicAttributeService.shouldTheComponentBeWrapped.component.and.slot.required");
		}

		return (contentSlot.getCmsComponents().stream().filter(e -> {

			if (e instanceof AbstractCMSComponentContainerModel){

				return cmsComponentContainerStrategy.getDisplayComponentsForContainer((AbstractCMSComponentContainerModel) e).stream().filter(f -> f.getUid().equals(component.getUid())).findAny().isPresent();

			}else{
				return e.getUid().equals(component.getUid());
			}
		}).findAny().isPresent());
	}

	protected SessionService getSessionService()
	{
		return sessionService;
	}

	@Required
	public void setSessionService(final SessionService sessionService)
	{
		this.sessionService = sessionService;
	}

	protected CMSComponentContainerStrategy getCmsComponentContainerStrategy()
	{
		return cmsComponentContainerStrategy;
	}

	@Required
	public void setCmsComponentContainerStrategy(final CMSComponentContainerStrategy cmsComponentContainerStrategy)
	{
		this.cmsComponentContainerStrategy = cmsComponentContainerStrategy;
	}
}
