package com.example.demo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * The StoreOrders class that holds a list of all orders the store has taken
 * This class can export store orders into another text file with export()
 *
 * @author Tommy Cho, Neha Gudur
 */

public class StoreOrders {
    private ArrayList<Order> orders = new ArrayList<Order>();

    /**
     * Getter method for order list
     * @return list of orders
     */
    public ArrayList<Order> getOrders() {
        return this.orders;
    }

    /**
     * A method to add an order to the list of orders
     *
     * @param order order that is being added
     */
    public void addOrder(Order order) {
        orders.add(order);
    }

    /**
     * A method to remove an order from the list of orders
     *
     * @param order the order being removed in the list
     */
    public void removeOrder(Order order) {
        if (orders.isEmpty()) {
            //no orders to show
        } else {
            orders.remove(order);
        }
    }

    /**
     * A method to find a specific order in the list of orders given a phone number
     * @param phoneNumber phone number being found
     * @return true if order is found, false otherwise
     */
    public Order findOrder(String phoneNumber){
        for (int i = 0; i < orders.size(); i++){
            if (orders.get(i).getPhoneNumber().equals(phoneNumber)){
                return orders.get(i);
            }
        }
        return null;
    }


    /**
     * A method to print the orders in the list.
     *
     * @return list of orders in String form
     */
    public String printOrders() {
        DecimalFormat dec = new DecimalFormat("#0.00");
        dec.setGroupingUsed(true);
        dec.setGroupingSize(3);
        int indexFixer = 1;
        StringBuilder str = new StringBuilder();
        str.append("List of Orders:\n");
        for (int i = 0; i < orders.size(); i++) {
            str.append(orders.get(i).printOrder() + "\n");
        }
        return str.toString();
    }

    public void export() {
        File myObj = new File("StoreOrders.txt");
        try {
            FileWriter myWriter = new FileWriter("StoreOrders.txt");
            myWriter.write(this.printOrders());
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) { //testbed main
        Order order1 = new Order(); //create new order
        order1.setPhoneNumber("7323369471"); //set phone number identifier
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
        order1.addPizza(pizza1); //add pizza1 to order
        Pizza pizza2 = PizzaMaker.createPizza("Hawaiian"); //create new pizza
        Pizza pizza3 = PizzaMaker.createPizza("Deluxe"); //create new pizza
        pizza2.increaseSize(); //increase size of pizza2 to medium
        pizza3.addTopping("Pineapple"); //add pineapple to pizza3
        order1.addPizza(pizza2); //add pizza2 to order
        order1.addPizza(pizza3); //add pizza3 to order
        System.out.println(order1.printOrder()); //print order
        order1.removePizza(2); //remove pizza3 from order
        System.out.println(order1.printOrder()); //print order
        //break
        Order order2 = new Order(); //make new example order
        order2.setPhoneNumber("2016003382");
        Pizza pizza4 = PizzaMaker.createPizza("Pepperoni");
        pizza4.addTopping("Onions");
        pizza4.increaseSize();
        pizza4.increaseSize();
        Pizza pizza5 = PizzaMaker.createPizza("Hawaiian");
        pizza5.removeTopping("Pineapples");
        pizza5.increaseSize();
        order2.addPizza(pizza4);
        order2.addPizza(pizza5);
        //break
        StoreOrders test = new StoreOrders();
        test.addOrder(order1);
        test.addOrder(order2);
        System.out.println(test.printOrders());
        test.removeOrder(order1);
        System.out.println(test.printOrders());
        test.export();
    }
}
