package readExcel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class WriteExcel {
    @SuppressWarnings("null")
    public void writeExcel(String sheetName, String cellValue, int rowNumber, int colNumber) throws Exception {
        String excelPath = "/home/amali/Documents/msc/PrivacyAnalyzer-Alexa/testData/Testcases.xlsx";
        File file = new File(excelPath);
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(fis);

        XSSFSheet sheet = wb.getSheet(sheetName);
        XSSFRow row = sheet.getRow(rowNumber);
        row.createCell(colNumber);
//        XSSFCell cell = row.getCell(colNumber);
        XSSFCell cell = row.getCell(colNumber, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
        if (cell == null) {
            row.createCell(colNumber);
            cell.setCellValue(cellValue);
        } else {
            cell.setCellValue(cellValue);
        }

        FileOutputStream fos = new FileOutputStream(new File(excelPath));
        wb.write(fos);

        wb.close();
        fos.close();
        System.out.println("Excel write success");
    }

    private static void createSheet(String add, Row row) throws Exception {
        XSSFWorkbook book = new XSSFWorkbook();
        XSSFSheet sheet = book.createSheet("newsheet");
        int rowno = 0;


        FileOutputStream out = new FileOutputStream(new File("/home/amali/Documents/msc/PrivacyAnalyzer-Alexa/testData/aaa.xlsx")); // file name with path
        book.write(out);
        out.close();
    }

    private static void createlist(String add, Row row) {
        Cell cell = row.createCell(0);
        cell.setCellValue(add);
    }


}
