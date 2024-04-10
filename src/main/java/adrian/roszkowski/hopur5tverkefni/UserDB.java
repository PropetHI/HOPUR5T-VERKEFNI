package adrian.roszkowski.hopur5tverkefni;

/**
 * MockObject class to represent User DB
 * @version 1.0
 * @author Hopur5T
 *
 */
public class UserDB {

    private static User user0 = new User("Demo User", "demo", "demo");
    private static User user1 = new User("Jon Jonsson", "jon@netfang.is", "12345");
    private static User user2 = new User("Gunna Gunnarsdottir", "gunna@netfang.is","12345");
    private static User[] userDB = new User[3];


    /**
     * Method to initialize system with demo users
     */
    public static void init() {
        userDB[0] = user0;
        userDB[1] = user1;
        userDB[2] = user2;

    }

    /**
     * Method to validate user and password
     */
    public static boolean isAuthenticationValid(String email, String password){
        boolean userValid = false;
        //System.out.println("Got Params: " + email + " , "  + password);

        for (int i=0; i < userDB.length; i++){
            //System.out.println(email +"=" +  userDB[i].getEmail() + " - " + password + "=" + userDB[i].getPassword() );
            if ((email.equals(userDB[i].getEmail())) && (password.equals(userDB[i].getPassword())) ){
                userValid = true;
                //System.out.println("Login valid in DB");
            }
        }
        return userValid;
    }

}
