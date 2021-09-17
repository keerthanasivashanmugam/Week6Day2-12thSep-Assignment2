package serviceNow;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ServiceNowDeleteINC extends ServiceNowBaseClass{

	@Given("Select Number from the dropdown")
	public void selectNoEnterIncNo() {
		WebElement frameElement1 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frameElement1);
		driver.findElement(By.xpath("//a[@class='breadcrumb_link']")).click();
		WebElement selectElement = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		Select drpdwn = new Select(selectElement);
		drpdwn.selectByValue("number");
	}
	
	@Given("Enter the Incident number")
	public void enterINCno() throws InterruptedException {
		WebElement searchINC1 = driver.findElement(By.xpath("//input[@class='form-control']"));
		searchINC1.sendKeys(incNo);
		searchINC1.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		
	}
	
	
	@Given("Click on the Incident Number link")
	public void clickIncidentNumber() {
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
	}
	
	
	@When("Click delete button")
	public void clickDelete() throws InterruptedException {
		driver.findElement(By.xpath("//button[@id='sysverb_delete']")).click();
		driver.findElement(By.xpath("//button[@id='ok_button']")).click();
		Thread.sleep(3000);
	}
	
	
	@Then("Verify the Incident is deleted")
	public void verifyDelete() throws InterruptedException {
		
	//	WebElement frameElement2 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
	//	driver.switchTo().frame(frameElement2);
	//	Thread.sleep(1000);
	/*	WebElement selectElement = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		Select drpdwn1 = new Select(selectElement);
		drpdwn1.selectByVisibleText("Number");
		WebElement searchINC2 = driver.findElement(By.xpath("//input[@class='form-control']"));
		searchINC2.sendKeys(incNo);
		searchINC2.sendKeys(Keys.ENTER);
		Thread.sleep(1000); */
				
		boolean displayed1 = driver.findElement(By.xpath("//td[text()='No records to display']")).isDisplayed();
		Assert.assertTrue(displayed1);
		System.out.println(incNo+"   is deleted successfully");
		
		
	}
	
}
