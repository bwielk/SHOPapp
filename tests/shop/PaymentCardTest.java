package shop;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PaymentCardTest {

    private PaymentCard card1;
    private PaymentCard card2;

    @Before
    public void before(){
        card1 = new DebitCard();
        card2 = new CreditCard();
    }

    @Test
    public void cardHoldItsSpecificType(){
        assertEquals(PaymentMethodType.CREDIT_CARD, card2.getCardType());
        assertEquals(PaymentMethodType.DEBIT_CARD, card1.getCardType());
    }

}