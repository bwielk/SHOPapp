package example.codeclan.com.shop;

/**
 * Created by user on 21/01/2017.
 */

public class Product {

    private String name;
    private Double price;
    private int stock;

    public Product(String name,Double price, int stock){
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getName(){
        return this.name;
    }

    public Double getPrice(){
        return this.price;
    }

    public int getStock(){
        return this.stock;
    }

    public void setStock(int number){
        this.stock = number;
    }

}
