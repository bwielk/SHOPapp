package shop;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmailTest {

    private Email email1;
    private Email email2;

    @Before
    public void before(){
        this.email1 = new Email("bwielk@gmail.com");
    }

    @Test
    public void canGetItsEmailAddress() {
        assertEquals("bwielk@gmail.com", email1.getEmailAddress());
    }

    @Test(expected = IllegalArgumentException.class)
    public void theEmailThrowsExceptionWhenWrongEmailFormat1() throws IllegalArgumentException{
        new Email("manchester1992@abc.@123");
    }

    @Test(expected = IllegalArgumentException.class)
    public void theEmailThrowsExceptionWhenWrongEmailFormat2() throws IllegalArgumentException{
        new Email("london@abc@abc.co.uk");
    }
}