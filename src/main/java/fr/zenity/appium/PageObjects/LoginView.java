package fr.zenity.appium.PageObjects;

import fr.zenity.appium.Enum.Direction;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class LoginView extends View{

    @AndroidFindBy(xpath="//android.widget.Button[@index='1']")
    private MobileElement isOK;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@text='Email']")
    private MobileElement emailInput;

    @AndroidFindBy(xpath = "//android.widget.EditText[@index='1']")
    private MobileElement pwd;

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

    @AndroidFindBy(xpath = "//android.view.View[@index='1']")
    private MobileElement product1;

    @AndroidFindBy(xpath = "//android.view.View[@index='2']")
    private MobileElement product2;

    @AndroidFindBy(xpath = "//android.widget.Button[@index='2']")
    private MobileElement addOneCart;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='0']")
    private MobileElement backToStore;

    @AndroidFindBy(xpath = "//android.widget.Button[@index='3']")
    private MobileElement addToCart;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='1']")
    private MobileElement goToCart;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Valider']")
    private MobileElement btnValidate;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Ok']")
    private MobileElement popUpSuccess;

    @AndroidFindBy(id = "com.example.shop_app:id/et_card_number")
    private MobileElement cardNumber;

    @AndroidFindBy(id = "com.example.shop_app:id/et_expiry")
    private MobileElement expiration;

    @AndroidFindBy(id = "com.example.shop_app:id/et_cvc")
    private MobileElement card_cvc;

    @AndroidFindBy(id = "com.example.shop_app:id/buttonSave")
    private MobileElement buttonSave;



    public void login(String email, String password) throws InterruptedException {
        longWait.until(ExpectedConditions.visibilityOf(emailInput));
        emailInput.click();
        emailInput.sendKeys(email);
        longWait.until(ExpectedConditions.visibilityOf(pwd));
        pwd.click();
        longWait.until(ExpectedConditions.visibilityOf(pwd));
        pwd.sendKeys(password);
    }

    public void gotoStore() throws InterruptedException {
        checkIfElementIsPresentAndGotoNewElement(imConnected, gotoWebSite);
        Thread.sleep(3000);
    }
    public void submit(){
        wait.until(ExpectedConditions.visibilityOf(btnSubscribe));
        btnSubscribe.click();
    }

    public boolean applicationOk(){
        longWait.until(visibilityOf(isOK));
        return true;
    }

    public void shopping() throws InterruptedException {
        swipeScreen(Direction.UP);
        swipeScreen(Direction.LEFT);
        longWait.until(ExpectedConditions.visibilityOf(product1)).click();
        swipeScreen(Direction.UP);
        longWait.until(ExpectedConditions.visibilityOf(addOneCart)).click();
        longWait.until(ExpectedConditions.visibilityOf(addToCart)).click();
        longWait.until(ExpectedConditions.visibilityOf(backToStore)).click();
        longWait.until(ExpectedConditions.visibilityOf(product2)).click();
        swipeScreen(Direction.UP);
        middleWait.until(ExpectedConditions.visibilityOf(addOneCart)).click();
        longWait.until(ExpectedConditions.visibilityOf(addToCart)).click();
        longWait.until(ExpectedConditions.visibilityOf(goToCart)).click();
        longWait.until(ExpectedConditions.visibilityOf(btnValidate)).click();

    }

    public void paidTheOrder(String card_number, String exp, String cvc) throws InterruptedException {
        longWait.until(ExpectedConditions.visibilityOf(cardNumber)).click();
        cardNumber.sendKeys(card_number);
        longWait.until(ExpectedConditions.visibilityOf(expiration)).click();
        expiration.sendKeys(exp);
        longWait.until(ExpectedConditions.visibilityOf(card_cvc)).click();
        card_cvc.sendKeys(cvc);
        longWait.until(ExpectedConditions.visibilityOf(buttonSave)).click();


        try{
            longWait.until(ExpectedConditions.visibilityOf(popUpSuccess)).click();
            longWait.until(ExpectedConditions.visibilityOf(popUpSuccess)).click();

        }catch(Exception e){
            System.out.println("++++++++++++++++++ Eche de la commande veuillez reessayer plus tart ....");
            e.printStackTrace();
        }

    }

    public void clickOnContinue(){
        shortWait.until(elementToBeClickable(isOK)).click();
        //isOK.click();
    }
    public void logOut() throws InterruptedException {
        Thread.sleep(2000);
        longWait.until(ExpectedConditions.visibilityOf(avatarAccount)).click();
        swipeScreen(Direction.UP);
        wait.until(ExpectedConditions.visibilityOf(logOutBtn)).click();
    }

}
