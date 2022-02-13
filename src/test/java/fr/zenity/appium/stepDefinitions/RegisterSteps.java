package fr.zenity.appium.stepDefinitions;

import fr.zenity.appium.PageObjects.RegisterView;
import io.cucumber.java8.En;

public class RegisterSteps implements En {

    public RegisterSteps(RegisterView registerView
            ){

        Given("^I am on the home page$", () -> {
            System.out.println("Register page");
            registerView.clickOnRegistered();

        });

        When("^I go to the register page and I create account with \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$", (String email, String password, String cPassword) -> {
            registerView.register(email, password, cPassword);
            registerView.submit();
            registerView.checkEmail(email);
            registerView.checkPwd(password);
            registerView.checkPwdShort(cPassword);
            System.out.println("------before logout-------");
        });
        Then("^I am registered$", () -> {
            registerView.checkIfElementIsPresent();
            System.out.println("Account has been created...");
        });
    }
}
