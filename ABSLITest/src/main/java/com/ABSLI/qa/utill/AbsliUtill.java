package com.ABSLI.qa.utill;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AbsliUtill  {
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	
	public static Object[][] getDataFromExcel(String FileName, String sheetName)
	{
	
		Object [][] data = null;
	{
		try {
			
			FileInputStream fis = new FileInputStream(FileName);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			XSSFRow row = sheet.getRow(0);
			int noOfRows = sheet.getPhysicalNumberOfRows();
			int noOfCols = row.getLastCellNum();
			Cell cell;
			
			data = new Object[noOfRows-1][noOfCols];
			
			for(int i=1;i<noOfRows;i++)
			{
				for(int j=0;j<noOfCols;j++)
				{
					row = sheet.getRow(i);
					cell=row.getCell(j);
					data[i-1][j]=cell.toString();

				}
			}
			
		} catch (IOException e) {
			System.out.println("The exception is: "+e.getMessage());
		}
		catch (Exception e) {
		    e.printStackTrace(); 
		}
	}
	
	return data;
	}
}
