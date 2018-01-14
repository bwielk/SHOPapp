package example.codeclan.com.shop;

/**
 * Created by user on 21/01/2017.
 */

public class Shop {

    private String name;
    private Double transaction;
    private Double refund;

    public Shop(String name) {
        this.name = name;
        transaction = 0.0;
        refund = 0.0;
    }

    public String getName(){
        return this.name;
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

    public void transferRefund(Customer customer, Double value, PaymentMethod card){
        Refund refundForm = new Refund();
        refundForm.create(value, card);
        refundForm.sendRefund(customer);
    }

    public void acceptRefund(Customer customer, Product product, PaymentMethod card) {
        Double refund = product.getPrice();
        setRefunds(refund);
        product.setStock(product.getStock() +1);
        transferRefund(customer, refund, card);
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
