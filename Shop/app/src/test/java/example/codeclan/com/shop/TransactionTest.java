package example.codeclan.com.shop;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by user on 23/01/2017.
 */
public class TransactionTest{

    private Basket basket;
    private Product product1;
    private Product product2;
    private Transaction transaction1;
    private Customer customer;
    private Customer customer1;
    private DebitCard card1;
    private CreditCard card2;

    @Before
    public void before() {
        customer = new Customer();
        customer1 = new Customer();
        card1 = new DebitCard();
        card2 = new CreditCard();
        customer.setWallet(card1, 100.00);
        customer1.setWallet(card2, 100.00);
        basket = new Basket();
        product1 = new Product("1111", 20.00, 3);
        product2 = new Product("2222", 30.00, 2);
        basket.add(product1);
        basket.add(product1);
        basket.add(product1);
        basket.add(product2);
        transaction1 = new Transaction();
    }


    @Test
    public void TransactionCanBeCreated(){
        transaction1.create(card1, basket);
        assertEquals(card1, transaction1.getPayMethod());
    }

    @Test
    public void TransactionCanBeCreated2(){
        transaction1.create(card2, basket);
        assertEquals(card2, transaction1.getPayMethod());
    }

    @Test
    public void TransactionRegistersItems(){
        transaction1.create(card2, basket);
        assertEquals(4, transaction1.getItems().size());
    }


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    @Test
//    public void canTurnBasketIntoATransaction() {
//        transaction1.fillUp(card1, basket);
//        assertEquals(card1, transaction1.getPayMethod());
//    }
//
//    @Test
//    public void canInteractWithBoughtItems() {
//        transaction1.fillUp(card2, basket);
//        assertEquals(90.00, transaction1.getTotal(), 0.1);
//    }
//}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}