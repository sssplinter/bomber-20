package game.characters;

import game.Constants;
import game.LevelData;

import java.util.Random;

public class Enemy extends Character {

    public Enemy(LevelData levelData) {
        super(levelData);
        new MoveThread().start();
    }

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
        return Constants.CHARACTER_IMAGE;
    }

    private class MoveThread extends Thread {

        private static final int UP = 0;
        private static final int DOWN = 1;
        private static final int LEFT = 2;
        private static final int RIGHT = 3;

        private Random random = new Random();

        @Override
        public void run() {
            while (Enemy.this.isAlive()) {
                final int direction = Math.abs(random.nextInt()) % 4;
                for (int i = 0; i < 6; i++) {
                    switch (direction) {
                        case UP:
                            Enemy.this.moveUp();
                            break;
                        case DOWN:
                            Enemy.this.moveDown();
                            break;
                        case LEFT:
                            Enemy.this.moveLeft();
                            break;
                        case RIGHT:
                            Enemy.this.moveRight();
                            break;
                        default:
                            throw new IllegalArgumentException();
                    }
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}