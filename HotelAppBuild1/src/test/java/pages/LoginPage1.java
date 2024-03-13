package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage1 {
	
	WebDriver driver ;
	//All the WebElements
		By username = By.xpath(".//*[@id='username']");
		By password = By.id("password");
		By login = By.id("login");


	public LoginPage1(WebDriver driver) {

		this.driver = driver;
	}

	
	//Actions on the WebElement
	public void setUsername(String userName) {
	
		driver.findElement(username).clear();
		driver.findElement(username).sendKeys(userName);
	}
	public void setPassword(String userPassword) {

		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(userPassword);
	}

	public void ClickOnLoginButton() {

		driver.findElement(login).click();
		
	}
}