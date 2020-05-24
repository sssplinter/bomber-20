package game;

import com.sun.istack.internal.Nullable;
import game.blocks.BackgroundBlock;
import game.blocks.Block;
import game.blocks.BlockFactory;
import game.characters.Character;
import game.characters.Enemy;
import game.characters.Hero;
import utilities.Executable;

public class LevelData {

    private boolean gameInProcess = true;
    private boolean needRebuilding = true;
    private Hero bomberman;
    private Enemy enemy;

    public Hero getBomberman() {
        return bomberman;
    }

    public Boolean getGameInProcess() {
        return gameInProcess;
    }

    public Boolean getNeedRebuilding() {
        return needRebuilding;
    }

    public void setNeedRebuilding() {
        this.needRebuilding = false;
    }

    //TODO  заменить на матрицу блоков
    private Block[][] levelContent;

    private Character[] enemies;

    public Block[][] getLevelContent() {
        return levelContent;
    }

    LevelData(final int[][] blockCodes) {
        final BlockFactory blockFactory = new BlockFactory();
        int temp = blockCodes[0].length;

        levelContent = new Block[blockCodes.length][blockCodes[0].length];
        for (int i = 0; i < levelContent.length; i++) {
            for (int j = 0; j < levelContent[0].length; j++) {
                levelContent[i][j] = blockFactory.createBlock(blockCodes[i][j]);
            }
        }
        creteHero();
        bomberman.setLayoutX(getBlockCordX(1));
        bomberman.setLayoutY(getBlockCordY(1));

        createEnemy();
        enemy.setLayoutX(getBlockCordX(1));
        enemy.setLayoutY(getBlockCordY(2));
    }

    private void creteHero() {
        bomberman = new Hero(this);
    }

    private void createEnemy() {
        enemy = new Enemy(this);
    }

    public int getWidth() {
        return levelContent.length;
    }

    public int getHeight() {
        return levelContent[0].length;
    }

    @Nullable
    public Block getBlockByPosition(final int posX, final int posY) {
        if (posX < 0 || posY < 0){
            return null;
        }

        if (posX >= levelContent.length || posY >= levelContent[0].length){
            return null;
        }
        return levelContent[posX][posY];
    }

    public Block getBlockByCoordinates(final int cordX, final int cordY) {
        final int posX = cordX / Constants.BLOCK_SIZE;
        final int posY = cordY / Constants.BLOCK_SIZE;
        return getBlockByPosition(posX, posY);
    }

    public static int getPositionByCoordinate(final double cord) {
        return ((int) cord / Constants.CHARACTER_SIZE);
    }

    public void plantBomb(final int posX, final int posY) {
        if (bomberman.canPlantBomb()) {
            final Executable explosiveTask = new ExplosiveTask(posX, posY);
            final Block bomb = new Bomb(explosiveTask);
            levelContent[posX][posY] = bomb;
            needRebuilding = true;
        }
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
    /////////////////

    private void explosion(final int posX, final int posY) {
        levelContent[posX][posY] = new BackgroundBlock();
        //todo анимация
        needRebuilding = true;
    }

    private class ExplosiveTask implements Executable {

        private final int posX;
        private final int posY;

        ExplosiveTask(final int posX, final int posY) { // todo создать экземпяр, передав позицию
            this.posX = posX;
            this.posY = posY;
        }

        @Override
        public void execute() {
            bomberman.releaseBomb();
            explosiveTop();
            explosiveBottom();
            //todo вызвать для остальных 3 направлений
            explosion(posX, posY);
        }

        private void explosiveTop() {
            boolean active = true;
            for ( int i = 0; i < Constants.EXPLOSIVE_POWER && active; i++){
                final int posY = this.posY - i;
                final Block block = getBlockByPosition(posX, posY);
                if (block != null){
                    active = block.destroy();
                    if (active){
                        explosion(posX, posY);
                    }
                }

                bomberman.explosive(posX, posY);
                explosion(posX, posY);
            }
        }

        private void explosiveBottom() {
            boolean active = true;
            for ( int i = 0; i < Constants.EXPLOSIVE_POWER && active; i++){
                final int posY = this.posY + i;
                final Block block = getBlockByPosition(posX, posY);
                if (block != null){
                    active = block.destroy();
                    if (active){
                        explosion(posX, posY);
                    }
                }

                bomberman.explosive(posX, posY);

            }
        }
        // todo сделать еще три метода в друиге стороны
    }
}
