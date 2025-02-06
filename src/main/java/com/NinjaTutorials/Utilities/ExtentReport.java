package com.NinjaTutorials.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {

	public static ExtentReports generateExtentReports() {
		ExtentReports extentReport = new ExtentReports();
		File extentReportFile = new File(
				System.getProperty("user.dir") + "\\test-output\\ExtentReports\\extentReport.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("NinjaTutorials Test Automation Results");
		sparkReporter.config().setDocumentTitle("NinjaTutorials Automation Report");
		sparkReporter.config().setTimeStampFormat("yyyy-MM-dd_HH-mm-ss");

		extentReport.attachReporter(sparkReporter);

		Properties configprop = new Properties();
		File configPropFile = new File(System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\NinjaTutorials\\configuration\\config.properties");
		try {
			FileInputStream fisConfigProp = new FileInputStream(configPropFile);
			configprop.load(fisConfigProp);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		extentReport.setSystemInfo("Application url",configprop.getProperty("url"));
		extentReport.setSystemInfo("Browser Name",configprop.getProperty("browserName"));
		extentReport.setSystemInfo("Email",configprop.getProperty("validEmail"));
		extentReport.setSystemInfo("Password",configprop.getProperty("validPassword"));
		extentReport.setSystemInfo("Operating system",System.getProperty("os.name"));
		extentReport.setSystemInfo("User name",System.getProperty("user.name"));
		extentReport.setSystemInfo("java version",System.getProperty("java.version"));
		
		return extentReport;
	}

}
