package game.characters;

import game.Point;

class CharacterFrame {

    private final Point topLeftPoint;
    private final Point topRightPoint;
    private final Point downLeftPoint;
    private final Point downRightPoint;

    CharacterFrame(final Point topLeftPoint,
                   final Point topRightPoint,
                   final Point downLeftPoint,
                   final Point downRightPoint) {
        this.topLeftPoint = topLeftPoint;
        this.topRightPoint = topRightPoint;
        this.downLeftPoint = downLeftPoint;
        this.downRightPoint = downRightPoint;
    }

    boolean isOverLay(final CharacterFrame other) {
        if (isPointInFrame(other.getTopLeftPoint())) {
            return true;
        }
        if (isPointInFrame(other.getTopRightPoint())) {
            return true;
        }
        if (isPointInFrame(other.getDownRightPoint())) {
            return true;
        }
        if (isPointInFrame(other.getDownLeftPoint())) {
            return true;
        }

        return false;
    }

    private boolean isPointInFrame(final Point otherPoint) {
        final int otherX = otherPoint.getCordX();
        final int otherY = otherPoint.getCordY();

        final int tlX = topLeftPoint.getCordX();
        final int tlY = topLeftPoint.getCordY();

        final int drX = downRightPoint.getCordX();
        final int drY = downRightPoint.getCordY();

        return otherX > tlX && otherX < drX && otherY > tlY && otherY < drY;
    }

    private Point getTopLeftPoint() {
        return topLeftPoint;
    }

    private Point getTopRightPoint() {
        return topRightPoint;
    }

    private Point getDownLeftPoint() {
        return downLeftPoint;
    }

    private Point getDownRightPoint() {
        return downRightPoint;
    }

}
