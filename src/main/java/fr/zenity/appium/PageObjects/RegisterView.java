package fr.zenity.appium.PageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;


public class RegisterView extends View {

    @AndroidFindBy(xpath = "//android.widget.Button[1]")
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

    @AndroidFindBy(xpath = "//android.widget.Button[@index='8']")
    private MobileElement btnSubscribe2;

    @AndroidFindBy(xpath = "//android.widget.Button[@index='3']")
    private MobileElement gotoWebSite;

    @AndroidFindBy(xpath = "//android.view.View[@index='2']")
    private MobileElement imConnected;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='3']")
    private MobileElement avatarAccount;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='5']")
    private MobileElement logOutBtn;


    @AndroidFindBy(xpath = "//android.widget.Button[@index='7']")
    private MobileElement loadingBtn;


    @AndroidFindBy(xpath = "//android.widget.Button[@index='10']")
    private MobileElement loadingBtn2;


    @AndroidFindBy(id = "android.view.View[@index='8']")
    private MobileElement checkPwdToShort;


    @AndroidFindBy(id = "android.view.View[@index='10']")
    private MobileElement checkPwdIsMatching;


    @AndroidFindBy(xpath = "//android.view.View[@index='6']")
    private MobileElement ERROR_EMAIL;

    @AndroidFindBy(xpath = "//android.view.View[@index='7']")
    private MobileElement ERROR_SHORT_PWD;

    @AndroidFindBy(xpath = "//android.view.View[@index='7']")
    private MobileElement ERROR_PWD_DO_NOT_MATCH;


    public void clickOnRegistered() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //registerButton.click();
        shortWait.until(elementToBeClickable(registerButton)).click();
    }


    public void register(String mailto, String password, String cPassword) {
        longWaitUntil(visibilityOf(emailInput));
        emailInput.click();
        emailInput.sendKeys(mailto);
        longWaitUntil(visibilityOf(pwd));
        pwd.click();
        pwd.sendKeys(password);
        longWaitUntil(visibilityOf(cPwd));
        cPwd.click();
        cPwd.sendKeys(cPassword);
    }

    public void submit() {
        try {
            longWaitUntil(visibilityOf(btnSubscribe));
            btnSubscribe.click();
        } catch (Exception e) {
            loadingBtn.click();
            System.out.println(e.getMessage());
        }
    }

    public void checkPwd(String password) {
        checkPwdIsWong(ERROR_PWD_DO_NOT_MATCH, password);
    }

    public void checkEmail(String email) {
        checkEmailValid(ERROR_EMAIL, email);
    }

    public void checkPwdShort(String password) {
        checkPwdIsTooShort(ERROR_SHORT_PWD, password);
    }

    public void checkIfElementIsPresent() {
        checkIfElementIsPresentAndGotoNewElement(imConnected, gotoWebSite);
    }

}


