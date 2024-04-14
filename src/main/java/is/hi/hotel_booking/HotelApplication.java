package is.hi.hotel_booking;

import is.hi.hotel_booking.controllers.HotelController;
import is.hi.hotel_booking.database.DatabaseManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class HotelApplication extends Application {

/*    @Override
    public void start(Stage primaryStage) {
        is.hi.hotel_booking.HotelUI hotelUI = new is.hi.hotel_booking.HotelUI(primaryStage);
        hotelUI.init();
    }

    public static void main(String[] args) {
        launch(args);
    }
}*/
    @Override
    public void start(Stage primaryStage) throws IOException,SQLException{
        // Load the FXML file
        FXMLLoader loader = new FXMLLoader(HotelApplication.class.getResource("HotelSearch.fxml"));
        Parent root = loader.load();

       /*// Set up the controller
        Connection connection = DatabaseManager.getConnection();

        // Set up the controller
        is.hi.hotel_booking.HotelUI hotelUIController = new is.hi.hotel_booking.HotelUI();
        hotelUIController.initialize(); // Pass the controller to initialize method

        // Set the scene
        primaryStage.setScene(new Scene(root));
        primaryStage.show();*/
        // Get the controller instance
        is.hi.hotel_booking.HotelUI hotelUIController = loader.getController();

        // Set up the controller
        Connection connection = DatabaseManager.getConnection();
        hotelUIController.initialize(connection);

        // Set the scene
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}


