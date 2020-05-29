package mainMenu;

import game.Constants;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import settings.Settings;

import java.io.IOException;

public class MainMenuController {

    @FXML
    ImageView pointer1;

    @FXML
    ImageView pointer2;

    @FXML
    ImageView pointer3;

    @FXML
    ImageView newGame;

    @FXML
    ImageView information;

    @FXML
    ImageView exit;

    private Image start;
    private Image selStart;
    private Image infImg;
    private Image selInfImg;
    private Image exitImg;
    private Image selExitImg;


    @FXML
    public void initialize() {
        start = new Image(Constants.START_IMAGE);
        selStart = new Image(Constants.SELECTED_START_IMAGE);
        infImg = new Image(Constants.INF_IMAGE);
        selInfImg = new Image(Constants.SELECTED_INF_IMAGE);
        exitImg= new Image(Constants.EXIT_IMAGE);
        selExitImg = new Image(Constants.SELECTED_EXIT_IMAGE);
    }

    @FXML
    public void onNewGamePressed() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../complexityMenu/complexityMenuScene.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = new Stage();
        stage.setTitle("BOMBERMEN");
        stage.setScene(new Scene(root, 620, 480));
        stage.showAndWait();
        Settings.getInstance();
    }

    @FXML
    public void onInformationPressed(){

    }

    @FXML
    public void onExitPressed(){

    }

    @FXML
    public void onStartEntered() {
        pointer2.setVisible(false);
        information.setImage(infImg);
        pointer3.setVisible(false);
        exit.setImage(exitImg);
        pointer1.setVisible(true);
        newGame.setImage(selStart);
    }

    @FXML
    public void onInformationEntered() {
        pointer1.setVisible(false);
        newGame.setImage(start);
        pointer3.setVisible(false);
        exit.setImage(exitImg);
        pointer2.setVisible(true);
        information.setImage(selInfImg);
    }

    @FXML
    public void onExitEntered() {
        pointer1.setVisible(false);
        newGame.setImage(start);
        pointer2.setVisible(false);
        information.setImage(infImg);
        pointer3.setVisible(true);
        exit.setImage(selExitImg);
    }
}
