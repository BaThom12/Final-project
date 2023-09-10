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
    public void Register_TC01_RegisterSuccessfully(){
        home = new HomePageObject(driver);
        verifyEquals(home.getUrlHomePage(driver),HomePageUI.HOME_URL);
        home.clickToElementOnHomePage(driver,HomePageUI.LOCATOR_REGISTER_lABEL);
        register = new RegisterPageObject(driver);
        verifyTrue(driver.getCurrentUrl().contains(RegisterPageUI.REGISTER_URL));
        register.clickToElementOfRegisterPage(driver,RegisterPageUI.LOCATOR_GENDER);
        register.enterValueOnTextBoxOfRegisterPage(driver, RegisterPageUI.LOCATOR_DYNAMIC_TEXTBOX, "FirstName","Thom");
        register.enterValueOnTextBoxOfRegisterPage(driver, RegisterPageUI.LOCATOR_DYNAMIC_TEXTBOX, "LastName","Ba");
        register.chooseValueOfSelectOfRegisterPage(driver, RegisterPageUI.LOCATOR_DYNAMIC_SELECT, "DateOfBirthDay","8");
        register.chooseValueOfSelectOfRegisterPage(driver, RegisterPageUI.LOCATOR_DYNAMIC_SELECT, "DateOfBirthMonth","August");
        register.chooseValueOfSelectOfRegisterPage(driver, RegisterPageUI.LOCATOR_DYNAMIC_SELECT, "DateOfBirthYear","1998");
        register.enterValueOnTextBoxOfRegisterPage(driver, RegisterPageUI.LOCATOR_DYNAMIC_TEXTBOX, "Email","thombt@vmodev.com");
        register.enterValueOnTextBoxOfRegisterPage(driver, RegisterPageUI.LOCATOR_DYNAMIC_TEXTBOX, "Company","VMO JAPAN");
        register.enterValueOnTextBoxOfRegisterPage(driver, RegisterPageUI.LOCATOR_DYNAMIC_TEXTBOX, "Password","Abc@1234");
        register.enterValueOnTextBoxOfRegisterPage(driver, RegisterPageUI.LOCATOR_DYNAMIC_TEXTBOX, "ConfirmPassword","Abc@1234");
        register.clickToElementOfRegisterPage(driver,RegisterPageUI.LOCATOR_REGISTER_BUTTON);
        verifyEquals(register.getTextOfNofify(driver,RegisterPageUI.LOCATOR_MESSAGE_REGISTER_SUCCESS), "Your registration completed");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
