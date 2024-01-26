package hooks;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import DriverFactory.driverFactory;
import Utility.configProperty;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class MyHooks
{
	WebDriver driver;
	
	@Before
	public void setUp() throws IOException
	{
		Properties prop= configProperty.initializingProperty();
		
	    driverFactory.initializingBrowser(prop.getProperty("browser"));
	    driver= driverFactory.getDriver();	    
		driver.get(prop.getProperty("url"));
	}
	
	@After
	public void tearDown(Scenario scenario)
	{
		String scenarioname=scenario.getName().replace(" ","_");
		
		if(scenario.isFailed())
		{
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot,"image/png", scenarioname);
		}
		
			driver.quit();
		
		
		
	}

}
