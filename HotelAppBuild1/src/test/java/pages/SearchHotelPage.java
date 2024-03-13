package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SearchHotelPage{
		
	WebDriver driver;
	public SearchHotelPage(WebDriver driver) {
		this.driver = driver;
	}
	public By location = By.id("location");
	public By noOfPeople = By.id("adult_room");
	
	public void selectFromDropDown(By element, String input) {
		Select selectElement = new Select(driver.findElement(element));
		selectElement.selectByVisibleText(input);
	}
	public boolean verifyLocation() {
	
		String slocation = driver.findElement(location).getAttribute("value");
		if(slocation.equalsIgnoreCase("Sydney"))
			return true;
		else
			return false;
	}
}