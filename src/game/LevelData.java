package game;

import com.sun.istack.internal.Nullable;
import game.blocks.BackgroundBlock;
import game.blocks.Block;
import game.blocks.BlockFactory;
import game.characters.Character;
import game.characters.Enemy;
import game.characters.Hero;
import utilities.Executable;

import java.util.ArrayList;
import java.util.List;

public class LevelData {

    private boolean gameInProcess = true;
    private boolean needRebuilding = true;
    private Hero bomberman;

    public Hero getBomberman() {
        return bomberman;
    }

    public List<Enemy> getEnemies() {
        return enemies;
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

    private ArrayList<Enemy> enemies;

    public Block[][] getLevelContent() {
        return levelContent;
    }

    private final BlockFactory blockFactory;

    LevelData(final int[][] blockCodes) {
        blockFactory = new BlockFactory();

        levelContent = new Block[blockCodes.length][blockCodes[0].length];
        for (int i = 0; i < levelContent.length; i++) {
            for (int j = 0; j < levelContent[0].length; j++) {
                levelContent[i][j] = blockFactory.createBlock(blockCodes[i][j]);
            }
        }

        creteHero();
        createEnemy(blockCodes);

        new OverlayThread().start();
    }

    public boolean isActive(){
        return bomberman.isAlive();
    }

    private void creteHero() {
        bomberman = new Hero(this);
        bomberman.setLayoutX(getBlockCordX(1));
        bomberman.setLayoutY(getBlockCordY(1));
    }

    private void createEnemy(final int[][] blockCodes) {
        enemies = new ArrayList<>();
        for (int i = 0; i < blockCodes.length; i++) {
            for (int j = 0; j < blockCodes[0].length; j++) {
                final int code = blockCodes[i][j];
                if (blockFactory.isEnemy(code)) {
                    final Enemy enemy = new Enemy(this);
                    enemy.setLayoutX(getBlockCordX(i));
                    enemy.setLayoutY(getBlockCordY(j));
                    enemies.add(enemy);
                }
            }
        }
    }


    public int getWidth() {
        return levelContent.length;
    }

    public int getHeight() {
        return levelContent[0].length;
    }

    @Nullable
    public Block getBlockByPosition(final int posX, final int posY) {
        if (posX < 0 || posY < 0) {
            return null;
        }

        if (posX >= levelContent.length || posY >= levelContent[0].length) {
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
        return ((int) cord / Constants.BLOCK_SIZE);
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
            explosiveLeft();
            explosiveRight();;
            //todo вызвать для остальных 3 направлений
            explosion(posX, posY);
        }

        private void explosiveTop() {
            boolean active = true;
            for (int i = 0; i < Constants.EXPLOSIVE_POWER && active; i++) {
                final int posY = this.posY - i;
                final Block block = getBlockByPosition(posX, posY);
                if (block != null) {
                    active = block.isDestroyable();
                    if (active) {
                        explosion(posX, posY);
                    }
                }
                explosionAlert(posX, posY);
            }
        }

        private void explosiveBottom() {
            boolean active = true;
            for (int i = 0; i < Constants.EXPLOSIVE_POWER && active; i++) {
                final int posY = this.posY + i;
                final Block block = getBlockByPosition(posX, posY);
                if (block != null) {
                    active = block.isDestroyable();
                    if (active) {
                        explosion(posX, posY);
                    }
                }
                explosionAlert(posX, posY);
            }
        }

        private void explosiveLeft() {
            boolean active = true;
            for (int i = 0; i < Constants.EXPLOSIVE_POWER && active; i++) {
                final int posX = this.posX - i;
                final Block block = getBlockByPosition(posX, posY);
                if (block != null) {
                    active = block.isDestroyable();
                    if (active) {
                        explosion(posX, posY);
                    }
                }
                explosionAlert(posX, posY);
            }
        }

        private void explosiveRight() {
            boolean active = true;
            for (int i = 0; i < Constants.EXPLOSIVE_POWER && active; i++) {
                final int posX = this.posX + i;
                final Block block = getBlockByPosition(posX, posY);
                if (block != null) {
                    active = block.isDestroyable();
                    if (active) {
                        explosion(posX, posY);
                    }
                }
                explosionAlert(posX, posY);
            }
        }

        private void explosionAlert(final int posX, final int posY){
            bomberman.explosive(posX, posY);
            for (final Enemy enemy : enemies) {
                enemy.explosive(posX, posY);
            }
        }
    }

    private class OverlayThread extends Thread{
        @Override
        public void run() {
            while (LevelData.this.isActive()){
                for (final Character enemy : enemies){
                    if (bomberman.isOverlayCharacter(enemy)) {
                        needRebuilding = true;
                    }
                }
            }
        }
    }
}
