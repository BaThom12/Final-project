package com.vmo.nopcommerce.interfaces;

import org.openqa.selenium.WebDriver;

public class HomePageUI {

    public static final String HOME_URL = "https://demo.nopcommerce.com/";
    public static final String LOCATOR_REGISTER_lABEL = "(//div[@class='header-links']//a)[1]";
    public static final String LOCATOR_LOGIN_lABEL = "(//div[@class='header-links']//a)[2]";
    public static final String LOCATOR_SEARCH_TEXTBOX = "//input[@id='small-searchterms']";
    public static final String LOCATOR_SEARCH_BUTTON = "//input[@id='small-searchterms']/..//button";
    public static final String LOCATOR_LIST_PRODUCT = "//div[@class='product-grid']//div[@class='details']//a";
    public static final String KEY_SEARCH_1 = "Nokia";
    public static final String KEY_SEARCH_2 = "Samsung A12";
    public static final String LOCATOR_NEWS_TITLE = "(//div[@class='news-item']/div[@class='news-head']/a)[1]";
    public static final String LOCATOR_NEWS_DETAIL_TITLE = "//div[@class='page-title']/h1";
    public static final String LOCATOR_TITLE_COMMENT = "//input[@id='AddNewComment_CommentTitle']";
    public static final String LOCATOR_CONTENT_COMMENT = "//textarea[@id='AddNewComment_CommentText']";
    public static final String LOCATOR_ADD_COMMENT_BUTTON = "//button[@name='add-comment']";
    public static final String LOCATOR_MESSAGE_ADD_COMMENT_SUCCESS = "//div[@class='result']";
    public static final String MESSAGE_ADD_COMMENT_SUCCESS = "News comment is successfully added.";
    public static final String LOCATOR_DETAIL_TITLE_COMMENT = "//div[@class='comment-title']";
    public static final String TITLE_COMMENT = "comment 1";
    public static final String LOCATOR_DETAIL_CONTENT_COMMENT = "//div[@class='comment-body']/p";
    public static final String CONTENT_COMMENT = "The news is great!";
    public static final String LOCATOR_EXCHANGE = "//select[@id='customerCurrency']";
    public static final String EXCHANGE = "//div[@class='prices']/span";
    public static final String SOCIAL = "//li[@class='facebook']/a";

    public static final String FORM_FB = "//form[@id='login_popup_cta_form']";

    public static String LOCATOR_NO_RESULT ="//div[@class='no-result']";
    public static final String LOCATOR_COMPUTER_MENU = "(//div[@class='header-menu']//a)[1]";
    public static final String LOCATOR_SOFTWARE_MENU = "(//ul[@class='sublist']//li//a)[3]";
    public static final String LOCATOR_SOFTWARE_TITLE = "//div[@class='page-title']/h1";
    public static final String LOCATOR_SELECT_PRODUCT_SORT_ORDER = "//select[@id='products-orderby']";
    public static final String SELECT_OPTION = "Name: Z to A";

}
