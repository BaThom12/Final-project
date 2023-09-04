package com.vmo.nopcommerce.interfaces;

public class LoginPageUI {
    public static final String LOCATOR_FORGOT_PASSWORD_lABEL = "//span[@class='forgot-password']//a";
    public static final String LOCATOR_EMAIL_TEXTBOX = "//input[@id='Email']";
    public static final String LOCATOR_RECOVER_BUTTON = "//button[@name='send-email']";
    public static final String PASSWORD_RECOVER_TITLE = "nopCommerce demo store. Password Recovery";
    public static final String LOGIN_TITLE = "nopCommerce demo store. Login";
    public static final String FORGOT_TITLE = "Email with instructions has been sent to you.";
    public static final String LOCATOR_NOFICATION_TITLE = "//div[@class='bar-notification success']/p";
    public static final String GMAIL_URL = "https://accounts.google.com/InteractiveLogin/identifier?continue"+
                                           "=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&emr=1&followup=https%3A%2F%2"
                                           +"Fmail.google.com%2Fmail%2Fu%2F0%2F&osid=1&passive=1209600&service=mail&ifkv="
                                           +"AXo7B7V9K1EXzHsbpJhbxp7B7a0SFT2L103KQ6X4oSrfdgnTZIwfHpfqLpvnK_YvSwh7L5yVmnAUOw&theme"
                                           +"=glif&flowName=GlifWebSignIn&flowEntry=ServiceLogin";

    public static final String LOCATOR_EMAIL_ID_TEXTBOX = "//input[@id='identifierId']";
    public static final String LOCATOR_NEXT_BUTTON = "//*[@id ='identifierNext']";
    public static final String LOCATOR_PASSWORD_TEXTBOX = "//*[@id ='password']/div[1]/div / div[1]/input";
    public static final String LOCATOR_PASSWORD_NEXT_BUTTON = "//*[@id ='passwordNext']";

}
