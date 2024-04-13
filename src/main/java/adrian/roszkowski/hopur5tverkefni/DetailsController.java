package adrian.roszkowski.hopur5tverkefni;

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


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

    }

    protected void setData(String service, String price){
        fxServiceLabel.setText(service);
        fxPriceLabel.setText(price);
    }
}
