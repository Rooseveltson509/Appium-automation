package fr.zenity.appium.stepDefinitions;

import fr.zenity.appium.PageObjects.LoginView;
import io.cucumber.java8.En;
import org.apache.commons.validator.routines.EmailValidator;

public class LoginSteps implements En {

    public LoginSteps(LoginView loginView) {
        Given("^I am on the login page$", () -> {
            //assert loginView.applicationOk();
            System.out.println("------------- login page ----------------------");
            //loginView.clickOnContinue();
        });


        When("^I go to the login page and I signing with my \"([^\"]*)\" and \"([^\"]*)\"$", (String email, String password) -> {
            loginView.login(email, password);
            boolean valid = EmailValidator.getInstance().isValid(email);
            if(!valid){
                loginView.submit(email);
            }
            loginView.submit(password);

            System.out.println("<<<<<<<<<<< i'm login >>>>>>>>>>>>>>>>>>>>>>");
            loginView.gotoStore();
        });

       /* And("^I am on the store catalogue$", () -> {
            System.out.println("<<<<<<<<<<< i'm login >>>>>>>>>>>>>>>>>>>>>>");
            loginView.gotoStore();
            //Thread.sleep(6000);
        });

        And("^I choose one product and i add i increase and add it to the cart$", () -> {
            System.out.println("I increment the quantity of my cart.");
            //loginView.shopping();
        });

        And("^I return to the catalogue of product i choose another product and i increase and add it to the cart$", () -> {
            System.out.println("I return to the catalogue of product i choose another product and i increase and add it to the cart");
        });

        And("^I choose products \"([^\"]*)\" then \"([^\"]*)\"$", (String product1, String product2) -> {
            loginView.shopping1(product1);
            loginView.shopping2(product2);
            System.out.println("OK");
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
        });*/
        Then("^I am on the store page$", () -> {
            System.out.println("then I'm logging off");
            //loginView.logOut();
            Thread.sleep(2000);
        });
    }
}
