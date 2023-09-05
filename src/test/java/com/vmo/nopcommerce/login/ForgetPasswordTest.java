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
        login.clickOnLogin(driver);
        verifyEquals(login.getTitlePage(driver), LoginPageUI.LOGIN_TITLE);
        login.clickOnForgetPassword(driver);
        verifyEquals(login.getTitlePage(driver), LoginPageUI.PASSWORD_RECOVER_TITLE);
        login.enterEmail(driver);
        login.clickOnRecoverButton(driver);
        verifyEquals(login.getNofifySuccess(driver), LoginPageUI.FORGOT_TITLE);
        login.loginGmail(driver);

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
