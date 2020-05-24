package game.characters;

import game.Constants;
import game.LevelData;
import game.blocks.Block;

public abstract class Character extends Block {

    private boolean alive = true;

    private int moveSpeed = 5;

    protected final LevelData levelData;

    Character(LevelData levelData) {
        this.levelData = levelData;
    }

    private int getAvailableLeftSteps() {
        for (int i = 1; i <= moveSpeed; i++) {
            final boolean firstBlockIsPermeable = getBlockPermeableByOffset(-i, 0);
            final boolean secondBlockIsPermeable = getBlockPermeableByOffset(-i, Constants.CHARACTER_SIZE - 1);
            if (!(firstBlockIsPermeable && secondBlockIsPermeable)) {
                return i - 1;
            }
        }
        return moveSpeed;
    }

    private int getAvailableRightSteps() {
        for (int i = 1; i <= moveSpeed; i++) {
            final boolean firstBlockIsPermeable =
                    getBlockPermeableByOffset(Constants.CHARACTER_SIZE + i, 0);
            final boolean secondBlockIsPermeable =
                    getBlockPermeableByOffset(Constants.CHARACTER_SIZE + i, Constants.CHARACTER_SIZE - 1);
            if (!(firstBlockIsPermeable && secondBlockIsPermeable)) {
                return i - 1;
            }
        }
        return moveSpeed;

    }

    private int getAvailableUpSteps() {
        for (int i = 1; i <= moveSpeed; i++) {
            final boolean firstBlockIsPermeable = getBlockPermeableByOffset(0, -1);
            final boolean secondBlockIsPermeable =
                    getBlockPermeableByOffset(Constants.CHARACTER_SIZE - 1, -1);
            if (!(firstBlockIsPermeable && secondBlockIsPermeable)) {
                return i - 1;
            }
        }
        return moveSpeed;
    }

    private int getAvailableDownSteps() {
        for (int i = 1; i <= moveSpeed; i++) {
            final boolean firstBlockIsPermeable =
                    getBlockPermeableByOffset(0, Constants.CHARACTER_SIZE + i);
            final boolean secondBlockIsPermeable =
                    getBlockPermeableByOffset(Constants.CHARACTER_SIZE - 1, Constants.CHARACTER_SIZE + i);
            if (!(firstBlockIsPermeable && secondBlockIsPermeable)) {
                return i - 1;
            }
        }
        return moveSpeed;
    }

    private boolean getBlockPermeableByOffset(final int offsetX, final int offsetY) {
        final int posX = (int) (getLayoutX() + offsetX);
        final int posY = (int) (getLayoutY() + offsetY);
        final Block firstBlock = levelData.getBlockByCoordinates(posX, posY);
        return firstBlock.isPermeable();
    }

    public void moveLeft() {
        final int availableSteps = getAvailableLeftSteps();
        setLayoutX(getLayoutX() - availableSteps);
    }

    public void moveRight() {
        final int availableSteps = getAvailableRightSteps();
        setLayoutX(getLayoutX() + availableSteps);
    }

    public void moveUp() {
        final int availableSteps = getAvailableUpSteps();
        setLayoutY(getLayoutY() - availableSteps);
    }

    public void moveDown() {
        final int availableSteps = getAvailableDownSteps();
        setLayoutY(getLayoutY() + availableSteps);
    }
}
