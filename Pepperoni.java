package sample;

import java.lang.StringBuilder;

public class Pepperoni extends Pizza{

    private static final double pepperoniBasePrice = 8.99;
    private static final int pepperoniBaseToppings = 1;
    //constants for price adjustments
    protected static final double sizeIncrement = 2.0;
    protected static final double toppingIncrement = 1.49;

    /**
     * The method to determine the price of a pepperoni pizza.
     * @return price of the pizza in double form.
     */
    public double price(){
        double price = pepperoniBasePrice;
        if (toppings.size() > pepperoniBaseToppings){
            price = price + ((toppings.size() - pepperoniBaseToppings) * toppingIncrement);
        }
        if (this.size == Size.Medium){
            price = price + sizeIncrement;
        }
        if (this.size == Size.Large){
            price = price + sizeIncrement + sizeIncrement;
        }
        return price;
    }

    /**
     * The print method for an instance of pepperoni pizza.
     * @return the details of this pepperoni pizza in String form
     */
    public String printPizza(){
        StringBuilder str = new StringBuilder();
        str.append(this.size.pizzaSizeString() + " Pepperoni Pizza - Toppings: ");
        if (toppings.isEmpty()){
            str.append("None");
        }
        else{
            str.append(toppings.get(0));
            for (int i = 1; i < toppings.size(); i++){
                str.append(", " + toppings.get(i));
            }
        }
        str.append(" - Subtotal: $" + this.price());
        return str.toString();
    }

    public static void main(String[]args){
        Pizza test = PizzaMaker.createPizza("Pepperoni"); //create new pepperoni pizza
        System.out.println(test.printPizza()); //default pizza
        test.addTopping("Pineapple"); //add pineapple topping
        test.addTopping("Pineapple"); //add pineapple topping (should return error msg)
        System.out.println(test.printPizza()); //print pepperoni pizza with pineapple
        test.increaseSize(); //increase size to medium
        System.out.println(test.printPizza()); //print medium pepperoni pizza w pineapple
        test.increaseSize(); //increase size to large
        System.out.println(test.printPizza()); //print large pepperoni pizza w pineapple
        test.decreaseSize(); //decrease size to medium
        System.out.println(test.printPizza()); //print medium pepperoni pizza w pineapple
        test.decreaseSize(); //decrease size to small
        test.decreaseSize(); //decrease size (should return error msg)
        test.removeTopping("Pineapple"); //remove pineapple
        test.removeTopping("Pineapple"); //remove pineapple (should return error msg)
        test.removeTopping("Pepperoni"); //remove pepperoni
        System.out.println(test.printPizza()); //print small pepperoni pizza without pepperoni but same base price
    }
}