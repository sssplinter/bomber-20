package game;

import game.blocks.BackgroundBlock;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;

public class Character extends Pane {

    private boolean alive = true;

    private int moveSpeed;

    private int positionX;
    private int positionY;
    private final LevelData levelData;

//    private final int size = Constants.CHARACTER_SIZE;

    Character(LevelData levelData){
        this.levelData = levelData;
        final Image image = new Image(getClass().getResourceAsStream(Constants.CHARACTER_IMAGE));
        final ImageView imageView = new ImageView(image);
        this.getChildren().add(imageView);
    }

    private boolean isLeftMoveAvailable(){
       return ((levelData.getBlockByCoordinates((int)(this.getLayoutX()) - moveSpeed, (int)(this.getLayoutY())).isPermeable()) &&
                (levelData.getBlockByCoordinates((int)(this.getLayoutX()) - moveSpeed, (int)(this.getLayoutY()) + Constants.BLOCK_SIZE - 1).isPermeable()));
    }

    private boolean isRightMoveAvailable(){
       return ((levelData.getBlockByCoordinates((int)(this.getLayoutX()) + moveSpeed, (int)(this.getLayoutY())).isPermeable()) &&
                (levelData.getBlockByCoordinates((int)(this.getLayoutX()) + moveSpeed, (int)(this.getLayoutY()) + Constants.BLOCK_SIZE - 1).isPermeable()));

    }

    private boolean isUpMoveAvailable(){
       return ((levelData.getBlockByCoordinates((int)(this.getLayoutX()), (int)(this.getLayoutY()) - moveSpeed).isPermeable()) &&
                (levelData.getBlockByCoordinates((int)(this.getLayoutX()) + Constants.BLOCK_SIZE - 1, (int)(this.getLayoutY()) - moveSpeed).isPermeable()));

    }

    private boolean isDownMoveAvailable(){
      return ((levelData.getBlockByCoordinates((int)(this.getLayoutX()), (int)(this.getLayoutY()) + moveSpeed).isPermeable()) &&
                (levelData.getBlockByCoordinates((int)(this.getLayoutX()) + Constants.BLOCK_SIZE - 1, (int)(this.getLayoutY()) + moveSpeed).isPermeable()));
    }

    public void moveLeft(){
        if(isLeftMoveAvailable()){
            this.setLayoutX(getLayoutX() + moveSpeed);
        }
    }

    public void moveRight(){
        if(isRightMoveAvailable()){
            this.setLayoutX(getLayoutX() - moveSpeed);
        }
    }

    public void moveUp(){
        if(isUpMoveAvailable()){
            this.setLayoutY(getLayoutY() + moveSpeed);
        }
    }

    public void moveDown(){
        if(isDownMoveAvailable()){
            this.setLayoutY(getLayoutY() + moveSpeed);
        }
    }

}
