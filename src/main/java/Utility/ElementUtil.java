package Utility;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.core.gherkin.Argument;

public class ElementUtil
{
	WebDriver driver;
	
	public ElementUtil(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}

	public WebElement driverWait(WebElement element, long seconds)
	{
		WebElement webelement = null;
		
		try 
		{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(seconds));
		webelement=wait.until(ExpectedConditions.elementToBeClickable(element));
		 }
		
		catch(Throwable t)
		{
			t.getStackTrace();
		}
		
		return webelement;
	}
	
	
	public void clickableElement(WebElement element, long seconds)
	{
		WebElement webelement= driverWait(element,seconds);
		webelement.click();
	}
	
	public void sentText(WebElement element, String text, long seconds)
	{
		WebElement webelement= driverWait(element,seconds);
		webelement.click();
		webelement.clear();
		webelement.sendKeys(text);
	}
	
	public void selectElement(WebElement element, String dropdown)
	{
	    Select select = new Select(element);
	    select.selectByVisibleText(dropdown);
	}
	
	public String getValue(WebElement element)
	{
	    String value=element.getText();	
	    return value;
	}
		
	public void acceptAlert(WebElement element,long second)
	{
		Alert alert=alertMessage(element,second);
		alert.accept();
	}
	
	public void dismissAlert(WebElement element,long second)
	{
		Alert alert=alertMessage(element,second);
		alert.dismiss();
	}
		
	public Alert alertMessage(WebElement element, long second)
	{
		Alert alert=null;
		try
		{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(second));
		wait.until(ExpectedConditions.alertIsPresent());
		}
		catch(Throwable t)
		{
			t.getStackTrace();
		}
		return alert;
		
	}
	
	
	public void mouseOver(WebElement element, long second )
	{
		WebElement webelement=visibilityofElements(element, second);
		Actions action= new Actions(driver);
		action.moveToElement(webelement).click().perform();
			
	}
	
	public WebElement visibilityofElements(WebElement element, long second)
	{

		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(second));
		WebElement webelement=wait.until(ExpectedConditions.visibilityOf(element));
		return webelement;
	}
	
	
	public void javaScriptClick(WebElement element, long second)
	{
		WebElement webelement=visibilityofElements(element, second);
		JavascriptExecutor jse= ((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].click();",webelement);
		
	}
	
	public void javaScriptType(WebElement element, long second, String text)
	{
		WebElement webelement=visibilityofElements(element, second);
		JavascriptExecutor jse= ((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].value='"+text+"'",webelement);
	}
	
	
}
