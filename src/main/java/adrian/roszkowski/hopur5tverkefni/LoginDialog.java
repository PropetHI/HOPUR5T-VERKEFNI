package adrian.roszkowski.hopur5tverkefni;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

//public class LoginDialog extends Dialog<User>{
public class LoginDialog extends Dialog<User>{
    //private User user;

    private String user, password;


    public LoginDialog(){
        super();
        this.setTitle("Login");

        buildUI();
        //setPropertyBindings();
        //setResultConverter();
    }

    private void buildUI(){
        Pane pane = createLoginPane();
        pane.getStylesheets().add(TripPlannerApplication.class.getResource("mainui-styles.css").toExternalForm());
        //FXMLLoader(TripPlannerApplication.class.getResource("mainui-view.fxml"));
        getDialogPane().setContent(pane);

        //getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL);
        //Button button = (Button) getDialogPane().lookupButton(ButtonType.OK);


        getDialogPane().expandableContentProperty().set(new Label("Login with a valid user \n" +
                "User account must be pre registered with the system."));
        getDialogPane().setExpanded(false);

    }

    public Pane createLoginPane(){
        VBox content = new VBox(10);

        Label loginTextLabelUser = new Label("User");
        TextField loginTextFieldUser = new TextField();
        Label loginTextLabelPassword = new Label("Password");
        //TextField loginTextFieldPassword = new TextField();
        PasswordField loginPasswordFieldPassword = new PasswordField();
        Label loginTextLabelMessage = new Label("");
        Button fxLoginButton = new Button("Login");

        loginTextLabelMessage.setPadding(new Insets(5, 0, 0, 10));

        fxLoginButton.setOnAction(e -> {
            System.out.println("Login Diag button: " + loginTextFieldUser.getText() + " , " + loginPasswordFieldPassword.getText());

            user = loginTextFieldUser.getText();
            password = loginPasswordFieldPassword.getText();

            if (UserDB.isAuthenticationValid(user, password)) {
                AppState.currentUser = user;
                //System.out.println("UI login ok");
                loginTextLabelMessage.setText("Login OK");
                AppState.userLoggedInBoolProperty.set(true);
                this.close();
            }
            else {
                loginTextLabelMessage.setText("Login failed");
            }
        });


        HBox buttonBox = new HBox();
        HBox buttonEVBox = new HBox();
        HBox buttonUBox = new HBox();

        buttonBox.setHgrow(buttonUBox, javafx.scene.layout.Priority.ALWAYS);
        buttonUBox.setAlignment(Pos.BASELINE_LEFT);
        buttonEVBox.getChildren().add(fxLoginButton);
        buttonEVBox.getChildren().add(loginTextLabelMessage);

        buttonBox.getChildren().add(buttonEVBox);
        buttonBox.getChildren().add(buttonUBox);

        content.getChildren().add(loginTextLabelUser);
        content.getChildren().add(loginTextFieldUser);
        content.getChildren().add(loginTextLabelPassword);
        content.getChildren().add(loginPasswordFieldPassword);

        content.getChildren().add(buttonBox);


        return content;
    }
}
