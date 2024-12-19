package runners;

import io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    tags = "@EjecutarSoloEsta",
    glue = {
    	"steps",
    	"hooks"	
    },
    plugin = {
        "pretty",
        "html:target/cucumber-reports.html",
        "json:target/cucumber.json",
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
        "rerun:target/rerun.txt" // Para capturar las pruebas fallidas
    }
)
public class TestNGRunner extends AbstractTestNGCucumberTests {
}
