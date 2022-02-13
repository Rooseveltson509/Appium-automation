package fr.zenity.appium.PageObjects;

import fr.zenity.appium.Enum.Direction;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class LoginView extends View{

    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='0']")
    private MobileElement emailInput;

    @AndroidFindBy(xpath = "//android.widget.EditText[@index='1']")
    private MobileElement pwd;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Continue']")
    private MobileElement btnSubscribe;

    @AndroidFindBy(xpath = "//android.widget.Button[@index='3']")
    private MobileElement gotoWebSite;

    @AndroidFindBy(xpath = "//android.view.View[@index='2']")
    private MobileElement imConnected;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='3']")
    private MobileElement avatarAccount;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='5']")
    private MobileElement logOutBtn;


    @AndroidFindBy(xpath = "//android.view.View[@index='6']")
    private MobileElement checkEmailIsValid;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Le mot de passe est trop court']")
    private MobileElement checkPwdToShort;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Email ou Mot de passe incorrect']")
    private MobileElement checkPwdIsWong;

    @AndroidFindBy(xpath = "//android.widget.Button[@index='7']")
    private MobileElement loadingBtn;



    public void login(String email, String password) throws InterruptedException {
        longWait.until(ExpectedConditions.visibilityOf(emailInput));
        emailInput.click();
        emailInput.sendKeys(email);
        longWait.until(ExpectedConditions.visibilityOf(pwd));
        pwd.click();
        longWait.until(ExpectedConditions.visibilityOf(pwd));
        pwd.sendKeys(password);
    }

    public void gotoStore(){
        checkIfElementIsPresentAndGotoNewElement(imConnected, gotoWebSite);
    }

    public void submit() {
        try {
            wait.until(ExpectedConditions.visibilityOf(btnSubscribe)).click();
        } catch (Exception e) {
            loadingBtn.click();
            System.out.println(e.getMessage());
        }
    }

    public void loginValidate(String email,String password) {
        if(longWaitUntil(visibilityOf(checkPwdToShort))){
            loginValidator(checkPwdToShort, email, password);
        } else if(longWaitUntil(visibilityOf(checkEmailIsValid))){
            loginValidator(checkEmailIsValid, email, password);
        } else if(longWaitUntil(visibilityOf(checkPwdIsWong))){
            loginValidator(checkPwdIsWong, email, password);
        } else{
            System.out.println("Nothing to report.....");
        }
    }

    public void logOut() throws InterruptedException {
        Thread.sleep(2000);
        longWait.until(ExpectedConditions.visibilityOf(avatarAccount)).click();
        swipeScreen(Direction.UP);
        wait.until(ExpectedConditions.visibilityOf(logOutBtn)).click();
    }
}
