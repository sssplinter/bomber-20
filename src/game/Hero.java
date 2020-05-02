package game;

public class Hero extends Character {
    Hero(LevelData levelData) {
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
}
