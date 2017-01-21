package example.codeclan.com.shop;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 21/01/2017.
 */

public class ShopTest{

    Shop shop;
    Product product;
    Product product2;
    Transaction transaction;

    @Before
    public void before(){
        shop = new Shop();
        product = new Product(20);
        product2 = new Product(30);
        transaction = new Transaction();
    }

    @Test
    public void shopHasTransactionValue(){
        assertEquals(0, shop.getTransactionValue());
    }

    @Test
    public void shopHasIncomeAfterSales(){
        shop.sell(product);
        assertEquals(20, shop.getTransactionValue());
    }

    @Test
    public void shopHasUpdatesTransactionValueAfterSalesP2(){
        shop.sell(product);
        shop.sell(product2);
        assertEquals(50, shop.getTransactionValue());
    }

    @Test
    public void shopCanAcceptRefund(){
        shop.sell(product);
        shop.sell(product2);
        shop.acceptRefund(product);
        assertEquals(20, shop.getRefundsValue());
    }

    @Test
    public void shopCanCheckIncome(){
        shop.sell(product);
        shop.sell(product2);
        shop.acceptRefund(product);
        assertEquals(30, shop.getIncome());
    }

    @Test
    public void shopCanGenerateDailyReport(){
        shop.sell(product);
        shop.sell(product2);
        shop.acceptRefund(product);
        assertEquals("Total sales value: £30\nTotal refunds value: £20\nTotal transaction value: £50", shop.printReport());
    }
}