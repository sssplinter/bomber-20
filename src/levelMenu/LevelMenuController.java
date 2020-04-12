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
            Parent root = (Parent) fxmlLoader.load();
            LevelController controller = fxmlLoader.getController();
            final LevelGenerator generator = new LevelGenerator(levelNumber);
            final LevelData levelData = generator.generateLevelData();
            controller.setLevelData(levelData);
            Stage stage = new Stage();
            stage.setScene(new Scene(root, levelData.getPaneWidth(), levelData.getPaneHeight()));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @FXML
    public void onFirstLevelClick() {
      initLevelController(1);
    }


}
