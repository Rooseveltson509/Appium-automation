package fr.zenity.appium.PageObjects;

import fr.zenity.appium.Enum.Direction;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class OrderView extends View {

    @AndroidFindBy(xpath = "//android.view.View[@index='1']")
    private MobileElement product1;

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

    @AndroidFindBy(xpath = "//android.widget.Button[@index='3']")
    private MobileElement gotoWebSite;

    @AndroidFindBy(xpath = "//android.view.View[@index='2']")
    private MobileElement imConnected;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='1']")
    private MobileElement cartCountItems;


    public void gotoStore() throws InterruptedException {
        checkIfElementIsPresentAndGotoNewElement(imConnected, gotoWebSite);
    }

    public void shopping1(String productname) throws InterruptedException {
        System.out.println("<<<<<<<<<<<<<<<<<< Shopping >>>>>>>>>>>>>>>>>>>>>>>>");
        swipeScreen(Direction.UP);
        clickToList(productsList, productname);

        swipeScreen(Direction.UP);
        longWait.until(ExpectedConditions.visibilityOf(addOneCart)).click();
        longWait.until(ExpectedConditions.visibilityOf(addToCart)).click();
        longWait.until(ExpectedConditions.visibilityOf(backToStore)).click();
        swipeScreen(Direction.RIGHT);

    }
    public void shopping2(String productname) throws InterruptedException {
        swipeScreen(Direction.UP);
        checkListElPresent(productsList, productname);
        System.out.println("<<<< Before swipe up >>>>>>>>>>>>");

        swipeScreen(Direction.UP);
        longWait.until(ExpectedConditions.visibilityOf(addOneCart)).click();
        longWait.until(ExpectedConditions.visibilityOf(addToCart)).click();
        longWait.until(ExpectedConditions.visibilityOf(backToStore)).click();
        swipeScreen(Direction.RIGHT);
        swipeScreen(Direction.DOWN);


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
                    try {
                        if(!c.getAttribute("content-desc").contains(name)){
                            swipeScreen(Direction.LEFT);
                            System.out.println("<<< checklist method >>>>>>");
                            clickToList(mEl, name);
                            System.out.println("<<< checklist method >>>>>>");
                        }
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
        );
    }

    public void checkItemToCart() {
        wait.until(elementToBeClickable(cartCountItems)).click();
        wait.until(elementToBeClickable(btnValidate)).click();
    }
}
