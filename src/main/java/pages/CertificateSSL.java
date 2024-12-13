package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

//PALEATIVO AL CERTIFICADO SSL, AGREGAR EN CENTA ADD_ARGUMENT EL CHROMEOPTIONS()
public class CertificateSSL {
	WebDriver driver = null;
	WebDriverWait wait;

	public void setDriver(WebDriver d) {
		driver = d;
		PageFactory.initElements(driver, this);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	// Constructor
	public CertificateSSL(WebDriver d) {
        this.driver = d;
        PageFactory.initElements(driver, this);
    }
	
	// BUTTON LOGIN
	public void btnDetails() {
		driver.findElement(By.xpath("//button[@id='details-button']")).click();
	}
		
		// BUTTON LOGIN
	public void btnProceedLink() {
		driver.findElement(By.xpath("//a[@id='proceed-link']")).click();
	}	
}
