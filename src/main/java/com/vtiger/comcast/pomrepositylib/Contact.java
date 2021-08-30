package com.vtiger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contact {
	WebDriver driver;
	public Contact(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id = "selectCurrentPageRec")
	private WebElement multipleSelectCheckBOx;
	
	@FindBy(xpath = "//input[@value='Send Mail']")
	private WebElement sendMailLnk;
	
	@FindBy(xpath = "//input[contains(@onclick,'validate_sendmail')]")
	private WebElement popupSelectBtn;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement creatContactImg;
	
	
	public WebElement getCreatContactImg() {
		return creatContactImg;
	}

	public WebElement getMultipleSelectCheckBOx() {
		return multipleSelectCheckBOx;
	}

	public WebElement getSendMailLnk() {
		return sendMailLnk;
	}

	public WebElement getPopupSelectBtn() {
		return popupSelectBtn;
	}
	
	
	
	

}