package shop;

import java.util.ArrayList;

public class Basket {

    public ArrayList<Product> basket;

    public Basket(){
        basket = new ArrayList<Product>();
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

    public void remove(int index){
        basket.remove(index);
    }

    public Product getItem(int index){
        return basket.get(index);
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
 }