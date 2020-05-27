package game.characters;

import game.Constants;
import game.LevelData;

public class Enemy extends Character {

    public Enemy(LevelData levelData) {
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
}

