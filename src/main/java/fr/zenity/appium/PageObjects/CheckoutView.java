package fr.zenity.appium.PageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class CheckoutView extends View {

    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='1']")
    private MobileElement cartCountItems;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Valider']")
    private MobileElement btnValidate;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Ok']")
    private MobileElement popUpSuccess;

    @AndroidFindBy(id = "com.example.shop_app:id/et_card_number")
    private MobileElement cardNumber; //com.example.shop_app:id/textinput_placeholder

    @AndroidFindBy(id = "com.example.shop_app:id/et_expiry")
    private MobileElement expiration;

    @AndroidFindBy(id = "com.example.shop_app:id/et_cvc")
    private MobileElement card_cvc;

    @AndroidFindBy(id = "com.example.shop_app:id/textinput_error")
    private MobileElement ERROR_EXP; //Your card's expiration year is invalid.

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Your card's security code is invalid.']")
    private MobileElement ERROR_CVC; //Your card's security code is invalid.

    @AndroidFindBy(xpath = "//android.widget.TextView[@index='0']")
    private MobileElement ERROR_CARD_NUMBER; //Your card's number is invalid.

    @AndroidFindBy(id = "com.example.shop_app:id/buttonSave")
    private MobileElement buttonSave;


    public void paidTheOrder(String card_number, String exp, String cvc) {
        longWait.until(visibilityOf(cardNumber)).click();
        cardNumber.sendKeys(card_number);
        longWait.until(visibilityOf(expiration)).click();
        expiration.sendKeys(exp);
        longWait.until(visibilityOf(card_cvc)).click();
        card_cvc.sendKeys(cvc);
        //longWait.until(visibilityOf(buttonSave)).click();
    }

    public void checkItemToCart() {
        //checkIsFail(cartCountItems);
        wait.until(elementToBeClickable(cartCountItems)).click();
        wait.until(elementToBeClickable(btnValidate)).click();
    }
    public void submit() {
        longWaitUntil(visibilityOf(buttonSave));
        buttonSave.click();
    }

    public void cardValidate(String card_number,String exp,String CVC) {
        if(longWaitUntil(visibilityOf(ERROR_CARD_NUMBER))){
            checkCardNumber(ERROR_CARD_NUMBER, card_number, exp, CVC);
        } else if(longWaitUntil(visibilityOf(ERROR_EXP))){
            checkCardNumber(ERROR_EXP, card_number, exp, CVC);
        } else if(longWaitUntil(visibilityOf(ERROR_CVC))){
            checkCardNumber(ERROR_CVC, card_number, exp, CVC);
        } else{
            System.out.println("Nothing to report.....");
        }
    }


    public void closeSuccessBTN() {
        try {
            while (longWaitUntil(visibilityOf(popUpSuccess))) popUpSuccess.click();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
