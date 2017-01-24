package example.codeclan.com.shop;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 24/01/2017.
 */
public class RefundTest {

    Refund refundForm;
    DebitCard card1;
    CreditCard card2;
    Customer customer;

    @Before
    public void before(){
        card1 = new DebitCard();
        card2 = new CreditCard();
        customer = new Customer();
        customer.setWallet(card1, 100.00);
        customer.setWallet(card2, 95.00);
        refundForm = new Refund();
    }

    @Test
    public void valueCanBeSet(){
        refundForm.setValue(45.00);
        assertEquals(45.00, refundForm.getValue(), 0.1);
    }

    @Test
    public void chosenCardCanBeSet(){
        refundForm.setCard(card1);
        PaymentMethod card = refundForm.getCard();
        assertEquals(100.00, customer.getFunds(card), 0.1);
    }

    @Test
    public void refundFormCanBeCreated(){
        refundForm.create(100.00, card2);
        assertEquals(card2, refundForm.getCard());
    }

    @Test
        public void canSendRefundToCustomer(){
        refundForm.create(100.00, card2);
        refundForm.sendRefund(customer);
        assertEquals(195.00, customer.getFunds(card2), 0.1);
    }

}