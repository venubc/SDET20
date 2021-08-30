package com.vtiger.comcast.contacttest;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.vtiger.comcast.genericUtility.BaseClass;
import com.vtiger.comcast.genericUtility.ExcelUtility;
import com.vtiger.comcast.genericUtility.FileUtility;
import com.vtiger.comcast.genericUtility.WebDriverUtility;
import com.vtiger.comcast.pomrepositylib.Contact;
import com.vtiger.comcast.pomrepositylib.ContactInfo;
import com.vtiger.comcast.pomrepositylib.Createnewconact;
import com.vtiger.comcast.pomrepositylib.Home;
import com.vtiger.comcast.pomrepositylib.Login;
import com.vtiger.comcast.pomrepositylib.OrganizationLookUp;

public class CreatContactTest extends BaseClass{

		@Test(groups = "smokeTest")
		public void CreatContactWithOrgNameAndEraseTest() throws Throwable {
		
		String conName =  eLib.getDataFromExcel("sheet1", 1, 2);
		
		Home home = new Home(driver);
		home.getContactLnk().click();
		
		Contact contact = new Contact(driver);
		contact.getCreatContactImg().click();
		
		Createnewconact newcontact = new Createnewconact(driver);
		String currentWid = driver.getWindowHandle();
		
		newcontact.getLastNameEdt().sendKeys(conName);
		newcontact.getOrgLookupImg().click();
		
		Set<String> allWid = driver.getWindowHandles();
		
		for(String Wid:allWid) {
			if(!Wid.contains(currentWid)) {
				driver.switchTo().window(Wid);
				break;
			}
		}
		
		OrganizationLookUp orgList = new OrganizationLookUp(driver);
		
		orgList.getSelectOrgFromOrgList().click();
		
		driver.switchTo().window(currentWid);
		
		newcontact.getClearOrgImg().click();
		newcontact.getSaveBtn().click();
		
		ContactInfo contactInfo = new ContactInfo(driver);
		
		String actualMsg = contactInfo.getSuccesfullMsg().getText();
		
		if(actualMsg.contains(conName)) {
			System.out.println(conName +" is created succesfully");
		}
		else {
			System.out.println(conName +" not created succesfully");
		}
		
	}
		@Test(groups={"regressionTest"})
		public void CreatContactCheckCallBoxEnableTest() throws Throwable {
			
			String conName =  eLib.getDataFromExcel("sheet1", 2, 2);
			
			Home home = new Home(driver);
			home.getContactLnk().click();
			
			Contact contact = new Contact(driver);
			contact.getCreatContactImg().click();
			
			Createnewconact creatContact = new Createnewconact(driver);
			creatContact.getLastNameEdt().sendKeys(conName);
			
			WebElement dNC = creatContact.getDoNotCallCheckBox();
			if(dNC.isEnabled()) {
				System.out.println("Do Not Call box is enable");
			}
			else {
				System.out.println("Do Not Call box is disable");
			}
		}
		

}
