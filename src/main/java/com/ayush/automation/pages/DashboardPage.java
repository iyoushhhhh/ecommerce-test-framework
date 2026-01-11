package com.ayush.automation.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ayush.automation.utils.WaitUtils;

public class DashboardPage {

    private WebDriver driver;

    private By productCards = By.cssSelector(".card-body");
    private By productName = By.cssSelector("b");
    private By addToCartButton = By.cssSelector("button:last-of-type");
    private By toastMessage = By.cssSelector("#toast-container");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    // ✅ Print all product names visible on dashboard
    public void printAllProductsName() {

        WaitUtils.waitForElementVisible(driver, productCards);
        List<WebElement> products = driver.findElements(productCards);

        System.out.println("Total products found: " + products.size());

        for (WebElement product : products) {
            String name = product.findElement(productName).getText();
            System.out.println(name);
        }
    }

    // ✅ Add specific products to cart and wait for toast
    public void addProductsToCart(String... requiredProducts) {

        List<String> productsNeeded = Arrays.asList(requiredProducts);

        WaitUtils.waitForElementVisible(driver, productCards);
        List<WebElement> products = driver.findElements(productCards);

        for (WebElement product : products) {

            String name = product.findElement(productName).getText();

            if (productsNeeded.contains(name)) {

                product.findElement(addToCartButton).click();
                System.out.println("Added to cart: " + name);

                // Wait for toast to disappear before next click
                WaitUtils.waitForToastToDisappear(driver, toastMessage);
            }
        }
    }
}
