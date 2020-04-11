import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mainMenu/mainMenuScene.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage= new Stage();
        stage.setScene(new Scene(root, 640, 780));
        stage.showAndWait();
    }
}
