package shop;

public class DebitCard implements PaymentMethod{

    double funds;

    public DebitCard(){
        this.funds = 0.0;
    }

    public Double getFunds(){
        return this.funds;
    }

    public void receiveTransfer(Double value){
        this.funds += value;
    }
}
