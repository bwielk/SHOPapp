package example.codeclan.com.shop;

import java.util.ArrayList;

/**
 * Created by user on 21/01/2017.
 */

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
//    MOVES ALL THE BASKET ITEMS INTO ANOTHER ARRAY
//    public ArrayList<Product> prepForTransaction(){
//        ArrayList<Product> array = new ArrayList<Product>();
//        for(int i = 0; i < basket.size(); i += 1) {
//            array.add(basket.remove(i));
//            }
//        return array;
//        }
    }
