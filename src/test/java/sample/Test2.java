package sample;




	import java.util.Set;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;

import com.google.inject.Key;
import com.vtiger.comcast.pomrepositylib.Composemail;
	import com.vtiger.comcast.pomrepositylib.Contact;
	import com.vtiger.comcast.pomrepositylib.Home;
	import com.vtiger.comcast.pomrepositylib.Login;

	public class Test2 {

		public static void main(String[] args) throws InterruptedException {
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.get("http://localhost:8888/");
			/* Login */
			Login loginpage = new Login(driver);
			loginpage.LoginToApp("admin", "admin");
			
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
			 driver.switchTo().alert().accept();
			//System.out.println(alert.getText());
			//alert.accept();
			//driver.close();
			
			//driver.switchTo().window(currentWId);
			
			//home.logout();
			
			
			
			
			

		}

	} 


	


