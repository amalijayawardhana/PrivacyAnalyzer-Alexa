package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

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


        @When("user type username as username")
        public void userTypeUsernameAsDaAdmin() throws IOException {
            //dr.findElement(By.xpath("//*[@id='username']")).sendKeys(getProperty("daAdminUsername"));
            dr.findElement(By.id("ap_email")).sendKeys(getProperty("username"));
        }

        @When("user type password for password")
        public void userTypePasswordForDaAdmin() throws IOException {
//            dr.findElement(By.xpath("//*[@id='password']")).sendKeys(getProperty("daAdminPassword"));
            dr.findElement(By.id("ap_password")).sendKeys(getProperty("password"));
        }

        @When("^click on login button$")
        public void clickLoginButton() throws Throwable{
            Thread.sleep(1000);
//            dr.findElement(By.id("signInSubmit")).click();
            JavascriptExecutor jse = (JavascriptExecutor)dr;
            jse.executeScript("arguments[0].click()", dr.findElement(By.id("signInSubmit")));

        }

        @Then("^user should logged in successfully$")
        public void verifySuccessful() throws Throwable{
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
            JavascriptExecutor jse = (JavascriptExecutor)dr;
            jse.executeScript("arguments[0].click()", dr.findElement(By.id("react-select-2--value")));

            jse.executeScript("arguments[0].click()", dr.findElement(By.id("react-select-3--value")));
        }

        @When("user input the message")
        public void userTypeInputMessage() throws Throwable {
            dr.findElement(By.xpath("//div[@id='astro-tabs-1-panel-0']/div/div[2]/input")).sendKeys("Hi");
            dr.findElement(By.xpath("//div[@id='astro-tabs-1-panel-0']/div/div[2]/input")).sendKeys(Keys.ENTER);
            Thread.sleep(10000);

        }
        @When("user input the message2")
        public void userTypeInputMessage2() throws Throwable {
            dr.findElement(By.xpath("//div[@id='astro-tabs-1-panel-0']/div/div[2]/input")).sendKeys("Good morning");
            dr.findElement(By.xpath("//div[@id='astro-tabs-1-panel-0']/div/div[2]/input")).sendKeys(Keys.ENTER);
            Thread.sleep(10000);

        }

        @When("user verify response message")
        public void userVerifyResponseMessage() throws Throwable {
            Thread.sleep(10000);
//            boolean responseMessage = dr.findElement(By.xpath("//div[@id='astro-tabs-1-panel-0']/div[2]/div[2]/p")).isDisplayed();
//            boolean responseMessage = dr.findElement(By.cssSelector(".askt-dialog__message.askt-dialog__message--request")).isDisplayed();
            boolean responseMessage = dr.findElement(By.cssSelector(".askt-dialog__message.askt-dialog__message--active-response")).isDisplayed();
            Assert.assertArrayEquals(new boolean[]{true}, new boolean[]{
                    responseMessage});
            actualResponseMessage = dr.findElement(RESPONSE_MESSAGE).getText();
            actualResponseMessage1 = dr.findElement(RESPONSE_MESSAGE1).getText();
            
            System.out.println("actual Message    "+actualResponseMessage);
            System.out.println("actual Message1    "+actualResponseMessage1);
            Thread.sleep(10000);

        }





            }