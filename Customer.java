package example.codeclan.com.shop;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by user on 21/01/2017.
 */

public class Customer {

    public ArrayList<Product> basket;
    public ArrayList<Transaction> transaction;
    public HashMap<PaymentMethod, Double> wallet;

    public Customer() {
        basket = new ArrayList<Product>();
        transaction = new ArrayList<Transaction>();
        wallet = new HashMap<PaymentMethod, Double>();
    }


}
