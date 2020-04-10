package game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Character extends Pane {

    private boolean alive = true;

    private int moveSpeed;
    //todo разобраться с направление с помощью enum

    private int positionX;
    private int positionY;

    private final int size = Constants.CHARACTER_SIZE;

    private Image image = new Image(getClass().getResourceAsStream(Constants.CHARACTER_IMAGE));
    private ImageView imageView = new ImageView(image);



}
