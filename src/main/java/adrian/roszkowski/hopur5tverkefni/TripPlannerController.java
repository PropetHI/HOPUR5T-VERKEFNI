package adrian.roszkowski.hopur5tverkefni;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import java.util.Optional;

public class TripPlannerController implements Initializable {

    String noUserLoginText = "Not logged in";

    @FXML
    private Label welcomeText;

    @FXML
    private Button fxLoginButton;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    private Label currentUserLabel;

    @FXML
    protected void onLoginButtonClick() {
        //System.out.println("Login ...");
        if (AppState.userLoggedInBoolProperty.getValue()) {
            AppState.currentUser = noUserLoginText;
            AppState.userLoggedInBoolProperty.set(false);
            updateUI();
        }
        else {
            Dialog<User> loginDialog = new LoginDialog();
            Optional<User> loginResult = loginDialog.showAndWait();
        }


    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        currentUserLabel.setText(noUserLoginText);
             welcomeText.setText("something");

        AppState.userLoggedInBoolProperty.addListener(new ChangeListener<Boolean>() {
            public void changed(ObservableValue<? extends Boolean> mv, Boolean isOld, Boolean isNew) {
                //System.out.println("user logged in bool changed");
                updateUI();
            }
        });
    }

    public void updateUI(){
        //System.out.println("controller updating ui");
        currentUserLabel.setText(AppState.currentUser);

        if(AppState.userLoggedInBoolProperty.get()) {
            fxLoginButton.setText("Logout");
        }
        else {
            fxLoginButton.setText("Login");
        }


    }


}