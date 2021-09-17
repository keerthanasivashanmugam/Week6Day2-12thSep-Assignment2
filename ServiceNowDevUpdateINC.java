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

public class ServiceNowDevUpdateINC extends  ServiceNowBaseClass {

	@Test
	public  void runServiceNowDevUpdateINC( ) throws InterruptedException {
					
		
		//Enter 'Incident' on the navigation filter
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("Incident");
		driver.findElement(By.xpath("//div[text()='Incidents']")).click();
		
		//To search for INC no which starts with INC001
		WebElement frameElement1 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frameElement1);
		driver.findElement(By.xpath("//a[@class='breadcrumb_link']")).click();
		WebElement selectElement = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		Select drpdwn = new Select(selectElement);
		drpdwn.selectByValue("number");
		
		WebElement incSearch = driver.findElement(By.xpath("//input[@class='form-control']"));
		incSearch.sendKeys(IncidentNumber);
		Actions builder = new Actions(driver);
		builder.moveToElement(incSearch).sendKeys(Keys.ENTER).perform(); 
		
	
		//Click the Incident link
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		
		
		//Click on Urgency lookup and select the 'urgency' as '1' - High
		WebElement selectElement1 = driver.findElement(By.xpath("//select[@name='incident.urgency']"));
		Select drpdwn1= new Select(selectElement1);
		drpdwn1.selectByValue("1");
		String urgency = driver.findElement(By.xpath("//option[@selected='SELECTED']")).getText();
		System.out.println("Urgency : "+urgency);
			
		//Click on State lookup and select the 'state' as '2' - In Progress
		WebElement selectElement2 = driver.findElement(By.xpath("//select[@name='incident.state']"));
		Select drpdwn2 = new Select(selectElement2);
		drpdwn2.selectByValue("2");
		String state = driver.findElement(By.xpath("(//option[@selected='SELECTED'])[2]")).getText();
		System.out.println("State : +"+state);
		
		//Click on Update button
		driver.findElement(By.xpath("//button[text()='Update']")).click();
		
		//Click on the Incident number link
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		
		//Get the Urgency and State values 
		String urgencyAfterUpdate = driver.findElement(By.xpath("//option[@selected='SELECTED']")).getText();
		System.out.println("Urgency After Update : "+urgencyAfterUpdate);
		String stateAfterUpdate = driver.findElement(By.xpath("(//option[@selected='SELECTED'])[2]")).getText();
		System.out.println("State After Update : "+stateAfterUpdate);
		
		
		
		//Verify Urgency and State are updated
		if(!urgency.equalsIgnoreCase(urgencyAfterUpdate) 	&& 	state.equalsIgnoreCase(stateAfterUpdate))
		{
			System.out.println("Update didn happen");
		}else
			System.out.println("Update happened");
		
		System.out.println("Update INC : "+IncidentNumber);
	}
}

