package com.saucedemo.testsuite;

import com.saucedemo.pages.HomePage;
import com.saucedemo.pages.Products;
import com.saucedemo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    HomePage homePage = new HomePage();
    Products products = new Products();

    @Test
    public void userShouldLoginSuccessfullyWithValid(){
        homePage.enterUserName("standard_user");
        homePage.enterPassword("secret_sauce");
        homePage.clickOnLoginButton();
        String actualMessage = products.verifyText();
        String exceptedMessage = "Products";
        Assert.assertEquals(exceptedMessage,actualMessage);
    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        homePage.enterUserName("standard_user");
        homePage.enterPassword("secret_sauce");
        homePage.clickOnLoginButton();
        int actualNumber = products.verifyProductList();
        int expectedNumber = 6;
        Assert.assertEquals(actualNumber,expectedNumber);
    }
}
