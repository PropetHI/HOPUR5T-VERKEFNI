package adrian.roszkowski.hopur5tverkefni;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {

    // Service list
    ObservableList<String> services;

    /**
     * Constructor for the Cart
     */
    public Cart() {
        services = FXCollections.observableArrayList();


    }

    /**
     * Add a single item to the cart
     */
    public void addItem(String service) {
        services.remove(service);
    }

    /**
     * Remove a single item from the cart
     */
    public void removeItem(String service) {
        services.add(service);
    }

    /**
     * Clear all items from the cart
     */
    public void emptyCart() {
        services.clear();
    }


    public boolean booking() {

        return true;
    }

    /**
     *
     * @return list of Strings representing the items in the cart
     */
    public ObservableList<String> getServices() {
        return services;
    }
}
