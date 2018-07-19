package shop;

import java.util.*;

public class Transactions {

    private HashMap<String, Transaction> transactions;
    private TransactionIDGenerator idGenerator = new TransactionIDGenerator();

    public boolean addTransaction(Transaction transaction){
        String transactionID = idGenerator.run();
        if(transaction != null && !checkIfThereIsSimilarId(transactionID)){
            transactions.put(transactionID, transaction);
            return true;
        }
        return false;
    }

    public Map getTransactions(){
        return this.transactions;
    }

    private boolean checkIfThereIsSimilarId(String id){
        if(transactions.containsKey(id)){
            return true;
        }
        return false;
    }

    public int numOfTransactions(){
        return transactions.size();
    }


    public Transaction getTransaction(int index){
        return transactions.get(index);
    }

    private class TransactionIDGenerator {

        private String run(){
            return new Date().toString();
        }
    }
}