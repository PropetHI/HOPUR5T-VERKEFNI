package mock_database;

/**
 * Class for handling user login
 * @version 1.0
 * @author Bogi Fjalar Sigurðsson - bfs11 - Hopur5T
 */
public class Login {

    /**
     * Method for logging in a user
     * @param email
     * @param password
     * @return
     */
    public static boolean loginUser(String email, String password){
        boolean loginOk = false;
        if (UserDB.isAuthenticationValid(email, password)) {
            System.out.println("login ok");
            loginOk = true;
        }
        else {
            System.out.println("login failed");
            loginOk = false;
        }
        return loginOk;
    }
}
