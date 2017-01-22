package example.codeclan.com.shop;

/**
 * Created by user on 21/01/2017.
 */

public class Product {

    int price;
    int stock;

    public Product(int price, int stock){
        this.price = price;
        this.stock = stock;
    }

    public int getPrice(){
        return this.price;
    }

    public int getStock(){
        return this.stock;
    }

    public void setStock(int number){
        this.stock -= number;
    }

}
