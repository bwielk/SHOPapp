package example.codeclan.com.shop;

/**
 * Created by user on 21/01/2017.
 */

public class Product {

    Double price;
    int stock;

    public Product(Double price, int stock){
        this.price = price;
        this.stock = stock;
    }

    public Double getPrice(){
        return this.price;
    }

    public int getStock(){
        return this.stock;
    }

    public void setStock(int number){
        this.stock -= number;
    }

}
