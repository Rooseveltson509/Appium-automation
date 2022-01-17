package fr.zenity.appium.PageObjects;

import fr.zenity.appium.Enum.Direction;
import fr.zenity.appium.drivers.MobileDriverManager;
import fr.zenity.appium.drivers.utils.Waiter;
import io.appium.java_client.*;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;


public class RegisterView extends View{

    @AndroidFindBy(xpath="//android.widget.Button[1]")
    private MobileElement isOK;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"S'inscrire\"]")
    private MobileElement registerButton;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='2']")
    private MobileElement emailInput;

    @AndroidFindBy(xpath = "//android.widget.EditText[@index='3']")
    private MobileElement pwd;

    @AndroidFindBy(xpath = "//android.widget.EditText[@index='4']")
    private MobileElement cPwd;

    @AndroidFindBy(xpath = "//android.widget.Button[@index='5']")
    private MobileElement btnSubscribe;

    @AndroidFindBy(xpath = "//android.widget.Button[@index='3']")
    private MobileElement gotoWebSite;

    @AndroidFindBy(xpath = "//android.view.View[@index='2']")
    private MobileElement imConnected;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='3']")
    private MobileElement avatarAccount;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='5']")
    private MobileElement logOutBtn;


    public boolean applicationOk(){
        longWait.until(visibilityOf(isOK));
        return true;
    }

    public void clickOnContinue(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        isOK.click();
        //shortWait.until(elementToBeClickable(isOK)).click();
    }

    public void clickOnRegistered(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        registerButton.click();
        //shortWait.until(elementToBeClickable(registerButton)).click();
    }


    public void register(String mailto, String password, String cPassword) {
        wait.until(ExpectedConditions.visibilityOf(emailInput));
        emailInput.click();
        wait.until(ExpectedConditions.visibilityOf(emailInput));
        emailInput.sendKeys(mailto);
        wait.until(ExpectedConditions.visibilityOf(pwd));
        pwd.click();
        wait.until(ExpectedConditions.visibilityOf(pwd));
        pwd.sendKeys(password);
        wait.until(ExpectedConditions.visibilityOf(cPwd));
        cPwd.click();
        wait.until(ExpectedConditions.visibilityOf(cPwd));
        cPwd.sendKeys(cPassword);

    }

    public void submit(){
        wait.until(ExpectedConditions.visibilityOf(btnSubscribe));
        btnSubscribe.click();
    }


    public void checkIfElementIsPresent() {
        checkIfElementIsPresentAndGotoNewElement(imConnected, gotoWebSite);
    }

    public void logOut() throws InterruptedException {
        longWait.until(ExpectedConditions.visibilityOf(avatarAccount)).click();
        swipeScreen(Direction.UP);
        longWait.until(ExpectedConditions.visibilityOf(logOutBtn)).click();
    }



}


