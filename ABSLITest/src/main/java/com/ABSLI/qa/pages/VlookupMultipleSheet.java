package com.ABSLI.qa.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class VlookupMultipleSheet {

	public static void main(String[] args) {
		String sourceFilePath = "C:\\Users\\Mallikandan E\\Documents\\multiplevlookup.xlsx";
		String targetFilePath = "C:\\Users\\Mallikandan E\\Documents\\multid.xlsx";

		try (FileInputStream sourceFis = new FileInputStream(sourceFilePath);
				Workbook sourceWorkbook = new XSSFWorkbook(sourceFis);
				FileInputStream targetFis = new FileInputStream(targetFilePath);
				Workbook targetWorkbook = new XSSFWorkbook(targetFis)) {

			Sheet sourceSheet = sourceWorkbook.getSheetAt(0);
			Sheet targetSheet = targetWorkbook.getSheetAt(0);

			// Create a new sheet in the target workbook for source data
			Sheet newSheet = targetWorkbook.createSheet("SourceData");
			for (int i = 0; i <= sourceSheet.getLastRowNum(); i++) {
				Row sourceRow = sourceSheet.getRow(i);
				Row newRow = newSheet.createRow(i);
				if (sourceRow != null) {
					for (int j = 0; j < sourceRow.getLastCellNum(); j++) {
						Cell sourceCell = sourceRow.getCell(j);
						Cell newCell = newRow.createCell(j);
						if (sourceCell != null) {
							switch (sourceCell.getCellType()) {
							case STRING:
								newCell.setCellValue(sourceCell.getStringCellValue());
								break;
							case NUMERIC:
								newCell.setCellValue(sourceCell.getNumericCellValue());
								break;
							case BOOLEAN:
								newCell.setCellValue(sourceCell.getBooleanCellValue());
								break;
							case FORMULA:
								newCell.setCellFormula(sourceCell.getCellFormula());
								break;
							default:
								newCell.setCellType(sourceCell.getCellType());
							}
						}
					}
				}
			}

			// Apply VLOOKUP formula in the target sheet
			for (Row row : targetSheet) {
				if (row.getRowNum() == 0)
					continue; // Skip header row

				Cell keyCell = row.getCell(0);
				if (keyCell != null) {
					Cell formulaCell = row.getCell(1);
					if (formulaCell == null) {
						formulaCell = row.createCell(1);
					}
					String formula = String.format("VLOOKUP(A:A, SourceData!$A:$J, 7, FALSE)", row.getRowNum() + 1);
					formulaCell.setCellFormula(formula);
				}
			}

			// Save the updated target workbook
			try (FileOutputStream fos = new FileOutputStream(
					"C:\\Users\\Mallikandan E\\Documents\\updated_multid.xlsx")) {
				targetWorkbook.write(fos);
			}

			System.out.println(
					"VLOOKUP applied and file saved as: C:\\Users\\Mallikandan E\\Documents\\updated_multid.xlsx");

		} catch (IOException e) {
			System.err.println("An IOException occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}
}

/*
 * public static void main(String[] args) { String sourceFilePath =
 * "C:\\Users\\Mallikandan E\\Documents\\multiplevlookup.xlsx"; String
 * targetFilePath = "C:\\Users\\Mallikandan E\\Documents\\multid.xlsx";
 * 
 * try (FileInputStream sourceFis = new FileInputStream(sourceFilePath);
 * Workbook sourceWorkbook = new XSSFWorkbook(sourceFis); FileInputStream
 * targetFis = new FileInputStream(targetFilePath); Workbook targetWorkbook =
 * new XSSFWorkbook(targetFis)) {
 * 
 * Sheet sourceSheet = sourceWorkbook.getSheetAt(0); Sheet targetSheet =
 * targetWorkbook.getSheetAt(0);
 * 
 * // Check if sourceSheet and targetSheet exist if (sourceSheet == null ||
 * targetSheet == null) {
 * System.err.println("Source or Target sheet does not exist."); return; }
 * 
 * // Define a named range in the source workbook Name namedRange =
 * sourceWorkbook.createName(); namedRange.setNameName("SourceData");
 * namedRange.setRefersToFormula("Sheet1!$A$1:$J$100"); // Adjust range as
 * needed
 * 
 * // Iterate over rows of the target sheet for (Row row : targetSheet) { //
 * Skip header row if (row.getRowNum() == 0) continue;
 * 
 * Cell keyCell = row.getCell(0); if (keyCell != null) { Cell formulaCell =
 * row.getCell(1);
 * 
 * if (formulaCell == null) { formulaCell = row.createCell(1); }
 * 
 * // Construct a VLOOKUP formula using the named range String formula =
 * String.format( "VLOOKUP(A:A,[multiplevlookup.xlsx]Sheet1!$A:$J,8,FALSE)",
 * row.getRowNum() + 1 );
 * 
 * // Debug output System.out.println("Setting formula: " + formula); try {
 * formulaCell.setCellFormula(formula); } catch (Exception e) {
 * System.err.println("Error setting formula: " + e.getMessage()); } } }
 * 
 * // Save the updated target workbook try (FileOutputStream fos = new
 * FileOutputStream("C:\\Users\\Mallikandan E\\Documents\\updated_multid.xlsx"))
 * { targetWorkbook.write(fos); }
 * 
 * System.out.
 * println("VLOOKUP applied and file saved as: C:\\Users\\Mallikandan E\\Documents\\updated_multid.xlsx"
 * );
 * 
 * } catch (IOException e) { System.err.println("An IOException occurred: " +
 * e.getMessage()); e.printStackTrace(); } } }
 * 
 * /*
 * 
 * public static void main(String[] args) { String sourceFilePath =
 * "C:\\Users\\Mallikandan E\\Documents\\multiplevlookup.xlsx"; String
 * targetFilePath = "C:\\Users\\Mallikandan E\\Documents\\multid.xlsx";
 * 
 * try (FileInputStream sourceFis = new FileInputStream(sourceFilePath);
 * Workbook sourceWorkbook = new XSSFWorkbook(sourceFis); FileInputStream
 * targetFis = new FileInputStream(targetFilePath); Workbook targetWorkbook =
 * new XSSFWorkbook(targetFis)) {
 * 
 * Sheet sourceSheet = sourceWorkbook.getSheetAt(0); Sheet targetSheet =
 * targetWorkbook.getSheetAt(0);
 * 
 * // Check if sourceSheet and targetSheet exist if (sourceSheet == null ||
 * targetSheet == null) {
 * System.err.println("Source or Target sheet does not exist."); return; }
 * 
 * // Define a named range in the source workbook if needed // Example: Creating
 * a named range for the source sheet data Name namedRange =
 * sourceWorkbook.createName(); namedRange.setNameName("SourceData");
 * namedRange.setRefersToFormula("Sheet1!$A$1:$J$100"); // Adjust range as
 * needed
 * 
 * // Iterate over rows of the target sheet for (Row row : targetSheet) { //
 * Skip header row if (row.getRowNum() == 0) continue;
 * 
 * Cell keyCell = row.getCell(0); if (keyCell != null) { Cell formulaCell =
 * row.getCell(1);
 * 
 * if (formulaCell == null) { formulaCell = row.createCell(1); }
 * 
 * // Construct a VLOOKUP formula within the same workbook String formula =
 * String.format( "VLOOKUP(A:A,[multiplevlookup.xlsx]Sheet1!$A:$J,8,0)",
 * row.getRowNum() + 1 );
 * 
 * // Debug output System.out.println("Setting formula: " + formula); try {
 * formulaCell.setCellFormula(formula); } catch (Exception e) {
 * System.err.println("Error setting formula: " + e.getMessage()); } } }
 * 
 * // Save the updated target workbook try (FileOutputStream fos = new
 * FileOutputStream("C:\\Users\\Mallikandan E\\Documents\\updated_multid.xlsx"))
 * { targetWorkbook.write(fos); }
 * 
 * System.out.
 * println("VLOOKUP applied and file saved as: C:\\Users\\Mallikandan E\\Documents\\updated_multid.xlsx"
 * );
 * 
 * } catch (IOException e) { System.err.println("An IOException occurred: " +
 * e.getMessage()); e.printStackTrace(); } } }
 * 
 * /* public static void main(String[] args) { String sourceFilePath =
 * "C:\\Users\\Mallikandan E\\Documents\\multiplevlookup.xlsx"; String
 * targetFilePath = "C:\\Users\\Mallikandan E\\Documents\\multid.xlsx";
 * 
 * try (FileInputStream sourceFis = new FileInputStream(sourceFilePath);
 * Workbook sourceWorkbook = new XSSFWorkbook(sourceFis); FileInputStream
 * targetFis = new FileInputStream(targetFilePath); Workbook targetWorkbook =
 * new XSSFWorkbook(targetFis)) {
 * 
 * Sheet sourceSheet = sourceWorkbook.getSheetAt(0); Sheet targetSheet =
 * targetWorkbook.getSheetAt(0);
 * 
 * // Check if sourceSheet and targetSheet exist if (sourceSheet == null ||
 * targetSheet == null) {
 * System.err.println("Source or Target sheet does not exist."); return; }
 * 
 * // Iterate over rows of the target sheet for (Row row : targetSheet) { //
 * Skip header row if (row.getRowNum() == 0) continue;
 * 
 * Cell keyCell = row.getCell(0); if (keyCell != null) { Cell formulaCell =
 * row.getCell(1);
 * 
 * if (formulaCell == null) { formulaCell = row.createCell(1); }
 * 
 * // Construct a VLOOKUP formula (adjust for your case if needed) String
 * formula = String.format(
 * "VLOOKUP(A:A,[multiplevlookup.xlsx]Sheet1!$A:$J,8,0)", row.getRowNum() + 1,
 * new File(sourceFilePath).getName() );
 * 
 * // Debug output System.out.println("Setting formula: " + formula); try {
 * formulaCell.setCellFormula(formula); } catch (Exception e) {
 * System.err.println("Error setting formula: " + e.getMessage()); } } }
 * 
 * // Save the updated target workbook try (FileOutputStream fos = new
 * FileOutputStream("C:\\Users\\Mallikandan E\\Documents\\updated_multid.xlsx"))
 * { targetWorkbook.write(fos); }
 * 
 * System.out.
 * println("VLOOKUP applied and file saved as: C:\\Users\\Mallikandan E\\Documents\\updated_multid.xlsx"
 * );
 * 
 * } catch (IOException e) { System.err.println("An IOException occurred: " +
 * e.getMessage()); e.printStackTrace(); } } }
 * 
 * /* public static void main(String[] args) { String sourceFilePath =
 * "C:\\Users\\Mallikandan E\\Documents\\testdatavlook.xlsx"; String
 * targetFilePath = "C:\\Users\\Mallikandan E\\Documents\\multid.xlsx";
 * 
 * try (FileInputStream sourceFis = new FileInputStream(sourceFilePath);
 * Workbook sourceWorkbook = new XSSFWorkbook(sourceFis); FileInputStream
 * targetFis = new FileInputStream(targetFilePath); Workbook targetWorkbook =
 * new XSSFWorkbook(targetFis)) {
 * 
 * Sheet sourceSheet = sourceWorkbook.getSheetAt(0); Sheet targetSheet =
 * targetWorkbook.getSheetAt(0);
 * 
 * String sourceSheetName = sourceSheet.getSheetName();
 * 
 * for (Row row : targetSheet) { if (row.getRowNum() == 0) continue;
 * 
 * Cell keyCell = row.getCell(0); if (keyCell != null) { Cell formulaCell =
 * row.getCell(1);
 * 
 * if (formulaCell == null) { formulaCell = row.createCell(1); }
 * 
 * String formula = String.format(
 * "VLOOKUP(A:A,[testdatavlook.xlsx]Sheet1!$A:$K,8,0)", row.getRowNum() + 1, new
 * File(sourceFilePath).getName(), sourceSheetName );
 * formulaCell.setCellFormula(formula); } }
 * 
 * try (FileOutputStream fos = new
 * FileOutputStream("C:\\Users\\Mallikandan E\\Documents\\updated_multid.xlsx"))
 * { targetWorkbook.write(fos); }
 * 
 * System.out.
 * println("VLOOKUP applied and file saved as: C:\\Users\\Mallikandan E\\Documents\\updated_multid.xlsx"
 * );
 * 
 * } catch (IOException e) { e.printStackTrace(); } } }
 * 
 * /* public static void applyVLookup(String sourceFilePath, String
 * targetFilePath) { File sourceFile = new File(sourceFilePath); File targetFile
 * = new File(targetFilePath);
 * 
 * // Check if the source and target files exist if (!sourceFile.exists()) {
 * System.err.println("Source file does not exist: " + sourceFilePath); return;
 * } if (!targetFile.exists()) {
 * System.err.println("Target file does not exist: " + targetFilePath); return;
 * }
 * 
 * try (FileInputStream sourceFis = new FileInputStream(sourceFile); Workbook
 * sourceWorkbook = new XSSFWorkbook(sourceFis); FileInputStream targetFis = new
 * FileInputStream(targetFile); Workbook targetWorkbook = new
 * XSSFWorkbook(targetFis)) {
 * 
 * Sheet sourceSheet = sourceWorkbook.getSheetAt(0); // Source sheet Sheet
 * targetSheet = targetWorkbook.getSheetAt(0); // Target sheet
 * 
 * // Check if the source and target sheets exist if (sourceSheet == null) {
 * System.err.println("Source sheet does not exist."); return; } if (targetSheet
 * == null) { System.err.println("Target sheet does not exist."); return; }
 * 
 * // Get source sheet name String sourceSheetName = sourceSheet.getSheetName();
 * System.out.println("Source Sheet Name: " + sourceSheetName);
 * 
 * // Iterate over rows of the target sheet for (Row row : targetSheet) { //
 * Skip header row if (row.getRowNum() == 0) continue;
 * 
 * Cell keyCell = row.getCell(0); // Key column if (keyCell != null) { Cell
 * formulaCell = row.getCell(1); // Formula column
 * 
 * if (formulaCell == null) { formulaCell = row.createCell(1); // Create if it
 * does not exist }
 * 
 * // Construct the VLOOKUP formula with proper referencing String formula =
 * String.format( "vlookup([testdatavlook.xlsx]Sheet1!$A:$K,7,0)",
 * row.getRowNum() + 1, new File(sourceFilePath).getName(), sourceSheetName );
 * System.out.println("Setting formula: " + formula);
 * formulaCell.setCellFormula(formula); } }
 * 
 * // Save the updated target workbook String updatedFilePath =
 * Paths.get(targetFile.getParent(), "updated_" +
 * targetFile.getName()).toString(); try (FileOutputStream fos = new
 * FileOutputStream(updatedFilePath)) { targetWorkbook.write(fos); }
 * 
 * System.out.println("VLOOKUP applied and file saved as: " + updatedFilePath);
 * } catch (IOException e) { System.err.println("An IOException occurred: " +
 * e.getMessage()); e.printStackTrace(); } catch (Exception e) {
 * System.err.println("An unexpected error occurred: " + e.getMessage());
 * e.printStackTrace(); } }
 * 
 * public static void main(String[] args) { if (args.length != 2) { System.err.
 * println("Usage: java VlookupMultipleSheet \"C:\\Users\\Mallikandan E\\Documents\\testdatavlook.xlsx\" \"C:\\Users\\Mallikandan E\\Documents\\multid.xlsx\""
 * ); return; }
 * 
 * System.out.println("Arguments received:"); for (int i = 0; i < args.length;
 * i++) { System.out.println("Arg[" + i + "]: " + args[i]); }
 * 
 * try { applyVLookup(args[0], args[1]); } catch (Exception e) {
 * System.err.println("An error occurred in main: " + e.getMessage());
 * e.printStackTrace(); } } }
 * 
 * /* public static void applyVLookup(String sourceFilePath, String
 * targetFilePath) { File sourceFile = new File(sourceFilePath); File targetFile
 * = new File(targetFilePath);
 * 
 * // Check if the source and target files exist if (!sourceFile.exists()) {
 * System.err.println("Source file does not exist: " + sourceFilePath); return;
 * } if (!targetFile.exists()) {
 * System.err.println("Target file does not exist: " + targetFilePath); return;
 * }
 * 
 * try (FileInputStream sourceFis = new FileInputStream(sourceFile); Workbook
 * sourceWorkbook = new XSSFWorkbook(sourceFis); FileInputStream targetFis = new
 * FileInputStream(targetFile); Workbook targetWorkbook = new
 * XSSFWorkbook(targetFis)) {
 * 
 * Sheet sourceSheet = sourceWorkbook.getSheetAt(0); // Source sheet Sheet
 * targetSheet = targetWorkbook.getSheetAt(0); // Target sheet
 * 
 * // Check if the source and target sheets exist if (sourceSheet == null) {
 * System.err.println("Source sheet does not exist."); return; } if (targetSheet
 * == null) { System.err.println("Target sheet does not exist."); return; }
 * 
 * // Get source sheet name String sourceSheetName = sourceSheet.getSheetName();
 * System.out.println("Source Sheet Name: " + sourceSheetName);
 * 
 * // Iterate over rows of the target sheet for (Row row : targetSheet) { //
 * Skip header row if (row.getRowNum() == 0) continue;
 * 
 * Cell keyCell = row.getCell(0); // Key column if (keyCell != null) { Cell
 * formulaCell = row.getCell(1); // Formula column
 * 
 * if (formulaCell == null) { formulaCell = row.createCell(1); // Create if it
 * does not exist }
 * 
 * // Construct the VLOOKUP formula with proper referencing String formula =
 * String.format( "VLOOKUP(A%d, '[%s]%s'!$A:$K, 8, FALSE)", row.getRowNum() + 1,
 * new File(sourceFilePath).getName(), sourceSheetName );
 * System.out.println("Setting formula: " + formula);
 * formulaCell.setCellFormula(formula); } }
 * 
 * // Save the updated target workbook String updatedFilePath =
 * Paths.get(targetFile.getParent(), "updated_" +
 * targetFile.getName()).toString(); try (FileOutputStream fos = new
 * FileOutputStream(updatedFilePath)) { targetWorkbook.write(fos); }
 * 
 * System.out.println("VLOOKUP applied and file saved as: " + updatedFilePath);
 * } catch (IOException e) { System.err.println("An IOException occurred: " +
 * e.getMessage()); e.printStackTrace(); } catch (Exception e) {
 * System.err.println("An unexpected error occurred: " + e.getMessage());
 * e.printStackTrace(); } }
 * 
 * public static void main(String[] args) { if (args.length != 2) { System.err.
 * println("Usage: java VlookupMultipleSheet \"C:\\Users\\Mallikandan E\\Documents\\testdatavlook.xlsx\" \"C:\\Users\\Mallikandan E\\Documents\\multid.xlsx\""
 * ); return; }
 * 
 * System.out.println("Arguments received:"); for (int i = 0; i < args.length;
 * i++) { System.out.println("Arg[" + i + "]: " + args[i]); }
 * 
 * try { applyVLookup(args[0], args[1]); } catch (Exception e) {
 * System.err.println("An error occurred in main: " + e.getMessage());
 * e.printStackTrace(); } } } /* public static void applyVLookup(String
 * sourceFilePath, String targetFilePath) throws IOException { File sourceFile =
 * new File(sourceFilePath); File targetFile = new File(targetFilePath);
 * 
 * // Check if the source and target files exist if (!sourceFile.exists()) {
 * System.err.println("Source file does not exist: " + sourceFilePath); return;
 * } if (!targetFile.exists()) {
 * System.err.println("Target file does not exist: " + targetFilePath); return;
 * }
 * 
 * try (FileInputStream sourceFis = new FileInputStream(sourceFile); Workbook
 * sourceWorkbook = new XSSFWorkbook(sourceFis); FileInputStream targetFis = new
 * FileInputStream(targetFile); Workbook targetWorkbook = new
 * XSSFWorkbook(targetFis)) {
 * 
 * Sheet sourceSheet = sourceWorkbook.getSheetAt(0); // Source sheet Sheet
 * targetSheet = targetWorkbook.getSheetAt(0); // Target sheet
 * 
 * // Check if the source and target sheets exist if (sourceSheet == null) {
 * System.err.println("Source sheet does not exist."); return; } if (targetSheet
 * == null) { System.err.println("Target sheet does not exist."); return; }
 * 
 * // Get source sheet name String sourceSheetName = sourceSheet.getSheetName();
 * 
 * // Iterate over rows of the target sheet for (Row row : targetSheet) { //
 * Skip header row if (row.getRowNum() == 0) continue;
 * 
 * Cell keyCell = row.getCell(0); // Key column
 * 
 * if (keyCell != null) { Cell formulaCell = row.getCell(1); // Formula column
 * 
 * if (formulaCell == null) { formulaCell = row.createCell(1); // Create if it
 * does not exist }
 * 
 * // Construct the VLOOKUP formula with proper referencing String formula =
 * String.format( "VLOOKUP(A%d, '[%s]%s'!$A:$K, 8, FALSE)", row.getRowNum() + 1,
 * new File(sourceFilePath).getName(), sourceSheetName );
 * formulaCell.setCellFormula(formula); } }
 * 
 * // Save the updated target workbook String updatedFilePath =
 * Paths.get(targetFile.getParent(), "updated_" +
 * targetFile.getName()).toString(); try (FileOutputStream fos = new
 * FileOutputStream(updatedFilePath)) { targetWorkbook.write(fos); }
 * 
 * System.out.println("VLOOKUP applied and file saved as: " + updatedFilePath);
 * } catch (IOException e) { System.err.println("An error occurred: " +
 * e.getMessage()); e.printStackTrace(); } } public static void main(String[]
 * args) { if (args.length != 2) { System.err.
 * println("Usage:java VlookupMultipleSheet \"C:\\testdatavlook.xlsx\" \"C:\\multid.xlsx\""
 * ); return; }
 * 
 * System.out.println("Arguments received:"); for (int i = 0; i < args.length;
 * i++) { System.out.println("Arg[" + i + "]: " + args[i]); }
 * 
 * try { applyVLookup(args[0], args[1]); } catch (IOException e) {
 * System.err.println("An error occurred: " + e.getMessage());
 * e.printStackTrace(); } }
 * 
 * }
 * 
 * /* public static void applyVLookup(String sourceFilePath, String
 * targetFilePath) throws IOException { File sourceFile = new
 * File(sourceFilePath); File targetFile = new File(targetFilePath);
 * 
 * // Check if the source and target files exist if (!sourceFile.exists()) {
 * System.err.println("Source file does not exist: " + sourceFilePath); return;
 * } if (!targetFile.exists()) {
 * System.err.println("Target file does not exist: " + targetFilePath); return;
 * }
 * 
 * try (FileInputStream sourceFis = new FileInputStream(sourceFile); Workbook
 * sourceWorkbook = new XSSFWorkbook(sourceFis); FileInputStream targetFis = new
 * FileInputStream(targetFile); Workbook targetWorkbook = new
 * XSSFWorkbook(targetFis)) {
 * 
 * Sheet sourceSheet = sourceWorkbook.getSheetAt(0); // Source sheet Sheet
 * targetSheet = targetWorkbook.getSheetAt(0); // Target sheet
 * 
 * // Check if the source and target sheets exist if (sourceSheet == null ||
 * targetSheet == null) {
 * System.err.println("Source or Target sheet does not exist."); return; }
 * 
 * // Get source sheet name String sourceSheetName = sourceSheet.getSheetName();
 * 
 * // Iterate over rows of the target sheet for (Row row : targetSheet) { //
 * Skip header row if (row.getRowNum() == 0) continue;
 * 
 * Cell keyCell = row.getCell(0); // Key column
 * 
 * if (keyCell != null) { Cell formulaCell = row.getCell(1); // Formula column
 * 
 * if (formulaCell == null) { formulaCell = row.createCell(1); // Create if it
 * does not exist }
 * 
 * // Construct the VLOOKUP formula with proper referencing String formula =
 * String.format( "VLOOKUP(A%d, '[%s]%s'!$A:$K, 8, FALSE)", row.getRowNum() + 1,
 * new File(sourceFilePath).getName(), sourceSheetName );
 * formulaCell.setCellFormula(formula); } }
 * 
 * // Save the updated target workbook String updatedFilePath =
 * Paths.get(targetFile.getParent(), "updated_" +
 * targetFile.getName()).toString(); try (FileOutputStream fos = new
 * FileOutputStream(updatedFilePath)) { targetWorkbook.write(fos); }
 * 
 * System.out.println("VLOOKUP applied and file saved as: " + updatedFilePath);
 * } catch (IOException e) { System.err.println("An error occurred: " +
 * e.getMessage()); e.printStackTrace(); } }
 * 
 * public static void main(String[] args) { if (args.length != 2) { System.err.
 * println("Usage: java VlookupMultipleSheet \"C:\\Users\\Mallikandan E\\Documents\\testdatavlook.xlsx\" \"C:\\Users\\Mallikandan E\\Documents\\multid.xlsx\""
 * ); return; } try { applyVLookup(args[0], args[1]); } catch (IOException e) {
 * System.err.println("An error occurred: " + e.getMessage());
 * e.printStackTrace(); } } }
 * 
 * /* public static void applyVLookup(String sourceFilePath, String
 * targetFilePath) throws IOException { File sourceFile = new
 * File(sourceFilePath); File targetFile = new File(targetFilePath);
 * 
 * if (!sourceFile.exists()) { System.err.println("Source file does not exist: "
 * + sourceFilePath); return; } if (!targetFile.exists()) {
 * System.err.println("Target file does not exist: " + targetFilePath); return;
 * }
 * 
 * try (FileInputStream sourceFis = new FileInputStream(sourceFile); Workbook
 * sourceWorkbook = new XSSFWorkbook(sourceFis); FileInputStream targetFis = new
 * FileInputStream(targetFile); Workbook targetWorkbook = new
 * XSSFWorkbook(targetFis)) {
 * 
 * Sheet sourceSheet = sourceWorkbook.getSheetAt(0); // Source sheet Sheet
 * targetSheet = targetWorkbook.getSheetAt(0); // Target sheet
 * 
 * if (sourceSheet == null || targetSheet == null) {
 * System.err.println("Source or Target sheet does not exist."); return; }
 * 
 * // Get source sheet name String sourceSheetName = sourceSheet.getSheetName();
 * 
 * // Iterate over rows of the target sheet for (Row row : targetSheet) { //
 * Skip header row if (row.getRowNum() == 0) continue;
 * 
 * Cell keyCell = row.getCell(0); // Key column
 * 
 * if (keyCell != null) { Cell formulaCell = row.getCell(1); // Formula column
 * 
 * if (formulaCell == null) { formulaCell = row.createCell(1); // Create if it
 * does not exist }
 * 
 * // Construct the VLOOKUP formula with proper referencing String formula =
 * String.format("VLOOKUP(A%d, '[%s]Sheet1'!$A:$K, 8, FALSE)", row.getRowNum() +
 * 1, new File(sourceFilePath).getName()); formulaCell.setCellFormula(formula);
 * } }
 * 
 * // Save the updated target workbook String updatedFilePath =
 * Paths.get(targetFile.getParent(), "updated_" +
 * targetFile.getName()).toString(); try (FileOutputStream fos = new
 * FileOutputStream(updatedFilePath)) { targetWorkbook.write(fos); }
 * 
 * System.out.println("VLOOKUP applied and file saved as: " + updatedFilePath);
 * } }
 * 
 * public static void main(String[] args) { if (args.length != 2) { System.err.
 * println("Usage: java VlookupMultipleSheet \"C:\\Users\\Mallikandan E\\Documents\\testdatavlook.xlsx\" \"C:\\Users\\Mallikandan E\\Documents\\multid.xlsx\""
 * ); return; } try { applyVLookup(args[0], args[1]); } catch (IOException e) {
 * e.printStackTrace(); } } }
 * 
 * 
 * /*
 * 
 * public static void applyVLookup(String sourceFilePath, String targetFilePath)
 * throws IOException { File sourceFile = new File(sourceFilePath); File
 * targetFile = new File(targetFilePath);
 * 
 * if (!sourceFile.exists()) { System.err.println("Source file does not exist: "
 * + sourceFilePath); return; } if (!targetFile.exists()) {
 * System.err.println("Target file does not exist: " + targetFilePath); return;
 * }
 * 
 * try (FileInputStream sourceFis = new FileInputStream(sourceFile); Workbook
 * sourceWorkbook = new XSSFWorkbook(sourceFis); FileInputStream targetFis = new
 * FileInputStream(targetFile); Workbook targetWorkbook = new
 * XSSFWorkbook(targetFis)) {
 * 
 * Sheet sourceSheet = sourceWorkbook.getSheetAt(0); // Source sheet Sheet
 * targetSheet = targetWorkbook.getSheetAt(0); // Target sheet
 * 
 * if (sourceSheet == null || targetSheet == null) {
 * System.err.println("Source or Target sheet does not exist."); return; }
 * 
 * // Construct the VLOOKUP formula reference based on the source workbook
 * String sourceSheetName = sourceSheet.getSheetName(); String formulaBase =
 * String.format("VLOOKUP(A:A,[testdatavlook.xlsx]Sheet1!$A:$K,8,0)", 2,
 * sourceFile.getName());
 * 
 * // Iterate over rows of the target sheet for (Row row : targetSheet) { //
 * Start from row 1 if row 0 contains headers if (row.getRowNum() == 0)
 * continue;
 * 
 * Cell keyCell = row.getCell(0); // Key column
 * 
 * if (keyCell != null) { Cell formulaCell = row.getCell(1); // Formula column
 * 
 * if (formulaCell == null) { formulaCell = row.createCell(1); // Create if it
 * does not exist }
 * 
 * // Set the VLOOKUP formula String formula = formulaBase.replaceFirst("A2",
 * "A" + (row.getRowNum() + 1)); formulaCell.setCellFormula(formula); } }
 * 
 * String updatedFilePath = Paths.get(targetFile.getParent(), "updated_" +
 * targetFile.getName()).toString();
 * 
 * try (FileOutputStream fos = new FileOutputStream(updatedFilePath)) {
 * targetWorkbook.write(fos); }
 * 
 * System.out.println("VLOOKUP applied and file saved as: " + updatedFilePath);
 * } }
 * 
 * public static void main(String[] args) { if (args.length != 2) { System.err.
 * println("java VlookupMultipleSheet \"C:\\Users\\Mallikandan E\\Documents\\testdatavlook.xlsx\" \"C:\\Users\\Mallikandan E\\Documents\\multid.xlsx\""
 * ); return; } try { applyVLookup(args[0], args[1]); } catch (IOException e) {
 * e.printStackTrace(); } } }
 * 
 * /* public static void applyVLookup(String sourceFilePath, String
 * targetFilePath) throws IOException { File sourceFile = new
 * File(sourceFilePath); File targetFile = new File(targetFilePath);
 * 
 * if (!sourceFile.exists()) { System.err.println("Source file does not exist: "
 * + sourceFilePath); return; } if (!targetFile.exists()) {
 * System.err.println("Target file does not exist: " + targetFilePath); return;
 * }
 * 
 * try (FileInputStream sourceFis = new FileInputStream(sourceFile); Workbook
 * sourceWorkbook = new XSSFWorkbook(sourceFis); FileInputStream targetFis = new
 * FileInputStream(targetFile); Workbook targetWorkbook = new
 * XSSFWorkbook(targetFis)) {
 * 
 * Sheet sourceSheet = sourceWorkbook.getSheetAt(0); // Source sheet Sheet
 * targetSheet = targetWorkbook.getSheetAt(0); // Target sheet
 * 
 * if (sourceSheet == null || targetSheet == null) {
 * System.err.println("Source or Target sheet does not exist."); return; }
 * 
 * // Iterate over rows of the target sheet for (Row row : targetSheet) { //
 * Start from row 1 if row 0 contains headers if (row.getRowNum() == 0)
 * continue;
 * 
 * Cell keyCell = row.getCell(0); // Key column
 * 
 * if (keyCell != null) { Cell formulaCell = row.getCell(1); // Formula column
 * 
 * if (formulaCell == null) { formulaCell = row.createCell(1); // Create if it
 * does not exist }
 * 
 * // Construct VLOOKUP formula String formula =
 * String.format("VLOOKUP(A:A,[testdatavlook.xlsx]Sheet1!$A:$K,3,0)",
 * row.getRowNum() + 1, sourceFile.getName());
 * formulaCell.setCellFormula(formula); } }
 * 
 * String updatedFilePath = Paths.get(targetFile.getParent(), "updated_" +
 * targetFile.getName()).toString();
 * 
 * try (FileOutputStream fos = new FileOutputStream(updatedFilePath)) {
 * targetWorkbook.write(fos); }
 * 
 * System.out.println("VLOOKUP applied and file saved as: " + updatedFilePath);
 * } }
 * 
 * public static void main(String[] args) { if (args.length != 2) { System.err.
 * println("Usage: java VlookupMultipleSheet \"C:\\Users\\Mallikandan E\\Documents\\multiplevlookup.xlsx\" \"C:\\Users\\Mallikandan E\\Document\\multid.xlsx\\"
 * ); return; } try { applyVLookup(args[0], args[1]); } catch (IOException e) {
 * e.printStackTrace(); } } }
 * 
 * 
 * /*
 * 
 * public static void applyVLookup(String sourceFilePath, String targetFilePath)
 * throws IOException { File sourceFile = new File(sourceFilePath); File
 * targetFile = new File(targetFilePath);
 * 
 * if (!sourceFile.exists()) { System.err.println("Source file does not exist: "
 * + sourceFilePath); return; } if (!targetFile.exists()) {
 * System.err.println("Target file does not exist: " + targetFilePath); return;
 * }
 * 
 * try (FileInputStream sourceFis = new FileInputStream(sourceFile); Workbook
 * sourceWorkbook = new XSSFWorkbook(sourceFis); FileInputStream targetFis = new
 * FileInputStream(targetFile); Workbook targetWorkbook = new
 * XSSFWorkbook(targetFis)) {
 * 
 * Sheet sourceSheet = sourceWorkbook.getSheetAt(0); // Source sheet Sheet
 * targetSheet = targetWorkbook.getSheetAt(0); // Target sheet
 * 
 * if (sourceSheet == null || targetSheet == null) {
 * System.err.println("Source or Target sheet does not exist."); return; }
 * 
 * for (Row row : targetSheet) { Cell keyCell = row.getCell(0); // Key column
 * 
 * if (keyCell != null) { Cell formulaCell = row.createCell(1); // Formula
 * column
 * 
 * // Correct VLOOKUP formula construction String formula =
 * String.format("VLOOKUP(A:A,[testdatavlook.xlsx]Sheet1!$A:$K,3,0)",
 * row.getRowNum() + 1, sourceFile.getName());
 * formulaCell.setCellFormula(formula); } }
 * 
 * String updatedFilePath = Paths.get(targetFile.getParent(), "updated_" +
 * targetFile.getName()).toString();
 * 
 * try (FileOutputStream fos = new FileOutputStream(updatedFilePath)) {
 * targetWorkbook.write(fos); }
 * 
 * System.out.println("VLOOKUP applied and file saved as: " + updatedFilePath);
 * } }
 * 
 * public static void main(String[] args) { if (args.length != 2) { //
 * System.err.
 * println("Usage: java VlookupMultipleSheet <sourceFilePath> <targetFilePath>"
 * ); System.err.
 * println("Usage: java VlookupMultipleSheet \"C:\\Users\\Mallikandan E\\Documents\\testdatavlook.xlsx\" \"C:\\Users\\Mallikandan E\\Documents\\multiplevlookup.xlsx\""
 * ); return; } try { applyVLookup(args[0], args[1]); } catch (IOException e) {
 * e.printStackTrace(); } } } /* public static void applyVLookup(String
 * sourceFilePath, String targetFilePath) throws IOException { File sourceFile =
 * new File(sourceFilePath); File targetFile = new File(targetFilePath);
 * 
 * if (!sourceFile.exists()) { System.err.println("Source file does not exist: "
 * + sourceFilePath); return; } if (!targetFile.exists()) {
 * System.err.println("Target file does not exist: " + targetFilePath); return;
 * }
 * 
 * try (FileInputStream sourceFis = new FileInputStream(sourceFile); Workbook
 * sourceWorkbook = new XSSFWorkbook(sourceFis); FileInputStream targetFis = new
 * FileInputStream(targetFile); Workbook targetWorkbook = new
 * XSSFWorkbook(targetFis)) {
 * 
 * Sheet sourceSheet = sourceWorkbook.getSheetAt(0); // Source sheet Sheet
 * targetSheet = targetWorkbook.getSheetAt(0); // Target sheet
 * 
 * if (sourceSheet == null || targetSheet == null) {
 * System.err.println("Source or Target sheet does not exist."); return; }
 * 
 * for (Row row : targetSheet) { Cell keyCell = row.getCell(0); // Key column
 * 
 * if (keyCell != null) { Cell formulaCell = row.createCell(1); // Formula
 * column
 * 
 * // Correct VLOOKUP formula construction String formula =
 * String.format("VLOOKUP(A:A,[testdatavlook.xlsx]Sheet1!$A:$K,3,0)",
 * row.getRowNum() + 1, sourceFile.getName());
 * formulaCell.setCellFormula(formula); } }
 * 
 * String updatedFilePath = Paths.get(targetFile.getParent(), "updated_" +
 * targetFile.getName()).toString();
 * 
 * try (FileOutputStream fos = new FileOutputStream(updatedFilePath)) {
 * targetWorkbook.write(fos); }
 * 
 * System.out.println("VLOOKUP applied and file saved as: " + updatedFilePath);
 * } }
 * 
 * public static void main(String[] args) { if (args.length != 2) {
 * System.err.println(
 * "Usage: VlookupMultipleSheet <C:\\Users\\Mallikandan E\\Documents\\testdatavlook.xlsx> <C:\\Users\\Mallikandan E\\Documents\\multiplevlookup.xlsx>"
 * ); return; } try { applyVLookup(args[0], args[1]); } catch (IOException e) {
 * e.printStackTrace(); } } }
 * 
 * /* public static void applyVLookup(String sourceFilePath, String
 * targetFilePath) throws IOException { File sourceFile = new
 * File(sourceFilePath); File targetFile = new File(targetFilePath);
 * 
 * if (!sourceFile.exists()) { System.err.println("Source file does not exist: "
 * + sourceFilePath); return; } if (!targetFile.exists()) {
 * System.err.println("Target file does not exist: " + targetFilePath); return;
 * }
 * 
 * try (FileInputStream sourceFis = new FileInputStream(sourceFile); Workbook
 * sourceWorkbook = new XSSFWorkbook(sourceFis); FileInputStream targetFis = new
 * FileInputStream(targetFile); Workbook targetWorkbook = new
 * XSSFWorkbook(targetFis)) {
 * 
 * Sheet sourceSheet = sourceWorkbook.getSheetAt(0); // Source sheet Sheet
 * targetSheet = targetWorkbook.getSheetAt(0); // Target sheet
 * 
 * if (sourceSheet == null || targetSheet == null) {
 * System.err.println("Source or Target sheet does not exist."); return; }
 * 
 * for (Row row : targetSheet) { Cell keyCell = row.getCell(0); // Key column
 * 
 * if (keyCell != null) { Cell formulaCell = row.createCell(1); // Formula
 * column
 * 
 * // Build the VLOOKUP formula String formula =
 * String.format("VLOOKUP(A:A,[testdatavlook.xlsx]Sheet1!$A:$K,3,0)",
 * row.getRowNum() + 1, sourceFile.getName());
 * formulaCell.setCellFormula(formula); } }
 * 
 * String updatedFilePath = Paths.get(targetFile.getParent(), "updated_" +
 * targetFile.getName()).toString();
 * 
 * try (FileOutputStream fos = new FileOutputStream(updatedFilePath)) {
 * targetWorkbook.write(fos); }
 * 
 * System.out.println("VLOOKUP applied and file saved as: " + updatedFilePath);
 * } }
 * 
 * public static void main(String[] args) { if (args.length != 2) { System.err.
 * println("Usage: VlookupMultipleSheet <C:\\Users\\Mallikandan E\\Documents\\testdatavlook.xlsx> <C:\\Users\\Mallikandan E\\Documents\\multiplevlookup.xlsx>"
 * ); return; } try { applyVLookup(args[0], args[1]); } catch (IOException e) {
 * e.printStackTrace(); } } } /* public static void applyVLookup(String
 * sourceFilePath, String targetFilePath) throws IOException { File sourceFile =
 * new File(sourceFilePath); File targetFile = new File(targetFilePath);
 * 
 * if (!sourceFile.exists()) { System.err.println("Source file does not exist: "
 * + sourceFilePath); return; } if (!targetFile.exists()) {
 * System.err.println("Target file does not exist: " + targetFilePath); return;
 * }
 * 
 * try (FileInputStream sourceFis = new FileInputStream(sourceFile); Workbook
 * sourceWorkbook = new XSSFWorkbook(sourceFis); FileInputStream targetFis = new
 * FileInputStream(targetFile); Workbook targetWorkbook = new
 * XSSFWorkbook(targetFis)) {
 * 
 * Sheet sourceSheet = sourceWorkbook.getSheetAt(0); // Source sheet Sheet
 * targetSheet = targetWorkbook.getSheetAt(0); // Target sheet
 * 
 * if (sourceSheet == null || targetSheet == null) {
 * System.err.println("Source or Target sheet does not exist."); return; }
 * 
 * for (Row row : targetSheet) { Cell keyCell = row.getCell(0); // Key column
 * 
 * if (keyCell != null) { Cell formulaCell = row.createCell(1); // Formula
 * column
 * 
 * // Build the VLOOKUP formula String formula =
 * String.format("VLOOKUP(A:A,[testdatavlook.xlsx]Sheet1!$A:$K,3,0)",
 * row.getRowNum() + 1, sourceFile.getName());
 * formulaCell.setCellFormula(formula); } }
 * 
 * String updatedFilePath = Paths.get(targetFile.getParent(), "updated_" +
 * targetFile.getName()).toString();
 * 
 * try (FileOutputStream fos = new FileOutputStream(updatedFilePath)) {
 * targetWorkbook.write(fos); }
 * 
 * System.out.println("VLOOKUP applied and file saved as: " + updatedFilePath);
 * } }
 * 
 * public static void main(String[] args) { try {
 * applyVLookup("C:\\Users\\Mallikandan E\\Documents\\testdatavlook.xlsx",
 * "C:\\Users\\Mallikandan E\\Documents\\multiplevlookup.xlsx"); } catch
 * (IOException e) { e.printStackTrace(); } } }
 * 
 * 
 * /* // Method to apply VLOOKUP from source to target workbook public static
 * void applyVLookup(String sourceFilePath, String targetFilePath) throws
 * IOException { File sourceFile = new File(sourceFilePath); File targetFile =
 * new File(targetFilePath);
 * 
 * // Check if files exist if (!sourceFile.exists()) {
 * System.err.println("Source file does not exist: " + sourceFilePath); return;
 * } if (!targetFile.exists()) {
 * System.err.println("Target file does not exist: " + targetFilePath); return;
 * }
 * 
 * try (FileInputStream sourceFis = new FileInputStream(sourceFilePath);
 * Workbook sourceWorkbook = new XSSFWorkbook(sourceFis); FileInputStream
 * targetFis = new FileInputStream(targetFilePath); Workbook targetWorkbook =
 * new XSSFWorkbook(targetFis)) {
 * 
 * // Access the source and target sheets Sheet sourceSheet =
 * sourceWorkbook.getSheetAt(0); // Assuming data is in the first sheet Sheet
 * targetSheet = targetWorkbook.getSheetAt(0); // Assuming data is in the first
 * sheet
 * 
 * if (sourceSheet == null || targetSheet == null) {
 * System.err.println("Source or Target sheet does not exist."); return; }
 * 
 * // Loop through rows in the target sheet and apply VLOOKUP formula for (Row
 * row : targetSheet) { Cell keyCell = row.getCell(0); // Assuming key column is
 * the first column
 * 
 * if (keyCell != null) { Cell formulaCell = row.createCell(1); // Formula
 * column
 * 
 * // Build VLOOKUP formula String formula =
 * String.format("VLOOKUP(A:A,[testdatavlook.xlsx]Sheet1!$A:$K,3,0)",
 * row.getRowNum() + 1, sourceFile.getName());
 * formulaCell.setCellFormula(formula); } }
 * 
 * // Generate the updated file path String updatedFilePath =
 * Paths.get(targetFile.getParent(), "updated_" +
 * targetFile.getName()).toString();
 * 
 * // Write changes to the new file try (FileOutputStream fos = new
 * FileOutputStream(updatedFilePath)) { targetWorkbook.write(fos); }
 * 
 * System.out.println("VLOOKUP applied and file saved as: " + updatedFilePath);
 * } }
 * 
 * public static void main(String[] args) { try { // Update paths to your actual
 * file locations //first one source & second target
 * applyVLookup("C:\\\\Users\\\\Mallikandan E\\\\Documents\\\\testdatavlook.xlsx"
 * , "C:\\\\Users\\\\Mallikandan E\\\\Documents\\\\multiplevlookup.xlsx"); }
 * catch (IOException e) { e.printStackTrace(); } }
 */
