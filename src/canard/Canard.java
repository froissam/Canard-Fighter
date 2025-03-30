package canard;

public abstract class Canard {

    protected String nom;

    protected int pv;

    protected int pvMax;

    protected int attaque;

    protected int attaqueDefaut;

    protected int ppAttaque;

    protected int ppCapacite;

    protected int vitesse;

    protected int vitesseDefaut;

    protected Statut statut;

    protected int dureeStatut;

    protected TypeCanard type;

    public String getNom() {
        return nom;
    }

    public int getPv() {
        return pv;
    }

    public int getAttaque() {
        return attaque;
    }

    public int getPpAttaque() {
        return ppAttaque;
    }

    public int getPpCapacite() {
        return ppCapacite;
    }

    public int getVitesse() {
        return vitesse;
    }

    public int getDureeStatut() {
        return dureeStatut;
    }

    public Statut getStatut() {
        return statut;
    }

    public TypeCanard getType() {
        return type;
    }

    public int attaquer(Canard cible) {
        if (ppAttaque == 0) {
            System.out.println(nom + " n'a plus de point de pouvoir, il n'a pas pu attaquer");
            return 0;
        }
        ppAttaque--;
        return (int) (attaque * TypeCanard.getMultiplicateur(type, cible.getType()));
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

    public void appliquerEffet(Canard cible, Statut statut) {
        cible.statut = statut;
        cible.dureeStatut = statut.duree;
    }

    public abstract void capaciteSpeciale(Canard cible);

    public void setDureeStatut(int duree) {
        this.dureeStatut = duree;
    }

    public void reinitialisation() {
        this.pv = pvMax;
        this.attaque = attaqueDefaut;
        this.vitesse = vitesseDefaut;
        this.ppAttaque = 15;
        this.ppCapacite = 5;
        this.statut = Statut.AUCUN;
    }
}
