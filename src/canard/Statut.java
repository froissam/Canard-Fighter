package canard;

public enum Statut {
    AUCUN(0),
    GEL(2),
    BRULE(3),
    PARALISE(2);

    public int duree;

    Statut(int duree) {
        this.duree = duree;
    }
}
