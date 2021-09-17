package week5.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNowDevDeleteINC extends  ServiceNowBaseClass  {
	
	@Test
	public void runServiceNowDevDeleteINC( ) throws InterruptedException {
				
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("Incident");
		driver.findElement(By.xpath("//div[text()='Incidents']")).click();
		
		//Select Number from the dropdown and Enter Incident Number
		WebElement frameElement1 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frameElement1);
		driver.findElement(By.xpath("//a[@class='breadcrumb_link']")).click();
		WebElement selectElement = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		Select drpdwn = new Select(selectElement);
		drpdwn.selectByValue("number");
	
		//Enter the Incident number
		WebElement searchINC1 = driver.findElement(By.xpath("//input[@class='form-control']"));
		searchINC1.sendKeys(IncidentNumber);
		Actions builder = new Actions(driver);
		builder.moveToElement(searchINC1).sendKeys(Keys.ENTER).perform();
		Thread.sleep(1000);
		
		//Click on the Incident Number
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		
		//Click delete button
		driver.findElement(By.xpath("//button[@id='sysverb_delete']")).click();
		driver.findElement(By.xpath("//button[@id='ok_button']")).click();
		
		//Verify the Incident is deleted
		driver.findElement(By.xpath("//a[@class='breadcrumb_link']")).click();
		WebElement selectElement2 = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		Select drpdwn1 = new Select(selectElement2);
		drpdwn1.selectByValue("number");
		

	}

}
