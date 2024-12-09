package runners;

import io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {
    	"steps",
    	"hooks"	
    },
    plugin = {
        "pretty",
        "html:target/cucumber-reports.html",
        "json:target/cucumber.json",
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
    }
)
public class TestNGRunner extends AbstractTestNGCucumberTests {
}