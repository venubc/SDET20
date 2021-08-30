package com.vtiger.comcast.contacttest;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.vtiger.comcast.genericUtility.BaseClass;
import com.vtiger.comcast.pomrepositylib.Composemail;
import com.vtiger.comcast.pomrepositylib.Contact;
import com.vtiger.comcast.pomrepositylib.Home;
import com.vtiger.comcast.pomrepositylib.Login;

public class CreatSendingMailTest extends BaseClass{

	
	@Test(groups = {"smokeTest" })
	public	void CreatSendingEmailTest(){
		
		/* Click on contact link */
		
		Home home = new Home(driver);
		home.getContactLnk().click();
		
		String currentWId = driver.getWindowHandle();
		
		Contact contact = new Contact(driver);
		contact.getMultipleSelectCheckBOx().click();
		
		contact.getSendMailLnk().click();
		
		contact.getPopupSelectBtn().click();
		
		Set<String> allWId = driver.getWindowHandles();
		
		for(String wId:allWId) {
			
			if(!wId.contains(currentWId)) {
				driver.switchTo().window(wId);
				break;
			}
		}
		
		Composemail compose = new Composemail(driver);
		
		compose.getSubjectEdt().sendKeys("official mail");
		compose.getSendBtn().click();
		
		/* popup will come because we are not configure mail server in this system */
		/* to handle pop up */
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		//driver.close();
		
		driver.switchTo().window(currentWId);
		
		
		
		
		
		
		

	}

}
