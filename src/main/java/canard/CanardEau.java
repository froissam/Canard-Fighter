package canard;

public class CanardEau extends Canard {

    /**
     * Constructeur d'un Canard de type eau
     * @param nom le nom du canard
     * @param pv les points de vie du canard
     * @param attaque l'attaque du canard
     * @param vitesse la vitesse du canard
     */
    public CanardEau(String nom, int pv, int attaque, int vitesse) {
        super(nom, pv, attaque, vitesse, TypeCanard.EAU);
    }

    /**
     * Si le canard a assez de points de pouvoirs de capacité,
     * il se régénère 20 points de vie (avec un maximum de points de vie égal à pvMax).
     * @param cible (inutile ici).
     */
    @Override
    public void capaciteSpeciale(Canard cible) {
        if (ppCapacite == 0) {
            System.out.println(nom + " n'a plus de point de pouvoir, il n'a pas pu utiliser sa capacité spéciale");
        } else {
            pv += 20;
            if (pv > pvMax) {
                pv = pvMax;
            }
            System.out.println(nom + " s'est soigné");
            ppCapacite--;
        }
    }
}
