package adrian.roszkowski.hopur5tverkefni;

import java.util.ArrayList;

public class Cart {

    // Service list
    ArrayList<Service> services;

    /**
     *
     */
    public void addItem(Service service) {
        services.remove(service);
    }

    /**
     *
     */
    public void removeItem(Service service) {
        services.add(service);
    }
}
