package com.NinjaTutorials.Base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.NinjaTutorials.Utilities.Utilities;

public class Base {

	WebDriver driver;
	public Properties prop;
	
	public  Base() {
	    prop = new Properties();
		File propfile = new File(System.getProperty("user.dir") + "\\src\\main\\java\\com\\NinjaTutorials\\configuration\\config.properties");
		try {
		FileInputStream fis = new FileInputStream(propfile);
		prop.load(fis);
		}catch(Throwable e){
			e.printStackTrace();
		}
	}

	public WebDriver initializeBrowserAndOpenApplication(String browserName)  {
		if (browserName.equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("Edge")) {

			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.Implicit_Wait_Time));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.page_Wait_Time));
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.findElement(By.xpath("//a[@title=\"My Account\"]")).click();
		driver.findElement(By.xpath("//a[text()=\"Login\"]")).click();
		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
        driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
        driver.findElement(By.xpath("//input[@value=\"Login\"]")).click();
		return driver;
	}
}
