package example.codeclan.com.shop;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by user on 21/01/2017.
 */

public class Transaction {

    HashMap<PaymentMethod, Basket> transaction;
//    HashMap<PaymentMethod, Double> details;

    public Transaction(){
        transaction = new HashMap<PaymentMethod, Basket>();
//        details = new HashMap<PaymentMethod, Double>();
    }

    public void fillUp(PaymentMethod card, Basket basket){
        transaction.put(card, basket);
    }

    public Basket getBasket() {
        return transaction.get(transaction.keySet().toArray()[0]);

    }

    public PaymentMethod getPayMethod() {
        ArrayList<PaymentMethod> array = new ArrayList<PaymentMethod>();
        for (PaymentMethod key : transaction.keySet()) {
            array.add(key);
        }
        return array.get(0);
    }

//        ArrayList<Product> array = basket.prepForTransaction();
//        for(Product product : array) {
//            transaction.put(product.getName(), product.getPrice());
//        }
//    }
////
//    public Double getPriceByName(int index){
//        return transaction.get();
//    }
//
//    public void defPayType(PaymentMethod card, Basket basket){
//        transaction.put(card, basket.getTotalPrice());
//    }
//
//    public PaymentMethod getPayType(){
//        for (PaymentMethod key :
//    }
}
