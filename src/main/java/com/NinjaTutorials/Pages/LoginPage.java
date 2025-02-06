package com.NinjaTutorials.Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	@FindBy(linkText = "Edit your account information")
	WebElement editAccountLink;
	
	public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);  
    }

    // Actions:
	public boolean isEditAccountlinkDisplayed() {
        return editAccountLink.isDisplayed();
    }

}
