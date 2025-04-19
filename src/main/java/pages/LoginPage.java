package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helper.Utility;

public class LoginPage 
{
   static WebDriver driver;
   
   public LoginPage(WebDriver driver) {
	   this.driver = driver;
   }
   
   By username = By.xpath("//input[@id='email1']");
   By password = By.xpath("//input[@id='password1']");
   By loginButton = By.xpath("//button[normalize-space()='Sign in']");
   By SignIn = By.xpath("//h2[normalize-space()='Sign ']");
   
   public DashBoardPage loginToApplication(String user, String pass) 
   {
	   Utility.typeOnElement(driver, username, user);
	  // driver.findElement(username).sendKeys(user);
	   Utility.typeOnElement(driver, password, pass);
	   //driver.findElement(password).sendKeys(pass);
	   Utility.clickUsingJS(driver, loginButton);
	   //Utility.clickUsingJS(driver, loginButton);
	  //driver.findElement(loginButton).click();
	   
	   DashBoardPage dashboard = new DashBoardPage(driver);
	   return dashboard;
   }
   
   
   public boolean isSigninDisplayed() 
   {
	boolean status = Utility.checkElement(driver, SignIn).isDisplayed();     
	return status;
   }
   
   
   
   
   }
   
   
   
   

