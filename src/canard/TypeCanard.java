package canard;

public enum TypeCanard {
    EAU,
    FEU,
    GLACE,
    VENT,
    ELECTRIQUE;

    private final static double[][] forcesFaiblesse = new double[][] {
        {1.0, 1.5, 0.5, 0.5, 1.0}, // TYPE EAU
        {0.5, 1.0, 1.5, 1.0, 1.0}, // TYPE FEU
        {1.0, 0.5, 1.0, 1.5, 1.0}, // TYPE GLACE
        {1.5, 1.0, 0.5, 1.0, 0.5}, // TYPE VENT
        {1.5, 1.0, 1.0, 1.5, 1.0}, // TYPE ELECTRIQUE
    };

    public static double getMultiplicateur(TypeCanard attaquant, TypeCanard cible) {
        return forcesFaiblesse[attaquant.ordinal()][cible.ordinal()];
    }
}


