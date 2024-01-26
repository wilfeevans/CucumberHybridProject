package stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import DriverFactory.driverFactory;
import Pages.HomePage;
import Pages.SearchPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class searchitem 
{

	WebDriver driver;
	SearchPage searchpage;
	HomePage homepage;
	
	@Given("User opens the application")
	public void user_opens_the_application() 
	{
		driver= driverFactory.getDriver();
		
	}

	@When("The user search with valid product called {string}")
	public void the_user_search_with_valid_product_called(String value)
	{
		  searchpage= new SearchPage(driver);
		  searchpage.validProduct();
		 // searchpage.validProduct().sendKeys(value);
		//driver.findElement(By.name("search")).sendKeys(value);
		
	}

	@When("The user clicks on the search icon")
	public void the_user_clicks_on_the_search_icon() 
	{
		searchpage.searchButton();
	    //driver.findElement(By.xpath("//button[@class=\"btn btn-default btn-lg\"]")).click();
		
	}

	@Then("The search results should get displayed")
	public void the_search_results_should_get_displayed() 
	{
	  // String actual= driver.findElement(By.xpath("//h1[text()=\"Search - hp\"]")).getText();
	   
		String actual= searchpage.searchResult();
		Assert.assertEquals(actual,"Search - hp");
	}

	@When("The user search with invalid product called {string}")
	public void the_user_search_with_invalid_product_called(String value) 
	{
	    //intenssionally left this test case
		searchpage= new SearchPage(driver);
		searchpage.invalidProduct();
		//searchpage.invalidProduct().sendKeys(value);
	}

	@Then("The user should get a No Product Matches message")
	public void the_user_should_get_a_no_product_matches_message() 
	{
		//String actual= driver.findElement(By.xpath("//p[text()=\"There is no product that matches the search criteria.\"]")).getText();
	    
		String actuals=searchpage.messageCheck();
		Assert.assertEquals(actuals,"There is no product that matches the search criteria.");
	}

}
