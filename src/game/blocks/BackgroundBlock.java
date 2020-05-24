package game.blocks;

import game.Constants;

public class BackgroundBlock extends Block {

    public BackgroundBlock() {
        super();
    }

    @Override
    public boolean destroy() {
        return true;
    }

    @Override
    public boolean isPermeable() {
        return true;
    }

    @Override
    protected String getImagePath() {
        return Constants.BACKGROUND_BLOCK_IMAGE;
    }
}
