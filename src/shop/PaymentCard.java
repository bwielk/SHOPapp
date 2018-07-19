package shop;

public abstract class PaymentCard implements PaymentMethod{

    protected PaymentMethodType paymentType;
    protected double funds;

    public PaymentMethodType getCardType(){
        return this.paymentType;
    }
}
