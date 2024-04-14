package is.hi.hotel_booking;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.application.Application.launch;

public class SearchApplication extends Application {
  /*  @FXML
    private TextField nameField;

    @FXML
    private ListView<Hotel> hotelListView;



    @FXML
    private void initialize() {
        // You can perform initialization tasks here if needed
    }

    @FXML
    private void searchButtonClicked() {
        String name = nameField.getText();
        List<Hotel> matchingHotels = searchHotelsByName(name);
        if (!matchingHotels.isEmpty()) {
            ObservableList<Hotel> hotels = FXCollections.observableArrayList(matchingHotels);
            hotelListView.setItems(hotels);
        } else {
            hotelListView.getItems().clear();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("No hotels found with the specified name.");
            alert.showAndWait();
        }
    }

    private List<Hotel> searchHotelsByName(String name) {
        List<Hotel> matchingHotels = new ArrayList<>();
        for (Hotel hotel : hotels) {
            if (hotel.getName().equalsIgnoreCase(name)) {
                matchingHotels.add(hotel);
            }
        }
        return matchingHotels;
    }*/

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SearchApplication.class.getResource("HotelSearch.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 440);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
