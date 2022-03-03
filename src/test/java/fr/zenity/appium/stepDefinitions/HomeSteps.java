package fr.zenity.appium.stepDefinitions;

import fr.zenity.appium.PageObjects.HomePage;
import io.cucumber.java8.En;

public class HomeSteps implements En {

    public HomeSteps(HomePage homePage){

        Given("^I go to login view$", () -> {
           assert homePage.applicationOk();
           homePage.clickOnContinue();
        });

        Then("^I click on registered button$", () -> {
            try {
                Thread.sleep(5000);
            }catch (Exception e){}
            homePage.clickOnRegistered();
        });
    }
}