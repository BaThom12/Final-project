package com.vmo.nopcommerce.common;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

// dung cho cac action
public class BasePage {
    private static int LONG_TIMEOUT = 30;

    protected WebElement findElement(WebDriver driver, String locator) {
        return driver.findElement(By.xpath(locator));
    }

    public WebDriverWait waitElement(WebDriver driver, int timeout) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    protected void sendKeys(WebDriver driver, String locator, String value) {
        waitElement(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        findElement(driver, locator).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        findElement(driver, locator).sendKeys(value);

    }

    protected void clickElement(WebDriver driver, String locator) {
        waitElement(driver, 30).until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
        findElement(driver, locator).click();
    }

    protected void selectElement(WebDriver driver, String locator,String value) {
        waitElement(driver, 30).until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
        Select select = new Select(driver.findElement(By.xpath(locator)));
        select.selectByVisibleText(value);
    }

    protected List<String> getList(WebDriver driver, String locator){
        waitElement(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        List<WebElement> listSearch =driver.findElements(By.xpath(locator));
        List<String> listNameProduct = new ArrayList<>();
        for (WebElement childElement : listSearch) {
            listNameProduct.add(childElement.getText());
        }
        return listNameProduct;
    }

    public String getText(WebDriver driver, String locator){
        return driver.findElement(By.xpath(locator)).getText();
    }
    protected String getUrl(WebDriver driver){
        return driver.getCurrentUrl();
    }
    protected String getTitle(WebDriver driver){
        return driver.getTitle();
    }



}
