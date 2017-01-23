package example.codeclan.com.shop;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by user on 21/01/2017.
 */

public class Customer {

    private Basket basket;
    private ArrayList<Transaction> transactions;
    private HashMap<PaymentMethod, Double> wallet;

    public Customer() {
        this.basket = new Basket();
        this.transactions = new ArrayList<Transaction>();
        this.wallet = new HashMap<PaymentMethod, Double >();
    }

    public void addItem(Product product){
        basket.add(product);
    }

    public void setWallet(PaymentMethod card, Double funds){
        wallet.put(card, funds);
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

    public void setFunds(PaymentMethod card, Double funds){////card class method??
        wallet.put(card, funds);
    }

    public Double getFunds(PaymentMethod card){
        Double funds = wallet.get(card); //getting a value of the card
        return funds;
    }


    public Double getTotalFunds(){
        Double total = 0.0;
        HashMap<PaymentMethod, Double> cards = getCards();
        for( Double funds : cards.values()){ //cards.values() = an "arrayish" Collection of values
            total += funds;
        }
        return total;
    }

    public String pay(PaymentMethod card) {
        if (getFunds(card) < basket.getTotalPrice()) {
            return "Not enough funds on your card! Try again";
        } else {
            Double fundsLeft = getFunds(card) - basket.getTotalPrice();
            setFunds(card, fundsLeft);
            Transaction transaction = new Transaction();
            transaction.fillUp(card, basket);
            basket.empty();
            transactions.add(transaction);
            return "Transaction complete!";
        }
    }

    public String refund(Product product){

    }

}


//HashMap<Product, Double> transaction = new HashMap<Product, Double>();
//for(Product product : basket){
//  transaction.put(product.getName product.getPrice);
// }}