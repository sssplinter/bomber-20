import game.Constants;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;
    Scene mainScene, levelScene;

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mainMenu/mainMenuScene.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage= new Stage();
        stage.setTitle("BOMBERMEN");
        stage.setScene(new Scene(root, 620, 480));
        stage.showAndWait();
    }
}
