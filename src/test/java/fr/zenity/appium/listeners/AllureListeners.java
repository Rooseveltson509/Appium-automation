package fr.zenity.appium.listeners;

import fr.zenity.appium.drivers.MobileDriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;
import java.util.UUID;

public class AllureListeners implements ITestListener {
    protected AppiumDriver<MobileElement> driver;
    public void onTestStart(ITestContext iTestContext) {
        System.out.println("I am on start method "+ iTestContext.getName());
        iTestContext.setAttribute("Driver", MobileDriverManager.getInstance().getDriver());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("I am on start method "+ getTestMethodName(result));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("I am on testFailure method " + getTestMethodName(result)+" failed");
        if(ITestResult.FAILURE == result.getStatus()){
            saveFailureScreenShot(driver);
            System.out.println("SCREENSHOT TAKEN.........");
            Allure.addAttachment("Any text", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
            Allure.addAttachment(UUID.randomUUID().toString(), new ByteArrayInputStream(((TakesScreenshot)MobileDriverManager.getInstance().getDriver()).getScreenshotAs(OutputType.BYTES)));
            //Assert.fail("ERROR");
            System.out.println("SCREENSHOT TAKEN");
            System.out.println("<<<<<<<<<<<<<< "+ITestResult.SUCCESS+" >>>>>>>>>>>>>>");
        }

        //Object testClass = result.getInstance();
        //ITestContext context = result.getTestContext();
        //WebDriver driver = (WebDriver) context.getAttribute("driver");
       /* AndroidDriver<MobileElement> driver = (AndroidDriver<MobileElement>) MobileDriverManager.getInstance().getDriver();
        if (driver != null) {
            System.out.println("Screenshot captured for test case: "+getTestMethodName(result));
            saveFailureScreenShot(driver);
        }
        saveTextLog(getTestMethodName(result) + "failed and screenshot taken!")*/;
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("I am on test skipped method "+getTestMethodName(result)+" skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
    }

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext context) {
    }

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    // Screenshot attachments for allure
    @Attachment(value ="page screenshot", type = "image/png")
    public byte[] saveFailureScreenShot(AppiumDriver<MobileElement> driver) {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    // Text attachments for allure
    @Attachment(value= "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    //HTML attachments for allure
    @Attachment(value= "{0}", type = "text/html")
    public static String attachHtml(String html) {
        return html;
    }
}