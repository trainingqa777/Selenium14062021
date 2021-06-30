package excelUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWorks {
	
	private static XSSFWorkbook workbook;
	private static XSSFSheet worksheet;
	private static XSSFRow row;
	private static XSSFCell cell;
	
	public static String path = "C:\\MySampleWorks\\TestData.xlsx";
	
	public static void main(String[] args) {
		printAllData();
		//readFromExcel(1,1);
	}
	
	//Set Excel File - Establish a connection
	public static void setExcelFile(String sheetname) {
		try {
			File file = new File(path);
			FileInputStream fileInputStream = new FileInputStream(file);
			
			workbook = new XSSFWorkbook(fileInputStream);
			worksheet = workbook.getSheet(sheetname);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//Read From Excel
	public static void readFromExcel(int rowNum, int colNum) {
		//Create Connection
		setExcelFile("DataSheet");
		
		cell = worksheet.getRow(rowNum).getCell(colNum);
		
		String cellValue = cell.getStringCellValue();
		System.out.println("Cell Value from Excel : "+cellValue);
		
	}
	//Write to Excel
	public static void writeToExcel(int rowNum, int colNum, String result) {
		
		//Create Connection
		try {
			setExcelFile("DataSheet");
			worksheet.getRow(rowNum).createCell(colNum).setCellValue(result);
			
			FileOutputStream fileOutputStream = new FileOutputStream(path);
			workbook.write(fileOutputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	
	public static int getRowCountInSheet(){
	       int rowcount = worksheet.getLastRowNum()-worksheet.getFirstRowNum();
	       return rowcount;
	    }
	
	public static int getCellCount(int rowNum) {
		//get cell count in a row
        int cellcount=worksheet.getRow(rowNum).getLastCellNum();
        return cellcount;
	}
	
	public static void printAllData() {
		setExcelFile("DataSheet");
		int rowCount = getRowCountInSheet();
		
		for(int i=0; rowCount>=i; i++) {
			System.out.println("Values from row "+i);
			int cellCount = getCellCount(i);
			for(int j=0; cellCount>j; j++) {
				cell = worksheet.getRow(i).getCell(j);
				System.out.print(cell.getStringCellValue()+",");
			}	
			System.out.println("\n");
		}
	}
	
}
