 package com.vtiger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Composemail {
	
	public Composemail(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "subject")
	private WebElement subjectEdt;
	
	@FindBy(xpath = "//input[@name='Send']")
	private WebElement sendBtn;

	public WebElement getSubjectEdt() {
		return subjectEdt;
	}

	public WebElement getSendBtn() {
		return sendBtn;
		
	}

}
