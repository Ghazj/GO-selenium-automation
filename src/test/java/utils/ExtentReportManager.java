package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    private static ExtentReports extent;

    public static ExtentReports getExtentInstance() {
        if (extent == null) {
            // Configurar el Spark Reporter (archivo HTML del reporte)
            ExtentSparkReporter spark = new ExtentSparkReporter("target/extentReports/ExtentReport.html");
            spark.config().setDocumentTitle("Reporte de Pruebas");
            spark.config().setReportName("Resultados de las Pruebas Automatizadas");
            
            // Inicializar ExtentReports
            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }
}
