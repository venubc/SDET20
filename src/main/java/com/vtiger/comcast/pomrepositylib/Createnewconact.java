package com.vtiger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Createnewconact {
	
	public Createnewconact(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "lastname")
	private WebElement lastNameEdt;
	
	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getOrgLookupImg() {
		return orgLookupImg;
	}

	public WebElement getClearOrgImg() {
		return clearOrgImg;
	}

	@FindBy(xpath = "//img[contains(@onclick,'return window.open')]")
	private WebElement orgLookupImg;
	
	@FindBy(xpath = "//input[contains(@onclick,'this.form.account_id.value')]")
	private WebElement clearOrgImg;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	@FindBy(name = "donotcall")
	private WebElement doNotCallCheckBox;

	public WebElement getDoNotCallCheckBox() {
		return doNotCallCheckBox;
	}
	
	

}
