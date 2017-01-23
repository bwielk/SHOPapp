package example.codeclan.com.shop;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 21/01/2017.
 */
public class ProductTest {

    Product product;

    @Before
    public void before(){
        product = new Product("9999", 30.00, 5);
    }

    @Test
    public void canGetName(){
        assertEquals("9999", product.getName());
    }

    @Test
    public void canCheckTheStock(){
        assertEquals(5, product.getStock());
    }

    @Test
    public void canGetPrice(){
        assertEquals(30.00, product.getPrice(), 0.1);
    }

}