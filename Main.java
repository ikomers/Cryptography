import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * The overridden start method initializes and displays the main graphical user interface (GUI).
     *
     * @param primaryStage The primary stage provided by the JavaFX runtime.
     */
    @Override
    public void start(Stage primaryStage) {
        ViewManager.openMainGUI(primaryStage);
    }
}