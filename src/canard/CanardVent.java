package canard;

public class CanardVent extends Canard {

    public CanardVent(String nom, int pv, int attaque) {
        this.nom = nom;
        this.pv = pv;
        this.pvMax = pv;
        this.attaque = attaque;
        this.type = TypeCanard.VENT;
    }

    @Override
    public void CapaciteSpeciale() {
        // TODO capacité spéciale vent
    }
}
