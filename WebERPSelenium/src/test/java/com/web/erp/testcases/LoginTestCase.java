package com.web.erp.testcases;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTestCase {

	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	private JavascriptExecutor js;

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		baseUrl = "https://www.google.com/";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		js = (JavascriptExecutor) driver;
	}

	@Test
	public void testLoginTestCase() throws Exception {
		driver.get("http://etestingplatform.com/webERP/index.php");
		driver.findElement(By.name("UserNameEntryField")).click();
		driver.findElement(By.name("UserNameEntryField")).clear();
		driver.findElement(By.name("UserNameEntryField")).sendKeys("Admin");
		driver.findElement(By.name("Password")).clear();
		driver.findElement(By.name("Password")).sendKeys("weberp");
		driver.findElement(By.name("SubmitUser")).click();
		driver.findElement(By.linkText("Receivables")).click();
		driver.findElement(By.linkText("Purchases")).click();
		driver.findElement(By.linkText("Payables")).click();
		driver.findElement(By.linkText("Inventory")).click();
		driver.findElement(By.linkText("Manufacturing")).click();
		driver.findElement(By.linkText("General Ledger")).click();
		driver.findElement(By.linkText("Asset Manager")).click();
		driver.findElement(By.linkText("Petty Cash")).click();
		driver.findElement(By.linkText("Setup")).click();
		driver.findElement(By.linkText("Utilities")).click();
		driver.findElement(By.linkText("Setup")).click();
		driver.findElement(By.linkText("• Supplier Types")).click();
		driver.get("http://etestingplatform.com/webERP/SupplierTypes.php");
		driver.findElement(By.name("TypeName")).click();
		driver.findElement(By.name("TypeName")).clear();
		driver.findElement(By.name("TypeName")).sendKeys("sup03");
		driver.findElement(By.name("submit")).click();
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='sup03'])[1]/following::a[1]")).click();
		driver.findElement(By.name("TypeName")).click();
		driver.findElement(By.name("TypeName")).clear();
		driver.findElement(By.name("TypeName")).sendKeys("supp03");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//img[@alt='Main Menu']")).click();
		acceptNextAlert = true;
		driver.get("http://etestingplatform.com/webERP/index.php");
		driver.findElement(By.xpath("//img[@alt='Logout']")).click();
		assertTrue(closeAlertAndGetItsText().matches("^Are you sure you wish to logout[\\s\\S]$"));
	}

	@AfterClass(alwaysRun = true)
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
