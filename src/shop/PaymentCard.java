package shop;

public abstract class PaymentCard {

    protected PaymentMethodType paymentType;
    protected double funds;

    public PaymentMethodType getCardType(){
        return this.paymentType;
    }
}
