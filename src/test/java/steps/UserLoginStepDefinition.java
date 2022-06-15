package steps;

import io.cucumber.core.internal.gherkin.deps.com.google.gson.Gson;
import io.cucumber.core.internal.gherkin.deps.com.google.gson.JsonArray;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import readExcel.ExcelReader;

import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class UserLoginStepDefinition extends Base {
    //        private final By RESPONSE_MESSAGE = By.xpath("//div[@id='astro-tabs-1-panel-0']/div[2]/div[2]/p");
    private final By RESPONSE_MESSAGE = By.cssSelector(".askt-dialog__message.askt-dialog__message--active-response");
    private final By RESPONSE_MESSAGE1 = By.cssSelector(".askt-dialog__bubble.askt-dialog__bubble--response");
    private String skillCategory = "";
    private String skillId = "";
    private String skillInvocationName = "";
    private String utterance = "";
    private String response = "";
    private String skillStatus = "";

    private Map<Integer, HashMap<String, String>> nestedMap;
    private ArrayList<HashMap> list = new ArrayList<>();



//        private final By ErrorDescriptionForInvalid = By.xpath("//span[contains(text(),'Invalid username or password.')]");

    @Before
    public void setup() {
        String exePath = "src/main/resources/drivers/local/chromedriver";
        //String exePath = "src/main/resources/drivers/server/chromedriver";

        System.setProperty("webdriver.chrome.driver", exePath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox"); //Bypass OS security model
        options.addArguments("--start-maximized");
//        options.addArguments("--start-minimized");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--mute-audio");
//        options.addArguments("--disable-popup-blocking");
            options.addArguments("--headless");
        options.addArguments("ignore-certificate-errors");
        options.addArguments("--ignore-ssl-errors=yes");
        options.addArguments("--strict");
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

    @Given("user go to")
    public void userGoTo() throws IOException, InterruptedException {
        dr.get(getProperty("BaseURL"));
        dr.manage().window().maximize();

//        Thread.sleep(30000);
//
//        //import skill names to explore
//        ArrayList<ArrayList<String>> names = new ArrayList<>();
//        input(names, "Skills");
//        System.out.println(names.size());
//        System.out.println(names.get(0));
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
        Thread.sleep(10000);
        boolean icon = dr.findElement(By.xpath("//*[@id=\"dpc-header-logo\"]/div/div[2]/span")).isDisplayed();
//            boolean question = dr.findElement(By.xpath("//*[@id=\"root\"]/span/div/div/div/div/ul/div/div/h2")).isDisplayed();
//            boolean welcome = dr.findElement(By.xpath("//*[@id=\"root\"]/span/div/div/div/div/ul/div/div/h4")).isDisplayed();


//            boolean promo = dr.findElement(By.xpath("//*[@id=\"landing-page-space-0\"]")).isDisplayed();
//            boolean eng = dr.findElement(By.xpath("//*[@id=\"landing-page-space-1\"]")).isDisplayed();
//            boolean survey = dr.findElement(By.xpath("//*[@id=\"landing-page-space-2\"]")).isDisplayed();

        Assert.assertArrayEquals(new boolean[]{true}, new boolean[]{icon});
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
//        dr.findElement(By.id("ap_email")).sendKeys(username);
//        dr.findElement(By.id("ap_password")).sendKeys(password);
        dr.findElement(By.id("ap_email")).sendKeys(getProperty("daAdminUsername"));
        dr.findElement(By.id("ap_password")).sendKeys(getProperty("daAdminPassword"));

    }

    @And("user login with valid credentials")
    public void loginToTheSystem() throws IOException, InterruptedException {
        dr.findElement(By.id("ap_email")).sendKeys(getProperty("username"));
        dr.findElement(By.id("ap_password")).sendKeys(getProperty("password"));
        dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

//        Thread.sleep(30000);
//
//        //import skill names to explore
//        ArrayList<ArrayList<String>> names = new ArrayList<>();
//        input(names, "Skills");
////        System.out.println(names.size());
////        System.out.println(names.get(0));
//
//        for (String n : names.get(0)) {
//            System.out.println(n);
//        }
    }

    @Then("^user input the \"(.*)\" and \"(.*)\"$")
    public void userSendMessageUsingExcel(String testId, String sheetName) throws Throwable {
        Thread.sleep(10000);

        ExcelReader excelReader = new ExcelReader("input/TestcaseSheet", testId, sheetName);


        skillCategory = excelReader.fieldsAndValues.get("skill_category");
        skillInvocationName = excelReader.fieldsAndValues.get("invocation_name");
        skillId = excelReader.fieldsAndValues.get("skill_id");
        utterance = excelReader.fieldsAndValues.get("utterance");
        String message1 = "Alexa, open " + skillInvocationName;
        String message2 = utterance;
        String message3 = "Alexa, close " + skillInvocationName;

        System.out.println("message1 = " + message1);
        System.out.println("message2 = " + message2);
        System.out.println("message3 = " + message3);

        dr.findElement(By.xpath("//*[@id=\"astro-tabs-1-panel-0\"]/div[1]/div[2]/div[1]/div[1]/input")).sendKeys(message1);
        dr.findElement(By.xpath("//*[@id=\"astro-tabs-1-panel-0\"]/div[1]/div[2]/div[1]/div[1]/input")).sendKeys(Keys.ENTER);
        Thread.sleep(10000);
        dr.findElement(By.xpath("//*[@id=\"astro-tabs-1-panel-0\"]/div[1]/div[2]/div[1]/div[1]/input")).sendKeys(message2);
        dr.findElement(By.xpath("//*[@id=\"astro-tabs-1-panel-0\"]/div[1]/div[2]/div[1]/div[1]/input")).sendKeys(Keys.ENTER);
        Thread.sleep(10000);
        dr.findElement(By.xpath("//*[@id=\"astro-tabs-1-panel-0\"]/div[1]/div[2]/div[1]/div[1]/input")).sendKeys(message3);
        dr.findElement(By.xpath("//*[@id=\"astro-tabs-1-panel-0\"]/div[1]/div[2]/div[1]/div[1]/input")).sendKeys(Keys.ENTER);
        Thread.sleep(10000);
    }

    @Then("^user input the \"(.*)\" and \"(.*)\" and \"(.*)\"$")
    public void userTypeInputMessage(String message1, String message2, String message3) throws Throwable {
        Thread.sleep(10000);

        dr.findElement(By.xpath("//*[@id=\"astro-tabs-1-panel-0\"]/div[1]/div[2]/div[1]/div[1]/input")).sendKeys(message1);
        dr.findElement(By.xpath("//*[@id=\"astro-tabs-1-panel-0\"]/div[1]/div[2]/div[1]/div[1]/input")).sendKeys(Keys.ENTER);
        Thread.sleep(10000);
        dr.findElement(By.xpath("//*[@id=\"astro-tabs-1-panel-0\"]/div[1]/div[2]/div[1]/div[1]/input")).sendKeys(message2);
        dr.findElement(By.xpath("//*[@id=\"astro-tabs-1-panel-0\"]/div[1]/div[2]/div[1]/div[1]/input")).sendKeys(Keys.ENTER);
        Thread.sleep(10000);
        dr.findElement(By.xpath("//*[@id=\"astro-tabs-1-panel-0\"]/div[1]/div[2]/div[1]/div[1]/input")).sendKeys(message3);
        dr.findElement(By.xpath("//*[@id=\"astro-tabs-1-panel-0\"]/div[1]/div[2]/div[1]/div[1]/input")).sendKeys(Keys.ENTER);
        Thread.sleep(10000);
    }

    @When("user store response message")
    public void userVerifyResponseMessage() throws Throwable {
        Thread.sleep(10000);
//        boolean req = dr.findElement(By.cssSelector(".askt-dialog__bubble--request")).isDisplayed();
//        boolean res = dr.findElement(By.cssSelector(".askt-dialog__message--response")).isDisplayed();

//        Assert.assertArrayEquals(new boolean[]{true, true}, new boolean[]{
//                req, res});
//        ListIterator<WebElement> requestMessageElements = dr.findElements(By.cssSelector(".askt-dialog__message--request")).listIterator();
        List<WebElement> requests = dr.findElements(By.cssSelector("div[data-qa-hook='skill-testing-dialog-request']"));
        List<WebElement> responses = dr.findElements(By.cssSelector("div[data-qa-hook='skill-testing-dialog-response']"));
//        ListIterator<WebElement> responseMessageElements = dr.findElements(By.cssSelector(".askt-dialog__message--response")).listIterator();
        List<WebElement> elementList = dr.findElements(By.cssSelector(".askt-dialog"));
//        String objects = elementList2.toArray().toString();

        JSONObject array = new JSONObject();
        JSONObject requestObj = new JSONObject();
        JSONObject responseObj = new JSONObject();
        int i = 1;
        for (WebElement response : responses) {
            responseObj.put("Response" + i, response.getText());
            i++;

        }
        int j = 1;
        for (WebElement request : requests) {
            requestObj.put("Request" + j, request.getText());
            j++;
        }
        array.put("request", requestObj);
        array.put("response", responseObj);
        String message = array.toString();


        JSONObject newArray = new JSONObject();
        LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();
        ArrayList<String> dataArray = new ArrayList<String>();
        JsonArray jsonElements = new JsonArray();

        JSONObject newRequestObj = new JSONObject();
        JSONObject newResponseObj = new JSONObject();
        for (WebElement element : elementList) {
            List<WebElement> resElements = element.findElements(By.cssSelector(".askt-dialog__bubble"));
            int c = 1;
            int k = 1;
            int s = 1;
            int p = 1;
            int q = 1;
            for (WebElement res : resElements) {
//                a=c;
                System.out.println();
                String className = res.getAttribute("class");
                System.out.println();
                if (className.contains("request")) {
                    newArray.put("Request" + c, res.getText());
                    dataMap.put("Request" + c, res.getText());
//                    dataMap.put("Request"+c+".0",res.getText());

//                    dataArray.add("Request"+c+":"+res.getText());
                    System.out.println("Request " + c + ".0 =" + res.getText());
                    s = c;
                    c++;
                    System.out.println();
                } else {
//                    dataMap.put("Response" + k, res.getText());

                    if (s == 1) {
                        dataMap.put("Response" + s + "." + k, res.getText());
                        k++;
                    } else if (s == 2) {
                        dataMap.put("Response" + s + "." + p, res.getText());
                        p++;
                    } else if (s == 3) {
                        dataMap.put("Response" + s + "." + q, res.getText());
                        q++;
                    }
 /*                   if (a==s) {
                        newArray.put("Response" + k, res.getText());
                        dataMap.put("Response" + s + "." + k, res.getText());

                        System.out.println("Response" + s + "." + k + "=" + res.getText());
                        k++;

                    }else {
                        k = 1;
                        newArray.put("Response" + k, res.getText());
                        dataMap.put("Response" + s + "." + k, res.getText());

                        System.out.println("Response" + s + "." + k + "=" + res.getText());
                        k++;


                    }
*/

                }
            }


        }
        String newMessage = newArray.toString();
//        String msg = new Gson().toJson(newArray, Map.class);

        String s = dataMap.toString();
        String jsonString1 = new JSONObject(dataMap).toString();
        String jsonString = new Gson().toJson(dataMap, Map.class);
        try {
            FileWriter fileWriter = new FileWriter("/home/amali/Documents/msc/PrivacyAnalyzer-Alexa/testData/json.json", true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
//            printWriter.println("JSON object");
//            printWriter.println(message);
//            printWriter.println(newMessage);
//            printWriter.println(",");
//            printWriter.println(jsonString1);
//            printWriter.println(",");
            printWriter.println(jsonString);
            printWriter.println(",");
//            printWriter.println();
            printWriter.close();
            fileWriter.close();
            System.out.println("successfully saved the data into file");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Thread.sleep(10000);
    }

    @When("user analyze the response message")
    public void userAnalyzeResponseMessage() throws Throwable {
        Thread.sleep(10000);
        List<WebElement> requests = dr.findElements(By.cssSelector("div[data-qa-hook='skill-testing-dialog-request']"));
        List<WebElement> responses = dr.findElements(By.cssSelector("div[data-qa-hook='skill-testing-dialog-response']"));
        List<WebElement> elementList = dr.findElements(By.cssSelector(".askt-dialog"));

        JSONObject array = new JSONObject();
        JSONObject requestObj = new JSONObject();
        JSONObject responseObj = new JSONObject();
        int i = 1;
        for (WebElement response : responses) {
            responseObj.put("Response" + i, response.getText());
            i++;

        }
        int j = 1;
        for (WebElement request : requests) {
            requestObj.put("Request" + j, request.getText());
            j++;
        }
        array.put("request", requestObj);
        array.put("response", responseObj);
        String message = array.toString();


        JSONObject newArray = new JSONObject();
        LinkedHashMap<String, String> dataMap = new LinkedHashMap<>();
        ArrayList<String> dataArray = new ArrayList<String>();
        JsonArray jsonElements = new JsonArray();

        JSONObject newRequestObj = new JSONObject();
        JSONObject newResponseObj = new JSONObject();
        for (WebElement element : elementList) {
            List<WebElement> resElements = element.findElements(By.cssSelector(".askt-dialog__bubble"));
            int c = 1;
            int k = 1;
            int s = 1;
            int p = 1;
            int q = 1;
            for (WebElement res : resElements) {
//                a=c;
                System.out.println();
                String className = res.getAttribute("class");
                System.out.println();
                if (className.contains("request")) {
                    newArray.put("Request" + c, res.getText());
                    dataMap.put("Request" + c, res.getText());
//                    dataMap.put("Request"+c+".0",res.getText());

//                    dataArray.add("Request"+c+":"+res.getText());
                    System.out.println("Request " + c + ".0 =" + res.getText());
                    s = c;
                    c++;
                    System.out.println();
                } else {
//                    dataMap.put("Response" + k, res.getText());

                    if (s == 1) {
                        dataMap.put("Response" + s + "." + k, res.getText());
                        k++;
                    } else if (s == 2) {
                        dataMap.put("Response" + s + "." + p, res.getText());
                        p++;
                    } else if (s == 3) {
                        dataMap.put("Response" + s + "." + q, res.getText());
                        q++;
                    }

                }
            }

        }
        String newMessage = newArray.toString();
//        String msg = new Gson().toJson(newArray, Map.class);

        String s = dataMap.toString();
        String jsonString1 = new JSONObject(dataMap).toString();
        String jsonString = new Gson().toJson(dataMap, Map.class);
//        System.out.println(dataMap.containsValue("Response2"));
        System.out.println("=======================");

        for (int k = 1; k < 49; k++) {
            String testid = String.valueOf(k);
            ExcelReader excelReader = new ExcelReader("input/Responses_analysis", testid, "Responses");
            String response_keyword = excelReader.fieldsAndValues.get("response_keyword");
//            System.out.println(response_keyword);
            String status = excelReader.fieldsAndValues.get("Accepting_Privacy_Data");
            excelReader.fieldsAndValues.get("response_keyword");
//                    Map<Integer, HashMap<String,String>> nestedMap = new HashMap<Integer, HashMap<String,String>>();
//            nestedMap.put(k-1, excelReader.fieldsAndValues);
//            System.out.println("inside loop" + nestedMap.toString());
            list.add((excelReader.fieldsAndValues));

        }
//        System.out.println(dataMap.keySet());
        List<String> arrayList = new ArrayList<>();
        for (String key : dataMap.keySet()) {

            if (key.contains("Response2")) {
                for (HashMap hashMap : list) {
                    String response_keyword = hashMap.get("response_keyword").toString();
                    String Accepting_Privacy_Data = hashMap.get("Accepting_Privacy_Data").toString();
                    boolean a = dataMap.get(key).equalsIgnoreCase(response_keyword);
                    boolean c = dataMap.get(key).toLowerCase().contains(response_keyword.toLowerCase());
                    boolean b = response_keyword.toLowerCase().contains(dataMap.get(key).toLowerCase());
                    boolean d = dataMap.get(key).toLowerCase().contains("don't know");
                    boolean e = response_keyword.contains("<Audio only response>");
                    if (a || b || c || d || e){
                        System.out.println(response_keyword+","+ Accepting_Privacy_Data);
                        response = dataMap.get(key);
                        skillStatus = Accepting_Privacy_Data;
                    }
//                    else {
//                        response = dataMap.get(key);
//                        skillStatus = "NAN";
//                        System.out.println("else response_keyword"+response_keyword);
//                        System.out.println("else response"+response);
//                    }
//

                }
                System.out.println(dataMap.get(key));


//                System.out.println(Arrays.deepToString(analyzedRespArray));
                //read the response analysis file and iterate it
//                for (String analyzedResponse : analyzedRespArray) {
//                    if (dataMap.get(key).contains(analyzedResponse) || analyzedResponse.contains(dataMap.get(key)) ||
//                            dataMap.get(key).equals(analyzedResponse)) {
//                        response = dataMap.get(key);
////                    System.out.println("response_keyword"+response_keyword);
////                    System.out.println("response"+response);
//                        skillStatus = status;
//                    } else {
//                        response = dataMap.get(key);
//                        skillStatus = "NAN";
//                        System.out.println("else response_keyword"+response_keyword);
//                        System.out.println("else response"+response);
//                    }
//
//                }
                System.out.print(skillCategory);
                System.out.print(" | ");
                System.out.print(skillId);
                System.out.print(" | ");
                System.out.print(skillInvocationName);
                System.out.print(" | ");
                System.out.print(utterance);
                System.out.print(" | ");
                System.out.print(skillStatus);
                System.out.print(" | ");
                System.out.print(response);
                System.out.print(" | ");

            }

        }


        try {
            FileWriter fileWriter = new FileWriter(getProperty("filePath")+"output/output.csv", true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
//            String output = skillCategory+","+skillId+","+skillInvocationName+","+utterance+","+ response+","+skillStatus;
            String output = skillCategory+"|"+skillId+"|"+skillInvocationName+"|"+utterance+"|"+ response+"|"+skillStatus;
            printWriter.println(output);
//            printWriter.println(",");
//            printWriter.println();
            printWriter.close();
            fileWriter.close();
            System.out.println("successfully saved the data into output file");
        }catch (IOException e){
            e.printStackTrace();
        }

        Thread.sleep(10000);
    }


}