package readExcel;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;

public class ExcelLibrary {
    XSSFWorkbook wb;
    XSSFSheet sheet;


    public ExcelLibrary() throws Exception {
        String excelPath = "/home/amali/Documents/msc/PrivacyAnalyzer-Alexa/testData/Testcases.xlsx";

        File file = new File(excelPath);
        FileInputStream fis = new FileInputStream(file);
        wb = new XSSFWorkbook(fis);

    }
    @Test
    public String readData(String sheetName, int row, int col){
        sheet = wb.getSheet(sheetName);
        String data = sheet.getRow(row).getCell(col).getStringCellValue();
        return data;
    }
}
