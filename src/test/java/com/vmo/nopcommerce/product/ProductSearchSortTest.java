package com.vmo.nopcommerce.product;

import com.vmo.nopcommerce.common.BaseTest;
import com.vmo.nopcommerce.interfaces.HomePageUI;
import com.vmo.nopcommerce.pageobject.HomePageObject;
import com.vmo.nopcommerce.pageobject.RegisterPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductSearchSortTest extends BaseTest {
    private static WebDriver driver;
    private HomePageObject home;
    private RegisterPageObject register;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(HomePageUI.HOME_URL);
    }
    @Test
    public void Product_TC02_Search() {
        home = new HomePageObject(driver);
        verifyEquals(home.getUrlHomePage(driver),HomePageUI.HOME_URL);
        String resultSearch = home.performSearchHasResult(driver,HomePageUI.KEY_SEARCH_1);
        verifyTrue(resultSearch.contains(HomePageUI.KEY_SEARCH_1));
        resultSearch = home.performSearchNoResult(driver,HomePageUI.KEY_SEARCH_2);
        verifyTrue(resultSearch.contains("No products"));

    }
    @Test
    public void Product_TC03_Sort() throws InterruptedException{
        home = new HomePageObject(driver);
        verifyEquals(home.getUrlHomePage(driver),HomePageUI.HOME_URL);
        boolean resultOrder = home.selectSortOption(driver,HomePageUI.SELECT_OPTION);
        verifyEquals(home.getText(driver,HomePageUI.LOCATOR_SOFTWARE_TITLE),"Software");
        verifyEquals(home.optionValue,HomePageUI.SELECT_OPTION);
        verifyTrue(resultOrder);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}