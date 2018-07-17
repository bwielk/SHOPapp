package shop;

import java.util.*;
import java.util.stream.Collectors;

public class Basket {

    public List<Product> basket;

    public Basket(){
        basket = new LinkedList<Product>();
    }

    public List getBasket(){
        return this.basket;
    }

    public int numOfItems(){
        return basket.size();
    }

    public boolean canCustomerAddProductToBasket(Product product){
        if(product.getStock()<1){
            return false;
        }
        product.setStock(product.getStock()-1);
        return true;
    }

    public void empty(){
        basket.clear();
    }

    public void removeByProductID(String productID){
        for(Product product : basket){
            if(product.getProductID().equals(productID)){
                basket.remove(basket.indexOf(product));
                product.setStock(product.getStock() + 1);
                break;
            }
        }
    }

    public Product getItemById(String id){
        List<Product> results = basket.stream()
                .filter(product -> product.getProductID() == id)
                .collect(Collectors.toList());
        return results.get(0);
    }

    public Double getTotalPrice(){
        Double total = 0.0;
        for(Product product : basket){
            total += product.getPrice();
        }
        return total;
    }

    @Override
    public String toString() {
       StringBuffer textToPrint = new StringBuffer();
       textToPrint.append("\n\n ---  BASKET REPORT ---");
       for(Product product : basket){
           textToPrint.append("\nINDEX = " + basket.indexOf(product) +
                            "\n ; ID = " + product.getProductID() +
                            "\n ; PRICE = " + product.getPrice());
       }
       return textToPrint.toString();
    }
}