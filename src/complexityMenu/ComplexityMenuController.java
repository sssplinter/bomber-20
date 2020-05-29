package complexityMenu;

import game.Constants;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class ComplexityMenuController {

    @FXML
    private ImageView pointer1;

    @FXML
    ImageView pointer2;

    @FXML
    ImageView pointer3;

    @FXML
    ImageView easyGame;

    @FXML
    ImageView normalGame;

    @FXML
    ImageView hardGame;

    @FXML
    ImageView bomb1;

    @FXML
    ImageView bomb2;

    @FXML
    ImageView bomb3;
    @FXML
    ImageView bomb4;

    @FXML
    ImageView bomb5;

    @FXML
    ImageView bomb6;


    private Image easy;
    private Image selEasy;
    private Image normal;
    private Image selNormal;
    private Image hard;
    private Image selHard;


    @FXML
    public void initialize() {
        easy = new Image(Constants.EASY_IMAGE);
        selEasy = new Image(Constants.SELECTED_EASY_IMAGE);
        normal = new Image(Constants.NORMAL_IMAGE);
        selNormal = new Image(Constants.SELECTED_NORMAL_IMAGE);
        hard = new Image(Constants.HARD_IMAGE);
        selHard = new Image(Constants.SELECTED_HARD_IMAGE);
    }

    @FXML
    public void onEasyGamePressed() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../testLevelMenu/levelMenuScene.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = new Stage();
        stage.setTitle("BOMBERMEN");
        stage.setScene(new Scene(root, 640, 480));
        stage.showAndWait();
    }

    @FXML
    public void onNormalGamePressed() {

    }

    @FXML
    public void onHardGamePressed() {

    }

    public void setInvisible(){
        bomb1.setVisible(false);
        bomb2.setVisible(false);
        bomb3.setVisible(false);
        bomb4.setVisible(false);
        bomb5.setVisible(false);
        bomb6.setVisible(false);
    }

    @FXML
    public void onEasyEntered() {
        setInvisible();
        pointer2.setVisible(false);
        normalGame.setImage(normal);
        pointer3.setVisible(false);
        hardGame.setImage(hard);
        pointer1.setVisible(true);
        easyGame.setImage(selEasy);
        bomb1.setVisible(true);
    }

    @FXML
    public void onNormalEntered() {
        setInvisible();
        pointer1.setVisible(false);
        easyGame.setImage(easy);
        pointer3.setVisible(false);
        hardGame.setImage(hard);
        pointer2.setVisible(true);
        normalGame.setImage(selNormal);
        bomb2.setVisible(true);
        bomb3.setVisible(true);
    }

    @FXML
    public void onHardEntered() {
        setInvisible();
        pointer1.setVisible(false);
        easyGame.setImage(easy);
        pointer2.setVisible(false);
        normalGame.setImage(normal);
        pointer3.setVisible(true);
        hardGame.setImage(selHard);
        bomb4.setVisible(true);
        bomb5.setVisible(true);
        bomb6.setVisible(true);
    }
}
