package adrian.roszkowski.hopur5tverkefni;

/**
 * User class for user objects
 * @version 1.0
 * @author Bogi Fjalar Sigurðsson - bfs11 - Hopur5T
 */
public class User {
    private String name;
    private String email;
    private String password;


    /**
     * Constructor for User Class
     * @param name
     * @param email
     * @param password
     */
    public User (String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }

    /**
     * Method that returns the name of the user
     * @return
     */
    public String getName(){
        return name;
    }

    /**
     * Method that returns the email (login id) of the user
     * @return
     */
    public String getEmail(){
        return email;
    }

    /**
     * Method that returns the password of the user
     * @return
     */
    public String getPassword(){
        return password;
    }

}
