package com.ABSLI.qa.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Vlookup {

	public static void applyVLookup(String filePath) throws IOException {
		File file = new File(filePath);

		// Check if file exists
		if (!file.exists()) {
			System.err.println("File does not exist: " + filePath);
			return;
		}

		// Open the existing workbook
		try (FileInputStream fis = new FileInputStream(filePath); Workbook workbook = new XSSFWorkbook(fis)) {

			// Access Sheet2 where we want to apply VLOOKUP
			Sheet sheet2 = workbook.getSheet("Sheet2");
			if (sheet2 == null) {
				System.err.println("Sheet2 does not exist in the file.");
				return;
			}

			// Loop through the rows in Sheet2 and apply VLOOKUP formula
			for (Row row : sheet2) {
				Cell keyCell = row.getCell(0); // Key Column

				if (keyCell != null) {
					String keyValue;

					// Handle different cell types
					switch (keyCell.getCellType()) {
					case STRING:
						keyValue = keyCell.getStringCellValue();
						break;
					case NUMERIC:
						keyValue = String.valueOf(keyCell.getNumericCellValue());
						break;
					case BOOLEAN:
						keyValue = String.valueOf(keyCell.getBooleanCellValue());
						break;
					case FORMULA:
						keyValue = keyCell.getCellFormula();
						break;
					default:
						keyValue = "";
						break;
					}

					if (!keyValue.isEmpty()) {
						Cell formulaCell = row.createCell(1); // Formula Column
						String formula = String.format("VLOOKUP(A:A,Sheet1!A:J,7,0)", row.getRowNum() + 1);
						formulaCell.setCellFormula(formula);
					}
				}
			}

			// Generate the updated file path
			String updatedFilePath = Paths.get(file.getParent(), "updated_" + file.getName()).toString();

			// Write changes to the new file
			try (FileOutputStream fos = new FileOutputStream(updatedFilePath)) {
				workbook.write(fos);
			}

			System.out.println("VLOOKUP applied and file saved as: " + updatedFilePath);
		}
	}

	public static void main(String[] args) {
		try {
			applyVLookup("C:\\Users\\Mallikandan E\\Documents\\testdatavlook.xlsx");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
/*
 * public static void applyVLookup(String filePath) throws IOException { File
 * file = new File(filePath);
 * 
 * // Check if file exists if (!file.exists()) {
 * System.err.println("File does not exist: " + filePath); return; }
 * 
 * // Open the existing workbook try (FileInputStream fis = new
 * FileInputStream(filePath); Workbook workbook = new XSSFWorkbook(fis)) {
 * 
 * // Access Sheet2 where we want to apply VLOOKUP Sheet sheet2 =
 * workbook.getSheet("Sheet2"); if (sheet2 == null) {
 * System.err.println("Sheet2 does not exist in the file."); return; }
 * 
 * // Loop through the rows in Sheet2 and apply VLOOKUP formula
 * 
 * for (Row row : sheet2) { Cell keyCell = row.getCell(0); // Key Column if
 * (keyCell != null && !keyCell.getStringCellValue().isEmpty()) { Cell
 * formulaCell = row.createCell(1); // Formula Column String formula =
 * String.format("VLOOKUP(A:A,Sheet1!A:J,7,0)", row.getRowNum() + 1);
 * formulaCell.setCellFormula(formula); } }
 * 
 * // Write changes to a new file try (FileOutputStream fos = new
 * FileOutputStream("updated_" + filePath)) { workbook.write(fos); }
 * 
 * System.out.println("VLOOKUP formulas applied and file saved as updated_" +
 * filePath); } }
 * 
 * public static void main(String[] args) { try {
 * applyVLookup("C:\\Users\\Mallikandan E\\Documents\\testdatavlook.xlsx"); }
 * catch (IOException e) { e.printStackTrace(); } } }
 * 
 * /* public class Vlookup {
 * 
 * public static void applyVLookup(String filePath) throws IOException { //
 * Ensure the file path is correct File file = new File(filePath); if
 * (!file.exists()) { System.err.println("File does not exist: " + filePath);
 * return; }
 * 
 * try (FileInputStream fis = new FileInputStream(filePath); Workbook workbook =
 * new XSSFWorkbook(fis)) {
 * 
 * // Access Sheet2 where we want to apply VLOOKUP Sheet sheet2 =
 * workbook.getSheet("Sheet2"); if (sheet2 == null) {
 * System.err.println("Sheet2 does not exist in the file."); return; }
 * 
 * // Loop through the rows in Sheet2 and apply VLOOKUP formula for (Row row :
 * sheet2) { Cell keyCell = row.getCell(0); // Key Column if (keyCell != null &&
 * !keyCell.getStringCellValue().isEmpty()) { Cell formulaCell =
 * row.createCell(1); // Formula Column String formula =
 * String.format("VLOOKUP(A%d, Sheet1!$A$1:$B$10, 2, FALSE)", row.getRowNum() +
 * 1); formulaCell.setCellFormula(formula); } }
 * 
 * // Generate the updated file path String updatedFilePath = "updated_" +
 * file.getName();
 * 
 * // Write changes to the new file try (FileOutputStream fos = new
 * FileOutputStream(updatedFilePath)) { workbook.write(fos); }
 * 
 * System.out.println("VLOOKUP applied and file saved as: " + updatedFilePath);
 * } }
 * 
 * public static void main(String[] args) { try {
 * applyVLookup("C:\\Users\\Mallikandan E\\Documents\\testdatavlook.xlsx"); }
 * catch (IOException e) { e.printStackTrace(); } } }
 */
