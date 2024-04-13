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


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        //fxServicesInCart.getItems().addAll(ServiceInteractor.getServiceList());

        //ObservableList<String> observableList = FXCollections.observableArrayList(ServiceInteractor.getServiceList());
        //fxServicesInCart.setItems(observableList);
    }

    @FXML
    protected void onExploreMore() {
        ViewSwitcher.switchTo(View.MAIN, true);
    }

    @FXML
    protected void onRemove() {

    }

    @FXML
    protected void onAdd() {
    }

    @FXML
    private void onSendBooking(ActionEvent event) {
        if (this.cart.services != null && !this.cart.services.isEmpty()) {
            // Booking
        } else {
            emptyCartDialog();
        }
    }

    @FXML
    private void emptyCartDialog() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("");
        alert.setHeaderText(null);


        alert.setContentText("Your cart is currently empty. Please add items to your cart before proceeding with the booking.");


        ButtonType okButton = new ButtonType("Ok", ButtonType.OK.getButtonData());
        alert.getButtonTypes().setAll(okButton);

        alert.showAndWait();
    }
}
