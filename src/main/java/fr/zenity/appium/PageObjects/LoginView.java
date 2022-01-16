package fr.zenity.appium.PageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class LoginView extends View{

    @AndroidFindBy(xpath="//android.widget.Button[1]")
    private MobileElement isOK;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='0']")
    private MobileElement emailInput;

    @AndroidFindBy(xpath = "//android.widget.EditText[@index='1']")
    private MobileElement pwd;

    @AndroidFindBy(xpath = "//android.widget.Button[@index='5']")
    private MobileElement btnSubscribe;





    public void login(String email, String password) {
        wait.until(ExpectedConditions.visibilityOf(emailInput));
        emailInput.click();
        wait.until(ExpectedConditions.visibilityOf(emailInput));
        emailInput.sendKeys(email);
        wait.until(ExpectedConditions.visibilityOf(pwd));
        pwd.click();
        wait.until(ExpectedConditions.visibilityOf(pwd));
        pwd.sendKeys(password);

        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void submit(){
        wait.until(ExpectedConditions.visibilityOf(btnSubscribe));
        btnSubscribe.click();
    }

    public boolean applicationOk(){
        longWait.until(visibilityOf(isOK));
        return true;
    }

    public void clickOnContinue(){
        shortWait.until(elementToBeClickable(isOK)).click();
        isOK.click();
    }
}
