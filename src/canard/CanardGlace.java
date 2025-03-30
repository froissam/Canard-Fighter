package canard;

public class CanardGlace extends Canard {

    public CanardGlace(String nom, int pv, int attaque) {
        this.nom = nom;
        this.pv = pv;
        this.pvMax = pv;
        this.attaque = attaque;
        this.type = TypeCanard.GLACE;
    }

    @Override
    public void CapaciteSpeciale() {
        // TODO capacité spéciale glace
    }
}
