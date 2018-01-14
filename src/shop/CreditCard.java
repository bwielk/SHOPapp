package shop;

public class CreditCard implements PaymentMethod {

    public Double funds;

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
