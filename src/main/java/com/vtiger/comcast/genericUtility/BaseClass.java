
package com.vtiger.comcast.genericUtility;




	
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.AfterSuite;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.vtiger.comcast.genericUtility.ExcelUtility;
import com.vtiger.comcast.genericUtility.FileUtility;
import com.vtiger.comcast.genericUtility.JavaUtility;
import com.vtiger.comcast.genericUtility.WebDriverUtility;
import com.vtiger.comcast.pomrepositylib.Home;
	import com.vtiger.comcast.pomrepositylib.Login;

	public class BaseClass {
		public WebDriver driver;
		  /*Object Creation for Lib*/
			public JavaUtility jLib = new JavaUtility();
			public WebDriverUtility wLib = new WebDriverUtility();
			public FileUtility fLib = new FileUtility();
			public ExcelUtility eLib = new ExcelUtility();
		
		@BeforeSuite(groups = { "smokeTest","regressionTest"})
		public void configBS() {
			System.out.println("========================connect to DB========================");
		}
			
	/*	@BeforeClass(groups = { "smokeTest","regressionTest"})
		public void configBC() throws Throwable {
			System.out.println("=============Launch the Browser=======");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			this.driver = driver; 
			
		}*/
		@Parameters("BROWSER")
		@BeforeClass
		public void configBC(String BROWSER) {
			System.out.println("=============Launch the Browser=======");
			if(BROWSER.equals("chrome")) {
			    driver = new ChromeDriver();
			}else if(BROWSER.equals("firefox")) {
				driver = new FirefoxDriver();
			}else if(BROWSER.equals("ie")) {
				driver = new InternetExplorerDriver();
			}else {
				 driver = new ChromeDriver();
			}
			wLib.waitUntilPageLoad(driver);
			driver.manage().window().maximize();
		}

		
		@BeforeMethod(groups = { "smokeTest","regressionTest"})
		public void configBM() throws Throwable {
			/*common Data*/
			String URL = fLib.getPropertyKeyValue("url");
			String USERNAME = fLib.getPropertyKeyValue("username");
			String PASSWORD = fLib.getPropertyKeyValue("password");
			String BROWSER = fLib.getPropertyKeyValue("browser");
			/* Navigate to app*/
			
		
			   driver.get(URL);
		        /* step 1 : login */
		        Login loginPage = new Login(driver);
		        loginPage.LoginToApp(USERNAME, PASSWORD);
		}
		
		
		@AfterMethod(groups = { "smokeTest","regressionTest"})
		public void configAM() {
		      /*step 6 : logout*/
			Home homePage = new Home(driver);
	        homePage.logout();
		}
		
		@AfterClass(groups = { "smokeTest","regressionTest"})
		public void configAC() {
			System.out.println("=============Close the Browser=======");
			driver.quit();
		}
		
		@AfterSuite(groups = { "smokeTest","regressionTest"})
		public void configAS() {
			System.out.println("========================close DB========================");
		}
	}







