package shop;

public class PhoneNumber {

    private String phoneNumber;

    public PhoneNumber(String phoneNumber){
        checkThePhoneNumber(phoneNumber);
    }

    public String getFullPhoneNumber(){
        return this.phoneNumber;
    }

    private void checkThePhoneNumber(String phoneNumber){
        String phoneRegex = "^\\s*0\\s*[1-9]{3}\\s*\\d{3}\\s*(\\d{4}|\\d{2}\\s*\\d{2})\\s*$";
        phoneNumber = phoneNumber.replaceAll(" ", "");
        if(!phoneNumber.startsWith("0") && phoneNumber.length() == 10){
            phoneNumber = "0" + phoneNumber;
        }
        if(phoneNumber.matches(phoneRegex)){
            this.phoneNumber = phoneNumber;
        }else{
            throw new IllegalArgumentException("Invalid phone number format. " +
                    "\nThe phone number format should be like this: 09876543322");
        }
    }
}
