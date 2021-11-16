package com.example.demo;

import java.util.ArrayList;

/**
 * The Pizza class that holds all information relevant for all pizzas.
 *
 * @author Tommy Cho, Neha Gudur
 */
public abstract class Pizza {
    protected ArrayList<Topping> toppings = new ArrayList<Topping>();
    protected Size size;

    public abstract double price();

    public abstract String printPizza();

    /**
     * A helper method to convert a String of a topping to the Topping Type
     *
     * @param topping topping being converted
     * @return topping in Topping type
     */
    private Topping toppingConverter(String topping) {
        if (topping.equals("Pepperoni")) {
            return Topping.Pepperoni;
        } else if (topping.equals("Ham")) {
            return Topping.Ham;
        } else if (topping.equals("Sausage")) {
            return Topping.Sausage;
        } else if (topping.equals("Peppers")) {
            return Topping.Peppers;
        } else if (topping.equals("Onions")) {
            return Topping.Onions;
        } else if (topping.equals("Pineapple")) {
            return Topping.Pineapple;
        } else if (topping.equals("Mushrooms")) {
            return Topping.Mushrooms;
        } else if (topping.equals("Chicken")) {
            return Topping.Chicken;
        } else {
            return Topping.Invalid;
        }
    }

    /**
     * Method to add a topping to the pizza.
     * Will output error message if the maximum number of toppings (7) have been reached.
     * Use toppingConverter() to convert input String to Topping type
     *
     * @param topping topping to be added.
     */
    public void addTopping(String topping) {

        if (this.toppings.size() < 7) {
            if (this.toppings.contains(toppingConverter(topping))) {
                //topping contained already
            } else {
                this.toppings.add(toppingConverter(topping));
            }
        } else {
            //max number of toppings reached
        }
    }

    /**
     * Method to remove a topping from the pizza.
     * Will output error messages if the topping is not removed.
     * Use toppingConverter() to convert input String to Topping type
     *
     * @param topping topping that is being removed.
     */
    public void removeTopping(String topping) {
        if (this.toppings.isEmpty()) {
            //no toppings on the pizza
        } else if (!this.toppings.contains(toppingConverter(topping))) {
            //topping not on the pizza
        } else {
            this.toppings.remove(toppingConverter(topping));
        }
    }

    /**
     * Method to set size of pizza
     * @param size size being set  (Small, Medium, Large)
     */
    public void setSize(String size){
        if (size.equals("Small")){
            this.size = Size.Small;
        }
        else if (size.equals("Medium")){
            this.size = Size.Medium;
        }
        else{
            this.size = Size.Large;
        }
    }

    /**
     * A helper method that checks if a pizza has a certain topping or not
     *
     * @param topping topping being checked
     * @return true if topping is found, false otherwise.
     */
    public boolean hasTopping(String topping) {
        if (this.toppings.contains(toppingConverter(topping))) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * A method that shows the toppings that are available to be added to a pizza.
     *
     * @return availability of pizza toppings
     */
    public String showAvailableToppings() {
        StringBuilder str = new StringBuilder();
        if (!this.hasTopping("Pepperoni")) {
            str.append("Pepperoni\n");
        }
        if (!this.hasTopping("Ham")) {
            str.append("Ham\n");
        }
        if (!this.hasTopping("Sausage")) {
            str.append("Sausage\n");
        }
        if (!this.hasTopping("Peppers")) {
            str.append("Peppers\n");
        }
        if (!this.hasTopping("Onions")) {
            str.append("Onions\n");
        }
        if (!this.hasTopping("Pineapples")) {
            str.append("Pineapples\n");
        }
        if (!this.hasTopping("Mushroom")) {
            str.append("Mushroom\n");
        }
        if (!this.hasTopping("Chicken")) {
            str.append("Chicken\n");
        }
        return str.toString();
    }

    /**
     * A method to increase the size of the pizza.
     * Will output an error message if trying to increase the size of a large pizza.
     */
    public void increaseSize() {
        if (this.size == Size.Small) {
            this.size = Size.Medium;
            //price = price + sizeIncrement;
        } else if (this.size == Size.Medium) {
            this.size = Size.Large;
            //price = price + sizeIncrement;
        } else {
            //maximum size reached
        }
    }

    /**
     * A method to decrease the size of a pizza.
     * Will output an error message if trying to decrease the size of a small pizza.
     */
    public void decreaseSize() {
        if (this.size == Size.Large) {
            this.size = Size.Medium;
            //price = price - sizeIncrement;
        } else if (this.size == Size.Medium) {
            this.size = Size.Small;
            //price = price - sizeIncrement;
        } else {
            //minimum size reached
        }
    }
}
