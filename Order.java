package sample;

import java.util.ArrayList;

public class Order {

    private int phoneNumber;
    private ArrayList<Pizza> pizzas = new ArrayList<Pizza>();

    /**
     * Method to add a pizza to the order
     * @param pizza
     */
    private void addPizza(Pizza pizza){
        pizzas.add(pizza);
    }

    private void removePizza(Pizza pizza){
        if (pizzas.isEmpty()){
            System.out.println("Order is empty!");
        }
        else if (!pizzas.contains(pizza)){
            System.out.println("");
        }
    }

    private void checkOrder(){ //pretty much the print method

    }

    public String printOrder(){
        return "Test.";
    }
}
