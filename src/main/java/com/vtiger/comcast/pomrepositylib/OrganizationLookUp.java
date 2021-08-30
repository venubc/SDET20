package com.vtiger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationLookUp {
	
	public OrganizationLookUp(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getSelectOrgFromOrgList() {
		return selectOrgFromOrgList;
	}

	@FindBy(linkText ="SDET20")
	private WebElement selectOrgFromOrgList;

}
