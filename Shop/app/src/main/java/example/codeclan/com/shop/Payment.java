package example.codeclan.com.shop;

/**
 * Created by user on 25/01/2017.
 */

public class Payment {

    Double value;
    Shop shop;

    public Payment(){

        this.shop = null;
        this.value = 0.0;
    }

    public Double getValue(){
        return this.value;
    }

    public void setValue(Double value){
        this.value = value;
    }

    public void setShop(Shop shop){
        this.shop = shop;
    }
    public Shop getShop(){
        return this.shop;
    }

    public void create(Double value, Shop shop){
        setValue(value);
        setShop(shop);
    }

    public void sendPayment(){
        Shop shop = getShop();
        shop.setTransaction(getValue());
    }

}
