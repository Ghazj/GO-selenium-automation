package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

public class TestNGListener implements ITestListener {
    private static ExtentReports extent = ExtentReportManager.getExtentInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    private WebDriver driver; // Vincula esto a tu instancia de WebDriver.
    
    public void setDriver(WebDriver driver) {
    	System.out.println("Setea el driver en el listener");
    	this.driver = driver;
    }
    
    @Override
    public void onTestStart(ITestResult result) {
    	System.out.println("Listener onTestStart");
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    	System.out.println("Listener onTestSuccess");
        test.get().log(Status.PASS, "Prueba exitosa: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
    	System.out.println("Listener onTestFailure");
        test.get().log(Status.FAIL, "Prueba fallida: " + result.getThrowable());
        try {
            // Toma una captura de pantalla si hay una falla
            File screenshot = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE);
            String screenshotPath = "reports/screenshots/" + result.getMethod().getMethodName() + ".png";
            FileUtils.copyFile(screenshot, new File(screenshotPath));
            test.get().addScreenCaptureFromPath(screenshotPath, "Captura de pantalla del fallo");
        } catch (IOException e) {
            test.get().log(Status.FAIL, "Error al guardar la captura: " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    	System.out.println("Listener onTestSkipped");
        test.get().log(Status.SKIP, "Prueba omitida: " + result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
    	System.out.println("Listener onFinish");
        extent.flush();
    }
}
