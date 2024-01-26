package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.ElementUtil;

public class SearchPage
{
    WebDriver driver;
	ElementUtil elementutil;
    
	public SearchPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementutil= new ElementUtil(driver);
	}
	
	@FindBy(name ="search")
	WebElement validproduct;
	public void validProduct()
	{		
		elementutil.sentText(validproduct, "hp", 15);
		//return validproduct;
		
	}
	
	@FindBy(name="search")
	WebElement invalidproduct;
	public void invalidProduct()
	{
		elementutil.sentText(invalidproduct, "car", 15);
		//return invalidproduct;
	}
	
	
	@FindBy(xpath="//button[@class=\"btn btn-default btn-lg\"] ")
	WebElement searchbutton;
	public void searchButton()
	{
		elementutil.clickableElement(searchbutton, 15);
		//searchbutton.click();
	}
	
	@FindBy(xpath="//h1[text()=\"Search - hp\"]")
	WebElement searchresult;
	public String searchResult()
	{
		return elementutil.getValue(searchresult);
		//return searchresult.getText();
	}
	
	@FindBy(xpath="//*[@id=\"content\"]/p[2]")
	WebElement messagecheck;
	public String messageCheck()
	{
		return elementutil.getValue(messagecheck);
		//return messagecheck.getText();
	}
	
	
	
	
	
	
}
