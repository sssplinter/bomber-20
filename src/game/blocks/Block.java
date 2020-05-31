package game.blocks;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public abstract class Block extends Pane {

    protected Block() {
        final Image image = new Image(getClass().getResourceAsStream(getImagePath()));
        final ImageView imageView = new ImageView(image);
        this.getChildren().add(imageView);
    }

    public abstract boolean isDestroyable();

    public abstract boolean isPermeable();

    public boolean isRefractory() {
        return false;
    }

    protected abstract String getImagePath();


}
