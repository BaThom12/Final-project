package com.vmo.sauce.login;

import com.vmo.nopcommerce.common.BaseTest;
import com.vmo.nopcommerce.helper.Log;
import com.vmo.nopcommerce.helper.TestNGListener;
import com.vmo.nopcommerce.interfaces.ForgotPasswordPageUI;
import com.vmo.nopcommerce.interfaces.HomePageUI;
import com.vmo.nopcommerce.pageobject.ForgotPasswordPageObject;
import com.vmo.nopcommerce.pageobject.HomePageObject;
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
@Story("Login successful")
@Listeners(TestNGListener.class)
public class LoginSuccessful extends BaseTest {
    private static WebDriver driver;
    private LoginPageObject login;

    @Parameters({"browser","runType"})
    @BeforeMethod
    // public void setup(@Optional("CHROME") String browser) {
    public void setup(String browser, String type) {
        driver = getDriverBrowser(browser,type);
        driver.manage().window().maximize();
        Log.info("Open browser");
        driver.get(LoginPageUI.SAUCE_URL);
        Log.info("Open Login page");
        ExcelUtil.setExcelFileSheet("data");
    }

    @Test(description = "Valid username valid password")
    @Description("Valid username valid password")
    public void loginSuccessful() {
        login = new LoginPageObject(driver);
        login.enterValueOnTextbox(driver, LoginPageUI.LOCATOR_USERNAME_TEXTBOX, ExcelUtil.getRowData(1).getCell(2).toString());
        login.enterValueOnTextbox(driver, LoginPageUI.LOCATOR_PASSWORD_TEXTBOX, ExcelUtil.getRowData(1).getCell(3).toString());
        login.clickOnButton(driver,LoginPageUI.LOCATOR_LOGIN_BUTTON);
        verifyEquals(login.getUrl(driver), LoginPageUI.SAUCE_HOME_URL);
        Log.allure("url: %s",login.getUrl(driver));
        Log.allure("text url: %s",LoginPageUI.SAUCE_HOME_URL);
        login.fillTestResult(1,4);
    }
}
