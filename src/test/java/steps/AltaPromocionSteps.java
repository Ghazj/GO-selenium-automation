package steps;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.messages.types.Duration;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.CertificateSSL;
import pages.Login;
import pages.MainPage;


@SuppressWarnings("unused")
public class AltaPromocionSteps {
	Scenario scenario;
	WebDriver driver;
	WebDriverWait wait;
	CertificateSSL ssl;
	Login loginPage;
	MainPage mainPage;
	JavascriptExecutor js;
	
	@Before
    public void setUp(Scenario scenario) {
        this.scenario = scenario;
    }
	
	@Description("Prueba para verificar el alta de promociones")
	@Severity(SeverityLevel.CRITICAL)

	@Given("el usuario ingresa a pantalla de promociones")
	public void ingresaPantallaPromociones() {
		System.out.println("El usuario carga la promocion");
		Allure.step("Paso: Cargar promocion");
		
		this.driver = Hooks.getDriver();
		this.wait = Hooks.getDriverWait();
		js = (JavascriptExecutor) this.driver;

		//Ingresar a panel hasta llegar a pantalla de promociones
		driver.findElement(By.linkText("Adquirencia")).click();
		driver.findElement(By.linkText("Comercios")).click();
		driver.findElement(By.cssSelector("li:nth-child(2) > .menu-link3")).click();
		driver.findElement(By.linkText("Promociones a Comercios")).click();
		//ingresar nueva promocion
		driver.findElement(By.name("btnNew")).click();
		
	}
		
	@Then("el usuario carga formulario de pantalla promociones")
	public void pantallaPromociones() {
		//ingresar datos en pantalla de datos principales
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Descripcion")));
		}
		driver.findElement(By.name("Descripcion")).click();
		driver.findElement(By.name("Descripcion")).sendKeys("Preuba Selenium IDE");
		
		//Formatear fecha para utilizar en campo fecha desde con fecha actual
		LocalDate fechaActual = LocalDate.now();
        String fechaActualFormateada = fechaActual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		driver.findElement(By.name("FechaVigenteDesde")).click();
		driver.findElement(By.name("FechaVigenteDesde")).clear();
		// Encontrar el campo de fecha desde y enviar la fecha actual
        WebElement campoFechaDesde = driver.findElement(By.name("FechaVigenteDesde"));
		driver.findElement(By.name("FechaVigenteDesde")).sendKeys(Keys.ENTER);
		
		//tomar fecha actual considerada como fecha desde y sumar 3 meses de vigencia en la promocion
		driver.findElement(By.name("FechaVigenteHasta")).click();
		driver.findElement(By.name("FechaVigenteHasta")).clear();
		LocalDate fechaHasta = fechaActual.plusMonths(3);
        String fechaHastaFormateada = fechaHasta.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        WebElement campoFechaHasta = driver.findElement(By.name("FechaVigenteHasta"));
        campoFechaHasta.click();
        campoFechaHasta.clear();
        campoFechaHasta.sendKeys(fechaHastaFormateada);
        driver.findElement(By.name("FechaVigenteHasta")).sendKeys(Keys.ENTER);
		driver.findElement(By.name("CuotasDesde")).sendKeys("1");
		driver.findElement(By.name("CuotasHasta")).sendKeys("6");
		{
			WebElement dropdown = driver.findElement(By.name("IdSistemaFinanciacion"));
			dropdown.findElement(By.xpath("//option[. = 'FINANCIACION ADQUIRENTE']")).click();
		}
		driver.findElement(By.name("TasaPromo")).sendKeys("0");		
		driver.findElement(By.name("HoraDesde")).sendKeys("09:00");
		driver.findElement(By.name("HoraHasta")).sendKeys("23:59");
		{
			WebElement dropdown = driver.findElement(By.name("ModoEntrada"));
			dropdown.findElement(By.xpath("//option[. = 'CONTACTLESS']")).click();
		}
		driver.findElement(By.name("PorcDescuento")).sendKeys("40");
		driver.findElement(By.name("TopeDescuento")).sendKeys("50000");
		driver.findElement(By.name("TopeTotal")).sendKeys("100000");
		driver.findElement(By.name("PartEmisor")).sendKeys("30");
		driver.findElement(By.name("PartComercio")).sendKeys("30");
		driver.findElement(By.name("PartAdquirente")).sendKeys("40");
		driver.findElement(By.name("Prioridad")).sendKeys("1");		
		{
			WebElement dropdown = driver.findElement(By.cssSelector("select.selectMarca"));
			dropdown.findElement(By.xpath("//option[. = 'Todas']")).click();
		}
		driver.findElement(By.name("DiasPromo")).click();
		driver.findElement(By.id("inputLunes")).click();
		driver.findElement(By.id("inputMiercoles")).click();
		driver.findElement(By.cssSelector(".checkbox:nth-child(4) > label")).click();
		driver.findElement(By.cssSelector(".checkbox:nth-child(6) > label")).click();
		driver.findElement(By.cssSelector(".checkbox:nth-child(7) > label")).click();	
		driver.findElement(By.cssSelector("button.goToStep")).click(); 
		
		// Capturar y adjuntar un screenshot del paso
	    byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	    this.scenario.attach(screenshot, "image/png", "Screenshot after clicking element");
		
		}
		
	@And("el usuario carga formulario de pantalla Comercios")
	public void pantallaComercios() {
		//Pantalla de seleccion de comercios
		
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("select.selectTipoComercio:nth-child(2)")));
		}
		{
			WebElement dropdown = driver.findElement(By.cssSelector("select.selectTipoComercio:nth-child(2)"));
            Select select = new Select(dropdown);
            dropdown.click();
            select.selectByVisibleText("Rubro");
		}
		{
			WebElement dropdown = driver.findElement(By.cssSelector(".inputComercios"));
			dropdown.findElement(By.xpath("//option[. = '97 - Furia']")).click();
		}
			driver.findElement(By.cssSelector(".btn-agregar")).click();
		{
		    WebElement dropdown = driver.findElement(By.cssSelector(".inputComercios2"));
		    dropdown.findElement(By.xpath("//option[. = '97 - Furia']")).click();
		}
	    driver.findElement(By.cssSelector(".goToStep")).click();
	}
	
	@And("el usuario carga formulario de pantalla Tarjetas")
	public void pantallaTarjetas() {
	    //Pantalla de tarjetas incluidas
	    {
	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".TarjetasIncluidasTitle")));
	    }
	    driver.findElement(By.cssSelector("input.inputTarjetaDesde")).sendKeys("5450290000000000");	
	    driver.findElement(By.cssSelector("input.inputTarjetaHasta")).sendKeys("5450299999999999");	
	    driver.findElement(By.cssSelector("button.btn-agregarBin")).click();
	    driver.findElement(By.cssSelector(".form-group > .btn-submit")).click();
	}
	   
		@Then("el usuario deberia ver el dashboard con alta de promociones")
		public void altaPromociones() {
	    
	    //Pantalla de Alta de Promocion
	    {
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(.,'Alta Exitosa.')]")));
		
		Assert.assertTrue(driver.findElement(By.xpath("//h1[contains(.,'Alta Exitosa.')]")).isDisplayed(), "El elemento no es visible.");
    	}	    
	}
}
