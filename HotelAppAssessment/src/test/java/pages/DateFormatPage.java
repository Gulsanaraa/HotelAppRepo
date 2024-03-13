package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DateFormatPage {
	WebDriver driver;
	public DateFormatPage(WebDriver driver) {
		this.driver = driver;
	}
	public By datepick_in = By.id("datepick_in");
	public By datepick_out = By.id("datepick_out");
	
	public void setDate(By element,String input) {
		driver.findElement(element).click();
		driver.findElement(element).clear();
		driver.findElement(element).sendKeys(input);
		
	}
	
	public boolean verifyLocation() {
		return true;
	
	}
	

}
