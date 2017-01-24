package example.codeclan.com.shop;

/**
 * Created by user on 24/01/2017.
 */

public class Refund {

    Double value;
    PaymentMethod card;

    public Refund(){
        this.value = 0.0;
        this.card = null;
    }

    public void setValue(Double refund){
        this.value = refund;
    }

    public Double getValue(){
        return this.value;
    }

    public void setCard(PaymentMethod card){
        this.card = card;
    }

    public PaymentMethod getCard(){
        return this.card;
    }

    public void create(Double value, PaymentMethod card){
        setValue(value);
        setCard(card);
    }

    public void sendRefund(Customer customer){
        customer.receiveRefund(getValue(), getCard());
    }
}
