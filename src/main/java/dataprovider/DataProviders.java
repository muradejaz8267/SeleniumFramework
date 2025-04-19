package dataprovider;

import org.testng.annotations.DataProvider;

import com.aventstack.chaintest.plugins.ChainTestListener;

public class DataProviders {

	@DataProvider(name = "logincredentials")
	public static Object [][] getData()
	{
	
		ChainTestListener.log("LOG :INFO - Dataprovider getting ready for testdata");
		Object [][] arr = ExcelUtility.getData("Sheet1");
	
		ChainTestListener.log("LOG :INFO - Dataprovider getting ready with testdata");
	    return arr;
	} 
}
