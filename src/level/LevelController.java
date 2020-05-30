package level;

import game.Constants;
import game.characters.Enemy;
import game.characters.Hero;
import game.LevelData;
import game.blocks.Block;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.List;

public class LevelController extends Application {

    private LevelData levelData;

    @FXML
    private Pane root;

    @FXML
    private Pane gameOverPane;

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
        boolean  haveEnemies = false;
        for (final Enemy enemy : enemies) {
            if (enemy.isAlive()) {
                root.getChildren().add(enemy);
                haveEnemies = true;
            }
        }


        final Hero bomberman = levelData.getBomberman();
        if (bomberman.isAlive()) {
            root.getChildren().add(levelData.getBomberman());
            if(!haveEnemies) {
               endOfTheGame(Constants.WIN_IMAGE);
            }
        } else {
            endOfTheGame(Constants.YOU_DIED_IMAGE);
        }
    }

    private void endOfTheGame(final  String imagePath){ //todo возвращенеи к левел меню
        Pane gameOverPane = new Pane();
        gameOverPane.setPrefWidth(root.getWidth());
        gameOverPane.setPrefHeight(root.getHeight());
        gameOverPane.setStyle("-fx-background-color: #000000");
        Image img = new Image(imagePath);
        ImageView imageView = new ImageView(img);
        int temp = (int) ((root.getWidth() / 2) - (int) (img.getWidth() /  2));
        imageView.setLayoutX(temp);
        temp = (int) ((root.getHeight() / 2) - (int) (img.getHeight() /2));
        imageView.setLayoutY(temp);
        root.getChildren().add(gameOverPane);
        root.getChildren().add(imageView);
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
