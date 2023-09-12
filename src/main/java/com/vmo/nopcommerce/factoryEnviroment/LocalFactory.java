package com.vmo.nopcommerce.factoryEnviroment;

import com.vmo.nopcommerce.factoryBrowser.BrowserNotSupportedException;
import com.vmo.nopcommerce.factoryBrowser.ChromeDriverManager;
import com.vmo.nopcommerce.factoryBrowser.EdgeDriverManager;
import com.vmo.nopcommerce.factoryBrowser.FireFoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocalFactory {
    private WebDriver driver;

    public WebDriver createDriver(String browser) {
        browser = browser.toUpperCase();
        switch (browser) {
            case "CHROME":
                driver = new ChromeDriverManager().getBrowserDriver();
                break;
            case "FIREFOX":
                driver = new FireFoxDriverManager().getBrowserDriver();
                break;
            case "EDGE":
                driver = new EdgeDriverManager().getBrowserDriver();
                break;
            default:
                throw new BrowserNotSupportedException(browser);
        }
        return driver;
    }
}
