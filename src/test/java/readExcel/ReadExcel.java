package readExcel;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;

public class ReadExcel {
    @Test
    public void readExcel() throws Exception {
        String excelPath = "/home/amali/Documents/msc/PrivacyAnalyzer-Alexa/testData/Testcases.xlsx";
        String fileName = "Testcases";
        String sheetName = "testcases";

        //create the object of file class to get the file path
        File file = new File(excelPath);
        //to read the file
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(fis);

        XSSFSheet sheet = wb.getSheet(sheetName);
        int totalRowCount = sheet.getLastRowNum();
        System.out.println("total rows: "+totalRowCount);
        String data = sheet.getRow(1).getCell(1).getStringCellValue();
        System.out.println(data);
        for (int i = 0; i <= totalRowCount; i++) {
            XSSFRow row = sheet.getRow(i);
            for (int j = 0; j < row.getLastCellNum(); j++) {
                String data1 = sheet.getRow(i).getCell(j).getStringCellValue();
                System.out.print(data1+ " | ");
            }
            System.out.println();
        }
        wb.close();
    }
}
