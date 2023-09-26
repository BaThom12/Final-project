package com.vmo.sauce.login;

import com.vmo.nopcommerce.common.BaseTest;
import com.vmo.nopcommerce.helper.TestNGListener;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;

@Epic("Sauce")
@Feature("Login")
@Story("Login unsuccessful")
@Listeners(TestNGListener.class)
public class LoginUnSuccessful extends BaseTest {
}
