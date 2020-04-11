package game;

import game.blocks.Block;

public class LevelData {

    //TODO  заменить на матрицу блоков
    private Block[][] levelContent;
    private int[][] enemyLocation;

    private int width ;
    private int height;

    public int getWidth(){
       return width;
    }

    public int getHeight(){
        return height;
    }
////////////// разрушается или нет
    public Block getBlockByPosition(final int posX, final int posY){
        return levelContent[posX][posY];
    }

    public Block getBlockByCoordinates(final int cordX, final int cordY){
        final int posX = cordX / Constants.BLOCK_SIZE;
        final int posY = cordY / Constants.BLOCK_SIZE;
        return getBlockByPosition(posX, posY);
    }
////////////////////////////////////////////////
    public double getPaneHeight(){
        return height * Constants.BLOCK_SIZE;
    }

    public double getPaneWidth(){
        return width * Constants.BLOCK_SIZE;
    }
///////////////// для размещения
    public double getBlockCordX(final int posX){
          return posX * Constants.BLOCK_SIZE;
    }

    public double getBlockCordY(final int posY){
          return posY * Constants.BLOCK_SIZE;
    }
/////////////////r

}
