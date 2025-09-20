package com.tekpyramid.tms.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelUtility {
	
	public String getDataFromExcel(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis  = new FileInputStream(".\\src\\test\\resources\\testScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		wb.close();
		return data;
	}
	
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis  = new FileInputStream(".\\src\\test\\resources\\testScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowCount = wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return rowCount;
	}
	
	public void writeDataToExcel(String sheetName, int rowNum, int cellNum, String inputData) throws EncryptedDocumentException, IOException {
		FileInputStream fis  = new FileInputStream(".\\src\\test\\resources\\testScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cel = row.getCell(cellNum);
		cel.setCellValue(inputData);
		
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\testScriptData.xlsx");
		wb.write(fos);
		wb.close();
	}
}
