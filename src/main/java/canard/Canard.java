package canard;

public abstract class Canard {

    /** Nom du canard */
    protected String nom;

    /** Points de vie actuels du canard
     * (>= à 0, si == 0 le canard est KO) */
    protected int pv;

    /** Points de vie maximum du canard */
    protected int pvMax;

    /** Valeur d'attaque actuelle du canard (>= à 0) */
    protected int attaque;

    /** Valeur d'attaque par défaut du canard */
    protected int attaqueDefaut;

    /** Points de pouvoir pour l'attaque
     * (si == 0 le canard ne peut plus attaquer) */
    protected int ppAttaque;

    /** Points de pouvoir pour les capacités spéciales
     * (si == 0 le canard ne peut plus utiliser sa capacité spéciale)*/
    protected int ppCapacite;

    /** Vitesse actuelle du canard,
     * permet de déterminer quel canard agit en premier lors d'un combat */
    protected int vitesse;

    /** Vitesse par défaut du canard */
    protected int vitesseDefaut;

    /** Statut du canard (par défaut : AUCUN)*/
    protected Statut statut;

    /** Durée restante (en nombre de tours) du statut qui affecte le canard */
    protected int dureeStatut;

    /** Type du canard influençant les attaques en combat */
    protected TypeCanard type;

    public Canard(String nom, int pv, int attaque, int vitesse, TypeCanard type) {
        this.nom = nom;
        this.pv = pv;
        this.pvMax = pv;
        this.attaque = attaque;
        this.attaqueDefaut = attaque;
        this.vitesse = vitesse;
        this.vitesseDefaut = vitesse;
        this.ppAttaque = 15;
        this.ppCapacite = 5;
        this.statut = Statut.AUCUN;
        this.type = type;
    }

    public String getNom() {
        return nom;
    }

    public int getPv() {
        return pv;
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

    public void setDureeStatut(int duree) {
        this.dureeStatut = duree;
    }

    public TypeCanard getType() {
        return type;
    }

    /**
     * Vérifie si le canard a assez de point de pouvoir pour attaquer.
     * Si oui, calcul les dégâts du canard sur une cible en fonction
     * du type du canard attaquant et de la cible.
     * @param cible le canard cible
     * @return le nombre de dégâts fait par le canard (0 s'il n'a plus de points de pouvoir).
     */
    public int attaquer(Canard cible) {
        if (ppAttaque == 0) {
            System.out.println(nom + " n'a plus de point de pouvoir, il n'a pas pu attaquer");
            return 0;
        }
        ppAttaque--;
        return (int) (attaque * TypeCanard.getMultiplicateur(type, cible.getType()));
    }

    /**
     * Applique des dégâts aux points de vie du canard
     * @param degats les dégâts à infliger au canard
     */
    public void subirDegats(int degats) {
        pv -= degats;
        if (pv < 0) {
            pv = 0;
        }
    }

    /**
     * Vérifie si le canard est KO (si ses PV sont à 0)
     * @return true si le canard est KO, sinon false
     */
    public boolean estKo() {
        return pv == 0;
    }

    /**
     * Applique un effet de statut à un canard cible
     * @param cible le canard cible
     * @param statut le statut à appliquer
     */
    public void appliquerEffet(Canard cible, Statut statut) {
        cible.statut = statut;
        cible.dureeStatut = statut.duree;
    }

    /**
     * Méthode abstraite de la capacité spéciale du canard
     * @param cible le canard qui peut potentiellement être la cible de cette capacité
     */
    public abstract void capaciteSpeciale(Canard cible);

    /**
     * Réinitialise les attributs du canard pour les remettre par défaut (à la fin d'un combat)
     */
    public void reinitialisation() {
        this.pv = pvMax;
        this.attaque = attaqueDefaut;
        this.vitesse = vitesseDefaut;
        this.ppAttaque = 15;
        this.ppCapacite = 5;
        this.statut = Statut.AUCUN;
    }
}
