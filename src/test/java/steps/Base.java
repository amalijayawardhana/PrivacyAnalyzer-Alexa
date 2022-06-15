package steps;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    public static WebDriver dr = null;

    public void scrollUp() {
        JavascriptExecutor js = (JavascriptExecutor) dr;
        js.executeScript("scroll(0, -250);");
    }

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) dr;
        js.executeScript("scroll(0, 250);");
    }

    public static String getProperty(String key) throws IOException, FileNotFoundException {
        String propertyFilePath = "src/main/resources/properties/Properities.properties";
        FileInputStream fis = new FileInputStream(propertyFilePath);
        Properties prop = new Properties();
        prop.load(fis);
        return prop.getProperty(key);
    }

    public void clearText(By XPath) throws InterruptedException {
        Thread.sleep(3000);
        dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement toClear = dr.findElement(XPath);
        toClear.sendKeys("test");
        toClear.sendKeys(Keys.CONTROL + "a");
        toClear.sendKeys(Keys.DELETE);
    }

    public void errorAssert(By xpath, String assertVal) throws InterruptedException {
        Thread.sleep(3000);
        String msg = dr.findElement(xpath).getText();
        Assert.assertEquals(assertVal, msg);
    }

    public void errorMsgAssert(By xpath, String assertVal) throws InterruptedException {
        Thread.sleep(3000);
        String msg = dr.findElement(xpath).getText();
        Assert.assertEquals(assertVal, msg);
    }


    public static void input(ArrayList<ArrayList<String>> data, String name) throws IOException {

        ArrayList<ArrayList<XSSFCell>> cells = new ArrayList<>();

//        File myFile = new File(Direct + "/Data/" + name + ".xlsx");
        File myFile = new File("/home/amali/Documents/msc/PrivacyAnalyzer-Alexa/testData/input/" + name + ".xlsx");
        FileInputStream fis = null;

        fis = new FileInputStream(myFile);

        XSSFWorkbook wb = null;

        wb = new XSSFWorkbook(fis);


        XSSFSheet sheet = wb.getSheetAt(0);

        XSSFRow row;
        XSSFCell cell = null;

        int rows; // No of rows
        rows = sheet.getPhysicalNumberOfRows();

        int cols = 0; // No of columns
        int tmp = 0;

        // This trick ensures that question get the data properly even if it doesn't start from first few rows
        for (int i = 0; i < 10 || i < rows; i++) {
            row = sheet.getRow(i);
            if (row != null) {
                tmp = sheet.getRow(i).getPhysicalNumberOfCells();
                if (tmp > cols) {
                    cols = tmp;
                }
            }
        }
        for (int n = 0; n < cols; n++) {
            cells.add(new ArrayList<XSSFCell>()); //fills arraylists for number of columns
            data.add(new ArrayList<String>());
        }

        for (int r = 0; r < rows * 2; r++) { //*2 to fix halfing problem
            row = sheet.getRow(r);
            if (row != null) {
                for (int c = 0; c < cols; c++) {
                    cell = row.getCell((short) c);
                    if (cell != null) {
                        cells.get(c % cols).add(cell);
                    }
                }
            }
        }

        for (int i = 0; i < cells.size(); i++) {
            for (int j = 0; j < cells.get(i).size(); j++) { //adjust to isolate years
                cells.get(i).get(j).setCellType(CellType.STRING); //convert cell to numeric
                data.get(i).add(cells.get(i).get(j).getStringCellValue()); //convert cell to double and add to arraylist
            }
        }
        //-------------------input data end-------------------------------------
    }


}
