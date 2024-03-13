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
//import pages.LoginPage;

public class POMPageTest {
	
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeMethod
	public void setUp() throws Exception {
		WebDriverManager.chromedriver().setup();	
		driver = new ChromeDriver();
		baseUrl = "http://www.adactin.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl + "/HotelApp/");
	}
	@Test
	public void testForLogin(){
		LoginPage login = new LoginPage(driver);
		login.setUsername("gularaa123");
		login.setPassword("gularaa123");
		login.clickLoginButton();
	}
	@Test
	public void testForSerachHotel() {
		LoginPage login = new LoginPage(driver);
		login.setUsername("gularaa123");
		login.setPassword("gularaa123");
		login.clickLoginButton();
		SearchHotelPage search = new SearchHotelPage(driver);
		search. selectFromDropDown(search.location, "Sydney");
		search. selectFromDropDown(search.noOfPeople, "4 - Four");
		search.verifyLocation();

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
