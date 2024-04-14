package adrian.roszkowski.hopur5tverkefni;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;


import java.net.URL;
import java.util.ResourceBundle;

public class CartController implements Initializable {

    @FXML
    private ListView<String> fxServicesInCart;
    @FXML
    private TripPlannerController tripPlannerController;

    private Cart cart = new Cart();
    ObservableList<String> services;


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        services = cart.getServices();

        if (services != null) {
            fxServicesInCart.setItems(cart.getServices());

            ObservableList<String> observableList = FXCollections.observableArrayList(cart.getServices());
            fxServicesInCart.setItems(observableList);
        }
    }

    @FXML
    protected void onExploreMore() {
        ViewSwitcher.switchTo(View.MAIN, true);
    }

    @FXML
    protected void onRemove() {
        String selectedService = fxServicesInCart.getSelectionModel().getSelectedItem();
        if (selectedService != null) {
            cart.removeItem(selectedService);
        } else {
            CartDialog.addRemoveEmptyDialog();
        }
    }

    @FXML
    protected void onAdd() {
        String selectedService = fxServicesInCart.getSelectionModel().getSelectedItem();
        if (selectedService != null) {
            cart.addItem(selectedService);
        } else {
            CartDialog.addRemoveEmptyDialog();
        }
    }

    @FXML
    private void onSendBooking(ActionEvent event) {
        if (cart.services != null && !cart.services.isEmpty()) {
            for (String service : services) {
                if (cart.booking()) {
                    // Ef tókst að bóka
                    CartDialog.bookingConfirmedDialog();
                    cart.emptyCart();
                } else {
                    // Ef tókst ekki
                    CartDialog.bookingErrorDialog();
                }
            }
        } else {
            CartDialog.emptyCartDialog();
        }
    }
}
