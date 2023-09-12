package com.vmo.nopcommerce.pageobject;

import com.vmo.nopcommerce.common.BasePage;
import com.vmo.nopcommerce.interfaces.HomePageUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class HomePageObject extends BasePage {
    WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToElementOnHomePage(WebDriver driver, String locator) {
        clickToElement(driver, locator);
    }

    public void sendKeyToElementOnHomePage(WebDriver driver, String locator, String value) {
        sendKeyToElement(driver, locator, value);
    }

    public String performSearchHasResult(WebDriver driver, String locator, String keySearch) {
        List<String> listProduct = getListTextElements(driver, locator);
        int numberProductContainKeySearch = 0;
        for (int i = 0; i < listProduct.size(); i++) {
            if (listProduct.get(i).contains(keySearch)) {
                numberProductContainKeySearch += 1;
            }
        }
        String result = "";
        if (numberProductContainKeySearch == listProduct.size()) {
            result = "Product's name contain:" + keySearch;
        } else {
            result = "Opp! Wrong result";
        }
        return result;
    }

    public String performSearchNoResult(WebDriver driver, String locator) {
        String result = getTextElement(driver, locator);
        return result;
    }

    public String optionValue = "";

    public boolean isListSort(WebDriver driver, String locatorList, String locatorSelect, String option) throws InterruptedException {
        List<String> lstBeforeOrder = getListTextElements(driver, locatorList);
        Collections.sort(lstBeforeOrder, Collections.reverseOrder());
        Select selectOrder = new Select(driver.findElement(By.xpath(locatorSelect)));
        selectOrder.selectByVisibleText(option);
        optionValue = selectOrder.getFirstSelectedOption().getText();
        Thread.sleep(3300);
        List<String> lstAfterOrder = getListTextElements(driver, locatorList);
        Boolean orderTrue = false;
        for (int i = 0; i < lstBeforeOrder.size(); i++) {
            if (lstBeforeOrder.get(i).toString().equals(lstAfterOrder.get(i).toString())) {
                orderTrue = true;
            }
        }
        return orderTrue;
    }

    public boolean isCommentAdded(WebDriver driver, String locatorTitleComment, String tiltleComment, String locatorContentComment, String contentComment) {
        boolean isCommentDisplayed = false;
        boolean isTitleCommentDisplayed = false;
        List<String> lstTitleComment = getListTextElements(driver, locatorTitleComment);
        for (int i = 0; i < lstTitleComment.size(); i++) {
            if (lstTitleComment.get(i).toString().equals(tiltleComment)) {
                isTitleCommentDisplayed = true;
            }
        }
        boolean isContentCommentDisplayed = false;
        List<String> lstContentComment = getListTextElements(driver, locatorContentComment);
        for (int i = 0; i < lstContentComment.size(); i++) {
            if (lstContentComment.get(i).toString().equals(contentComment)) {
                isContentCommentDisplayed = true;
            }
        }
        isCommentDisplayed = isTitleCommentDisplayed & isContentCommentDisplayed;
        return isCommentDisplayed;
    }

    public void selectExchange(WebDriver driver, String locatorSelect, String option) {
        selectItemInDefaultDropdownByText(driver,locatorSelect,option);
    }
    public String getOptionOfSelect(WebDriver driver,String locator){
        return getSelectedItemInDefaultDropdown(driver, locator);
    }

    public boolean isExchangeDisplayed(WebDriver driver, String locatorPrice, String exchange) {
        List<String> listPrice = getListTextElements(driver, locatorPrice);
        List<String> listExchange = new ArrayList<>();
        for (int i = 0; i < listPrice.size(); i++) {
            listExchange.add(String.valueOf(listPrice.get(i).charAt(0)));
        }
        boolean exchangeDisplayed = false;
        switch (exchange) {
            case "Euro":
                exchangeDisplayed = checkDisplay(listExchange, "€");
                break;
            default:
                exchangeDisplayed = checkDisplay(listExchange, "$");
                break;
        }
        return exchangeDisplayed;

    }

    private boolean checkDisplay(List<String> lstexchange, String exchange) {
        boolean result = false;
        for (int i = 0; i < lstexchange.size(); i++) {
            if (lstexchange.get(i).toString().equals(exchange)) {
                result = true;
            } else {
                result = false;
            }
        }
        return result;
    }

    public String getParentId(WebDriver driver){
        return driver.getWindowHandle();
    }

    public String openSocial(WebDriver driver, String locator, String locatorInSocial, String parentID) {
        scrollToBottomPage(driver);
        clickToElementOnHomePage(driver, locator);
        switchWindowByID(driver, parentID);
        waitForElementVisible(driver, locatorInSocial);
        String title = getTitlePage(driver);
        return title;
    }

    public String getTitlePage(WebDriver driver) {
        return getTitle(driver);
    }

    public String getUrlHomePage(WebDriver driver) {
        return getCurrentUrl(driver);
    }

    public String getTextElementOfHomePage(WebDriver driver, String locator) {
        return getTextElement(driver, locator);
    }


}
