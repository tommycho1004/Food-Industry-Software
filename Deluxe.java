package com.example.demo;

import java.lang.StringBuilder;
import java.text.DecimalFormat;

/**
 * The Deluxe class that extends the Pizza class and holds relevant information for deluxe pizzas.
 *
 * @author Tommy Cho, Neha Gudur
 */
public class Deluxe extends Pizza {

    private static final double deluxeBasePrice = 12.99;
    private static final int deluxeBaseToppings = 5;
    //constants for price adjustments
    protected static final double sizeIncrement = 2.0;
    protected static final double toppingIncrement = 1.49;

    /**
     * The method to determine the price of a deluxe pizza.
     *
     * @return price of the pizza in double form.
     */
    public double price() {
        double price = deluxeBasePrice;
        if (toppings.size() > deluxeBaseToppings) {
            price = price + ((toppings.size() - deluxeBaseToppings) * toppingIncrement);
        }
        if (this.size == Size.Medium) {
            price = price + sizeIncrement;
        }
        if (this.size == Size.Large) {
            price = price + sizeIncrement + sizeIncrement;
        }
        return price;
    }

    /**
     * The print method for an instance of deluxe pizza.
     *
     * @return the details of this deluxe pizza in String form
     */
    public String printPizza() {
        DecimalFormat dec = new DecimalFormat("#0.00");
        dec.setGroupingUsed(true);
        dec.setGroupingSize(3);
        StringBuilder str = new StringBuilder();
        str.append(this.size.pizzaSizeString() + " Deluxe Pizza - Toppings: ");
        if (toppings.isEmpty()) {
            str.append("None");
        } else {
            str.append(toppings.get(0));
            for (int i = 1; i < toppings.size(); i++) {
                str.append(", " + toppings.get(i));
            }
        }
        str.append(" - Subtotal: $" + dec.format(this.price()));
        return str.toString();
    }
}
