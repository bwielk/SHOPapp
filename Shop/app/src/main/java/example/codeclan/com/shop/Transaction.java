package example.codeclan.com.shop;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by user on 21/01/2017.
 */

public class Transaction {

    HashMap<String, Double> transaction;
    HashMap<PaymentMethod, Double> details;

    public Transaction(){
        transaction = new HashMap<String, Double>();
        details = new HashMap<PaymentMethod, Double>();
    }

    public void fillUp(Basket basket){
        ArrayList<Product> array = basket.prepForTransaction();
        for(Product product : array) {
            transaction.put(product.getName(), product.getPrice());
        }
    }

    public Double getPriceByName(String name){
        return transaction.get(name);
    }

    public void defPayType(PaymentMethod card, Basket basket){
        details.put(card, basket.getTotalPrice());
    }
//
//    public PaymentMethod getPayType(){
//        for (PaymentMethod key :
//    }
}
