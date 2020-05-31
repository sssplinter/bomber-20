package game.blocks;

import game.Constants;
import utilities.Executable;

public class ExplosionBlock extends Block {

    Executable fireTask;

    public ExplosionBlock(Executable fireTask) {
        this.fireTask = fireTask;
        new FireThread().start();
    }

    @Override
    public boolean isDestroyable() {
        return true;
    }

    @Override
    public boolean isPermeable() {
        return false;
    }

    @Override
    protected String getImagePath() {
        return Constants.EXPLOSION_BLOCK_IMAGE;
    }

    private class FireThread extends Thread{
        @Override
        public void run() {
            try {
                sleep(180);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            fireTask.execute();
        }
    }
}
