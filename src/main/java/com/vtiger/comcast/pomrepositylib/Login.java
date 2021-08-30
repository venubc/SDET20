package com.vtiger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	
	public Login(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "user_name")
	private WebElement userNameEdt;
	
	@FindBy(name = "user_password")
	private WebElement userPasswordEdt;
	
	@FindBy(id = "submitButton")
	private WebElement loginButton;

	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getUserPasswordEdt() {
		return userPasswordEdt;
	}
	
	public WebElement getLoginButton() {
		return loginButton;
	}
	
	public void LoginToApp(String userName, String password){
		userNameEdt.sendKeys(userName);
		userPasswordEdt.sendKeys(password);
		loginButton.click();
		
		
	}

	
	
	
	
	

}
