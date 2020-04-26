package game;

import game.blocks.BackgroundBlock;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;

public class Character extends Pane {

    private boolean alive = true;

    private int moveSpeed = 16;

    private int positionX;
    private int positionY;
    private final LevelData levelData;

//    private final int size = Constants.CHARACTER_SIZE;

    Character(LevelData levelData) {
        this.levelData = levelData;
        final Image image = new Image(getClass().getResourceAsStream(Constants.CHARACTER_IMAGE));
        final ImageView imageView = new ImageView(image);
        this.getChildren().add(imageView);
    }

    private int getAvailableLeftSteps() {
        for (int i = 1; i <= moveSpeed; i++) {
            if (!(levelData.getBlockByCoordinates((int) (getLayoutX()) - moveSpeed,
                    (int) (getLayoutY())).isPermeable()) &&
                    (levelData.getBlockByCoordinates((int) (getLayoutX()) - moveSpeed,
                            (int) (getLayoutY()) + Constants.BLOCK_SIZE - 1).isPermeable())) {
                return i - 1;
            }
        }
        return moveSpeed;
    }

    private int getAvailableRightSteps() {
        for (int i = 1; i <= moveSpeed; i++) {
            if (!(levelData.getBlockByCoordinates((int) (getLayoutX()) + i,
                    (int) (getLayoutY())).isPermeable()) &&
                    (levelData.getBlockByCoordinates((int) (getLayoutX()) + i,
                            (int) (getLayoutY()) + Constants.BLOCK_SIZE - 1).isPermeable())) {
                return i - 1;
            }
        }
        return moveSpeed;
    }

    private int getAvailableUpSteps() {
        for (int i = 1; i <= moveSpeed; i++) {
            if (!(levelData.getBlockByCoordinates((int) (getLayoutX()),
                    (int) (getLayoutY()) - moveSpeed).isPermeable()) &&
                    (levelData.getBlockByCoordinates((int) (getLayoutX()) + Constants.BLOCK_SIZE - 1,
                            (int) (getLayoutY()) - moveSpeed).isPermeable())) {
                return i - 1;
            }
        }
        return moveSpeed;
    }

    private int getAvailableDownSteps() {
        for (int i = 1; i <= moveSpeed; i++) {
            if (!(levelData.getBlockByCoordinates((int) (getLayoutX()),
                    (int) (getLayoutY()) + moveSpeed).isPermeable()) &&
                    (levelData.getBlockByCoordinates((int) (getLayoutX()) + Constants.BLOCK_SIZE - 1,
                            (int) (getLayoutY()) + moveSpeed).isPermeable())) {
                return i - 1;
            }
        }
        return moveSpeed;
    }

    public void moveLeft() {
        final int availableSteps = getAvailableLeftSteps();
            setLayoutX(getLayoutX() - availableSteps);
    }

    public void moveRight() {
        final int availableSteps = getAvailableRightSteps();
            setLayoutX(getLayoutX() + availableSteps);
    }

    public void moveUp() {
        final int availableSteps = getAvailableUpSteps();
            setLayoutY(getLayoutY() + availableSteps);
    }

    public void moveDown() {
        final int availableSteps = getAvailableDownSteps();
            setLayoutY(getLayoutY() + availableSteps);
    }

}
