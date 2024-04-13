module adrian.roszkowski.hopur5tverkefni {
    requires javafx.controls;
    requires javafx.fxml;


    opens adrian.roszkowski.hopur5tverkefni to javafx.fxml;
    exports adrian.roszkowski.hopur5tverkefni;
    exports hbv401.cluster5.mockdata;
    opens hbv401.cluster5.mockdata to javafx.fxml;
}