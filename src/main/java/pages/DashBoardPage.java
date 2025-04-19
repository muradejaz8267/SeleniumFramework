package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helper.Utility;

public class DashBoardPage {
	
	WebDriver driver;
	public DashBoardPage(WebDriver driver)
	{
	   this.driver =driver;	
	}
	
	
	By menu = By.xpath("//img[@alt='menu']");
	By signout = By.xpath("//button[normalize-space()='Sign out']");
	By welcomeMsg = By.xpath("//h4");
	
	public String getWelcomeText() 
	{
		String msg = Utility.checkElement(driver, welcomeMsg).getText();
		return msg;
	}
	
	
	
	public void logoutFromApplication() 
	{
	   Utility.clickUsingJS(driver, menu);	
	   //driver.findElement(menu).click();
	   Utility.clickUsingJS(driver, signout);
	   //driver.findElement(signout).click();
	}
	
	

}
