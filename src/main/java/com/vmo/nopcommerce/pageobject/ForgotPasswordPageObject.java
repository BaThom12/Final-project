package com.vmo.nopcommerce.pageobject;

import com.vmo.nopcommerce.common.BasePage;
import com.vmo.nopcommerce.helper.Log;
import org.openqa.selenium.WebDriver;

import java.awt.*;

public class ForgotPasswordPageObject extends BasePage {
    WebDriver driver;

    public ForgotPasswordPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnButton(WebDriver driver,String locator) {
        clickToElement(driver, locator);
    }

    public void enterValueOnTextbox(WebDriver driver,String locator, String value) {
        sendKeyToElement(driver, locator, value);
        Log.allure("Send key to textbox value: %s",value);
    }

    public String getNofifySuccess(WebDriver driver,String locator) {
        waitForElementVisible(driver, locator);
        Log.allure("Send new pass to email success");
        return getTextElement(driver, locator);
    }

    public void openGmailPage(WebDriver driver, int index,String url) throws AWTException{
        openNewTabByRobot(driver,index);
        driver.get(url);
        Log.allure("Open gmail is success");
    }
    public String getTitlePage(WebDriver driver){
        return getTitle(driver);
    }

}
