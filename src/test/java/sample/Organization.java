package sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Organization {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 15);
		
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[contains(@title,'Create Organization...')]")).click();
		driver.findElement(By.name("accountname")).sendKeys("SDET20");
		
		WebElement industrylist = driver.findElement(By.name("industry"));
		Select select = new Select(industrylist);
		select.selectByVisibleText("Construction");
		
		
		WebElement typelist = driver.findElement(By.name("accounttype"));
		Select select1 = new Select(typelist);
		select1.selectByVisibleText("Customer");
		
		WebElement ratinglist = driver.findElement(By.name("rating"));
		Select select2 = new Select(ratinglist);
		select2.selectByIndex(2);
		
		driver.findElement(By.className("crmbutton")).click();
		
		WebElement logout = driver.findElement(By.xpath("//td[contains(@onmouseover,'fnDropDownUser')]"));
		Actions action  = new Actions(driver);
		action.moveToElement(logout).perform();
		
		//driver.findElement(By.linkText("Sign Out")).click();
		

	}

}
