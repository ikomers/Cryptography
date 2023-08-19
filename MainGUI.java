import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import java.io.File;

/**
 * The MainGUI class represents the graphical user interface (GUI) controller
 * for the main application window where the user can input a file path and
 * initiate actions.
 */
public class MainGUI {

    @FXML
    private TextField filePathTextField;

    @FXML
    private Label pathLabel;

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * Handles the action when the OK button is clicked.
     *
     * @param actionEvent The action event triggered by the OK button
     */
   public void onOKButtonClicked(ActionEvent actionEvent) {
       String filePath = filePathTextField.getText();
       if (!filePath.isEmpty() && isFileValid(filePath)) {
           updatePathLabel(filePath);
           CryptoFileManager manager = new CryptoFileManager();
           manager.getNewFile(filePath);
           if (CryptoFileManager.file != null) {
               manager.setFile(null);
               manager.getNewFile(filePath);
           }
           ViewManager.openActionsModal(stage); // Opens a modal window for actions
       }else {
           // Handles the case when the path is not entered or is incorrect
           showInvalidPathError();
       }

   }

    /**
     * Updates the label to display the selected file path.
     *
     * @param path The selected file path
     */
    public void updatePathLabel(String path) {
        pathLabel.setText("Выбранный файл: " + path);
    }

    /**
     * Handles the event when Enter key is pressed in the file path text field.
     *
     * @param keyEvent The key event triggered by pressing Enter
     */
    @FXML
    public void onFilePathTextFieldEnter(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            onOKButtonClicked(null); // Вызываем метод, аналогичный нажатию кнопки OK
        }
    }

    /**
     * Displays an error message when the entered file path is invalid.
     */
    //TODO It seems that the text input is not being processed when the Enter key on the keyboard is pressed,
    // and the highlighting in red is not working.
    public void showInvalidPathError() {
        filePathTextField.clear();
        filePathTextField.getStyleClass().add("error-text");
        filePathTextField.setPromptText("Введите корректный путь");
    }

    /**
     * Checks if the entered file path is valid.
     *
     * @param filePath The entered file path
     * @return True if the file exists, false otherwise
     */
    private boolean isFileValid(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }
}