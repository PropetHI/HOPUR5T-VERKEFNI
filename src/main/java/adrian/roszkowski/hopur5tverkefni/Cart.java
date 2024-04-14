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
        this.services = FXCollections.observableArrayList();


    }

    /**
     * Add a single item to the cart
     */
    public void addItem(String service) {
        services.add(service);
    }

    /**
     * Remove a single item from the cart
     */
    public void removeItem(String service) {
        services.remove(service);
    }

    /**
     * Clear all items from the cart
     */
    public void emptyCart() {
        services.clear();
    }


    public boolean booking() {
        if (services != null) {
            // TO-DO klára bókunaraðferð
            if (true) {
                // Ef tókst að bóka
                CartDialog.bookingConfirmedDialog();
                emptyCart();
            } else {
                // Ef tókst ekki
                CartDialog.bookingErrorDialog();
            }
        } else {
           CartDialog.emptyCartDialog();
           return false;
        }
        return true;
    }

    /**
     *
     * @return list of Strings representing the items in the cart
     */
    public ObservableList<String> getServices() {
        return services;
    }

    /**
     *
     * @return String value of all of the items in the cart
     */
    public String totalAmount() {
        int total = 0;
        for (String service : services) {
            String[] parts = service.split(";");
            if (parts.length >= 4) {
                String amountString = parts[3].trim();
                // Remove "Price"
                if (amountString.startsWith("Price:")) {
                    amountString = amountString.substring("Price:".length()).trim();
                }
                int amount = Integer.parseInt(amountString);
                total += amount;
            }
        }
        return String.valueOf(total);
    }
}
