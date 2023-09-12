package com.vmo.nopcommerce.factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FireFoxHeadlessDriverManager implements BrowserFactory{
    @Override
    public WebDriver getBrowserDriver() {
        FirefoxBinary firefoxBinary = new FirefoxBinary();
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary(firefoxBinary);
        options.setHeadless(true);  // <-- headless set here
        WebDriver driver = new FirefoxDriver(options);
        return driver;
    }
}
