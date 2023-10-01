package com.vmo.nopcommerce.factoryBrowser.GridDriverManager;

import com.vmo.nopcommerce.common.GlobalConstants;
import com.vmo.nopcommerce.factoryBrowser.BrowserFactory;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;

public class ChromeGridDriverManager implements BrowserFactory {
    @Override
    public WebDriver getBrowserDriver() {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("browserName", "chrome");
        options.setCapability("browserVersion", "117.0.5938.132");
        options.setCapability("platformName", "Windows 11");
        options.setCapability("se:name", "My simple test");
        options.setCapability("se:sampleMetadata", "Sample metadata value");
        try {
            return new RemoteWebDriver(new URL(GlobalConstants.HUB_URL), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }
}
