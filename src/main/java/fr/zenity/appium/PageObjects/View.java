package fr.zenity.appium.PageObjects;

import fr.zenity.appium.Enum.Direction;
import fr.zenity.appium.drivers.MobileDriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Allure;
import org.junit.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;
import java.time.Duration;
import java.util.function.Function;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public abstract class View {


    protected AppiumDriver<MobileElement> driver;

    protected WebDriverWait wait;
    protected WebDriverWait shortWait;
    protected WebDriverWait middleWait;
    protected WebDriverWait longWait;

    protected View() {
        driver = MobileDriverManager
                .getInstance()
                .getDriver()
                .getDriver();

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

        wait = new WebDriverWait(driver, 5);
        shortWait = new WebDriverWait(driver, 10);
        middleWait = new WebDriverWait(driver, 20);
        longWait = new WebDriverWait(driver, 5);

    }

    public <V> boolean longWaitUntil(Function<? super WebDriver, V> isTrue) {
        try {
            longWait.until(isTrue);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void checkIfElementIsPresentAndGotoNewElement(MobileElement mElPresent, MobileElement goTo) {
        try {
            wait.until(ExpectedConditions.visibilityOf(mElPresent));
            wait.until(ExpectedConditions.visibilityOf(goTo));
            goTo.click();
            try {
                goTo.click();
            } catch (Exception e) {
                System.out.println("----not clicking----");
            }
            System.out.println("******************** ELEMENT DISPLAYED ***************************");
        } catch (Exception e) {
            System.out.println("Element not present, we are good here!");
        }
    }


    public void checkPwdIsTooShort(MobileElement mElement, String pwd) {
        try {
            if (wait.until(ExpectedConditions.visibilityOf(mElement)) != null) {
                Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
                Assert.fail("INVALID CREDENTIALS: " + mElement.getAttribute("content-desc") + "\n" + "password: " + pwd);
            }
        } catch (Exception e) {
            System.out.println("Element not present, we are good here!");
        }
    }

    public void checkPwdIsWong(MobileElement mElement, String password) {
        try {
            if (wait.until(ExpectedConditions.visibilityOf(mElement)) != null) {
                Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
                Assert.fail("INVALID PASSWORD: " + mElement.getAttribute("content-desc") + "\n" + "password: " + password);
            }
        } catch (Exception e) {
            System.out.println("Element not present, we are good here!");
        }
    }

    public void checkEmailValid(MobileElement mElement, String email) {
        try {
            if (wait.until(ExpectedConditions.visibilityOf(mElement)) != null) {
                Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
                Assert.fail("INVALID CREDENTIALS: " + mElement.getAttribute("content-desc") + "\n" + "Email: " + email);
            }
        } catch (Exception e) {
            System.out.println("Element not present, we are good here!");
        }
    }

    public void checkCardNumber(MobileElement mElement, String nCard, String exp, String cvc) {
        if (longWaitUntil(visibilityOf(mElement))) {
            Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
            Assert.fail("INVALID CARD NUMBER: " + mElement.getAttribute("text") + "\n" + "card number: " + nCard + "\n" + "exp: " + exp + "\n" + "CVC: " + cvc);
        } else {
            System.out.println("Element not present, we are good here!");
        }
    }

    public void loginValidator(MobileElement mElement, String email, String password) {
        try {
            if (wait.until(ExpectedConditions.visibilityOf(mElement)) != null) {
                Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
                Assert.fail("INVALID CREDENTIALS: " + mElement.getAttribute("content-desc") + "\n" + "Email: " + email + "\n" + "Password: " + password);
            }
        } catch (Exception e) {
            System.out.println("Element not present, we are good here!");
        }
    }

    public void loginValidatorBTV(MobileElement mElement, String name, String number, String password) {
        try {
            if (wait.until(ExpectedConditions.visibilityOf(mElement)) != null) {
                Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
                Assert.fail("INVALID CREDENTIALS: " + mElement.getAttribute("text") + "\n" + "Nom de famille: " + name + "\n" + "number: " + number+ "\n" + "password: " + password);
            }
        } catch (Exception e) {
            System.out.println("Element not present, we are good here!");
        }
    }

    public void registerFields(MobileElement mElement, String email, String pwd, String cpwd) {
        if (longWaitUntil(visibilityOf(mElement))) {
            Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
            Assert.fail("INVALID CREDENTIALS: " + mElement.getAttribute("content-desc") + "\n" + "Email: " + email + "\n" + "password: " + pwd + "\n" + "confirm password: " + cpwd);
        } else {
            System.out.println("Element not present, we are good here!");
        }
    }


    /**
     * Performs swipe from the center of screen
     *
     * @param dir the direction of swipe
     * @version java-client: 7.3.0
     **/
    public void swipeScreen(Direction dir) throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("swipeScreen(): dir: '" + dir + "'"); // always log your actions

        // Animation default time:
        //  - Android: 300 ms
        //  - iOS: 200 ms
        // final value depends on your app and could be greater
        final int ANIMATION_TIME = 200; // ms

        final int PRESS_TIME = 200; // ms

        int edgeBorder = 10; // better avoid edges
        PointOption pointOptionStart, pointOptionEnd;

        // init screen variables
        Dimension dims = driver.manage().window().getSize();

        // init start point = center of screen
        pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);

        switch (dir) {
            case DOWN: // center of footer
                pointOptionEnd = PointOption.point(dims.width / 2, dims.height - edgeBorder);
                break;
            case UP: // center of header
                pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);
                break;
            case LEFT: // center of left side
                pointOptionEnd = PointOption.point(edgeBorder, dims.height / 2);
                break;
            case RIGHT: // center of right side
                pointOptionEnd = PointOption.point(dims.width - edgeBorder, dims.height / 2);
                break;
            default:
                throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
        }

        // execute swipe using TouchAction
        try {
            new TouchAction(driver)
                    .press(pointOptionStart)
                    // a bit more reliable when we add small wait
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
        } catch (Exception e) {
            System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
            return;
        }

        // always allow swipe action to complete
        try {
            Thread.sleep(ANIMATION_TIME);
        } catch (InterruptedException e) {
            // ignore
        }
    }


}
