package shop;

import java.util.ArrayList;
import java.util.HashMap;

public class Transaction {

    PaymentMethodType paymentMethodType;
    ArrayList<Product> products;
    Shop shop;


    public Transaction(PaymentMethodType paymentMethod) {
        this.paymentMethodType = paymentMethod;
        this.products = new ArrayList<Product>();
        this.shop = new Shop("Dior");
    }

    public Product getItemById(String id) {
        Product productFound = null;
        for (Product product : products) {
            if (product.getProductID() == id) {
                productFound = product;
            } else {
                System.out.println("No item found");
            }
        }
        return productFound;
    }

    public void create(PaymentMethod card, Basket basket, Shop shop){
        //products = basket.prepForTransaction();
        this.shop = shop;
    }

//    public PaymentMethod getPayMethod(){
//        //return paymentType.get("type");
//    }

    public ArrayList<Product> getItems(){
        return this.products;
    }

    public Shop getShop(){
        return this.shop;
    }

    public Double getTotal(){
        Double total = 0.0;
        for(Product product : products){
            total += product.getPrice();
        }
        return total;
    }
}
