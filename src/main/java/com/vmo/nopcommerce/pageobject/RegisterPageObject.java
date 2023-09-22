package com.vmo.nopcommerce.pageobject;

import com.vmo.nopcommerce.common.BasePage;
import com.vmo.nopcommerce.helper.Log;
import com.vmo.nopcommerce.interfaces.RegisterPageUI;
import org.openqa.selenium.WebDriver;

public class RegisterPageObject extends BasePage {
    WebDriver driver;

    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToElementOfRegisterPage(WebDriver driver,String locator) {
        clickToElement(driver, locator);
        Log.allure("Click on button successful");
    }

    public void enterValueOnTextBoxOfRegisterPage(WebDriver driver,String locator,String textDynamic,String value) {
        sendKeyToElement(driver, getDynamiLocator(locator,textDynamic), value);
        Log.allure("Send key to text box value: %s",value);
    }
    public void chooseValueOfSelectOfRegisterPage(WebDriver driver,String locator,String textDynamic,String value) {
        selectItemInDefaultDropdownByText(driver,getDynamiLocator(locator,textDynamic),value);
        Log.allure("Select option: %s",value);
    }

    public String getTextOfNofify(WebDriver driver,String locator) {
        Log.allure("Register successful");
        return getTextElement(driver, locator);
    }

}
