package fr.mowitnow.mower2.model;

import org.apache.log4j.Logger;

public class Tondeuse {
    public static final Logger logger = Logger.getLogger(Travail.class);
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
    public void bouger(char action) {
        switch (action) {
            case ActionEnum.D:
                if (this.orientation.equals(OrientationEnum.E)) {
                    this.orientation = OrientationEnum.S;
                } else if (this.orientation.equals(OrientationEnum.N)) {
                    this.orientation = OrientationEnum.E;
                } else if (this.orientation.equals(OrientationEnum.S)) {
                    this.orientation = OrientationEnum.W;
                } else if (this.orientation.equals(OrientationEnum.W)) {
                    this.orientation = OrientationEnum.N;
                }
                break;
            case ActionEnum.G:
                if (this.orientation.equals(OrientationEnum.E)) {
                    this.orientation = OrientationEnum.N;
                } else if (this.orientation.equals(OrientationEnum.N)) {
                    this.orientation = OrientationEnum.W;
                } else if (this.orientation.equals(OrientationEnum.S)) {
                    this.orientation = OrientationEnum.E;
                } else if (this.orientation.equals(OrientationEnum.W)) {
                    this.orientation = OrientationEnum.S;
                }
                break;
            case ActionEnum.A:
                if (this.orientation.equals(OrientationEnum.E)) {
                    this.position.setX(this.position.getX() + 1);
                } else if (this.orientation.equals(OrientationEnum.N)) {
                    this.position.setY(this.position.getY() + 1);
                } else if (this.orientation.equals(OrientationEnum.S)) {
                    this.position.setY(this.position.getY() - 1);
                } else if (this.orientation.equals(OrientationEnum.W)) {
                    this.position.setX(this.position.getX() - 1);
                }
                break;
            default:
                logger.debug("Action inconnue: " + action);
        }
        logger.debug(this);
    }

    public void printPosition() {
        logger.info(this);
    }

    @Override
    public String toString() {
        return this.nom + ": " + this.position + " " + this.orientation;
    }

    public Position calculProchainePosition(char action) {

        // Si tourner à gauche ou à droite, retourner la position actuelle
        if (ActionEnum.A != action) {
            return this.position;
        }

        Position newPosition = new Position(this.position);
        switch (this.orientation) {
            case OrientationEnum.E:
                newPosition.setX(this.position.getX() + 1);
                break;
            case OrientationEnum.N:
                newPosition.setY(this.position.getY() + 1);
                break;
            case OrientationEnum.S:
                newPosition.setY(this.position.getY() - 1);
                break;
            case OrientationEnum.W:
                newPosition.setX(this.position.getX() - 1);
                break;
            default:
                return newPosition;
        }
        return newPosition;
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
