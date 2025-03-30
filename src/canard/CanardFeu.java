package canard;

public class CanardFeu extends Canard {

    public CanardFeu(String nom, int pv, int attaque, int vitesse) {
        this.nom = nom;
        this.pv = pv;
        this.pvMax = pv;
        this.attaque = attaque;
        this.vitesse = vitesse;
        this.ppAttaque = 15;
        this.ppCapacite = 5;
        this.statut = Statut.AUCUN;
        this.type = TypeCanard.FEU;
    }

    @Override
    public void capaciteSpeciale(Canard cible) {
        if (ppCapacite == 0) {
            System.out.println(nom + "n'a plus de point de pouvoir, il n'a pas pu utiliser sa capacité spéciale");
        } else {
            System.out.println(nom + " lance une attaque surpuissante");
            int degats = attaquer(cible) + 20;
            cible.subirDegats(degats);
            ppCapacite--;
        }
    }
}
