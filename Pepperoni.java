package sample;

import java.lang.StringBuilder;
import java.text.DecimalFormat;

/**
 * The Pepperoni class that extends the Pizza class and holds relevant information for pepperoni pizas.
 *
 * @author Tommy Cho, Neha Gudur
 */
public class Pepperoni extends Pizza {

    private static final double pepperoniBasePrice = 8.99;
    private static final int pepperoniBaseToppings = 1;
    //constants for price adjustments
    protected static final double sizeIncrement = 2.0;
    protected static final double toppingIncrement = 1.49;

    /**
     * The method to determine the price of a pepperoni pizza.
     *
     * @return price of the pizza in double form.
     */
    public double price() {
        double price = pepperoniBasePrice;
        if (toppings.size() > pepperoniBaseToppings) {
            price = price + ((toppings.size() - pepperoniBaseToppings) * toppingIncrement);
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
     * The print method for an instance of pepperoni pizza.
     *
     * @return the details of this pepperoni pizza in String form
     */
    public String printPizza() {
        DecimalFormat dec = new DecimalFormat("#0.00");
        dec.setGroupingUsed(true);
        dec.setGroupingSize(3);
        StringBuilder str = new StringBuilder();
        str.append(this.size.pizzaSizeString() + " Pepperoni Pizza - Toppings: ");
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

    public static void main(String[] args) { //testbed main
        Pizza pizza1 = PizzaMaker.createPizza("Pepperoni"); //create new pepperoni pizza
        System.out.println(pizza1.printPizza()); //default pizza
        pizza1.addTopping("Pineapple"); //add pineapple topping
        pizza1.addTopping("Pineapple"); //add pineapple topping (should return error msg)
        System.out.println(pizza1.printPizza()); //print pepperoni pizza with pineapple
        pizza1.increaseSize(); //increase size to medium
        System.out.println(pizza1.printPizza()); //print medium pepperoni pizza w pineapple
        pizza1.increaseSize(); //increase size to large
        System.out.println(pizza1.printPizza()); //print large pepperoni pizza w pineapple
        pizza1.decreaseSize(); //decrease size to medium
        System.out.println(pizza1.printPizza()); //print medium pepperoni pizza w pineapple
        pizza1.decreaseSize(); //decrease size to small
        pizza1.decreaseSize(); //decrease size (should return error msg)
        pizza1.removeTopping("Pineapple"); //remove pineapple
        pizza1.removeTopping("Pineapple"); //remove pineapple (should return error msg)
        pizza1.removeTopping("Pepperoni"); //remove pepperoni
        System.out.println(pizza1.printPizza()); //print small pepperoni pizza without pepperoni but same base price
        pizza1.addTopping("Pepperoni"); //add pepperoni
        System.out.println(pizza1.showAvailableToppings()); //shows available toppings for pizza (should be all but pepperoni)
    }
}
