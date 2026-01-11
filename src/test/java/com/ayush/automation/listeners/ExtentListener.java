package com.ayush.automation.listeners;

import java.lang.reflect.Field;

import org.openqa.selenium.WebDriver;
import org.testng.*;

import com.aventstack.extentreports.*;
import com.ayush.automation.reports.*;
import com.ayush.automation.utils.ScreenshotUtil;

public class ExtentListener implements ITestListener {

    private ExtentReports extent = ExtentManager.getInstance();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test =
            extent.createTest(result.getMethod().getMethodName());
        ExtentTestManager.setTest(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTestManager.getTest()
            .log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        ExtentTest test = ExtentTestManager.getTest();
        test.log(Status.FAIL, result.getThrowable());

        WebDriver driver = getDriver(result);

        if (driver != null) {
            String screenshotPath =
                ScreenshotUtil.captureScreenshot(
                    driver, result.getMethod().getMethodName());

            test.addScreenCaptureFromPath(screenshotPath);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTestManager.getTest()
            .log(Status.SKIP, "Test skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

    // 🔥 Fetch driver from BaseTest
    private WebDriver getDriver(ITestResult result) {
        try {
            Object testClass = result.getInstance();
            Field driverField =
                testClass.getClass()
                         .getSuperclass()
                         .getDeclaredField("driver");
            driverField.setAccessible(true);
            return (WebDriver) driverField.get(testClass);
        } catch (Exception e) {
            return null;
        }
    }
}
