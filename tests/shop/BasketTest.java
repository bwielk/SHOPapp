package shop;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BasketTest {

    private Product product;
    private Product product2;
    private Product product3;
    private Basket basket;

    @Before
    public void before(){
        product = new Product("1111", 30.00, 2);
        product2 = new Product("2222", 25.00, 5);
        product3 = new Product("3333", 45.00, 1);
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
        assertEquals(100.00, basket.getTotalPrice(), 0.1);
    }

    @Test
    public void canGetTotalPriceAfterNumerousShoppingActions(){
        basket.add(product);//30
        basket.add(product2);//25
        basket.add(product3);//45
        basket.removeByProductID(product3.getProductID());
        basket.add(product2);//25
        basket.removeByProductID(product2.getProductID());
        basket.add(product);//30
        System.out.println(basket.toString());
        assertEquals(85.00, basket.getTotalPrice(), 0.1);
    }
}
