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

    public String add(Product product){
        if(product.getStock()<1){
            return "Not enough pieces in stock!";
        }else {
            basket.add(product);
            product.setStock(product.getStock()-1);
            return "Item has been added";
        }
    }

    public void empty(){
        basket.clear();
    }

    public void removeByProductID(String productID){
        basket.removeIf(item -> getItemById(productID).getProductID().equals(productID));
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

    public ArrayList<Product> prepForTransaction(){
        ArrayList<Product> array = new ArrayList<Product>();
        int basketSize = basket.size();

        for(int i = 0; i < basketSize; i += 1) {
            Product product = basket.remove(0);
            array.add(product);
            }
        return array;
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