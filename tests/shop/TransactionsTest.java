package shop;

import org.junit.Before;

import static org.junit.Assert.*;

public class TransactionsTest {

    private Transaction transaction1;
    private Transaction transaction2;
    private Transaction transaction3;

    @Before
    public void before(){
        transaction1 = new Transaction(PaymentMethodType.CASH);
    }

}