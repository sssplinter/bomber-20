package game.characters;

import game.Constants;
import game.LevelData;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Hero extends Character {
    Image img =  new Image(getClass().getResourceAsStream(getImagePath()));
    int columns = 3;
    int count = 3;
    int offsetX = 32;
    int offsetY = 32;
    int width = 32;
    int height = 32;

    public void playAnimation(){
        ImageView imageView = new ImageView(img);
        imageView.setViewport(new Rectangle2D(offsetX, offsetY, width, height));
//        final Animation animation = new SpriteAnimation(imageView, Duration.millis(3000), count, columns, offsetX, offsetY, width, height){
//            imageView,
//        }

    }

    private final Object LOCK = new Object();//todo таймер, expo (координаты) -> метод = взрыв -> releaseBomb ->

    private int availableBombCount = 3;



    public Hero(LevelData levelData) {
        super(levelData);
    }

    @Override
    public boolean isDestroyable() {
        return false;
    }

    @Override
    public boolean isPermeable() {
        return false;
    }

    @Override
    protected String getImagePath() {
        return Constants.CHARACTER_IMAGE;
    }

    public void setBomb() {
        final int bombPosX = LevelData.getPositionByCoordinate(getLayoutX());
        final int bombPosY = LevelData.getPositionByCoordinate(getLayoutY());
        levelData.plantBomb(bombPosX, bombPosY);
        availableBombCount--;
    }

    public void releaseBomb() {
        synchronized (LOCK) {
            availableBombCount++;
        }
    }

    private boolean hasSpaceForBomb() {
        final int posX = LevelData.getPositionByCoordinate(getLayoutX());
        final int posY = LevelData.getPositionByCoordinate(getLayoutY());
        return levelData.getBlockByPosition(posX, posY).isPermeable();
    }

    public boolean canPlantBomb() {
        return ((availableBombCount > 0) && hasSpaceForBomb() && isAlive());
    }


}
