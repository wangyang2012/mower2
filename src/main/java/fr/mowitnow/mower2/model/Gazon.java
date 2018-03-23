package fr.mowitnow.mower2.model;

public class Gazon {
    private Position position;

    /****** Constructors ******/
    public Gazon() {
    }

    public Gazon(Integer x, Integer y) {
        // check if value is valid before create gazon
        if (x >= 0 && y >= 0) {
            this.position = new Position(x, y);
        }
    }

    /****** actions *******/
    public boolean canMove(Tondeuse tondeuse, char action) {
        if (tondeuse == null || tondeuse.getPosition() == null) {
            return false;
        }

        if (ActionEnum.A == action) {
            Position position = tondeuse.getPosition();
            Character  orientation = tondeuse.getOrientation();
            switch (orientation) {
                case OrientationEnum.N:
                    return position.getY() + 1 <= this.position.getY();
                case OrientationEnum.E:
                    return position.getX() + 1 <= this.position.getX();
                case OrientationEnum.W:
                    return position.getX() - 1 >= 0;
                case OrientationEnum.S:
                    return position.getY() - 1 >= 0;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Gazon de " + position.getX() + "*" + position.getY();
    }

    /****** Getters and Setters ******/

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
