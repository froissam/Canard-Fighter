package canard;

public enum TypeCanard {
    EAU,
    FEU,
    GLACE,
    VENT,
    ELECTRIQUE;

    /**
     * Matrice des forces et des faiblesses des différents types de canard.
     * (0.5 : faible, 1.0 : normal, 1.5 : fort)
     */
    private final static double[][] forcesFaiblesse = new double[][] {
        {1.0, 1.5, 0.5, 0.5, 1.0}, // TYPE EAU
        {0.5, 1.0, 1.5, 1.0, 1.0}, // TYPE FEU
        {1.0, 0.5, 1.0, 1.5, 1.0}, // TYPE GLACE
        {1.5, 1.0, 0.5, 1.0, 0.5}, // TYPE VENT
        {1.5, 1.0, 1.0, 1.5, 1.0}, // TYPE ELECTRIQUE
    };

    /**
     * Récupère le multiplicateur dans la matrice des forces et faiblesse
     * en fonction des types des canards attaquant et cible
     * @param attaquant le type du canard attaquant
     * @param cible le type du canard cible
     * @return le multiplicateur correspondant (0.5, 1.0 ou 1.5)
     */
    public static double getMultiplicateur(TypeCanard attaquant, TypeCanard cible) {
        return forcesFaiblesse[attaquant.ordinal()][cible.ordinal()];
    }
}


