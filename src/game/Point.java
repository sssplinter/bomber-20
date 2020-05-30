package game;

public class Point {

    private final int cordX;
    private final int cordY;

    public Point(final double cordX, final double cordY){
        this.cordX = (int) cordX;
        this.cordY = (int) cordY;
    }

    public int getCordX(){
        return cordX;
    }

    public int getCordY() {
        return cordY;
    }
}
