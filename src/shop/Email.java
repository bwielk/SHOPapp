package shop;

public class Email {

    private String email;

    public Email(String email){
        checkTheEmailAddress(email);
    }

    public String getEmailAddress(){
        return this.email;
    }

    private void checkTheEmailAddress(String email){
        String emailRegex = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";
        if(email.matches(emailRegex)){
            this.email = email;
        }else{
            throw new IllegalArgumentException("Invalid date format. " +
                    "\nThe email format should be like this: name@domain.com");
        }
    }
}
