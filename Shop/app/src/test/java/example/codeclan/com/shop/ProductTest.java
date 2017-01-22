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
        product = new Product(30, 5);
    }

    @Test
    public void cachCheckTheStock(){
        assertEquals(5, product.getStock());
    }

}