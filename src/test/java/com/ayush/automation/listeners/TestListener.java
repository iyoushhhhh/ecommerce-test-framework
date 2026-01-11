package com.ayush.automation.listeners;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("▶ STARTED: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("✅ PASSED: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("❌ FAILED: " + result.getName());

        Object testClass = result.getInstance();
        WebDriver driver = null;

        try {
            // 🔥 Fetch driver from BaseTest using reflection
            Field driverField =
                testClass.getClass().getSuperclass().getDeclaredField("driver");
            driverField.setAccessible(true);
            driver = (WebDriver) driverField.get(testClass);

            if (driver != null) {
                takeScreenshot(driver, result.getName());
            }
        } catch (Exception e) {
            System.out.println("⚠ Could not capture screenshot: " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("⚠ SKIPPED: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("🚀 TEST SUITE STARTED");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("🏁 TEST SUITE FINISHED");
    }

    // ---------- Utility ----------
    private void takeScreenshot(WebDriver driver, String testName)
            throws IOException {

        File src =
            ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        File dest = new File(
            System.getProperty("user.dir")
            + "/screenshots/"
            + testName + ".png"
        );

        dest.getParentFile().mkdirs();
        Files.copy(src.toPath(), dest.toPath());

        System.out.println("📸 Screenshot saved: " + dest.getAbsolutePath());
    }
}
