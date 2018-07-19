package shop;

import java.util.*;

public class Customer {

    private Email email;
    private PhoneNumber phoneNumber;
    private Basket basket;
    private Transactions transactions;
    private CustomerWallet wallet;

    public Customer(String email, String phoneNumber) {
        String id = new Date().toString();
        this.email = new Email(email);
        this.phoneNumber = new PhoneNumber(phoneNumber);
        this.basket = new Basket();
        this.transactions = new Transactions();
        this.wallet = new CustomerWallet(id);
    }

    public String getEmail(){
        return email.getEmailAddress();
    }

    public String getPhoneNumber(){
        return phoneNumber.getFullPhoneNumber();
    }

    public Basket getBasket(){
        return basket;
    }

    public CustomerWallet getWallet(){
        return this.wallet;
    }

    public Transactions getTransactions() {
        return this.transactions;
    }

    public boolean addItem(Product product){
        if(product != null && basket.canCustomerAddProductToBasket(product)) {
            basket.getBasket().add(product);
            return true;
        }
        return false;
    }

    public boolean removeFromBasketByProductID(String productID){
        if(productID != null){
            basket.removeItemByID(productID);
            return true;
        };
        return false;
    }

    public void emptyBasket(){
        basket.getBasket().clear();
    }

    public int numOfItems(){
        return basket.numOfItems();
    }

    public String pay(PaymentMethod card, Shop shop) {
        if (wallet.getFunds(card) < basket.getTotalPrice()) {
            return "Not enough funds on your card! Try again";
        } else {
            Payment payment = new Payment();
            payment.create(basket.getTotalPrice(), shop);
            payment.sendPayment();
            Double fundsLeft = wallet.getFunds(card) - basket.getTotalPrice();
            wallet.setFunds(card, fundsLeft);
            Transaction transaction = new Transaction(PaymentMethodType.CASH);
            transaction.create(card, basket, shop);
            basket.getBasket().clear();
            transactions.addTransaction(transaction);
            return "Transaction complete!";
        }
    }

    public String getRefund(int transactionIndexNum, int itemIndexNum, PaymentMethod card) {
        if (transactions.getTransactions().size() != 0) {
            Transaction transaction = (Transaction) transactions.getTransactions().get(transactionIndexNum);
            Shop shop = transaction.getShop();
            Product productToReturn = transaction.getItems().get(itemIndexNum);
            transaction.getItems().set(itemIndexNum, null);
            shop.acceptRefund(this, productToReturn, card);
            return "You have received a successful refund";
        } else {
            return "There is nothing to return!";
        }
    }
}