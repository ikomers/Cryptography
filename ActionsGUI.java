import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * This class represents the graphical user interface for the actions' menu.
 * It provides buttons for encryption, decryption, and brute force decryption
 * operations on files.
 */
public class ActionsGUI {

    @FXML
    private Button encryptButton;

    @FXML
    private Button decryptButton;

    @FXML
    private Button bruteForceButton;

    private Stage stage;

    /**
     * Sets the stage for the ActionsGUI.
     *
     * @param stage The main stage of the JavaFX application.
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    /**
     * Handles the event when the "Encrypt" button is clicked.
     * Initiates the encryption process on the selected file.
     *
     * @param actionEvent The event representing the button click.
     */
    @FXML
    public void onEncryptButtonClicked(ActionEvent actionEvent) {
        // Логика для зашифровки файла
        Encrypter encrypter = new Encrypter();
        encrypter.encrypt();
    }

    /**
     * Handles the event when the "Decrypt" button is clicked.
     * Initiates the decryption process on the selected file.
     *
     * @param actionEvent The event representing the button click.
     */
    @FXML
    public void onDecryptButtonClicked(ActionEvent actionEvent) {
        // Логика для расшифровки файла
        Decrypter decrypter = new Decrypter();
        decrypter.decrypt();
    }

    /**
     * Handles the event when the "Brute Force" button is clicked.
     * Initiates the brute force decryption process on the selected file.
     *
     * @param actionEvent The event representing the button click.
     */
    @FXML
    public void onBruteForceButtonClicked(ActionEvent actionEvent) {
        // Логика для взлома шифровки
        Decrypter decrypter = new Decrypter();
        decrypter.bruteForce();
    }

    /**
     * Handles the event when the "Back" button is clicked.
     * Returns to the main GUI window.
     *
     * @param actionEvent The event representing the button click.
     */
    public void onBackButtonClicked(ActionEvent actionEvent) {
        ViewManager.openMainGUI(stage); // Открываем предыдущее окно снова
        //((Stage) ((Button) actionEvent.getSource()).getScene().getWindow()).hide(); // Скрываем текущее окно
    }
}