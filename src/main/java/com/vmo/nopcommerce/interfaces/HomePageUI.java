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
    public static String LOCATOR_NO_RESULT ="//div[@class='no-result']";
    public static final String LOCATOR_COMPUTER_MENU = "(//div[@class='header-menu']//a)[1]";
    public static final String LOCATOR_SOFTWARE_MENU = "(//ul[@class='sublist']//li//a)[3]";
    public static final String LOCATOR_SOFTWARE_TITLE = "//div[@class='page-title']/h1";
    public static final String LOCATOR_SELECT_PRODUCT_SORT_ORDER = "//select[@id='products-orderby']";
    public static final String SELECT_OPTION = "Name: Z to A";

}
