package levelMenu;

import game.Constants;
import game.LevelData;
import game.LevelGenerator;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import level.LevelController;
import utilities.StageUtils;

import java.io.IOException;

public class LevelMenuController {

    @FXML
    ImageView level1;
    @FXML
    ImageView level2;
    @FXML
    ImageView level3;
    @FXML
    ImageView level4;
    @FXML
    ImageView level5;
    @FXML
    ImageView level6;
    @FXML
    ImageView level7;
    @FXML
    ImageView level8;
    @FXML
    ImageView level9;
    @FXML
    ImageView level10;

    @FXML
    ImageView pointer1;
    @FXML
    ImageView pointer2;
    @FXML
    ImageView pointer3;
    @FXML
    ImageView pointer4;
    @FXML
    ImageView pointer5;
    @FXML
    ImageView pointer6;
    @FXML
    ImageView pointer7;
    @FXML
    ImageView pointer8;
    @FXML
    ImageView pointer9;
    @FXML
    ImageView pointer10;
    @FXML
    ImageView backImg;

    private Image lev1;
    private Image lev2;
    private Image lev3;
    private Image lev4;
    private Image lev5;
    private Image lev6;
    private Image lev7;
    private Image lev8;
    private Image lev9;
    private Image lev10;
    private Image back;
    private Image selLev1;
    private Image selLev2;
    private Image selLev3;
    private Image selLev4;
    private Image selLev5;
    private Image selLev6;
    private Image selLev7;
    private Image selLev8;
    private Image selLev9;
    private Image selLev10;
    private Image selBack;

    @FXML
    public void level1Pressed() {
        initLevelController(1);
    }

    @FXML
    public void level2Pressed() {
        initLevelController(2);
    }

    @FXML
    public void level3Pressed() {
        initLevelController(3);
    }

    @FXML
    public void level4Pressed() {
        initLevelController(4);
    }

    @FXML
    public void level5Pressed() {
        initLevelController(5);
    }

    @FXML
    public void level6Pressed() {
        initLevelController(6);
    }

    @FXML
    public void level7Pressed() {
        initLevelController(7);
    }

    @FXML
    public void level8Pressed() {
        initLevelController(8);
    }

    @FXML
    public void level9Pressed() {
        initLevelController(9);
    }

    @FXML
    public void level10Pressed() {
        initLevelController(10);
    }

    private void initLevelController(final int levelNumber) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../level/level.fxml"));
            fxmlLoader.setController(new LevelController());
            Parent root = (Parent) fxmlLoader.load();
            LevelController controller = fxmlLoader.getController();
            final LevelGenerator generator = new LevelGenerator(levelNumber);
            final LevelData levelData = generator.generateLevelData();
            Stage stage = new Stage();
            stage.setTitle("LEVEL " + levelNumber);
            stage.setScene(new Scene(root, levelData.getPaneWidth(), levelData.getPaneHeight()));
            stage.initStyle(StageStyle.TRANSPARENT);
            controller.setLevelData(levelData);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
            StageUtils.closeStage(pointer1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void initialize() {
        lev1 = new Image(Constants.LEV1_IMAGE);
        lev2 = new Image(Constants.LEV2_IMAGE);
        lev3 = new Image(Constants.LEV3_IMAGE);
        lev4 = new Image(Constants.LEV4_IMAGE);
        lev5 = new Image(Constants.LEV5_IMAGE);
        lev6 = new Image(Constants.LEV6_IMAGE);
        lev7 = new Image(Constants.LEV7_IMAGE);
        lev8 = new Image(Constants.LEV8_IMAGE);
        lev9 = new Image(Constants.LEV9_IMAGE);
        lev10 = new Image(Constants.LEV10_IMAGE);
        back = new Image(Constants.BACK_TO_LEVEL_MENU);

        selLev1 = new Image(Constants.SEL_LEV1_IMAGE);
        selLev2 = new Image(Constants.SEL_LEV2_IMAGE);
        selLev3 = new Image(Constants.SEL_LEV3_IMAGE);
        selLev4 = new Image(Constants.SEL_LEV4_IMAGE);
        selLev5 = new Image(Constants.SEL_LEV5_IMAGE);
        selLev6 = new Image(Constants.SEL_LEV6_IMAGE);
        selLev7 = new Image(Constants.SEL_LEV7_IMAGE);
        selLev8 = new Image(Constants.SEL_LEV8_IMAGE);
        selLev9 = new Image(Constants.SEL_LEV9_IMAGE);
        selLev10 = new Image(Constants.SEL_LEV10_IMAGE);
        selBack = new Image(Constants.SEL_BACK_TO_LEVEL_MENU);
    }

    @FXML
    private void onBackToLevelMenu() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../complexityMenu/complexityMenuScene.fxml"));
        Parent root = (Parent) loader.load();
        Stage stage = new Stage();
        stage.setTitle("BOMBERMEN");
        stage.setScene(new Scene(root, 620, 480));
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
        StageUtils.closeStage(pointer1);
    }

    private void setUnselected() {
        level1.setImage(lev1);
        level2.setImage(lev2);
        level3.setImage(lev3);
        level4.setImage(lev4);
        level5.setImage(lev5);
        level6.setImage(lev6);
        level7.setImage(lev7);
        level8.setImage(lev8);
        level9.setImage(lev9);
        level10.setImage(lev10);
        backImg.setImage(back);

        pointer1.setVisible(false);
        pointer2.setVisible(false);
        pointer3.setVisible(false);
        pointer4.setVisible(false);
        pointer5.setVisible(false);
        pointer6.setVisible(false);
        pointer7.setVisible(false);
        pointer8.setVisible(false);
        pointer9.setVisible(false);
        pointer10.setVisible(false);
    }

    @FXML
    public void onLevel1() {
        setUnselected();
        level1.setImage(selLev1);
        pointer1.setVisible(true);
    }

    @FXML
    public void onLevel2() {
        setUnselected();
        level2.setImage(selLev2);
        pointer2.setVisible(true);
    }

    @FXML
    public void onLevel3() {
        setUnselected();
        level3.setImage(selLev3);
        pointer3.setVisible(true);
    }

    @FXML
    public void onLevel4() {
        setUnselected();
        level4.setImage(selLev4);
        pointer4.setVisible(true);
    }

    @FXML
    public void onLevel5() {
        setUnselected();
        level5.setImage(selLev5);
        pointer5.setVisible(true);
    }

    @FXML
    public void onLevel6() {
        setUnselected();
        level6.setImage(selLev6);
        pointer6.setVisible(true);
    }

    @FXML
    public void onLevel7() {
        setUnselected();
        level7.setImage(selLev7);
        pointer7.setVisible(true);
    }

    @FXML
    public void onLevel8() {
        setUnselected();
        level8.setImage(selLev8);
        pointer8.setVisible(true);
    }

    @FXML
    public void onLevel9() {
        setUnselected();
        level9.setImage(selLev9);
        pointer9.setVisible(true);
    }

    @FXML
    public void onLevel10() {
        setUnselected();
        level10.setImage(selLev10);
        pointer10.setVisible(true);
    }

    @FXML
    public void onBackEntered(){
        setUnselected();
        backImg.setImage(selBack);
    }
}
