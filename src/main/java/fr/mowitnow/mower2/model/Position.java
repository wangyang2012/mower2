package fr.mowitnow.mower2.model;

public class Position {
    private Integer x;
    private Integer y;
    private Character  orientation;

    /****** actions *******/
    @Override
    public String toString() {
        return this.x + " " + this.y + " " + this.orientation;
    }

    /****** Constructors ******/
    public Position(Integer x, Integer y, Character  orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
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

    public Character  getOrientation() {
        return orientation;
    }

    public void setOrientation(Character  orientation) {
        this.orientation = orientation;
    }
}
