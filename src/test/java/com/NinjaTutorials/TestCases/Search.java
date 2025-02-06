package com.NinjaTutorials.TestCases;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.NinjaTutorials.Base.Base;
import com.NinjaTutorials.Pages.SearchPage;

public class Search extends Base {

	public WebDriver driver;
	SearchPage searchPage;
	
	public Search(){
		super();
	}

	@BeforeMethod
	public void setup()  {
		driver = initializeBrowserAndOpenApplication("chrome");
		searchPage = new SearchPage(driver);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void verifySearchWithValidProduct(){
		searchPage.clickOnSearchBox();  
        searchPage.enterSearchText("HP" + Keys.ENTER);
        searchPage.pressEnterInSearchBox();  
        Assert.assertTrue(searchPage.isProductLinkDisplayed(),"Product HP LP3065 not found!");

	}

}
