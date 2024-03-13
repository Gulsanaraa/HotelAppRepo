package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
	
		this.driver = driver;
	}
	
	public By username = By.xpath(".//*[@id='username']");
	public By password = By.id("password");
	public By loginButton = By.id("login");
	
	public void setUsername(String inputUsername) {
	
		driver.findElement(username).clear();
		driver.findElement(username).sendKeys(inputUsername);
	}
	
	public void setPassword(String inputPassword) {
	
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(inputPassword);
	}
	
	public void clickLoginButton() {
	
		driver.findElement(loginButton).click();
	
	}
}