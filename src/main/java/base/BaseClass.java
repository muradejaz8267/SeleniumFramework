package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.chaintest.plugins.ChainTestListener;

import dataprovider.ConfigUtility;
import factory.Browserfactory;

public class BaseClass 
{   
	public WebDriver driver;
	@BeforeClass
	public void setup()
	{
		ChainTestListener.log("LOG:INFO - Setting up browser");
		
		driver=Browserfactory.startBrowser(ConfigUtility.readProperty("Browser"), ConfigUtility.readProperty("qaenv"));
		
	}
	@AfterClass
	public void tearDown() 
	{    
		ChainTestListener.log("LOG Info : Close Browser ");
		System.out.println("LOG:INFO - Closing browser");
        driver.quit();	
	}
	
}
