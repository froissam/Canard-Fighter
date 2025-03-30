package canard;

public class CanardEau extends Canard {

    public CanardEau(String nom, int pv, int attaque) {
        this.nom = nom;
        this.pv = pv;
        this.pvMax = pv;
        this.attaque = attaque;
        this.type = TypeCanard.EAU;
    }

    @Override
    public void CapaciteSpeciale() {
        // TODO capacité spéciale eau
    }
}
