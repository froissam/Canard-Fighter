package canard;

public class CanardElectrique extends Canard {

    /**
     * Constructeur d'un Canard de type électrique
     * @param nom le nom du canard
     * @param pv les points de vie du canard
     * @param attaque l'attaque du canard
     * @param vitesse la vitesse du canard
     */
    public CanardElectrique(String nom, int pv, int attaque, int vitesse) {
        super(nom, pv, attaque, vitesse, TypeCanard.ELECTRIQUE);
    }

    /**
     * Si le canard a assez de points de pouvoirs de capacité,
     * il applique le statut PARALYSIE à la cible (PARALYSIE : 50% de chances d'attaquer).
     * @param cible le canard auquel appliquer le statut PARALYSIE
     */
    @Override
    public void capaciteSpeciale(Canard cible) {
        if (ppCapacite == 0) {
            System.out.println(nom + " n'a plus de point de pouvoir, il n'a pas pu utiliser sa capacité spéciale");
        } else {
            appliquerEffet(cible, Statut.PARALYSIE);
            System.out.println(cible.getNom() + " est paralysé");
            ppCapacite--;
        }
    }
}
