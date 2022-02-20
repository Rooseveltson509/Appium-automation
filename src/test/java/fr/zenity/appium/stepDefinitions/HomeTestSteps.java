package fr.zenity.appium.stepDefinitions;

import fr.zenity.appium.PageObjects.HomePage;
import io.cucumber.java8.En;

public class HomeTestSteps implements En {
    public HomeTestSteps(HomePage homePage){

        Given("^I go to login page$", () -> {
            assert homePage.applicationOk();
            homePage.clickOnContinue();
        });

        Then("^I fill in the fields$", () -> {
            try {
                Thread.sleep(5000);
            }catch (Exception e){}
        });
    }
}
