package example.codeclan.com.shop;

/**
 * Created by user on 21/01/2017.
 */

public class Shop {

    int transaction;
    int refund;

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


    public void sell(Product product){
        int income = product.getPrice();
        setTransaction(income);
    }

    public void acceptRefund(Product product) {
        int refund = product.getPrice();
        setRefunds(refund);
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
