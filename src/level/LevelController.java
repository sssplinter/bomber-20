package level;

import game.Character;
import game.LevelData;
import game.LevelGenerator;
import game.blocks.Block;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LevelController {

    private LevelData levelData;
    private Character bomber;


    @FXML
    Pane root;
//todo,не listener
    private void setListeners() {
        final Scene scene = root.getScene();
        scene.setOnKeyPressed(event -> {
            if ((event.getCode() == KeyCode.UP) || event.getCode() == KeyCode.W) {
                bomber.moveUp();
            }

            if ((event.getCode() == KeyCode.DOWN) || event.getCode() == KeyCode.S) {
                bomber.moveDown();
            }

            if ((event.getCode() == KeyCode.LEFT) || event.getCode() == KeyCode.A) {
                bomber.moveLeft();
            }

            if ((event.getCode() == KeyCode.RIGHT) || event.getCode() == KeyCode.D) {
                bomber.moveRight();
            }
        });
    }

    public void setLevelData(final LevelData levelData) {
        this.levelData = levelData;
        initPane();
        setListeners();
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

        }
        bomber = levelData.cretePerson();
        final double layoutX = levelData.getBlockCordX(1);
        final double layoutY = levelData.getBlockCordY(1);
        bomber.setLayoutX(layoutX);
        bomber.setLayoutY(layoutY);
        root.getChildren().add(bomber);
    }


}
