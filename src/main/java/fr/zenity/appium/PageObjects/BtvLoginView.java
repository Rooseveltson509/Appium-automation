package fr.zenity.appium.PageObjects;

import fr.zenity.appium.Enum.Direction;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class BtvLoginView extends View{
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='lastname']")
    private MobileElement login;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='username']")
    private MobileElement username;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='password']")
    private MobileElement pwd;

    @AndroidFindBy(xpath = "//android.view.View[@resource-id='errorMessageContainer']")
    private MobileElement ERROR_CREDENTIALS;

    @AndroidFindBy(xpath = "//android.view.View[@index='3']")
    private MobileElement avatarLogin;

    @AndroidFindBy(xpath = "//android.view.View[@resource-id='menu']")
    private MobileElement logOutBurger;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Je me connecte']")
    private MobileElement btnSubscribe;

    @AndroidFindBy(xpath = "//android.widget.Button[@index='7']")
    private MobileElement loadingBtn;

    @AndroidFindBy(xpath = "//android.view.View[@index='10']")
    private MobileElement confirmInfos;

    @AndroidFindBy(xpath = "//android.view.View[@text='Fermer']")
    private MobileElement closeThankBtn;

    @AndroidFindBy(xpath = "//android.widget.Image[@text='Bouygues Telecom']")
    private MobileElement imageAppToClose;

    @AndroidFindBy(xpath = "//android.view.View[@index='10']")
    private MobileElement disconnect;

    public void login(String lastname, String number, String password) throws InterruptedException {
        longWaitUntil(visibilityOf(login));
        login.click();
        login.clear();
        login.sendKeys(lastname);
        longWaitUntil(visibilityOf(username));
        username.click();
        username.clear();
        username.sendKeys(number);
        longWaitUntil(visibilityOf(pwd));
        pwd.clear();
        pwd.sendKeys(password);
    }
    public void submit() throws InterruptedException {
        longWaitUntil(visibilityOf(btnSubscribe));
        btnSubscribe.click();
        //Thread.sleep(5000);
    }
    public void clickOnLoginAvatar(){
        longWaitUntil(visibilityOf(avatarLogin));
        avatarLogin.click();
    }

    public void loginValidate(String name, String number,String password) {
        if(longWaitUntil(visibilityOf(ERROR_CREDENTIALS))){
            loginValidatorBTV(ERROR_CREDENTIALS, name, number, password);
        }  else{
            System.out.println("Nothing to report.....");
        }
    }

    public boolean confirmationLogged(){
        longWait.until(visibilityOf(confirmInfos));
        return true;
    }

    public void clickOnConfirm() throws InterruptedException {
        shortWait.until(elementToBeClickable(confirmInfos)).click();
        Thread.sleep(10000);
        longWaitUntil(visibilityOf(closeThankBtn));
        closeThankBtn.click();
        Thread.sleep(3000);
        longWaitUntil(visibilityOf(imageAppToClose));
        imageAppToClose.click();
    }

    public void logOut() throws InterruptedException {
        Thread.sleep(2000);
        longWait.until(ExpectedConditions.visibilityOf(logOutBurger)).click();
        swipeScreen(Direction.UP);
        wait.until(ExpectedConditions.visibilityOf(disconnect)).click();
        Thread.sleep(7000);
    }
}
