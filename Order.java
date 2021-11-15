package com.example.demo;

import java.text.DecimalFormat;
import java.util.ArrayList;


/**
 * The Order class that allows the user to add, remove, and edit pizzas for an order
 *
 * @author Tommy Cho, Neha Gudur
 */
public class Order {

    private Long phoneNumber;
    private ArrayList<Pizza> pizzas = new ArrayList<Pizza>();

    /**
     * Setter method for phone number
     *
     * @param phoneNumber number that is being set
     */
    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Getter method for phone number
     *
     * @return phone number of instance
     */
    public Long getPhoneNumber() {
        return this.phoneNumber;
    }

    public ArrayList<Pizza> getPizzas() {
        return this.pizzas;
    }

    /**
     * Method to add a pizza to the order
     *
     * @param pizza pizza being added
     */
    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    /**
     * Method to remove a pizza from the order
     * The GUI will display the list of pizzas in the order, so the input can correspond to that.
     *
     * @param pizzaIndex index at which the pizza being removed is found
     */
    public void removePizza(int pizzaIndex) {
        if (pizzas.isEmpty()) {
            System.out.println("Order is empty!");
        } else {
            pizzas.remove(pizzaIndex);
            System.out.println("Pizza removed");
        }
    }

    /**
     * A method that calculates the order's total
     *
     * @return total price of the order
     */
    private double getOrderTotal() {
        double orderTotal = 0.0;
        for (int i = 0; i < pizzas.size(); i++) {
            orderTotal = orderTotal + pizzas.get(i).price();
        }
        return orderTotal;
    }

    /**
     * A method that calculates the order's tax
     *
     * @return tax of the order
     */
    private double getTax() {
        return this.getOrderTotal() * 0.0625;
    }

    public double getGrandTotal() {
        return (this.getOrderTotal() + this.getTax());
    }

    /**
     * Method to print the complete details of an order.
     *
     * @return order in String form
     */
    public String printOrder() {
        DecimalFormat dec = new DecimalFormat("#0.00");
        dec.setGroupingUsed(true);
        dec.setGroupingSize(3);
        int indexFixer = 1;
        StringBuilder str = new StringBuilder();
        str.append("Order for " + phoneNumber + ".\n");
        str.append("Number of pizzas in this order: " + pizzas.size() + "\n");
        for (int i = 0; i < pizzas.size(); i++) {
            str.append(i + indexFixer + ". " + pizzas.get(i).printPizza() + "\n");
        }
        str.append("Tax: $" + dec.format(this.getTax()) + "\n");
        str.append("Order Total: $" + dec.format(this.getGrandTotal()) + "\n");
        return str.toString();
    }

    public static void main(String[] args) { //testbed main
        Order test = new Order(); //create new order
        test.setPhoneNumber(7323369471L); //set phone number identifier
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
        test.addPizza(pizza1); //add pizza1 to order
        Pizza pizza2 = PizzaMaker.createPizza("Hawaiian"); //create new pizza
        Pizza pizza3 = PizzaMaker.createPizza("Deluxe"); //create new pizza
        pizza2.increaseSize(); //increase size of pizza2 to medium
        pizza3.addTopping("Pineapple"); //add pineapple to pizza3
        test.addPizza(pizza2); //add pizza2 to order
        test.addPizza(pizza3); //add pizza3 to order
        System.out.println(test.printOrder()); //print order
        test.removePizza(2); //remove pizza3 from order
        System.out.println(test.printOrder()); //print order
    }
}
