package com.vmo.nopcommerce.pageobject;

import com.vmo.nopcommerce.common.BasePage;
import org.openqa.selenium.WebDriver;

import java.awt.*;

public class LoginPageObject extends BasePage {
    WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnButton(WebDriver driver,String locator) {
        clickToElement(driver, locator);
    }

    public void enterValueOnTextbox(WebDriver driver,String locator, String value) {
        sendKeyToElement(driver, locator, value);
    }

    public String getNofifySuccess(WebDriver driver,String locator) {
        waitForElementVisible(driver, locator);
        return getTextElement(driver, locator);
    }

    public void openGmailPage(WebDriver driver, int index,String url) throws AWTException{
        openNewTabByRobot(driver,index);
        driver.get(url);
    }
    public String getTitlePage(WebDriver driver){
        return getTitle(driver);
    }

}
