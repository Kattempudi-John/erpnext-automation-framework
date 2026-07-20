package com.erpTechnologies.reports;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.erpTechnologies.utilities.ConfigReader;

public class ReportManager {

    private static ExtentReports extentReports;
    private static ExtentSparkReporter sparkReporter;

    public static ExtentReports getExtentReports() {

        if (extentReports == null) {

            // Create Extent Report
            extentReports = new ExtentReports();

            // Create Spark Reporter
            sparkReporter = new ExtentSparkReporter(
                    ConfigReader.getProperty("report.path"));

            // Configure Report
            sparkReporter.config().setDocumentTitle(
                    ConfigReader.getProperty("report.title"));

            sparkReporter.config().setReportName(
                    ConfigReader.getProperty("report.name"));

            sparkReporter.config().setTheme(Theme.STANDARD);

            // Attach Reporter
            extentReports.attachReporter(sparkReporter);

            // System Information
            extentReports.setSystemInfo(
                    "Browser",
                    ConfigReader.getProperty("browser"));

            extentReports.setSystemInfo(
                    "Environment",
                    ConfigReader.getProperty("environment"));

            extentReports.setSystemInfo(
                    "Tester",
                    ConfigReader.getProperty("tester"));

            extentReports.setSystemInfo(
                    "Java Version",
                    System.getProperty("java.version"));

            extentReports.setSystemInfo(
                    "Operating System",
                    System.getProperty("os.name"));
        }

        return extentReports;
    }
}
