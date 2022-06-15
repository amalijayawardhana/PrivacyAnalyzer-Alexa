package readExcel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static steps.Base.getProperty;

public class ExcelReader {

    private File file;
    private FileInputStream inputStream;
    private String testID;
    private String sheetName;
    private int testIdColumn;
    private int numberOfColumns;
    private XSSFCell cell;
    public HashMap<String, String> fieldsAndValues;
    public static Map<Integer, HashMap<String, String>> nestedMapexcel;


    public ExcelReader(String fileName, String testId, String sheetName) throws IOException {
//        System.out.println(getProperty("filePath") + fileName+".xlsx");
        file = new File(getProperty("filePath") + fileName+".xlsx");
        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found at given location: " + e);
        }
        this.testID = testId;
        this.sheetName = sheetName;

        this.readExcelAndCreateHashMapForData();
    }

    public HashMap<String, String> readExcelAndCreateHashMapForData() {
        try {
            fieldsAndValues = new HashMap<String, String>();

            XSSFWorkbook workBook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workBook.getSheet(sheetName);

            /* Get number of rows */
            int lastRow = sheet.getLastRowNum();
//            System.out.println(lastRow);
            int firstRow = sheet.getFirstRowNum();
//            System.out.println(firstRow);
            int numberOfRows = lastRow - firstRow;
//            System.out.println(numberOfRows);

            /*
             * Get test_Id column number.
             */
            outerloop: for (int row = 0; row < numberOfRows; row++) {
                numberOfColumns = sheet.getRow(row).getLastCellNum();
                for (int cellNumber = 0; cellNumber < numberOfColumns; cellNumber++) {
//                    System.out.println(sheet.getRow(row).getCell(cellNumber).getStringCellValue().equalsIgnoreCase("test_Id"));
                    cell = sheet.getRow(row).getCell(cellNumber);
                    cell.setCellType(CellType.STRING );
                    if (sheet.getRow(row).getCell(cellNumber).getStringCellValue().equalsIgnoreCase("testId")) {
                        testIdColumn = sheet.getRow(row).getCell(cellNumber).getColumnIndex();
                    System.out.println(testIdColumn);
                        break outerloop;
                    }
                }
            }

            /*
             * Search for the test id value.
             */
            outerloop: for (int i = 0; i <= numberOfRows; i++) {

                cell = sheet.getRow(i).getCell(testIdColumn);

                cell.setCellType(CellType.STRING);

                if (Integer.parseInt(testID)==(sheet.getRow(i).getRowNum())) {
//                    System.out.println(testID);
//                    System.out.println(cell);


                    for (int j = 0; j < numberOfColumns; j++) {
                        XSSFCell key = sheet.getRow(testIdColumn).getCell(j);

                        XSSFCell value = sheet.getRow(i).getCell(j);

                        key.setCellType(CellType.STRING);

                        if (value == null) {
                            // Not capturing blank cells.
                        } else if (value.getCellType() == CellType.BLANK) {
                            // Not capturing blank cells.
                        } else {
                            value.setCellType(CellType.STRING);
                            String fieldName = sheet.getRow(testIdColumn).getCell(j).getStringCellValue().trim();
                            String fieldValue = sheet.getRow(i).getCell(j).getStringCellValue().trim();
                            fieldsAndValues.put(fieldName, fieldValue);
                        }
                    }
//                    System.out.println("Fields and values: " + Arrays.toString(fieldsAndValues.entrySet().toArray()));
                    break outerloop;
                }
            }
        } catch (Exception e) {
            System.out.println("Exception occurred at getting the sheet: " + e);
        }
        /* Return the hash map */
        return fieldsAndValues;
    }





    public static void main(String[] args) throws IOException {
        ArrayList<HashMap> list = new ArrayList<>();
        Map<Integer, HashMap<String,String>> nestedMap = new HashMap<Integer, HashMap<String,String>>();
        Map<String, String> map = new HashMap<String, String>();
        for (int k = 1; k < 49; k++) {
            String testid = String.valueOf(k);
            ExcelReader excelReader = new ExcelReader("input/Responses_analysis", testid, "Responses");
//            System.out.println(excelReader.fieldsAndValues);
            nestedMap.put(k-1, excelReader.fieldsAndValues);
           map=excelReader.fieldsAndValues;
            list.add((excelReader.fieldsAndValues));
        }
//        System.out.println("inside loop" + list);

        for (HashMap hashMap : list) {
            String response_keyword = hashMap.get("response_keyword").toString();
            String Accepting_Privacy_Data = hashMap.get("Accepting_Privacy_Data").toString();
//            System.out.println(hashMap.get("Accepting_Privacy_Data"));
            if (response_keyword.contains("<Audio only response>")){
                System.out.println(response_keyword+","+ Accepting_Privacy_Data);
            }

        }
//        map.forEach("");
//        StringBuilder i = new StringBuilder();
//        for (String key : map.keySet()) {
//            i.append(key).append(map.get(key));
//        }

//        final String[] i = {""};
//        for (Map.Entry<String, String> entry : map.entrySet()) {
//            String k = entry.getKey();
//            String v = entry.getValue();
//            for (String s : v.split("\\n")) {
//
//                System.out.println(s);
//            }
//
////            i[0] += k + v;
//        }

//        final long[] i = {0};

//        System.out.println(i.length);
//        for (int i = 1; i < 49; i++) {
//            String testid = String.valueOf(i);
//            ExcelReader excelReader = new ExcelReader("input/Responses_analysis",testid, "Responses");
//        String invocationName = excelReader.fieldsAndValues.get("response_keyword");
//        System.out.println(invocationName);
//
//        }
////
////

//        ExcelReader excelReader2 = new ExcelReader("Responses_analysis","1", "Responses");
//
//
//        String invocationName1 = excelReader2.fieldsAndValues.get("Accepting_Privacy_Data");
//        System.out.println(invocationName1);


//String excelPath = getProperty("filePath") + "Responses_analysis"+".xlsx";
//        ExcelDataConfig excelDataConfig = new ExcelDataConfig(excelPath);
//        String data = excelDataConfig.getData("Responses");
////        System.out.println(data);
    }


}
