import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;


/**
 * Test parametrage de la grille.
 */
class GrilleImplTest {

    /**
     * Test sur le depassement des bornes
     */
    @Test
    public void testCheckBornes() {
        GrilleImpl test = new GrilleImpl(9);
	    for (int i = 0; i < 9; i++){
	    for (int j = 0; j < 9; j++){
		test.checkBornes(i, j);
	    }
	}

    assertThrows(IllegalArgumentException.class, () -> test.checkBornes(-1, 3), "-1 3");
	assertThrows(IllegalArgumentException.class, () -> test.checkBornes(1, -3), "1 -3");
	assertThrows(IllegalArgumentException.class, () -> test.checkBornes(9, 3), "9 3");
	assertThrows(IllegalArgumentException.class, () -> test.checkBornes(3, 9), "3 9");
    }

    /**
     * Test la recupération des valeurs de la grille 9x9
     */
    @Test
    public void getValue9x9() {
        GrilleImpl test = new GrilleImpl(9);
        test.initialisation();
        assertEquals('@', test.getValue(8, 5));
    }

    /**
     * Test si les valeurs sont recupérables
     */
    @Test
    public void setValue9x9() {
        GrilleImpl test = new GrilleImpl(9);
        test.setValue(8, 5, '4');
        assertEquals('4', test.getValue(8, 5));
    }

    /**
     * Test si tableau d'essai bon
     */
    @Test
    public void possible9x9() {
        GrilleImpl test = new GrilleImpl(9);
        test.setValue(1, 0, '1');
        test.setValue(2, 0, '3');
        test.setValue(3, 0, '8');
        test.setValue(4, 0, '6');
        test.setValue(5, 0, '2');
        test.setValue(6, 0, '7');
        test.setValue(7, 0, '9');
        test.setValue(8, 0, '5');

        test.setValue(0, 1, '7');
        test.setValue(0, 2, '5');
        test.setValue(0, 3, '8');
        test.setValue(0, 4, '6');
        test.setValue(0, 5, '3');
        test.setValue(0, 6, '2');
        test.setValue(0, 7, '9');
        test.setValue(0, 8, '1');

        assertEquals(false, test.possible(0, 0, '5'));
        assertEquals(true, test.possible(0, 0, '4'));
        assertEquals(true, test.possible(0, 0, '4'));
        assertThrows(IllegalArgumentException.class, () -> test.checkPossibles('n'), "n");
        assertThrows(IllegalArgumentException.class, () -> test.checkPossibles('a'), "n");


    }

    /**
     * Test la recupération des dimensions de la grille 9x9
     */
    @Test
    public void getDimension9x9() {
        GrilleImpl test = new GrilleImpl(9);
        assertEquals(9, test.getDimension());
    }

    /**
     * Test si la grille 9x9 est complete
     */
    @Test
    public void complete9x9() {
        GrilleImpl test = new GrilleImpl(9);
        test.initialisation();
        assertEquals(false, test.complete());
    }

    /**
     * Test si l'implementation de la grille 9x9 est fonctionnelle
     */
    @Test
    public void grilleImpl9x9() {
        GrilleImpl test = new GrilleImpl(9);
        assertEquals(9, test.getDimension());
        assertFalse(Arrays.asList(test).isEmpty());
    }

    /**
     * Test la recupération des valeurs de la grille 9x9
     */
    @Test
    public void getValue16x16() {
        GrilleImpl test = new GrilleImpl(16);
        test.initialisation();
        assertEquals('@', test.getValue(12, 10));
    }

    /**
     * Test si les valeurs sont recupérables
     */
    @Test
    public void setValue16x16() {
        GrilleImpl test = new GrilleImpl(16);
        test.initialisation();
        assertEquals('@', test.getValue(12, 10));
        test.setValue(9, 5, '7');
        assertEquals('7', test.getValue(9, 5));
    }

    /**
     * Test si les positions sont valides
     */
    @Test
    public void possible16x16() {
        GrilleImpl test = new GrilleImpl(16);
        test.setValue(0, 0, 'e');
        test.setValue(1, 0, '8');
        test.setValue(2, 0, 'a');
        test.setValue(3, 0, 'b');
        test.setValue(4, 0, '0');
        test.setValue(5, 0, '1');
        test.setValue(6, 0, '2');
        test.setValue(7, 0, '5');
        test.setValue(8, 0, '4');
        test.setValue(9, 0, 'f');
        test.setValue(10, 0, '3');
        test.setValue(11, 0, '6');
        test.setValue(12, 0, 'd');
        test.setValue(13, 0, '7');
        test.setValue(14, 0, 'c');
        test.setValue(15, 0, '9');

        test.setValue(0, 1, '7');
        test.setValue(0, 2, '5');
        test.setValue(0, 3, '2');
        test.setValue(0, 4, 'f');
        test.setValue(0, 5, '8');
        test.setValue(0, 6, 'a');
        test.setValue(0, 7, 'b');
        test.setValue(0, 8, 'd');
        test.setValue(0, 9, '1');
        test.setValue(0, 10, '3');
        test.setValue(0, 11, '0');
        test.setValue(0, 12, 'c');
        test.setValue(0, 13, '4');
        test.setValue(0, 14, '9');
        test.setValue(0, 15, '6');

        assertEquals(false, test.possible(0, 0, '5'));
        assertEquals(false, test.possible(0, 0, '0'));
        assertEquals(false, test.possible(1, 1, 'e'));
        assertEquals(true, test.checkZone(0,0,'e',4));

        assertThrows(IllegalArgumentException.class, () -> test.checkPossibles('n'), "n");
    }

    /**
     * Test la recupération des dimensions de la grille 16x16
     */
    @Test
    public void getDimension16x16() {
        GrilleImpl test = new GrilleImpl(16);
        assertEquals(16, test.getDimension());
    }

    /**
     * Test si la grille 16x16 est complete
     */
    @Test
    public void complete16x16() {
        GrilleImpl test = new GrilleImpl(16);
        test.initialisation();
        assertEquals(false, test.complete());
    }

    /**
     * Test si l'implementation de la grille 16x16 est fonctionnelle
     */
    @Test
    public void grilleImpl16x16() {
        GrilleImpl test = new GrilleImpl(16);
        assertEquals(16, test.getDimension());
        test.initialisation();
        assertFalse(Arrays.asList(test).isEmpty());
    }
    @Test
    public void solveur9x9() {
        GrilleImpl test = new GrilleImpl(9);
        assertEquals(9, test.getDimension());
        test.initialisation();
        assertEquals(false, test.solveur());
    }

    @Test
    public void solveur16x16() {
        GrilleImpl test = new GrilleImpl(16);
        assertEquals(16, test.getDimension());
        test.initialisation();
        assertEquals(false, test.solveur());
    }

    @Test
    public void checkZone9x9() {
        GrilleImpl test = new GrilleImpl(9);
        assertEquals(9, test.getDimension());
        test.setValue(0, 0, '1');
        assertEquals(true, test.checkZone(0,0,'1',3));
        assertEquals(false, test.checkZone(0,0,'2',3));
    }

    @Test
    public void checkZone16x16() {
        GrilleImpl test = new GrilleImpl(16);
        assertEquals(16, test.getDimension());
        test.setValue(0, 0, '1');
        assertEquals(true, test.checkZone(0,0,'1',4));
        assertEquals(false, test.checkZone(0,0,'2',4));
    }
}
