package com.HRMS.Utilities;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner.stdDSA;
import org.testng.annotations.DataProvider;

public class ExcelFileHandler {
	
	private String path = "D:\\Login_Excel.xlsx";
    private String cellData ;

	
    
    
	public String readData(int sheet_index, int row_num, int cell_num ) throws IOException {

		File fileStream = new File(path);
		FileInputStream file=new FileInputStream(fileStream);
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheetAt(sheet_index);
		XSSFRow row = sheet.getRow(row_num);
		XSSFCell cell = row.getCell(cell_num);

		// check the cell type and handle it appropriately
		if(cell.getCellType() == CellType.NUMERIC) {
		    // the cell contains a numeric value, so get the value directly
            cellData = String.valueOf(cell.getNumericCellValue());
			System.out.println("Numeric value: " + cellData);
		    
		}
		else if (cell.getCellType() == CellType.STRING) {
		    // the cell contains a string value, so get the value as a string and convert it to a numeric value
            cellData = cell.getStringCellValue();
//		    double numericValue = Double.parseDouble(cellData);
		    System.out.println("String value: " + cellData);
		} 
		else {
		    // the cell contains an unsupported value type, so handle it as appropriate
		    System.out.println("Unsupported value type: " + cell.getCellType());
		}
//		print whatever data take from excel
		return cellData;
		
	}
	
//	return one column values from excel in array format code and loop to that array java
		
	public String[] readColumnData(String sheetName, int sheet, int rowNumber, int columnNumber) {
		
		try {
			File fileStream = new File(path);
			FileInputStream file = new FileInputStream(fileStream);
			XSSFWorkbook wb = new XSSFWorkbook(file);
			XSSFSheet sheetObj = wb.getSheet(sheetName);
			
			 // get the total number of rows in the sheet
            int rowCount = sheetObj.getLastRowNum() - sheetObj.getFirstRowNum() + 1;
			
            // create an array to store the column values
            String[] columnValues = new String[rowCount];
			
            // loop through the rows and retrieve the cell value in the specified column
            for (int i = 0; i < rowCount; i++) {
                Row row = sheetObj.getRow(i);
                Cell cell = row.getCell(columnNumber);
                if(cell != null) {
                columnValues[i] = cell.getStringCellValue();
                }
                else {
                	columnValues[i]="";
				}
                }
			
			
			return columnValues;
		} catch(IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	


	public void writeData(int sheet_index,int row_index,int cell_index,String cell ) throws IOException {
		
		try {
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
//		XSSFWorkbook wb=new XSSFWorkbook();
		
		XSSFWorkbook wb=new XSSFWorkbook();
	    XSSFSheet wds=wb.getSheetAt(sheet_index);
		XSSFRow wdr=wds.getRow(row_index);
		XSSFCell wdc=wdr.createCell(cell_index);
		wdc.setCellValue(cell);
//		wb.getSheetAt(sheet_index).getRow(row_index).createCell(cell_index).setCellValue(cell);
		
		FileOutputStream fos = new FileOutputStream(file);
		wb.write(fos);
		fos.close();
		fis.close();}
		catch(IOException  e) {
			e.printStackTrace();
		}
	}
	
	public int readDataint(int sheet_index, int row_num, int cell_num ) throws IOException {

		File fileStream = new File(path);
		FileInputStream file=new FileInputStream(fileStream);
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheetAt(sheet_index);
		
		int dataint = (int) sheet.getRow(row_num).getCell(cell_num).getNumericCellValue();
//		print whatever data take from excel
		return dataint;
		
	}
	
}
