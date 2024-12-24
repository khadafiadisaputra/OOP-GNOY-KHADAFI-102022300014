import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Logincontrol {

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    @FXML
    void Login(ActionEvent event) {
        String inputUsername = username.getText(); 
        String inputPassword = password.getText(); 

        if (inputUsername.equals("Daapi") && inputPassword.equals("00000")) {
            try {

                Parent homePage = FXMLLoader.load(getClass().getResource("homepage.fxml")); 
                Scene homeScene = new Scene(homePage);
                Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                stage.setScene(homeScene);
                stage.show();
                System.out.println("Login successful!");
            } catch (IOException e) {
                e.printStackTrace();
                showAlert("Error", "Tidak dapat memuat halaman berikutnya.", AlertType.ERROR);
            }
        } else {
            showAlert("Login Failed", "Silakan cek kembali username atau password Anda.", AlertType.ERROR);
        }
    }

    private void showAlert(String title, String message, AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
