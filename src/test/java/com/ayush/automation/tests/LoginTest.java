package com.ayush.automation.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ayush.automation.base.BaseTest;
import com.ayush.automation.config.ConfigReader;
import com.ayush.automation.pages.CartPage;
import com.ayush.automation.pages.DashboardPage;
import com.ayush.automation.pages.LoginPage;
import com.ayush.automation.pages.PaymentPage;
import com.ayush.automation.pages.ThankYouPage;

@Listeners(com.ayush.automation.listeners.TestListener.class)
public class LoginTest extends BaseTest {

    ConfigReader config;

    @BeforeMethod(alwaysRun = true)
    public void setup() {

        System.out.println(">>> SETUP STARTED");

        config = new ConfigReader();
        System.out.println(">>> CONFIG LOADED");

        String url = config.getProperty("url");
        System.out.println(">>> URL = " + url);

        launchApplication(url);
        System.out.println(">>> BROWSER LAUNCHED");
    }

    @Test(groups = "smoke")
    public void loginAndGetAllProductsTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(
                config.getProperty("username"),
                config.getProperty("password")
        );

        DashboardPage dashboard = new DashboardPage(driver);
        dashboard.printAllProductsName();
    }
    
   

    @Test(groups ="regression")
    public void loginAndAddSpecificProductsToCart() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(
                config.getProperty("username"),
                config.getProperty("password")
        );

        DashboardPage dashboard = new DashboardPage(driver);
        dashboard.addProductsToCart(
                "IPHONE 13 PRO",
                "ADIDAS ORIGINAL"
        );
    }

    // ✅ ADD THIS METHOD HERE
    @Test(groups = "e2e")
    public void endToEndCheckoutFlow() {

        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(
                config.getProperty("username"),
                config.getProperty("password")
        );

        // Dashboard
        DashboardPage dashboard = new DashboardPage(driver);
        dashboard.addProductsToCart(
                "IPHONE 13 PRO",
                "ADIDAS ORIGINAL"
        );

        // Cart
        CartPage cart = new CartPage(driver);
        cart.goToCart();
        cart.clickCheckout();
        
        PaymentPage payment = new PaymentPage(driver);
        payment.selectCountry();
        payment.placeOrder();

        ThankYouPage thankYou = new ThankYouPage(driver);
        thankYou.verifyThankYouMessage();

    }

}
