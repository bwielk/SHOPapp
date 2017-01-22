package example.codeclan.com.shop;

/**
 * Created by user on 21/01/2017.
 */

public class Shop {

    private int transaction;
    private int refund;

    public Shop() {
        transaction = 0;
        refund = 0;
    }

    public int getTransactionValue() {
        return transaction;
    }

    public void setTransaction(int value) {
        transaction += value;
    }

    public int getRefundsValue(){
        return refund;
    }

    public void setRefunds(int value){
        refund += value;
    }

    public int getIncome(){
        int income = transaction - refund;
        return income;
    }

    public String sell(Product product, int amount){
        int price = product.getPrice();
        if(amount > product.getStock()){
           return "Not enough products in stock";
        }else{
            product.setStock(product.getStock() - amount);
            setTransaction(price*amount);
            return "Transaction complete";
        }
    }

    public void acceptRefund(Product product) {
        int refund = product.getPrice();
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
