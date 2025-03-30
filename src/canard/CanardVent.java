package canard;

public class CanardVent extends Canard {

    public CanardVent(String nom, int pv, int attaque, int vitesse) {
        this.nom = nom;
        this.pv = pv;
        this.pvMax = pv;
        this.attaque = attaque;
        this.vitesse = vitesse;
        this.ppAttaque = 15;
        this.ppCapacite = 5;
        this.statut = Statut.AUCUN;
        this.type = TypeCanard.VENT;
    }

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
