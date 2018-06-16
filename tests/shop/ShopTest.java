package shop;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ShopTest{

    private Shop shop;
    private Product product;
    private Product product2;
    private DebitCard card1;
    private CreditCard card2;
    private Customer customer;
    private Payment payment1;
    private Payment payment2;

    @Before
    public void before(){
        shop = new Shop("Chanel");
        product = new Product("1111", 20.00, 10);
        product2 = new Product("2222", 30.00, 10);
        card1 = new DebitCard();
        card2 = new CreditCard();
        customer = new Customer("tony@gmail.com", "07823341123");
        customer.setWallet(card1, 100.00);
        customer.setWallet(card2, 120.00);
        payment1 = new Payment();
        payment2 = new Payment();
    }

    @Test
    public void updatesStockAfterSales() {
        shop.sell(product, 2);
        assertEquals(8, product.getStock());
    }

    @Test
    public void updatesStockAfterRefund(){
        shop.sell(product, 2);
        shop.acceptRefund(customer, product, card2); //-1
        assertEquals(9, product.getStock());
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
        shop.acceptRefund(customer, product, card2);
        assertEquals(20.00, shop.getRefundsValue(), 0.1);
    }

    @Test
    public void shopCanCheckIncome(){
        shop.sell(product, 2);
        shop.sell(product2, 2);
        shop.acceptRefund(customer, product, card1);
        assertEquals(80.00, shop.getIncome(), 0.1);
    }

    @Test
    public void shopCanGenerateDailyReport(){
        shop.sell(product, 5);
        shop.sell(product2, 1);
        shop.acceptRefund(customer, product, card1);
        assertEquals("Total sales value: �110.0\nTotal refunds value: �20.0\nTotal transaction value: �130.0", shop.printReport());
    }


    @Test
    public void cannotSellAnItemIfNotEnoughItems(){
        assertEquals("Not enough products in stock", shop.sell(product, 11));
    }

    @Test
    public void shopCanTransferRefunds(){
        shop.transferRefund(customer, 30.00, card1);
        assertEquals(130.00, customer.getFunds(card1), 0.1);
    }

    @Test
    public void shopCanReceivePaymentFromCustomer(){
        payment1.create(60.00, shop);
        payment1.sendPayment();
        payment2.create(65.00, shop);
        payment2.sendPayment();
        assertEquals(125.00, shop.getTransactionValue(), 0.1);
    }
}