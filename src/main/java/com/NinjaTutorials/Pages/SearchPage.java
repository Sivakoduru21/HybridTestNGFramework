package com.NinjaTutorials.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	WebDriver driver;
	// OBJECTS

	@FindBy(name = "search")
	private WebElement searchbox;

	@FindBy(linkText = "HP LP3065")
	private WebElement productlink;

	public SearchPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// Actions:

	public void clickOnSearchBox() {
		searchbox.click();
	}

	public void enterSearchText(String searchText) {
		searchbox.sendKeys(searchText);
	}
	public void pressEnterInSearchBox() {
        searchbox.sendKeys(Keys.ENTER);
    }

    public boolean isProductLinkDisplayed() {
        return productlink.isDisplayed();
    }

}
