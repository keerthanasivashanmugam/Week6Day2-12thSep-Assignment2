package week6.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DependsOnGroups {

	public static EdgeDriver driver;
	public static String IncidentNumber;
	
	@Test(groups="CreateINC")
	public void createINC() throws InterruptedException
	{
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
		driver.findElement(By.xpath("//input[@id='filter']")).click();
		driver.findElement(By.xpath("//div[text()='Create New']")).click();
		WebElement frameElement1 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frameElement1);
		IncidentNumber = driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");
		System.out.println("Incident no : "+IncidentNumber);
		driver.findElement(By.xpath("//input[@id='sys_display.incident.caller_id']")).sendKeys("Krystle Stika");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@class='form-control'])[2]")).sendKeys("Sample INC ");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		Thread.sleep(1000);
		WebElement selectWebElement = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		Select drpdwn = new Select(selectWebElement);
		drpdwn.selectByValue("number");
		WebElement searchINC = driver.findElement(By.xpath("//input[@class='form-control']"));
		searchINC.sendKeys(IncidentNumber);
		searchINC.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		String INCNo = driver.findElement(By.xpath("//label[@class='checkbox-label']/span")).getText();
		if(INCNo.contains(IncidentNumber))
		{
			System.out.println("Created INC is displayed");
		}else
			System.out.println("Created INC is not displayed");
		driver.switchTo().defaultContent();
	}

	@Test(groups="DeleteINC")
public void deleteINC() throws InterruptedException
{
	driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("Incident");
	driver.findElement(By.xpath("//div[text()='Incidents']")).click();
	WebElement frameElement1 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
	driver.switchTo().frame(frameElement1);
	driver.findElement(By.xpath("//a[@class='breadcrumb_link']")).click();
	WebElement selectElement = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
	Select drpdwn = new Select(selectElement);
	drpdwn.selectByValue("number");
	WebElement searchINC1 = driver.findElement(By.xpath("//input[@class='form-control']"));
	searchINC1.sendKeys(IncidentNumber);
	Actions builder = new Actions(driver);
	builder.moveToElement(searchINC1).sendKeys(Keys.ENTER).perform();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
	driver.findElement(By.xpath("//button[@id='sysverb_delete']")).click();
	driver.findElement(By.xpath("//button[@id='ok_button']")).click();
	driver.findElement(By.xpath("//a[@class='breadcrumb_link']")).click();
	WebElement selectElement2 = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
	Select drpdwn1 = new Select(selectElement2);
	drpdwn1.selectByValue("number");
	System.out.println(IncidentNumber+"  Deleted successfully");
	driver.close();
}

	
}
