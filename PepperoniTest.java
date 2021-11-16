import com.example.demo.Pizza;
import com.example.demo.PizzaMaker;
import com.example.demo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PepperoniTest {
    @Test
    void price(){
        Double expected1 = 8.99;
        Double expected2 = 8.99;
        Double expected3 = 8.99;
        Double expected4 = 11.97;
        Double expected5 = 10.99;
        Double expected6 = 12.99;
        Double expected7 = 15.97;
        Double expected8 = 13.97;
        Pizza testPizza = PizzaMaker.createPizza("Pepperoni");
        Double actual1 = testPizza.price(); //base price of a small pepperoni pizza
        testPizza.removeTopping("Pepperoni");
        Double actual2 = testPizza.price(); //price of a pepperoni pizza without pepperoni (0 toppings)
        testPizza.addTopping("Pineapple");
        Double actual3 = testPizza.price(); //price of a pepperoni pizza with 1 topping that's not pepperoni
        testPizza.addTopping("Pepperoni");
        testPizza.addTopping("Mushrooms");
        Double actual4 = testPizza.price(); //price of pepperoni pizza with 3 toppings
        Pizza testPizza2 = PizzaMaker.createPizza("Pepperoni"); //create new test pizza
        testPizza2.increaseSize();
        Double actual5 = testPizza2.price(); //price of a medium pepperoni pizza
        testPizza2.increaseSize();
        Double actual6 = testPizza2.price(); //price of a large pepperoni pizza
        testPizza2.addTopping("Chicken");
        testPizza2.addTopping("Tomatoes");
        Double actual7 = testPizza2.price(); //price of a large pepperoni pizza with 3 toppings
        testPizza2.decreaseSize();
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
