package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
	WebDriver driver;
	WebDriverWait wait;

	public MainPage(WebDriver d) {
		driver = d;
		PageFactory.initElements(driver, this);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
		this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	// wrapper	
	public WebElement get_obj_wrapper() {
		return driver.findElement(By.xpath("//*[@id=\"wrapper\"]"));
	}
	
	// -------------- MENU SIDE BAR --------------	
	// SUB-NIVELES DEL MENU
	public String[] get_def_sideBarItem1(String nivel1) {
		return new String[] { "id", "//a[text()='" + nivel1 + "']" };
	}

	public WebElement get_obj_sideBarItem1(String nivel1) {
		return driver.findElement(By.xpath("//a[text()='" + nivel1 + "']"));
	}

	public String[] get_def_sideBarItem2(String nivel1, String nivel2) {
		return new String[] { "id", "//a[text()='" + nivel1 + "']/..//a[text()='" + nivel2 + "']" };
	}

	public WebElement get_obj_sideBarItem2(String nivel1, String nivel2) {
		return driver.findElement(By.xpath("//a[text()='" + nivel1 + "']/..//a[text()='" + nivel2 + "']"));
	}

	public String[] get_def_sideBarItem3(String nivel1, String nivel2, String nivel3) {
		return new String[] { "id",
				"//a[text()='" + nivel1 + "']/..//a[text()='" + nivel2 + "']/..//a[text()='" + nivel3 + "']" };
	}

	public WebElement get_obj_sideBarItem3(String nivel1, String nivel2, String nivel3) {
		return driver.findElement(
				By.xpath("//a[text()='" + nivel1 + "']/..//a[text()='" + nivel2 + "']/..//a[text()='" + nivel3 + "']"));
	}

	public String[] get_def_sideBarItem4(String nivel1, String nivel2, String nivel3, String nivel4) {
		return new String[] { "id", "//a[text()='" + nivel1 + "']/..//a[text()='" + nivel2 + "']/..//a[text()='"
				+ nivel3 + "']/..//a[text()='" + nivel4 + "']" };
	}

	public WebElement get_obj_sideBarItem4(String nivel1, String nivel2, String nivel3, String nivel4) {
		return driver.findElement(By.xpath("//a[text()='" + nivel1 + "']/..//a[text()='" + nivel2 + "']/..//a[text()='"
				+ nivel3 + "']/..//a[text()='" + nivel4 + "']"));
	}

	// -------------- NAV BAR SUPERIOR --------------
		// PESTAÑAS SUPERIORES CLOSE BUTTON (PRIMERA NRO 5)
		public String[] get_def_btnCloseTab() {
			return new String[] {"id","//li[@class='tab active' and @id[contains(.,'tab-')]]//i"};
		}
		public WebElement get_obj_btnCloseTab(){		
			return driver.findElement(By.xpath("//li[@class='tab active' and @id[contains(.,'tab-')]]//i"));
		}
		// BOTON DE SALIR
		public String[] get_def_btnSalir() {
			return new String[] {"id","//a[@id='idLogOff']"};
		}
		public WebElement get_obj_btnSalir(){		
			return driver.findElement(By.xpath("//a[@id='idLogOff']"));
		}
	
}
