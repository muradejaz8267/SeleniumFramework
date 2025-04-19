package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.chaintest.plugins.ChainTestListener;

import base.BaseClass;
import factory.Browserfactory;
import helper.Utility;

public class MyTestNGListener implements ITestListener {
	
	

	public void onTestSuccess(ITestResult result) 
	{
		ChainTestListener.log("LOG PASS- Test Passed " +result.getMethod().getMethodName());
		
	}
	
	public void onTestFailure(ITestResult result) {
	    WebDriver driver = Browserfactory.getDriver();

	    if (driver != null) {
	        String screenshot = Utility.captureScreenshot(driver);
	        ChainTestListener.embed(screenshot, "image/png");
	    } else {
	        System.out.println("Driver is null, cannot capture screenshot");
	    }

	    ChainTestListener.log("LOG:FAIL - Test Failed " + result.getMethod().getMethodName() + " " + result.getThrowable().getMessage());
	}
	
	public void onTestSkipped(ITestResult result) 
	{
		ChainTestListener.log("LOG Skipped- Test Skipped " +result.getMethod().getMethodName());
		
	}
	
	
}
