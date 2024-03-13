package testcase;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import static org.junit.Assert.*;
import org.junit.*;
import org.openqa.selenium.*;
public class OrderNumberTest {

	private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  JavascriptExecutor js;
	  @Before
	  public void setUp() throws Exception {
	    WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    baseUrl = "https://www.google.com/";
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	    js = (JavascriptExecutor) driver;
	  }

	  @Test
	  public void testOrderNumber() throws Exception {
	    driver.get("https://adactinhotelapp.com/index.php");
	    driver.findElement(By.id("username")).click();
	    driver.findElement(By.id("username")).clear();
	    driver.findElement(By.id("username")).sendKeys("gularaa123");
	    driver.findElement(By.id("password")).click();
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys("gularaa123");
	    driver.findElement(By.id("login")).click();
	    driver.get("https://adactinhotelapp.com/SearchHotel.php");
	    driver.findElement(By.id("location")).click();
	    new Select(driver.findElement(By.id("location"))).selectByVisibleText("Sydney");
	    driver.findElement(By.id("hotels")).click();
	    new Select(driver.findElement(By.id("hotels"))).selectByVisibleText("Hotel Creek");
	    driver.findElement(By.id("room_type")).click();
	    new Select(driver.findElement(By.id("room_type"))).selectByVisibleText("Standard");
	    driver.findElement(By.id("room_nos")).click();
	    new Select(driver.findElement(By.id("room_nos"))).selectByVisibleText("2 - Two");
	    driver.findElement(By.id("datepick_in")).click();
	    driver.findElement(By.id("datepick_out")).click();
	    driver.findElement(By.id("Submit")).click();
	    driver.get("https://adactinhotelapp.com/SelectHotel.php");
	    driver.findElement(By.id("radiobutton_0")).click();
	    driver.findElement(By.id("continue")).click();
	    driver.get("https://adactinhotelapp.com/BookHotel.php");
	    driver.findElement(By.id("first_name")).click();
	    driver.findElement(By.id("first_name")).clear();
	    driver.findElement(By.id("first_name")).sendKeys("Gulsan");
	    driver.findElement(By.id("first_name")).click();
	    driver.findElement(By.id("last_name")).click();
	    driver.findElement(By.id("last_name")).clear();
	    driver.findElement(By.id("last_name")).sendKeys("araa");
	    driver.findElement(By.id("address")).click();
	    driver.findElement(By.id("address")).clear();
	    driver.findElement(By.id("address")).sendKeys("12344");
	    driver.findElement(By.id("cc_num")).click();
	    driver.findElement(By.id("cc_num")).clear();
	    driver.findElement(By.id("cc_num")).sendKeys("1234567890000000");
	    driver.findElement(By.id("cc_type")).click();
	    new Select(driver.findElement(By.id("cc_type"))).selectByVisibleText("VISA");
	    driver.findElement(By.id("cc_exp_month")).click();
	    new Select(driver.findElement(By.id("cc_exp_month"))).selectByVisibleText("November");
	    driver.findElement(By.id("cc_exp_year")).click();
	    new Select(driver.findElement(By.id("cc_exp_year"))).selectByVisibleText("2025");
	    driver.findElement(By.id("cc_cvv")).click();
	    driver.findElement(By.id("cc_cvv")).clear();
	    driver.findElement(By.id("cc_cvv")).sendKeys("123");
	    driver.findElement(By.id("book_now")).click();
	    driver.get("https://adactinhotelapp.com/BookingConfirm.php");
	    driver.findElement(By.id("my_itinerary")).click();
	    driver.get("https://adactinhotelapp.com/BookedItinerary.php");
	    driver.findElement(By.id("logout")).click();
	    driver.get("https://adactinhotelapp.com/Logout.php");
	  }

	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
	}
