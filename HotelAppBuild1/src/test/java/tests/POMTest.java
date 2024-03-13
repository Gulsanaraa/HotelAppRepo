package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;
import pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class POMTest {
	
		private WebDriver driver;
		private String baseUrl;
		private StringBuffer verificationErrors = new StringBuffer();
		@BeforeMethod
		public void setUp() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
			baseUrl = "http://www.adactin.com/";
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(baseUrl + "/HotelApp/");
		}
		@Test(priority = 0)
		public void Login() {
			LoginPage1 loginPage = new LoginPage1(driver);
			loginPage.setUsername("gularaa123");
			loginPage.setPassword("gularaa123");
			loginPage.ClickOnLoginButton();
		}
		@Test(priority = 1)
		public void verifyLocation() {
			SelectHotelPage home = new SelectHotelPage(driver);
			LoginPage1 loginPage = new LoginPage1(driver);
			loginPage.setUsername("gularaa123");
			loginPage.setPassword("gularaa123");
			loginPage.ClickOnLoginButton();
			home.selectFromDropDown("Sydney", home.location);
			home.search();
			assertTrue(home.verifyLocation());
		}
		@AfterMethod
		public void tearDown() throws Exception {
			driver.quit();
			String verificationErrorString = verificationErrors.toString();
			if (!"".equals(verificationErrorString)) {
			Assert.fail(verificationErrorString);
			}
		}

}
