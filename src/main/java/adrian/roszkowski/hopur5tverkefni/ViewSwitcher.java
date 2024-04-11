package adrian.roszkowski.hopur5tverkefni;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 *
 * EÞH - changed to include caching of controllers
 */
public class ViewSwitcher {

    private static final Map<View, Parent> cache = new HashMap<>();
    private static final Map<View, Object> controllers = new HashMap<>();
    private static Scene scene;
    private static Stage stage;

    public static void setScene(Scene scene, Stage stage) {
        ViewSwitcher.scene = scene;
        ViewSwitcher.stage = stage;
    }

    public static void switchTo(View view, boolean isCache) {
        if (scene == null || stage == null) {
            System.out.println("Scene or stage is not set");
            return;
        }

        try {
            Parent root;

            if (cache.containsKey(view) && isCache) {
                System.out.println("Loading from cache");
                root = cache.get(view);
            } else {
                System.out.println("Loading from FXML " + view.getFileName());
                FXMLLoader loader = new FXMLLoader(ViewSwitcher.class.getResource(view.getFileName()));
                root = loader.load();

                cache.put(view, root);
                controllers.put(view, loader.getController());
            }

            scene.setRoot(root);
            stage.sizeToScene(); // Aðlaga stærð sviðs
            stage.centerOnScreen(); // Miðjusetja svið á skjá

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object lookup(View v) {
        return controllers.get(v);
    }
}
