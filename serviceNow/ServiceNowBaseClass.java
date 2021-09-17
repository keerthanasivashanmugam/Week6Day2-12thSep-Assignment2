package serviceNow;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNowBaseClass extends AbstractTestNGCucumberTests{

	public static EdgeDriver driver;
	public static String incNo;
	public static String urgencyAfterUpdate;
	public static String stateAfterUpdate;
	
	
	@BeforeMethod
	public void preCondition() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get("https://dev106228.service-now.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
			
		WebElement frameElement = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frameElement);
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("H68qWbuHksDT");
		driver.findElement(By.xpath("//button[@id='sysverb_login']")).click();
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("Incident");
		driver.findElement(By.xpath("(//div[text()='Incidents'])[2]")).click();
	}
	
	@AfterMethod
	public void postCondition() {
		driver.switchTo().defaultContent();
				driver.close();
	}
}
