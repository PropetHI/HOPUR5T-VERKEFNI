package adrian.roszkowski.hopur5tverkefni;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;


import java.net.URL;
import java.util.ResourceBundle;

public class CartController implements Initializable {

    @FXML
    private ListView<String> fxServicesInCart;
    @FXML
    private Label fxTotalAmount;

    private Cart cart;


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        cart = new Cart();
        fxServicesInCart.setItems(cart.getServices());

        updateServiceList();

        fxTotalAmount.setText(cart.totalAmount() + "kr.-");
    }

    private void updateServiceList(){
        fxServicesInCart.getItems().clear();
        fxServicesInCart.getItems().addAll(ServiceInteractor.getServiceList("", "", ""));
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
            fxTotalAmount.setText(cart.totalAmount() + "kr.-");
        } else {
            CartDialog.addRemoveEmptyDialog();
        }
    }

    @FXML
    protected void onAdd() {
        String selectedService = fxServicesInCart.getSelectionModel().getSelectedItem();
        if (selectedService != null) {
            cart.addItem(selectedService);
            fxTotalAmount.setText(cart.totalAmount() + "kr.-");
        } else {
            CartDialog.addRemoveEmptyDialog();
        }
    }

    @FXML
    private void onSendBooking(ActionEvent event) {
        cart.booking();
        fxTotalAmount.setText(cart.totalAmount() + "kr.-");
    }
}
