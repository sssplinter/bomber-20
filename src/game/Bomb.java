package game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Bomb extends Pane {


    //todo разобраться с направление с помощью enum
    private int positionX;
    private int positionY;
    private boolean ready = true;
    private final int size = Constants.CHARACTER_SIZE;

    private Image image = new Image(getClass().getResourceAsStream(Constants.BOMB_IMAGE));
    private ImageView imageView = new ImageView(image);
}
