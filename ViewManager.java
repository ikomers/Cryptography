import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * The ViewManager class is responsible for managing the opening of different GUI views using JavaFX's FXMLLoader.
 * It provides methods to open the main GUI and a modal actions window.
 */
public class ViewManager {

    /**
     * Opens the main GUI view.
     *
     * @param primaryStage The primary stage of the application.
     */
    public static void openMainGUI(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(ViewManager.class.getResource("main.fxml"));
            Parent root = loader.load();

            MainGUI controller = loader.getController();
            controller.setStage(primaryStage);

            primaryStage.setTitle("Crypto App");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Opens a modal actions window.
     *
     * @param parentStage The parent stage for the modal window.
     */
    public static void openActionsModal(Stage parentStage) {
        try {
            FXMLLoader loader = new FXMLLoader(ViewManager.class.getResource("actions.fxml"));
            Parent root = loader.load();

            Stage actionsStage = new Stage();
            actionsStage.initModality(Modality.WINDOW_MODAL);
            actionsStage.initOwner(parentStage);
            actionsStage.setTitle("Actions");

            ActionsGUI controller = loader.getController();
            controller.setStage(actionsStage);

            Scene scene = new Scene(root);
            actionsStage.setScene(scene);
            actionsStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}