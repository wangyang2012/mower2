package fr.mowitnow.mower2.model;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Travail {

    public static final Logger logger = Logger.getLogger(Travail.class);

    private Gazon gazon;
    private List<Tondeuse> tondeuses;
    public static final boolean COLLISION_DETECTION = false; // Si true, les tondeuses ne peuvent pas se superposer

    /****** Constructors ******/
    public Travail() {
        this.gazon = null;
        this.tondeuses = new ArrayList<>();
    }

    /****** actions *******/
    public void lancer(List<String> entrees) {
        try {
            this.init(entrees);
            this.roulerTondeuses();
            logger.info("Travail est terminé avec succès");
            this.printResult();
        } catch (BusinessException e) {
            logger.error("Erreur: " + e.getMessage());
        }
    }

    /**
     * Création du gazon et des tondeuses
     * @param entrees
     * @throws BusinessException
     */
    private void init(List<String> entrees) throws BusinessException {
        logger.info("*************** Mower 2 ***************");
        if (entrees == null || entrees.isEmpty()) {
            throw new BusinessException("Le flux d'entrée est vide");
        }
        initGazon(entrees.get(0));
        initTondeuses(entrees.subList(1, entrees.size()));
    }

    /**
     * Création du gazon
     * @param line
     * @throws BusinessException
     */
    private void initGazon(String line) throws BusinessException {
        String[] coordinates = line.split(" ");
        if (coordinates == null || coordinates.length != 2) {
            throw new BusinessException("Le format de la ligne de gazon est erroné.");
        }
        Integer x = Integer.valueOf(coordinates[0]);
        Integer y = Integer.valueOf(coordinates[1]);
        this.gazon = new Gazon(x, y);
        logger.info("Le gazon est correctement initialisé: " + gazon);
    }

    /**
     * Création des tondeuses
     *
     * @param lignes: Chaque tondeuse a deux lignes, la première ligne décrit sa position initiale, la deuxième ligne décrit son déroulement
     */
    private void initTondeuses(List<String> lignes) throws BusinessException {
        if (lignes == null || lignes.isEmpty()) {
            throw new BusinessException("Il n'y a pas de tondeuse sur le gazon.");
        }

        if (lignes.size() % 2 != 0) {
            throw new BusinessException("Le nombre des lignes de tondeuse n'est pas paire.");
        }

        // parcourir chaque 2 lignes
        for (int i = 0; i < lignes.size(); i += 2) {
            int numberTondeuse = this.tondeuses.size() + 1;
            try {
                String ligneUne = lignes.get(i);
                String[] positions = ligneUne.split(" ");
                Integer x = Integer.valueOf(positions[0]);
                Integer y = Integer.valueOf(positions[1]);
                char orientation = positions[2].charAt(0);
                String ligneDeux = lignes.get(i + 1);
                Tondeuse tondeuse = new Tondeuse("Tondeuse" + numberTondeuse, x, y, orientation, ligneDeux.toCharArray());
                this.tondeuses.add(tondeuse);
                logger.debug("Nouvelle tondeuse: " + tondeuse);
            } catch (Exception e) {
                throw new BusinessException("Impossible de créer la tondeuse N°" + numberTondeuse);
            }
            logger.info("La tondeuse " + numberTondeuse + " est créée correctement");
        }
    }

    /**
     * Dérouler les actions de chaque tondeuse
     * @throws BusinessException
     */
    private void roulerTondeuses() {
        if (this.gazon == null || this.tondeuses == null || this.tondeuses.isEmpty()) {
            return;
        }

        for (Tondeuse tondeuse : this.tondeuses) {
            // verifier position actuelle de la tondeuse par rapport au gazon
            if (isPositionLegalle(tondeuse.getPosition())) {
                roulerTondeuse(tondeuse);
            } else {
                logger.debug("La tondeuse " + tondeuse.getNom() + " n'est pas dans le gazon!");
            }
        }
    }

    /**
     * Vérifier si la position en paramètre est dans le gazon
     *
     * @param position
     * @return
     */
    private boolean isPositionLegalle(Position position) {
        if (position == null || this.gazon == null || this.gazon.getPosition() == null) {
            return false;
        }

        // Détection de collision
        if (COLLISION_DETECTION) {
            int countPosition = 0;
            for (Tondeuse tondeuse : tondeuses) {
                if (position.equals(tondeuse.getPosition())) {
                    countPosition++;
                    if (countPosition > 1) {
                        return false;
                    }
                }
            }
        }

        // Vérifier si la position ne dépasse pas le gazon
        return position.getX() <= this.gazon.getPosition().getX() && position.getY() <= this.gazon.getPosition().getY();
    }

    /**
     * Dérouler toutes les actions de la tondeuse
     * @param tondeuse
     */
    private void roulerTondeuse(Tondeuse tondeuse) {
        for (char action : tondeuse.getActions()) {
            if (ActionEnum.A == action) {
                // Si l'action est avancer, vérifier que la tondeuse ne dépasse pas le gazon
                Position prochainePosition = tondeuse.calculProchainePosition(action);
                if (!isPositionLegalle(prochainePosition)) {
                    continue;
                }
            }
            tondeuse.bouger(action);
        }
    }

    /**
     * Afficher le résultat
     * @throws BusinessException
     */
    private void printResult() {
        for (Tondeuse tondeuse : this.tondeuses) {
            tondeuse.printPosition();
        }
    }


    /****** Getters and Setters ******/
    public Gazon getGazon() {
        return gazon;
    }

    public void setGazon(Gazon gazon) {
        this.gazon = gazon;
    }

    public List<Tondeuse> getTondeuses() {
        return tondeuses;
    }

    public void setTondeuses(List<Tondeuse> tondeuses) {
        this.tondeuses = tondeuses;
    }
}
