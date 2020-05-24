package game.characters;

import game.Constants;
import game.LevelData;

public class Hero extends Character {

    private final Object LOCK = new Object();//todo таймер, expo (координаты) -> метод = взрыв -> releaseBomb ->

    private int availableBombCount = 3;

    public Hero(LevelData levelData) {
        super(levelData);
    }

    @Override
    protected Boolean destroy() {
        return null;
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
        return ((availableBombCount > 0) && (hasSpaceForBomb()));
    }
}
