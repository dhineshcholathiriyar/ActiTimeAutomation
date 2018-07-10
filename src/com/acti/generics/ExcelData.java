package com.acti.generics;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelData 
{
	public static String getData(String file_path,String sheetName,int rowNum,int cellNum)
	{
		try
		{
		FileInputStream fis=new FileInputStream(new File(file_path));
		String text = WorkbookFactory.create(fis).getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		return text;
		}
		catch(Exception e)
		{
			return " ";
		}
		
	}
	
	public static int getRowCount(String file_path,String sheetName)
	{
		try
		{
		FileInputStream fis=new FileInputStream(new File(file_path));
		int rowCount = WorkbookFactory.create(fis).getSheet(sheetName).getLastRowNum();
		return rowCount;
		}
		catch(Exception e)
		{
			return 0;
		}
		
	}
	
	
	
}
