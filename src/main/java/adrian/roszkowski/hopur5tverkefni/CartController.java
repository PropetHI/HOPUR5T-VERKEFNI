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

    private Cart cart;


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
}
