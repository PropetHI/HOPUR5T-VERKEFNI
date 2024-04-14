module adrian.roszkowski.hopur5tverkefni {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens adrian.roszkowski.hopur5tverkefni to javafx.fxml;
    exports adrian.roszkowski.hopur5tverkefni;

    exports hbv401.cluster5.mockdata;
    opens hbv401.cluster5.mockdata to javafx.fxml;

    opens is.hi.hotel_booking to javafx.fxml;
    exports is.hi.hotel_booking;
}

