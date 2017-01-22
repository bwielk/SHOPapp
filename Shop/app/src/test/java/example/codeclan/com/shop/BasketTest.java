package example.codeclan.com.shop;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 22/01/2017.
 */
public class BasketTest {

    private Product product;
    private Product product2;
    private Product product3;
    private Basket basket;

    @Before
    public void before(){
        product = new Product(30, 2);
        product2 = new Product(25, 5);
        product3 = new Product(45, 1);
        basket = new Basket();
    }

    @Test
    public void basketCanStoreItems(){
        basket.add(product);
        basket.add(product2);
        assertEquals(2, basket.numOfItems());
    }

    @Test
    public void backetCanBeEmptied(){
        basket.add(product);
        basket.add(product2);
        basket.empty();
        assertEquals(0, basket.numOfItems());
    }

    @Test
    public void canGetTotalPriceOfAllItems(){
        basket.add(product);
        basket.add(product2);
        basket.add(product3);
        assertEquals(100, basket.getTotalPrice());
    }

    @Test
    public void canGetTotalPriceAfterNumerousShoppingActions(){
        basket.add(product);
        basket.add(product2);
        basket.add(product3);
        basket.remove(2);
        basket.add(product2);
        basket.remove(1);
        basket.add(product);
        assertEquals(85, basket.getTotalPrice());

    }
}