package com.ayush.automation.pages;

//import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ayush.automation.utils.WaitUtils;

public class PaymentPage {

    private WebDriver driver;
//
//    private By countryInput =
//        By.cssSelector("input[placeholder='Select Country']");
//
//    private By countryResults =
//        By.cssSelector(".ta-results button");

    private By placeOrderButton =
        By.cssSelector(".action__submit");

//    private By spinnerOverlay =
//        By.cssSelector(".ngx-spinner-overlay");

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectCountry() {

        By countryInput = By.cssSelector("input[placeholder='Select Country']");
        By countryResults = By.cssSelector(".ta-results button");

        // Just wait for input to be usable
        WaitUtils.waitForElementVisible(driver, countryInput);

        driver.findElement(countryInput).sendKeys("Ind");

        WaitUtils.waitForElementVisible(driver, countryResults);

        for (WebElement option : driver.findElements(countryResults)) {
            if (option.getText().equalsIgnoreCase("India")) {
                option.click();
                break;
            }
        }
    }



    public void placeOrder() {

        // 5️⃣ Wait for Place Order button to be clickable
        WaitUtils.waitForElementToBeClickable(driver, placeOrderButton);

        driver.findElement(placeOrderButton).click();
    }
}
