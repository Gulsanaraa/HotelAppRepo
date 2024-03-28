package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\61470\\OneDrive\\Desktop\\gul\\Testing\\chromedriver-win64\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriver webDriver = new ChromeDriver();
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    webDriver.get("https://www.google.com/");
	    
	    
	    ExtentReports extent = new ExtentReports();
	    ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
	    extent.attachReporter(spark);
	    extent.createTest("MyFirstTest").log(Status.PASS, "This is a logging event for MyFirstTest, and it passed!");
	    extent.flush();
	    
	    webDriver.quit();

	}

}
