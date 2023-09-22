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
        Log.allure("Click on element success");
    }

    public void enterValueOnTextBoxOfRegisterPage(WebDriver driver,String locator,String textDynamic,String value) {
        sendKeyToElement(driver, getDynamiLocator(locator,textDynamic), value);
        Log.allure("Send key to textbox success");
    }
    public void chooseValueOfSelectOfRegisterPage(WebDriver driver,String locator,String textDynamic,String value) {
        selectItemInDefaultDropdownByText(driver,getDynamiLocator(locator,textDynamic),value);
        Log.allure("Choose value on select is success");
    }

    public String getTextOfNofify(WebDriver driver,String locator) {
        return getTextElement(driver, locator) ;
    }

}
