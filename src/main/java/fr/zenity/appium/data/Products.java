package fr.zenity.appium.data;

import fr.zenity.appium.drivers.MobileDriverManager;

public class Products {
    private static Products INSTANCE = new Products();
    public String product1  = "Gloves XC Omega - Polygon\n€36.55";
    public String product2  = "Rooseveltson cebeat\n€36.55";

    public String getProduct1(){
        return product1;
    }
    public String getProduct2(){
        return product2;
    }

    public static Products getInstance(){ return INSTANCE; }
}