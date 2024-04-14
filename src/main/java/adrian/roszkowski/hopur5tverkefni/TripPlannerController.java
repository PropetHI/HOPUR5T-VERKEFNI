package adrian.roszkowski.hopur5tverkefni;

import is.hi.hotel_booking.database.DatabaseManager;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

import is.hi.hotel_booking.HotelApplication;

import java.util.Optional;

public class TripPlannerController implements Initializable {

    String noUserLoginText = "Not logged in";
    String currentSelectedListItem;
    String[] currentSelectedListItemParts;

    String listItemDelimiter = ";";

    @FXML
    private Label fxStatusText;

    @FXML
    private Button fxLoginButton;

    @FXML
    private DatePicker fxDateFrom;
    @FXML
    private DatePicker fxDateTo;

    @FXML
    private TextField fxLocation;

    @FXML
    private TextField fxNumPeople;

    @FXML
    private TextField fxSearchText;

    @FXML
    protected void onMyCartButtonClick() {
        fxStatusText.setText("Opening Cart");
        ViewSwitcher.switchTo(View.CART, true);
    }

    @FXML
    private Label currentUserLabel;

    @FXML
    private ListView<String> fxServiceListView;

    @FXML
    protected void onSearchButtonClick(){
        //System.out.println("Searching...");
            updateServiceList();

        //fxServiceListView.getItems().addAll(ServiceInteractor.getServiceList("","",""));
    }

    @FXML
    protected void onHotelServicesButtonClick() throws IOException, SQLException {
        System.out.println("Accessing Hotel Services ...");

        Stage hotelDialogStage = new Stage();
        hotelDialogStage.initModality(Modality.APPLICATION_MODAL);
        hotelDialogStage.setTitle("Hotel Services");

        HotelApplication hotelApp = new HotelApplication();
        FXMLLoader loader = new FXMLLoader(HotelApplication.class.getResource("HotelSearch.fxml"));
        Parent hotelRoot = loader.load();

        Scene hotelScene = new Scene(hotelRoot, 400,300);

        hotelDialogStage.setScene(hotelScene);

        is.hi.hotel_booking.HotelUI hotelUIController = loader.getController();
        Connection connection = DatabaseManager.getConnection();
        hotelUIController.initialize(connection);

        hotelDialogStage.showAndWait();
        
    }

    @FXML
    protected void onDetailsButtonClick(){
        //System.out.println("Showing Details dialog");
        try{
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("details-view.fxml"));
            DialogPane detailsDialogPane = fxmlLoader.load();

            Dialog<ButtonType> detailsDialog  = new Dialog<>();
            detailsDialog.setDialogPane(detailsDialogPane);
            detailsDialog.setTitle("Service Details");

            DetailsController detailsController = fxmlLoader.getController();
            detailsController.setData(currentSelectedListItemParts[0], currentSelectedListItemParts[4],currentSelectedListItemParts[5], currentSelectedListItemParts[3],currentSelectedListItemParts[6]);

            Optional<ButtonType> clickedButton = detailsDialog.showAndWait();
            if (clickedButton.get() == ButtonType.CLOSE){
                System.out.println("Details Dialog Closed");
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

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

    @FXML
    protected void onTestBookingButtonClick(){
        System.out.println("Button:" + currentSelectedListItemParts[0] + currentSelectedListItemParts[2]);
        if (ServiceInteractor.bookService(currentSelectedListItemParts[0], currentSelectedListItemParts[2]) == 0 ) {
            //updateUI();
            updateServiceList();
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

        //fxServiceListView.getItems().addAll(ServiceInteractor.getServiceList());
        updateServiceList();
        fxServiceListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2){
                currentSelectedListItem = fxServiceListView.getSelectionModel().getSelectedItem();
                fxStatusText.setText(currentSelectedListItem);

                try {
                    currentSelectedListItemParts = fxServiceListView.getSelectionModel().getSelectedItem().split(listItemDelimiter);
                }
                catch (Exception e){
                    System.out.println(e);
                }
            }
        });
    }

    private void updateServiceList(){
        fxServiceListView.getItems().clear();
        fxServiceListView.getItems().addAll(ServiceInteractor.getServiceList(fxSearchText.getText(),fxLocation.getText(),fxNumPeople.getText()));
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
