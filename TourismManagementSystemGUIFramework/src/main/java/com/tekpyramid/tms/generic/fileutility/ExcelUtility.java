package com.tekpyramid.tms.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public String getDataFromExcel(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
		FileInputStream fr  = new FileInputStream(".\\src\\test\\resources\\testScriptData.xlsx");
		Workbook ws = WorkbookFactory.create(fr);
		String data = ws.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		return data;
	}
}
