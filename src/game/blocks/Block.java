package game.blocks;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public abstract class Block extends Pane {

    public Block() {
        final Image image = new Image(getClass().getResourceAsStream(getImagePath()));
        final ImageView imageView = new ImageView(image);
        this.getChildren().add(imageView);
    }

    protected abstract Boolean destroy();

    public abstract boolean isPermeable();

    protected abstract String getImagePath();


}
