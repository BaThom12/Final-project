package com.vmo.nopcommerce.login;

import com.vmo.nopcommerce.common.BaseTest;
import com.vmo.nopcommerce.interfaces.HomePageUI;
import com.vmo.nopcommerce.interfaces.LoginPageUI;
import com.vmo.nopcommerce.pageobject.HomePageObject;
import com.vmo.nopcommerce.pageobject.LoginPageObject;
import com.vmo.nopcommerce.pageobject.RegisterPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;

public class ForgetPasswordTest extends BaseTest {
    private static WebDriver driver;
    private HomePageObject home;
    private LoginPageObject login;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(HomePageUI.HOME_URL);
    }

    @Test
    public void Password_TC04_Forgot()throws AWTException {
        home = new HomePageObject(driver);
        verifyEquals(home.getUrlHomePage(driver),HomePageUI.HOME_URL);
        login = new LoginPageObject(driver);
        login.clickOnButton(driver,HomePageUI.LOCATOR_LOGIN_lABEL);
        verifyEquals(login.getTitlePage(driver), LoginPageUI.LOGIN_TITLE);
        login.clickOnButton(driver,LoginPageUI.LOCATOR_FORGOT_PASSWORD_lABEL);
        verifyEquals(login.getTitlePage(driver), LoginPageUI.PASSWORD_RECOVER_TITLE);
        login.enterValueOnTextbox(driver,LoginPageUI.LOCATOR_EMAIL_TEXTBOX,"thombt@vmogroup.com");
        login.clickOnButton(driver,LoginPageUI.LOCATOR_RECOVER_BUTTON);
        verifyEquals(login.getNofifySuccess(driver,LoginPageUI.LOCATOR_NOFICATION_TITLE), LoginPageUI.FORGOT_TITLE);
        //login.loginGmail(driver);
        login.openGmailPage(driver,0,LoginPageUI.GMAIL_URL);
        login.enterValueOnTextbox(driver,LoginPageUI.LOCATOR_EMAIL_ID_TEXTBOX,"thombt@vmogroup.com");
        login.clickOnButton(driver, LoginPageUI.LOCATOR_NEXT_BUTTON);
        login.enterValueOnTextbox(driver, LoginPageUI.LOCATOR_PASSWORD_TEXTBOX, "password");
        login.clickOnButton(driver, LoginPageUI.LOCATOR_PASSWORD_NEXT_BUTTON);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
