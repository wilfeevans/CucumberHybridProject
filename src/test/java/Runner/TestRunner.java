package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features",
				 glue= {"stepdefinition","hooks"},
				 stepNotifications = true,
			     plugin={"pretty","html:target/Cucumber_Report/Cucumber.html"}
				 
		)
public class TestRunner 
{
    
	
}
