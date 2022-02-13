package fr.zenity.appium.stepDefinitions;

import fr.zenity.appium.PageObjects.CheckoutView;
import io.cucumber.java8.En;

public class CheckoutSteps implements En {

    public CheckoutSteps(CheckoutView checkoutView) {
        Given("^I am on the order page$", () -> {
            System.out.println("------------- Checkout Page ----------------------");
            //checkoutView.checkItemToCart();
        });

        When("^I enter my banking information my \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$", (String cardNumber, String exp, String cvc) -> {
            checkoutView.paidTheOrder(cardNumber, exp, cvc);
            checkoutView.submit();
            checkoutView.cardValidate(cardNumber,exp, cvc);
            System.out.println("-------------- placing Order -----------------");
        });
        Then("^I validate my order$", () -> {
            System.out.println("Order successful");
            checkoutView.closeSuccessBTN();
        });

    }
}
