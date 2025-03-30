package canard;

public enum Statut {
    AUCUN(0),
    GEL(2),
    BRULURE(3),
    PARALYSIE(2);

    public final int duree;

    Statut(int duree) {
        this.duree = duree;
    }
}
