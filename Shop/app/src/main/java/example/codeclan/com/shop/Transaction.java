package example.codeclan.com.shop;

import android.util.Log;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by user on 21/01/2017.
 */

public class Transaction {

     HashMap<String, PaymentMethod> paymentType;
     ArrayList<Product> products;

    public Transaction() {
        this.paymentType = new HashMap<String, PaymentMethod>();
        this.products = new ArrayList<Product>();
    }

    public void create(PaymentMethod card, Basket basket){
        paymentType.put("type", card);
        products = basket.prepForTransaction();
    }

    public PaymentMethod getPayMethod(){
        return paymentType.get("type");
    }

    public ArrayList<Product> getItems(){
        return this.products;
    }
}












 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    HashMap<PaymentMethod, ArrayList<Product>> transaction;
////    HashMap<PaymentMethod, Double> details;
//
//    public Transaction(){
//        transaction = new HashMap<PaymentMethod, ArrayList<Product>>();
////      details = new HashMap<PaymentMethod, Double>();
//    }
//
//    public void fillUp(PaymentMethod card, Basket basket){
//        ArrayList<Product> items = basket.prepForTransaction();
//        transaction.put(card, items);
//    }
//
//    public ArrayList<Product> getBasket() {
//
//        ArrayList<Product> products = transaction.get(0);
//
//        return products;
//
//    }
//
//    public Double getTotal(){
//        ArrayList<Product> allProducts = getBasket();
//        Double total = 0.0;
//        for(Product product : allProducts){
//            total += product.getPrice();
//        }
//        return total;
//    }
//
//    public PaymentMethod getPayMethod() {
//        ArrayList<PaymentMethod> array = new ArrayList<PaymentMethod>();
//        for (PaymentMethod key : transaction.keySet()) {
//            array.add(key);
//        }
//        return array.get(0);
//    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////
//    public Double getPriceByName(int index){
//        return transaction.get();
//    }
//
//    public void defPayType(PaymentMethod card, Basket basket){
//        transaction.put(card, basket.getTotalPrice());
//    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
