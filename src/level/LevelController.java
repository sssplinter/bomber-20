package level;

import game.characters.Enemy;
import game.characters.Hero;
import game.LevelData;
import game.blocks.Block;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.List;

public class LevelController extends Application {

    private LevelData levelData;

    @FXML
    private Pane root;

    private void setListeners() {
        final Scene scene = root.getScene();
        scene.setOnKeyPressed(event -> {
            if ((event.getCode() == KeyCode.UP) || event.getCode() == KeyCode.W) {
                levelData.getBomberman().moveUp();
            }

            if ((event.getCode() == KeyCode.DOWN) || event.getCode() == KeyCode.S) {
                levelData.getBomberman().moveDown();
            }

            if ((event.getCode() == KeyCode.LEFT) || event.getCode() == KeyCode.A) {
                levelData.getBomberman().moveLeft();
            }

            if ((event.getCode() == KeyCode.RIGHT) || event.getCode() == KeyCode.D) {
                levelData.getBomberman().moveRight();
            }

            if (event.getCode() == KeyCode.SPACE) {
                levelData.getBomberman().setBomb();
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
        new BackgroundRenderingRunnable().start();
    }

    private void renderBackground() {
        clearRoot();
        for (int posX = 0; posX < levelData.getWidth(); posX++) {
            for (int posY = 0; posY < levelData.getHeight(); posY++) {
                final Block block = levelData.getBlockByPosition(posX, posY);
                block.setLayoutX(levelData.getBlockCordX(posX));
                block.setLayoutY(levelData.getBlockCordY(posY));
                root.getChildren().add(block);
            }
        }
        List<Enemy> enemies = levelData.getEnemies();
        for(final Enemy enemy : enemies){
            if(enemy.isAlive()) {
                root.getChildren().add(enemy);
            }
        }

        final Hero bomberman = levelData.getBomberman();
        if (bomberman.isAlive()) {
            root.getChildren().add(levelData.getBomberman());
        } else {
            //TODO вывести сообщение о проебеи закрыть нахуй игру
        }
    }

    private void clearRoot() {
        root.getChildren().clear();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }

    private class BackgroundRenderingRunnable extends Thread {
        @Override
        public void run() {
            while (levelData.getGameInProcess()) {
                if (levelData.getNeedRebuilding()) {
                    Platform.runLater(LevelController.this::renderBackground);
                    levelData.setNeedRebuilding();
                }
            }
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
