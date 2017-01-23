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
    private Customer customer;
    private Customer customer1;
    private DebitCard card1;
    private CreditCard card2;

    @Before
    public void before(){
        customer = new Customer();
        customer1 = new Customer();
        customer.setWallet(card1, 100.00);
        customer1.setWallet(card2, 100.00);
        basket = new Basket();
        product1 = new Product("1111", 20.00, 2);
        product2 = new Product("2222", 30.00, 1);
        basket.add(product1);
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

    @Test
    public void canTurnBasketIntoATransaction2(){
        transaction1.fillUp(basket);
        Double example = transaction1.getPriceByName("2222");
        assertEquals(30.00, example, 0.1);
    }
//    @Test
//    public void canDefineRegisterPaymentMethod(){
//        transaction1.defPayType(card1, basket);
//        assertEquals(card1, transaction1.getPayType());
//    }
}