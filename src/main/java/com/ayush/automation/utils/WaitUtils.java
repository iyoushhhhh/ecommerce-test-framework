package com.ayush.automation.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

    public static void waitForElementVisible(WebDriver driver, By locator) {
        WebDriverWait wait =
            new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitForUrlContains(WebDriver driver, String text) {
        WebDriverWait wait =
            new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlContains(text));
    }
    
    public static void waitForElementToDisappear(WebDriver driver, By locator) {
        WebDriverWait wait =
            new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
    
    public static void waitForToastToDisappear(WebDriver driver, By toastLocator) {
        WebDriverWait wait =
            new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(toastLocator));
    }
    
    public static void waitForElementToBeClickable(WebDriver driver, By locator) {
        WebDriverWait wait =
            new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }



}
