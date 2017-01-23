package example.codeclan.com.shop;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 21/01/2017.
 */

public class ShopTest{

    private Shop shop;
    private Product product;
    private Product product2;
    private Transaction transaction;

    @Before
    public void before(){
        shop = new Shop();
        product = new Product("1111", 20.00, 5);
        product2 = new Product("2222", 30.00, 4);
        transaction = new Transaction();
    }

    @Test
    public void shopHasTransactionValue(){
        assertEquals(0.0, shop.getTransactionValue(), 0.1);
    }

    @Test
    public void shopHasIncomeAfterSales(){
        shop.sell(product, 1);
        assertEquals(20.00, shop.getTransactionValue(), 0.1);
    }

    @Test
    public void shopHasUpdatesTransactionValueAfterSalesP2(){
        shop.sell(product, 5);
        shop.sell(product2, 1);
        assertEquals(130.00, shop.getTransactionValue(), 0.1);
    }

    @Test
    public void shopCanAcceptRefund(){
        shop.sell(product, 1);
        shop.sell(product2, 1);
        shop.acceptRefund(product);
        assertEquals(20.00, shop.getRefundsValue(), 0.1);
    }

    @Test
    public void shopCanCheckIncome(){
        shop.sell(product, 2);
        shop.sell(product2, 2);
        shop.acceptRefund(product);
        assertEquals(80.00, shop.getIncome(), 0.1);
    }

    @Test
    public void shopCanGenerateDailyReport(){
        shop.sell(product, 5);
        shop.sell(product2, 1);
        shop.acceptRefund(product);
        assertEquals("Total sales value: £110\nTotal refunds value: £20\nTotal transaction value: £130", shop.printReport());
    }

    @Test
    public void updatesStockAfterSales() {
        shop.sell(product, 2);
        assertEquals(3, product.getStock());
    }

    @Test
    public void updatesStockAfterRefund(){
        shop.sell(product, 2);
        shop.acceptRefund(product);
        assertEquals(4, product.getStock());

    }

    @Test
    public void cannotSellAnItemIfNotEnoughItems(){
        assertEquals("Not enough products in stock", shop.sell(product, 10));
    }
}