package fr.zenity.appium.stepDefinitions;

import fr.zenity.appium.PageObjects.BtvLoginView;
import io.cucumber.java8.En;

public class BtvLoginSteps implements En {
    public BtvLoginSteps(BtvLoginView btvLoginView) {
        Given("^I am on the login page btv$", () -> {
            System.out.println("Given Block");
            btvLoginView.clickOnLoginAvatar();
        });
        When("^connect with my \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$", (String login, String number, String password) -> {
            btvLoginView.login(login, number,password);
            btvLoginView.submit();
            btvLoginView.loginValidate(login, number, password);
        });
        Then("^I am connected$", () -> {
            Thread.sleep(10000);
            //assert btvLoginView.confirmationLogged();
                  btvLoginView.clickOnConfirm();
            System.out.println("Then:  block");
            Thread.sleep(10000);
        });
    }
}
