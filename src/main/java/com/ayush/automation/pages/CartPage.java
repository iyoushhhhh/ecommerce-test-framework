package com.ayush.automation.pages;

import org.openqa.selenium.*;
import com.ayush.automation.utils.WaitUtils;

public class CartPage {

    private WebDriver driver;

    private By cartIcon =
        By.cssSelector("button[routerlink*='cart'], a[routerlink*='cart']");

    private By spinnerOverlay =
        By.cssSelector(".ngx-spinner-overlay");

    private By checkoutButton =
        By.cssSelector(".cartSection button.btn-primary");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToCart() {

        WaitUtils.waitForElementToDisappear(driver, spinnerOverlay);

        WaitUtils.waitForElementToBeClickable(driver, cartIcon);
        driver.findElement(cartIcon).click();

        // HARD proof we reached cart page
        WaitUtils.waitForUrlContains(driver, "cart");

        WaitUtils.waitForElementToDisappear(driver, spinnerOverlay);
    }

    public void clickCheckout() {

        // PROVE checkout button exists on cart page
        WaitUtils.waitForElementVisible(driver, checkoutButton);

        WebElement checkout = driver.findElement(checkoutButton);

        // Scroll into view
        ((JavascriptExecutor) driver)
            .executeScript("arguments[0].scrollIntoView({block:'center'});", checkout);

        WaitUtils.waitForElementToBeClickable(driver, checkoutButton);

        // FINAL reliable click
        checkout.click();

        // NOW order page must load
        WaitUtils.waitForUrlContains(driver, "order");

        WaitUtils.waitForElementToDisappear(driver, spinnerOverlay);
    }
}
