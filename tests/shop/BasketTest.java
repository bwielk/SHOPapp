package shop;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BasketTest {

    private Customer customer;
    private Product product;
    private Product product2;
    private Product product3;
    private Basket basket;

    @Before
    public void before(){
        customer = new Customer("liza@minelli.com", "02331121139");
        product = new Product("1111", 30.00, 2);
        product2 = new Product("2222", 25.00, 5);
        product3 = new Product("3333", 45.00, 1);
    }

    @Test
    public void basketCanStoreItems(){
        customer.addItem(product);
        customer.addItem(product2);
        assertEquals(2, customer.getBasket().numOfItems());
    }

    @Test
    public void backetCanBeEmptied(){
        customer.addItem(product);
        customer.addItem(product2);
        customer.emptyBasket();
        assertEquals(0, customer.getBasket().numOfItems());
    }

    @Test
    public void canGetTotalPriceOfAllItems(){
        customer.addItem(product);
        customer.addItem(product2);
        customer.addItem(product3);
        assertEquals(100.00, customer.getBasket().getTotalPrice(), 0.1);
    }

    @Test
    public void canGetTotalPriceAfterNumerousShoppingActions(){
        customer.addItem(product);//30
        customer.addItem(product2);//25
        customer.addItem(product3);//45
        customer.removeFromBasketByProductID(product3.getProductID());
        customer.addItem(product2);//25
        customer.removeFromBasketByProductID(product2.getProductID());
        customer.addItem(product);//30
        System.out.println(customer.getBasket().toString());
        assertEquals(85.00, customer.getBasket().getTotalPrice(), 0.1);
    }

    @Test
    public void onceItemIsRemovedFromBasketItsStockGetsUpdated(){
        customer.addItem(product2);
        customer.addItem(product2);
        customer.addItem(product2);
        customer.addItem(product);
        assertEquals(2, product2.getStock());
        assertEquals(1, product.getStock());
        customer.removeFromBasketByProductID(product2.getProductID());
        assertEquals(3, product2.getStock());
        customer.removeFromBasketByProductID(product2.getProductID());
        assertEquals(4, product2.getStock());
    }
}
