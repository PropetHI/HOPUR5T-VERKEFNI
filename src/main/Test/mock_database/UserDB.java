package mock_database;

/**
 * MockObject class to represent User DB
 * @version 1.0
 * @author Bogi Fjalar Sigurðsson - bfs11 - Hopur5T
 *
 */
public class UserDB {
    private static User user0 = new User("Jon Jonsson", "jon@netfang.is", "12345");
    private static User user1 = new User("Gunna Gunnarsdottir", "gunna@netfang.is","12345");
    private static User[] userDB = new User[2];


    /**
     * Method to initialize system with demo users
     */
    public static void init() {
        userDB[0] = user0;
        userDB[1] = user1;

    }

    /**
     * Method to validate user and password
     */
    public static boolean isAuthenticationValid(String email, String password){
        boolean userValid = false;
        for (int i=0; i < userDB.length; i++){
            if ((email == userDB[i].getEmail()) && (password == userDB[i].getPassword())){
                userValid = true;
            }
        }
        return userValid;
    }

}