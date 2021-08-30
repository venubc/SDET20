package com.vtiger.comcast.contacttest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.vtiger.comcast.pomrepositylib.Contact;
import com.vtiger.comcast.pomrepositylib.Createnewconact;
import com.vtiger.comcast.pomrepositylib.Home;
import com.vtiger.comcast.pomrepositylib.Login;

public class TC_1_CreatContactWithoutMandatoryField {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		/* 1 navigate to Url */
		driver.get("http://localhost:8888/");
		
		/* 2 Login to the application */
		
		Login login = new Login(driver);
		login.LoginToApp("admin", "admin");
		
		/* 3 click on contact module */
		
		Home home = new Home(driver);
		home.getContactLnk().click();
		
		/* 4 click on new contact + img */
		
		Contact contact = new Contact(driver);
		contact.getCreatContactImg().click();
		
		/* 5 Create new contact with out mandatory filed */
		
		Createnewconact newContact = new Createnewconact(driver);
		newContact.getSaveBtn().click();
		
		String expectedResult = "Last Name cannot be empty";
		Alert alert= driver.switchTo().alert();
		
		if(expectedResult.equals(alert.getText())) {
			System.out.println("PASS:Last Name cannot be empty is displayed");
		}
		else {
			System.out.println("FAIL:Last Name cannot be empty is not displayed");
		}
		alert.accept();
		
		/* logout */
		home.logout();
		
		
		
		

	}

}
