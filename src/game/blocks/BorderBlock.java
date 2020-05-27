package game.blocks;

import game.Constants;

public class BorderBlock extends Block {

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
        return Constants.UNBREAKABLE_BLOCK_IMAGE;
    }
}
