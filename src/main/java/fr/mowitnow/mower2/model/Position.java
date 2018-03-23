package fr.mowitnow.mower2.model;

public class Position {
    private Integer x;
    private Integer y;


    /****** actions *******/
    @Override
    public String toString() {
        return this.x + " " + this.y;
    }

    /****** Constructors ******/
    public Position(Integer x, Integer y) {
        this.x = x;
        this.y = y;
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
