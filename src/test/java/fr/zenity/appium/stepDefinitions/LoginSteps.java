package fr.zenity.appium.stepDefinitions;

import fr.zenity.appium.PageObjects.LoginView;
import io.cucumber.java8.En;

public class LoginSteps implements En {

    public LoginSteps(LoginView loginView) {
        Given("^I am on the login page$", () -> {
            //assert loginView.applicationOk();
            System.out.println("------------- login page ----------------------");
            loginView.clickOnContinue();
        });


        When("^I go to the login page and I signing with my \"([^\"]*)\" and \"([^\"]*)\"$", (String email, String password) -> {
            System.out.println("<<<<<<<<<<<<<<<<<<< When >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            loginView.login(email, password);
            loginView.submit();
            //Thread.sleep(5000);
        });

        And("^I am on the store catalogue$", () -> {
            System.out.println("<<<<<<<<<<< i'm login >>>>>>>>>>>>>>>>>>>>>>");
            loginView.gotoStore();
            //Thread.sleep(6000);
        });

        And("^I choose one product and i add i increase and add it to the cart$", () -> {
            System.out.println("I increment the quantity of my cart.");
            loginView.shopping();
        });

        And("^I return to the catalogue of product i choose another product and i increase and add it to the cart$", () -> {
            System.out.println("I return to the catalogue of product i choose another product and i increase and add it to the cart");
        });

        And("^I go to my cart$", () -> {
            System.out.println("I go to my cart and I check my cart");
        });

        And("^I validate my cart with card number \"([^\"]*)\" and expiration date \"([^\"]*)\" and \"([^\"]*)\"$", (String cardNumber, String exp, String cvc) -> {
            loginView.paidTheOrder(cardNumber, exp, cvc);
            System.out.println("Order successful validate...");
            //loginView.logOut();
        });

        Then("^I payed my order$", () -> {
            System.out.println("then I validate my cart");
            loginView.logOut();
            Thread.sleep(2000);
        });
    }
}
