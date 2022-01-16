package fr.zenity.appium.PageObjects;

import fr.zenity.appium.drivers.MobileDriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class View {


    protected AppiumDriver<MobileElement> driver;

    protected WebDriverWait wait;
    protected WebDriverWait shortWait;
    protected WebDriverWait middleWait;
    protected WebDriverWait longWait;

    protected View (){
        driver = MobileDriverManager
                .getInstance()
                .getDriver()
                .getDriver();

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

        wait        = new WebDriverWait(driver, 5);
        shortWait   = new WebDriverWait(driver, 10);
        middleWait  = new WebDriverWait(driver, 20);
        longWait    = new WebDriverWait(driver, 6000);

    }



}
