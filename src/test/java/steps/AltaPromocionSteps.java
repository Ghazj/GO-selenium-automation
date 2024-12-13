package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import hooks.Hooks;
import io.cucumber.java.en.And;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.CertificateSSL;
import pages.Login;
import pages.MainPage;

public class AltaPromocionSteps {
	WebDriver driver;
	WebDriverWait wait;
	CertificateSSL ssl;
	Login loginPage;
	MainPage mainPage;
	JavascriptExecutor js;

	@Description("Prueba para verificar el alta de promociones")
	@Severity(SeverityLevel.CRITICAL)
	@And("el usuario carga promociones")
	public void cargadepromociones() {
		System.out.println("El usuario carga la promocion");
		Allure.step("Paso: Cargar promocion");
		
		this.driver = Hooks.getDriver();
		this.wait = Hooks.getDriverWait();
		js = (JavascriptExecutor) this.driver;

		driver.findElement(By.linkText("Adquirencia")).click();
		driver.findElement(By.linkText("Comercios")).click();
		driver.findElement(By.linkText("Parametría")).click();
		driver.findElement(By.linkText("Promociones a Comercios")).click();
		driver.findElement(By.name("btnNew")).click();
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Descripcion")));
		}
		//js.executeScript("window.scrollTo(0,0)");
		driver.findElement(By.name("Descripcion")).click();
		driver.findElement(By.name("Descripcion")).sendKeys("Preuba Selenium IDE");
		//js.executeScript("window.scrollTo(0,100)");
		
		driver.findElement(By.name("FechaVigenteDesde")).sendKeys("07/12/2024");
		driver.findElement(By.name("FechaVigenteHasta")).sendKeys("08/12/2024");
		driver.findElement(By.name("TopeDescuento")).click();		
		
		driver.findElement(By.name("CuotasDesde")).sendKeys("1");
		driver.findElement(By.name("CuotasHasta")).sendKeys("6");
		{
			WebElement dropdown = driver.findElement(By.name("IdSistemaFinanciacion"));
			dropdown.findElement(By.xpath("//option[. = 'FINANCIACION ADQUIRENTE']")).click();
		}
		driver.findElement(By.name("HoraDesde")).sendKeys("12:40");
		driver.findElement(By.name("HoraHasta")).sendKeys("15:42");
		{
			WebElement dropdown = driver.findElement(By.name("ModoEntrada"));
			dropdown.findElement(By.xpath("//option[. = 'CONTACTLESS']")).click();
		}
		driver.findElement(By.name("PorcDescuento")).sendKeys("40");
		driver.findElement(By.name("TopeDescuento")).sendKeys("50000");
		driver.findElement(By.name("TopeTotal")).sendKeys("100000");
		driver.findElement(By.name("PartEmisor")).sendKeys("30");
		driver.findElement(By.name("PartComercio")).sendKeys("30");
		//js.executeScript("window.scrollTo(0,1200)");
		driver.findElement(By.name("PartAdquirente")).sendKeys("40");
		driver.findElement(By.name("Prioridad")).sendKeys("1");		
		{
			WebElement dropdown = driver.findElement(By.name("IdMarca"));
			dropdown.findElement(By.xpath("//option[. = 'Todas']")).click();
		}
		driver.findElement(By.name("DiasPromo")).click();
		driver.findElement(By.id("inputLunes")).click();
		driver.findElement(By.id("inputMiercoles")).click();
		driver.findElement(By.cssSelector(".checkbox:nth-child(4) > label")).click();
		driver.findElement(By.cssSelector(".checkbox:nth-child(6) > label")).click();
		driver.findElement(By.cssSelector(".checkbox:nth-child(7) > label")).click();		
		driver.findElement(By.xpath("//button[@class='btn btn-nav goToStep']")).click();
		
	    
	}

}
