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
    private CreditCard card1;
    private DebitCard card2;

    @Before
    public void before(){
        customer = new Customer();
        product = new Product("1111", 30.00, 2);
        product2 = new Product("2222", 25.00, 1);
        product3 = new Product("3333", 10.00, 3);
        basket = new Basket();
        card1 = new CreditCard();
        card2 = new DebitCard();
        customer.setWallet(card1, 130.00);
        customer.setWallet(card2, 125.00);
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
        assertEquals(30.00, example.getPrice(), 0.1);
    }

    @Test
    public void canDeleteAnItem2(){
        customer.addItem(product);
        customer.addItem(product2);
        customer.addItem(product3);
        customer.putBack(0);
        Product example1 = customer.getItem(1);
        assertEquals(10.00, example1.getPrice(),0.1);
    }

    @Test
    public void canGetTotalFunds(){
        Double total = customer.getTotalFunds();
        assertEquals(255.00, total, 0.1);
    }

    @Test
    public void canGetFundsOfAPArticularCard(){
        Double funds = customer.getFunds(card1);
        assertEquals(130.00, funds, 0.1);
    }

    @Test
    public void CanChangeFunds(){
        customer.setFunds(card1, 100.00);
        assertEquals(100.00, customer.getFunds(card1), 0.1);
    }

    @Test
    public void canPayForItemsInBasket1(){
        customer.addItem(product);
        customer.addItem(product2);
        customer.pay(card1);
        assertEquals(75.00, customer.getFunds(card1), 0.1);
    }

    }