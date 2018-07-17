package shop;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.*;

public class Customer {

    private Email email;
    private PhoneNumber phoneNumber;
    private Basket basket;
    private List<Transaction> transactions;
    private HashMap<PaymentMethod, Double> wallet;

    public Customer(String email, String phoneNumber) {
        this.email = new Email(email);
        this.phoneNumber = new PhoneNumber(phoneNumber);
        this.basket = new Basket();
        this.transactions = new LinkedList<Transaction>();
        this.wallet = new HashMap<PaymentMethod, Double>();
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

    public HashMap getCards(){
        return this.wallet;
    }

    public boolean addItem(Product product){
        if(product != null) {
            basket.getBasket().add(product);
            return true;
        }
        return false;
    }

    public int numOfTransactions(){
        return transactions.size();
    }

    public Transaction getTransaction(int index){
        return transactions.get(index);
    }

    public void setFunds(PaymentMethod card, Double funds){
        if(funds > 0) {
            wallet.put(card, funds);
        }else{
            throw new IllegalArgumentException("Entered funds should be greater than 0");
        }
    }

    public boolean removeFromBasketByProductID(String productID){
        if(productID != null){
            basket.removeByProductID(productID);
            return true;
        };
        return false;
    }

    public void emptyBasket(){
        basket.empty();
    }

    public int numOfItems(){
        return basket.numOfItems();
    }

    public void receiveRefund(Double value, PaymentMethod card){
        Double currentFunds = wallet.get(card);
        Double updatedFunds = currentFunds + value;
        wallet.put(card, updatedFunds);
    }

    public Double getFunds(PaymentMethod card){
        Double funds = wallet.get(card);
        return funds;
    }

    public Double getTotalFunds(){
        Double total = 0.0;
        HashMap<PaymentMethod, Double> cards = getCards();
        for( Double funds : cards.values()){
            total += funds;
        }
        return total;
    }

    public String pay(PaymentMethod card, Shop shop) {
        if (getFunds(card) < basket.getTotalPrice()) {
            return "Not enough funds on your card! Try again";
        } else {
            Payment payment = new Payment();
            payment.create(basket.getTotalPrice(), shop);
            payment.sendPayment();
            Double fundsLeft = getFunds(card) - basket.getTotalPrice();
            setFunds(card, fundsLeft);
            Transaction transaction = new Transaction();
            transaction.create(card, basket, shop);
            basket.empty();
            transactions.add(transaction);
            return "Transaction complete!";
        }
    }

    public String getRefund(int transactionIndexNum, int itemIndexNum, PaymentMethod card) {
        if (transactions.size() != 0) {
            Transaction transaction = transactions.get(transactionIndexNum);
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