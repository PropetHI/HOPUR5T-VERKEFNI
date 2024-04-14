package is.hi.hotel_booking;

import is.hi.hotel_booking.controllers.HotelController;
import is.hi.hotel_booking.database.DatabaseManager;
import is.hi.hotel_booking.entities.Hotel;
import is.hi.hotel_booking.entities.Room;
import is.hi.hotel_booking.entities.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class BookingUI {

    @FXML
    private Label hotelNameLabel;

    @FXML
    private ComboBox<String> roomTypeComboBox;
    @FXML
    private TextField user_name;

    @FXML
    private TextField user_email;

    @FXML
    private DatePicker fromDatePick;

    @FXML
    private DatePicker toDatePick;
    private HotelController hotelController;
    private Hotel selectedHotel;

    // Initialize BookingUI with HotelController and selected hotel
    public void init(HotelController hotelController, Hotel selectedHotel) {
        this.hotelController = hotelController;
        this.selectedHotel = selectedHotel;

        // Update the UI with the details of the selected hotel
        hotelNameLabel.setText(selectedHotel.getName());
        // You can add more UI elements here to display other details of the hotel

        // fyrir dropdown lista
        roomTypeComboBox.getItems().addAll("Single Room", "Double Room", "Suite");

    }
    @FXML
    protected void onBackClick(ActionEvent event) throws IOException, SQLException {
        // Load the HotelSearch.fxml file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HotelSearch.fxml"));
        Parent root = loader.load();

        // Get the controller instance
        HotelUI hotelUIController = loader.getController();

        // Set up the controller
        Connection connection = DatabaseManager.getConnection();
        hotelUIController.initialize(connection);

        // Get the stage and set the scene
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void bookConfirmclick(ActionEvent event) {
        // Sækjum allar viðeigandi upplýsingar
        String userName = user_name.getText();
        String userEmail = user_email.getText();

        // Sækjum daganna sem voru valdir
        LocalDate fromDate = fromDatePick.getValue();
        LocalDate toDate = toDatePick.getValue();

        // Veljum rétt roomtype
        String selectedRoomTypeString = roomTypeComboBox.getValue();

        if (userName.isEmpty() || userEmail.isEmpty() || fromDate == null || toDate == null || selectedRoomTypeString == null) {
            // If any field is empty, show a message indicating that all fields must be filled
            showAlert("Please fill in all fields.");
        } else {

            Room.RoomType selectedRoomType = null;
            switch (selectedRoomTypeString) {
                case "Single Room":
                    selectedRoomType = Room.RoomType.SINGLE;
                    break;
                case "Double Room":
                    selectedRoomType = Room.RoomType.DOUBLE;
                    break;
                case "Suite":
                    selectedRoomType = Room.RoomType.SUITE;
                    break;
            }

            // If all fields are filled, proceed with booking
            String result = hotelController.createBooking(selectedHotel, selectedRoomType, new User(userName, userEmail), fromDate, toDate);
            System.out.println(result);
        }
    }
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
