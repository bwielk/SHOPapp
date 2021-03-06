package shop;

public class DebitCard extends PaymentCard implements PaymentMethod{

    public DebitCard(){
        this.funds = 0.0;
        paymentType = PaymentMethodType.DEBIT_CARD;
    }

    public Double getFunds(){
        return this.funds;
    }

    public void receiveTransfer(Double value){
        this.funds += value;
    }
}
