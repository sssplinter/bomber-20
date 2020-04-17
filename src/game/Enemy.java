package game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Enemy extends Pane {
    private int moveSpeed;
    //todo разобраться с направление с помощью enum
    private int positionX;
    private int positionY;
    private boolean alive = true;
    private final int size = Constants.ENEMY_SIZE;
    private Image image = new Image(getClass().getResourceAsStream(Constants.ENEMY_IMAGE));
    private ImageView imageView = new ImageView(image);

    public Enemy(LevelData levelData){
        final Image image = new Image(getClass().getResourceAsStream(Constants.ENEMY_IMAGE));
        final ImageView imageView = new ImageView(image);
        this.getChildren().add(imageView);
    }
}
