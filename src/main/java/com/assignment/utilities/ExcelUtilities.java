package com.assignment.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.assignment.exceptions.ExcelFileReadException;
import com.assignment.exceptions.InvalidExcelPathException;

/**
 * Utility class to read from the excel.
 * 
 * @author Manpreet Kaur M
 * 22-Jun-2021
 * 
 * @see com.assignment.listeners.MethodInterceptor
 * @see DataProviderUtilities
 */

public final class ExcelUtilities {

	/**
	 * Private constructor to avoid external instantiation
	 */
	
	private ExcelUtilities() {
	}

	/**
	 * Encapsulates all the values from the mentioned excel sheet and stores it in
	 * a list holding HashMaps. Keys for the map are the column headers in the excel sheet.
	 * 
	 * @param excelFile
	 * Excel File to read the value from
	 * 
	 * @param sheetName
	 * Excel sheet name within the excel file to read the value from
	 * 
	 * @return List where each index holds a map and Each map holds the details about the test
	 * 
	 * @throws IOException
	 */
	
	public static List<Map<String, String>> getExcelFile(String excelFile, String sheetName) throws IOException{

		List<Map<String, String>> list = null;
		XSSFWorkbook workbook = null;

		try(FileInputStream fs = new FileInputStream(excelFile)) {

			workbook = new XSSFWorkbook(fs);
			XSSFSheet sheet = workbook.getSheet(sheetName);

			Map<String, String> map = null;
			list = new ArrayList<>();
			int noOfRows = sheet.getLastRowNum();

			int noOfCols = sheet.getRow(0).getLastCellNum();

			for(int i=1; i<=noOfRows; i++) {
				map = new HashMap<>();
				for(int j=0; j<noOfCols; j++) {
					String key = sheet.getRow(0).getCell(j).getStringCellValue();
					String value = sheet.getRow(i).getCell(j).getStringCellValue();
					map.put(key, value);
				}
				list.add(map);
			}
		}
		catch (FileNotFoundException e1) {
			throw new InvalidExcelPathException("Required Excel file to be read is not found");
		}
		catch(IOException e) {
			throw new ExcelFileReadException("IO Exception while trying to read the excel file");
		}
		return list;	
	}

}
