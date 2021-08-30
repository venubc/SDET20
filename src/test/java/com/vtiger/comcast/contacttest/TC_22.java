package com.vtiger.comcast.contacttest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.vtiger.comcast.genericUtility.FileUtility;
import com.vtiger.comcast.genericUtility.WebDriverUtility;
import com.vtiger.comcast.pomrepositylib.Contact;
import com.vtiger.comcast.pomrepositylib.Createnewconact;
import com.vtiger.comcast.pomrepositylib.Home;
import com.vtiger.comcast.pomrepositylib.Login;

public class TC_22 {

	public static void main(String[] args) throws Throwable {
		
		WebDriverUtility wLib = new WebDriverUtility();
		FileUtility fLib = new FileUtility();
		
		String url = fLib.getPropertyKeyValue("url");
		String username = fLib.getPropertyKeyValue("username");
		String password = fLib.getPropertyKeyValue("password");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		wLib.waitUntilPageLoad(driver);
		driver.get(url);
		/* Login */
		Login loginpage = new Login(driver);
		loginpage.LoginToApp(username, password);
		
		Home home = new Home(driver);
		home.getContactLnk().click();
		
		Contact contact = new Contact(driver);
		contact.getCreatContactImg().click();
		
		Createnewconact creatContact = new Createnewconact(driver);
		creatContact.getLastNameEdt().sendKeys("Ras");
		
		WebElement dNC = creatContact.getDoNotCallCheckBox();
		if(dNC.isEnabled()) {
			System.out.println("Do Not Call box is enable");
		}
		else {
			System.out.println("Do Not Call box is disable");
		}
		
		home.logout();

	}

}
