package fr.mowitnow.mower2.model;

import java.util.List;

// TODO: make in Singleton
public class Jeu {
    private Gazon gazon; // Singleton => Il n'y a qu'un gazon par jeu
    private List<Tondeuse> tondeuses;

    public void lancer(String entrees) {
        try {
            this.init(entrees);
        } catch (BusinessException e) {
            System.out.print("Erreur: " + e.getMessage());
        }

    }

    private void init(String entrees) throws BusinessException {
        // TODO: créer Gazons et Tondeuses
    }

    private void roulerTondeuses() throws BusinessException {

        // TODO détection collision?

    }

    private void printResult() throws BusinessException {

    }
}
