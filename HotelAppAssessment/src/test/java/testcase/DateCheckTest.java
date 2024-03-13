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

public class DateCheckTest {

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
	  public void testDateCheck() throws Exception {
	    driver.get("https://adactinhotelapp.com/");
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
	    new Select(driver.findElement(By.id("room_type"))).selectByVisibleText("Standard");
	    driver.findElement(By.id("datepick_in")).click();
	    driver.findElement(By.id("datepick_in")).click();
	    driver.findElement(By.id("datepick_in")).clear();
	    driver.findElement(By.id("datepick_in")).sendKeys("19/03/2024");
	    driver.findElement(By.id("datepick_out")).click();
	    driver.findElement(By.id("datepick_out")).click();
	    driver.findElement(By.id("datepick_out")).click();
	    driver.findElement(By.id("datepick_out")).clear();
	    driver.findElement(By.id("datepick_out")).sendKeys("17/03/2024");
	    driver.findElement(By.id("Submit")).click();
	    //Thread.sleep(2000l);
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

