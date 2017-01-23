package example.codeclan.com.shop;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 23/01/2017.
 */
public class TransactionTest {

    private Basket basket;
    private Product product1;
    private Product product2;
    private Transaction transaction1;

    @Before
    public void before(){
        basket = new Basket();
        product1 = new Product("1111", 20.00, 3);
        product2 = new Product("2222", 30.00, 1);
        basket.add(product1);
        basket.add(product2);
        transaction1 = new Transaction();
    }

    @Test
    public void canTurnBasketIntoATransaction(){
        transaction1.fillUp(basket);
        Double example = transaction1.getPriceByName("1111");
        assertEquals(20.00, example, 0.1);
    }
}