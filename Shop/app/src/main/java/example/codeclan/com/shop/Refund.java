package example.codeclan.com.shop;

/**
 * Created by user on 24/01/2017.
 */

public class Refund {

    Double value;
    PaymentMethod card;

    public Refund(){
        value = 0.0;
        card = null;
    }

    public void setValue(Double refund){
        this.value = refund;
    }

    public void create(Double value, PaymentMethod card){

    }
}
