package sample;

import java.util.ArrayList;

/**
 * The Pizza class that holds all information relevant for all pizzas.
 *
 * @author Tommy Cho, Neha Gudur
 */
public abstract class Pizza {
    protected ArrayList<Topping> toppings = new ArrayList<Topping>();
    protected Size size;


    //abstract method
    //do we need to include the topping and size increments in the price method since we already do it in the function methods?
    public abstract double price();
    public abstract String printPizza();

    /**
     * A helper method to convert a String of a topping to the Topping Type
     * @param topping topping being converted
     * @return topping in Topping type
     */
    private Topping toppingConverter(String topping){
        if (topping.equals("Pepperoni")){ return Topping.Pepperoni; }
        else if (topping.equals("Ham")){ return Topping.Ham; }
        else if (topping.equals("Sausage")){ return Topping.Sausage; }
        else if (topping.equals("Peppers")){ return Topping.Peppers; }
        else if (topping.equals("Onions")){ return Topping.Onions; }
        else if (topping.equals("Pineapple")){ return Topping.Pineapple; }
        else if (topping.equals("Mushrooms")){ return Topping.Mushrooms; }
        else if (topping.equals("Chicken")){ return Topping.Chicken; }
        else{ return Topping.Invalid; }
    }

    /**
     * Method to add a topping to the pizza.
     * Will output error message if the maximum number of toppings (7) have been reached.
     * Use toppingConverter() to convert input String to Topping type
     * @param topping topping to be added.
     */
    public void addTopping(String topping){

        if (toppings.size() < 7){
            if(toppings.contains(toppingConverter(topping))){
                System.out.println("Topping is already included!");
            }
            else{
                toppings.add(toppingConverter(topping));
                //price = price + toppingIncrement;
                System.out.println("Topping added");
            }
        }
        else{
            System.out.println("Maximum number of toppings reached!");
        }
    }

    /**
     * Method to remove a topping from the pizza.
     * Will output error messages if the topping is not removed.
     * Use toppingConverter() to convert input String to Topping type
     * @param topping topping that is being removed.
     */
    public void removeTopping(String topping){
        if (toppings.isEmpty()){
            System.out.println("No toppings on the pizza!");
        }
        else if (!toppings.contains(toppingConverter(topping))){
            System.out.println("This topping is not on the pizza!");
        }
        else{
            toppings.remove(toppingConverter(topping));
            //price = price - toppingIncrement;
            System.out.println("Topping removed");
        }
    }

    /**
     * A method to increase the size of the pizza.
     * Will output an error message if trying to increase the size of a large pizza.
     */
    public void increaseSize(){
        if (this.size == Size.Small){
            this.size = Size.Medium;
            //price = price + sizeIncrement;
        }
        else if (this.size == Size.Medium){
            this.size = Size.Large;
            //price = price + sizeIncrement;
        }
        else{
            System.out.println("This is the maximum size!");
        }
    }

    /**
     * A method to decrease the size of a pizza.
     * Will output an error message if trying to decrease the size of a small pizza.
     */
    public void decreaseSize(){
        if (this.size == Size.Large){
            this.size = Size.Medium;
            //price = price - sizeIncrement;
        }
        else if (this.size == Size.Medium){
            this.size = Size.Small;
            //price = price - sizeIncrement;
        }
        else{
            System.out.println("This is the minimum size!");
        }
    }
}
