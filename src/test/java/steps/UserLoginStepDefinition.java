package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import readExcel.WriteExcel;

import java.io.*;
import java.util.List;
import java.util.ListIterator;

public class UserLoginStepDefinition extends Base {
    private String actualResponseMessage1 = "";
    private String actualResponseMessage = "";
    //        private final By RESPONSE_MESSAGE = By.xpath("//div[@id='astro-tabs-1-panel-0']/div[2]/div[2]/p");
    private final By RESPONSE_MESSAGE = By.cssSelector(".askt-dialog__message.askt-dialog__message--active-response");
    private final By RESPONSE_MESSAGE1 = By.cssSelector(".askt-dialog__bubble.askt-dialog__bubble--response");


//        private final By ErrorDescriptionForInvalid = By.xpath("//span[contains(text(),'Invalid username or password.')]");

    @Before
    public void setup() {
        String exePath = "src/main/resources/drivers/local/chromedriver";
        //String exePath = "src/main/resources/drivers/server/chromedriver";

        System.setProperty("webdriver.chrome.driver", exePath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox"); //Bypass OS security model
        options.addArguments("--start-maximized");
        options.addArguments("--disable-dev-shm-usage");
//            options.addArguments("--headless");
        options.addArguments("ignore-certificate-errors");
        options.addArguments("--ignore-ssl-errors=yes");
        dr = new ChromeDriver(options);
    }

    @After
    public void cleanUp() {
        dr.quit();
    }

    @Given("user go to Amazon login page")
    public void userGoToTalitoLoginPage() throws IOException {
        dr.get(getProperty("BaseURL"));
        dr.manage().window().maximize();
    }


    @When("^user type username as \"(.*)\"$")
    public void userTypeUsernameAsDaAdmin(String username) throws IOException {
        //dr.findElement(By.xpath("//*[@id='username']")).sendKeys(getProperty("daAdminUsername"));
        dr.findElement(By.id("ap_email")).sendKeys(username);
    }

    @When("^user type password as \"(.*)\"$")
    public void userTypePasswordForDaAdmin(String password) throws IOException {
//            dr.findElement(By.xpath("//*[@id='password']")).sendKeys(getProperty("daAdminPassword"));
        dr.findElement(By.id("ap_password")).sendKeys(password);
    }

    @When("^click on keep me signin$")
    public void clickKeepMeSignin() throws Throwable {
        Thread.sleep(1000);
        dr.findElement(By.xpath("//*[@id=\"authportal-main-section\"]/div[2]/div/div/form/div/div/div/div[3]/div[2]/div/label/div/label/input")).click();
//        JavascriptExecutor jse = (JavascriptExecutor) dr;
//        jse.executeScript("arguments[0].click()", dr.findElement(By.id("signInSubmit")));
        Thread.sleep(1000);
    }

    @When("^click on login button$")
    public void clickLoginButton() throws Throwable {
        Thread.sleep(1000);
//            dr.findElement(By.id("signInSubmit")).click();
        JavascriptExecutor jse = (JavascriptExecutor) dr;
        jse.executeScript("arguments[0].click()", dr.findElement(By.id("signInSubmit")));
        Thread.sleep(10000);
    }

    @Then("^user should logged in successfully$")
    public void verifySuccessful() throws Throwable {
        Thread.sleep(5000);
        boolean icon = dr.findElement(By.xpath("//*[@id=\"dpc-header-logo\"]/div/div[2]/span")).isDisplayed();
//            boolean question = dr.findElement(By.xpath("//*[@id=\"root\"]/span/div/div/div/div/ul/div/div/h2")).isDisplayed();
//            boolean welcome = dr.findElement(By.xpath("//*[@id=\"root\"]/span/div/div/div/div/ul/div/div/h4")).isDisplayed();


//            boolean promo = dr.findElement(By.xpath("//*[@id=\"landing-page-space-0\"]")).isDisplayed();
//            boolean eng = dr.findElement(By.xpath("//*[@id=\"landing-page-space-1\"]")).isDisplayed();
//            boolean survey = dr.findElement(By.xpath("//*[@id=\"landing-page-space-2\"]")).isDisplayed();

        Assert.assertArrayEquals(new boolean[]{true}, new boolean[]{
                icon});
    }

    @When("user select the action as test in the dropdown")
    public void loginUser() throws InterruptedException {
        Thread.sleep(30000);
//            dr.findElement(By.id("react-select-2--value")).click();
        JavascriptExecutor jse = (JavascriptExecutor) dr;
        jse.executeScript("arguments[0].click()", dr.findElement(By.id("react-select-2--value")));

        jse.executeScript("arguments[0].click()", dr.findElement(By.id("react-select-3--value")));
    }

    @When("^user type \"(.*)\" and \"(.*)\"$")
    public void userTypeUsernamePassword(String username, String password) throws Throwable {
        //dr.findElement(By.xpath("//*[@id='username']")).sendKeys(getProperty("daAdminUsername"));
        dr.findElement(By.id("ap_email")).sendKeys(username);
        dr.findElement(By.id("ap_password")).sendKeys(password);

    }

    @Then("^user input the \"(.*)\" and \"(.*)\" and \"(.*)\"$")
    public void userTypeInputMessage(String message1, String message2, String message3) throws Throwable {
        Thread.sleep(10000);
        dr.findElement(By.xpath("//div[@id='astro-tabs-1-panel-0']/div/div[2]/input")).sendKeys(message1);
        dr.findElement(By.xpath("//div[@id='astro-tabs-1-panel-0']/div/div[2]/input")).sendKeys(Keys.ENTER);
        Thread.sleep(10000);
        dr.findElement(By.xpath("//div[@id='astro-tabs-1-panel-0']/div/div[2]/input")).sendKeys(message2);
        dr.findElement(By.xpath("//div[@id='astro-tabs-1-panel-0']/div/div[2]/input")).sendKeys(Keys.ENTER);
        Thread.sleep(10000);
        dr.findElement(By.xpath("//div[@id='astro-tabs-1-panel-0']/div/div[2]/input")).sendKeys(message3);
        dr.findElement(By.xpath("//div[@id='astro-tabs-1-panel-0']/div/div[2]/input")).sendKeys(Keys.ENTER);
        Thread.sleep(10000);
    }

    @When("user verify response message")
    public void userVerifyResponseMessage(DataTable dataTable) throws Throwable {
        Thread.sleep(10000);
        boolean request = dr.findElement(By.cssSelector(".askt-dialog__bubble--request")).isDisplayed();
        boolean response = dr.findElement(By.cssSelector(".askt-dialog__message--response")).isDisplayed();

//            boolean responseMessage = dr.findElement(By.xpath("//div[@id='astro-tabs-1-panel-0']/div[2]/div[2]/p")).isDisplayed();
//            boolean responseMessage = dr.findElement(By.cssSelector(".askt-dialog__message.askt-dialog__message--request")).isDisplayed();
//        boolean responseMessage = dr.findElement(By.cssSelector(".askt-dialog__message.askt-dialog__message--active-response")).isDisplayed();
        Assert.assertArrayEquals(new boolean[]{true, true}, new boolean[]{
                request, response});
//        ListIterator<WebElement> requestMessageElements = dr.findElements(By.cssSelector(".askt-dialog__message--request")).listIterator();
//        ListIterator<WebElement> responseMessageElements = dr.findElements(By.cssSelector(".askt-dialog__message--response")).listIterator();
        List<WebElement> elementList = dr.findElements(By.cssSelector(".askt-dialog"));
        String objects = elementList.toArray().toString();
        for (WebElement element : elementList
        ) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(element.getText().lines().toArray().length);
            System.out.println(element.getText().lines().toArray()[0]);
            System.out.println(objects);
            System.out.println();
            System.out.println();
            System.out.println();
            Object data = element.getText();
//            WriteExcel obj = new WriteExcel();
//            obj.writeExcel("console", "ddgdf", 1, 1);
//            obj.writeExcel("console", "amali", 1, 2);
//            PrintStream myTextFile = new PrintStream(new File("/home/amali/Documents/msc/PrivacyAnalyzer-Alexa/testData/test.txt"));
//            System.setOut(myTextFile);
//            myTextFile.print(data);
        try {
            FileWriter fileWriter = new FileWriter("/home/amali/Documents/msc/PrivacyAnalyzer-Alexa/testData/test.txt", true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(data);
            printWriter.close();
            fileWriter.close();
            System.out.println("successfully saved the data into file");
        }catch (IOException e){
            e.printStackTrace();
        }


        }


        Thread.sleep(10000);


    }

//    @Test
//    public void write() throws Exception {
//        WriteExcel obj = new WriteExcel();
//        obj.writeExcel("console", "ddgdf", 1, 1);
//
//    }

}