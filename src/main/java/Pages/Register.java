package Pages;

import java.util.Date;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.ElementUtil;
import io.cucumber.datatable.DataTable;

public class Register 
{

	WebDriver driver;
	ElementUtil elementutil;
	
	public Register(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementutil= new ElementUtil(driver);
	}
	
	@FindBy(id = "input-firstname")
	WebElement firstname;
	
	@FindBy(id = "input-lastname")
	WebElement lastname;
	
	@FindBy(id = "input-email")
	WebElement email;
	
	@FindBy(id = "input-telephone")
	WebElement telephone;
	
	@FindBy(id = "input-password")
	WebElement password;
	
	@FindBy(id = "input-confirm")
	WebElement confirmpassword;
	
	public void mandatoryFields(DataTable datatable)
	{
		
		Map<String,String> datamap= datatable.asMap();
		
		elementutil.sentText(firstname,datamap.get("firstname"),15);;
		elementutil.sentText(lastname,datamap.get("LastName"),15);
		elementutil.sentText(email,getEmail(),15);
		elementutil.sentText(telephone,datamap.get("Telephone"),15);
		elementutil.sentText(password,datamap.get("Password"),15);
		elementutil.sentText(confirmpassword,datamap.get("Password Confirm"),15);
		
		/*firstname.sendKeys(datamap.get("firstname"));
		lastname.sendKeys(datamap.get("LastName"));
		email.sendKeys(getEmail());
		telephone.sendKeys(datamap.get("Telephone"));
		password.sendKeys(datamap.get("Password"));
		confirmpassword.sendKeys(datamap.get("Password Confirm")); */
		
	}
	
	@FindBy(name ="agree")
	WebElement privacy;
	public void privacy()
	{
		elementutil.clickableElement(privacy, 15);
		//privacy.click();
	}
	
	@FindBy(xpath="//input[@value=\"Continue\"]")
	WebElement continuebutton;
	public Register continueButton()
	{
		elementutil.clickableElement(continuebutton, 15);
		//continuebutton.click();
		return new Register(driver);
	}
	
	@FindBy(xpath="//h1[text()=\"Your Account Has Been Created!\"]")
	WebElement successful;
	public String successful()
	{
		return elementutil.getValue(successful);
		//return successful.getText();
	}
	
	@FindBy(xpath="//div[@class=\"alert alert-danger alert-dismissible\"]")
	WebElement warningmessage;
	public String warningMessage()
	{
		    return elementutil.getValue(warningmessage);
			//String message= warningmessage.getText();	
			//return message;
	}
	
	
	
	
	
	public String getEmail()
	{
		Date date= new Date();
		 String email= "Sam" + date.toString().replace(" ","_").replace(":","_")+"@gmail.com";
		 return email;
}
	
}
