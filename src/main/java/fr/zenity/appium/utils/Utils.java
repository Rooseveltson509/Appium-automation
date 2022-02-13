package fr.zenity.appium.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Utils {
    public static AppiumDriver<MobileElement> driver;

    @Attachment(value = "Screenshot after {name}", type = "image/png")
    public static byte[] takeScreenShot(String methodName) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
