package canard;

public class CanardGlace extends Canard {

    /**
     * Constructeur d'un Canard de type glace
     * @param nom le nom du canard
     * @param pv les points de vie du canard
     * @param attaque l'attaque du canard
     * @param vitesse la vitesse du canard
     */
    public CanardGlace(String nom, int pv, int attaque, int vitesse) {
        super(nom, pv, attaque, vitesse, TypeCanard.GLACE);
    }

    /**
     * Si le canard a assez de points de pouvoirs de capacité,
     * il applique le statut GEL à la cible (GEL : ne peut pas faire d'action pendant 2 tours).
     * @param cible le canard auquel appliquer le statut GEL
     */
    @Override
    public void capaciteSpeciale(Canard cible) {
        if (ppCapacite == 0) {
            System.out.println(nom + " n'a plus de point de pouvoir, il n'a pas pu utiliser sa capacité spéciale");
        } else {
            appliquerEffet(cible, Statut.GEL);
            System.out.println(cible.getNom() + " est gelé");
            ppCapacite--;
        }
    }
}
