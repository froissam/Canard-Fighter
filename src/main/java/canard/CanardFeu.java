package canard;

public class CanardFeu extends Canard {

    /**
     * Constructeur d'un Canard de type feu
     * @param nom le nom du canard
     * @param pv les points de vie du canard
     * @param attaque l'attaque du canard
     * @param vitesse la vitesse du canard
     */
    public CanardFeu(String nom, int pv, int attaque, int vitesse) {
        super(nom, pv, attaque, vitesse, TypeCanard.FEU);
    }

//    /**
//     *  - Capacité de base -
//     * Si le canard a assez de points de pouvoirs de capacité,
//     * il attaque la cible avec une attaque qui fait 20 points de dégâts de plus
//     * @param cible le canard à attaquer
//     */
//    @Override
//    public void capaciteSpeciale(Canard cible) {
//        if (ppCapacite == 0) {
//            System.out.println(nom + " n'a plus de point de pouvoir, il n'a pas pu utiliser sa capacité spéciale");
//        } else {
//            System.out.println(nom + " lance une attaque surpuissante");
//            int degats = attaquer(cible) + 20;
//            cible.subirDegats(degats);
//            ppCapacite--;
//        }
//    }

    /**
     *  - Capacité pour tester le statut BRULURE -
     * Si le canard a assez de points de pouvoirs de capacité,
     * il applique le statut BRULURE à la cible (BRULURE : subit 10 points de dégâts par tours).
     * @param cible le canard auquel appliquer le statut BRULURE
     */
    @Override
    public void capaciteSpeciale(Canard cible) {
        if (ppCapacite == 0) {
            System.out.println(nom + " n'a plus de point de pouvoir, il n'a pas pu utiliser sa capacité spéciale");
        } else {
            appliquerEffet(cible, Statut.BRULURE);
            System.out.println(cible.getNom() + " est brulé");
            ppCapacite--;
        }
    }
}
