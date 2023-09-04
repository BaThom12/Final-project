package com.vmo.nopcommerce.login;

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

public class ForgetPasswordTest {
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
    public void Password_TC04_Forgot() {
        home = new HomePageObject(driver);
        Assert.assertEquals(this.driver.getCurrentUrl(), HomePageUI.HOME_URL);
        login = new LoginPageObject(driver);
        login.clickOnLogin(driver);
        Assert.assertEquals(this.driver.getTitle(), LoginPageUI.LOGIN_TITLE);
        login.clickOnForgetPassword(driver);
        Assert.assertEquals(this.driver.getTitle(), LoginPageUI.PASSWORD_RECOVER_TITLE);
        login.enterEmail(driver);
        login.clickOnRecoverButton(driver);
        Assert.assertEquals(login.getNofifySuccess(driver), LoginPageUI.FORGOT_TITLE);
        login.verifyGmail(driver);

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
