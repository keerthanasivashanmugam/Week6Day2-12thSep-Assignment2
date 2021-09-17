package serviceNow;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ServiceNowCreateINC extends ServiceNowBaseClass{

	
	@Given("Click on Create New option and save the Incident number")
	public void createIncident() {
		driver.findElement(By.xpath("//div[text()='Create New']")).click();
		WebElement frameElement1 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frameElement1);
		incNo = driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");
		System.out.println("Incident no : "+incNo);
	}
	
	@Given("Enter {string} and {string}")
	public void enterCallernameAndDescription(String CallerName, String ShortDescription) throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='sys_display.incident.caller_id']")).sendKeys(CallerName);
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//tr[@class='ac_highlight']")).click();
		System.out.println("Caller Name : "+CallerName);
		driver.findElement(By.xpath("(//input[@class='form-control'])[2]")).sendKeys(ShortDescription);
		System.out.println("Short Description : "+ShortDescription);
	}
	
	@Given("Click on Submit button")
	public void clickSubmit() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		Thread.sleep(1000);
	}
	
	@When("Search for the Created Incident number in the dropdown by using Number option")
	public void searchIncident() throws InterruptedException {
		WebElement selectWebElement = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		Select drpdwn = new Select(selectWebElement);
		drpdwn.selectByValue("number");
		WebElement searchINC = driver.findElement(By.xpath("//input[@class='form-control']"));
		searchINC.sendKeys(incNo);
		searchINC.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
	}
	
	@Then("Verify whether the Incident number is displayed")
	public void displayIncidentNumber() {
		String INCNo = driver.findElement(By.xpath("//label[@class='checkbox-label']/span")).getText();
		System.out.println(INCNo);
		if(INCNo.contains(incNo))
		{
			System.out.println("Created INC is displayed");
		}else
			System.out.println("Created INC is not displayed");
	}
	
	
	
}
