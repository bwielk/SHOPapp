package shop;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.*;

public class Customer {

    private String email;
    private String phoneNumber;
    private Basket basket;
    private List<Transaction> transactions;
    private HashMap<PaymentMethod, Double> wallet;

    public Customer(String email, String phoneNumber) {
        String emailRegex = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";
        String phoneRegex = "^\\s*0\\s*[1-9]{3}\\s*\\d{3}\\s*(\\d{4}|\\d{2}\\s*\\d{2})\\s*$";
        if(email.matches(emailRegex)){
            this.email = email;
        }else{
            throw new IllegalArgumentException("Invalid date format. " +
                                                    "\nThe email format should be like this: name@domain.com");
        }
        phoneNumber = phoneNumber.replaceAll(" ", "");
        if(!phoneNumber.startsWith("0") && phoneNumber.length() == 10){
            phoneNumber = "0" + phoneNumber;
        }
        if(phoneNumber.matches(phoneRegex)){
            this.phoneNumber = phoneNumber;
        }else{
            throw new IllegalArgumentException("Invalid phone number format. " +
                                                    "\nThe phone number format should be like this: 09876543322");
        }
        this.basket = new Basket();
        this.transactions = new LinkedList<Transaction>();
        this.wallet = new HashMap<PaymentMethod, Double >();
    }

    public String getEmail(){
        return email;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void addItem(Product product){
        basket.add(product);
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

    public void putBack(int index){
        basket.remove(index);
    }

    public void emptyBasket(){
        basket.empty();
    }

    public int numOfItems(){
        return basket.numOfItems();
    }

    public Product getItem(int index){
        return basket.getItem(index);
    }

    public HashMap<PaymentMethod, Double> getCards(){
        return this.wallet;
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