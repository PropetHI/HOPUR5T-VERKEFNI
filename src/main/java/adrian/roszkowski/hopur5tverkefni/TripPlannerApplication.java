package adrian.roszkowski.hopur5tverkefni;

import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main UI Class for Trip Planner Application
 * @version 1.0
 * @author Hopur5T: Adrian Roszkowski (), Bogi Fjalar Sigurðsson (bfs11@hi.is), Eva Hrönn Rúnarsdóttir () and Xiang Ji ()
 */
public class TripPlannerApplication extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TripPlannerApplication.class.getResource("mainui-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setResizable(false);
        stage.setTitle("5T Trip Planner");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        AppState.init();
        launch();
    }
}