package com.vmo.nopcommerce.login;

import com.vmo.nopcommerce.common.BaseTest;
import com.vmo.nopcommerce.helper.Log;
import com.vmo.nopcommerce.helper.TestNGListener;
import com.vmo.nopcommerce.interfaces.HomePageUI;
import com.vmo.nopcommerce.interfaces.ForgotPasswordPageUI;
import com.vmo.nopcommerce.pageobject.HomePageObject;
import com.vmo.nopcommerce.pageobject.ForgotPasswordPageObject;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.awt.*;
@Epic("NopCommerce")
@Feature("Login")
@Story("Forget Password successful")
@Listeners(TestNGListener.class)
public class ForgetPasswordTest extends BaseTest {
    private static WebDriver driver;
    private HomePageObject home;
    private ForgotPasswordPageObject forgot;

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
        forgot = new ForgotPasswordPageObject(driver);
        forgot.clickOnButton(driver, HomePageUI.LOCATOR_LOGIN_lABEL);
        verifyEquals(forgot.getTitlePage(driver), ForgotPasswordPageUI.LOGIN_TITLE);
        Log.info("Verify that you are on the login page is succeed");
        forgot.clickOnButton(driver, ForgotPasswordPageUI.LOCATOR_FORGOT_PASSWORD_lABEL);
        verifyEquals(forgot.getTitlePage(driver), ForgotPasswordPageUI.PASSWORD_RECOVER_TITLE);
        Log.info("Verify that you are on the password recovery page is succeed");
        forgot.enterValueOnTextbox(driver, ForgotPasswordPageUI.LOCATOR_EMAIL_TEXTBOX, "thombt1212@gmail.com");
        forgot.clickOnButton(driver, ForgotPasswordPageUI.LOCATOR_RECOVER_BUTTON);
        verifyEquals(forgot.getNofifySuccess(driver, ForgotPasswordPageUI.LOCATOR_NOFICATION_TITLE), ForgotPasswordPageUI.FORGOT_TITLE);
        Log.info("Verify the message(Email with instructions has been sent to you.) is displayed");
        forgot.openGmailPage(driver, 0, ForgotPasswordPageUI.GMAIL_URL);
        forgot.enterValueOnTextbox(driver, ForgotPasswordPageUI.LOCATOR_EMAIL_ID_TEXTBOX, "thombt1212@gmail.com");
        forgot.clickOnButton(driver, ForgotPasswordPageUI.LOCATOR_NEXT_BUTTON);
        forgot.enterValueOnTextbox(driver, ForgotPasswordPageUI.LOCATOR_PASSWORD_TEXTBOX, "password");
        forgot.clickOnButton(driver, ForgotPasswordPageUI.LOCATOR_PASSWORD_NEXT_BUTTON);
        Log.info("Log in gmail successful");
    }

    @AfterMethod
    public void tearDown() {
        cleanBrowserAndDriver();
        Log.info("Clear Browser and driver");
    }

}
