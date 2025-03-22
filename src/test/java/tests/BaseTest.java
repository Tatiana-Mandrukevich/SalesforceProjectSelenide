package tests;

import com.codeborne.selenide.Configuration;
import constants.IConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class BaseTest implements ITestConstants, IConstants {
    AccountListPage accountListPage;
    AccountPage accountPage;
    ContactListPage contactListPage;
    ContactPage contactPage;
    HomePage homePage;
    LoginPage loginPage;
    NewAccountModalPage newAccountModalPage;
    NewContactModalPage newContactModalPage;

    Random random = new Random();
    SoftAssert softAssert = new SoftAssert();

    public void initPages() {
        accountListPage = new AccountListPage();
        accountPage = new AccountPage();
        contactListPage = new ContactListPage();
        contactPage = new ContactPage();
        homePage = new HomePage();
        loginPage = new LoginPage();
        newAccountModalPage = new NewAccountModalPage();
        newContactModalPage = new NewContactModalPage();
    }

    @BeforeMethod
    public  void initTest(){
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        options.addArguments("--disable-popup-blocking");
        prefs.put("profile.default_content_setting_values.notifications", 2);
        options.setExperimentalOption("prefs", prefs);
        WebDriver driver = new ChromeDriver(options);
        setWebDriver(driver);

        Configuration.browser = "chrome";
        Configuration.timeout = 15000;
        Configuration.headless = false;
        Configuration.browserSize = "1024x768";

        initPages();
    }

    /**
     * It is quitting the WebDriver.
     */
    @AfterMethod
    public void endTest() {
        getWebDriver().quit();
    }
}