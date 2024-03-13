package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectHotelPage {
	
	
		WebDriver driver ;
		//All the WebElements
			public By location = By.id("location");
			public By room = By.id("adult_room");
			By submit = By.id("Submit");
	
	
		public SelectHotelPage(WebDriver driver)
		{
		
			this.driver = driver;
		}
	
		
		//methods for all the elements
		public void selectFromDropDown(String selectItem, By element) {
			Select selectElement = new Select(driver.findElement(element));
			selectElement.selectByVisibleText(selectItem);
		}
		public void search() {
	
			driver.findElement(submit).click();
		}
	
		public Boolean verifyLocation() {
			String slocation = driver.findElement(location).getAttribute("value");
			if(slocation.equalsIgnoreCase("Sydney"))
				return true;
			else
				return false;
	
	}
}
