package com.vmo.nopcommerce.login;

import com.vmo.nopcommerce.common.BaseTest;
import com.vmo.nopcommerce.helper.Log;
import com.vmo.nopcommerce.helper.TestNGListener;
import com.vmo.nopcommerce.interfaces.HomePageUI;
import com.vmo.nopcommerce.interfaces.LoginPageUI;
import com.vmo.nopcommerce.pageobject.HomePageObject;
import com.vmo.nopcommerce.pageobject.LoginPageObject;
import com.vmo.nopcommerce.pageobject.RegisterPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.awt.*;
@Listeners(TestNGListener.class)
public class ForgetPasswordTest extends BaseTest {
    private static WebDriver driver;
    private HomePageObject home;
    private LoginPageObject login;

    @Parameters("browser")
    @BeforeMethod
    public void setup(@Optional("CHROME") String browser) {
        driver = getDriverBrowser(browser);
        driver.manage().window().maximize();
        Log.info("Open browser");
        driver.get(HomePageUI.HOME_URL);
        Log.info("Open Home of Nopcommer");
    }

    @Test
    public void Password_TC04_Forgot() throws AWTException {
        home = new HomePageObject(driver);
        verifyEquals(home.getUrlHomePage(driver), HomePageUI.HOME_URL);
        Log.info("Verify that you are on the home page is succeed");
        login = new LoginPageObject(driver);
        login.clickOnButton(driver, HomePageUI.LOCATOR_LOGIN_lABEL);
        verifyEquals(login.getTitlePage(driver), LoginPageUI.LOGIN_TITLE);
        Log.info("Verify that you are on the login page is succeed");
        login.clickOnButton(driver, LoginPageUI.LOCATOR_FORGOT_PASSWORD_lABEL);
        verifyEquals(login.getTitlePage(driver), LoginPageUI.PASSWORD_RECOVER_TITLE);
        Log.info("Verify that you are on the password recovery page is succeed");
        login.enterValueOnTextbox(driver, LoginPageUI.LOCATOR_EMAIL_TEXTBOX, "thombt@rikkei.com");
        login.clickOnButton(driver, LoginPageUI.LOCATOR_RECOVER_BUTTON);
        verifyEquals(login.getNofifySuccess(driver, LoginPageUI.LOCATOR_NOFICATION_TITLE), LoginPageUI.FORGOT_TITLE);
        Log.info("Verify the message(Email with instructions has been sent to you.) is displayed");
        login.openGmailPage(driver, 0, LoginPageUI.GMAIL_URL);
        login.enterValueOnTextbox(driver, LoginPageUI.LOCATOR_EMAIL_ID_TEXTBOX, "thombt@rikkei.com");
        login.clickOnButton(driver, LoginPageUI.LOCATOR_NEXT_BUTTON);
        login.enterValueOnTextbox(driver, LoginPageUI.LOCATOR_PASSWORD_TEXTBOX, "password");
        login.clickOnButton(driver, LoginPageUI.LOCATOR_PASSWORD_NEXT_BUTTON);
        Log.info("Log in gmail successful");
    }

    @AfterMethod
    public void tearDown() {
        cleanBrowserAndDriver();
        Log.info("Clear Browser and driver");
    }

}
