package fr.mowitnow.mower2.model;

public class Tondeuse {
    private String nom;
    private Position position;
    private char[] actions;

    /****** actions *******/
    public void moveNow(char action) {
    }

    public void printPosition() {
        System.out.println("****** " + this.nom + " ******");
        System.out.println(this.position.toString());
    }


    /****** Constructors ******/
    public Tondeuse(String nom, Integer x, Integer y, char orientation, char[] actions) {
        this.nom = nom;
        this.position = new Position(x, y, orientation);
        this.actions = actions;
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
}
