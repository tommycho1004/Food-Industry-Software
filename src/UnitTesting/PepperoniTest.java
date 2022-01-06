package UnitTesting;

import com.example.demo.Pizza;
import com.example.demo.PizzaMaker;
import com.example.demo.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PepperoniTest {
    @Test
    void price(){
        ArrayList<Topping> testToppings = new ArrayList<Topping>();
        testToppings.add(Topping.Pepperoni);
        Double expected1 = 8.99;
        Double expected2 = 8.99;
        Double expected3 = 8.99;
        Double expected4 = 11.97;
        Double expected5 = 10.99;
        Double expected6 = 12.99;
        Double expected7 = 15.97;
        Double expected8 = 13.97;
        Pizza testPizza = PizzaMaker.createPizza("Pepperoni");
        testPizza.setToppings(testToppings); //adding pepperoni
        Double actual1 = testPizza.price(); //base price of a small pepperoni pizza
        testToppings.remove(Topping.Pepperoni); //removing pepperoni
        testPizza.setToppings(testToppings);
        Double actual2 = testPizza.price(); //price of a pepperoni pizza without pepperoni (0 toppings)
        testToppings.add(Topping.Pineapple);
        testPizza.setToppings(testToppings);
        Double actual3 = testPizza.price(); //price of a pepperoni pizza with 1 topping that's not pepperoni
        testToppings.add(Topping.Onions);
        testToppings.add(Topping.Peppers);
        testPizza.setToppings(testToppings);
        Double actual4 = testPizza.price(); //price of pepperoni pizza with 3 toppings
        Pizza testPizza2 = PizzaMaker.createPizza("Pepperoni"); //create new test pizza
        testToppings.clear();
        testToppings.add(Topping.Pepperoni);
        testPizza2.setToppings(testToppings);
        testPizza2.setSize(Size.Medium);
        Double actual5 = testPizza2.price(); //price of a medium pepperoni pizza
        testPizza2.setSize(Size.Large);
        Double actual6 = testPizza2.price(); //price of a large pepperoni pizza
        testToppings.add(Topping.Chicken);
        testToppings.add(Topping.Onions);
        testPizza2.setToppings(testToppings);
        Double actual7 = testPizza2.price(); //price of a large pepperoni pizza with 3 toppings
        testPizza2.setSize(Size.Medium);
        Double actual8 = testPizza2.price(); //price of a medium pepperoni pizza with 3 toppings
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
        assertEquals(expected5, actual5);
        assertEquals(expected6, actual6);
        assertEquals(expected7, actual7);
        assertEquals(expected8, actual8);
    }
}
