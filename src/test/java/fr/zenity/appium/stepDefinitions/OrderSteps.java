package fr.zenity.appium.stepDefinitions;

import fr.zenity.appium.Enum.Products;
import fr.zenity.appium.PageObjects.OrderView;
import fr.zenity.appium.utils.CSVWorker;
import io.cucumber.java8.En;

public class OrderSteps implements En {

    CSVWorker worker = new CSVWorker("src\\test\\resources\\data\\products.csv");
    public OrderSteps(OrderView orderView) {
        Given("^I am on the product catalog page$", () -> {
            System.out.println("------ Go to Product Catalog");
            orderView.gotoStore();
        });

        And("^I choose the product \"([^\"]*)\"$", (String product1) -> {
            orderView.shopping2(Products.PRODUCT1.getName());
        });

        And("^I choose another product \"([^\"]*)\"$", (String product2) -> {
            orderView.shopping2(worker.getColumn("productName").get(1));
        });

        Then("^I am on the product detail page$", () -> {
            orderView.checkItemToCart();
            System.out.println("---------------- Cart Items --------------------");
        });
    }
}
