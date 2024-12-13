package hooks;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.WebDriverFactory;
import utils.TestNGListener;

public class Hooks {
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static TestNGListener testNGListener;
    
    @Before
    public void setUp() {
    	driver = WebDriverFactory.getDriver("CHROME");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        testNGListener = new TestNGListener();
        testNGListener.setDriver(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }
    
    public static WebDriverWait getDriverWait() {
        return wait;
    }
       
}
