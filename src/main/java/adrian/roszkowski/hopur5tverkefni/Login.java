package adrian.roszkowski.hopur5tverkefni;

public class Login {
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
