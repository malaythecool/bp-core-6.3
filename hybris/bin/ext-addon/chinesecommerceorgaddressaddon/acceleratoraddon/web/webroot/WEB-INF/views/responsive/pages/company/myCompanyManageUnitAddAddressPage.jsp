<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template" %>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/responsive/formElement"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="org-common" tagdir="/WEB-INF/tags/addons/commerceorgaddon/responsive/common" %>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags" %>
<%@ taglib prefix="address"
	tagdir="/WEB-INF/tags/addons/chinesecommerceorgaddressaddon/responsive/address"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<spring:url value="/my-company/organization-management/manage-units/details/" var="cancelUrl" htmlEscape="false">
	<spring:param name="unit" value="${uid}"/>
</spring:url>

<c:choose>
	<c:when test="${not empty addressData.id}">
		<spring:url value="/my-company/organization-management/manage-units/edit-address/" var="actionUrl" htmlEscape="false">
			<spring:param name="unit" value="${uid}"/>
			<spring:param name="addressId" value="${addressData.id}"/>
		</spring:url>
	</c:when>
	<c:otherwise>
		<spring:url value="/my-company/organization-management/manage-units/add-address/" var="actionUrl" htmlEscape="false">
			<spring:param name="unit" value="${uid}"/>
		</spring:url>
	</c:otherwise>
</c:choose>

<template:page pageTitle="${pageTitle}">
	<div class="account-section">
		<org-common:headline url="${cancelUrl}" labelKey="text.company.manage.units.addressForm.${empty addressData.id?'create':'edit'}.title" />

        <div class="account-section-content">
            <form:form action="${actionUrl}" method="post" commandName="addressForm">
              <div class="row">
            	<div class="col-xs-12 col-sm-6">
                        <formElement:formSelectBox idKey="address.country" labelKey="address.country" path="countryIso"
                                                   mandatory="true" skipBlank="false" selectCSSClass="form-control"
                                                   skipBlankMessageKey="address.selectCountry" items="${countryData}"
                                                   itemValue="isocode" selectedValue="${addressForm.countryIso}"/>
                </div>
				<c:if test="${not empty country}">
					<address:addressFormElements regions="${regions}"
						country="${country}" />
				</c:if>
                <div class="accountActions-bottom">
                    <div class="col-sm-3 col-sm-push-9">
                        <ycommerce:testId code="unitAddress_saveAddress_button">
                            <button type="submit" class="save btn btn-primary btn-block"><spring:theme code="text.company.save.button"/></button>
                        </ycommerce:testId>
                    </div>
                    <div class="col-sm-3 col-sm-push-3">
                        <ycommerce:testId code="unitAddress_cancelAddress_button">
                            <a href="${cancelUrl}" class="button cancel">
                                <button type="button" class="btn btn-default btn-block">
                                    <spring:theme code="text.company.manage.unit.address.cancelButton"/>
                                </button>
                            </a>
                        </ycommerce:testId>
                    </div>
                </div>
              </div>
            </form:form>
	    </div>
	</div>
</template:page>
