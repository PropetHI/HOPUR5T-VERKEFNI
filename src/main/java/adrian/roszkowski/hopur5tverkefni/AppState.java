package adrian.roszkowski.hopur5tverkefni;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class AppState {
    //public static boolean userLoggedIn;
    protected static String currentUser;

    public static BooleanProperty userLoggedInBoolProperty = new SimpleBooleanProperty(false);


    public static void init(){
        UserDB.init();
        ServiceDB.init();

        ServiceInteractor.getServiceList();
    }
}
