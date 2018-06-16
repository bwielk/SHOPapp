package shop;

public class CreditCard extends PaymentCard implements PaymentMethod {

    public CreditCard(){
       this.funds = 0.0;
    }

    public Double getFunds(){
        return this.funds;
    }

    public void receiveTransfer(Double value){
        this.funds += value;
    }
}
