package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import database.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class for testing User Login
 * @version 1.0
 * @author Bogi Fjalar Sigurðsson - bfs11 - Hopur5T
 */
class LoginTest {

    /**
     * Initialize Data needed for login testing
     */
    @BeforeEach
    void setup(){
        UserDB.init();
    }

    /**
     * Method testing login of a valid user with a valid password
     */
    @Test
    void testValidUserLogin() {
        String validUserEmail = "jon@netfang.is";
        String validUserPassword = "12345";
        assertEquals(true, Login.loginUser(validUserEmail, validUserPassword));
    }

    /**
     * Method testing login of a valid user with an invalid password
     */
    @Test
    void testUserLoginWithWringPwd() {
        String validUserEmail = "jon@netfang.is";
        String inValidUserPassword = "NotTheCorrectPassword";
        assertEquals(false, Login.loginUser(validUserEmail, inValidUserPassword));
    }
}