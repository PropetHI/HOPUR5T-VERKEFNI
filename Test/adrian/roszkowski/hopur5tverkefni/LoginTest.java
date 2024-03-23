package adrian.roszkowski.hopur5tverkefni;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginTest {

    @BeforeEach
    void setup(){
        UserDB.init();
    }
    @Test
    void testValidUserLogin() {
        String validUserEmail = "jon@netfang.is";
        String validUserPassword = "12345";
        assertEquals(true, Login.loginUser(validUserEmail, validUserPassword));
    }

    @Test
    void testUserLoginWithWringPwd() {
        String validUserEmail = "jon@netfang.is";
        String inValidUserPassword = "NotTheCorrectPassword";
        assertEquals(false, Login.loginUser(validUserEmail, inValidUserPassword));
    }
}