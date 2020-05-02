package game;

public class Enemy extends Character {

    Enemy(LevelData levelData) {
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
        return Constants.ENEMY_IMAGE;
    }
}

