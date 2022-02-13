package fr.zenity.appium.stepDefinitions;

import fr.zenity.appium.Enum.Products;
import fr.zenity.appium.PageObjects.OrderView;
import io.cucumber.java8.En;

public class OrderSteps implements En {

    public OrderSteps(OrderView orderView) {
        Given("^I am on the product catalog page$", () -> {
            System.out.println("------ Go to Product Catalog");
            orderView.gotoStore();
        });

        And("^I choose the product \"([^\"]*)\"$", (String product1) -> {
            orderView.shopping2(Products.PRODUCT2.getName());
        });

        And("^I choose another product \"([^\"]*)\"$", (String product2) -> {
            orderView.shopping2(Products.PRODUCT3.getName());
        });

        Then("^I am on the product detail page$", () -> {
            orderView.checkItemToCart();
            System.out.println("---------------- Cart Items --------------------");
        });
    }
}
