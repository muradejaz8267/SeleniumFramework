package helper;

import java.time.Duration;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility 
{
	
	/*
	 *    
	 *    select values from Dropdown
	 *    alert
	 *    frames
	 *    window 
	 *    waits
	 *    screenshot
	 *    custom dropdown
	 *  
	 */
	
	
	public static String captureScreenshot(WebDriver driver)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		return ts.getScreenshotAs(OutputType.BASE64);
	}
	public static void selectValueFromDropdown(WebElement element,String valueToSelect)
	{
		
		Select dropdown=new Select(element);
		
		dropdown.selectByVisibleText(valueToSelect);
		
		System.out.println("*********** Selected "+valueToSelect+" From Dropdown");
		
	}
	

	public static void closeBrowser(WebDriver driver)
	{
		System.out.println("*********** Closing the browser ***********");
		
		if(driver!=null)
		{
			driver.quit();
		}
		
		System.out.println("*********** Application Closed ***********");
		
	}
	
	public static void waitForSeconds(int seconds)
	{
		try 
		{
			System.out.println("*********** Waiting for "+seconds+" Seconds ***********");
			
			Thread.sleep(seconds*1000);
			
		} catch (InterruptedException e) 
		{
			
		}
	}
	
	public static void clickElemment(WebDriver driver , By locator) {
		
		try {
			Utility.checkElement(driver, locator).click();
		}
		catch(Exception e) {
			System.out.println("WebElement Click failed Trying with JS Click");
			clickUsingJS(driver ,locator);
			
		}
		
	}
	
	public static void clickUsingJS(WebDriver driver, By locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", driver.findElement(locator));
	}
	
	public static void typeOnElement(WebDriver driver , By locator , String textToType)
	{
		Utility.checkElement(driver, locator).sendKeys(textToType);
		
	}	
	public static WebElement checkElement(WebDriver driver, By locaotor) {
		WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(30));
		WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(locaotor));
		return ele;
	}

}
