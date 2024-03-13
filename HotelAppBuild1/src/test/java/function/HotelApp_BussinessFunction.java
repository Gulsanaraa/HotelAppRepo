package function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HotelApp_BussinessFunction {
	
	
	public void loginFun(WebDriver driver,String username, String password) {
		driver.findElement(By.id("username")).click();
	    driver.findElement(By.id("username")).clear();
	    driver.findElement(By.id("username")).sendKeys(username);
	    driver.findElement(By.id("password")).click();
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys(password);
	    driver.findElement(By.id("login")).click();
	}
	

}
