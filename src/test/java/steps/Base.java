package steps;

import org.junit.Assert;
import org.openqa.selenium.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
}
