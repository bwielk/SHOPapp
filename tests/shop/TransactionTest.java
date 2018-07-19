package shop;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TransactionTest{

    private Basket basket;
    private Product product1;
    private Product product2;
    private Transaction transaction1;
    private Customer customer;
    private Customer customer1;
    private DebitCard card1;
    private CreditCard card2;
    private Shop shop;

    @Before
    public void before() {

        shop = new Shop("Dior");
        customer = new Customer("thomas@gmail.com", "09231129012");
        customer1 = new Customer("elza@gmail.com", "08772123344");
        card1 = new DebitCard();
        card2 = new CreditCard();
        customer.setFunds(card1, 100.00);
        customer1.setFunds(card2, 100.00);
        basket = new Basket();
        product1 = new Product("1111", 20.00, 3);
        product2 = new Product("2222", 30.00, 2);
        customer.addItem(product1);
        customer.addItem(product1);
        customer.addItem(product1);
        customer.addItem(product2);
        transaction1 = new Transaction(PaymentMethodType.CASH);
    }
    @Test
    public void canGetProductByName(){
        transaction1.create(card1, basket, shop);
        Product item = transaction1.getItemById("1111");
        assertEquals(20.00, item.getPrice(), 0.1);
    }

//    @Test
//    public void TransactionCanBeCreated(){
//        transaction1.create(card1, basket, shop);
//        assertEquals(card1, transaction1.getPayMethod());
//    }
//
//    @Test
//    public void TransactionCanBeCreated2(){
//        transaction1.create(card2, basket, shop);
//        assertEquals(card2, transaction1.getPayMethod());
//    }

    @Test
    public void TransactionRegistersItems(){
        transaction1.create(card2, basket, shop);
        assertEquals(4, transaction1.getItems().size());
    }

    @Test
    public void canGetShop(){
        transaction1.create(card2, basket, shop);
        assertEquals(shop, transaction1.getShop());
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