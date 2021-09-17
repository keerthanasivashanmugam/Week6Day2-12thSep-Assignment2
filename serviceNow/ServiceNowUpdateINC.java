package serviceNow;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class ServiceNowUpdateINC extends ServiceNowBaseClass{

	@Given("Select the Number option from the dropdown and enter the IncidentNumber")
	public void enterIncidentNo( ) throws InterruptedException {
		WebElement frameElement1 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frameElement1);
		
		WebElement selectWebElement = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
		Select drpdwn = new Select(selectWebElement);
		drpdwn.selectByValue("number");
		WebElement searchINC = driver.findElement(By.xpath("//input[@class='form-control']"));
		searchINC.sendKeys(incNo);	//static variable
		searchINC.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
	}
	
	@Given("Click on the Incident number link")
	public void clickIncidentNo() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
	}
	
	@Given("Click on lookup and select the {string} as {string}")
	public void updateUrgencyState(String option, String number) {
		WebElement selectElement1 = driver.findElement(By.xpath("//select[@name='incident."+option+"']"));
		Select drpdwn1= new Select(selectElement1);
		drpdwn1.selectByValue(number);
		//String urgency1 = driver.findElement(By.xpath("//option[@selected='SELECTED']")).getText();
		//System.out.println("Urgency : "+urgency1);
	}
	
	/*@Given("Click on Update button")
	public void clickUpdate() {
		driver.findElement(By.xpath("//button[text()='Update']")).click();
	}*/
	
	@When("Get the Urgency and State values")
	public void getUrgencyState() {
		
		 urgencyAfterUpdate = driver.findElement(By.xpath("//span[@class='sn-widget-list-table-cell']//..")).getText();
		System.out.println(urgencyAfterUpdate);
		 stateAfterUpdate = driver.findElement(By.xpath("(//span[@class='sn-widget-list-table-cell']//..)[7]")).getText();
		System.out.println(stateAfterUpdate);
	}
	
	@Then("Verify Urgency and State are updated")
	public void verifyUrgencyState() {
		if(urgencyAfterUpdate.contains("High") 	&& 	stateAfterUpdate.contains("In Progress"))
		{
			System.out.println("Update didn happen for : "+incNo);
		}else
			System.out.println("Update happened for : "+incNo);
	
	}
	
	
	
}
