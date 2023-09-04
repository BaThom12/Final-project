package com.vmo.nopcommerce.pageobject;

import com.vmo.nopcommerce.common.BasePage;
import com.vmo.nopcommerce.interfaces.HomePageUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Collections;
import java.util.List;

public class HomePageObject extends BasePage {
    WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToMenu(WebDriver driver) {
        clickElement(driver, HomePageUI.LOCATOR_REGISTER_lABEL);
    }

    public String performSearchHasResult(WebDriver driver,String keySearch) {
        sendKeys(driver, HomePageUI.LOCATOR_SEARCH_TEXTBOX, keySearch);
        clickElement(driver, HomePageUI.LOCATOR_SEARCH_BUTTON);
        List<String> listProduct = getList(driver, HomePageUI.LOCATOR_LIST_PRODUCT);
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

    public String performSearchNoResult(WebDriver driver,String keySearch) {
        sendKeys(driver, HomePageUI.LOCATOR_SEARCH_TEXTBOX, keySearch);
        clickElement(driver, HomePageUI.LOCATOR_SEARCH_BUTTON);
        String result = getText(driver, HomePageUI.LOCATOR_NO_RESULT);
        return result;
    }

    public String optionValue="";
    public boolean selectSortOption(WebDriver driver,String option) throws InterruptedException {
        clickElement(driver, HomePageUI.LOCATOR_COMPUTER_MENU);
        clickElement(driver, HomePageUI.LOCATOR_SOFTWARE_MENU);
        List<String> lstBeforeOrder = getList(driver, HomePageUI.LOCATOR_LIST_PRODUCT);
        Collections.sort(lstBeforeOrder, Collections.reverseOrder());
        Select selectOrder = new Select(driver.findElement(By.xpath(HomePageUI.LOCATOR_SELECT_PRODUCT_SORT_ORDER)));
        selectOrder.selectByVisibleText(HomePageUI.SELECT_OPTION);
        optionValue = selectOrder.getFirstSelectedOption().getText();
        Thread.sleep(3300);
        List<String> lstAfterOrder = getList(driver, HomePageUI.LOCATOR_LIST_PRODUCT);
        Boolean orderTrue = false;
        for (int i = 0; i < lstBeforeOrder.size(); i++) {
                if (lstBeforeOrder.get(i).toString().equals(lstAfterOrder.get(i).toString())) {
                    orderTrue = true;
                }
        }
        return orderTrue;
    }


}
