package shop;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest {

    private Shop shop;
    private Product product;
    private Customer customer;
    private Product product2;
    private Product product3;
    private CreditCard card1;
    private DebitCard card2;


    @Before
    public void before() {
        shop = new Shop("Dior");
        customer = new Customer("email@email.com", "07952221123");
        product = new Product("1111", 30.00, 4);
        product2 = new Product("2222", 25.00, 6);
        product3 = new Product("3333", 10.00, 8);
        card1 = new CreditCard();
        card2 = new DebitCard();
        customer.getWallet().setFunds(card1, 130.00);
        customer.getWallet().setFunds(card2, 125.00);
    }

    @Test
    public void customerHasEmailAndPhoneNumber(){
        assertEquals("email@email.com", customer.getEmail());
        assertEquals("07952221123", customer.getPhoneNumber());
    }

    @Test(expected = IllegalArgumentException.class)
    public void customerIsNotCreatedIfEmailIsWrong() throws IllegalArgumentException{
        new Customer("no_name@gmail@pl", "09871112233");
    }

    @Test(expected = IllegalArgumentException.class)
    public void customerIsNotCreatedIfPhoneNumberIsWrong_TooManyOrTooFewDigits() throws IllegalArgumentException{
        new Customer("no_name@gmail.com", "088211123311");
        new Customer("no_name@gmail.com", "0 882 111 233 11");
        new Customer("no_name@gmail.com", "88211123311");
        new Customer("no_name@gmail.com", "88211123311");
        new Customer("no_name@gmail.com", "882123311");
        new Customer("no_name@gmail.com", "098");
    }

    @Test(expected = IllegalArgumentException.class)
    public void customerIsNotCreatedIfPhoneNumberIsWrong_NonDigitCharacters() throws IllegalArgumentException{
        new Customer("no_name@gmail.com", "O2341122211");
        new Customer("no_name@gmail.com", "MyPhonenumber");
        new Customer("no_name@gmail.com", "0988j213453");
    }

    @Test
    public void customerIsCreatedWithAPhoneNumberContainingSpaces(){
        Customer newCustomer = new Customer("no_name@gmail.com", "0 123 123 11 12");
        assertEquals("01231231112", newCustomer.getPhoneNumber());
    }

    @Test
    public void customerIsCreatedIfThePhoneNumberContains10DigitsWithout0AtTheBeginning(){
        Customer newCustomer1 = new Customer("no_name@gmail.com", "9871234455");
        Customer newCustomer2 = new Customer("no_name@gmail.com", "0 987 123 44 55");
        assertEquals("09871234455", newCustomer1.getPhoneNumber());
        assertEquals("09871234455", newCustomer2.getPhoneNumber());
    }

    @Test(expected = IllegalArgumentException.class)
    public void customerIsNotCreatedIfThePhoneNumberContains10DigitsWithOneToThreeZerosAtTheBeginning() throws IllegalArgumentException{
        new Customer("no_name@gmail.com", "0 023 2113499");
        new Customer("no_name@gmail.com", "0 001 2113433");
        new Customer("no_name@gmail.com", "0 000 1113499");
    }

    @Test
    public void canAddItemsToTheBasket() {
        customer.addItem(product);
        customer.addItem(product2);
        assertEquals(2, customer.numOfItems());
    }

    @Test
    public void canEmptyBasket() {
        customer.addItem(product);
        customer.addItem(product2);
        customer.emptyBasket();
        assertEquals(0, customer.numOfItems());
    }

    @Test
    public void canDeleteAnItemByItemID_1() {
        customer.addItem(product);
        customer.addItem(product2);
        customer.removeFromBasketByProductID(product2.getProductID());
        Product example = customer.getBasket().getItemById(product.getProductID());
        assertEquals(30.00, example.getPrice(), 0.1);
    }

    @Test
    public void canRemoveAnItemByItemID_2() {
        customer.addItem(product);
        customer.addItem(product2);
        customer.addItem(product3);
        customer.removeFromBasketByProductID(product.getProductID());
        Product example1 = customer.getBasket().getItemById(product3.getProductID());
        assertEquals(10.00, example1.getPrice(), 0.1);
    }

    @Test
    public void canGetTotalFunds() {
        Double total = customer.getWallet().getTotalFunds();
        assertEquals(255.00, total, 0.1);
    }

    @Test
    public void canGetFundsOfAPArticularCard() {
        Double funds = customer.getWallet().getFunds(card1);
        assertEquals(130.00, funds, 0.1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotSetTheFundsWithAmountLessThan0() throws IllegalArgumentException{
        customer.getWallet().setFunds(card1, -100.00);
    }

    @Test
    public void canChangeFunds() {
        customer.getWallet().setFunds(card1, 100.00);
        assertEquals(100.00, customer.getWallet().getFunds(card1), 0.1);
    }

    @Test
    public void canPayForItemsInBasket1() {
        customer.addItem(product);
        customer.addItem(product2);
        customer.pay(card1, shop);
        assertEquals(75.00, customer.getWallet().getFunds(card1), 0.1);
    }

    @Test
    public void basketIsEmptyAfterTransaction() {
        customer.addItem(product);
        customer.addItem(product2);
        customer.pay(card1, shop);
        assertEquals(0, customer.numOfItems());
    }

    @Test
    public void customerGetsTransactionReceipt() {
        customer.addItem(product);
        customer.addItem(product2);
        customer.pay(card1, shop);
        customer.addItem(product);
        customer.addItem(product2);
        customer.pay(card1, shop);
        assertEquals(2, customer.getTransactions().numOfTransactions());
    }

    @Test
    public void customerCanShowReceipt() {
        customer.addItem(product);
        customer.addItem(product);
        customer.pay(card1, shop);
        customer.addItem(product2);
        customer.addItem(product3);
        customer.pay(card1, shop);
        customer.addItem(product3);
        customer.addItem(product3);
        customer.pay(card2, shop);
        assertEquals(3, customer.getTransactions().numOfTransactions());
        assertEquals(60.00, customer.getTransactions().getTransaction(0).getTotal(), 0.1);
        assertEquals(35.00, customer.getTransactions().getTransaction(1).getTotal(), 0.1);
        assertEquals(20.00, customer.getTransactions().getTransaction(2).getTotal(), 0.1);
    }

    @Test
    public void customerCanGetRefundandRefundMakesChangesToTheShop() { //card1 = 130 card2 = 125
        customer.addItem(product);//30
        customer.addItem(product2);//25
        customer.pay(card1, shop);
        customer.addItem(product);//30
        customer.addItem(product3);//10
        customer.addItem(product3);//10
        customer.pay(card2, shop);
        customer.getRefund(0,0, card2);//30
        customer.getRefund(0,1, card1);//25
        customer.getRefund(1,0, card2);//30
        customer.getRefund(1,2, card1);//10
        assertEquals(110.00, customer.getWallet().getFunds(card1), 0.1);
        assertEquals(135.00, customer.getWallet().getFunds(card2), 0.1);
        assertEquals(0, customer.numOfItems());
        assertEquals(105.00, shop.getTransactionValue(), 0.1);
        assertEquals(95.00, shop.getRefundsValue(), 0.1);
        assertEquals(10, shop.getIncome(), 0.1);
    }

    @Test
    public void customerCanGetRefundandRefundMakesChangesToTheShop2(){
        customer.addItem(product3);
        customer.addItem(product2);
        customer.pay(card1, shop);
    }

    @Test
    public void customerHasNothingToClaimRefundOn(){
        assertEquals("There is nothing to return!", customer.getRefund(0,0,card1));
    }
}
