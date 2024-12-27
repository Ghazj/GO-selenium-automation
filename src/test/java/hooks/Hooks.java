package hooks;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.WebDriverFactory;
import utils.Screenshot;
import utils.TestNGListener;

public class Hooks {
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static TestNGListener testNGListener;
    private static Scenario scenario;
    
    
    @Before
    public void setUp(Scenario scenario) {
    	this.driver = WebDriverFactory.getDriver("CHROME");
    	System.out.println("Ingreso a Navegador de Chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        this.testNGListener = new TestNGListener();
        this.testNGListener.setDriver(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.scenario = scenario;
    }

    @After
    public void tearDown() {
    	if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            String screenshotPath = Screenshot.takeScreenshot(driver, screenshotName);
            
            byte[] screenshotBytes = Screenshot.getScreenshotAsBytes(screenshotPath);
            
            if (screenshotBytes != null) {
                scenario.attach(screenshotBytes, "image/png", screenshotName);
            }
        }
        if (driver != null) {
            driver.quit();
        }
    }
    
    //@AfterStep
    public void takeScreenshotOnFinishStep(Scenario scenario) {    	
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            String screenshotPath = Screenshot.takeScreenshot(driver, screenshotName);
            
            byte[] screenshotBytes = Screenshot.getScreenshotAsBytes(screenshotPath);
            
            if (screenshotBytes != null) {
                scenario.attach(screenshotBytes, "image/png", screenshotName);
            }        
    }
    
    @After
    public void takeScreenshotOnFailure(Scenario scenario) {
        
    }
    
    public static WebDriver getDriver() {
        return driver;
    }
    
    public static WebDriverWait getDriverWait() {
        return wait;
    }
       
}
