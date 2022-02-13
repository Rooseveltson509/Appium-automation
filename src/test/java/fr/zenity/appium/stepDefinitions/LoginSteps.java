package fr.zenity.appium.stepDefinitions;

import fr.zenity.appium.PageObjects.LoginView;
import io.cucumber.java8.En;

public class LoginSteps implements En {

    public LoginSteps(LoginView loginView) {
        Given("^I am on the login page$", () -> {
            System.out.println("------------- login page ----------------------");
        });

        When("^I go to the login page and I signing with my \"([^\"]*)\" and \"([^\"]*)\"$", (String email, String password) -> {
            loginView.login(email, password);
            loginView.submit();
            loginView.loginValidate(email, password);

            System.out.println("<<<<<<<<<<< i'm login >>>>>>>>>>>>>>>>>>>>>>");
            loginView.gotoStore();
        });

        Then("^I am on the store page$", () -> {
            System.out.println("then I'm logging off");
        });
    }
}
