package adrian.roszkowski.hopur5tverkefni;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
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
        }
        else {
            addRemoveEmptyDialog();
        }
    }

    @FXML
    protected void onAdd() {
        String selectedService = fxServicesInCart.getSelectionModel().getSelectedItem();
        if (selectedService != null) {
            cart.addItem(selectedService);
        }
        else {
            addRemoveEmptyDialog();
        }
    }

    @FXML
    private void onSendBooking(ActionEvent event) {
        if (cart.services != null && !cart.services.isEmpty()) {
            for(String service : services) {
                // skoða hvernig service þetta er
                // bóka
                if(true) {
                    // Ef tókst
                    bookingConfirmedDialog();
                }
                else {
                    // Ef tókst ekki
                    bookingErrorDialog();
                }
            }
        } else {
            emptyCartDialog();
        }
    }

    private void emptyCartDialog() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("");
        alert.setHeaderText(null);


        alert.setContentText("Your cart is currently empty. Please add items to your cart before proceeding with the booking.");


        ButtonType okButton = new ButtonType("Ok", ButtonType.OK.getButtonData());
        alert.getButtonTypes().setAll(okButton);

        alert.showAndWait();
    }

    private void bookingErrorDialog() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("");
        alert.setHeaderText(null);


        alert.setContentText("We're sorry, there was an error processing your booking. Please try again " +
                "or contact customer support for assistance.");


        ButtonType okButton = new ButtonType("Ok", ButtonType.OK.getButtonData());
        alert.getButtonTypes().setAll(okButton);

        alert.showAndWait();
    }

    private void bookingConfirmedDialog() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Booking Confirmed");
        alert.setHeaderText(null);


        alert.setContentText("Your booking has been confirmed. " +
                "\nThank you for your reservation!");


        ButtonType okButton = new ButtonType("Ok", ButtonType.OK.getButtonData());
        alert.getButtonTypes().setAll(okButton);

        alert.showAndWait();
    }

    private void addRemoveEmptyDialog() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("");
        alert.setHeaderText(null);


        alert.setContentText("Your cart is currently empty");


        ButtonType okButton = new ButtonType("Ok", ButtonType.OK.getButtonData());
        alert.getButtonTypes().setAll(okButton);

        alert.showAndWait();
    }

}
