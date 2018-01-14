package shop;

public interface PaymentMethod {
	Double getFunds();
    void receiveTransfer(Double value);
}
