package canard;

public class CanardVent extends Canard {

    /**
     * Constructeur d'un Canard de type vent
     * @param nom le nom du canard
     * @param pv les points de vie du canard
     * @param attaque l'attaque du canard
     * @param vitesse la vitesse du canard
     */
    public CanardVent(String nom, int pv, int attaque, int vitesse) {
        super(nom, pv, attaque, vitesse, TypeCanard.VENT);
    }

    /**
     * Si le canard a assez de points de pouvoirs de capacité,
     * il augmente sa propre vitesse de 20 points
     * @param cible (inutile ici)
     */
    @Override
    public void capaciteSpeciale(Canard cible) {
        if (ppCapacite == 0) {
            System.out.println(nom + " n'a plus de point de pouvoir, il n'a pas pu utiliser sa capacité spéciale");
        } else {
            vitesse += 20;
            System.out.println("La vitesse de " + nom + " augmente");
            ppCapacite--;
        }
    }
}
