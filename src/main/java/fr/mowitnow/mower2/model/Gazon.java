package fr.mowitnow.mower2.model;

public class Gazon {
    private Integer x;
    private Integer y;

    /****** actions *******/
    public boolean canMove(Tondeuse tondeuse, char action) {
        if (tondeuse == null || tondeuse.getPosition() == null) {
            return false;
        }

        if (ActionEnum.A == action) {
            Position position = tondeuse.getPosition();
            Character  orientation = position.getOrientation();
            switch (orientation) {
                case OrientationEnum.N:
                    return position.getY() + 1 <= this.y;
                case OrientationEnum.E:
                    return position.getX() + 1 <= this.x;
                case OrientationEnum.W:
                    return position.getX() - 1 >= 0;
                case OrientationEnum.S:
                    return position.getY() - 1 >= 0;
            }
        }
        return true;
    }

    /****** Constructors ******/
    public Gazon() {
    }

    public Gazon(Integer x, Integer y) {
        // check if value is valid before create gazon
        if (x >= 0) {
            this.x = x;
        }

        if (y >= 0) {
            this.y = y;
        }
    }

    /****** Getters and Setters ******/
    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }
}
