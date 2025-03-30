package canard;

public class CanardFeu extends Canard {

    public CanardFeu(String nom, int pv, int attaque) {
        this.nom = nom;
        this.pv = pv;
        this.pvMax = pv;
        this.attaque = attaque;
        this.type = TypeCanard.FEU;
    }

    @Override
    public void CapaciteSpeciale() {
        // TODO capacité spéciale feu
    }
}
