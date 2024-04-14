package adrian.roszkowski.hopur5tverkefni;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class CartDialog {

    public static void emptyCartDialog() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("");
        alert.setHeaderText(null);


        alert.setContentText("Your cart is currently empty. Please add items to your cart before proceeding with the booking.");


        ButtonType okButton = new ButtonType("Ok", ButtonType.OK.getButtonData());
        alert.getButtonTypes().setAll(okButton);

        alert.showAndWait();
    }

    public static void bookingErrorDialog() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("");
        alert.setHeaderText(null);


        alert.setContentText("We're sorry, there was an error processing your booking. Please try again " +
                "or contact customer support for assistance.");


        ButtonType okButton = new ButtonType("Ok", ButtonType.OK.getButtonData());
        alert.getButtonTypes().setAll(okButton);

        alert.showAndWait();
    }

    public static void bookingConfirmedDialog() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Booking Confirmed");
        alert.setHeaderText(null);


        alert.setContentText("Your booking has been confirmed. " +
                "\nThank you for your reservation!");


        ButtonType okButton = new ButtonType("Ok", ButtonType.OK.getButtonData());
        alert.getButtonTypes().setAll(okButton);

        alert.showAndWait();
    }

    public static void addRemoveEmptyDialog() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("");
        alert.setHeaderText(null);


        alert.setContentText("Your cart is currently empty");


        ButtonType okButton = new ButtonType("Ok", ButtonType.OK.getButtonData());
        alert.getButtonTypes().setAll(okButton);

        alert.showAndWait();
    }
}
