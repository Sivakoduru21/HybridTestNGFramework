package com.NinjaTutorials.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.NinjaTutorials.Base.Base;
import com.NinjaTutorials.Pages.LoginPage;

public class Login extends Base {
	public WebDriver driver;
	LoginPage LoginPage;

	public Login() {
		super();
	}

	@BeforeMethod
	public void setUp() {

		driver = initializeBrowserAndOpenApplication(prop.getProperty("browserName"));
		LoginPage = new LoginPage(driver); 
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void verifyLoginWithValidCredentials() {
		Assert.assertTrue(LoginPage.isEditAccountlinkDisplayed(),
				"The 'Edit your account information' link is not displayed!");
	}

}
