package game.blocks;

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
        return null;
    }
}
