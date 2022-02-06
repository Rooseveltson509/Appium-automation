package fr.zenity.appium.PageObjects;

import fr.zenity.appium.Enum.Direction;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;


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


    @AndroidFindBy(xpath = "//android.widget.Button[@index='9']")
    private MobileElement loadingBtn;


    @AndroidFindBy(id = "android.view.View[@content-desc='Veuillez entrer un email valide']")
    private MobileElement checkEmailIsValid;


    @AndroidFindBy(id = "android.view.View[@index='8']")
    private MobileElement checkPwdToShort;


    @AndroidFindBy(id = "android.view.View[@index='10']")
    private MobileElement checkPwdIsMatching;

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

    public void submit(String email, String password) throws InterruptedException {
        try {
            wait.until(ExpectedConditions.visibilityOf(btnSubscribe)).click();
        } catch (Exception e) {
            loadingBtn.click();
            System.out.println(e.getMessage());
        }
        checkRegisterFormValidate(imConnected, gotoWebSite, email, password);
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


