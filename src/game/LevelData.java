package game;

import game.blocks.Block;
import game.blocks.BlockFactory;

public class LevelData {

    //TODO  заменить на матрицу блоков
    private Block[][] levelContent;
    private int[][] enemyLocation;

    public LevelData(final int[][] blockCodes){
        final BlockFactory blockFactory = new BlockFactory();
        levelContent = new Block[blockCodes.length][blockCodes[0].length];
        for(int i = 0; i < levelContent.length; i++){
            for(int j = 0; j < levelContent[0].length; i++){
                levelContent[i][j] = blockFactory.createBlock(blockCodes[i][j]);
            }
        }
    }

    public int getWidth() {
        return levelContent.length;
    }

    public int getHeight() {
        return levelContent[0].length;
    }

    ////////////// разрушается или нет
    public Block getBlockByPosition(final int posX, final int posY) {
        return levelContent[posX][posY];
    }

    public Block getBlockByCoordinates(final int cordX, final int cordY) {
        final int posX = cordX / Constants.BLOCK_SIZE;
        final int posY = cordY / Constants.BLOCK_SIZE;
        return getBlockByPosition(posX, posY);
    }
    ////////////////////////////////////////////////
    public double getPaneHeight() {
        return getHeight() * Constants.BLOCK_SIZE;
    }

    public double getPaneWidth() {
        return getWidth() * Constants.BLOCK_SIZE;
    }

    ///////////////// для размещения
    public double getBlockCordX(final int posX) {
        return posX * Constants.BLOCK_SIZE;
    }

    public double getBlockCordY(final int posY) {
        return posY * Constants.BLOCK_SIZE;
    }
    /////////////////r

}
