package readExcel;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.HashMap;

public class ExcelDataConfig {

    XSSFWorkbook wb;
    XSSFSheet sheet1;
    private XSSFCell cell;

    private int testIdColumn;
    private int numberOfColumns;
    public HashMap<String, String> responseValues;

    //Constructor
    public ExcelDataConfig(String excelpath) {

        try {
            File file=new File(excelpath);
            FileInputStream fis=new FileInputStream(file);
            wb=new XSSFWorkbook(fis);
        }
        catch (Exception e) {

            System.out.println(e.getMessage());

        }

    }

//    public String getData(int sheetNumber,int row,int column) {
//        sheet1=wb.getSheetAt(sheetNumber);
//        String data=sheet1.getRow(row).getCell(column).getStringCellValue();
//
//        return data;
//    }

    public String getData(String sheetName) {
//        sheet1=wb.getSheetAt(sheetName);
        sheet1 = wb.getSheet(sheetName);


        /* Get number of rows */
        int lastRow = sheet1.getLastRowNum();
//            System.out.println(lastRow);
        int firstRow = sheet1.getFirstRowNum();
//            System.out.println(firstRow);
        int numberOfRows = lastRow - firstRow;
//            System.out.println(numberOfRows);
                String data1 = "";
        String fieldName="";
        String  fieldValue="";
        for (int i = 1; i <= numberOfRows; i++) {
            XSSFRow row = sheet1.getRow(i);
            for (int j = 0; j < row.getLastCellNum(); j++) {
                 fieldName = sheet1.getRow(i).getCell(j).getStringCellValue();
                fieldValue = sheet1.getRow(i).getCell(j).getStringCellValue();
               data1 = sheet1.getRow(i).getCell(j).getStringCellValue();
//                System.out.print(data1+ ",");
//                System.out.print(fieldName+ ",");
//                responseValues.put(fieldName, fieldValue);

                System.out.print(data1);
            }
//            System.out.print(fieldName+", "+fieldValue);
//            System.out.print(fieldValue);
            System.out.println();
        }

        return data1;
    }

    public int getRowCount(int sheetIndex)
    {
        int row=wb.getSheetAt(sheetIndex).getLastRowNum();
        row=row+1;
        return row;

    }
}
