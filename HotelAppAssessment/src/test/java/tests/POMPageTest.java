package tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.DateFormatPage;
import pages.LoginPage;
import pages.SearchHotelPage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
public class POMPageTest {
	
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		WebDriverManager.chromedriver().setup();	
		driver = new ChromeDriver();
		baseUrl = "http://www.adactin.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl + "/HotelApp/");
	}
//	@Test
//	public void testForLogin(){
//		LoginPage login = new LoginPage(driver);
//		login.setUsername("gularaa123");
//		login.setPassword("gularaa123");
//		login.clickLoginButton();
//	}
	@Test
	public void testForSerachHotel() throws Exception{
		LoginPage login = new LoginPage(driver);
		login.setUsername("gularaa123");
		login.setPassword("gularaa123");
		login.clickLoginButton();
		SearchHotelPage search = new SearchHotelPage(driver);
		search. selectFromDropDown(search.location, "Sydney");
		search. selectFromDropDown(search.hotels, "Hotel Creek");
		search. selectFromDropDown(search.room_type, "Standard");
		//search. selectFromDropDown(search.room_nos, "1");
		//search.verifyLocation();
		DateFormatPage date = new DateFormatPage(driver);
		date.setDate(date.datepick_in, "19/03/2024");
		date.setDate(date.datepick_out, "17/03/2024");
		search.clickSearchButton();
		Thread.sleep(20000l);
	}
	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
		fail(verificationErrorString);
		}
	}
}
