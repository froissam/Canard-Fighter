import canard.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CanardTest {

    private CanardEau canardEau;
    private CanardFeu canardFeu;
    private CanardGlace canardGlace;
    private CanardVent canardVent;

    @BeforeEach
    void setUp() {
        canardEau = new CanardEau("CanardoTest", 100, 20, 10);
        canardFeu = new CanardFeu("ConfiTest", 90, 25, 12);
        canardGlace = new CanardGlace("Glaglanard", 80, 22, 8);
        canardVent = new CanardVent("Tornard", 80, 20, 10);
    }

    @Test
    void attaquerFaible() {
        int degats = canardFeu.attaquer(canardEau);
        assertEquals(12, degats);
    }

    @Test
    void attaquerNormal() {
        int degats = canardFeu.attaquer(canardVent);
        assertEquals(25, degats);
    }

    @Test
    void attaquerFort() {
        int degats = canardFeu.attaquer(canardGlace);
        assertEquals(37, degats);
    }

    @Test
    void subirDegats() {
        canardEau.subirDegats(30);
        assertEquals(70, canardEau.getPv());
    }

    @Test
    void estKOTrue() {
        canardFeu.subirDegats(90);
        assertTrue(canardFeu.estKo());
    }

    @Test
    void estKOFalse() {
        canardGlace.subirDegats(79);
        assertFalse(canardGlace.estKo());
    }

    @Test
    void appliquerEffet() {
        canardGlace.appliquerEffet(canardFeu, Statut.GEL);
        assertEquals(Statut.GEL, canardFeu.getStatut());
        assertEquals(2, canardFeu.getDureeStatut());
    }

    @Test
    void reinitialisation() {
        canardEau.subirDegats(50);
        canardEau.appliquerEffet(canardEau, Statut.BRULURE);
        canardEau.reinitialisation();

        assertEquals(100, canardEau.getPv());
        assertEquals(15, canardEau.getPpAttaque());
        assertEquals(5, canardEau.getPpCapacite());
        assertEquals(Statut.AUCUN, canardEau.getStatut());
    }
}
