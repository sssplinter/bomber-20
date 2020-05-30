import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;

public class Main extends Application {

    Stage window;
    Scene mainScene, levelScene;
    private static final String MEDIA_URL = "src/music/mp1.mp3";


    @Override
    public void start(Stage primaryStage) throws Exception {
        Media media = new Media(new File(MEDIA_URL).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mainMenu/mainMenuScene.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage= new Stage();
        stage.setTitle("BOMBERMEN");
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(new Scene(root, 620, 480));
        stage.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
