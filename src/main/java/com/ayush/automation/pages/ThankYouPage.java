package com.ayush.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ayush.automation.utils.WaitUtils;

public class ThankYouPage {

    private WebDriver driver;

    // Thank you message
    private By thankYouMessage =
        By.cssSelector(".hero-primary");

    public ThankYouPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyThankYouMessage() {

        // Ensure we are on thank you page
        WaitUtils.waitForUrlContains(driver, "thanks");

        // Wait for message to appear
        WaitUtils.waitForElementVisible(driver, thankYouMessage);

        String actualText =
            driver.findElement(thankYouMessage).getText().trim();

        System.out.println(">>> Thank You Message: " + actualText);

        // HARD assertion (fail test if not matched)
        Assert.assertEquals(
            actualText,
            "THANKYOU FOR THE ORDER.",
            "❌ Order confirmation message mismatch"
        );
    }
}
