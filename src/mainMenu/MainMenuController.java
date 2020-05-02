package mainMenu;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController {

    @FXML
    public void onNewGamePressed() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../levelMenu/levelMenu.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage= new Stage();
        stage.setTitle("BOMBERMEN");
        stage.setScene(new Scene(root, 640, 480));
        stage.showAndWait();
    }
}
