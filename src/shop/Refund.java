package shop;

public class Refund {

    private Double value;
    private PaymentMethod card;

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
        customer.getWallet().receiveRefund(getValue(), getCard());
    }
}