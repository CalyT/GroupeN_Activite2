public class prog {
    public static void main(String[] args) {
        GrilleImpl test = new GrilleImpl(9);
        test.initialisation();
        System.out.println("Sudoku initialisé");
        test.print2D();
        test.solveur();
        if (test.complete()) {
            System.out.println("Sudoku possible :");
            test.print2D();
        } else {
            System.out.println("Sudoku impossible :");
            test.print2D();
        }
    }
}
