package com.vmo.nopcommerce.pageobject;

import com.vmo.nopcommerce.common.BasePage;
import com.vmo.nopcommerce.interfaces.HomePageUI;
import com.vmo.nopcommerce.interfaces.RegisterPageUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RegisterPageObject extends BasePage {
    WebDriver driver;

    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void chooseGender(WebDriver driver) {
        clickElement(driver, RegisterPageUI.LOCATOR_GENDER);
    }

    public void enterFirstName(WebDriver driver) {
        sendKeys(driver, RegisterPageUI.LOCATOR_FIRSTNAME, "Thom");
    }

    public void enterLastName(WebDriver driver) {
        sendKeys(driver, RegisterPageUI.LOCATOR_LASTNAME, "Ba");
    }

    public void chooseDay(WebDriver driver) {
        selectElement(driver, RegisterPageUI.LOCATOR_DAY, "8");
    }

    public void chooseMonth(WebDriver driver) {
        selectElement(driver, RegisterPageUI.LOCATOR_MONTH, "August");
    }

    public void chooseYear(WebDriver driver) {
        selectElement(driver, RegisterPageUI.LOCATOR_YEAR, "1998");
    }

    public void enterEmail(WebDriver driver) {
        sendKeys(driver, RegisterPageUI.LOCATOR_EMAIL, "thombt@vmogroup.com");
    }

    public void enterCompany(WebDriver driver) {
        sendKeys(driver, RegisterPageUI.LOCATOR_COMPANY, "VMO JAPAN");
    }

    public void enterPassword(WebDriver driver) {
        sendKeys(driver, RegisterPageUI.LOCATOR_PASSWORD, "Abc@1234");
    }

    public void enterConfirmPassword(WebDriver driver) {
        sendKeys(driver, RegisterPageUI.LOCATOR_CONFIRM_PASSWORD, "Abc@1234");
    }

    public void clickRegisterButton(WebDriver driver) {
        clickElement(driver, RegisterPageUI.LOCATOR_REGISTER_BUTTON);
    }

    public String getTextOfNofify() {
        return getText(driver, RegisterPageUI.LOCATOR_MESSAGE_REGISTER_SUCCESS) ;
    }

}
