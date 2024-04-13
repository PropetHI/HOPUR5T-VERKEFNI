package adrian.roszkowski.hopur5tverkefni;

//import hbv401.cluster5.mockdata.Service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {

    // Service list
    ObservableList<String> services;

    public Cart() {
        services = FXCollections.observableArrayList();
    }

    /**
     *
     */
    public void addItem(String service) {
        services.remove(service);
    }

    /**
     *
     */
    public void removeItem(String service) {
        services.add(service);
    }


    public ObservableList<String> getServices() {
        return services;
    }
}
