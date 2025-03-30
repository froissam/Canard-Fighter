package canard;

public enum TypeCanard {
    EAU,
    FEU,
    GLACE,
    VENT;

    private final static double[][] forcesFaiblesse = new double[][] {
        {1.0, 1.5, 0.5, 0.5}, // TYPE EAU
        {0.5, 1.0, 1.5, 1.0}, // TYPE FEU
        {1.0, 0.5, 1.0, 1.5}, // TYPE GLACE
        {1.5, 1.0, 0.5, 1.0}, // TYPE VENT
    };

    public static double getMultiplicateur(TypeCanard attaquant, TypeCanard cible) {
        return forcesFaiblesse[attaquant.ordinal()][cible.ordinal()];
    }
}


