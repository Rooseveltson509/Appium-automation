package fr.zenity.appium.PageObjects;

import fr.zenity.appium.Enum.Direction;
import fr.zenity.appium.data.Products;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Objects;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class LoginView extends View{

    @AndroidFindBy(xpath="//android.widget.Button[@index='1']")
    private MobileElement isOK;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='0']")
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

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Gloves XC Omega - Polygon€36.55']")
    private MobileElement productText;

    @AndroidFindBy(className = "android.view.View")
    private List<MobileElement> productsList;

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

    @AndroidFindBy(xpath = "//android.view.View[@index='6']")
    private MobileElement checkEmailIsValid;

    @AndroidFindBy(id = "android.view.View[@index='8']")
    private MobileElement checkPwdToShort;

    @AndroidFindBy(id = "android.view.View[@index='10']")
    private MobileElement checkPwdIsMatching;

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

    public void gotoStore() throws InterruptedException {
        checkIfElementIsPresentAndGotoNewElement(imConnected, gotoWebSite);
        Thread.sleep(3000);
    }
    public void submit(String Mel) throws InterruptedException {
        try {
            wait.until(ExpectedConditions.visibilityOf(btnSubscribe)).click();
        } catch (Exception e) {
            loadingBtn.click();
            System.out.println(e.getMessage());
        }

        checkLoginIsFail(checkEmailIsValid, Mel);

    }

    public boolean applicationOk(){
        longWait.until(visibilityOf(isOK));
        return true;
    }

    public void shopping1(String productname) throws InterruptedException {
        swipeScreen(Direction.UP);
        clickToList(productsList, productname);

        swipeScreen(Direction.UP);
        longWait.until(ExpectedConditions.visibilityOf(addOneCart)).click();
        longWait.until(ExpectedConditions.visibilityOf(addToCart)).click();
        longWait.until(ExpectedConditions.visibilityOf(backToStore)).click();

    }
    public void shopping2(String productname) throws InterruptedException {
        swipeScreen(Direction.UP);
        checkListElPresent(productsList, productname);

        swipeScreen(Direction.UP);
        longWait.until(ExpectedConditions.visibilityOf(addOneCart)).click();
        longWait.until(ExpectedConditions.visibilityOf(addToCart)).click();
        longWait.until(ExpectedConditions.visibilityOf(backToStore)).click();

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

    //check an item to an existing list
    public void clickToList(List<MobileElement> elementList, String name) throws InterruptedException {
        MobileElement aEl = elementList.stream()
                .filter(element -> element.getAttribute("content-desc").contains(name))
                .findFirst().get();

        aEl.click();
    }

    public void checkListElPresent(List<MobileElement> mEl, String name){
        mEl.forEach(
                (c) -> {

                    if(!c.getAttribute("content-desc").contains(name)){
                        try {
                            swipeScreen(Direction.LEFT);
                            clickToList(mEl, name);
                            //swipeScreen(Direction.UP);
                        } catch (InterruptedException e) {
                            System.out.println("ELEMENT NOT FOUND ..........");
                            e.printStackTrace();
                        }
                    }
                }
        );
    }

}
