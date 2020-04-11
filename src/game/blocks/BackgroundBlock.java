package game.blocks;

import game.Constants;

public class BackgroundBlock extends Block {

    public BackgroundBlock() {
        super();
    }

    @Override
    boolean destroy() {
        return false;
    }

    @Override
    boolean isPermeable() {
        return true;
    }

    @Override
    String getImagePath() {
        return Constants.BACKGROUND_BLOCK_IMAGE;
    }
}
