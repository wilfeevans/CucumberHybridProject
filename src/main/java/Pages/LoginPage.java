package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.ElementUtil;


public class LoginPage
{

	WebDriver driver;
	ElementUtil elementutil;
		
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementutil= new ElementUtil(driver);
	}
	
	@FindBy(xpath="//input[@id=\"input-email\"]")
	WebElement Email;
	public void getEmail(String email)
	{
		elementutil.sentText(Email, email, 15);
		//Email.sendKeys(email);
	}
	
	@FindBy(xpath="//input[@id=\"input-password\"]")
	WebElement Password;
	public void getPassword(String password)
	{
		 elementutil.sentText(Password,password,15);
		//Password.sendKeys(password);
	}
	
	@FindBy(xpath="//input[@value=\"Login\"] ")
	WebElement loginbutton;
	public void clickLogin()
	{
		elementutil.clickableElement(loginbutton,15);
		//loginbutton.click();
	}
	
	@FindBy(xpath="//input[@id=\"input-email\"]")
	WebElement invalidEmail;
	public void getinvalidEmail(String Email)
	{
		elementutil.sentText(invalidEmail,Email,15);
		//invalidEmail.sendKeys(Email);
	}
	
	@FindBy(xpath="//input[@id=\"input-password\"]")
	WebElement invalidPassword;
	public void getinvalidPassword(String Password)
	{
		elementutil.sentText(invalidPassword, Password, 15);
		invalidPassword.sendKeys(Password);
		
	}
	
	@FindBy(xpath="//div[text()=\"Warning: No match for E-Mail Address and/or Password.\"] ")
	WebElement unsuccessfullogin;
	public void unsuccessfulLogin()
	{
		WebElement warning= unsuccessfullogin;
		if(warning.getText().equalsIgnoreCase("Warning"))
		{
			System.out.println("Unsuccessful Login");
		}
		
	}
	
	@FindBy(xpath="//div[text()=\"Warning: No match for E-Mail Address and/or Password.\"]")
	WebElement message;
	public String warningMessage()
	{
		String warning= message.getText();
		
		return warning;
	}
	
	@FindBy(xpath="//a[text()=\"Continue\"] ")
	WebElement continuebutton;
	public LoginPage continueButton()
	{
		elementutil.clickableElement(continuebutton, 15);
		//continuebutton.click();
		return new LoginPage(driver);
	}

}
