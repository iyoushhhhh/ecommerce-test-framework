package com.ayush.automation.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.openqa.selenium.*;

public class ScreenshotUtil {

    public static String captureScreenshot(WebDriver driver, String testName) {

        File src = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        String path =
            System.getProperty("user.dir")
            + "/screenshots/"
            + testName + ".png";

        try {
            File dest = new File(path);
            dest.getParentFile().mkdirs();
            Files.copy(src.toPath(), dest.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }
}
