package com.web.erp.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.web.erp.base.TestBase;
import com.web.erp.pages.HomePage;
import com.web.erp.pages.LoginPage;

public class LoginPageTest extends TestBase{
LoginPage loginPage;
HomePage homePage;

	public LoginPageTest(){
	super();
	}
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
	}
	
	
	@Test
	public void loginTest(){
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown(){
	driver.quit();
	}
}