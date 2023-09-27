package com.vmo.sauce.interfaces;

public class LoginPageUI {
    public static final String SAUCE_URL = "https://www.saucedemo.com/";
    public static final String LOCATOR_USERNAME_TEXTBOX = "//input[@id='user-name']";
    public static final String LOCATOR_PASSWORD_TEXTBOX = "//input[@id='password']";
    public static final String LOCATOR_LOGIN_BUTTON = "//input[@id='login-button']";
    public static final String SAUCE_HOME_URL = "https://www.saucedemo.com/inventory.html";
    public static final String LOCATOR_ERROR_MESSAGE = "//div[@class='error-message-container error']/h3";
    public static final String USERNAME_REQUIRED_ERROR_MESSAGE = "Epic sadface: Username is required";
    public static final String PASSWORD_REQUIRED_ERROR_MESSAGE = "Epic sadface: Password is required";
    public static final String ERROR_MESSAGE = "Epic sadface: Username and password do not match any user in this service";

}
