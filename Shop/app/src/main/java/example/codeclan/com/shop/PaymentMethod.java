package example.codeclan.com.shop;

/**
 * Created by user on 21/01/2017.
 */

public interface PaymentMethod {
    Double getFunds();
    void receiveTransfer(Double value);
}
