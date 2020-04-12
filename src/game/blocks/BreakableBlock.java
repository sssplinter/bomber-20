package game.blocks;

import game.Constants;

public class BreakableBlock extends Block {
    @Override
    boolean destroy() {
        return false;
    }

    @Override
    boolean isPermeable() {
        return false;
    }

    @Override
    String getImagePath() {
        return Constants.BREAKABLE_BOCK_IMAGE;
    }
}
