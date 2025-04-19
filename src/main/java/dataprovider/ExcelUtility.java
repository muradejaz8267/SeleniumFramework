package dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility 
{
	static XSSFWorkbook wb=null;
	
	public static Object[][] getData(String excelName,String sheetName)
	{
		// locating the file
		File src=new File(System.getProperty("user.dir")+"/TestData/"+excelName+".xlsx");
		
		FileInputStream fis = null;
		
		try 
		{
			fis=new FileInputStream(src);
			
		} catch (FileNotFoundException e) 
		{
			System.out.println("File Not Found "+e.getMessage());
		}
		
		try 
		{
			// load the workbook
			wb=new XSSFWorkbook(fis);
			
		} catch (IOException e) 
		{
			System.out.println("Could not load the file "+e.getMessage());
		}
		
		XSSFSheet sh1=wb.getSheet(sheetName);
		
		int row=sh1.getPhysicalNumberOfRows();
		
		int column=sh1.getRow(0).getPhysicalNumberOfCells();
		
		Object [][]arr=new Object[row][column];
		
		// rows count
		for(int i=0;i<row;i++)
		{
			// column count
			for(int j=0;j<column;j++)
			{
				arr[i][j]= ExcelUtility.getCellData(sheetName, i, j);
				
			}
			
		}
		
		return arr;
		
	}
	
	public static Object[][] getData(String sheetName)
	{
		
		File src=new File(System.getProperty("user.dir")+"/TestData/TestData.xlsx");
		
		FileInputStream fis = null;
		
		try 
		{
			fis=new FileInputStream(src);
			
		} catch (FileNotFoundException e) 
		{
			System.out.println("File Not Found "+e.getMessage());
		}
		
		try 
		{
			wb=new XSSFWorkbook(fis);
			
		} catch (IOException e) 
		{
			System.out.println("Could not load the file "+e.getMessage());
		}
		
		XSSFSheet sh1=wb.getSheet(sheetName);
		
		int row=sh1.getPhysicalNumberOfRows();
		
		int column=sh1.getRow(0).getPhysicalNumberOfCells();
		
		Object [][]arr=new Object[row][column];
		
		// rows count
		for(int i=0;i<row;i++)
		{
			// column count
			for(int j=0;j<column;j++)
			{
				arr[i][j]= ExcelUtility.getCellData(sheetName, i, j);
				
			}
			
			
		}
		
		return arr;
		
	}
	
	
	// check cell type and return data as String
	public static String getCellData(String sheetName, int row, int column) {
	    if (wb == null) {
	        throw new IllegalStateException("Workbook is not initialized.");
	    }

	    XSSFSheet sheet = wb.getSheet(sheetName);
	    if (sheet == null) {
	        throw new IllegalArgumentException("Sheet " + sheetName + " not found.");
	    }

	    if (sheet.getRow(row) == null || sheet.getRow(row).getCell(column) == null) {
	        return ""; // return blank if cell is missing
	    }

	    XSSFCell cell = sheet.getRow(row).getCell(column);
	    CellType celltype = cell.getCellType();
	    String data = "";

	    switch (celltype) {
	        case STRING:
	            data = cell.getStringCellValue();
	            break;
	        case BOOLEAN:
	            data = String.valueOf(cell.getBooleanCellValue());
	            break;
	        case NUMERIC:
	            data = String.valueOf(cell.getNumericCellValue());
	            break;
	        case BLANK:
	            data = "";
	            break;
	        default:
	            data = "";
	            break;
	    }

	    return data;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
