package com.vmo.nopcommerce.pageobject;

import org.openqa.selenium.WebDriver;

public class PageGenerator {
    public static HomePageObject getHomePageObject(WebDriver driver){
        return new HomePageObject(driver);
    }
    public static ForgotPasswordPageObject getLoginPageObject(WebDriver driver){
        return new ForgotPasswordPageObject(driver);
    }
    public static RegisterPageObject getRegisterPageObject(WebDriver driver){
        return new RegisterPageObject(driver);
    }
}
