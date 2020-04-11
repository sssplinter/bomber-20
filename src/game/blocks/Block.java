package game.blocks;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public abstract class Block extends Pane {

    public Block() {
        final Image image = new Image(getClass().getResourceAsStream(getImagePath()));
        final ImageView imageView = new ImageView(image);
    }

    abstract boolean destroy();

    abstract boolean isPermeable();

    abstract String getImagePath();


}
