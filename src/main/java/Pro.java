/**
 * Classe main.
 */
public class Pro {

    /**
     * Execution du programme resolveur sudoku.
     */
    public static void main(final String[] args) {
        final int taille = 16;
        GrilleImpl tab = new GrilleImpl(taille);
        tab.initialisation();
        System.out.println("Sudoku début");
        tab.print2D();
        tab.solveur();
        if (tab.complete()) {
            System.out.println("Sudoku possible :");
            tab.print2D();
        } else {
            System.out.println("Sudoku impossible :");
            tab.print2D();
        }
    }
}