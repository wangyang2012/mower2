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

    /**
     * Comparaison pour les tests unitaires
     *
     * @param other
     * @return
     */
    @Override
    public boolean equals(Object other)
    {
        if (other == null) {
            return false;
        }

        if (!(other instanceof Position)) {
            return false;
        }

        Position o = (Position) other;


        if (x == null) {
            if (o.getX() != null) {
                return false;
            }
        } else {
            if (!x.equals(o.getX())) {
                return false;
            }
        }

        if (y == null) {
            if (o.getY() != null) {
                return false;
            } else {
                return true;
            }
        } else {
            return y.equals(o.getY());
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
