package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinitions {
	
	static WebDriver Driver;
	
	@Given("Admin User On Login Page")
	public void admin_user_on_login_page() {
	    Driver = new ChromeDriver();
	    Driver.get("https://admin.staging.legalfulfillmentgroup.com/");
	    
	}

	@When("Admin User Inputs valid UserName and Password")
	public void admin_user_inputs_valid_user_name_and_password() {
	   Driver.findElement(By.id("email")).sendKeys("msspl-admin");
	   Driver.findElement(By.id("password")).sendKeys("12345678");
	}

	@And("Admin User Click on LogIn Button")
	public void admin_user_click_on_log_in_button() {
	   Driver.findElement(By.xpath
	 ("//*[@id=\"root\"]/div/div/div/div/div[2]/div[1]/div/div/div/form/div/button")).click();
	}

	@Then("Admin User will be Redirected to Home Page")
	public void admin_user_will_be_redirected_to_home_page() 
	{
		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Assert.assertTrue(Driver.findElements(By.xpath("//*[@id=\"root\"]/div/div/div/div[3]/div[2]/div/div/div")).size()>0,"User is navigated to Home page");
	}

	@And("Close the Browser.")
	public void close_the_browser() {
	    Driver.quit();
	}


}
