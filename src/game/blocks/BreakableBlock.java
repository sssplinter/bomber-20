package game.blocks;

import game.Constants;

public class BreakableBlock extends Block {

    @Override
    public boolean destroy() {
        return true;//TODO
    }

    @Override
    public boolean isPermeable() {
        return false;
    }

    @Override
    protected String getImagePath() {
        return Constants.BREAKABLE_BOCK_IMAGE;
    }
}
