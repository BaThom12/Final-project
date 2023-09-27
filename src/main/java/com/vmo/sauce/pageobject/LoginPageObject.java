package com.vmo.sauce.pageobject;

import com.vmo.nopcommerce.common.BasePage;
import com.vmo.nopcommerce.helper.Log;
import com.vmo.nopcommerce.utils.excelutils.ExcelUtil;
import org.openqa.selenium.WebDriver;

public class LoginPageObject extends BasePage {
    WebDriver driver;
    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnButton(WebDriver driver,String locator) {
        clickToElement(driver, locator);
        Log.allure("Click on login button");
    }

    public void enterValueOnTextbox(WebDriver driver,String locator, String value) {
        sendKeyToElement(driver, locator, value);
        Log.allure("Send key to textbox value: %s",value);
    }
    public String getUrl(WebDriver driver){
        return getCurrentUrl(driver);
    }
    public String getErrorMessage(WebDriver driver, String locator){
        return getTextElement(driver,locator);
    }

    public void fillTestResult(int row, int column) {
        ExcelUtil.rowNumber = row;
        ExcelUtil.columnNumber = column;

    }
}
