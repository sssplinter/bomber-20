package level;

import game.Character;
import game.LevelData;
import game.LevelGenerator;
import game.blocks.Block;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

public class LevelController {

    private LevelData levelData;

    @FXML
    Pane root;

    @FXML
    public void initialize() {
        root.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
//                TODO
            }
        });
    }

    public void setLevelData(final LevelData levelData) {
        this.levelData = levelData;
        initPane();
    }

    private void initPane() {
        final double paneHeight = levelData.getPaneHeight();
        final double paneWidth = levelData.getPaneWidth();
        root.setPrefHeight(paneHeight);
        root.setPrefWidth(paneWidth);
        renderBackground();
    }

    private void renderBackground() {
        for (int posX = 0; posX < levelData.getWidth(); posX++) {
            for (int posY = 0; posY < levelData.getHeight(); posY++) {
                final Block block = levelData.getBlockByPosition(posX, posY);
                block.setLayoutX(levelData.getBlockCordX(posX));
                block.setLayoutY(levelData.getBlockCordY(posY));
                root.getChildren().add(block);
            }
            Character bomber = levelData.cretePerson();
            bomber.setLayoutX(levelData.getBlockCordX(1));
            bomber.setLayoutY(levelData.getBlockCordY(1));
            root.getChildren().add(bomber);
            for(int i =0; i < 3; i++){
               // bomber.isDownMoveAvailable();
            }
        }
    }
}
