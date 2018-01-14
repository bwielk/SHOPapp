package shop;

import java.util.ArrayList;
import java.util.HashMap;

public class Transaction {

    HashMap<String, PaymentMethod> paymentType;
    ArrayList<Product> products;
    Shop shop;


    public Transaction() {
        this.paymentType = new HashMap<String, PaymentMethod>();
        this.products = new ArrayList<Product>();
        this.shop = new Shop("Dior");
    }

    public Product getItemByName(String name) {
        Product productFound = null;
        for (Product product : products) {
            if (product.getName() == name) {
                productFound = product;
            } else {
                System.out.println("No item found");
            }
        }
        return productFound;
    }

    public void create(PaymentMethod card, Basket basket, Shop shop){
        paymentType.put("type", card);
        products = basket.prepForTransaction();
        this.shop = shop;
    }

    public PaymentMethod getPayMethod(){
        return paymentType.get("type");
    }

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
