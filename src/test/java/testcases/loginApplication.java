package testcases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.chaintest.plugins.ChainTestListener;

import base.BaseClass;
import dataprovider.DataProviders;
import pages.DashBoardPage;
import pages.LoginPage;



public class loginApplication extends BaseClass{
	LoginPage login ; 
	DashBoardPage dashboard;
	@Test(dataProvider = "logincredentials" , dataProviderClass = DataProviders.class)
	public void loginWithValidCredenatials(String user,String pass) {
	
	    login = new LoginPage(driver);
	    dashboard = login.loginToApplication(user,pass);
	    ChainTestListener.log("LOG : PASS User is able to login ");
	    
	    
		Assert.assertTrue(dashboard.getWelcomeText().contains("Welcome"),"Login Failed");
		ChainTestListener.log("LOG PASS :  User is able to get welcome message");
		dashboard.logoutFromApplication();
		Assert.assertTrue(login.isSigninDisplayed(),"Logout Failed");
	}
	
	
	
	
}
