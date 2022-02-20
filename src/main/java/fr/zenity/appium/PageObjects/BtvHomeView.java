package fr.zenity.appium.PageObjects;

import fr.zenity.appium.Enum.Direction;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class BtvHomeView extends View{
    @AndroidFindBy(xpath="//android.widget.Button[@text='Launch bouygues btv']")
    private MobileElement isOK;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Tout accepter']")
    private MobileElement btnAccept;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Connexion']")
    private MobileElement btnConnected;

    @AndroidFindBy(xpath = "//android.view.View[@index='4']")
    private MobileElement openMenu;

    @AndroidFindBy(xpath = "//android.view.View[@text='Bouygues Telecom']")
    private MobileElement home;

    @AndroidFindBy(xpath = "//android.view.View[@text='Accéder à votre espace client ']")
    private MobileElement espaceClient;

    @AndroidFindBy(xpath = "//android.view.View[@index='2']")
    private MobileElement panier;

    @AndroidFindBy(xpath = "//android.view.View")
    private List<MobileElement> menuList;

    @AndroidFindBy(xpath = "//android.view.View[@index='0']")
    private MobileElement telephonesLink;

    @AndroidFindBy(xpath = "//android.view.View[@index='10']")
    private MobileElement allMobile;

    public boolean applicationOk(){
        longWait.until(visibilityOf(isOK));
        return true;
    }

    public void clickOnContinue() throws InterruptedException {
        shortWait.until(elementToBeClickable(isOK)).click();
        Thread.sleep(7000);
        swipeScreen(Direction.UP);
        longWaitUntil(visibilityOf(btnAccept));
        btnAccept.click();
        Thread.sleep(7000);
    }

    public void goLoging() throws InterruptedException {
        longWaitUntil(visibilityOf(home));
        home.click();
        Thread.sleep(5000);
    }

}
