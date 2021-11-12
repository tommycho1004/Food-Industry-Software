package sample;

/**
 * The PizzaMaker class that instantiates a pizza depending on a chosen flavor
 * Flavors are: Pepperoni, Hawaiian, Deluxe (case sensitive)
 *
 * @author Tommy Cho, Neha Gudur
 */
//create an instance of subclasses based on the chosen flavor
public class PizzaMaker {

    //constants for base prices of each pizza flavor
    private static final double pepperoniBasePrice = 8.99;
    private static final double hawaiianBasePrice = 10.99;
    private static final double deluxeBasePrice = 12.99;

    /**
     * A method that instantiates a pizza.
     *
     * @param flavor flavor of pizza being created
     * @return pizza that was made
     */
    public static Pizza createPizza(String flavor) {
        if (flavor.equals("Pepperoni") || flavor.equals("pepperoni")) {
            Pepperoni pizza = new Pepperoni();
            pizza.addTopping("Pepperoni");
            pizza.size = Size.Small;
            return pizza;
        } else if (flavor.equals("Hawaiian") || flavor.equals("hawaiian")) {
            Hawaiian pizza = new Hawaiian();
            pizza.addTopping("Ham");
            pizza.addTopping("Pineapple");
            pizza.size = Size.Small;
            return pizza;
        } else { //if (flavor.equals("Deluxe") || flavor.equals("deluxe"))
            Deluxe pizza = new Deluxe();
            pizza.addTopping("Sausage");
            pizza.addTopping("Pepperoni");
            pizza.addTopping("Mushrooms");
            pizza.addTopping("Onions");
            pizza.addTopping("Peppers");
            pizza.size = Size.Small;
            return pizza;
        }
    }
}
