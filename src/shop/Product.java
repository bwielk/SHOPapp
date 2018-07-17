package shop;

public class Product {

    private String productID;
    private Double price;
    private int stock;

    public Product(String productID,Double price, int stock){
        this.productID = productID;
        this.price = price;
        this.stock = stock;
    }

    public String getProductID(){
        return this.productID;
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