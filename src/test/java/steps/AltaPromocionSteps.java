package steps;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
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
	WebDriver driver;
	WebDriverWait wait;
	CertificateSSL ssl;
	Login loginPage;
	MainPage mainPage;
	JavascriptExecutor js;

	@Description("Prueba para verificar el alta de promociones")
	@Severity(SeverityLevel.CRITICAL)

	@Given("El usuario ingresa a pantalla de promociones")
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
		driver.findElement(By.name("btnNew")).click();
		
	}
		
	@When("El usuario carga formulario de pantalla promociones - Campo Descripcion {string}")
	public void pantallaPromocionesDecripcion(String descripcion) {
		//ingresar datos de Descripcion en el formulario de la pantalla promociones
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Descripcion")));
		}
		driver.findElement(By.name("Descripcion")).click();
		driver.findElement(By.name("Descripcion")).sendKeys(descripcion);
	}
		
	@And("El usuario carga formulario de pantalla promociones - Campo FechaDesde")
	public void pantallaPromocionesFechaDesde() {
		//ingresar datos de FechaDesde en el formulario de la pantalla promociones
		
		//Formatear fecha para utilizar en campo fecha desde con fecha actual
		LocalDate fechaActual = LocalDate.now();
	    String fechaActualFormateada = fechaActual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		driver.findElement(By.name("FechaVigenteDesde")).click();
		driver.findElement(By.name("FechaVigenteDesde")).clear();
		// Encontrar el campo de fecha desde y enviar la fecha actual
	    WebElement campoFechaDesde = driver.findElement(By.name("FechaVigenteDesde"));
		driver.findElement(By.name("FechaVigenteDesde")).sendKeys(Keys.ENTER);
		
	}
		
	@And("El usuario carga formulario de pantalla promociones - Campo FechaHasta")
	public void pantallaPromocionesFechaHasta() {	
		//ingresar datos de FechaHasta en el formulario de la pantalla promociones
		
		//tomar fecha actual considerada como fecha desde y sumar 3 meses de vigencia en la promocion
		LocalDate fechaActual = LocalDate.now();
		driver.findElement(By.name("FechaVigenteHasta")).click();
		driver.findElement(By.name("FechaVigenteHasta")).clear();
		LocalDate fechaHasta = fechaActual.plusMonths(3);
        String fechaHastaFormateada = fechaHasta.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        WebElement campoFechaHasta = driver.findElement(By.name("FechaVigenteHasta"));
        campoFechaHasta.click();
        campoFechaHasta.clear();
        campoFechaHasta.sendKeys(fechaHastaFormateada);
        driver.findElement(By.name("FechaVigenteHasta")).sendKeys(Keys.ENTER);
        
	}
	
	@And("El usuario carga formulario de pantalla promociones - Campo CuotasDesde {string}")
	public void pantallaPromocionesCuotasDesde(String cuotasDesde) {	
		//ingresar datos de CuotasDesde en el formulario de la pantalla promociones
		
		driver.findElement(By.name("CuotasDesde")).sendKeys(cuotasDesde);
		
	}
	
	@And("El usuario carga formulario de pantalla promociones - Campo CuotasHasta {string}")
	public void pantallaPromocionesCuotasHasta(String cuotasHasta) {	
		//ingresar datos de CuotasHasta en el formulario de la pantalla promociones
		
		driver.findElement(By.name("CuotasHasta")).sendKeys(cuotasHasta);
		
	}
	
	@And("El usuario carga formulario de pantalla promociones - Campo SistemaFinanciacion {string}")
	public void pantallaPromocionesSistemaFinanciacion(String sistemaFinanciacion) {
		//ingresar datos de Sistema de Financiacion en el formulario de la pantalla promociones
	
		{
			WebElement dropdown = driver.findElement(By.name("IdSistemaFinanciacion"));
			dropdown.findElement(By.xpath("//option[. = '"+ sistemaFinanciacion +"']")).click();
		}
	}
	
	@And("El usuario carga formulario de pantalla promociones - Campo TasaPromo {string}")
	public void pantallaPromocionesTasaPromo(String tasaPromo) {
		//ingresar datos de Tasa Promo en el formulario de la pantalla promociones
		
		driver.findElement(By.name("TasaPromo")).sendKeys(tasaPromo);
	}
	
	@And("El usuario carga formulario de pantalla promociones - Campo HoraDesde")
	public void pantallaPromocionesHoraDesde() {
		//ingresar datos de Hora Desde en el formulario de la pantalla promociones
		
		driver.findElement(By.name("HoraDesde")).sendKeys("08:00");
	}
	
	@And("El usuario carga formulario de pantalla promociones - Campo HoraHasta")
	public void pantallaPromocionesHoraHasta() {
		//ingresar datos de Hora Hasta en el formulario de la pantalla promociones
		
		driver.findElement(By.name("HoraHasta")).sendKeys("23:59");
	}
		
	@And("El usuario carga formulario de pantalla promociones - Campo Modoentrada {string}")
	public void pantallaPromocionesModoEntrada(String modoEntrada) {
			//ingresar datos de Modo de Entrada en el formulario de la pantalla promociones
		{
			WebElement dropdown = driver.findElement(By.name("ModoEntrada"));
			dropdown.findElement(By.xpath("//option[. = '"+ modoEntrada +"']")).click();
		}
	}
	
	@And("El usuario carga formulario de pantalla promociones - Campo PorcentajeDescuento {string}")
	public void pantallaPromocionesPorcDescuento(String porcDescuento) {
			//ingresar datos de Porcentaje de Descuento en el formulario de la pantalla promociones
		
		driver.findElement(By.name("PorcDescuento")).sendKeys(porcDescuento);
	}
	
	@And("El usuario carga formulario de pantalla promociones - Campo TopeDescuento {string}")
	public void pantallaPromocionesTopeDescuento(String topeDescuento) {
			//ingresar datos de Tope de Descuento en el formulario de la pantalla promociones
		
		driver.findElement(By.name("TopeDescuento")).sendKeys(topeDescuento);
	}
	
	@And("El usuario carga formulario de pantalla promociones - Campo TopeTotal {string}")
	public void pantallaPromocionesTopeTotal(String topeTotal) {
			//ingresar datos de Tope Total en el formulario de la pantalla promociones
	
		driver.findElement(By.name("TopeTotal")).sendKeys(topeTotal);
	}
	
	@And("El usuario carga formulario de pantalla promociones - Campo ParteEmisor {string}")
	public void pantallaPromocionesParteEmisor(String parteEmisor) {
			//ingresar datos de Parte Emisor en el formulario de la pantalla promociones
	
		driver.findElement(By.name("PartEmisor")).sendKeys(parteEmisor);
	}
	
	@And("El usuario carga formulario de pantalla promociones - Campo ParteComercio {string}")
	public void pantallaPromocionesParteComercio(String parteComercio) {
			//ingresar datos de Parte Comercio en el formulario de la pantalla promociones

		driver.findElement(By.name("PartComercio")).sendKeys(parteComercio);
	}
	
	@And("El usuario carga formulario de pantalla promociones - Campo ParteAdquirente {string}")
	public void pantallaPromocionesParteAdquirente(String parteAdquirente) {
			//ingresar datos de Parte Adquirente en el formulario de la pantalla promociones

		driver.findElement(By.name("PartAdquirente")).sendKeys(parteAdquirente);
	}
	
	@And("El usuario carga formulario de pantalla promociones - Campo Prioridad {string}")
	public void pantallaPromocionesPrioridad(String prioridad) {
			//ingresar datos de Prioridad en el formulario de la pantalla promociones
	
		driver.findElement(By.name("Prioridad")).sendKeys(prioridad);	
	}
	
	@And("El usuario carga formulario de pantalla promociones - Campo SeleccionarMarca {string}")
	public void pantallaPromocionesSeleccionarMarca(String marca) {
		//ingresar datos de Marca en el formulario de la pantalla promociones
		{
			WebElement dropdown = driver.findElement(By.cssSelector("select.selectMarca"));
			dropdown.findElement(By.xpath("//option[. = '"+ marca +"']")).click();
		}
	}
	
	@And("El usuario carga formulario de pantalla promociones - Campo SeleccionarDiasPromo")
	public void pantallaPromocionesSeleccionarDiasPromo() {
		//ingresar datos de dias de promo en el formulario de la pantalla promociones
		driver.findElement(By.name("DiasPromo")).click();
		driver.findElement(By.id("inputLunes")).click();
		driver.findElement(By.id("inputMiercoles")).click();
		driver.findElement(By.cssSelector(".checkbox:nth-child(4) > label")).click();
		driver.findElement(By.cssSelector(".checkbox:nth-child(6) > label")).click();
		driver.findElement(By.cssSelector(".checkbox:nth-child(7) > label")).click();	
		driver.findElement(By.cssSelector("button.goToStep")).click(); 
		
	}
		
	@And("El usuario carga formulario de pantalla Comercios")
	public void pantallaComercios() {
		//Pantalla de seleccion de comercios
		
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("select.selectTipoComercio:nth-child(2)")));
		}
		
	}
	
	@And("El usuario carga formulario de pantalla Comercios - Campo SeleccionarComercios {string}")
	public void pantallaComerciosSeleccionarComercio(String seleccionarComercios) {
		//ingresar datos de comercio en el formulario de la pantalla promociones
	
		{
			WebElement dropdown = driver.findElement(By.cssSelector("select.selectTipoComercio:nth-child(2)"));
            Select select = new Select(dropdown);
            dropdown.click();
            select.selectByVisibleText(seleccionarComercios);
		}
	}
	
	@And("El usuario carga formulario de pantalla Comercios - Campo SeleccionarTiposComercios {string}")
	public void pantallaComerciosSeleccionarTipoComercio(String seleccionarTipoComercios) {
		//ingresar datos de tipo de comercio en el formulario de la pantalla promociones
		{
			WebElement dropdown = driver.findElement(By.cssSelector(".inputComercios"));
			dropdown.findElement(By.xpath("//option[. = '"+ seleccionarTipoComercios +"']")).click();
		}
			driver.findElement(By.cssSelector(".btn-agregar")).click();
			
		{
		    WebElement dropdown = driver.findElement(By.cssSelector(".inputComercios2"));
		    dropdown.findElement(By.xpath("//option[. = '"+ seleccionarTipoComercios +"']")).click();
		}
	    driver.findElement(By.cssSelector(".goToStep")).click();
	}
	
	@And("El usuario carga formulario de pantalla Tarjetas")
	public void pantallaTarjetas() {
	    //Pantalla de tarjetas incluidas
	    {
	    	wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".TarjetasIncluidasTitle")));
	    }
	}
	
	@And("El usuario carga formulario de pantalla Tarjetas - Campo TarjetaDesde {string}")
	public void pantallaTarjetasDesde(String tarjetaDesde) {
		//ingresar datos de tipo de Tajeta desde en el formulario de la pantalla promociones
		
	    driver.findElement(By.cssSelector("input.inputTarjetaDesde")).sendKeys(tarjetaDesde);
	}
	
	@And("El usuario carga formulario de pantalla Tarjetas - Campo TarjetaHasta {string}")
	public void pantallaTarjetasHasta(String tarjetaHasta) {
		//ingresar datos de tipo de Tajeta Hasta en el formulario de la pantalla promociones
	   
		driver.findElement(By.cssSelector("input.inputTarjetaHasta")).sendKeys(tarjetaHasta);	
	    
	    driver.findElement(By.cssSelector("button.btn-agregarBin")).click();
	    driver.findElement(By.cssSelector(".form-group > .btn-submit")).click();
	}
	   
	@Then("El usuario deberia ver la pantalla con alta de promociones")
	public void altaPromociones() {
	    
	    //Pantalla de Alta de Promocion
	    {
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(.,'Alta Exitosa.')]")));
		Assert.assertTrue(driver.findElement(By.xpath("//h1[contains(.,'Alta Exitosa.')]")).isDisplayed(), "El elemento no es visible.");
    	}	    
	}
}
