package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//Cucumber Framework
@CucumberOptions(features = "src/test/java/cucumber", glue="ashwinkallingal.StepDefinition", tags = "@ErrorValidation", monochrome=true, plugin= {"html:target/cucumber.html"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
	
}
