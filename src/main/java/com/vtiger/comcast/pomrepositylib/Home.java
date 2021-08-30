package com.vtiger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
	WebDriver driver;
	public Home(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Organizations")
	private WebElement organizationLnk;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactLnk;
	
	@FindBy(xpath = "//img[contains(@src,'user')]")
	private WebElement admimistratorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLnk;

	public WebElement getOrganizationLnk() {
		return organizationLnk;
	}

	public WebElement getContactLnk() {
		return contactLnk;
	}

	public WebElement getAdmimistratorImg() {
		return admimistratorImg;
	}
	public WebElement getSignOutLnk() {
		return signOutLnk;
	}
	
	public void logout(){
		Actions action = new Actions(driver);
		action.moveToElement(admimistratorImg).perform();
		
		signOutLnk.click();
		
	}

}

	
