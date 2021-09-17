package week5.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNowDevAssignINC extends ServiceNowDevCreateINC {

		@Test
	public  void runServiceNowDevAssignINC() throws InterruptedException {
		
		//Enter 'Incident' on the Filter navigator and click on Open option
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("Incident");
		driver.findElement(By.xpath("//div[text()='Open']")).click();
		Thread.sleep(1000);
		
		//Click on Open column to sort it date wise //Select Number from the dropdown and enter the Incident number
		WebElement frameElement1 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frameElement1);
		driver.findElement(By.xpath("//th[@name='opened_at']")).click();
		Thread.sleep(2000);
		
		//Click the Incident number link
		WebElement selectWebElement = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		Select drpdwn = new Select(selectWebElement);
		drpdwn.selectByValue("number");
		WebElement searchINC = driver.findElement(By.xpath("//input[@class='form-control']"));
		searchINC.sendKeys(IncidentNumber);
		searchINC.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		
		//Click on the Assignment group Lookup 
		driver.findElement(By.xpath("(//span[@class='icon icon-search'])[6]")).click();
		Set<String> windowHandlesSet1 = driver.getWindowHandles();
		List <String> windowHandlesList1 = new ArrayList<String>(windowHandlesSet1);
		driver.switchTo().window(windowHandlesList1.get(1));
		
		//Enter 'Software' in the search box of the child window and select the group	
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("Software");
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='glide_ref_item_link']")).click();
		driver.switchTo().window(windowHandlesList1.get(0));
		WebElement frameElement3 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frameElement3);		

		//Click on Work Notes and enter 'Work Notes'
		driver.findElement(By.xpath("(//span[@class='icon icon-locked'])[2]")).click();
		driver.findElement(By.xpath("//textarea[@id='activity-stream-textarea']")).sendKeys("Work Notes");
		
		//Click on Update button
		driver.findElement(By.xpath("//button[text()='Update']")).click();
		
		//Verify whether the Assignment group is software
		
		String AssignGrp = driver.findElement(By.xpath("//tr[@class='list_row list_odd']/td[10]")).getText();
		if(AssignGrp.contains("Software")) {
			System.out.println("Assigned to Software group");
		}else
			System.out.println("Not Assigned to Software group");
		

	}

}
