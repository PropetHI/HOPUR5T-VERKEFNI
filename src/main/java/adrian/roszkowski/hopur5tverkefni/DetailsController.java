package adrian.roszkowski.hopur5tverkefni;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class DetailsController implements Initializable {

    @FXML
    private Label fxServiceLabel;
    @FXML
    private Label fxPriceLabel;
    @FXML
    private Label fxTypeLabel;
    @FXML
    private Label fxLocationLabel;
    @FXML
    private Label fxAvailableLabel;


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

    }

    protected void setData(String type, String price, String service, String location, String availability){
        fxTypeLabel.setText(type);
        fxServiceLabel.setText(service);
        fxPriceLabel.setText(price);
        fxLocationLabel.setText(location);
        fxAvailableLabel.setText(availability);
    }

    public void onAddToCart(ActionEvent actionEvent) {
    }
}
