package fr.zenity.appium.Enum;

import java.util.Objects;

public enum Products {
    PRODUCT1("Nike Sport"),
    PRODUCT2("Logitech"),
    PRODUCT3("Gloves");

    private String name;

    Products(String name){this.name = name;}

    public static Products parse(String name){
        if(name.contains("custom")) return Products.valueOf("CUSTOM").setName(name.replace("custom",""));
        return Products.valueOf(name);
    }

    private Products setName(String name){this.name = name; return this;}

    public String getName() {return name;}

    @Override
    public String toString() {return Objects.requireNonNull(name);}
}
