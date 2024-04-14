package is.hi.hotel_booking;

import is.hi.hotel_booking.controllers.HotelController;
import is.hi.hotel_booking.database.DatabaseManager;
import is.hi.hotel_booking.entities.Hotel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class HotelUI{
    private final Stage primaryStage;
    private HotelController hotelController;
    private Hotel selectedHotel;

    @FXML
    private TextField searchField;


    @FXML
    private ListView<String> hotelListView;

    @FXML
    private Label welcomeText;

    @FXML
    private Label confirmationText;

    @FXML
    private Button bookButton;

    public HotelUI() throws SQLException, IOException {
        this.primaryStage = new Stage();
        this.hotelController = new HotelController(DatabaseManager.getConnection());
    }
    public void initialize(Connection connection) {
        this.hotelController = new HotelController(connection);

        // Initialize the HotelController to fetch data from the database
        hotelController.initialize();

        List<Hotel> allHotels = this.hotelController.getHotels();
        updateListView(allHotels);

        searchField.setPromptText("Search Hotels");
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            List<Hotel> filteredHotels = this.hotelController.search(newValue);
            updateListView(filteredHotels);
        });
        hotelListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            // Get the selected hotel object
            selectedHotel = allHotels.get(hotelListView.getSelectionModel().getSelectedIndex());

        });
    }
    private void updateListView(List<Hotel> hotels) {
        // Clear the existing items in the list view
        hotelListView.getItems().clear();

        // Add hotel names to the list view
        for (Hotel hotel : hotels) {
            hotelListView.getItems().add(hotel.getName());
        }
    }

    @FXML
    protected void bookButtonClicked(ActionEvent event) throws IOException {
        // Skoðum hvort hótel sé valið
        if(selectedHotel != null){
            // sendum selected hotel með bookingfxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Booking.fxml"));
            Parent root = loader.load();
            BookingUI bookingUI = loader.getController();
            bookingUI.init(hotelController, selectedHotel);

            // Show the booking view
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
}


