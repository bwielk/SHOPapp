package shop;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PaymentTest {

    Payment transfer;
    Customer customer;
    Shop shop;


    @Before
    public void before(){
        transfer = new Payment();
        customer = new Customer("greg@gmail.com", "07652223311");
        shop = new Shop("Vetements");
    }

    @Test
    public void CanSetTheValueOfTheTransfer(){
        transfer.setValue(45.00);
        assertEquals(45.00, transfer.getValue(), 0.1);

    }

    @Test
    public void CanSetTheShopWhichReceivesThePayment(){
        transfer.setShop(shop);
        assertEquals("Vetements", transfer.getShop().getName());
    }

    @Test
    public void PaymentCanBeInitiated(){
        transfer.create(60.00, shop);
        assertEquals(60.00, transfer.getValue(), 0.1);
    }

    @Test
    public void PaymentCanBeSentToTheShop(){
        transfer.create(60.00, shop);
        transfer.sendPayment();
        transfer.create(115.00, shop);
        transfer.sendPayment();
        assertEquals(175.00, shop.getTransactionValue(), 0.0);
    }
}