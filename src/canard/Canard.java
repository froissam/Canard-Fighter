package canard;

public abstract class Canard {

    protected String nom;

    protected int pv;

    protected int pvMax;

    protected int attaque;

    protected Statut statut;

    protected TypeCanard type;

    public String getNom() {
        return nom;
    }

    public int getPv() {
        return pv;
    }

    public int getPvMax() {
        return pvMax;
    }

    public int getAttaque() {
        return attaque;
    }

    public Statut getStatut() {
        return statut;
    }

    public TypeCanard getType() {
        return type;
    }

    public int attaquer(Canard canardEnnemi) {
        return (int) (attaque * TypeCanard.getMultiplicateur(type, canardEnnemi.getType()));
    }

    public void subirDegats(int degats) {
        pv -= degats;
        if (pv < 0) {
            pv = 0;
        }
    }

    public boolean estKo() {
        return pv == 0;
    }

    public abstract void CapaciteSpeciale();
}
