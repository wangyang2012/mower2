package fr.mowitnow.mower2.model;

import fr.mowitnow.mower2.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

// TODO: make in Singleton
// TODO: utiliser Log4j
public class Travail {
    private Gazon gazon; // Singleton => Il n'y a qu'un gazon par travail
    private List<Tondeuse> tondeuses;

    /****** Constructors ******/
    public Travail() {
        this.gazon = null;
        this.tondeuses = new ArrayList<>();
    }

    /****** actions *******/
    public void lancer(List<String> entrees) {
        try {
            this.init(entrees);
        } catch (BusinessException e) {
            System.out.print("Erreur: " + e.getMessage());
        }

    }

    private void init(List<String> entrees) throws BusinessException {
        if (entrees == null || entrees.isEmpty()) {
            throw new BusinessException("Le flux d'entrée est vide");
        }
        initGazon(entrees.get(0));
        initTondeuses(entrees.subList(1, entrees.size()-1));

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
            } catch (Exception e) {
                throw new BusinessException("Impossible de créer la tondeuse N°" + numberTondeuse);
            }
            System.out.println("La tondeuse " + numberTondeuse + " est créée correctement");
        }
    }

    private void initGazon(String line) throws BusinessException {
        String[] coordinates = line.split(" ");
        if (coordinates == null || coordinates.length != 2) {
            throw new BusinessException("Le format de la ligne de gazon est erroné.");
        }
        Integer x = Integer.valueOf(coordinates[0]);
        Integer y = Integer.valueOf(coordinates[1]);
        this.gazon = new Gazon(x, y);
        System.out.println("Le gazon est correctement initialisé: " + gazon);
    }

    private void roulerTondeuses() throws BusinessException {
        // TODO détection collision?


    }

    private void printResult() throws BusinessException {

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
