package com.vmo.nopcommerce.register;

import com.vmo.nopcommerce.common.BaseTest;
import com.vmo.nopcommerce.interfaces.HomePageUI;
import com.vmo.nopcommerce.interfaces.RegisterPageUI;
import com.vmo.nopcommerce.pageobject.HomePageObject;
import com.vmo.nopcommerce.pageobject.RegisterPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterSuccessfullyTest extends BaseTest {
    private static WebDriver driver;
    private HomePageObject home;
    private RegisterPageObject register;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(HomePageUI.HOME_URL);
    }

    @Test
    public void Register_TC01_RegisterSuccessfully() {
        home = new HomePageObject(driver);
        Assert.assertEquals(this.driver.getCurrentUrl(), HomePageUI.HOME_URL);
        home.clickToMenu(driver);
        register = new RegisterPageObject(driver);
        Assert.assertTrue(driver.getCurrentUrl().contains(RegisterPageUI.REGISTER_URL));
        register.chooseGender(driver);
        register.enterFirstName(driver);
        register.enterLastName(driver);
        register.chooseDay(driver);
        register.chooseMonth(driver);
        register.chooseYear(driver);
        register.enterEmail(driver);
        register.enterCompany(driver);
        register.enterPassword(driver);
        register.enterConfirmPassword(driver);
        register.clickRegisterButton(driver);
        Assert.assertEquals(register.getTextOfNofify(), "Your registration completed");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
