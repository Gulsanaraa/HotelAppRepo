package com.web.erp.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.web.erp.base.TestBase;
import com.web.erp.pages.HomePage;
import com.web.erp.pages.LoginPage;
import com.web.erp.pages.ModuleListPage;
import com.web.erp.pages.PayablesPage;
import com.web.erp.pages.ReceivablesPage;
import com.web.erp.util.TestUtil;


public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ModuleListPage moduleListPage;
	ReceivablesPage receivablesPage;
	PayablesPage payablesPage;
	
	public HomePageTest() {
			super();
	}
	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser

	@BeforeMethod
	public void setUp() {
	initialization();
	testUtil = new TestUtil();
	moduleListPage = new ModuleListPage();
	loginPage = new LoginPage();
		
	homePage = loginPage. login(prop.getProperty("username"), prop.getProperty("password"));
	}
	/*@Test(priority=3)
	public void verifyHomePageTitleTest(){
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "webERP - Main Menu");
	}
	@Test(priority=2)
	public void verifyUserNameTest(){
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}*/
	@Test(priority=1)
	public void clickOnReceivablesLinkTest(){
		//receivablesPage=moduleListPage.clickOnReceivablesLink();
		moduleListPage.clickOnPayablesLink();
		String moduleSelectedPageName = moduleListPage.moduleSelectedPage();
		if(moduleSelectedPageName.equalsIgnoreCase("Receivables")) {
			System.out.println("Selected Module is - " +moduleSelectedPageName);
			receivablesPage = new ReceivablesPage();
		}
		else if(moduleSelectedPageName.equalsIgnoreCase("Payables")) {
			System.out.println("Selected Module is - " +moduleSelectedPageName);
			payablesPage = new PayablesPage();
		}
		else
			System.out.println("Selected Module is - " +moduleListPage.moduleSelectedPage());
		
	}
	@AfterMethod
		public void tearDown(){
		driver.quit();
	}
}
