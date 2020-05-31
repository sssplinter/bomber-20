package complexityMenu;

import game.Constants;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import utilities.StageUtils;

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

    @FXML
    Button levelMenu;

    @FXML
    ImageView backImg;

    private Image easy;
    private Image selEasy;
    private Image normal;
    private Image selNormal;
    private Image hard;
    private Image selHard;
    private Image back;
    private Image selBack;


    @FXML
    public void initialize() {
        easy = new Image(Constants.EASY_IMAGE);
        selEasy = new Image(Constants.SELECTED_EASY_IMAGE);
        normal = new Image(Constants.NORMAL_IMAGE);
        selNormal = new Image(Constants.SELECTED_NORMAL_IMAGE);
        hard = new Image(Constants.HARD_IMAGE);
        selHard = new Image(Constants.SELECTED_HARD_IMAGE);
        back = new Image(Constants.BACK_TO_LEVEL_MENU);
        selBack = new Image(Constants.SEL_BACK_TO_LEVEL_MENU);
    }

    @FXML
    public void onEasyGamePressed() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../levelMenu/levelMenuScene.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = new Stage();
        stage.setTitle("BOMBERMEN");
        stage.setScene(new Scene(root, 640, 480));
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
        StageUtils.closeStage(pointer2);

    }

    @FXML
    public void onNormalGamePressed() {

    }

    @FXML
    public void onBackToLevelMenu() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../mainMenu/mainMenuScene.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage= new Stage();
        stage.setTitle("BOMBERMEN");
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(new Scene(root, 620, 480));
        stage.show();
        StageUtils.closeStage(pointer2);
    }

    @FXML
    public void onHardGamePressed() {

    }

    private void setInvisible(){
        bomb1.setVisible(false);
        bomb2.setVisible(false);
        bomb3.setVisible(false);
        bomb4.setVisible(false);
        bomb5.setVisible(false);
        bomb6.setVisible(false);
    }

    private void setUnselected() {
        setInvisible();
        pointer1.setVisible(false);
        easyGame.setImage(easy);
        pointer2.setVisible(false);
        normalGame.setImage(normal);
        pointer3.setVisible(false);
        hardGame.setImage(hard);
        backImg.setImage(back);
    }


    @FXML
    public void onEasyEntered() {
        setUnselected();
        pointer1.setVisible(true);
        easyGame.setImage(selEasy);
        bomb1.setVisible(true);
    }

    @FXML
    public void onNormalEntered() {
        setUnselected();
        pointer2.setVisible(true);
        normalGame.setImage(selNormal);
        bomb2.setVisible(true);
        bomb3.setVisible(true);
    }

    @FXML
    public void onHardEntered() {
        setUnselected();
        pointer3.setVisible(true);
        hardGame.setImage(selHard);
        bomb4.setVisible(true);
        bomb5.setVisible(true);
        bomb6.setVisible(true);
    }

    @FXML
    public void onBackEntered(){
        setUnselected();
        backImg.setImage(selBack);
    }
}
