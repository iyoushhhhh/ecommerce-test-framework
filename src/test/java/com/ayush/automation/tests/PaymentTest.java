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
public class PaymentTest extends BaseTest {

    ConfigReader config;

    @BeforeMethod
    public void setup() {

        System.out.println(">>> PAYMENT TEST SETUP STARTED");

        config = new ConfigReader();
        launchApplication(config.getProperty("url"));
    }

    @Test
    public void paymentFlowTest() {

        // 1️⃣ Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(
                config.getProperty("username"),
                config.getProperty("password")
        );

        // 2️⃣ Add products
        DashboardPage dashboard = new DashboardPage(driver);
        dashboard.addProductsToCart(
                "IPHONE 13 PRO",
                "ADIDAS ORIGINAL"
        );

        // 3️⃣ Go to Cart and Checkout
        CartPage cart = new CartPage(driver);
        cart.goToCart();
        cart.clickCheckout(); // must land on order page

        // 4️⃣ Payment page actions
        PaymentPage payment = new PaymentPage(driver);
        payment.selectCountry();   // sends "Ind" and selects India
        payment.placeOrder();
        
        ThankYouPage thankYou = new ThankYouPage(driver);
        thankYou.verifyThankYouMessage();
    }
}
