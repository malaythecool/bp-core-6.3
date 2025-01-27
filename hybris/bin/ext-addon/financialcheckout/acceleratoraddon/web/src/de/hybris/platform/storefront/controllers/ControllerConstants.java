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

package de.hybris.platform.storefront.controllers;

public interface ControllerConstants
{
	String ADDON_PREFIX = "addon:/financialcheckout/";

	/**
	 * Class with view name constants
	 */
	interface Views
	{

		interface Pages
		{

			interface MultiStepCheckout
			{
				String GetFormPage = ADDON_PREFIX + "pages/checkout/multi/formPage";
				String AddPaymentMethodPage = ADDON_PREFIX + "pages/checkout/multi/addPaymentMethodPage";
				String QuoteReviewPage = ADDON_PREFIX + "pages/checkout/multi/quoteReviewPage";
				String CheckoutSummaryPage = ADDON_PREFIX + "pages/checkout/multi/checkoutSummaryPage";
				String HostedOrderPageErrorPage = ADDON_PREFIX + "pages/checkout/multi/hostedOrderPageErrorPage";
				String HostedOrderPostPage = ADDON_PREFIX + "pages/checkout/multi/hostedOrderPostPage";
				String SilentOrderPostPage = ADDON_PREFIX + "pages/checkout/multi/silentOrderPostPage";

				//Carried from B2C Checkout
				String AddEditDeliveryAddressPage = ADDON_PREFIX + "pages/checkout/multi/addEditDeliveryAddressPage";
				String ChooseDeliveryMethodPage = ADDON_PREFIX + "pages/checkout/multi/chooseDeliveryMethodPage";
				String ChoosePickupLocationPage = ADDON_PREFIX + "pages/checkout/multi/choosePickupLocationPage";
			}
		}

		interface Fragments
		{

			interface Checkout
			{
				String TermsAndConditionsPopup = ADDON_PREFIX + "fragments/checkout/termsAndConditionsPopup";
				String BillingAddressForm = ADDON_PREFIX + "fragments/checkout/billingAddressForm";
			}
		}
	}
}
