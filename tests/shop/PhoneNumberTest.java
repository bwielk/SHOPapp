package shop;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PhoneNumberTest {

    private PhoneNumber phoneNumber;

   @Before
   public void before(){
       this.phoneNumber = new PhoneNumber("0 787 232 21 11");
   }

   @Test
    public void phoneNumberIsCreatedAndWeCanGetItsStringValue(){
       assertEquals("07872322111", phoneNumber.getFullPhoneNumber());
       this.phoneNumber = new PhoneNumber("0 1121121122");
       assertEquals("01121121122", phoneNumber.getFullPhoneNumber());
       this.phoneNumber = new PhoneNumber("09811123111");
       assertEquals("09811123111", phoneNumber.getFullPhoneNumber());
       this.phoneNumber = new PhoneNumber("07941112233");
       assertEquals("07941112233", phoneNumber.getFullPhoneNumber());
   }

   @Test(expected = IllegalArgumentException.class)
    public void phoneNumberIsNotCreatedIfPhoneNumberIsInvalid1() throws IllegalArgumentException{
       PhoneNumber phoneNumberNotWorking = new PhoneNumber("1223451123");
   }

    @Test(expected = IllegalArgumentException.class)
    public void phoneNumberIsNotCreatedIfPhoneNumberIsInvalid2() throws IllegalArgumentException{
       PhoneNumber phoneNumberNotWorking = new PhoneNumber("122 112 112 1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void phoneNumberIsNotCreatedIfPhoneNumberIsInvalid3() throws IllegalArgumentException{
        PhoneNumber phoneNumberNotWorking = new PhoneNumber("0999112321");
    }

}