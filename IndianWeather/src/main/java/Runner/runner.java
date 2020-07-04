package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty","html:target/WeatherReport", "json:target/WeatherJsonReport.json"},
                 features = {"src/main/java/Feature"},
                 glue = {"StepDef"},
                 tags = {"@SmokeSuite"},
                 monochrome = true
		
		)

public class runner {

}
