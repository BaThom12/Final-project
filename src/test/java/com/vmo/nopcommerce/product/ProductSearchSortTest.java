package com.vmo.nopcommerce.product;

import com.vmo.nopcommerce.common.BaseTest;
import com.vmo.nopcommerce.interfaces.HomePageUI;
import com.vmo.nopcommerce.pageobject.HomePageObject;
import com.vmo.nopcommerce.pageobject.RegisterPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class ProductSearchSortTest extends BaseTest {
    private static WebDriver driver;
    private HomePageObject home;
    private RegisterPageObject register;

    @Parameters("browser")
    @BeforeMethod
    public void setup(@Optional("CHROME") String browser) {
       driver = getDriverBrowser(browser);
   // public void setup() {
    //    driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(HomePageUI.HOME_URL);
       // driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void Product_TC02_Search() {
        verifyOnHome();
        home.sendKeyToElementOnHomePage(driver, HomePageUI.LOCATOR_SEARCH_TEXTBOX, HomePageUI.KEY_SEARCH_1);
        home.clickToElementOnHomePage(driver, HomePageUI.LOCATOR_SEARCH_BUTTON);
        String resultSearch = home.performSearchHasResult(driver, HomePageUI.LOCATOR_LIST_PRODUCT, HomePageUI.KEY_SEARCH_1);
        verifyTrue(resultSearch.contains(HomePageUI.KEY_SEARCH_1));
        home.sendKeyToElementOnHomePage(driver, HomePageUI.LOCATOR_SEARCH_TEXTBOX, HomePageUI.KEY_SEARCH_2);
        home.clickToElementOnHomePage(driver, HomePageUI.LOCATOR_SEARCH_BUTTON);
        resultSearch = home.performSearchNoResult(driver, HomePageUI.LOCATOR_NO_RESULT);
        verifyTrue(resultSearch.contains("No products"));

    }

    @Test
    public void Product_TC03_Sort() throws InterruptedException {
        verifyOnHome();
        home.clickToElementOnHomePage(driver, HomePageUI.LOCATOR_COMPUTER_MENU);
        home.clickToElementOnHomePage(driver, HomePageUI.LOCATOR_SOFTWARE_MENU);
        boolean resultOrder = home.isListSort(driver, HomePageUI.LOCATOR_LIST_PRODUCT, HomePageUI.LOCATOR_SELECT_PRODUCT_SORT_ORDER, HomePageUI.SELECT_OPTION);
        verifyEquals(home.getTextElementOfHomePage(driver, HomePageUI.LOCATOR_SOFTWARE_TITLE), "Software");
        verifyEquals(home.optionValue, HomePageUI.SELECT_OPTION);
        verifyTrue(resultOrder);
    }

    @Test
    public void Product_TC05_AddComment() {
        verifyOnHome();
        String titleOfNews = home.getTextElementOfHomePage(driver, HomePageUI.LOCATOR_NEWS_TITLE);
        home.clickToElementOnHomePage(driver, HomePageUI.LOCATOR_NEWS_TITLE);
        verifyEquals(titleOfNews, home.getTextElementOfHomePage(driver, HomePageUI.LOCATOR_NEWS_DETAIL_TITLE));
        home.sendKeyToElementOnHomePage(driver, HomePageUI.LOCATOR_TITLE_COMMENT, HomePageUI.TITLE_COMMENT);
        home.sendKeyToElementOnHomePage(driver, HomePageUI.LOCATOR_CONTENT_COMMENT, HomePageUI.CONTENT_COMMENT);
        home.clickToElementOnHomePage(driver, HomePageUI.LOCATOR_ADD_COMMENT_BUTTON);
        verifyEquals(home.getTextElementOfHomePage(driver, HomePageUI.LOCATOR_MESSAGE_ADD_COMMENT_SUCCESS), HomePageUI.MESSAGE_ADD_COMMENT_SUCCESS);
        verifyTrue(home.isCommentAdded(driver,HomePageUI.LOCATOR_DETAIL_TITLE_COMMENT,HomePageUI.TITLE_COMMENT,HomePageUI.LOCATOR_DETAIL_CONTENT_COMMENT,HomePageUI.CONTENT_COMMENT));
    }
    @Test
    public void Product_TC06_ChangeExchange(){
        verifyOnHome();
        home.selectExchange(driver,HomePageUI.LOCATOR_EXCHANGE,"Euro");
        verifyEquals(home.getOptionOfSelect(driver,HomePageUI.LOCATOR_EXCHANGE),"Euro");
        verifyTrue(home.isExchangeDisplayed(driver,HomePageUI.EXCHANGE,"Euro"));
    }

    @Test
    public void Product_TC07_OpenSocial() {
        verifyOnHome();
        String title = home.openSocial(driver,HomePageUI.SOCIAL, HomePageUI.FORM_FB, home.getParentId(driver));
        verifyEquals(title,"NopCommerce | Facebook");
    }

    public void verifyOnHome() {
        home = new HomePageObject(driver);
        verifyEquals(home.getUrlHomePage(driver), HomePageUI.HOME_URL);
    }

    @AfterMethod
    public void tearDown() {
        cleanBrowserAndDriver();
    }
}
