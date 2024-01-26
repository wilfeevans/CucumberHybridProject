package stepdefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import DriverFactory.driverFactory;
import Pages.HomePage;
import Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class login 
{
	
	WebDriver driver;
	HomePage homepage;
	public LoginPage loginpage;
	
	@Given("User has navigate to login page")
	public void user_has_navigate_to_login_page() 
	{
		driver=driverFactory.getDriver();
		homepage= new HomePage(driver);
		homepage.myAccount();
		loginpage=homepage.Login();
	}

	@When("While entering valid Email {string}")
	public void while_entering_valid_Email(String Email)
	{
		loginpage.getEmail(Email);
		//driver.findElement(By.xpath("//input[@id=\"input-email\"]")).sendKeys(Email);
	}
	
	@When("While entering valid Password {string}")
	public void while_entering_valid_Password(String Password)
	{
		loginpage.getPassword(Password);
	    //driver.findElement(By.xpath("//input[@id=\"input-password\"]")).sendKeys(Password);
	}

	@When("By clicking login button")
	public void by_clicking_login_button()
	{
		//loginpage= new LoginPage(driver);
		loginpage.clickLogin();
	    //driver.findElement(By.xpath("//input[@value=\"Login\"]")).click();
	}

	@Then("The user should be able to login successfully")
	public void the_user_should_be_able_to_login_successfully()
	{
		System.out.println(driver.getTitle());
		
	}

	@When("^While entering invalid Email (.+)$")
	public void while_entering_invalid_Email(String Email)
	{    
		//loginpage= new LoginPage(driver);
		loginpage.getinvalidEmail(Email);
		//driver.findElement(By.xpath("//input[@id=\"input-email\"]")).sendKeys(Email);
	}

	@When("^While entering invalid Password (.+)$")
	public void while_entering_invalid_Password(String invalidPassword)
    {
		loginpage.getinvalidPassword(invalidPassword);
		//driver.findElement(By.xpath("//input[@id=\"input-password\"]")).sendKeys(Password);
	}

	@Then("The user should not be able to login successfully")
	public void the_user_should_not_be_able_to_login_successfully()
	{
		loginpage.unsuccessfulLogin();
		//WebElement warning= driver.findElement(By.xpath("//div[text()=\"Warning: No match for E-Mail Address and/or Password.\"]"));
		
	}

	@Then("The user should get a warning message")
	public void the_user_should_get_a_warning_message()
	{
		String warnings=loginpage.warningMessage();
		//WebElement warning= driver.findElement(By.xpath("//div[text()=\"Warning: No match for E-Mail Address and/or Password.\"]"));
        Assert.assertEquals(warnings,"Warning: No match for E-Mail Address and/or Password.");	
		
	}


}
