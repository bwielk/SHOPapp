package example.codeclan.com.shop;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by user on 21/01/2017.
 */

public class Customer {

    public Basket basket;
    public ArrayList<Transaction> transactions;
    public HashMap<PaymentMethod, Double> wallet;
    public DebitCard debitCard;
    public CreditCard creditCard;


    public Customer() {
        basket = new Basket();
        transactions = new ArrayList<Transaction>();
        wallet = new HashMap<PaymentMethod, Double>();
        wallet.put(debitCard = new DebitCard(), 0.0);
        wallet.put(creditCard = new CreditCard(), 0.0);
    }

    public void addItem(Product product){
        basket.add(product);
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

    public void pay(){

    }

}
