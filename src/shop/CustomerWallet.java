package shop;

import java.util.*;

public class CustomerWallet {

    private Map wallet;
    private String customerID;

    public CustomerWallet(String customerID){
        customerID = customerID;
        wallet = new HashMap<PaymentMethod, Double>();
    }

    public void setFunds(PaymentMethod card, Double funds){
        if(funds > 0) {
            wallet.put(card, funds);
        }else{
            throw new IllegalArgumentException("Entered funds should be greater than 0");
        }
    }

    public void receiveRefund(Double value, PaymentMethod card){
        Double currentFunds = (Double) wallet.get(card);
        Double updatedFunds = currentFunds + value;
        wallet.put(card, updatedFunds);
    }

    public Double getFunds(PaymentMethod card){
        Double funds = (Double) wallet.get(card);
        return funds;
    }

    public Map getCards(){
        return this.wallet;
    }

    public Double getTotalFunds(){
        Double total = 0.0;
        HashMap<PaymentMethod, Double> cards = (HashMap)getCards();
        for( Double funds : cards.values()){
            total += funds;
        }
        return total;
    }
}
