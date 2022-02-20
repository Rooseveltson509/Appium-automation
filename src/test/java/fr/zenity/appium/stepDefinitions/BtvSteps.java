package fr.zenity.appium.stepDefinitions;

import fr.zenity.appium.PageObjects.BtvHomeView;
import io.cucumber.java8.En;

public class BtvSteps implements En {
    public BtvSteps(BtvHomeView btvHomeView) {
        Given("^I go to login view to watch chanel$", () -> {
            assert btvHomeView.applicationOk();
            btvHomeView.clickOnContinue();
        });

        Then("^I click on login button$", () -> {
            System.out.println("Then block .......");
            btvHomeView.goLoging();
        });
    }
}
