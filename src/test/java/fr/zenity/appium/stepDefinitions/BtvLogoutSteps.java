package fr.zenity.appium.stepDefinitions;

import fr.zenity.appium.PageObjects.BtvLoginView;
import io.cucumber.java8.En;

public class BtvLogoutSteps implements En {
    public BtvLogoutSteps(BtvLoginView btnLoginView) {
        Given("^I ended my visit on the page$", () -> {
            System.out.println("log me out");
            btnLoginView.logOut();
        });
        Then("^I disconnect$", () -> {
            System.out.println("I disconnect to the application");
        });
    }
}
