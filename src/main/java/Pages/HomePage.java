package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.ElementUtil;

public class HomePage 
{
	WebDriver driver;
	ElementUtil elementutil;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementutil= new ElementUtil(driver);
	}

	@FindBy(linkText = "My Account")
	WebElement myaccount;
	public void myAccount()
	{
		elementutil.clickableElement(myaccount,15);
		//myaccount.click();
		
	}
	
	@FindBy(linkText = "Login")
	WebElement login;
	public LoginPage  Login()
	{
		elementutil.clickableElement(login,15);
		//login.click();
		return new LoginPage(driver);
		
	}
	
	
	
	
	
}
