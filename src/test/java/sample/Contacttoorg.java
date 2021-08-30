package sample;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Contacttoorg {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 15);
		
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[contains(@title,'Create Contact...')]")).click();
		
		driver.findElement(By.name("lastname")).sendKeys("vijay");
		
		String prentid = driver.getWindowHandle();
		
		driver.findElement(By.xpath("//img[contains(@onclick,'return ')]")).click();
		
		Set<String> allWid = driver.getWindowHandles();
		
		for(String wId:allWid) {
			if(!wId.contains(prentid)) {
				driver.switchTo().window(wId);
				break;
			}
			
		}
		Thread.sleep(5000);
		driver.findElement(By.id("search_txt")).sendKeys("SDET20");
		driver.findElement(By.xpath("//input[@type='button']")).click();
		driver.findElement(By.linkText("SDET20")).click();
		
		driver.switchTo().window(prentid);
		
		driver.findElement(By.xpath("//input[@accesskey='S']")).click();
		

	}

}
