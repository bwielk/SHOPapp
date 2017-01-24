package example.codeclan.com.shop;

/**
 * Created by user on 22/01/2017.
 */

public class CreditCard implements PaymentMethod {

    public Double funds;

    public CreditCard(){
       this.funds = 0.0;
    }

    public Double getFunds(){
        return funds;
    }

    public void receiveTransfer(Double value){
        this.funds += value;
    }
}
