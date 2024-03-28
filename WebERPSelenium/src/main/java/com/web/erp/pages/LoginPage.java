package com.web.erp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.web.erp.base.TestBase;


public class LoginPage extends TestBase{

	//Page Factory - OR:
	@FindBy(name="UserNameEntryField")
	WebElement username;

	@FindBy(name="Password")
	WebElement password;

	//@FindBy(xpath="//input[@type-'submit']")
	@FindBy(name="SubmitUser")
	WebElement loginBtn;

	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	//Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public HomePage login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();
	}


}
