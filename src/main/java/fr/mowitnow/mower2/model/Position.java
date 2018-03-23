package fr.mowitnow.mower2.model;

public class Position {
    private Integer x;
    private Integer y;

    /****** Constructors ******/
    public Position(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Position(Position position) {
        this.x = position.getX();
        this.y = position.getY();
    }

    /****** actions *******/
    @Override
    public String toString() {
        return this.x + " " + this.y;
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
