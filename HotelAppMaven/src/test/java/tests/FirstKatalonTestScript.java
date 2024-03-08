package tests;

import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import java.time.Duration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class FirstKatalonTestScript {
	  private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  private JavascriptExecutor js;

	  @BeforeMethod
	  public void setUp() throws Exception {
		 // System.setProperty("webdriver.chrome.driver","C:\\Users\\61470\\OneDrive\\Desktop\\gul\\Testing\\chromedriver-win64\\chromedriver.exe");
		  WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
	    baseUrl = "https://www.google.com/";
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    js = (JavascriptExecutor) driver;
	  }

	  @Test
	  public void testFirstKatalonTestScript() throws Exception {
	    driver.get("https://adactinhotelapp.com/HotelAppBuild2/");
	    driver.findElement(By.id("username")).click();
	    driver.findElement(By.id("username")).clear();
	    driver.findElement(By.id("username")).sendKeys("gularaa123");
	    driver.findElement(By.id("password")).click();
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys("gularaa123");
	    driver.findElement(By.id("login")).click();
	    driver.findElement(By.id("location")).click();
	    new Select(driver.findElement(By.id("location"))).selectByVisibleText("Sydney");
	    driver.findElement(By.id("hotels")).click();
	    new Select(driver.findElement(By.id("hotels"))).selectByVisibleText("Hotel Creek");
	    driver.findElement(By.id("room_type")).click();
	    driver.findElement(By.id("datepick_in")).click();
	    driver.findElement(By.id("datepick_in")).clear();
	    driver.findElement(By.id("datepick_in")).sendKeys("29/03/2024");
	    driver.findElement(By.id("datepick_out")).click();
	    driver.findElement(By.id("datepick_out")).clear();
	    driver.findElement(By.id("datepick_out")).sendKeys("01/05/2024");
	    driver.findElement(By.id("Submit")).click();
	    driver.findElement(By.id("radiobutton_1")).click();
	    driver.findElement(By.id("continue")).click();
	    driver.findElement(By.id("first_name")).click();
	    driver.findElement(By.id("first_name")).clear();
	    driver.findElement(By.id("first_name")).sendKeys("Gulsan");
	    driver.findElement(By.id("last_name")).click();
	    driver.findElement(By.id("last_name")).clear();
	    driver.findElement(By.id("last_name")).sendKeys("araa");
	    driver.findElement(By.id("address")).click();
	    driver.findElement(By.id("address")).clear();
	    driver.findElement(By.id("address")).sendKeys("qwedsgh");
	    driver.findElement(By.id("cc_num")).click();
	    driver.findElement(By.id("cc_num")).clear();
	    driver.findElement(By.id("cc_num")).sendKeys("1234344567788888");
	    driver.findElement(By.id("cc_type")).click();
	    new Select(driver.findElement(By.id("cc_type"))).selectByVisibleText("Master Card");
	    driver.findElement(By.id("cc_exp_month")).click();
	    new Select(driver.findElement(By.id("cc_exp_month"))).selectByVisibleText("October");
	    driver.findElement(By.id("cc_exp_year")).click();
	    new Select(driver.findElement(By.id("cc_exp_year"))).selectByVisibleText("2025");
	    driver.findElement(By.id("cc_cvv")).click();
	    driver.findElement(By.id("cc_cvv")).clear();
	    driver.findElement(By.id("cc_cvv")).sendKeys("123");
	    driver.findElement(By.id("book_now")).click();
	    driver.findElement(By.id("my_itinerary")).click();
	    driver.findElement(By.id("logout")).click();
	    driver.findElement(By.linkText("Click here to login again")).click();
	  }

	  @AfterMethod
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
