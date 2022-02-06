package fr.zenity.appium.stepDefinitions;

import fr.zenity.appium.PageObjects.LoginView;
import io.cucumber.java8.En;

public class LogoutSteps implements En {
    public LogoutSteps(LoginView loginView) {
        Given("^I finish my visit to the store$", () -> {
            System.out.println("log me out");
            loginView.logOut();
        });
        Then("^I am login out$", () -> {
            System.out.println("I disconnect to the application");
        });
    }
}
