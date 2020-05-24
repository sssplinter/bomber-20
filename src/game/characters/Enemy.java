package game.characters;

import game.Constants;
import game.LevelData;

public class Enemy extends Character {

    public Enemy(LevelData levelData) {
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
        return Constants.BOMB_IMAGE;
    }
}

