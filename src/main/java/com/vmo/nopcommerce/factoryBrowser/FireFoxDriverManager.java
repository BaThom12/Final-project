package com.vmo.nopcommerce.factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Collections;

public class FireFoxDriverManager implements BrowserFactory{
    @Override
    public WebDriver getBrowserDriver() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-geolocation");
        options.addArguments("--incognito");
        return new FirefoxDriver(options);
    }
}
