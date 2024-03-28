package com.web.erp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.web.erp.base.TestBase;


public class HomePage extends TestBase {

@FindBy(xpath = "//div[@id='Info']/a/img[@alt='Gul']")
WebElement userNameLabel;


	//Initializing the Page Objects:
	public HomePage() {
		PageFactory. initElements(driver, this);
	}
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	
	public boolean verifyCorrectUserName() {
		
		return userNameLabel.isDisplayed();
	}
}
