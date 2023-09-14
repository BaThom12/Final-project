package com.vmo.nopcommerce.product;

import com.vmo.nopcommerce.common.BaseTest;
import com.vmo.nopcommerce.helper.Log;
import com.vmo.nopcommerce.helper.TestNGListener;
import com.vmo.nopcommerce.interfaces.HomePageUI;
import com.vmo.nopcommerce.pageobject.HomePageObject;
import com.vmo.nopcommerce.pageobject.RegisterPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
@Listeners(TestNGListener.class)
public class ProductSearchSortTest extends BaseTest {
    private static WebDriver driver;
    private HomePageObject home;
    private RegisterPageObject register;

    @Parameters("browser")
    @BeforeMethod
    public void setup(@Optional("CHROME") String browser) {
        driver = getDriverBrowser(browser);
        driver.manage().window().maximize();
        Log.info("Open browser");
        driver.get(HomePageUI.HOME_URL);
        Log.info("Open Home of Nopcommer");
    }


    @Test
    public void Product_TC02_Search() {
        verifyOnHome();
        home.sendKeyToElementOnHomePage(driver, HomePageUI.LOCATOR_SEARCH_TEXTBOX, HomePageUI.KEY_SEARCH_1);
        Log.info("Sendkey on Search textbox is succeed");
        home.clickToElementOnHomePage(driver, HomePageUI.LOCATOR_SEARCH_BUTTON);
        Log.info("Click on search button is succeed");
        String resultSearch = home.performSearchHasResult(driver, HomePageUI.LOCATOR_LIST_PRODUCT, HomePageUI.KEY_SEARCH_1);
        verifyTrue(resultSearch.contains(HomePageUI.KEY_SEARCH_1));
        Log.info("Verify product's name contains keyword is succeed");
        home.sendKeyToElementOnHomePage(driver, HomePageUI.LOCATOR_SEARCH_TEXTBOX, HomePageUI.KEY_SEARCH_2);
        home.clickToElementOnHomePage(driver, HomePageUI.LOCATOR_SEARCH_BUTTON);
        resultSearch = home.performSearchNoResult(driver, HomePageUI.LOCATOR_NO_RESULT);
        verifyTrue(resultSearch.contains("No products"));
        Log.info("Verify message(No products were found that matched your criteria.) is displayed");
    }

    @Test
    public void Product_TC03_Sort() throws InterruptedException {
        verifyOnHome();
        home.clickToElementOnHomePage(driver, HomePageUI.LOCATOR_COMPUTER_MENU);
        home.clickToElementOnHomePage(driver, HomePageUI.LOCATOR_SOFTWARE_MENU);
        verifyEquals(home.getTextElementOfHomePage(driver, HomePageUI.LOCATOR_SOFTWARE_TITLE), "Software");
        Log.info("Verify that you are on the software page is succeed");
        boolean resultOrder = home.isListSort(driver, HomePageUI.LOCATOR_LIST_PRODUCT, HomePageUI.LOCATOR_SELECT_PRODUCT_SORT_ORDER, HomePageUI.SELECT_OPTION);
        verifyEquals(home.optionValue, HomePageUI.SELECT_OPTION);
        Log.info("Verify the sort option appear on the screen is succeed");
        verifyTrue(resultOrder);
        Log.info("Verify the sort function works correctly");
    }

    @Test
    public void Product_TC05_AddComment() {
        verifyOnHome();
        String titleOfNews = home.getTextElementOfHomePage(driver, HomePageUI.LOCATOR_NEWS_TITLE);
        Log.info("Title of news %s",titleOfNews);
        home.clickToElementOnHomePage(driver, HomePageUI.LOCATOR_NEWS_TITLE);
        verifyEquals(titleOfNews, home.getTextElementOfHomePage(driver, HomePageUI.LOCATOR_NEWS_DETAIL_TITLE));
        Log.info("Verify that you are on the article chosen is succeed");
        home.sendKeyToElementOnHomePage(driver, HomePageUI.LOCATOR_TITLE_COMMENT, HomePageUI.TITLE_COMMENT);
        home.sendKeyToElementOnHomePage(driver, HomePageUI.LOCATOR_CONTENT_COMMENT, HomePageUI.CONTENT_COMMENT);
        home.clickToElementOnHomePage(driver, HomePageUI.LOCATOR_ADD_COMMENT_BUTTON);
        verifyEquals(home.getTextElementOfHomePage(driver, HomePageUI.LOCATOR_MESSAGE_ADD_COMMENT_SUCCESS), HomePageUI.MESSAGE_ADD_COMMENT_SUCCESS);
        Log.info("Verify the message (News comment is successfully added.) is displayed");
        verifyTrue(home.isCommentAdded(driver, HomePageUI.LOCATOR_DETAIL_TITLE_COMMENT, HomePageUI.TITLE_COMMENT, HomePageUI.LOCATOR_DETAIL_CONTENT_COMMENT, HomePageUI.CONTENT_COMMENT));
        Log.info("Verify the new comment has added");
    }

    @Test
    public void Product_TC06_ChangeExchange() {
        verifyOnHome();
        home.selectExchange(driver, HomePageUI.LOCATOR_EXCHANGE, "Euro");
        verifyEquals(home.getOptionOfSelect(driver, HomePageUI.LOCATOR_EXCHANGE), "Euro");
        Log.info("Verify that the label of the chosen currency is displayed on screen");
        verifyTrue(home.isExchangeDisplayed(driver, HomePageUI.EXCHANGE, "Euro"));
        Log.info("Verify the prices start with the symbol of the currency is displayed on screen");
    }

    @Test
    public void Product_TC07_OpenSocial() {
        verifyOnHome();
        String title = home.openSocial(driver, HomePageUI.SOCIAL, HomePageUI.FORM_FB, home.getParentId(driver));
        verifyEquals(title, "NopCommerce | Facebook");
        Log.info("Verify that the new tab shows correctly with the title of the chosen social media");
    }

    public void verifyOnHome() {
        home = new HomePageObject(driver);
        verifyEquals(home.getUrlHomePage(driver), HomePageUI.HOME_URL);
        Log.info("Verify that you are on the home page is succeed");
    }

    @AfterMethod
    public void tearDown() {
        cleanBrowserAndDriver();
        Log.info("Verify that clean browser and driver are succeed");
    }
}
