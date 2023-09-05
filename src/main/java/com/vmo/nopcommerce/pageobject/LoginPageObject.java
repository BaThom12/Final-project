package com.vmo.nopcommerce.pageobject;

import com.vmo.nopcommerce.common.BasePage;
import com.vmo.nopcommerce.interfaces.HomePageUI;
import com.vmo.nopcommerce.interfaces.LoginPageUI;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class LoginPageObject extends BasePage {
    WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnLogin(WebDriver driver) {
        clickElement(driver, HomePageUI.LOCATOR_LOGIN_lABEL);
    }

    public void clickOnForgetPassword(WebDriver driver) {
        clickElement(driver, LoginPageUI.LOCATOR_FORGOT_PASSWORD_lABEL);
    }

    public void enterEmail(WebDriver driver) {
        sendKeys(driver, LoginPageUI.LOCATOR_EMAIL_TEXTBOX, "thombt@vmogroup.com");
    }

    public void clickOnRecoverButton(WebDriver driver) {
        clickElement(driver, LoginPageUI.LOCATOR_RECOVER_BUTTON);
    }

    public String getNofifySuccess(WebDriver driver) {
        waitElement(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LoginPageUI.LOCATOR_NOFICATION_TITLE)));
        return getText(driver, LoginPageUI.LOCATOR_NOFICATION_TITLE);
    }

    public void loginGmail(WebDriver driver) throws AWTException{
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_T);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_T);
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get(LoginPageUI.GMAIL_URL);
        sendKeys(driver, LoginPageUI.LOCATOR_EMAIL_ID_TEXTBOX, "thombt@vmogroup.com");
        clickElement(driver, LoginPageUI.LOCATOR_NEXT_BUTTON);
        sendKeys(driver, LoginPageUI.LOCATOR_PASSWORD_TEXTBOX, "thomBT@2023");
        clickElement(driver, LoginPageUI.LOCATOR_PASSWORD_NEXT_BUTTON);
    }
    public String getTitlePage(WebDriver driver){
        return getTitle(driver);
    }

}
