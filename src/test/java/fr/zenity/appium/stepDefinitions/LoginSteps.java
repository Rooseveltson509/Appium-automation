package fr.zenity.appium.stepDefinitions;

import fr.zenity.appium.PageObjects.LoginView;
import io.cucumber.java8.En;

public class LoginSteps implements En {

    public LoginSteps(LoginView loginView) {
        Given("^I am on the login page$", () -> {
            assert loginView.applicationOk();
            loginView.clickOnContinue();
        });

        When("^I go to the login page and I signing with my \"([^\"]*)\" and my \"([^\"]*)\"$", (String email, String password) -> {
            loginView.login(email, password);
            //loginView.submit();
            Thread.sleep(5000);
        });

        Then("^I am on the store catalogue$", () -> {
        });
    }
}
