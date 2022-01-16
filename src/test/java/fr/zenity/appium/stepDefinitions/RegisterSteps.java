package fr.zenity.appium.stepDefinitions;

import fr.zenity.appium.PageObjects.RegisterView;
import io.cucumber.java8.En;

public class RegisterSteps implements En {

    public RegisterSteps(RegisterView registerView
            ){

        Given("^I am on the home page$", () -> {
            assert registerView.applicationOk();
            registerView.clickOnContinue();
            registerView.clickOnRegistered();
        });

        When("^I go to the register page and I create account with \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$", (String email, String password, String cPassword) -> {
            registerView.register(email, password, cPassword);
            registerView.submit();
            registerView.checkIfElementIsPresent();
            registerView.logOut();
            //Thread.sleep(5000);
            try {
                Thread.sleep(5000);
            }catch (Exception ignored){}
        });
        Then("^I am on the account page$", () -> {
            System.out.println("Account has been created...");
        });
    }
}
