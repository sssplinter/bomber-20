package game.blocks;

import com.sun.istack.internal.NotNull;

public class BlockFactory {

    private static final int BACKGROUND_CODE = 0;
    private static final int BREAKABLE_CODE = 1;
    private static final int BORDER_CODE = 2;
    private static final int ENEMY_CODE = 3;

    @NotNull
    public Block createBlock(final int blockCode) {
        switch (blockCode) {
            case BACKGROUND_CODE: //линейное движение
            case ENEMY_CODE:
                return new BackgroundBlock();
            case BREAKABLE_CODE:
                return new BreakableBlock();
            case BORDER_CODE:
                return new BorderBlock();
            default:
                throw new IllegalArgumentException("Illegal block code.");
        }
    }

    public boolean isEnemy(final int code){
        return code == ENEMY_CODE;
    }
}
