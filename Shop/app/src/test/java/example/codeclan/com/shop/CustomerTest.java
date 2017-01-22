package example.codeclan.com.shop;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 21/01/2017.
 */
public class CustomerTest {

    private Product product;
    private Customer customer;
    private Product product2;
    private Product product3;
    private Basket basket;

    @Before
    public void before(){
        customer = new Customer();
        product = new Product(30, 2);
        product2 = new Product(25, 1);
        product3 = new Product(10, 3);
        basket = new Basket();
    }

    @Test
    public void canAddItemsToTheBasket(){
        customer.addItem(product);
        customer.addItem(product2);
        assertEquals(2, customer.numOfItems());
    }

    @Test
    public void canEmptyBasket(){
        customer.addItem(product);
        customer.addItem(product2);
        customer.emptyBasket();
        assertEquals(0, customer.numOfItems());
    }

    @Test
    public void canDeleteAnItem(){
        customer.addItem(product);
        customer.addItem(product2);
        customer.putBack(1);
        Product example = customer.getItem(0);
        assertEquals(30, example.getPrice());
    }

    @Test
    public void canDeleteAnItem2(){
        customer.addItem(product);
        customer.addItem(product2);
        customer.addItem(product3);
        customer.putBack(0);
        Product example = customer.getItem(1);
        assertEquals(10, example.getPrice());
    }
}