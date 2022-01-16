package fr.zenity.appium.PageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class HomePage extends View{

    @AndroidFindBy(xpath="//android.widget.Button[1]")
    private MobileElement isOK;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"S'inscrire\"]")
    private MobileElement registerButton;

    public boolean applicationOk(){
        longWait.until(visibilityOf(isOK));
        return true;
    }

    public void clickOnContinue(){
        shortWait.until(elementToBeClickable(isOK)).click();
    }

    public void clickOnRegistered(){
        shortWait.until(elementToBeClickable(registerButton)).click();
    }

}
