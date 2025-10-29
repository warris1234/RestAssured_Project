package DataDrivenWithExcelTest;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class XLUtils {

    private static FileInputStream fi;
    private static FileOutputStream fo;
    private static Workbook wb;
    private static Sheet ws;
    private static Row row;
    private static Cell cell;

    // ✅ Get row count
    public static int getRowCount(String xlfile, String xlsheet) throws IOException {
        try (FileInputStream fis = new FileInputStream(xlfile);
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheet(xlsheet);
            return sheet.getLastRowNum();
        }
    }

    // ✅ Get cell data
    public static String getCellData(String xlfile, String xlsheet, int rownum, int colnum) throws IOException {
        try (FileInputStream fis = new FileInputStream(xlfile);
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheet(xlsheet);
            Row row = sheet.getRow(rownum);
            if (row == null) return "";
            Cell cell = row.getCell(colnum);
            if (cell == null) return "";
            DataFormatter df = new DataFormatter();
            return df.formatCellValue(cell);
        }
    }

    // ✅ Write cell data safely
    public static void setCellData(String xlfile, String xlsheet, int rownum, int colnum, String data) throws IOException {
        FileInputStream fis = new FileInputStream(xlfile);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet(xlsheet);

        Row row = sheet.getRow(rownum);
        if (row == null)
            row = sheet.createRow(rownum);

        Cell cell = row.getCell(colnum);
        if (cell == null)
            cell = row.createCell(colnum);

        cell.setCellValue(data);

        fis.close(); // important to close input before writing

        try (FileOutputStream fos = new FileOutputStream(xlfile)) {
            workbook.write(fos);
        }

        workbook.close();
    }

    // ✅ Get all data (for DataProvider)
    public static Object[][] getExcelData(String path, String sheetName) throws IOException {
        fi = new FileInputStream(path);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(sheetName);

        int rowCount = ws.getLastRowNum();
        int colCount = ws.getRow(0).getLastCellNum();

        Object[][] data = new Object[rowCount][colCount];

        for (int i = 1; i <= rowCount; i++) {
            row = ws.getRow(i);
            for (int j = 0; j < colCount; j++) {
                cell = row.getCell(j);
                DataFormatter formatter = new DataFormatter();
                data[i - 1][j] = formatter.formatCellValue(cell);
            }
        }

        wb.close();
        fi.close();
        return data;
    }

    // ✅ Delete a row by Employee ID
    public static boolean deleteRowByEmployeeID(String path, String sheetName, String empID) throws IOException {
        fi = new FileInputStream(path);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(sheetName);

        boolean deleted = false;
        int lastRow = ws.getLastRowNum();

        for (int i = 1; i <= lastRow; i++) {
            row = ws.getRow(i);
            if (row != null) {
                Cell idCell = row.getCell(3); // Assuming ID is 4th column
                DataFormatter df = new DataFormatter();
                String currentID = df.formatCellValue(idCell);

                if (currentID.equals(empID)) {
                    int nextRowNum = i + 1;
                    if (nextRowNum <= lastRow) {
                        ws.shiftRows(nextRowNum, lastRow, -1);
                    } else {
                        ws.removeRow(row);
                    }
                    deleted = true;
                    break;
                }
            }
        }

        fi.close();
        fo = new FileOutputStream(path);
        wb.write(fo);
        fo.close();
        wb.close();

        return deleted;
    }

    // ✅ Print all data (debug)
    public static void printSheet(String path, String sheetName) throws IOException {
        fi = new FileInputStream(path);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(sheetName);

        int totalRows = ws.getLastRowNum();
        int totalCols = ws.getRow(0).getLastCellNum();

        System.out.println("\n=== Excel Sheet Data ===");
        for (int i = 0; i <= totalRows; i++) {
            row = ws.getRow(i);
            for (int j = 0; j < totalCols; j++) {
                cell = row.getCell(j);
                DataFormatter df = new DataFormatter();
                System.out.print(df.formatCellValue(cell) + "\t");
            }
            System.out.println();
        }
        System.out.println("=========================");

        wb.close();
        fi.close();
    }
    // ✅ Get column count of a specific row
    public static int getCellCount(String xlfile, String xlsheet, int rownum) throws IOException {
        try (FileInputStream fis = new FileInputStream(xlfile);
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheet(xlsheet);
            Row row = sheet.getRow(rownum);
            if (row == null)
                return 0;
            else
                return row.getLastCellNum();
        }
    }

}
