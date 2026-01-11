package com.ayush.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ayush.automation.utils.WaitUtils;

public class LoginPage {

    private WebDriver driver;

    private By email = By.id("userEmail");
    private By password = By.id("userPassword");
    private By loginButton = By.id("login");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String user, String pass) {
        WaitUtils.waitForElementVisible(driver, email);
        driver.findElement(email).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginButton).click();
    }
}
