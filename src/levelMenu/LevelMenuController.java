package levelMenu;

import game.LevelData;
import game.LevelGenerator;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import level.LevelController;

import java.io.IOException;

public class LevelMenuController {

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
            controller.setLevelData(levelData);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onFirstLevelClick() {
      initLevelController(1);
    }
    public void onSecondLevelClick() {
      initLevelController(2);
    }

    public void onThirdLevelClick() {
      initLevelController(3);
    }

    public void onFourthLevelClick() {
      initLevelController(4);
    }

    public void onFifthLevelClick() {
      initLevelController(5);
    }
}
