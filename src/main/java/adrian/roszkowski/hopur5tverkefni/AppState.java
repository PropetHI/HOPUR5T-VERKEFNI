package adrian.roszkowski.hopur5tverkefni;

import hbv401.cluster5.mockdata.*;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;



public class AppState {
    protected static String currentUser;

    public static BooleanProperty userLoggedInBoolProperty = new SimpleBooleanProperty(false);


    public static void init(){
        UserDB.init();
        //ServiceDB.init();
        MockFlightDB.init();
        MockHotelDB.init();
        MockDTourDB.init();

        //ServiceInteractor.getServiceList();
    }
}
