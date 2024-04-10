package adrian.roszkowski.hopur5tverkefni;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import java.util.Optional;

public class TripPlannerController implements Initializable {

    String noUserLoginText = "Not logged in";
    String currentSelectedListItem;

    @FXML
    private Label fxStatusText;

    @FXML
    private Button fxLoginButton;

    @FXML
    protected void onMyCartButtonClick() {
        fxStatusText.setText("Opening Cart");
    }

    @FXML
    private Label currentUserLabel;

    @FXML
    private ListView<String> fxServiceListView;

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
        fxStatusText.setText("");

        AppState.userLoggedInBoolProperty.addListener(new ChangeListener<Boolean>() {
            public void changed(ObservableValue<? extends Boolean> mv, Boolean isOld, Boolean isNew) {
                //System.out.println("user logged in bool changed");
                updateUI();
            }
        });


        //String[] serviceListData = {"9990;Reykjavik;Guided Bus Ride around the City of Reykjavik;10","500;Akureyri;Guided Bus Ride around the Town of Reykjavik;5","temp","test"};
        //fxServiceListView.getItems().addAll(serviceListData);
        fxServiceListView.getItems().addAll(ServiceInteractor.getServiceList());

        fxServiceListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2){


                currentSelectedListItem = fxServiceListView.getSelectionModel().getSelectedItem();
                fxStatusText.setText(currentSelectedListItem);

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