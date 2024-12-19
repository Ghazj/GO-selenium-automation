package steps;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import pages.CertificateSSL;
import pages.Login;
import pages.MainPage;
import utils.ExtentReportManager;

public class LoginSteps {
	WebDriver driver;
	WebDriverWait wait;
	CertificateSSL ssl;
	Login loginPage;
	MainPage mainPage;
	private ExtentTest test;

	@Description("Prueba para verificar el login del usuario")
	@Severity(SeverityLevel.CRITICAL)
	@Step("El usuario navega a la p�gina de login")
	@Given("el usuario esta en la pagina de login")
	public void userOnLoginPage() {
		System.out.println("User navigates to the login page");
		Allure.step("Paso 1: Navegar al login");

		this.driver = Hooks.getDriver();
		driver.get("https://v2adquirenciaarg.web.qa.global.globalprocessing.net.ar/");
		this.wait = Hooks.getDriverWait();
		ssl = new CertificateSSL(driver);
		loginPage = new Login(driver);
		mainPage = new MainPage(driver);
		ssl.btnDetails();
		ssl.btnProceedLink();
	}

	@Description("Prueba para verificar el login del usuario")
	@Severity(SeverityLevel.CRITICAL)
	@Step("El usuario ingresa credenciales v�lidas")
	@When("el usuario ingresa credenciales validas")
	public void userEntersCredentials() {
		Allure.step("Paso 2: Ingresar credenciales");

		System.out.println("User enters valid credentials");
		loginPage.inputUsername("admin700");
		loginPage.inputPassword("GlobalProc");
		loginPage.btnLogin();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Adquirencia")));
	}

	@Description("Prueba para verificar el login del usuario")
	@Severity(SeverityLevel.CRITICAL)
	@Step("el usuario deberia ver el dashboard")
	@Then("el usuario deberia ver el dashboard")
	public void userSeesDashboard() {
		Allure.step("Paso 3: Verificar que el dashboard sea visible");

		System.out.println("User sees the dashboard");
		mainPage.get_obj_wrapper();
		Assert.assertTrue(mainPage.get_obj_wrapper().isDisplayed(), "El elemento no es visible.");
	}

}
