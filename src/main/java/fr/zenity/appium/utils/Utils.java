package fr.zenity.appium.utils;

import fr.zenity.appium.drivers.MobileDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.qameta.allure.Attachment;

public class Utils {

    @Attachment(value = "Screenshot after {name}", type = "image/png")
    public static byte[] takeScreenShot(String methodName) {
        return ((TakesScreenshot) MobileDriverManager.getInstance().getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
