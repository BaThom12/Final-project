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
    public void Register_TC01_RegisterSuccessfully() throws InterruptedException{
        home = new HomePageObject(driver);
        verifyEquals(home.getUrlHomePage(driver),HomePageUI.HOME_URL);
        home.clickToElementOnHomePage(driver,HomePageUI.LOCATOR_REGISTER_lABEL);
        register = new RegisterPageObject(driver);
        verifyTrue(driver.getCurrentUrl().contains(RegisterPageUI.REGISTER_URL));
        register.clickToElementOfRegisterPage(driver,RegisterPageUI.LOCATOR_GENDER);
        register.enterValueOnTextBoxOfRegisterPage(driver, RegisterPageUI.LOCATOR_FIRSTNAME, "Thom");
        register.enterValueOnTextBoxOfRegisterPage(driver, RegisterPageUI.LOCATOR_LASTNAME, "Ba");
        register.chooseValueOfSelectOfRegisterPage(driver, RegisterPageUI.LOCATOR_DAY, "8");
        register.chooseValueOfSelectOfRegisterPage(driver, RegisterPageUI.LOCATOR_MONTH, "August");
        register.chooseValueOfSelectOfRegisterPage(driver, RegisterPageUI.LOCATOR_YEAR, "1998");
        register.enterValueOnTextBoxOfRegisterPage(driver, RegisterPageUI.LOCATOR_EMAIL, "thombt@vmogroup.com");
        register.enterValueOnTextBoxOfRegisterPage(driver, RegisterPageUI.LOCATOR_COMPANY, "VMO JAPAN");
        register.enterValueOnTextBoxOfRegisterPage(driver, RegisterPageUI.LOCATOR_PASSWORD, "Abc@1234");
        register.enterValueOnTextBoxOfRegisterPage(driver, RegisterPageUI.LOCATOR_CONFIRM_PASSWORD, "Abc@1234");
        Thread.sleep(3000);
        register.clickToElementOfRegisterPage(driver,RegisterPageUI.LOCATOR_REGISTER_BUTTON);
        verifyEquals(register.getTextOfNofify(driver,RegisterPageUI.LOCATOR_MESSAGE_REGISTER_SUCCESS), "Your registration completed");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
