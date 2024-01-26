package stepdefinition;


import java.util.Date;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import DriverFactory.driverFactory;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.Register;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class register 
{
     WebDriver driver;
     HomePage homepage;
     Register register;
     LoginPage loginpage;
     

	@Given("User navigates to the Registration Account Page")
	public void user_navigates_to_the_registration_account_page() throws InterruptedException
	{
		driver= driverFactory.getDriver();
		homepage= new HomePage(driver);
		homepage.myAccount();
		loginpage=homepage.Login();
		//loginpage= new LoginPage(driver);
		loginpage.continueButton();
		
		//driver.findElement(By.linkText("My Account")).click();
		//driver.findElement(By.linkText("Login")).click();
	    //driver.findElement(By.xpath("//a[text()=\"Continue\"]")).click();
	    
	}

	@When("The user enter the all the below fields:")
	public void the_user_enter_the_all_the_below_fields(DataTable datatable) throws InterruptedException
	{
		  register= new Register(driver);
	      register.mandatoryFields(datatable);
	      	      
	      /* Map<String,String> datamap= datatable.asMap();
	      driver.findElement(By.id("input-firstname")).sendKeys(datamap.get("firstname"));
	      driver.findElement(By.id("input-lastname")).sendKeys(datamap.get("LastName"));
	      driver.findElement(By.id("input-email")).sendKeys(getEmail());
	      driver.findElement(By.id("input-telephone")).sendKeys(datamap.get("Telephone"));
	      driver.findElement(By.id("input-password")).sendKeys(datamap.get("Password"));
	      driver.findElement(By.id("input-confirm")).sendKeys(datamap.get("Password Confirm"));
	      */
		
	}

	@When("Checking the privacy policy")
	public void checking_the_privacy_policy() 
	{
		register.privacy();
	    //driver.findElement(By.name("agree")).click();
	}

	@When("User clicks on continue button")
	public void user_clicks_on_continue_button()
	{
		
		register.continueButton();
	    //driver.findElement(By.xpath("//input[@value=\"Continue\"]")).click();
	}

	@Then("The user should be able to register successfully")
	public void the_user_should_be_able_to_register_successfully()
	{
		String actual= register.successful();
	   // String actual= driver.findElement(By.xpath("//h1[text()=\"Your Account Has Been Created!\"]")).getText();
	    Assert.assertEquals(actual, "Your Account Has Been Created!");
	}

	@When("The user is not entering any of the mandatory fields")
	public void the_user_is_not_entering_any_of_the_mandatory_fields()
	{
	   System.out.println("Mandatory fields required");
	}

	@When("The user clicks on the continue button")
	public void the_user_clicks_on_the_continue_button()
	{
		
		register= new Register(driver);
		register.continueButton();
		
		//driver.findElement(By.xpath("//input[@value=\"Continue\"]")).click();
		
	}

	@Then("The user should thrown with warning messages")
	public void the_user_should_thrown_with_warning_messages() 
	{
		
		String message=register.warningMessage();
		Assert.assertEquals(message,"Warning: You must agree to the Privacy Policy!" );
		
	}
	
	
	}
