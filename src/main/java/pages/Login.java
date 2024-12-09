package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
	WebDriver driver = null;
	WebDriverWait wait;

	public void setDriver(WebDriver d) {
		driver = d;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	// Constructor
	public Login(WebDriver d) {
        this.driver = d;
        PageFactory.initElements(driver, this);
    }

	// -------------- LOGIN FORM PAGE --------------
	// INPUT USERNAME FIELD	
	public void inputUsername(String username) {
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
	}
	
	// INPUT PASSWORD FIELD	
	public void inputPassword(String password) {
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
	}

	// LABEL LOGIN
	public WebElement get_obj_lblLogin() {
		return driver.findElement(By.xpath("//h1[@id='kc-page-title']"));
	}

	// BUTTON LOGIN
	public void btnLogin() {
		driver.findElement(By.xpath("//input[@id='kc-login']")).click();
	}
}
