package fr.zenity.appium.PageObjects;

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
        //new WebDriverWait(driver, 5);
        //String text = driver.findElement(By.xpath("//android.widget.ImageView[@index='5']"));
        /*String text = driver.findElement(By.xpath("//android.widget.ImageView[@index='5']")).getAttribute("content-desc");
        System.out.println("++++++++++++++++++++++++++++++" + text);*/
    }

    public void submit(){
        wait.until(ExpectedConditions.visibilityOf(btnSubscribe));
        btnSubscribe.click();
    }

    public void scrollingVertical(){
        //container Wrap
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().xpath(\"//android.widget.ScrollView[@index='1']\")).scrollIntoView(new UiSelector().xpath(\"//android.widget.ImageView[@index='5']\"))")).click();

    }

    public void checkIfElementIsPresent() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        try {
            if (wait.until(ExpectedConditions.visibilityOf(imConnected)) != null) {
                Assert.assertTrue(imConnected.isDisplayed());
                System.out.println("******************** ELEMENT DISPLAYED ***************************");
                wait.until(ExpectedConditions.visibilityOf(gotoWebSite));
                gotoWebSite.click();
                longWait.until(ExpectedConditions.visibilityOf(avatarAccount));
                avatarAccount.click();
            }
        } catch (Exception e) {
            System.out.println("Element not present, we are good here!");
        }
    }

    public void logOut() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(avatarAccount));
        new WebDriverWait(driver, 5);

        MobileElement mElement = driver.findElement(MobileBy.xpath("//android.widget.ImageView[@index='5']"));

        scrollUntilElementFound(mElement,"Log Out");
        new WebDriverWait(driver, 5);
        //logOutBtn.click();
        //scrollAndClick("Help Center");
        //scrollingVertical();
        //scrollUsingTouchActionsByElements();
        Thread.sleep(5000);
    }

    public void scrollAndClick(String visibleText) {
        //driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))")).click();
        new TouchAction((PerformsTouchActions) MobileDriverManager.getInstance().getDriver())
                .press(PointOption.point(0, 2))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(0, 3))
                .release().perform();
    }

    public void scrollUsingTouchActionsByElements() {
        MobileElement element = driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().xpath(\"//android.widget.ScrollView[@index='1']\")).getChildByText("
                        + "new UiSelector().xpath(\"//android.widget.ImageView[@index='5']\"), \"Log Out\")"));

//Perform the action on the element
        element.click();
    }
    public void scroll() {
         //driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().xpath(\"//android.widget.ScrollView[@index='1']\")).scrollIntoView(new UiSelector().xpath(\"//android.widget.ImageView[@index='5']\"))"));
        /*new TouchAction((PerformsTouchActions) MobileDriverManager.getInstance().getDriver())
                .press(PointOption.point(0, 0))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(0, 2))
                .release().perform();*/

        driver.findElementByAccessibilityId("Views").click();
        AndroidElement list = (AndroidElement) driver.findElement(By.id("android:id/mobile_list"));
        MobileElement listGroup = list
                .findElement(MobileBy
                        .AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
                                + "new UiSelector().text(\" List item:25\"));"));
        Assert.assertNotNull(listGroup.getLocation());
        listGroup.click();
    }

    public void scrollUntilElementFound(MobileElement elementScrollTo, String parentScrollViewId) {//Scrolls until element is found
        boolean elementFound = false;
        while(!elementFound) {
            try {
                if(elementScrollTo.isDisplayed()) {
                    break;
                }
            }catch(Exception e) {
                elementFound=false;
            }
            try {
                driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().description(\""+parentScrollViewId+"\")).scrollForward()"));
            }catch(Exception e) {
                //Ignore error
            }
        }
    }


}


