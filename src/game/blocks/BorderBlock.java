package game.blocks;

import game.Constants;

public class BorderBlock extends Block {

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
        return Constants.UNBREAKABLE_BLOCK_IMAGE;
    }
}
