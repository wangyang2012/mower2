package fr.mowitnow.mower2.model;

public class Tondeuse {
    private String nom;
    private Position position;
    private Character  orientation;
    private char[] actions;

    /****** Constructors ******/
    public Tondeuse(String nom, Integer x, Integer y, char orientation, char[] actions) {
        this.nom = nom;
        this.position = new Position(x, y);
        this.orientation = orientation;
        this.actions = actions;
    }

    /****** actions *******/
    public void moveNow(char action) {
    }

    public void printPosition() {
        System.out.println("****** " + this.nom + " ******");
        System.out.println(this.position.toString());
    }

    /****** Getters and Setters ******/

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Character getOrientation() {
        return orientation;
    }

    public void setOrientation(Character orientation) {
        this.orientation = orientation;
    }

    public char[] getActions() {
        return actions;
    }

    public void setActions(char[] actions) {
        this.actions = actions;
    }
}
