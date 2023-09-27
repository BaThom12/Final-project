package com.vmo.sauce.login;

import com.vmo.nopcommerce.common.BaseTest;
import com.vmo.nopcommerce.helper.Log;
import com.vmo.nopcommerce.helper.TestNGListener;
import com.vmo.nopcommerce.utils.excelutils.ExcelUtil;
import com.vmo.sauce.interfaces.LoginPageUI;
import com.vmo.sauce.pageobject.LoginPageObject;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Epic("Sauce")
@Feature("Login")
@Story("Login unsuccessful")
@Listeners(TestNGListener.class)
public class LoginUnSuccessful extends BaseTest {
    private static WebDriver driver;
    private LoginPageObject login;

    @Parameters("browser")
    @BeforeMethod
    public void setup(@Optional("CHROME") String browser) {
        driver = getDriverBrowser(browser);
        driver.manage().window().maximize();
        Log.info("Open browser");
        driver.get(LoginPageUI.SAUCE_URL);
        Log.info("Open Login page");
        ExcelUtil.setExcelFileSheet("data");
    }

    @Test(description = "Empty username valid password")
    @Description("Empty username valid password")
    public void loginUnSuccessful_EmptyUsernameValidPassword() {
        login = new LoginPageObject(driver);
        login.enterValueOnTextbox(driver, LoginPageUI.LOCATOR_USERNAME_TEXTBOX, ExcelUtil.getRowData(2).getCell(2).toString().trim());
        login.enterValueOnTextbox(driver, LoginPageUI.LOCATOR_PASSWORD_TEXTBOX, ExcelUtil.getRowData(2).getCell(3).toString().trim());
        login.clickOnButton(driver,LoginPageUI.LOCATOR_LOGIN_BUTTON);
        verifyEquals(login.getErrorMessage(driver,LoginPageUI.LOCATOR_ERROR_MESSAGE), LoginPageUI.USERNAME_REQUIRED_ERROR_MESSAGE);
        login.fillTestResult(2,4);
    }
    @Test(description = "Valid username empty password")
    @Description("Valid username empty password")
    public void loginUnSuccessful_ValidUsernameEmptyPassword() {
        login = new LoginPageObject(driver);
        login.enterValueOnTextbox(driver, LoginPageUI.LOCATOR_USERNAME_TEXTBOX, ExcelUtil.getRowData(3).getCell(2).toString().trim());
        login.enterValueOnTextbox(driver, LoginPageUI.LOCATOR_PASSWORD_TEXTBOX, ExcelUtil.getRowData(3).getCell(3).toString().trim());
        login.clickOnButton(driver,LoginPageUI.LOCATOR_LOGIN_BUTTON);
        verifyEquals(login.getErrorMessage(driver,LoginPageUI.LOCATOR_ERROR_MESSAGE), LoginPageUI.PASSWORD_REQUIRED_ERROR_MESSAGE);
        login.fillTestResult(3,4);
    }
    @Test(description = "Empty username empty password")
    @Description("Empty username empty password")
    public void loginUnSuccessful_EmptyUsernameEmptyPassword() {
        login = new LoginPageObject(driver);
        login.enterValueOnTextbox(driver, LoginPageUI.LOCATOR_USERNAME_TEXTBOX, ExcelUtil.getRowData(4).getCell(2).toString().trim());
        login.enterValueOnTextbox(driver, LoginPageUI.LOCATOR_PASSWORD_TEXTBOX, ExcelUtil.getRowData(4).getCell(3).toString().trim());
        login.clickOnButton(driver,LoginPageUI.LOCATOR_LOGIN_BUTTON);
        verifyEquals(login.getErrorMessage(driver,LoginPageUI.LOCATOR_ERROR_MESSAGE), LoginPageUI.USERNAME_REQUIRED_ERROR_MESSAGE);
        login.fillTestResult(4,4);
    }
    @Test(description = "Valid username invalid password")
    @Description("Valid username invalid password")
    public void loginUnSuccessful_ValidUsernameInvalidPassword() {
        login = new LoginPageObject(driver);
        login.enterValueOnTextbox(driver, LoginPageUI.LOCATOR_USERNAME_TEXTBOX, ExcelUtil.getRowData(5).getCell(2).toString().trim());
        login.enterValueOnTextbox(driver, LoginPageUI.LOCATOR_PASSWORD_TEXTBOX, ExcelUtil.getRowData(5).getCell(3).toString().trim());
        login.clickOnButton(driver,LoginPageUI.LOCATOR_LOGIN_BUTTON);
        verifyEquals(login.getErrorMessage(driver,LoginPageUI.LOCATOR_ERROR_MESSAGE), LoginPageUI.ERROR_MESSAGE);
        login.fillTestResult(5,4);
    }
    @Test(description = "Invalid username valid password")
    @Description("Invalid username valid password")
    public void loginUnSuccessful_InvalidUsernameInvalidPassword() {
        login = new LoginPageObject(driver);
        login.enterValueOnTextbox(driver, LoginPageUI.LOCATOR_USERNAME_TEXTBOX, ExcelUtil.getRowData(6).getCell(2).toString().trim());
        login.enterValueOnTextbox(driver, LoginPageUI.LOCATOR_PASSWORD_TEXTBOX, ExcelUtil.getRowData(6).getCell(3).toString().trim());
        login.clickOnButton(driver,LoginPageUI.LOCATOR_LOGIN_BUTTON);
        verifyEquals(login.getErrorMessage(driver,LoginPageUI.LOCATOR_ERROR_MESSAGE), LoginPageUI.ERROR_MESSAGE);
        login.fillTestResult(6,4);
    }

    @AfterTest
    public void tearDown(){
        cleanBrowserAndDriver();
    }
}
