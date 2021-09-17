package week5.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNowBaseClass {

	public RemoteWebDriver driver;
	public static String IncidentNumber;
	public String browser=null;
	
	
	@BeforeMethod
	@Parameters ({"url", "userName", "password","browser"})
	public void runServiceNowBase (String  url, String  userName, String password, String browser) {
	
		if(browser.equalsIgnoreCase("chrome"))
		{
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	
		}else if(browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);	
	WebElement frameElement = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
	driver.switchTo().frame(frameElement);
	driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys(userName);
	driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys(password);
	driver.findElement(By.xpath("//button[@id='sysverb_login']")).click();
	
}
	@AfterMethod
	public void closeServiceNow() {
	driver.close();
	}
}
