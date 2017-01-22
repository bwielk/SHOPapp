package example.codeclan.com.shop;

/**
 * Created by user on 21/01/2017.
 */

public class Shop {

    private Double transaction;
    private Double refund;

    public Shop() {
        transaction = 0.0;
        refund = 0.0;
    }

    public Double getTransactionValue() {
        return transaction;
    }

    public void setTransaction(Double value) {
        transaction += value;
    }

    public Double getRefundsValue(){
        return refund;
    }

    public void setRefunds(Double value){
        refund += value;
    }

    public Double getIncome(){
        Double income = transaction - refund;
        return income;
    }

    public String sell(Product product, int amount){
        Double price = product.getPrice();
        if(amount > product.getStock()){
           return "Not enough products in stock";
        }else{
            product.setStock(product.getStock() - amount);
            Double x = (Double)(price*amount);
            setTransaction(x);
            return "Transaction complete";
        }
    }

    public void acceptRefund(Product product) {
        Double refund = product.getPrice();
        setRefunds(refund);
        product.setStock(product.getStock() +1);
    }

    @Override
    public String toString(){
        return  "Total sales value: £" + getIncome() +
                "\nTotal refunds value: £" + refund +
                "\nTotal transaction value: £" + transaction +"";
    }

    public String printReport(){
        return toString();
    }

}
