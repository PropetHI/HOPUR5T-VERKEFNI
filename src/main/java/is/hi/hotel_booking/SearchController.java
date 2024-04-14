package is.hi.hotel_booking;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SearchController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void searchButtonClicked() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
